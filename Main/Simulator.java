package Main;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import Services.BoundariesService;
import Services.CollisionService;
import Services.DragService;
import Services.GravityService;
import Services.ParticlesService;
import Services.SeparatorService;
import Structures.Grid;
import Structures.Particle;
import Tools.ParticleDrawer;

public class Simulator {
    final int SUBSTEPS = 1; // for some reason increasing this makes particle separation worse at a high particle count
    final int FRAMERATE = 0; // target fps (0 for unlimited)
    final int WORKERTHREADS = 8; // how many threads the programs uses to update particles (ideally, use the number of cores your cpu has)

    ParticlesService particlesService;

    volatile AtomicInteger workingThreads = new AtomicInteger(0);

    Grid grid;
    Boolean running;
    ParticleDrawer drawer;
    int limitX;
    int limitY;
    int minRadius;
    int maxRadius;
    int frameCount;
    long lastFrameShowed;

    public Simulator(int limitX, int limitY, int minRadius, int maxRadius) {
        this.particlesService = new ParticlesService();
        this.running = false;
        this.drawer = new ParticleDrawer(particlesService.getParticles());
        this.limitX = limitX;
        this.limitY = limitY;
        this.frameCount = 0;
        this.lastFrameShowed = 0;
        this.minRadius = minRadius;
        this.maxRadius = maxRadius;

        int resolution = (int) Math.floor(Math.min(limitX, limitY) / maxRadius); //maximum resolution possible without weird behaviours
        System.out.println("Running simulation on a grid of resolution " + resolution);
        this.grid = new Grid(limitX, limitY, resolution);
    }

    @SuppressWarnings("unused")
    public void waitForFrame() {
        if (FRAMERATE > 0) {
            try {
                Thread.sleep(1000/FRAMERATE); // Sleep for a short period to control the update rate
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void run() {
        this.running = true;

        long lastTick = System.currentTimeMillis();

        while (running) {
            long now = System.currentTimeMillis();

            update((double) (now - lastTick)/100);
            drawer.repaint(); // Updates the drawing

            waitForFrame();

            lastTick = now;
        }
    }

    public void stop() {
        this.running = false;
    }

    public void updateParticlePosition(Particle p, double deltaTime) {
        ArrayList<Particle> neighbours = grid.getNeighbours(p);

        for (int i = 0; i < SUBSTEPS; i++){
            SeparatorService.calculateSeparations(p, neighbours);
            BoundariesService.calculateBoundaries(p, limitX, limitY);
        }

        p.position = p.position.add(p.velocity.mult(deltaTime)); //makes the particles actually change their positions
    }

    public void updateParticleVelocity(Particle p, double deltaTime) {
        GravityService.applyGravity(p, deltaTime);
            
        ArrayList<Particle> neighbours = grid.getNeighbours(p);

        CollisionService.calculateCollisions(p, neighbours);
        DragService.applyDrag(p, deltaTime);
    }

    // Updates the velocity and position of all particles, according to how much time has passed since the last update (deltaTime)
    public void update(double deltaTime) {
        handleFps(); //prints the fps on the console

        particlesService.summonParticleIfNeeded(); //tries to spawn particle in queue

        ArrayList<Particle> particles = particlesService.getParticles();        

        grid.clear(); // remakes grid
        for (Particle p : particles) {
            grid.insert(p);
        }

        for (int i = 0; i < WORKERTHREADS; i++) {
            final int threadId = i;
            workingThreads.incrementAndGet();
            Thread thread = new Thread(null, () -> {
                for (int j = threadId; j < particles.size(); j += WORKERTHREADS) {
                    updateParticleVelocity(particles.get(j), deltaTime);
                }
                workingThreads.decrementAndGet();
            }, "update particle velocity " + i);

            thread.start();
        }

        do {} while (workingThreads.get() > 0); //waits for all threads to finish

        for (int i = 0; i < WORKERTHREADS; i++) {
            final int threadId = i;
            workingThreads.incrementAndGet();
            Thread thread = new Thread(null, () -> {
                for (int j = threadId; j < particles.size(); j += WORKERTHREADS) {
                    updateParticlePosition(particles.get(j), deltaTime);
                }
                workingThreads.decrementAndGet();
            }, "update particle velocity " + i);

            thread.start();
        }

        do {} while (workingThreads.get() > 0); //waits for all threads to finish
    }

    private void handleFps() {
        frameCount++;
        long now = System.currentTimeMillis() / 1000; // second
        if (now - lastFrameShowed > 1) {
            System.out.println("FPS: " + frameCount);
            frameCount = 0;
            lastFrameShowed = now;
        }
    }
}
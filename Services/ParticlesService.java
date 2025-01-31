package Services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Structures.Particle;
import Structures.Vector2;

public class ParticlesService {
    ArrayList<Particle> particles;
    Queue<Particle> particlesToSpawn;
    long lastSpawnTime;

    public ParticlesService() {
        particles = new ArrayList<Particle>();
        lastSpawnTime = System.currentTimeMillis();
        particlesToSpawn = new LinkedList<>();
    }

    // creates a particle, adds it to a queue if it's not time yet, add to the list of particles otherwise
    public Particle createParticle(byte radius, Vector2 position, Vector2 velocity, long spawnTime) {
        long now = System.currentTimeMillis();

        Particle particle = new Particle((short) (particles.size() + particlesToSpawn.size()), radius, position, velocity, spawnTime);

        if (spawnTime <= now) {
            particles.add(particle);
        } else {
            particlesToSpawn.add(particle);
        }
        
        return particle;
    }

    public Particle createParticle(byte radius, Vector2 position, Vector2 velocity) {
        return createParticle(radius, position, velocity, System.currentTimeMillis());
    }

    // honestly i expected this to be more generic but whatever
    // creates a bunch of particles
    public void createParticles(Vector2 position, Vector2 velocity, int numParticles, int minRadius, int maxRadius, int msDelay) {
        long now = System.currentTimeMillis();
        for (int i = 0; i < numParticles; i++) {
            byte radius = (byte) (minRadius + Math.random() * (maxRadius - minRadius));

            createParticle(radius, position, velocity.add(new Vector2(0, (Math.sin(i/5.0) + 1) * 20)), now + i * msDelay);
        }
    }

    // checks if the next particle should be spawned
    public void summonParticleIfNeeded() {
        long now = System.currentTimeMillis();

        Particle particle = particlesToSpawn.peek();
        if (particle != null && now >= particle.spawnTime) {
            particles.add(particle);
            particlesToSpawn.poll();
        }
    }

    public ArrayList<Particle> getParticles() {
        return particles;
    }
}

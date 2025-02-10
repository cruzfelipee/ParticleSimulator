package Main;
import javax.swing.JFrame;

import Structures.Vector2;

public class App {
    final static int NUMBER_OF_PARTICLES = 1500; // particle count
    final static int MIN_RADIUS = 4; // min radius of the particles
    final static int MAX_RADIUS = 8; // max radius of the particle
    final static int MS_DELAY = 1; // delay between the spawn of each particle

    public static void main(String[] args) {
        JFrame frame = new JFrame("Particle Simulator");
        Simulator simulator = new Simulator(800, 600, 4, 8);
        frame.add(simulator.drawer);
        frame.setSize(812, 640);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        simulator.particlesService.createParticles(
            new Vector2(20, 20), new Vector2(50, 0), NUMBER_OF_PARTICLES, MIN_RADIUS, MAX_RADIUS, MS_DELAY
        );

        System.out.println(((double) System.currentTimeMillis())/1000);

        simulator.run();
    }
}

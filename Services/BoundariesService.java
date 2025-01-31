package Services;

import Structures.Particle;

public class BoundariesService {
    //if gets out of bounds, bounce to the opposite direction
    public static void calculateBoundaries(Particle particle, int limitX, int limitY) {
        if (particle.position.x < particle.radius) {
            particle.position.x = particle.radius;
            particle.velocity.x = -particle.velocity.x;
        }
        if (particle.position.x + particle.radius > limitX) {
            particle.position.x = limitX - particle.radius;
            particle.velocity.x = -particle.velocity.x;
        }
        if (particle.position.y < particle.radius) {
            particle.position.y = particle.radius;
            particle.velocity.y = -particle.velocity.y;
        }
        if (particle.position.y + particle.radius > limitY) {
            particle.position.y = limitY - particle.radius;
            particle.velocity.y = -particle.velocity.y;
        }
    }
}

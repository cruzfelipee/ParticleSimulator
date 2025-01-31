package Services;

import Structures.Particle;

public class DragService {
    static final double DRAG = .1;

    public static void applyDrag(Particle particle, double deltaTime) {
        particle.velocity = particle.velocity.mult(1 - DRAG * deltaTime);
    }
}

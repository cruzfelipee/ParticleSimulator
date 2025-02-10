package Services;

import Structures.Particle;
import Structures.Vector2;

public class DragService {
    static final double DRAG = .001;

    // https://en.wikipedia.org/wiki/Drag_equation
    public static void applyDrag(Particle particle, double deltaTime) {
        // Drag = velocty ^ 2 * dragCoefficient * area * density / 2
        // Considering we need to calculate final velocity, not drag force, we can ignore the area and density
        // Drag delta velocity = velocity ^ 2 * dragCoefficient * deltaTime

        Vector2 dragVelocity = particle.velocity.mult(particle.velocity.magnitude() * DRAG * deltaTime);
        particle.velocity = particle.velocity.sub(dragVelocity);
    }
}

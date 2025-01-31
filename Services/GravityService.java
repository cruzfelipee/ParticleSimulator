package Services;

import Structures.Particle;
import Structures.Vector2;

public class GravityService {
    static final Vector2 GRAVITY = new Vector2(0, 10);

    public static void applyGravity(Particle particle, double deltaTime) {
        particle.velocity = particle.velocity.add(GRAVITY.mult(deltaTime));
    }
}

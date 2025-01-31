package Services;

import java.util.ArrayList;

import Structures.Particle;
import Structures.Vector2;

public class CollisionService {
    public static void calculateCollisions(Particle p1, ArrayList<Particle> particles) {
        for (Particle p2 : particles) {
            if (p1.id >= p2.id) continue;

            double minRadius = p1.radius + p2.radius;
            if (p1.distance(p2) < minRadius) {
                collide(p1, p2);
                //System.out.println("colidedded" + p1 + p2);
            }
        }
    }

    // https://math.stackexchange.com/questions/13261/how-to-get-a-reflection-vector
    // idk why but i have to remove the x2 at the end of the formula, or else the velocities kept increasing exponentially
    public static Vector2 calculateBounce(Particle p1, Particle p2) {
        Vector2 normal = p1.position.sub(p2.position).normalize();
        Vector2 relativeVelocity = p1.velocity.sub(p2.velocity);
        Vector2 normalizedVelocity = relativeVelocity.normalize();
        Vector2 result = normalizedVelocity.sub(normal.mult(normalizedVelocity.dot(normal)));

        return result.mult(relativeVelocity.magnitude());
    }

    public static void collide(Particle p1, Particle p2) {
        Vector2 v1 = p2.velocity.add(calculateBounce(p1, p2));
        Vector2 v2 = p1.velocity.add(calculateBounce(p2, p1));

        p1.velocity = v1;
        p2.velocity = v2;
    }
}

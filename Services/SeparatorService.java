package Services;

import java.util.ArrayList;

import Structures.Particle;
import Structures.Vector2;

public class SeparatorService {
    /*
     * On lower framerates, you might get a better looking simulation by increasing the number of
     * times this method is called per tick. This happens because the method doesnt guarantee that
     * all particles wont touch each other, as it only checks for collisions between pairs each
     * iteration.
    */
    public static void calculateSeparations(Particle p1, ArrayList<Particle> particles) {
        for (Particle p2 : particles) {
            if (p1.id == p2.id) continue;

            double minRadius = p1.radius + p2.radius;
            if (p1.distance(p2) < minRadius) {
                separate(p1, p2);
            }
        }
    }
    
    // makes sure that the particles arent overlapping
    public static void separate(Particle p1, Particle p2) {
        Vector2 normal = p1.position.sub(p2.position).normalize();
        double overlap = p1.radius + p2.radius - p1.distance(p2);
        Vector2 separation = normal.mult(overlap / 2);
        p1.position = p1.position.add(separation);
        p2.position = p2.position.sub(separation);
    }
}

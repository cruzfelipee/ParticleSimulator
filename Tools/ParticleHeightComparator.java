package Tools;
import java.util.Comparator;

import Structures.Particle;

public class ParticleHeightComparator implements Comparator<Particle> {
    @Override
    public int compare(Particle p1, Particle p2) {
        return Double.compare(p2.position.y, p1.position.y);
    }
}
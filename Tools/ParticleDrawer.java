package Tools;
import javax.swing.*;

import Structures.Particle;

import java.awt.*;
import java.util.ArrayList;

public class ParticleDrawer extends JPanel {
    private ArrayList<Particle> particles;

    public ParticleDrawer(ArrayList<Particle> particles) {
        this.particles = particles;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ArrayList<Particle> clone = new ArrayList<>(particles);
        for (Particle p : clone) {
            g.setColor(p.color);
            g.fillOval((int) p.position.x - p.radius, (int) p.position.y - p.radius, p.radius * 2, p.radius * 2);
        }
    }
}
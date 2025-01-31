package Structures;

import java.awt.Color;
import java.util.Random;

public class Particle {
    public short id;
    public byte radius;
    public Vector2 position;
    public Vector2 velocity;
    public Color color;
    public long spawnTime;

    public Particle (short id, byte radius, Vector2 position, Vector2 velocity, long spawnTime) {
        Random rng = new Random();

        this.id = id;
        this.radius = radius;
        this.position = position;
        this.velocity = velocity;
        this.color = Color.getHSBColor(rng.nextFloat(), 1, 1);
        this.spawnTime = spawnTime;
    }

    public Particle (short id, byte radius, Vector2 position, Vector2 velocity) {
        this(id, radius, position, velocity, System.currentTimeMillis());
    }

    public double distance(Particle other) {
        return this.position.sub(other.position).magnitude();
    }
}
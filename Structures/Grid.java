package Structures;

import java.util.ArrayList;
import java.lang.reflect.Array;

public class Grid {
    int width;
    int height;
    int resolution;

    ArrayList<Particle>[][] grid;

    @SuppressWarnings("unchecked")
    public Grid(int width, int height, int resolution) {
        this.width = width;
        this.height = height;
        this.resolution = resolution;

        grid = (ArrayList<Particle>[][]) Array.newInstance(ArrayList.class, resolution, resolution);
    }

    public void insert(Particle particle) {
        int x = (int) (resolution * (particle.position.x / width));
        int y = (int) (resolution * (particle.position.y / height));

        x = Math.max(x, 0);
        x = Math.min(x, resolution - 1);
        y = Math.max(y, 0);
        y = Math.min(y, resolution - 1);

        if (grid[x][y] == null) {
            grid[x][y] = new ArrayList<>();
        }
        grid[x][y].add(particle);
    }

    public void clear() {
        for (int i = 0; i < resolution; i++) {
            for (int j = 0; j < resolution; j++) {
                grid[i][j] = null;
            }
        }
    }

    public ArrayList<Particle> getNeighbours(Particle particle) {
        ArrayList<Particle> neighbours = new ArrayList<>();

        int x = (int) (resolution * (particle.position.x / width));
        int y = (int) (resolution * (particle.position.y / height));

        for (int i = -1; i <= 1; i++) {
            int xIndex = x + i;
            if (xIndex < 0 || xIndex >= resolution) continue;
            for (int j = -1; j <= 1; j++) {
                
                int yIndex = y + j;
                if (yIndex >= 0 && yIndex < resolution) {
                    if (grid[xIndex][yIndex] != null) {
                        neighbours.addAll(grid[xIndex][yIndex]);
                    }
                }
            }
        }

        return neighbours;
    }
}

package de.lingen.modsim.model.food;

import de.lingen.modsim.model.Field;
import de.lingen.modsim.core.Point2D;

public class Point2DFood extends Point2D {
    private static final double DEAD_ZONE = 0.1; // no food will spawn there i.e. 10%

    /**
     * constructor with given points
     * @param x x pos
     * @param y y pos
     */
    public Point2DFood(int x, int y) {
        super(x, y);
    }

    /**
     * generates a random point in middle of the field
     * @return random point
     */
    public static Point2DFood randomPoint() {
        Field field = Field.getInstance();

        int x = (int) (random.nextInt((int) (field.MAX_X - (field.MAX_X * DEAD_ZONE * 2)) + 1) +
                       field.MAX_X * DEAD_ZONE);
        int y = (int) (random.nextInt((int) (field.MAX_Y - (field.MAX_Y * DEAD_ZONE * 2)) + 1) +
                       field.MAX_Y * DEAD_ZONE);

        return new Point2DFood(x, y);
    }

    /**
     * @param x checks if an x value is in the area
     * @return true = is in the area
     */
    @Override
    public boolean inBoundsX(int x) {
        return (x >= field.MAX_X * DEAD_ZONE) && (x <= field.MAX_X * (1 - DEAD_ZONE));
    }

    @Override
    public boolean inBoundsY(int y) {
        return (y >= field.MAX_Y * DEAD_ZONE) && (y <= field.MAX_Y * (1 - DEAD_ZONE));
    }

    @Override
    public void setX(int x) {
        this.x = inBoundsX(x) ? x : randomPoint().x;
    }

    @Override
    public void setY(int y) {
        this.y = inBoundsY(y) ? y : randomPoint().y;
    }

    @Override
    public boolean equals(Object obj) {
        return x == ((Point2DFood) obj).x
               && y == ((Point2DFood) obj).y
               && obj.getClass() == this.getClass();
    }
}

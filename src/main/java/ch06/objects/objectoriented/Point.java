package ch06.objects.objectoriented;

import java.util.StringJoiner;

public class Point implements  Shape {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String print() {
        return toString();
    }

    @Override
    public void move(double by_x, double by_y) {
        x += by_x;
        y += by_y;
    }

    @Override
    public void scale(double factor) {
        // NOP
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Point.class.getSimpleName() + "[", "]")
                .add("x=" + x)
                .add("y=" + y)
                .toString();
    }
}

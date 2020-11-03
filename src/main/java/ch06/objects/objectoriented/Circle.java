package ch06.objects.objectoriented;

import java.util.StringJoiner;

public class Circle implements Shape {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public String print() {
        return toString();
    }

    @Override
    public void move(double by_x, double by_y) {
        center.move(by_x, by_y);
    }

    @Override
    public void scale(double factor) {
        radius *= factor;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Circle.class.getSimpleName() + "[", "]")
                .add("center=" + center)
                .add("radius=" + radius)
                .toString();
    }
}

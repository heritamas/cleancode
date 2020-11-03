package ch06.objects.objectoriented;

import java.util.StringJoiner;

public class Ellipse implements Shape {
    private Point center;
    private double a;
    private double b;

    public Ellipse(Point center, double a, double b) {
        this.center = center;
        this.a = a;
        this.b = b;
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
        a *= factor;
        b *= factor;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Ellipse.class.getSimpleName() + "[", "]")
                .add("center=" + center)
                .add("a=" + a)
                .add("b=" + b)
                .toString();
    }
}

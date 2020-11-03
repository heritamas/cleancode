package ch06.objects.objectoriented;

import java.util.StringJoiner;

public class Rectangle implements Shape {

    private Point topleft;
    private double a;
    private double b;

    public Rectangle(Point topleft, double a, double b) {
        this.topleft = topleft;
        this.a = a;
        this.b = b;
    }

    @Override
    public String print() {
        return toString();
    }

    @Override
    public void move(double by_x, double by_y) {
        topleft.move(by_x, by_y);
    }

    @Override
    public void scale(double factor) {
        a *= factor;
        b *= factor;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Rectangle.class.getSimpleName() + "[", "]")
                .add("topleft=" + topleft)
                .add("a=" + a)
                .add("b=" + b)
                .toString();
    }
}

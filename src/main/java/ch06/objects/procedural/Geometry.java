package ch06.objects.procedural;

public class Geometry {

    public static void main(String[] args) {
        Geometry geo = new Geometry();

        Point center = new Point();
        center.x = 0.0;
        center.y = 0.0;

        Circle circle = new Circle();
        circle.center = center;
        circle.radius = 1.0;

        System.out.println("Before move: " + geo.print(circle));
        geo.move(circle, 0.5, 0.5);
        System.out.println("After move: " + geo.print(circle));
        geo.scale(circle, 2.0);
        System.out.println("After scale: " + geo.print(circle));
    }


    public String print(Object shape) {
        StringBuilder sb = new StringBuilder();

        if (shape instanceof Point) {
            Point p = (Point) shape;
            sb
                    .append("x = " + p.x + ";")
                    .append("x = " + p.y + ";");
        } else if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            sb
                    .append("center: " + print(c.center))
                    .append("r = " + c.radius + ";");
        } else if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            sb
                    .append("topleft: " + print(r.topleft))
                    .append("a = " + r.a + ";")
                    .append("b = " + r.b + ";");
        }

        return sb.toString();
    }

    public void move(Object shape, double by_x, double by_y) {
        if (shape instanceof Point) {
            Point p = (Point) shape;
            p.x += by_x;
            p.y += by_y;
        } else if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            move(c.center, by_x, by_y);
        } else if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            move(r.topleft, by_x, by_y);
        }
    }

    public void scale(Object shape, double factor) {
        if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            c.radius *= factor;
        } else if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            r.a *= factor;
            r.b *= factor;
        }
    }

    public double area(Object shape) {
        double area = 0.0;
        if (shape instanceof Circle) {
            Circle c = (Circle) shape;
            area = Math.PI * c.radius * c.radius;
        } else if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            area = r.a * r.b;
        }

        return area;
    }
}

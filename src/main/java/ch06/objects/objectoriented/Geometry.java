package ch06.objects.objectoriented;


public class Geometry {

    public static void main(String[] args) {
        Point center = new Point(0.0, 0.0);
        Circle circle = new Circle(center, 1.0);

        System.out.println("Before move: " + circle.print());
        circle.move(0.5, 0.5);
        System.out.println("After move: " + circle.print());
        circle.scale(2.0);
        System.out.println("After scale: " + circle.print());

    }

}

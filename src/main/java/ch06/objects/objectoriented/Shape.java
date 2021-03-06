package ch06.objects.objectoriented;

public interface Shape extends Cloneable {

    String print();
    void move(double by_x, double by_y);
    void scale(double factor);
}

package ch06.objects.geo;

public class RightAngleTriangle  extends Triangle {

    public RightAngleTriangle(double a, double b) {
        super(a, b, Math.sqrt(a*a + b*b));
    }

    @Override
    public double area() {
        return (a*b)/2;
    }
}

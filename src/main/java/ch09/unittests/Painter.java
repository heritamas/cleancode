package ch09.unittests;

import ch06.objects.objectoriented.Circle;
import ch06.objects.objectoriented.Rectangle;

public class Painter {

    public void drawCar(Circle wheel, Rectangle body) {
        body.scale(10.0);

        wheel.move(2, 0);
        wheel.move(2.1, 0);
        wheel.move(8, 0);
        wheel.move(8.1, 0);
    }

}

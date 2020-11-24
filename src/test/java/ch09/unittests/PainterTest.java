package ch09.unittests;

import ch06.objects.objectoriented.Circle;
import ch06.objects.objectoriented.Rectangle;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class PainterTest {

    Circle circle;
    Rectangle rectangle;
    Painter p = new Painter();

    @BeforeEach
    void setUp() {
        circle = mock(Circle.class);
        rectangle = mock(Rectangle.class);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void drawCar() {
        p.drawCar(circle, rectangle);
        verify(circle, times(4)).move(anyDouble(), anyDouble());
        verify(rectangle).scale(anyDouble());
    }
}
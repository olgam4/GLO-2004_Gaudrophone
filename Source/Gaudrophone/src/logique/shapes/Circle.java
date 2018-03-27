package logique.shapes;

import java.awt.Point;
import java.awt.Color;


public class Circle extends BaseShape {

    public Circle(Point point, Color color, int heigth, int width) {
        super(point, color, heigth, width);
        this.name = "Circle";
    }

}

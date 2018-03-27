package logique.shapes;

import java.awt.Point;
import java.awt.Color;

public class Rectangle extends BaseShape {

    public Rectangle(Point point, Color color, int heigth, int width) {
        super(point, color, heigth, width);
        this.name = "Rectangle";
    }

}

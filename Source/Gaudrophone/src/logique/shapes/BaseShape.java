package logique.shapes;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.io.Serializable;

public abstract class BaseShape implements Serializable {

    private Point point;
    private Color backgroundColor;
    private int heigth;
    private int width;
    protected String name;

    public BaseShape(Point point, Color color, int heigth, int width) {
        this.point = point;
        this.backgroundColor = color;
        this.heigth = heigth;
        this.width = width;

    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }

    public void displayShape(Graphics g) {

    }

    public String getName() {
        return this.name;
    }

    public int getHeigth() {
        return this.heigth;
    }

    public void setHeight(int heigth) {
        this.heigth = heigth;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
    }

}

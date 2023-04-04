package geometry;

import java.awt.Graphics;

public class Circle {

    private Point center;
    private int radius;
    private boolean selected;

    public Circle() {

    }

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public Circle(Point center, int radius, boolean selected) {
        this(center, radius);
        this.selected = selected;
    }

    public String toString() {
        return "Center: " + center + ", radius: " + radius + ", selected: " + selected;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Circle) {
            Circle temp = (Circle) obj;

            if (this.center.equals(temp.center) && this.radius == temp.radius) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean contains(int x, int y) {
        return center.distance(x, y) <= radius;
    }

    public boolean contains(Point p) {
        return center.distance(p.getX(), p.getY()) <= radius;
    }

    public double area() {
        return radius * radius * Math.PI;
    }

    public double circumference() {
        return 2 * radius * Math.PI;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int center) {
        this.radius = center;
    }

    @Override
    public void draw(Graphics g) {
        g.drawOval(center.getX() - radius, center.getY() - radius, 2 * radius, 2 * radius);

    }

}
package geometry;

import java.awt.Graphics;

public class Point extends Shape {
    private int x;
    private int y;

    public Point() {

    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, boolean selected) {
        this(x, y);
        this.selected = selected;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point temp = (Point) obj;

            if (this.x == temp.x && this.y == temp.y) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean contains(int x, int y) {
        return this.distance(x, y) <= 2;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getPoint() {
        return x + ", " + y + ", " + selected;
    }

    public void setX(int newX) {
        x = newX;
    }

    public void setY(int newY) {
        y = newY;
    }

    public double distance(int x, int y) {
        int x2 = x;
        int y2 = y;

        double distance = Math.sqrt(Math.pow(x2 - getX(), 2) + Math.pow(y2 - getY(), 2));

        return distance;
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(x - 2, y, x + 2, y);
        g.drawLine(x, y - 2, x, y + 2);
    }
}

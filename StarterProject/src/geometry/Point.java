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
        return "(" + x + "," + y + ")"; // (x,y)
    }

    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point pomocna = (Point) obj;

            if (this.x == pomocna.x && this.y == pomocna.y) {
                return true;
            } else {
                return false;
            }
        } else
            return false;
    }

    public boolean contains(int x, int y) {
        return this.distance(x, y) <= 2;
    }

    public double distance(int x2, int y2) {
        int dx = x2 - x;
        int dy = y2 - y;
        double d = Math.sqrt(dx * dx + dy * dy);
        return d;
    }

    // Metode pristupa (GET i SET)
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int novoX) {
        x = novoX;
    }

    public void setY(int novoY) {
        y = novoY;
    }

    @Override
    public void draw(Graphics g) {
        // tacku predstavljamo kao +
        g.drawLine(x - 2, y, x + 2, y); // horizontalna linija
        g.drawLine(x, y - 2, x, y + 2); // vertikalna linija
    }

    @Override
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;

    }

    @Override
    public void moveBy(int byX, int byY) {
        this.x += x;
        this.y += y;

    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Point)
            return (int) (this.distance(0, 0) - ((Point) o).distance(0, 0));
        return 0;
    }

}

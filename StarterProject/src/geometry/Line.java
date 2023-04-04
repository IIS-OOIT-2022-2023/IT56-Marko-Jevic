package geometry;

import java.awt.Graphics;

public class Line {

    private Point startPoint;
    private Point endPoint;

    public Line() {

    }

    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Line(Point startPoint, Point endPoint, boolean selected) {
        this(startPoint, endPoint);
        this.selected = selected;
    }

    public String toString() {
        return startPoint + " --> " + endPoint;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Line) {
            Line temp = (Line) obj;
            if (this.startPoint.equals(temp.startPoint) && this.endPoint.equals(temp.endPoint)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean contains(int x, int y) {
        return this.startPoint.distance(x, y) + this.endPoint.distance(x, y) - lenght() <= 2;
    }

    public double lenght() {
        return startPoint.getDistanceP2P(endPoint.getX(), endPoint.getY());
    }

    public Point getStartPoint() {
        return this.startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public void draw(Graphics g) {
        g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
    }

}
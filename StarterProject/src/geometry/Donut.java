package geometry;

import java.awt.Graphics;

public class Donut extends Circle {
    private int innerRadius;

    public Donut() {

    }

    public Donut(Point center, int radius, int innerRadius) {
        super(center, radius);
        this.innerRadius = innerRadius;
    }

    @Override
    public String toString() {
        return super.toString() + ", inner radius = " + innerRadius;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Donut) {
            Donut temp = (Donut) obj;

            if (getCenter().equals(temp.getCenter()) 
            && getRadius() == temp.getRadius() 
            && innerRadius == temp.innerRadius) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean contains(int x, int y) {
        return super.contains(x, y) && getCenter().distance(x, y) >= innerRadius;
    }

    @Override
    public boolean contains(Point p) {
        return super.contains(p) && getCenter().distance(p.getX(), p.getY()) >= innerRadius;
    }

    @Override
    public double area() {
        return super.area() - innerRadius * innerRadius * Math.PI;
    }

    @Override
    public double circumference() {
        return super.circumference() + 2 * innerRadius * Math.PI;
    }

    public Donut(Point center, int radius, int innerRadius, boolean selected) {
        this(center, radius, innerRadius);
        setSelected(selected);
    }

    public int getInnerRadius() {
        return innerRadius;
    }

    public void setInnerRadius(int innerRadius) {
        this.innerRadius = innerRadius;
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawOval(getCenter().getX() - innerRadius, getCenter().getY() - innerRadius, 2 * innerRadius, 2 * innerRadius);
    }
}
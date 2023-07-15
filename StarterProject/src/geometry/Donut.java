package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

public class Donut extends Shape {

	private Point center;
	private int outerRadius;
    private int innerRadius;

    public Donut() {

    }
    
    public Donut(Point center, int outerRadius, int innerRadius) {
        this.center = center;
        this.outerRadius = outerRadius;
        this.innerRadius = innerRadius;
    }
    
    public Donut(Point center, int outerRadius, int innerRadius, boolean selected) {
        this.center = center;
        this.outerRadius = outerRadius;
        this.innerRadius = innerRadius;
        this.selected = selected;
    }
    
    public Donut(Point center, int outerRadius, int innerRadius, Color outline, Color fill) {
    	this.center = center;
    	this.outerRadius = outerRadius;
    	this.innerRadius = innerRadius;
    	setOutlineColor(outline);
    	setFillColor(fill);
    }
    
    public double area() {
        return outerRadius * outerRadius * Math.PI - innerRadius * innerRadius * Math.PI;
    }

    public double circumference() {
        return 2 * outerRadius * Math.PI + 2 * innerRadius * Math.PI;
    }

    public int getInnerRadius() {
        return innerRadius;
    }

    public void setInnerRadius(int innerRadius) {
        this.innerRadius = innerRadius;
    }

    public String toString() {
        // Center: (x,y), outerRadius = 55, innerRadius = 44
        return " Center: " + center + " outerRadius = " + outerRadius + ", innerRadius = " + innerRadius;
    }

    public boolean equals(Object obj) {

        if (obj instanceof Donut) {
            Donut pomocna = (Donut) obj;
            if (this.center.equals(pomocna.center)
                    && this.outerRadius == pomocna.outerRadius
                    && this.innerRadius == pomocna.innerRadius)
                return true;
            else
                return false;
        } else
            return false;
    }

    public boolean contains(int x, int y) {
        return center.distance(x, y) <= outerRadius && center.distance(x, y) >= innerRadius;
    }

    public boolean contains(Point p) {
        return center.distance(p.getX(), p.getY()) <= outerRadius && center.distance(p.getX(), p.getY()) >= innerRadius;
    }
    
    public void draw(Graphics g) {
        // Create the outer circle ellipse
        Ellipse2D outerCircle = new Ellipse2D.Double(center.getX() - outerRadius, center.getY() - outerRadius, outerRadius * 2, outerRadius * 2);
        
        // Create the inner circle ellipse
        Ellipse2D innerCircle = new Ellipse2D.Double(center.getX() - innerRadius, center.getY() - innerRadius, innerRadius * 2, innerRadius * 2);
        
        // Create an Area from the outer ellipse
        Area ringArea = new Area(outerCircle);
        
        // Subtract the inner ellipse from the outer ellipse to get the ring shape
        ringArea.subtract(new Area(innerCircle));
        
        Graphics2D g2 = (Graphics2D) g;
        
        // Fill the ring shape with the fill color
        g2.setColor(getFillColor());
        g2.fill(ringArea);
        
        // Set the outline color and draw the ring shape
        g2.setColor(getOutlineColor());
        g2.draw(ringArea);
       
       
        if (selected) {
            g.setColor(Color.blue);
            g.drawRect(center.getX() - outerRadius - 2, center.getY() - 2, 4, 4);
            g.drawRect(center.getX() + outerRadius - 2, center.getY() - 2, 4, 4);
            g.drawRect(center.getX() - 2, center.getY() - outerRadius - 2, 4, 4);
            g.drawRect(center.getX() - 2, center.getY() + outerRadius - 2, 4, 4);
            g.drawRect(center.getX() - innerRadius - 2, center.getY() - 2, 4, 4);
            g.drawRect(center.getX() + innerRadius - 2, center.getY() - 2, 4, 4);
            g.drawRect(center.getX() - 2, center.getY() - innerRadius - 2, 4, 4);
            g.drawRect(center.getX() - 2, center.getY() + innerRadius - 2, 4, 4);
        }

    }
    
    @Override
    public void moveTo(int x, int y) {
    	center.moveTo(x, y);
    }
    
    @Override
    public void moveBy(int byX, int byY) {
    	center.moveBy(byX, byY);
    }
    
    @Override
    public int compareTo(Object obj) {
        if (obj instanceof Donut) {
            Donut shapeToCompare = (Donut) obj;
            return (int) (this.area() - shapeToCompare.area());
        }
        return 0;
    }

	public Point getCenter() {
		return center;
	}

	public int getOuterRadius() {
		return outerRadius;
	}

	public void setOuterRadius(int outerRadius) {
		this.outerRadius = outerRadius;
	}

	public void setCenter(Point center) {
		this.center = center;
	}
    
}

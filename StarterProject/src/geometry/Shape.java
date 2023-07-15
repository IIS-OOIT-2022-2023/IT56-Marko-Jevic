package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Moveable, Comparable<Object> {

	protected Color outlineColor;
    protected Color fillColor;
	
    protected boolean selected;

    // deklaracija apstraktnih metoda
    public abstract boolean contains(int x, int y);

    public abstract void draw(Graphics g);
    
    public Shape() {

    }
    
    public Color getOutlineColor() {
		return outlineColor;
	}

	public void setOutlineColor(Color outlineColor) {
		this.outlineColor = outlineColor;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public Shape(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}

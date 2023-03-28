package geometry;

public class Rectangle {

    private Point upperLeftPoint;
    private int width;
    private int height;
    private boolean selected;

    public Rectangle() {

    }

    public Rectangle(Point upperLeftPoint, int width, int height) {
        this.upperLeftPoint = upperLeftPoint;
        this.width = width;
        this.height = height;
    }

    public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
        this(upperLeftPoint, width, height);
        this.selected = selected;
    }

    public String toString() {
        return "Upper left point: " + upperLeftPoint + ", width: " + width + ", height: " + height + ", selected: "
                + selected;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Rectangle) {
            Rectangle temp = (Rectangle) obj;

            if (this.upperLeftPoint.equals(temp.upperLeftPoint) && this.width == temp.width
                    && this.height == temp.height) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public boolean contains(int x, int y) {
        return (x >= upperLeftPoint.getX() && x <= upperLeftPoint.getX() + width
                && y >= upperLeftPoint.getY() && y <= upperLeftPoint.getY() + height);
    }

    // Metode za racunanje povrsine
    public int area() {
        return width * height;
    }

    // Metode za racunanje obima
    public int circumference() {
        return 2 * (width + height);
    }

    // Methode pristupa
    public Point getUpperLeftPoint() {
        return upperLeftPoint;
    }

    public void setUpperLeftPoint(Point upperLeftPoint) {
        this.upperLeftPoint = upperLeftPoint;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
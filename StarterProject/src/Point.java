
public class Point {
    private int x;
    private int y;
    private boolean selected;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isSelected() {
        return selected;
    }

    /* get all values of Point */
    public String getPoint() {
        return x + ", " + y + ", " + selected;
    }

    public void setX(int newX) {
        x = newX;
    }

    public void setY(int newY) {
        y = newY;
    }

    public void setSelected(boolean newSelected) {
        selected = newSelected;
    }

    public double getDistanceP2P(int x, int y) {
        int x2 = x;
        int y2 = y;

        double distance = Math.sqrt(Math.pow(x2 - getX(), 2) + Math.pow(y2 - getY(), 2));

        return distance;
    }
}

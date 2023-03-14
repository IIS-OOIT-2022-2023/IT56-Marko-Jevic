public class Line {

    private Point startPoint;
    private Point endPoint;
    private boolean selected;

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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
import javax.swing.event.SwingPropertyChangeSupport;

public class Test {
    public static void main(String[] args) {

        Point p1 = new Point();

        p1.setX(10);
        p1.setY(15);
        p1.setSelected(true);

        Point p2 = new Point();

        p2.setX(4);
        p2.setY(5);
        p2.setSelected(true);

        System.out.println(p1.getDistanceP2P(p2.getX(), p2.getY()));


    }
}

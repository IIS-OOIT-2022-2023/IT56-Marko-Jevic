public class Test {
    public static void main(String[] args) {

        Point p = new Point();

        p.setX(10);
        p.setY(20);
        p.setSelected(true);

        System.out.println(p.getDistanceP2P(8, 18));

    }
}

package geometry;

public class Test {

    public static void main(String[] args) {

        Point point1 = new Point();

        // point1.x = 4;
        // point1.y = 5; Nije moguce zbog specifikatora pristupa

        point1.setX(4);
        point1.setY(5);
        point1.setSelected(false);

        System.out.println("X koordinata: " + point1.getX()); // (4,5)
        System.out.println("Y koordinata: " + point1.getY());
        System.out.println("Selected: " + point1.isSelected());

        double distanceResult = point1.distance(8, 7);
        System.out.println(distanceResult);

        // Vezbe 3
        System.out.println("Vezbe 3");

        Point p2 = new Point();
        Line l1 = new Line(); // objekat klase Line; instanca klase Line
        Rectangle r1 = new Rectangle();
        Circle c1 = new Circle();

        p2.setX(10);
        p2.setY(15);

        // Zadatak 1

        point1.setX(p2.getY());
        System.out.println("X koordinata tacke point1:" + point1.getX());

        // Zadatak 2

        l1.setStartPoint(point1);
        l1.setEndPoint(p2);
        System.out.println("X koordinate pocetne tacke l1: " + l1.getStartPoint().getX());
        System.out.println("Y koordinate pocetne tacke l1: " + l1.getStartPoint().getY());
        System.out.println("X koordinate pocetne tacke l1: " + l1.getEndPoint().getX());
        System.out.println("Y koordinate pocetne tacke l1: " + l1.getEndPoint().getY());

        // Zadatak 3

        l1.getEndPoint().setY(23);
        System.out.println("Y koordinate pocetne tacke l1: " + l1.getEndPoint().getY());

        // Zadatak 4

        l1.getStartPoint().setX(l1.getEndPoint().getY());
        System.out.println("X koordinate pocetne tacke l1: " + l1.getStartPoint().getX());

        // Zadatak 5

        l1.getEndPoint().setX((int) l1.lenght() - (l1.getStartPoint().getX() + l1.getStartPoint().getY()));

        // Zadatak 6

        r1.setUpperLeftPoint(new Point());
        r1.getUpperLeftPoint().setX(10);
        r1.getUpperLeftPoint().setY(15);
        System.out.println("X koordinata pravougaonika r1: " + r1.getUpperLeftPoint().getX());
        System.out.println("Y koordinata pravougaonika r1: " + r1.getUpperLeftPoint().getY());

        // Vezbe 4
        System.out.println(point1);
        System.out.println(l1);
        System.out.println(c1);
        System.out.println(r1);

        int a = 5;
        int b = 5;
        System.out.println(a == b); // poredjenje po vrednosti

        String s1 = new String("Hello");
        String s2 = new String("Hello");
        System.out.println(s1 == s2); // poredjenje po referenci
        System.out.println(s1.equals(s2)); // poredjenje po vrednosti

        Point p3 = new Point(23, 5);
        System.out.println(point1 == p3);
        System.out.println(point1.equals(p3));

    }

}

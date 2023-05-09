package geometry;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.Iterator;

public class Drawing extends JPanel {

    public Drawing() {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Drawing");
        frame.setSize(800, 600);
        Drawing drawing = new Drawing();
        frame.getContentPane().add(drawing);
        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        Point p1 = new Point(40, 50);
        //p1.draw(g);

        Line l1 = new Line(p1, new Point(110, 70));
        //l1.draw(g);

        g.setColor(Color.red);
        Circle c1 = new Circle(new Point(50, 200), 35);
        //c1.draw(g);

        Rectangle r1 = new Rectangle(new Point(150, 200), 40, 40);
        //r1.draw(g);

        g.setColor(Color.green);
        Donut d1 = new Donut(new Point(200, 300), 50, 30);
        //d1.draw(g);

        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(p1);
        shapes.add(l1);
        shapes.add(c1);
        shapes.add(r1);
        shapes.add(d1);

        Iterator<Shape> it = shapes.iterator();
        while(it.hasNext()) {
            it.next().moveBy(10, 0);
        }
        g.setColor(Color.black);
        shapes.get(3).draw(g);
        shapes.get(shapes.size() - 1).draw(g);
        shapes.remove(1);
        shapes.get(1).draw(g);
        shapes.get(3).draw(g);
        
        try {
        	c1.setRadius(-14);
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        System.out.println("Radius kruga c1 je: "+ c1.getRadius());

        p1.setSelected(true);
        l1.setSelected(true);
        c1.setSelected(true);
        r1.setSelected(true);
        d1.setSelected(true);
        
        it = shapes.iterator();
        while(it.hasNext()) {
            it.next().draw(g);
        }

        HashMap<String, Shape> map = new HashMap<String, Shape>();
        map.put("point", p1);
        map.put("line", l1);
        System.out.println(map.get("line"));
    }

}

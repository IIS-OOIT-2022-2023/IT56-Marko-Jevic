package geometry;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
    	Line l = new Line(new Point(100,100), new Point(300,300), Color.RED);
    	l.draw(g);
    	
    	Donut d = new Donut(new Point(200,200), 100, 50, Color.BLACK, Color.YELLOW);
    	d.draw(g);
    	
    	


    }
}

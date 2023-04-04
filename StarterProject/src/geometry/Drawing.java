package geometry;

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

    public Drawing(){
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Drawing");
        window.setSize(500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    public void paint(Graphics g) {
        Point p1 = new Point(40, 50);
    }
}
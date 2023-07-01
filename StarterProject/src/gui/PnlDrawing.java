package gui;

import javax.swing.JPanel;

import java.awt.Graphics;
import geometry.Shape;

import java.util.ArrayList;

public class PnlDrawing extends JPanel {

    protected void paintComponent(Graphics g, ArrayList<Shape> shapes) {
        super.paintComponent(g);
        if (shapes != null) {
            for (Shape shape : shapes) {
                shape.draw(g);
            }
        }
    }
}
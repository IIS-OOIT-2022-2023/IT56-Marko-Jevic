package geometry;

import java.awt.Color;

public class Test {

    public static void main(String[] args) {

    	Shape obj;

    	
    	obj = new Line(new Point(100,100), new Point(200,200), Color.BLUE);
    	
    	System.out.println(obj.getFillColor());
    	
    	obj.setFillColor(new Color(152,54,89));
    	System.out.println(obj.getFillColor());
    }

}

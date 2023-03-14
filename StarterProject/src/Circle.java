public class Circle{


    private Point center; 
    private int radius;
    private boolean selected;

    
    public int area(){
        return radius*radius*Math.PI;
    }
    public int circumference(){
        return 2*radius*Math.PI;
    }

    public Point getCenter(){
        return center;
    }

    public void setCenter(Point center){
        this.center = center;
    }
        
    public int getRadius(){
        return radius;
    }

    public void setRadius(int center){
        this.center = center;
    }
    
    public booleann isSelected(){
        return center;
    }

    public void setSelected(booleann selected){
        this.selected = selected;
    }

    
}
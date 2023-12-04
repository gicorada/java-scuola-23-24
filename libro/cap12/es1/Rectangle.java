package libro.cap12.es1;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        if(width == 1) return height;
        Rectangle small = new Rectangle(width - 1, height);
        return small.getArea() + height;
    }
}

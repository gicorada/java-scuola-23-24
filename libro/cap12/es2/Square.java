package libro.cap12.es2;

public class Square {
    private final double width;

    public Square(double width) {
        this.width = width;
    }

    double getArea() {
        if(width == 1) return 1;
        Square small = new Square(width - 1);
        return small.getArea() + width + width - 1;
    }
}

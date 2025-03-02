interface ShapeAcceptor {
    void accept(ShapeVisitor visitor);
}
class Circle implements ShapeAcceptor {
    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}

class Rectangle implements ShapeAcceptor {
    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visit(this);
    }
}
interface ShapeVisitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
}
class DrawingVisitor implements ShapeVisitor {
    @Override
    public void visit(Circle circle) {
        System.out.println("Drawing a Circle");
    }

    @Override
    public void visit(Rectangle rectangle) {
        System.out.println("Drawing a Rectangle");
    }
}
public class VisitorPatternExample {
    public static void main(String[] args) {
        ShapeAcceptor circle = new Circle();
        ShapeAcceptor rectangle = new Rectangle();

        ShapeVisitor drawingVisitor = new DrawingVisitor();

        circle.accept(drawingVisitor);   // "Drawing a Circle"
        rectangle.accept(drawingVisitor); // "Drawing a Rectangle"
    }
}

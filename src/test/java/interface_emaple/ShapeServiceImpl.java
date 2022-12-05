package interface_emaple;

public class ShapeServiceImpl {

    private final Shape shape;

    public ShapeServiceImpl(Shape shape) {
        this.shape = shape;
    }

    public void setProperty(float... params) {
        shape.setProperty(params);
    }

    public float getArea() {
        return shape.getArea();
    }

    public float getPeremeter() {
        return shape.getPeremeter();
    }
}

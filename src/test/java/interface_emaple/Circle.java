package interface_emaple;

public class Circle implements Shape{

    private float radius;

    private final float pi = 3.14F;

    @Override
    public void setProperty(float... params) {
        this.radius = params[0];
    }

    @Override
    public float getArea() {
        return (pi*radius*radius);
    }

    @Override
    public float getPeremeter() {
        return (2*pi*radius);
    }

}

package interface_emaple;

public class Triangle implements Shape {

    private float height;

    private float base;


    @Override
    public void setProperty(float... params) { // height, base
        this.height = params[0];
        this.base = params[1];
    }

    @Override
    public float getArea() {
        return (0.5F*height*base);
    }

    @Override
    public float getPeremeter() {
        return (height*base);
    }
}

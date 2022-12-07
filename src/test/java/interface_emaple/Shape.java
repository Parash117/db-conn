package interface_emaple;

public interface Shape {

    void setProperty(float... params);

    float getArea();

    float getPeremeter();

    default void someMethod(){
        System.out.println("");
    }

}

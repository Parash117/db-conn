package interface_emaple;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainClass {


    public static void main(String[] args) {
        List<Integer> range = IntStream.rangeClosed(1, 4)
                .boxed().collect(Collectors.toList());
        ShapeServiceImpl shapeService;

        String calculateFor = "triangle";

        if("circle".equalsIgnoreCase(calculateFor)){
            shapeService = new ShapeServiceImpl(new Circle());
            shapeService.setProperty(5F);
        }
        else if ("triangle".equalsIgnoreCase(calculateFor)){
            shapeService = new ShapeServiceImpl(new Triangle());
            shapeService.setProperty(20F, 5F);
        }
        else {
            shapeService = new ShapeServiceImpl(new Circle());
        }

        System.out.println("area of "+calculateFor+" = "+shapeService.getArea());

    }


}

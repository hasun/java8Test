import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasun on 17. 5. 13.
 */
public class Apple {

    String color;
    int weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static boolean isGreenApple(Apple apple){
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight() > 150;
    }

    public Apple () {

    }
    public Apple(int weight , String color) {
        this.weight= weight;
        this.color=color;
    }
    public static List<Apple> initData() {
        List <Apple> initData = new ArrayList<Apple>();
        String color = "";
        for ( int num=0 ; num < 200 ; num += 10 ) {
            if (num%20 == 0) {
                color = "red";
            }else {
                color = "green";
            }
            initData.add(new Apple (num , color));
        }
        return initData;
    }

    @Override
    public String toString() {
        return "weight :: "+this.getWeight() + " color :: "+this.getColor();
    }
}

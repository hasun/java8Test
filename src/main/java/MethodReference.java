/**
 * Created by hasun on 17. 5. 13.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MethodReference {

    public interface Predicate<T> {
        boolean filter(T t);
    }

    public static <T> Collection<T> filter(Collection<T> c, Predicate<T> p) {
        List <T> result = new ArrayList<T>();
        for (T t : c) {
            if (p.filter(t)) {
                result.add(t);
            }
        }
        return result;
    }

    static List<Apple> filterApples (List <Apple> inventory , Predicate <Apple> p) {
        List <Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (p.filter(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main (String [] args) {
        List<Apple> inventory = new ArrayList<Apple>();

        Apple apple = new Apple();
        apple.setColor("green");
        apple.setWeight(400);
        inventory.add(apple);

        apple = new Apple();
        apple.setColor("green");
        apple.setWeight(100);
        inventory.add(apple);

        System.out.println("green :: "+ filterApples(inventory , Apple::isGreenApple));
        System.out.println("green :: "+ filterApples(inventory ,(Apple a) -> "green".equals(a.getColor())));

        System.out.println("heavy :: "+ filterApples(inventory , Apple::isHeavyApple));
        System.out.println("heavy :: "+ filterApples(inventory ,(Apple a) -> a.getWeight() > 150));

        System.out.println("green || heavy :: "+ filterApples(inventory ,(Apple a) -> a.getWeight() > 150 || "green".equals(a.getColor())));

        System.out.println("test :: "+ filter(inventory , (Apple a) -> a.getWeight() > 150));
    }
}

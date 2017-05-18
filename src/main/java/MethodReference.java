/**
 * Created by hasun on 17. 5. 13.
 */

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Supplier;

import static java.util.Comparator.comparing;

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

    public static List <Apple> map (List<Integer> list , FunctionalInterfaces.Function<Integer , Apple> f) {
        List <Apple> result = new ArrayList<>();
        for (Integer e : list) {
            result.add(f.apply(e));
        }
        return result;
    }

    static Map<String , FunctionalInterfaces.Function<Integer , Apple>> map = new HashMap<>();
    static {
        map.put("apple" , Apple::new);
        map.put("apple" , Apple::new);
    }


    public static void main (String [] args) {
        Apple apple = new Apple();
        List<Apple> inventory = apple.initData();

        System.out.println("green :: "+ filterApples(inventory , Apple::isGreenApple));
        System.out.println("green :: "+ filterApples(inventory ,(Apple a) -> "green".equals(a.getColor())));

        System.out.println("heavy :: "+ filterApples(inventory , Apple::isHeavyApple));
        System.out.println("heavy :: "+ filterApples(inventory ,(Apple a) -> a.getWeight() > 150));

        System.out.println("green || heavy :: "+ filterApples(inventory ,(Apple a) -> a.getWeight() > 150 || "green".equals(a.getColor())));

        System.out.println("test :: "+ filter(inventory , (Apple a) -> a.getWeight() > 150));

        inventory.sort(comparing(Apple::getWeight));
        System.out.println (inventory);

        List <String> str = Arrays.asList("a" ,"b" ,"A" , "B");

        System.out.println (str);
        str.sort((s1,s2) -> s1.compareToIgnoreCase(s2));
        str.sort(String::compareToIgnoreCase);

        FunctionalInterfaces.Function<String , Integer> stringToInteger = Integer::parseInt;
        BiPredicate<List<String> , String> contains = List::contains;

        Supplier<Apple> c1 = Apple::new;
        Supplier<Apple> c2 = () -> new Apple();
        FunctionalInterfaces.Function<Integer , Apple> c3 = Apple::new;
        BiFunction<Integer, String , Apple> c4 = Apple::new;
        BiFunction<Integer, String , Apple> c5 = (weight , color) -> new Apple ( weight, color);

        Apple a1 = c1.get();
        a1 = c2.get();
        Apple a2 = c3.apply(100) ;
        System.out.println(a2);

        System.out.println (str);

        List <Integer> weights = Arrays.asList (7,3,4,10);
        List<Apple> apples = map (weights ,Apple::new);
        System.out.println (apples);

        Apple a3 =  c4.apply(110 , "green");
        a3 =  c5.apply(110 , "green");




    }
}

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BehaviorParameter {
	public interface Predicate <T> {
		boolean test(T t);
	}
	
	public interface AppleFormatter<T>{
		String accept(T t);
	}
	
	static <T>Collection<T> filter (Collection<T> c , Predicate<T> p ) {
		Collection <T> result = new ArrayList<>();
		for  (T t : c) {
			if (p.test(t)) {
				result.add(t);
			}
		}
		return result;
	};
	
	public class AppleRedAndHeavyPredicate implements Predicate<Apple>{
		public boolean test(Apple apple){
			return "red".equals(apple.getColor())
					&& apple.getWeight() > 150;
		}
	}
	
	public class AppleFancyFormatter implements AppleFormatter<Apple>{
		public String accept(Apple t){
			String characteristic = t.getWeight() > 150 ? "heavy" : "light";
			return "A " + characteristic +
					" " + t.getColor() +" apple";
		}
	}
	
	
	public class AppleSimpleFormatter implements AppleFormatter<Apple>{
		public String accept(Apple apple){
			return "An apple of " + apple.getWeight() + "g";
		}
	}
	
	public static void prettyPrintApple(Collection<Apple> inventory, AppleFormatter<Apple> formatter){
		for(Apple apple: inventory){
			String output = formatter.accept(apple);
			System.out.println(output);
		}
	}
	
	public static void main (String args []) {
		BehaviorParameter obj = new BehaviorParameter();
		Collection<Apple> inventory = Apple.initData();
		Collection<Apple> redAndHeavyApples =
				filter (inventory, obj.new AppleRedAndHeavyPredicate());
		System.out.println(redAndHeavyApples);
		
		prettyPrintApple(inventory, obj.new AppleFancyFormatter());
		prettyPrintApple(inventory, obj.new AppleSimpleFormatter());
	}
	

}

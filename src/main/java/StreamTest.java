import java.util.List;
import static java.util.stream.Collectors.toList;

public class StreamTest {
	public static void main (String args[]) {
		
		long startTime ;
		long endTime;
		long totalTime;
		
		List <Apple> inventory = Apple.initData();
//		startTime = System.currentTimeMillis();
		List <Apple> heavyApples = inventory.stream().filter((Apple a) -> a.getWeight() > 50).collect(toList());
//		System.out.println(heavyApples);
//		long endTime   = System.currentTimeMillis();
//		long totalTime = endTime - startTime;
//		System.out.println("totalTime ::"+ totalTime);
		
//		startTime = System.currentTimeMillis();
		List <Apple> heavyApples2 = inventory.parallelStream().filter((Apple a) -> a.getWeight() > 50).collect(toList());
//		System.out.println(heavyApples2);
//		endTime   = System.currentTimeMillis();
//		totalTime = endTime - startTime;
//		System.out.println("totalTime ::"+ totalTime);
//		totalTime ::10695
	}

}

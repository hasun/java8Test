import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionalInterfaces {
	
	@FunctionalInterface
	public interface BufferedReaderProcessor {
		String process(BufferedReader b) throws IOException;
	}
	
	@FunctionalInterface
	public interface Predicate <T> {
		boolean test(T t);
	}
	
	@FunctionalInterface 
	public interface Consumer <T> {
		void accept(T t);
	}
	
//	You might use this interface when you need to define a lambda that maps information from an input object to
//	an output (for example, extracting the weight of an apple or mapping a string to its length). 
	@FunctionalInterface 
	public interface Function <T , R> {
		R apply(T t);
	}
	
	public static String processFile (BufferedReaderProcessor p) throws IOException {
		try (BufferedReader br = new BufferedReader (new FileReader ( new File("data/data.txt").getAbsolutePath()))) {
			return p.process(br);
		}
	}
	
	public static <T> List<T> filter (List <T> list , Predicate <T> p) {
		List <T> results = new ArrayList<> ();
		for (T s : list) {
			if (p.test(s)) {
				results.add(s);
			}
		}
		return results;
	}
	
	public static <T> void forEach (List <T> list , Consumer <T> c) {
		for (T i : list) {
			c.accept(i);
		}
	}
	
	public static <T , R> List <R> map (List <T> list , Function <T ,R> f) {
		List <R> result = new ArrayList<>();
		for (T s : list) {
			result.add (f.apply(s));
		}
		return result;
	}
	
	public static void main (String args[]) {
		
		try {
			String oneLine = processFile ((BufferedReader br) -> br.readLine());
			String twoLines = processFile((BufferedReader br) -> br.readLine() + br.readLine());
			
			System.out.println("oneLine" + oneLine);
			System.out.println("twoLine" + twoLines);
			
			List <String> listOfStrings = Arrays.asList("a","b","A","B", "" , " " , "D");
			Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
			List <String> nonEmpty = filter (listOfStrings , nonEmptyStringPredicate);
			System.out.println("nonEmpty" + nonEmpty);
			
			forEach ( Arrays.asList(1,2,3,4,5,6), (Integer i) -> System.out.println(i) );
			
			List <Integer> list = map (Arrays.asList("lambda" , "in" , "action") , (String s) -> s.length());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

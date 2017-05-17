public class LambdaTest {
	public interface Runnable {
		void run();
	}
	
	public static void process (Runnable r) {
		r.run();
	}
	
	public static void main (String args[]) {
		
		Runnable r1 = () -> System.out.println("Test1");
		
		Runnable r2 = new Runnable () {
			public void run() {
				System.out.println("Test2");
			}
		};
		
		process (r1);
		process (r2);
		process(() -> System.out.println("Test3"));
	}

}

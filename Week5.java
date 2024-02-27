import java.time.LocalTime;
import java.time.Duration;

public class Week5{
	public static void main(String[] args){
//		LocalTime start1 = LocalTime.now();
//		System.out.println(fibonacci(50L));
//		System.out.println(Duration.between(start1, LocalTime.now()));
//		LocalTime start2 = LocalTime.now();
//		System.out.println(fib(93L));
//		System.out.println(Duration.between(start2, LocalTime.now()));
		LocalTime start3 = LocalTime.now();
		System.out.println(fibbi(2000000L));
		System.out.println(Duration.between(start3, LocalTime.now()));
		//printTables(10);
	}
	
	private static long fibonacci(long n){
		return n<=1? n : (fibonacci(n-1)+fibonacci(n-2));
	}
	
	private static long fib(long n){
		if(n <= 1 || n == 5) return n;
		if(n <  5) return n-1;
		return 5*fib(n-3) - 2*fib(n-5);
	}
	
	private static long fibbi(long n){
		double root5 = Math.sqrt(5);
		double gr = (1 + root5) / 2;
		double igr = 1 - gr;
		double value = (Math.pow(gr, n) - Math.pow(igr, n)) / root5;

		return (long)Math.floor(value + 0.5); 
	}
	
/*	private static void printTables(int until){
		String format = "%3d ";
		System.out.print("   *| ");
		for(int i = 1; i <= until; i++){
			System.out.printf(format, i);
		}
		System.out.println("\n" + "-".repeat(4*(until+1)));
		for(int i = 1; i <= until; i++){
			System.out.printf(format + "| ", i);
			for(int j = 1; j <= 10; j++){
				System.out.printf(format, i*j);
			}
			System.out.println();
		}
	}*/
}
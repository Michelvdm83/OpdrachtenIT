import java.time.LocalTime;
import java.time.Duration;

public class Week5{
	public static void main(String[] args){
		LocalTime start1 = LocalTime.now();
		System.out.println(fibonacci(50L));
		System.out.println(Duration.between(start1, LocalTime.now()));
		LocalTime start2 = LocalTime.now();
		System.out.println(fib(50L));
		System.out.println(Duration.between(start2, LocalTime.now()));
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

// 0 1 1 2 3 5 8 13 21 34 55 89
//21 = 3*8-3 || 21 = 2*13-5 || 8 stappen, dus: 
//fib(8) = 21
//= 2* fib(7) - fib(5)
//= 3* fib(6) - fib(4)
//= 7* fib(4) - fib(0)
//= 5* fib(5) - 2*fib(3)
/*
fib(8) = 21 <3*n - 3>
== 		fib(7)		+ 		fib(6)
== fib(6) + fib(5) 	+ fib(5) + fib(4)
== 5 4		4 3			4 3		3 2
==4 3 3 2  3 2 2 1	  3 2 2 1  2 1 1
*/
//fib(7)=13 3*5-2 < 3*n - 8 
//5* fib(4) - 2* fib(2)
//15 - 2
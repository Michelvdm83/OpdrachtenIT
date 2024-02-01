import java.util.Scanner;

public class FahrenheitToCelcius{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter an temperature in Fahrenheit: ");
		float tempF = Float.parseFloat(in.nextLine().replace(",", "."));
		float tempC = (tempF - 32f)/1.8f;
		
		System.out.println(tempF + " in Celcius is: " + tempC);
	}
}

//subtract 32 and divide by 1.8
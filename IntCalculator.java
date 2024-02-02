import java.util.Scanner;

public class IntCalculator{
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args){
		int number = askForPositiveInt();
		int sumOfEven = sumEven(number);
		int sumOfOdd = sumOdd(number);
		
		System.out.println("Som van oneven getallen tot en met " + number + " is " + sumOfOdd);
		System.out.println("Som van even getallen tot en met " + number + " is " + sumOfEven);
		System.out.println("verschil tussen twee sommen is " + (sumOfOdd-sumOfEven));
	}
	
	private static int askForPositiveInt(){
		System.out.print("Geef een geheel positief getal: ");
		do{
			if(in.hasNextInt()){
				int number = in.nextInt();
				if(number >= 0){
					return number;
				}
			}
			System.out.println("Please enter a positive int");
			in.nextLine();
		}while(true);
	}

	private static int sumEven(int number){
		int returnInt = 0;
		for(int i = 0; i <= number; i+=2){
			returnInt += i;
		}
		return returnInt;
	}
	
	private static int sumOdd(int number){
		int returnInt = 0;
		for(int i = 1; i <= number; i+=2){
			returnInt += i;
		}
		return returnInt;
	}	
}
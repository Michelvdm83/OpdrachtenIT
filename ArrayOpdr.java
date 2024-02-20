import static generic.CommandLine.*;
import java.util.Arrays;

public class ArrayOpdr{
	private int NUM_ITEMS;
	
	public static void main(String[] args){
		ArrayOpdr test = new ArrayOpdr();
		test.run();
	}
	
	public void run(){
		NUM_ITEMS = askForInt("Voer het aantal items in: ");
		int[] inputList = askArray();
		System.out.println("De waarden zijn: " + Arrays.toString(inputList));
		printArray(inputList);
	}
	
	private int[] askArray(){
		do{
			String[] input = askForString("Voer de waarde van alle items in (gescheiden door spatie): ").split(" ");
			int[] returnArray = new int[input.length];
			returnArray[NUM_ITEMS-1] = -1;
			for(int i = 0; i < input.length; i++){
				try{
					returnArray[i] = Integer.parseInt(input[i]);
				}catch(NumberFormatException e){
					System.out.println("Geef alleen hele integer getallen op");
					break;
				}
			}
			if(!(returnArray[NUM_ITEMS-1] == -1)) return returnArray;
		}while(true);
	}
	
	private void printArray(int[] printMe){
		for(int i: printMe){
			System.out.println("*".repeat(i) + "(" + i + ")");
		}
	}
}

/*
Schrijf een programma met de naam PrintArray dat de gebruiker vraagt om het aantal items in een array (een niet-negatief geheel getal) 
en het opslaat in een int variable met de naam NUM_ITEMS. Vervolgens wordt de gebruiker gevraagd om de waarden van alle items 
en worden deze opgeslagen in een int array met de naam items. Het programma zal dan de inhoud van de array afdrukken 
in de vorm van [x1, x2, ..., xn]

Bonus:​

Laat het programma de inhoud van de array in een grafische vorm afdrukken, waarbij de waarden worden weergegeven door het aantal sterren​
*/
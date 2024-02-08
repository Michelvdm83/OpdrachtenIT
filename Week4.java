import java.util.Arrays;
import static generic.CommandLine.*;

public class Week4{
	public static void main(String[] args){
		int lucas = askForInt("geef een natuurlijk getal: ");
		printLucasRow(lucas);
		
		int a = 5;
		int b = 2;
		System.out.println(exponent(a,b));
		System.out.println(isOdd(b));
		System.out.println(isOdd(a));
		
		int[] test = new int[]{1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(test));
		int[] test2 = invert(test);
		System.out.println(Arrays.toString(test));
	}
	
	private static void printLucasRow(int nrOfNumbers){
		int[] lucasRow = getLucasRow(nrOfNumbers);
		if(lucasRow == null)return;
		System.out.printf("De eerst %d Lucas-getallen:%n", lucasRow.length);
		for(int i: lucasRow){
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	private static int[] getLucasRow(int nrOfNumbers){
		if(nrOfNumbers < 0){
			System.out.println("Getal negatief, fout");
			return null;
		}
		if(nrOfNumbers == 0) return new int[]{};
		if(nrOfNumbers < 3) return new int[]{nrOfNumbers == 1? 2 : 2, 1};
		
		int[] totalRow = new int[nrOfNumbers];
		totalRow[0] = 2;
		totalRow[1] = 1;
		for(int i = 2; i < totalRow.length; i++){
			totalRow[i] = totalRow[i-1] + totalRow[i-2];
			if(((long)totalRow[i] + totalRow[i-1]) > Integer.MAX_VALUE){
				System.out.println("Getal te groot, past niet");
				return null;
			}
		}
		return totalRow;
	}
	
	private static int exponent(int base, int exp){
		return (int)Math.pow(base, exp);
	}
	
	private static boolean isOdd(int number){
		return number%2 != 0;
	}
	
	public static int[] invert(int[] array) {
		
		for(int i = 0; i < array.length; i++) {
		array[i] *= -1;
		}

		return array;
	}
}

/*
2 1 3 4 7 11 18 …​

Het eerste Lucas-getal is 2, het tweede is 1. Daarna krijg je het volgende getal telkens door de twee voorgaande getallen bij elkaar op te tellen. 
In je programma moet je testen of het door de gebruiker ingetypte getal wel positief is. 
Verder kunnen de getallen van de Lucas-reeks zo groot worden dat ze niet meer passen in een int. ​

Bouw in je programma een test in, zodat bij een te grote waarde van n niets geprint wordt. ​

​*/
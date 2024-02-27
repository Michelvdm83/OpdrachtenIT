import static generic.CommandLine.*;
import java.util.LinkedHashMap;
import java.util.Collections;

public class Palindroom{
	private LinkedHashMap<Character, Integer> countList;
	
	public Palindroom(){
		countList = new LinkedHashMap<>();
		for(char c = 'a'; c <= 'z'; c++){
			countList.put(c, 0);
		}
		for(char c = '0'; c <= '9'; c++){
			countList.put(c, 0);
		}
		countList.put(' ', 0);
	}
	
	private void countAll(String original){
		for(char c: original.toLowerCase().toCharArray()){
			countList.put(c, countList.get(c)+1);
		}
	}
	
	public void run(){
		String input = askForString("Voer een String in: ");
		String reversed = reverseString(input).replace(" ", "");
		
		countAll(input);
		int totalCharacters = input.length();
		int nrOfWords = input.split(" ").length;
		int nrOfVowels = countList.get('a')+countList.get('e')+countList.get('i')+countList.get('o')+countList.get('u')+countList.get('y');
		boolean isPalindroom = reversed.equals(input.replace(" ", ""));
		
		System.out.printf("""
		Aantal karakters: %d
		Aantal woorden:   %d
		Aantal klinkers:  %d
		Palindroom?       %b
		""", totalCharacters, nrOfWords, nrOfVowels, isPalindroom);
		System.out.println("\n\n");
		
		int highestCount = Collections.max(countList.values());
		for(int currentCount = highestCount; currentCount >= 0; currentCount--){
			for(char c: countList.keySet()){
				if(currentCount > 0){
					System.out.print((countList.get(c)>=currentCount? "*" : " "));
				}else{
					System.out.print(c);
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		
		//System.out.println(input + " -> " + reversed);
		//if(reversed.equals(input)) System.out.println("Palindroom!");
	}
	
	public static void main(String[] args){
		Palindroom test = new Palindroom();
		test.run();
	}
	
	private String reverseString(String original){
		StringBuilder reversed = new StringBuilder();
		for(char c: original.toCharArray()){
			reversed.insert(0, c);
		}
		return reversed.toString();
	}
}
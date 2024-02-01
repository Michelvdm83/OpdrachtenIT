import java.util.Scanner;

public class CaesarsCode{
	private final static int MOVE = 3;
	
	public static void main(String[] args){
		System.out.print("Please enter a line of capital letters: ");
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		System.out.println(caesarThis(input));
	}
	
	private static String caesarThis(String original){
		String returnString = "";
		for(char c: original.toCharArray()){
			if(c + 3 > 'Z'){
				returnString += (char)(c-(26-MOVE));
			}else{
				returnString += (char)(c+MOVE);
			}
		}
		return returnString;
	}
}
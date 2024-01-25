
public class Auto{
	public static void main(String[] args){
		int age = (int)(Math.random() * 30);
		boolean licence = Math.random() > 0.5;
		System.out.printf("leeftijd: %d, rijbewijs: %b%n", age, licence);
		if(licence){
			if(age >= 18){
				System.out.println("Je mag rijden.");
			} else {
				System.out.println("Je mag onder begeleiding rijden");
			}
			String text = "Je mag " + ((age<18)? "onder begeleiding " : "") + "rijden";
			System.out.println(text);
		}else{
			System.out.println("Je mag niet rijden.");
		}
	}
}
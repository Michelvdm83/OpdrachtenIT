package lichtaan;

public class LichtAan{
	
	public LichtAan(){}
	
	
	public static void main(String[] args){
		boolean lichtIsAan;
		lichtIsAan = Math.random() > 0.5;
		if(lichtIsAan){
			System.out.println("Het licht is aan.");
		}
		else{
			System.out.println("Het licht is uit.");
		}
	}
}
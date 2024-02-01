import java.util.Scanner;

public class CalcSpeed{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("afstand in meters: ");
		int afstand = in.nextInt();
		
		System.out.print("aantal uren: ");
		int uren = in.nextInt();
		
		System.out.print("aantal minuten: ");
		int minuten = in.nextInt();
		
		System.out.print("aantal seconden: ");
		int seconden = in.nextInt();
		
		int totaalSeconden = seconden + (minuten*60) + (uren*60*60);
		float mPerS = afstand/totaalSeconden;
		
		float urenTotaal = totaalSeconden/3600.0f;
		float kmPerH = (afstand/1000.0f)/urenTotaal;
		float mijlPerH = (afstand/1609.0f)/urenTotaal;
		
		System.out.println("snelheid in m/s: " + mPerS);
		System.out.println("snelheid in km/h: " + kmPerH);
		System.out.println("snelheid in mijl/h: " + mijlPerH);
	}
}
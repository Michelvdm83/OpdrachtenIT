import java.util.Scanner;

public class CalcSpeed{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.print("afstand in meters: ");
		int distanceInMeters = in.nextInt();
		
		System.out.print("aantal uren: ");
		int hours = in.nextInt();
		
		System.out.print("aantal minuten: ");
		int minutes = in.nextInt();
		
		System.out.print("aantal seconden: ");
		int seconds = in.nextInt();
		
		int totalSeconds = seconds + (minutes*60) + (hours*60*60);
		Speed spd = new Speed(distanceInMeters, totalSeconds);
		double mPerS = (double)distanceInMeters/totalSeconds;
		
		System.out.printf("snelheid in m/s: %.4f%n", spd.getSpeedInMetersPerSecond());
		System.out.printf("snelheid in km/h: %.4f%n", spd.getSpeedInKilometersPerHour());
		System.out.printf("snelheid in mijl/h: %.4f%n", spd.getSpeedInMilesPerHour());
	}
}

class Speed{
	private int distanceInMeters;
	private int timeInSeconds;
	private double timeInHours;
	
	public Speed(int distanceInMeters, int timeInSeconds){
		this.distanceInMeters = distanceInMeters;
		this.timeInSeconds = timeInSeconds;
		timeInHours = timeInSeconds/3600.0;
	}
	
	public double getSpeedInMetersPerSecond(){
		return (double)distanceInMeters/timeInSeconds;
	}
	
	public double getSpeedInKilometersPerHour(){
		return (distanceInMeters/1000.0)/timeInHours;
	}
	
	public double getSpeedInMilesPerHour(){
		return (distanceInMeters/1609.0)/timeInHours;
	}
}
/*
Prints Hello, world!
Everyone's first program
*/
package helloworld;

import java.util.Scanner;
//import LichtAan.LichtAan;

public class HelloWorld{
    public static void main(String[] args){
        //just say Hello
        System.out.println("Hello, world!");
        if(args.length > 0){
            for(int i = 0; i < args.length; i++){
                System.out.println(args[i]);
            }
        }
		//LichtAan.main(args);
		
		System.out.println("In the following calculations is assumed a month has 28 days (which equals 4 weeks)");
		
		int years = askInt("Please enter the amount of years: ");
		int months = askInt("Please enter the amount of months: ");
		int weeks = askInt("Please enter the amount of weeks: ");
		int days = askInt("Please enter the amount of days: ");
		int hours = askInt("Please enter the amount of hours: ");
		
		if(hours >= 24){
			days += (hours/24);
			hours = hours%24;
		}
		if(days >= 7){
			weeks += (days/7);
			days = days%7;
		}
		if(weeks >= 4){
			months += (weeks/4);
			weeks = weeks%4;
		}
		if(months >= 12){
			years += (months/12);
			months = months%12;
		}
		
		short hoursAsMinutes = calculateHoursToMinutes(hours);
		short daysAsMinutes = calculateDaysToMinutes(days);
		int weeksAsMinutes = calculateWeeksToMinutes(weeks);
		int monthsAsMinutes = calculateMonthsToMinutes(months);
		int yearsAsMinutes = calculateYearsToMinutes(years);
		System.out.println(years + " years is " + yearsAsMinutes);
		System.out.println(months + " months is " + monthsAsMinutes);
		System.out.println(weeks + " weeks is " + weeksAsMinutes);
		System.out.println(days + " days is " + daysAsMinutes);
		System.out.println(hours + " hours is " + hoursAsMinutes);
		
		int total = hoursAsMinutes + daysAsMinutes + weeksAsMinutes + monthsAsMinutes + yearsAsMinutes;
		System.out.println("Total is: " + total);
    }
	
	private static int calculateYearsToMinutes(int years){
		return (years * calculateMonthsToMinutes(12));
	}
	
	private static int calculateMonthsToMinutes(int months){
		return (months * calculateWeeksToMinutes(4));
	}
	
	private static int calculateWeeksToMinutes(int weeks){
		return (weeks * calculateDaysToMinutes(7));
	}
	
	private static short calculateDaysToMinutes(int days){
		return (short)(calculateHoursToMinutes(days*24));
	}
	
	private static short calculateHoursToMinutes(int hours){
		return (short)(hours*60);
	}
	
	private static int askInt(String question){
		System.out.print(question);
		
		Scanner in = new Scanner(System.in);
		do{
			if(in.hasNextInt()){
				int returnInt = in.nextInt();
				in.nextLine();
				return returnInt;
			}else{
				in.nextLine();
				System.out.println("Not a number");
			}
		}while(true);
	}
}
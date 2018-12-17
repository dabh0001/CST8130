import java.util.Scanner;
/************************************************************************************************************
Purpose:  This class is the method main for Lab 1 
Author:  Linda Crane and xxxxxxxxxx
Course: F2018 - CST8130
Lab Section: xxxxxxxx



 *************************************************************************************************************/


public class Lab1 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner (System.in);
		DueDates dd = null;
		boolean isValid = false;
		String ask;
		int value=0;
		do{
			System.out.print("How many assessments in this course- must be greater than 0?");
			while (!isValid) {
				
				if (keyboard.hasNextInt()) {  // testing to see if what was entered is valid int
					value = keyboard.nextInt();
					if (value > 0) { // testing  for value > 0
						isValid = true;  // to end loop
						
					}
					else 
						System.out.println("Error – please reenter a valid value");
				}  
				else {
					System.out.println("Error – please reenter a valid value");
					keyboard.next();  // read past the “bad” value}}
				}
			}
			dd = new DueDates(value);
			System.out.println("Enter due dates:");
			dd.inputDueDates(keyboard);
			
			System.out.println("The due dates are :");
			System.out.println(dd);
			
			dd.addOne();
			
			System.out.println("The due dates with one day added are :");
			
			System.out.println(dd);
			System.out.print("Do another (y/n)?");
			ask=keyboard.next();
			isValid=false;
		}while(ask.charAt(0)=='y');
	}

}




import java.util.Scanner;


public class Magazine extends Resource{
	private MyDate edition = new MyDate();
	
	public Magazine() {
		
	}
	
	public String toString() {
		return " edition " + edition.toString() + " " + super.toString();
	}
	
	public boolean inputResource(Scanner in, MyDate today) {
		if (!super.inputResource(in, today))
			return false;
		
		System.out.print ("Enter the edition date: ");
		if (!edition.inputDate(in))
			return false;
		
		// due date for magazine is 7 days from "today"
		for (int i=0; i<7; i++)
			dueDate.addOne();
		
		// late cost is flat $1
		cost = 1.00f;
		
		
		return true;
	}

}




import java.util.Scanner;


public class Book extends Resource{
	private String author = new String();
	
	public Book() {
		
	}
	
	public String toString() {
		return " author " + author + " " + super.toString();
	}
	
	public boolean inputResource(Scanner in, MyDate today) {
		if (!super.inputResource(in, today))
			return false;
		
		System.out.print ("Enter the author name (no spaces): ");
		author = in.next();
		
		// due date for magazine is 14 days from "today"
		for (int i=0; i<14; i++)
			dueDate.addOne();
		
		// late cost is flat $2
		cost = 2.00f;
		
		
		return true;
	}

}

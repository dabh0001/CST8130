
import java.util.Scanner;


public class DVD extends Resource{
	private String type = new String();

	public DVD() {
	
		}

	public String toString() {
		return " type of DVD : " + type + " " + super.toString();
	}
	
	public boolean inputResource(Scanner in, MyDate today) {
		if (!super.inputResource(in, today))
			return false;
		
		System.out.print ("Enter the type of DVD (no spaces): ");
		type = in.next();
		
		// due date for DVD is 3 days from "today"
		for (int i=0; i<3; i++)
			dueDate.addOne();
		
		// late cost is flat $1
		cost = 1.00f;
		
		
		return true;
	}

}

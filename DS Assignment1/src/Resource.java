/**
 * Name : Aditya Dabhi
 * Student No : 040902920
 * Assignment Number 1
 * Date : 10/03/2018
 * Purpose of class : Fills the data members with valid data and returns true if the data is read successfully and false otherwise.
 */

import java.text.ParseException;
import java.util.Scanner;

public class Resource {

	protected String title;
	protected String borrower;
	protected MyDate dueDate;
	protected float overdueCost;

	public Resource() {

	}

	public boolean inputResource(Scanner in, MyDate myDate) throws ParseException {
		//title
		do {
			System.out.print("Enter title being borrowed: ");
			this.title = in.next();
		} while (this.title == null || this.title.trim().equals(""));

		//borrower
		do {
			System.out.print("Enter borrower name (no spaces):");
			this.borrower = in.next();
		} while (this.borrower == null || this.borrower.trim().equals(""));

		//dueDate
		this.dueDate = myDate;
		return true;
	}

	@Override
	public String toString() {
		return borrower + " has " + title + " due on " + dueDate + " and if late " + overdueCost;
	}

	public boolean isOverDue(MyDate today) throws ParseException {
		return dueDate.isGreaterThan(today);
	}

	public void displayOverDue() {
		System.out.println("Borrower name:" + this.borrower + " and Due Cost: " + overdueCost);
	}

}

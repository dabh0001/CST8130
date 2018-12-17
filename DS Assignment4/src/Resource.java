

import java.util.Scanner;

public class Resource {
	protected String title = new String();
	protected String borrower = new String();
	protected MyDate dueDate = new MyDate();
	protected float cost = 0.0f;

	public Resource() {
	}

	public String toString() {
		return borrower + " has " + title + " due on " + dueDate.toString() + " and if late " + cost + "\n";
	}

	public int calculateHash(int numResources) {
		int hash = 0;
		char grab[] = title.toCharArray();
		for (int i = 0; i < grab.length; i++) {
			
			hash = hash +  grab[i];
			
		}
		hash = hash % numResources;
		return hash;
	}

	public boolean inputResource(Scanner in, MyDate today) {
		cost = 0.0f;
		dueDate = new MyDate(today);

		System.out.print("Enter title being borrowed: ");
		title = in.next().toLowerCase();

		System.out.print("Enter borrower name (no spaces): ");
		borrower = in.next();

		return true;
	}

	public boolean isOverDue(MyDate todayDate) {
		return todayDate.isGreaterThan(dueDate);

	}

	public void displayOverDue() {
		System.out.print(" This resource is overdue...borrower owes " + "$" + cost);
	}

}

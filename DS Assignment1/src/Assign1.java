/**
 * Name : Aditya Dabhi
 * Student No : 040902920
 * Assignment Number 1
 * Date : 10/03/2018
 * Purpose of class : This class takes the input from the user and calls the methods to follow the user's instruction.
 */

import java.text.ParseException;
import java.util.Calendar;
import java.util.Scanner;

public class Assign1 {

	public static void main(String[] args) throws ParseException {
		Scanner input = new Scanner(System.in);
		Calendar calendar = Calendar.getInstance();
		Library library = new Library();
		MyDate todayDate = new MyDate(calendar.get(Calendar.DATE), (calendar.get(Calendar.MONTH) + 1), calendar.get(Calendar.YEAR));
		int choice = 0;

		//loop until user wants to quit
		do {
			System.out.println("\nEnter \n1 to add to resources borrowed,");
			System.out.println("2 to display overdue items,");
			System.out.println("3 to display all resources borrowed,");
			System.out.println("4 to delete a resource,");
			System.out.println("5 to change today date");
			System.out.println("6 to quit:");

			if (input.hasNextInt()) {
				choice = input.nextInt();
			} else {
				System.out.println("Invalid entry - prompted to reenter choice");
				input.next();
			}

			if (choice == 1) {
				library.inputResource(input, todayDate);
			} else if (choice == 2) {
				library.resourcesOverDue(todayDate);
			} else if (choice == 3) {
				library.toString();
			} else if (choice == 4) {
				library.deleteResource(input, todayDate);
			} else if (choice == 5) {
				todayDate = new MyDate();
				System.out.println("Enter a new date for today's date: ");
				todayDate.inputDate(input);
			} else if (choice == 6) {
				System.out.println("goodbye");
			} else if (choice < 1 || choice > 6) {
				System.out.println("Invalid entry - prompted to reenter choice");
			}
		} while (choice != 6);

	}

}

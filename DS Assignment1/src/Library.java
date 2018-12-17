/**
 * Name : Aditya Dabhi
 * Student No : 040902920
 * Assignment Number 1
 * Date : 10/03/2018
 * Purpose of class : Asks for the kind of resource to work on and returns the details of the resources as well.
 */

import java.text.ParseException;
import java.util.Scanner;

public class Library {

	private int max = 1;
	private Resource[] resourcesBorrowed;
	private int numResources;

	// Creates an array of 1000 Resources.
	public Library() {
		resourcesBorrowed = new Resource[max];
		numResources = 0;
	}

	// Checks the array for space and asks user for to input the resources.
	public void inputResource(Scanner in, MyDate myDate) throws ParseException {
		String resouceType = "";
		boolean isValidResourceType = false;
		if (numResources == max) {
			System.out.println("Error - array is full");
			return;
		}

		do {
			System.out.println("Enter type of resource being borrowed - D for DVD, M for Magazine and B for book: ");
			resouceType = in.next();
			Resource resource = null;
			if (resouceType.equalsIgnoreCase("B")) {
				resource = new Book();
				isValidResourceType = true;
			} else if (resouceType.equalsIgnoreCase("D")) {
				resource = new DVD();
				isValidResourceType = true;
			} else if (resouceType.equalsIgnoreCase("M")) {
				resource = new Magazine();
				isValidResourceType = true;
			}
			if (isValidResourceType) {
				resource.inputResource(in, myDate);
				resourcesBorrowed[numResources] = resource;
				numResources++;
			}
		} while (!isValidResourceType);
	}

	// returns the list of currently borrowed items.
	public String toString() {
		System.out.println("Items currently borrowed from library are:");
		if (numResources == 0) {
			System.out.println("No entries underneath");
			return "";
		}
		for (int i = 0; i < numResources; i++) {
			System.out.println((i + 1) + ":  " + resourcesBorrowed[i].toString());
		}
		return "";
	}

	// returns the list of currently borrowed items that are overdue.
	public String resourcesOverDue(MyDate today) throws ParseException {
		System.out.println("Items currently borrowed from library that are overdue as of  " + today + " are:");
		if (numResources == 0) {
			System.out.println("No entries underneath");
			return "";
		}
		for (int i = 0; i < numResources; i++) {
			Resource resource = resourcesBorrowed[i];
			if (resource.isOverDue(today)) {
				System.out.println((i + 1) + ":  " + resourcesBorrowed[i].toString());
			}
		}
		return "";
	}

	// delete the resource from the array
	public void deleteResource(Scanner in, MyDate todayDate) throws ParseException {
		int resourceNum = 0;
		if (numResources == 0) {
			System.out.println("No resources to delete");
			return;
		}
		System.out.println("List of resources checked out in the library: ");
		for (int i = 0; i < numResources; i++) {
			System.out.println("[" + (i + 1) + "]:  " + resourcesBorrowed[i].toString());
		}

		do {
			System.out.println("Which resource to delete: ");
			if (in.hasNextInt()) {
				resourceNum = in.nextInt();
			} else {
				System.out.println("Invalid resource number. Prompted to re-enter");
			}
		} while (resourceNum <= 0 || resourceNum > numResources);

		//swipe each element to position - 1
		Resource resource = resourcesBorrowed[resourceNum - 1];
		if (resource.isOverDue(todayDate)) {
			System.out.println("This resource is overdue - $" + resource.overdueCost + " is owed by borrower. Item is not deleted.");
		}
		for (int i = (resourceNum - 1); i < numResources; i++) {
			resourcesBorrowed[i] = resourcesBorrowed[i + 1];
		}

		//decrement count because one resource is removed
		numResources--;

		System.out.println("Item is deleted.");
	}

}

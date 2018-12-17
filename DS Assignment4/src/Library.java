

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Library {
	private ArrayList<LinkedList<Resource>> gather = new ArrayList();
	private Resource[] resourcesBorrowed = new Resource[1000];
	private int max = 1000;
	private int numResources = 0;

	public Library() {
		for (int i = 0; i < 1000; i++) {
			gather.add(i, new LinkedList<Resource>());
		}
		// note this defaults to 1000 by initialization if paramter max <= 0
	}
	
	public String toString() {
		String output = "\nItems currently borrowed from library are:\n";
		for (int i = 0; i < gather.size(); i++) {
			if (!gather.get(i).isEmpty()) {
				output += (i + 1) + ": " + gather.get(i).toString();
			}

		}

		return output;
	}

	public void inputResource(Scanner in, MyDate today) {
		String type = new String();

		char choice = 'k';
		while (!(choice == 'D' || choice == 'M' || choice == 'B')) {
			System.out.print("Enter type of resource being borrowed - D for DVD, M for Magazine and B for book:");
			choice = in.next().toUpperCase().charAt(0);
		}
		if (choice == 'D') {
			Resource temp = new DVD();
			temp.inputResource(in, today);
			gather.get(temp.calculateHash(gather.size())).add(temp);
			// resourcesBorrowed[numResources] = new DVD();
		} else if (choice == 'M') {
			Resource temp = new Magazine();
			temp.inputResource(in, today);
			gather.get(temp.calculateHash(gather.size())).add(temp);
			// resourcesBorrowed[numResources] = new Magazine();
		} else {
			Resource temp = new Book();
			temp.inputResource(in, today);
			gather.get(temp.calculateHash(gather.size())).add(temp);
			// resourcesBorrowed[numResources] = new Book();
		}

	}

	public String itemsOverDue(MyDate todayDate) {
		String output = "Items currently borrowed from library that are overdue as of " + todayDate.toString()
				+ " are:\n";
		for (int i = 0; i < gather.size(); i++) {
			if (!gather.get(i).isEmpty()) {

				if (gather.get(i).get(0).isOverDue(todayDate)) {
					output += (i + 1) + ": " + gather.get(i).get(0).toString();
				}

			}

		}

		return output;

	}

	public void deleteResource(Scanner in, MyDate today) {
		int i;
		for (i = 0; i < gather.size(); i++) {
			if (!gather.get(i).isEmpty()) {
				break;
			}

		}
		if (i == 1000) {
			System.out.println("no resources to delete");
			return;
		}

		System.out.println("List of resources checked out in the library: ");
		for (i = 0; i < gather.size(); i++) {
			if (!gather.get(i).isEmpty()) {
				System.out.println("[" + i + "]: " + gather.get(i).toString());
			}
		}

		System.out.println("Which resource to delete: ");
		int numToDelete = 0;
		boolean reEnter = true;
		do {
			if (in.hasNextInt()) {
				numToDelete = in.nextInt();
				if (numToDelete < 0 || numToDelete > gather.size()) {
					System.out.println("Invalid ...  please reenter number between 0 and " + numResources);
				} else
					reEnter = false;
			} else {
				System.out.println("Invalid...please reenter valid integer");
				in.next();
			}

		} while (reEnter);

		if (gather.get(numToDelete).isEmpty()) {
			System.out.println("Invalid Choice");
			return;
		}

		if (gather.get(numToDelete).get(0).isOverDue(today)) {
			gather.get(numToDelete).get(0).displayOverDue();
		}

		gather.get(numToDelete).clear();

	}

	public void search(Scanner s) {
		int i;
		for (i = 0; i < gather.size(); i++) {
			if (!gather.get(i).isEmpty()) {
				break;
			}

		}
		if (i == 1000) {
			System.out.println("no resources to search");
			return;
		}
		System.out.println ("Enter the title you're looking for");
		String a = s.next();
		for(int j =0; j<gather.size(); j++) {
			if(!gather.get(i).isEmpty()) {
				if(gather.get(i).get(0).title.equals(a)) {
					System.out.println(i +": " +gather.get(i));
					break;
				}
			}
		}

	}

}

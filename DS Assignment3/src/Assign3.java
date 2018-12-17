/**
 * 	Name: Aditya Dabhi
 * 	Date: 15/11/2018
 * 	Course: CST8130
 *  Section: 300
 * 	Purpose: Allowing user to select between all the options
 */
import java.util.Scanner;

/**
 * This project takes the input from user and make a block chain for Algonquin college for different courses
 * with course information. User can input good or bad block while adding the new blocks and can see all the
 * courses by displaying them.
 * 
 * @author adity
 *
 */
public class Assign3 {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		College college = new College("Algonquin");
		String menuChoice = "a";

		while (menuChoice.charAt(0) != '6') {

			System.out.println("\nEnter 1 to display the college courses: ");
			System.out.println("2 to add a new course: ");
			System.out.println("3 to add a block: ");
			System.out.println("4 to verify chain: ");
			System.out.println("5 to fix a chain: ");
			System.out.println("6 to quit: ");
			menuChoice = keyboard.next();

			switch (menuChoice.charAt(0)) {
			case '1':
				college.printChain();
				break;
			case '2':
				college.addNewCourse(keyboard);
				break;
			case '3':
				college.addNewBlock(keyboard);
				break;
			case '4':
				college.verifyChain();
				break;
			case '5':
				college.fixChain(keyboard);
				break;
			case '6':
				System.out.println("Goodbye");
				break;
			default:
				System.out.println("Invalid choice...");
			}
		}

	}

}

/**
 * 	Name: Aditya Dabhi
 * 	Date: 15/11/2018
 * 	Course: CST8130
 *  Section: 300
 * 	Purpose: This class works on users choice from the main class until user wants to exit out of the program.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class College {

	private ArrayList<CourseGrades> college;
	private String collegeName = "NotEntered";
	/**
	 * The constructor creates the arraylist.
	 */
	public College(String collegeName) {
		college = new ArrayList<>();
		this.collegeName = collegeName;

	}
	/**
	 * This method print the chain with all the information of all the courses and their blocks underneath.
	 */
	public void printChain() {
		System.out.println("For college: " + collegeName);
		//Loop over the linkedlist
		for (int i = 0; i < college.size(); i++) {
			college.get(i).printBlockChain();
		}
	}
	/**
	 * This method loop over the chain and verify if the chain has any bad block, and if any, prints that it's not verified.
	 */
	public void verifyChain() {
		if (college.isEmpty()) {
			System.out.println("There is no course present.");
			return;
		}
		for (int i = 0; i < college.size(); i++) {
			if (college.get(i).verifyChain()) {
				System.out.println("Chain for " + college.get(i).getCourseName() + " is verified");
			} else {
				System.out.println("Chain for " + college.get(i).getCourseName() + " is not verified");
			}
		}
	}
	/**
	 * This method creates the new course and add it to the chain.
	 * @param keyboard Taking input of the course name.
	 */
	public void addNewCourse(Scanner keyboard) {
		//Create new CourseGrades

		System.out.println("Enter name of course to add:");
		String courseName = keyboard.next();
		CourseGrades courseGrades = new CourseGrades(courseName);

		college.add(courseGrades);

	}
	/**
	 * This method adds a new bad or good block to the list.
	 * @param keyboard Takes the input 	  
	 */
	public void addNewBlock(Scanner keyboard) {
		if (college.isEmpty()) {
			System.out.println("There is no course present.");
			return;
		}
		int index = 0;
		do {
			System.out.println("Enter which course to add: ");
			for (int i = 0; i < college.size(); i++) {
				System.out.println(i + " " + college.get(i).getCourseName() + ": ");
			}

			if (keyboard.hasNextInt()) {
				index = keyboard.nextInt();
			} else {
				System.out.println("Invalid input.");
				keyboard.next();
			}
		} while (index < 0 || index > (college.size() - 1));

		System.out.println("Add good block or bad?  (g for good, anything else for bad):");
		String blockType = keyboard.next();

		if (blockType.equalsIgnoreCase("g")) {
			college.get(index).addBlock(keyboard);
		} else {
			college.get(index).addBadBlock(keyboard);
		}
	}
	/**
	 * The method fixes the chain by looping fixes the blocks by replacing the previous hash in the present block correctly with the
	 * current hash of the previous block.
	 * @param keyboard Takes the input for the course of which the block needs to be fixed.
	 */
	public void fixChain(Scanner keyboard) {
		if (college.isEmpty()) {
			System.out.println("There is no course present.");
			return;
		}
		int index = 0;
		do {
			System.out.println("Enter which course to fix: ");
			for (int i = 0; i < college.size(); i++) {
				System.out.println(i + " " + college.get(i).getCourseName() + ": ");
			}

			if (keyboard.hasNextInt()) {
				index = keyboard.nextInt();
			} else {
				System.out.println("Invalid input.");
				keyboard.next();
			}
		} while (index < 0 || index > (college.size() - 1));
		college.get(index).fixChain();

		System.out.println("Course is fixed");
	}

}

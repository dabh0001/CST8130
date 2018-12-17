/**
 * 	Name: Aditya Dabhi
 * 	Date: 15/11/2018
 * 	Course: CST8130
 *  Section: 300
 * 	Purpose: All the information of the block is fed here such as student number, grades and, previous and current hash.
 */
import java.util.Scanner;

public class Block {

	private MyDate date;  // part of data - in month day year format  (eg) 2152018
	private int studentNumber; // part of data
	private int grade;  // part of data
	private float previousHash;
	private float currentHash;
	/**
	 * Constructor provides the value to the variables.
	 */
	public Block() {
		// create the Genesis block
		date = new MyDate(15, 10, 2018);
		studentNumber = 0;
		grade = 100;
		previousHash = 0f;
		currentHash = calculateHash();

	}
	/**
	 * Calculates the hash.
	 * @return hash
	 */
	public float calculateHash() {
		return (date.toInt() + studentNumber + grade) / 88;
	}
	/**
	 * returns the information of the block.
	 */
	public String toString() {
		return "" + studentNumber + " " + grade + " " + date + " current: " + currentHash + " previous: " + previousHash;
	}
	/**
	 * returns the value of current hash.
	 * @return
	 */
	public float getCurrentHash() {
		return currentHash;
	}
	/**
	 * Checks if the hash is equal in current and previous block.
	 * @param temp particular block
	 * @return true if hash is same otherwise false.
	 */
	public boolean isEqual(Block temp) {
		return (previousHash == temp.currentHash);
	}
	/**
	 * Updates the value of the hash.
	 * @param prevHash returns the hash of previous block.
	 */
	public void updatePreviousHash(float prevHash) {
		previousHash = prevHash;
	}
	/**
	 * This method adds the information about the student to the block.
	 * @param keyboard Inputs for filing up the information of the student.
	 * @param previousHash hash of previous block.
	 * @return return true if the block is added successfully.
	 */
	public boolean addInfoToBlock(Scanner keyboard, float previousHash) {
		System.out.print("Enter date: ");
		date.inputDate(keyboard);

		System.out.print("Enter student number: ");
		while (!keyboard.hasNextInt()) {
			System.out.print("Invalid...enter an int for student number: ");
			keyboard.next();
		}
		studentNumber = keyboard.nextInt();

		System.out.println("Enter grade: ");
		while (!keyboard.hasNextInt()) {
			System.out.print("Invalid...enter an int for grade: ");
			keyboard.next();
		}
		grade = keyboard.nextInt();

		currentHash = calculateHash();
		this.previousHash = previousHash;
		return true;
	}

}

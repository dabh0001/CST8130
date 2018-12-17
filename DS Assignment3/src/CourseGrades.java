/**
 * 	Name: Aditya Dabhi
 * 	Date: 15/11/2018
 * 	Course: CST8130
 *  Section: 300
 * 	Purpose: This class is responsible for block related activities such as verifying the chain, adding good or bad block, etc.
 */
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class CourseGrades {

	private LinkedList<Block> blockChain;
	private String courseName = "NotEntered";
	/**
	 * Constructor creates the block using linkedlist and add a block to the blockchain.
	 * @param courseName The name of the course.
	 */
	public CourseGrades(String courseName) {
		blockChain = new LinkedList<>();
		blockChain.add(new Block());
		this.courseName = new String(courseName);
	}
	/**
	 * The method loops over the list and prints the chain.
	 */
	public void printBlockChain() {
		System.out.println("");
		System.out.println("For course: " + courseName);
		//Loop over the linkedlist
		System.out.println("[");
		for (int i = 0; i < blockChain.size(); i++) {
			System.out.print(blockChain.get(i).toString());
			System.out.println((i < (blockChain.size() - 1)) ? "," : "]");
		}
	}
	/**
	 * The method verifies the list and return true and false accordingly.
	 * @return true if chain is correct and false if not.
	 */
	public boolean verifyChain() {
		if (blockChain.size() > 1) {
			for (int i = 1; i < blockChain.size(); i++) {
				Block previousBlock = blockChain.get(i - 1);
				//Get next block and assign it to current
				Block currentBlock = blockChain.get(i);
				//Check if current blocks previousHash and 
				//previous block's currentHash is not same then its invalid chain
				if (!currentBlock.isEqual(previousBlock)) {
					return false;
				}
			}
		}
		//If all good then return true means valid chain
		return true;
	}
	/**
	 * This method adds a new good block.
	 * @param keyboard Input the information for the block.
	 */
	public void addBlock(Scanner keyboard) {
		//Create new block Object
		Block newOne = new Block();
		//Pass the last tail's Block tail's currentHash because it will added 
		//in newly added Block's previousHash. it means it will create block chain.

		float currentHashCode = (blockChain.size() > 0) ? blockChain.get(blockChain.size() - 1).getCurrentHash() : 0;
		if (newOne.addInfoToBlock(keyboard, currentHashCode)) {
			blockChain.add(newOne);
		}
	}
	/**
	 * This method adds the bad block.
	 * @param keyboard Input the information for the block.
	 */
	public void addBadBlock(Scanner keyboard) {
		Random random = new Random();
		Block newOne = new Block();
		if (newOne.addInfoToBlock(keyboard, random.nextFloat())) {
			blockChain.add(newOne);
		}

	}
	/**
	 * returns the course name.
	 * @return coursename
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * This method fixes the chain by correctly updating the hash of the bad block.
	 */
	public void fixChain() {
		if (blockChain.size() > 1) {
			for (int i = 1; i < blockChain.size(); i++) {
				Block previousBlock = blockChain.get(i - 1);
				//Get next block and assign it to current
				Block currentBlock = blockChain.get(i);
				//Check if current blocks previousHash and 
				//previous block's currentHash is not same then its invalid chain
				if (!currentBlock.isEqual(previousBlock)) {
					blockChain.remove(i);
					if (i < blockChain.size()) {
						blockChain.get(i).updatePreviousHash(previousBlock.getCurrentHash());
					}
					break;
				}
			}
		}
	}
}


import java.util.Random;
import java.util.Scanner;

public class BlockChain {

    private Block head = new Block(); // start the chain with the Genesis block
    private Block tail = head;
    private String courseName = "NotEntered";

    public BlockChain(String courseName) {
        this.courseName = new String(courseName);
    }

    public void printBlockChain() {
        System.out.println("Chain for CST8130");
        Block currentBlock = head;
        //Loop do while because need to iterate first loop
        //then check is last Block's next is null then stop loop
        do {
            System.out.println(currentBlock);
            //Get next block and assign it to current
            currentBlock = currentBlock.next();
        } while (currentBlock != null);
    }

    public boolean verifyChain() {
        Block previousBlock = head;
        do {
            if (previousBlock.next() != null) {
                //Get next block and assign it to current
                Block currentBlock = previousBlock.next();
                //Check if current blocks previousHash and 
                //previous block's currentHash is not same then its invalid chain
                if (!currentBlock.isEqual(previousBlock)) {
                    return false;
                }
                previousBlock = currentBlock;
            }
        } while (previousBlock.next() != null);
        //If all good then return true means valid chain
        return true;
    }

    public void addBlock(Scanner keyboard) {
        
        Block newOne = new Block();
        
        if (newOne.addInfoToBlock(keyboard, tail.getCurrentHash())) {
            
            tail.updateNext(newOne);
            tail = newOne;
        }
    }

    public void addBadBlock(Scanner keyboard) {
        Random random = new Random();
        Block newOne = new Block();
        if (newOne.addInfoToBlock(keyboard, random.nextFloat())) {
            // add to chain at tail
            tail.updateNext(newOne);
            tail = newOne;
        }

    }

}

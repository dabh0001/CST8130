
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;


public class Dictionary {
    
    private TreeMap<String, Integer> nodes;
    
    Dictionary() {
        nodes = new TreeMap<>();
    }
    
    void clearDictionary(Scanner input) {
        nodes.clear();
    }
    
    void readFromKeyboard(Scanner input) {
        System.out.println("Enter text to process:");
        while (input.hasNextLine()) {  // loop till end of file
            processData(input.nextLine());
        }
        System.out.println("asdasd");
    }
    
    public void readFromFile(Scanner input) {
        System.out.println("Enter name of file to process:");
        String fName = input.next();
        try {
            File file = new File(fName);
            if (file.exists()) {
                input = new Scanner(file);
                while (input.hasNext()) {  // loop till end of file
                    processData(input.next());
                    
                }
            } else {
                System.out.println("File does not exist");
            }
            
        } catch (IOException e) {
            System.out.println("Could not open file..." + fName + "exiting");
        }
    }
    
    void searchWordCount(Scanner input) {
        if (nodes.isEmpty()) {
            System.out.println("There is no node present: ");
            return;
        }
        System.out.println("Enter word to search for: ");
        String word = input.next();
        int count = nodes.get(word.toLowerCase());
        System.out.println("the occurs " + count + " times");
    }
    
    void numberOfNodes(Scanner input) {
        System.out.println("There are " + nodes.size() + " nodes");
        
    }
    
    private void processData(String input) {
        String word = input.replaceAll("[^A-Za-z]", "").toLowerCase();
        if (!word.trim().equals("")) {
            int count = 1;
            if (nodes.containsKey(word)) {
                count = nodes.get(word) + 1;
            }
            nodes.put(word, count);
        }
    }
}

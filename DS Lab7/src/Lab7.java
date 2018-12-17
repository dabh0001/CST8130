
import java.util.Calendar;
import java.util.Scanner;


public class Lab7 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Calendar calendar = Calendar.getInstance();
        Dictionary dictionary = new Dictionary();
        int choice;
        do {
            choice = 0;
            System.out.println("\nEnter \n1 to clear dictionary,");
            System.out.println("2 to text from keyboard,");
            System.out.println("3 to text from a file,");
            System.out.println("4 to search for a word count,");
            System.out.println("5 to display number of nodes");
            System.out.println("6 to quit:");

            if (input.hasNextInt()) {
                choice = input.nextInt();
            } else {
                System.out.println("Invalid entry: prompted to reenter choice");
                input.next();
            }

            switch (choice) {
                case 1:
                    dictionary.clearDictionary(input);
                    break;
                case 2:
                    dictionary.readFromKeyboard(input);
                    break;
                case 3:
                    dictionary.readFromFile(input);
                    break;
                case 4:
                    dictionary.searchWordCount(input);
                    break;
                case 5:
                    dictionary.numberOfNodes(input);
                    break;
                case 6:
                    System.out.println("goodbye");
                    break;
                default:
                    break;
            }
        } while (choice != 6);
    }

}

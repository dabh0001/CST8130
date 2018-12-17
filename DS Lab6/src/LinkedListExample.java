import java.util.Scanner;
public class LinkedListExample {

	public static void main(String[] args) {
		LList list = new LList();
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a String: ");
		String word = scanner.nextLine();
		int length=0;
		word=word.replaceAll("[^a-zA-Z0-9_-]", "");
		LLNode newWord;
		for(int i=0; i<word.length(); i++) {
			list.addAtHead(Character.toLowerCase(word.charAt(i)));
			length++;
		}
		
		for(int j=0; j<length;j++) {
			newWord=list.deleteAtHead();
		}
		
		
		
		LLNode removedOne = list.deleteAtHead();
		System.out.println("After delete, the list is ");
		list.display();
		System.out.println("The one deleted is..." + removedOne);
		
		

	}

}

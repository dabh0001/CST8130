import java.util.Scanner;
public class Palindrome
{
	public static void main(String[]args)
	{
		//For capturing user input
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a String: ");
		String string = scanner.nextLine();
		//For removing all the spaces from the String
		string=string.replaceAll("[^a-zA-Z0-9_-]", "");
		//checking if the String is palindrome
		if(testPalindrome(string))
			System.out.println(string + " is a palindrome");
		else
			System.out.println(string + " is not a palindrome");
	}

	public static boolean testPalindrome(String s)
	{   
		if(s.length() == 0 || s.length() == 1)
			return true; 
		//checking if the position of elements are equal for the string to be palindrome
		if(Character.toLowerCase(s.charAt(0)) == Character.toLowerCase(s.charAt(s.length()-1)))
			// calling the function recursively
			return testPalindrome(s.substring(1, s.length()-1));

	return false;

	}
}
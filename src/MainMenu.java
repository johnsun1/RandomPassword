import java.util.Scanner;

/**
 User interface to PasswordGenerator.java
 @author John Sun
 @version 1.0 1 May 2015
 */

public class MainMenu 
{
	
	public static void main(String [] args) 
	{
		boolean exit = false;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Welcome to the random password generator.");
		
		while (!exit) 
		{
			System.out.println("P - generate a random password | Q - quit");
			String choice = in.next();
			choice = choice.toUpperCase(); //to ensure menu will work if user inputs lower case letters
			
			System.out.println(""); //formatting
			
			if (choice.equals("P")) 
			{
				System.out.print("How many passwords to generate? (at least 1): ");
				int numPasswords = in.nextInt();

				System.out.print("How many words should each password be? (at least 1): ");
				int numWords = in.nextInt();

				System.out.println("Generating " + numPasswords + " passwords that are " + numWords + " words long (each).");

				for (int i = 0; i < numPasswords; i++) 
				{
					PasswordGenerator pass = new PasswordGenerator(numWords);
					System.out.println(pass.generatePass());
				}
				
				System.out.println(""); //formatting
			}
			else if (choice.equals("Q")) 
			{
				System.out.println("Thank you for using the random password generator.");
				exit = true;
			}
			else 
			{
				System.out.println("You have entered an invalid menu option.");
			}
		}
		in.close();
	}
}
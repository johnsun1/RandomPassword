import java.io.File;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 Generates a random password (xkcd style).
 Inspired by http://xkcd.com/936/
 @author John Sun
 @version 1.5 6 May 2015
 */

public class PasswordGenerator 
{
	private int numWords;
	private String password;
	private ArrayList<String> words;

	/**
	 Constructor
	 @param numWords number of words per password.
	 */
	public PasswordGenerator(int numWords) 
	{
		this.numWords = numWords;
		words = new ArrayList<String>();
		loadFile();
	}

	/**
	 Loads words from words.txt into ArrayList<String> words
	 */
	public void loadFile()
	{
		File wordBank = new File("words.txt");

		if (!wordBank.exists())
		{
			try
			{
				wordBank.createNewFile();
			}
			catch (Exception e)
			{
				System.out.println("Something went wrong when creating words.txt!");
			}
		}

		try 
		{
			Scanner input = new Scanner(new File("words.txt"));

			while (input.hasNextLine())
			{
				words.add(input.nextLine());
			}
			input.close();
		} 
		catch (Exception e) 
		{
			System.out.println("Something went wrong when loading words.txt!");
		}
	}

	/**
	 Generates a random integer from 0 to words.size() (to avoid out of bounds error).
	 @return a random integer from 0 to words.size().
	 */
	public int randomInteger() 
	{
		Random rand = new Random();
		return rand.nextInt(words.size());
	}

	/**
	 Generates a random password.
	 @return a random password.
	 */
	public String generatePass() 
	{
		password = "";
		if (words.size() > 0)
		{
			for (int i = 0; i < numWords; i++) 
			{
				password = password + words.get(randomInteger()) + " ";
			}
		}
		else
		{
			return "words.txt is empty therefore no passwords are generated.";
		}
		return password;
	}
}
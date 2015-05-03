import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 Generates a random password (xkcd style).
 Inspired by http://xkcd.com/936/
 @author John Sun
 @version 1.1 1 May 2015
 */

public class PasswordGenerator 
{
	private int numWords;
	private ArrayList<String> words;

	/**
	 Constructor
	 */
	public PasswordGenerator(int numWords) 
	{
		this.numWords = numWords;
		words = new ArrayList<String>();
		loadFile();
	}

	/**
	 Loads word bank from text file
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
				System.out.println("Something went wrong when creating words.txt");
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
			System.out.println("Something went wrong when loading words.txt");
			e.printStackTrace();
		}

	}

	/**
	 Generates a random integer from 0 to the length of the word bank (to avoid out of bounds error).
	 @return a random integer.
	 */
	public int randomInteger() 
	{
		return (int) (Math.random() * words.size());
	}

	/**
	 Generates a random password.
	 @return a random password.
	 */
	public String generatePass() 
	{
		String password = "";
		if (words.size() > 0)
		{
			for (int i = 0; i < numWords; i++) 
			{
				password += words.get(randomInteger()) + " ";
			}
		}
		else
		{
			return "words.txt is empty therefore no passwords are generated.";
		}
		return password;
	}

	/**
	 Accessor for numWords.
	 * @return number of words password is to have.
	 */
	public int getNumWords() 
	{
		return numWords;
	}
}

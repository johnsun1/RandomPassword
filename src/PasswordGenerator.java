import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Generates a random password (xkcd style). Inspired by http://xkcd.com/936/
 * 
 * @author John Sun
 * @version 2.0 9 May 2015
 */
public class PasswordGenerator {
	private String password;
	private ArrayList<String> words;
	private Random rand;

	/**
	 * Constructor
	 */
	public PasswordGenerator() {
		words = new ArrayList<String>();
		rand = new Random();
		loadFile();
	}

	/**
	 * Generates a random password. 
	 * @param numWords the number of words per password          
	 * @return a random password.
	 */
	public String generatePass(int numWords) {
		password = ""; // there must be a new password string every time generatePass is called.
		if (words.size() > 0) {
			for (int i = 0; i < numWords; i++) {
				password = password + words.get(randomInteger()) + " ";
			}
		} else {
			return "words.txt is empty therefore no passwords are generated.";
		}
		return password;
	}

	/**
	 * Loads words from words.txt into ArrayList<String> words
	 */
	public void loadFile() {
		File wordBank = new File("words.txt");

		if (!wordBank.exists()) {
			try {
				wordBank.createNewFile();
			} catch (Exception e) {
				System.out.println("Something went wrong when creating words.txt!");
			}
		}

		try {
			Scanner input = new Scanner(new File("words.txt"));

			while (input.hasNextLine()) {
				words.add(input.nextLine());
			}
			input.close();
		} catch (Exception e) {
			System.out.println("Something went wrong when loading words.txt!");
		}
	}

	/**
	 * Generates a random integer from 0 to words.size() (to avoid out of bounds error).
	 * @return a random integer from 0 to words.size().
	 */
	public int randomInteger() {
		return rand.nextInt(words.size());
	}
}
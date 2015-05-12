import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * User interface to PasswordGenerator.java
 * 
 * @author John Sun
 * @version 2.1 11 May 2015
 */
public class MainMenu {
	public static void main(String[] args) {
		PasswordGenerator pass = new PasswordGenerator();
		
		//master frame
		JFrame frame = new JFrame("Password Generator");
		frame.setLayout(new BorderLayout());
		frame.setSize(700, 200);

		//main menu
		JPanel panel = new JPanel();
		panel.setSize(200, 200);
		panel.setLayout(new GridLayout(3,2));
		
		//password results field
		JPanel panel1 = new JPanel();
		panel1.setSize(200, 200);
		panel1.setLayout(new BorderLayout());

		JLabel labelOne = new JLabel("Number of passwords: ");
		JTextField fieldOne = new JTextField();

		JLabel labelTwo = new JLabel("Number of words per password: ");
		JTextField fieldTwo = new JTextField();

		JTextArea textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);

		JButton button = new JButton("Go!");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {				
					int numPass = Integer.parseInt(fieldOne.getText());
					int numWords = Integer.parseInt(fieldTwo.getText());

					textArea.setText(pass.generatePass(numWords));
					textArea.append("\n"); // formatting

					//numPass-1 because one password is already added to the text area outside the loop
					for (int i = 0; i < numPass - 1; i++) {
						textArea.append(pass.generatePass(numWords));
						textArea.append("\n"); // formatting
					}
				} catch (NumberFormatException e) {
					textArea.setText("You have entered a value that is not a number.");
				}
			}
		});

		JButton button1 = new JButton("Reset");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textArea.setText("");
				fieldOne.setText("");
				fieldTwo.setText("");
			}
		});

		panel.add(labelOne);
		panel.add(fieldOne);
		panel.add(labelTwo);
		panel.add(fieldTwo);
		panel.add(button);
		panel.add(button1);
		panel1.add(scroll);

		frame.add(panel, BorderLayout.WEST);
		frame.add(panel1, BorderLayout.CENTER);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
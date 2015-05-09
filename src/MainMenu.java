import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * User interface to PasswordGenerator.java
 * 
 * @author John Sun
 * @version 2.0 9 May 2015
 */
public class MainMenu {
	public static void main(String[] args) {
		PasswordGenerator pass = new PasswordGenerator();
		JFrame frame = new JFrame("Password Generator");
		frame.setLayout(new GridLayout(3, 2));
		frame.setSize(400, 200);

		JFrame frame1 = new JFrame("Password Results");
		frame1.setSize(400, 200);

		JLabel labelOne = new JLabel("Number of passwords: ");
		JTextField fieldOne = new JTextField();

		JLabel labelTwo = new JLabel("Number of words per password: ");
		JTextField fieldTwo = new JTextField();

		JTextArea textArea = new JTextArea();
		JScrollPane scroll = new JScrollPane(textArea);
		frame1.add(scroll);

		JButton button = new JButton("Go!");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					frame1.setVisible(true);
					
					int numPass = Integer.parseInt(fieldOne.getText());
					int numWords = Integer.parseInt(fieldTwo.getText());

					textArea.setText(pass.generatePass(numWords));
					textArea.append("\n"); // formatting

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

		frame.add(labelOne);
		frame.add(fieldOne);
		frame.add(labelTwo);
		frame.add(fieldTwo);
		frame.add(button);
		frame.add(button1);

		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
/* This is a 10-question quiz based on the environment and how it is affected by computers, and it also includes some questions above how computers affect humans. This quiz utilises GUI.
 * Daniel Zhang
 * April 30, 2020
 */

/* Sources:
 * https://sciencing.com/laptops-affect-environment-23252.html
 * https://www.betterhealth.vic.gov.au/health/healthyliving/computer-related-injuries
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class QuizGUI extends JFrame implements ActionListener {
	// Home Panel
	int answerCounter = 0; // Counter to keep track of which question panel the GUI should display
	int correctCounter = 0; // Counter to keep track of the number of correct answers by the user
	final int TOTAL_MARKS = 10; // Constant for the total amount of marks

	// Declaration of panels, labels, textfield, and buttons in the home panel
	JPanel panel = new JPanel();
	JLabel firstLine = new JLabel("Welcome to the Environmental Computer Quiz!", JLabel.LEFT);
	JLabel secondLine = new JLabel ("In this quiz, you must answer 10 questions about computers affecting the human and natural environment.", JLabel.LEFT);
	JLabel thirdLine = new JLabel ("To begin, enter your name: ", JLabel.LEFT);
	JTextField nameField = new JTextField();
	JButton submitButton = new JButton("Submit"); // Submit button to submit the answer
	JButton endButton = new JButton("End Quiz"); // End button to terminate quiz and calculate score

	// Labels and combo box for Question 1 (Combo Box)
	JLabel question1Line1 = new JLabel("1. The average computer today weighs about 2.3 kilograms, but a lot of materials are used to create such a", JLabel.LEFT);
	JLabel question1Line2 = new JLabel("small device. This leads to a lot of chemicals and pollutants being released, which can be harmful to the", JLabel.LEFT);
	JLabel question1Line3 = new JLabel("environment. Compared to a single computer’s weight, how many times more heavy are the chemicals and", JLabel.LEFT);
	JLabel question1Line4 = new JLabel("pollutants used to create the computer?", JLabel.LEFT);
	JComboBox boxQuestion1 = new JComboBox();

	// Labels and radio buttons for Question 2 (Multiple Choice)
	JLabel question2Line1 = new JLabel("2. E-waste, or electronic waste, consists of mostly computers. A few million tons is created each year,", JLabel.LEFT);
	JLabel question2Line2 = new JLabel("and most of it is generated in Southeast and East Asia due to the large populations there. Which one", JLabel.LEFT);
	JLabel question2Line3 = new JLabel("of these Asian countries generates the most?", JLabel.LEFT);
	ButtonGroup question2ButtonGroup = new ButtonGroup();
	JRadioButton question2A = new JRadioButton("A) Phillipines");
	JRadioButton question2B = new JRadioButton("B) South Korea");
	JRadioButton question2C = new JRadioButton("C) China");
	JRadioButton question2D = new JRadioButton("D) Malaysia");

	// Labels and textfield for Question 3 (Type-in answer)
	JLabel question3Line1 = new JLabel("3. The", JLabel.LEFT);
	JLabel question3Line2 = new JLabel("in a computer contains toxic substances, and lead is found in circuit boards.", JLabel.LEFT);
	JLabel question3Line3 = new JLabel("When dumped into landfills, the toxic compounds can leach out and pollute groundwater. When computers are", JLabel.LEFT);
	JLabel question3Line4 = new JLabel("burned, the dangerous substances are released into the atmosphere and contaminate the incinerator ash.", JLabel.LEFT);
	JTextField question3TextField = new JTextField();

	// Labels and check boxes for Question 4 (Check Box Question)
	JLabel question4Line1 = new JLabel("4. Back and neck pain, headaches, and shoulder and arm pain are common computer-related injuries. Such muscle", JLabel.LEFT);
	JLabel question4Line2 = new JLabel("and joint problems can be caused or made worse by poor workstation (desk) design, bad posture and sitting for", JLabel.LEFT);
	JLabel question4Line3 = new JLabel("long periods of time. Choose all the methods that can prevent computer-related muscle and joint injuries.", JLabel.LEFT);
	JCheckBox question4A = new JCheckBox("Sit at an adjustable desk specially designed for use with computers");
	JCheckBox question4B = new JCheckBox("Have the computer monitor (screen) either at eye level or slightly lower");
	JCheckBox question4C = new JCheckBox("Have your keyboard at a height that lets your elbows rest comfortably at your sides");
	JCheckBox question4D = new JCheckBox("Use an ergonomic keyboard so that your hands and wrists are in a more natural position");
	JCheckBox question4E = new JCheckBox("All of the above");

	// Labels and check boxes for Question 5 (Check Box Question)
	JLabel question5Line1 = new JLabel("5. Focusing your eyes at the same distance point for long periods of time causes fatigue. The human eye structurally", JLabel.LEFT);
	JLabel question5Line2 = new JLabel("prefers to look at objects more than six metres away, so any work performed close up puts extra demands on your eye", JLabel.LEFT);
	JLabel question5Line3 = new JLabel("muscles. Select the measures that reduce eye strain from computer use.", JLabel.LEFT);
	JCheckBox question5A = new JCheckBox("Tilt the screen slightly to avoid reflections or glare");
	JCheckBox question5B = new JCheckBox("Make sure the screen is not too close to your face");
	JCheckBox question5C = new JCheckBox("Put the screen either at eye level or slightly lower");
	JCheckBox question5D = new JCheckBox("Reduce the contrast and brightness of your screen by adjusting the controls");
	JCheckBox question5E = new JCheckBox("All of the above");

	// Labels and radio buttons for Question 6 (Multiple Choice)
	JLabel question6Line1 = new JLabel("6. Proper or formal e-waste recycling usually involves disassembling the electronics, separating and categorizing the", JLabel.LEFT);
	JLabel question6Line2 = new JLabel("contents by material and cleaning them. Items are then shredded mechanically for further sorting with advanced", JLabel.LEFT);
	JLabel question6Line3 = new JLabel("separation technologies. Companies must adhere to health and safety rules and use pollution-control technologies", JLabel.LEFT);
	JLabel question6Line4 = new JLabel("that reduce the health and environmental hazards of handling e-waste. If you live in Richmond Hill, where would be", JLabel.LEFT);
	JLabel question6Line5 = new JLabel("the closest place for you to safely dispose of your computer?");
	ButtonGroup question6ButtonGroup = new ButtonGroup();
	JRadioButton question6A = new JRadioButton("A) Your blue \"Richmond Hill\" recycling bin");
	JRadioButton question6B = new JRadioButton("B) Elgin Mills Community Environmental Centre");
	JRadioButton question6C = new JRadioButton("C) Markham Household Hazardous Waste Depot");
	JRadioButton question6D = new JRadioButton("D) Vaughan Household Hazardous Waste Depot");

	// Labels and radio buttons for Question 7 (Multiple Choice)
	JLabel question7Line1 = new JLabel("7. Electronic devices also comprise toxic heavy metals like lead, mercury, cadmium and beryllium, polluting PVC plastic,", JLabel.LEFT);
	JLabel question7Line2 = new JLabel("and hazardous chemicals, such as brominated flame retardants, which can harm human health and the environment. As", JLabel.LEFT);
	JLabel question7Line3 = new JLabel("more people buy electronic equipment, manufacturers are beginning to face shortages of the raw materials needed to", JLabel.LEFT);
	JLabel question7Line4 = new JLabel("make their products, so reclaiming and reusing the materials from discarded products and waste, a process called", JLabel.LEFT);
	JLabel question7Line5 = new JLabel("_____________, makes economic and environmental sense.");
	ButtonGroup question7ButtonGroup = new ButtonGroup();
	JRadioButton question7A = new JRadioButton("Computer mining");
	JRadioButton question7B = new JRadioButton("Strip mining");
	JRadioButton question7C = new JRadioButton("Electronics mining");
	JRadioButton question7D = new JRadioButton("Urban mining");

	// Labels and combo box for Question 8 (Combo Box)
	JLabel question8Line1 = new JLabel("8. When using a computer, most people rely on their whole body to perform various tasks on computers, such as typing and", JLabel.LEFT);
	JLabel question8Line2 = new JLabel("moving the mouse around. Doing these actions over and over again can be repetitive, and in the long-term, it could damage", JLabel.LEFT);
	JLabel question8Line3 = new JLabel("your muscles, tendons, back, and neck. What is this type of injury called?", JLabel.LEFT);
	JComboBox boxQuestion8 = new JComboBox();

	// Labels and checkboxes for Question 9 (Check Box Question)
	JLabel question9Line1 = new JLabel("9. Heavy metals are known to be very dense and are toxic in small concentrations. Unfortunately, they are", JLabel.LEFT);
	JLabel question9Line2 = new JLabel("used in computers to create several important parts, such as the circuit board, the CPU, and the", JLabel.LEFT);
	JLabel question9Line3 = new JLabel("motherboard, because they are excellent conductors. Which of these metals are found inside computers?", JLabel.LEFT);
	JLabel question9Line4 = new JLabel("(Choose all answers that apply)");
	JCheckBox question9A = new JCheckBox("Lead");
	JCheckBox question9B = new JCheckBox("Gold");
	JCheckBox question9C = new JCheckBox("Lithium");
	JCheckBox question9D = new JCheckBox("All of the above");

	// Labels and checkboxes for Question 10 (Check box Question)
	JLabel question10Line1 = new JLabel("10. With the flood of e-waste growing around the world, recycling alone will not be enough. Please choose all solutions below", JLabel.LEFT);
	JLabel question10Line2 = new JLabel("that are being practiced around the world and inspire more adoption of best practices.", JLabel.LEFT);
	JCheckBox question10A = new JCheckBox("Designing better products: manufacturers need to design electronics");
	JCheckBox question10B = new JCheckBox("The right to repair: in addition to recycling, it’s also important to be able to repair and reuse the devices we have");
	JCheckBox question10C = new JCheckBox("Extended Producer Responsibility: Companies make products that are safer, and more durable, repairable and recyclable");
	JCheckBox question10D = new JCheckBox("Better recycling: the best and only large-scale recycling being done today uses a copper smelter in Canada");
	JCheckBox question10E = new JCheckBox("All of the above");

	// Labels for the Last Panel
	JLabel finalPanelLine1 = new JLabel("", JLabel.LEFT);
	JLabel finalPanelLine2 = new JLabel("", JLabel.LEFT);
	JLabel finalPanelLine3 = new JLabel("", JLabel.LEFT);

	// Constructor
	public QuizGUI () {
		// Home Panel Additions
		super("Environmental Computer Quiz");
		setVisible(true);
		setSize(800, 600);
		panel.setLayout(null);
		add(panel);

		panel.add(firstLine);
		panel.add(secondLine);
		panel.add(thirdLine);
		panel.add(nameField);
		panel.add(submitButton);
		firstLine.setBounds(270, 150, 400, 40);
		secondLine.setBounds(100, 180, 700, 40);
		thirdLine.setBounds(215, 210, 200, 40);
		nameField.setBounds(370, 222, 200, 20);
		submitButton.setBounds(350, 510, 80, 40);
		endButton.setBounds(675, 510, 90, 40);
		submitButton.addActionListener(this);
		endButton.addActionListener(this);

		// Question 1 Additions
		boxQuestion1.addItem("");
		boxQuestion1.addItem("5x");
		boxQuestion1.addItem("10x");
		boxQuestion1.addItem("15x");
		boxQuestion1.addItem("20x");

		// Question 8 Additions
		boxQuestion8.addItem("");
		boxQuestion8.addItem("Repetitive Strain Injury (RSI)");
		boxQuestion8.addItem("Posterior Cervical Dorsal Syndrome (PCDS)");
		boxQuestion8.addItem("Carpal Tunnel Syndrome (CTS)");
		boxQuestion8.addItem("Mouse Arm Syndrome (MAS)");
	}

	// Action Listener
	public void actionPerformed (ActionEvent event) {
		// If the end button is clicked, automatically go to the last panel and calculate score
		if (event.getSource() == endButton) {
			clearPanel(panel); // Clear the panel

			// Home Panel Components
			panel.add(finalPanelLine1);
			panel.add(finalPanelLine2);
			panel.add(finalPanelLine3);
			finalPanelLine1.setBounds(150, 150, 600, 40);
			finalPanelLine2.setBounds(290, 190, 700, 40);
			finalPanelLine3.setBounds(295, 230, 200, 40);
			String finalName = nameField.getText();
			String finalLine1 = "Congratulations, " + finalName + "! You have completed the Environmental Computer Quiz!";
			String finalLine2 = "Here are your results from the quiz: ";
			String finalLine3 = correctCounter + "/" + TOTAL_MARKS + " correct questions = " + (correctCounter * 10) + "%";
			finalPanelLine1.setText(finalLine1);
			finalPanelLine2.setText(finalLine2);
			finalPanelLine3.setText(finalLine3);
		}
		// Otherwise, continue with the quiz
		// If the submit button is pressed, add one to the answerCounter
		if (event.getSource() == submitButton) {
			answerCounter++;
			if (answerCounter == 1) {
				// Question 1 Components
				clearPanel(panel);
				panel.add(question1Line1);
				panel.add(question1Line2);
				panel.add(question1Line3);
				panel.add(question1Line4);
				panel.add(boxQuestion1);
				panel.add(submitButton);
				panel.add(endButton);
				question1Line1.setBounds(60, 90, 800, 40);
				question1Line2.setBounds(75, 130, 800, 40);
				question1Line3.setBounds(75, 170, 800, 40);
				question1Line4.setBounds(75, 210, 800, 40);
				boxQuestion1.setBounds(320, 220, 50, 20);
			}

			// Checking if Question 1 answer is correct
			else if (answerCounter == 2) {
				// If the answer is correct, display correct message and add one to the correctCounter
				String question1Answer = (String) (boxQuestion1.getSelectedItem());
				if (question1Answer.equals("10x")) {
					JOptionPane.showMessageDialog(null, "Correct!");
					correctCounter++;
				}
				else
					// Otherwise, display incorrect message
					JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is 10x.");
				clearPanel(panel);

				// Question 2 Components
				panel.add(question2Line1);
				panel.add(question2Line2);
				panel.add(question2Line3);
				panel.add(question2A);
				panel.add(question2B);
				panel.add(question2C);
				panel.add(question2D);
				panel.add(submitButton);
				panel.add(endButton);
				question2ButtonGroup.add(question2A);
				question2ButtonGroup.add(question2B);
				question2ButtonGroup.add(question2C);
				question2ButtonGroup.add(question2D);
				question2Line1.setBounds(60, 90, 800, 40);
				question2Line2.setBounds(75, 130, 800, 40);
				question2Line3.setBounds(75, 170, 800, 40);
				question2A.setBounds(150, 210, 200, 40);
				question2B.setBounds(150, 250, 200, 40);
				question2C.setBounds(150, 290, 200, 40);
				question2D.setBounds(150, 330, 200, 40);
			}
			// Checking if Question 2 answer is correct
			else if (answerCounter == 3) {
				// If the answer is correct, display correct message and add one to the correctCounter
				if (question2C.isSelected()) {
					JOptionPane.showMessageDialog(null, "Correct!");
					correctCounter++;
				}
				// Otherwise, display incorrect message
				else
					JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is C)");
				clearPanel(panel);
				// Question 3 Components
				panel.add(question3Line1);
				panel.add(question3Line2);
				panel.add(question3Line3);
				panel.add(question3Line4);
				panel.add(question3TextField);
				panel.add(submitButton);
				panel.add(endButton);
				question3Line1.setBounds(60, 90, 800, 40);
				question3Line2.setBounds(300, 90, 800, 40);
				question3Line3.setBounds(75, 130, 800, 40);
				question3Line4.setBounds(75, 170, 800, 40);
				question3TextField.setBounds(100, 100, 190, 20);
			}
			// Checking if Question 3 answer is correct
			else if (answerCounter == 4) {
				// If the answer is correct, display correct message and add one to the correctCounter
				String question3Answer = question3TextField.getText();
				if (question3Answer.equalsIgnoreCase("CPU") || question3Answer.equalsIgnoreCase("Central Processing Unit")) {
					JOptionPane.showMessageDialog(null, "Correct!");
					correctCounter++;
				}
				// Otherwise, display incorrect message
				else
					JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is CPU or Central Processing Unit.");
				clearPanel(panel);
				// Question 4 Components
				panel.add(question4Line1);
				panel.add(question4Line2);
				panel.add(question4Line3);
				panel.add(submitButton);
				panel.add(endButton);
				panel.add(question4A);
				panel.add(question4B);
				panel.add(question4C);
				panel.add(question4D);
				panel.add(question4E);
				question4Line1.setBounds(60, 90, 800, 40);
				question4Line2.setBounds(75, 130, 800, 40);
				question4Line3.setBounds(75, 170, 800, 40);
				question4A.setBounds(150, 220, 800, 40);
				question4B.setBounds(150, 260, 800, 40);
				question4C.setBounds(150, 300, 800, 40);
				question4D.setBounds(150, 340, 800, 40);
				question4E.setBounds(150, 380, 800, 40);
			}
			// Checking if Question 4 answer is correct
			else if (answerCounter == 5) {
				// If the answer is correct, display correct message and add one to the correctCounter
				if ((question4E.isSelected()) || (question4A.isSelected() && question4B.isSelected() && question4C.isSelected() && question4D.isSelected())) {
					JOptionPane.showMessageDialog(null, "Correct!");
					correctCounter++;
				}
				// Otherwise, display incorrect message
				else
					JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is all first 4 options, or the last option.");
				clearPanel(panel);
				// Question 5 Components
				panel.add(question5Line1);
				panel.add(question5Line2);
				panel.add(question5Line3);
				panel.add(question5A);
				panel.add(question5B);
				panel.add(question5C);
				panel.add(question5D);
				panel.add(question5E);
				panel.add(submitButton);
				panel.add(endButton);
				question5Line1.setBounds(60, 90, 800, 40);
				question5Line2.setBounds(75, 130, 800, 40);
				question5Line3.setBounds(75, 170, 800, 40);
				question5A.setBounds(150, 220, 800, 40);
				question5B.setBounds(150, 260, 800, 40);
				question5C.setBounds(150, 300, 800, 40);
				question5D.setBounds(150, 340, 800, 40);
				question5E.setBounds(150, 380, 800, 40);
			}
			// Checking if Question 5 answer is correct
			else if (answerCounter == 6) {
				// If the answer is correct, display correct message and add one to the correctCounter
				if ((question5E.isSelected()) || (question5A.isSelected() && question5B.isSelected() && question5C.isSelected() && question5D.isSelected())) {
					JOptionPane.showMessageDialog(null, "Correct!");
					correctCounter++;
				}
				// Otherwise, display incorrect message
				else
					JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is all first 4 options, or the last option.");
				clearPanel(panel);
				// Question 6 Components
				panel.add(question6Line1);
				panel.add(question6Line2);
				panel.add(question6Line3);
				panel.add(question6Line4);
				panel.add(question6Line5);
				panel.add(question6A);
				panel.add(question6B);
				panel.add(question6C);
				panel.add(question6D);
				panel.add(submitButton);
				panel.add(endButton);
				question6ButtonGroup.add(question6A);
				question6ButtonGroup.add(question6B);
				question6ButtonGroup.add(question6C);
				question6ButtonGroup.add(question6D);
				question6Line1.setBounds(60, 90, 800, 40);
				question6Line2.setBounds(75, 130, 800, 40);
				question6Line3.setBounds(75, 170, 800, 40);
				question6Line4.setBounds(75, 210, 800, 40);
				question6Line5.setBounds(75, 250, 800, 40);
				question6A.setBounds(150, 300, 800, 40);
				question6B.setBounds(150, 340, 800, 40);
				question6C.setBounds(150, 380, 800, 40);
				question6D.setBounds(150, 420, 800, 40);
			}
			// Checking if Question 6 answer is correct
			else if (answerCounter == 7) {
				// If the answer is correct, display correct message and add one to the correctCounter
				if (question6B.isSelected()) {
					JOptionPane.showMessageDialog(null, "Correct!");
					correctCounter++;
				}
				// Otherwise, display incorrect message
				else
					JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is B)");
				clearPanel(panel);
				// Question 7 Components
				panel.add(question7Line1);
				panel.add(question7Line2);
				panel.add(question7Line3);
				panel.add(question7Line4);
				panel.add(question7Line5);
				panel.add(question7A);
				panel.add(question7B);
				panel.add(question7C);
				panel.add(question7D);
				panel.add(submitButton);
				panel.add(endButton);
				question7ButtonGroup.add(question7A);
				question7ButtonGroup.add(question7B);
				question7ButtonGroup.add(question7C);
				question7ButtonGroup.add(question7D);
				question7Line1.setBounds(60, 90, 800, 40);
				question7Line2.setBounds(75, 130, 800, 40);
				question7Line3.setBounds(75, 170, 800, 40);
				question7Line4.setBounds(75, 210, 800, 40);
				question7Line5.setBounds(75, 250, 800, 40);
				question7A.setBounds(150, 300, 800, 40);
				question7B.setBounds(150, 340, 800, 40);
				question7C.setBounds(150, 380, 800, 40);
				question7D.setBounds(150, 420, 800, 40);
			}
			// Checking if Question 7 answer is correct
			else if (answerCounter == 8) {
				// If the answer is correct, display correct message and add one to the correctCounter
				if (question7D.isSelected()) {
					JOptionPane.showMessageDialog(null, "Correct!");
					correctCounter++;
				}
				// Otherwise, display incorrect message
				else
					JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is A)");
				clearPanel(panel);
				// Question 8 Components
				panel.add(question8Line1);
				panel.add(question8Line2);
				panel.add(question8Line3);
				panel.add(boxQuestion8);
				panel.add(submitButton);
				panel.add(endButton);
				question8Line1.setBounds(60, 90, 800, 40);
				question8Line2.setBounds(75, 130, 800, 40);
				question8Line3.setBounds(75, 170, 800, 40);
				boxQuestion8.setBounds(75, 210, 300, 20);
			}
			// Checking if Question 8 answer is correct
			else if (answerCounter == 9) {
				String question8Answer = (String) (boxQuestion8.getSelectedItem());
				if (question8Answer.equals("Repetitive Strain Injury (RSI)")) {
					JOptionPane.showMessageDialog(null, "Correct!");
					correctCounter++;
				}
				// Otherwise, display incorrect message
				else
					JOptionPane.showMessageDialog(null, "Incorrect. The correct answers is Repetitive Strain Injury (RSI)");
				clearPanel(panel);
				// Question 9 Components
				panel.add(question9Line1);
				panel.add(question9Line2);
				panel.add(question9Line3);
				panel.add(question9Line4);
				panel.add(question9A);
				panel.add(question9B);
				panel.add(question9C);
				panel.add(question9D);
				panel.add(submitButton);
				panel.add(endButton);
				question9Line1.setBounds(60, 90, 800, 40);
				question9Line2.setBounds(75, 130, 800, 40);
				question9Line3.setBounds(75, 170, 800, 40);
				question9A.setBounds(150, 220, 800, 40);
				question9B.setBounds(150, 260, 800, 40);
				question9C.setBounds(150, 300, 800, 40);
				question9D.setBounds(150, 340, 800, 40);
			}
			// Checking if Question 9 answer is correct
			else if (answerCounter == 10) {
				// If the answer is correct, display correct message and add one to the correctCounter
				if (question9D.isSelected() || (question9A.isSelected() && question9B.isSelected() && question9C.isSelected())) {
					JOptionPane.showMessageDialog(null, "Correct!");
					correctCounter++;
				}
				// Otherwise, display incorrect message
				else
					JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is all first three options or the last option");
				clearPanel(panel);
				// Question 10 Components
				panel.add(question10Line1);
				panel.add(question10Line2);
				panel.add(question10A);
				panel.add(question10B);
				panel.add(question10C);
				panel.add(question10D);
				panel.add(question10E);
				panel.add(submitButton);
				panel.add(endButton);
				question10Line1.setBounds(60, 90, 800, 40);
				question10Line2.setBounds(75, 130, 800, 40);
				question10A.setBounds(50, 200, 800, 40);
				question10B.setBounds(50, 240, 800, 40);
				question10C.setBounds(50, 280, 800, 40);
				question10D.setBounds(50, 320, 800, 40);
				question10E.setBounds(50, 360, 800, 40);
			}
			// Checking if Question 10 answer is correct
			else if (answerCounter == 11) {
				// If the answer is correct, display correct message and add one to the correctCounter
				if (question10E.isSelected() || (question10A.isSelected() && question10B.isSelected() && question10C.isSelected() && question10D.isSelected())) {
					JOptionPane.showMessageDialog(null, "Correct!");
					correctCounter++;
				}
				// Otherwise, display incorrect message
				else
					JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is all first four options or the last option.");
				clearPanel(panel);
				// Final Panel Components
				panel.add(finalPanelLine1);
				panel.add(finalPanelLine2);
				panel.add(finalPanelLine3);
				finalPanelLine1.setBounds(150, 150, 600, 40);
				finalPanelLine2.setBounds(290, 190, 700, 40);
				finalPanelLine3.setBounds(295, 230, 200, 40);
				String finalName = nameField.getText();
				String finalLine1 = "Congratulations, " + finalName + "! You have completed the Environmental Computer Quiz!";
				String finalLine2 = "Here are your results from the quiz: ";
				String finalLine3 = correctCounter + "/" + TOTAL_MARKS + " correct questions = " + (correctCounter * 10) + "%";
				finalPanelLine1.setText(finalLine1);
				finalPanelLine2.setText(finalLine2);
				finalPanelLine3.setText(finalLine3);
			}
		}
	}

	/* Method to clear the panel in preparation for the next question
	 * @param the GUI panel to clear
	 */
	public static void clearPanel (JPanel panel) {
		panel.removeAll();
		panel.repaint();
		panel.revalidate();
	}

	public static void main(String[] args) {
		QuizGUI frame = new QuizGUI();
	}
}

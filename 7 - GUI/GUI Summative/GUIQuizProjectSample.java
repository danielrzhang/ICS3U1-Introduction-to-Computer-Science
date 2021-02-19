/**GUI QUIZ PROJECT SAMEPLE
 * with JButton,JTextField,JLabel,JComboBox,JRadioButton NO Layout
 * Ms. Stretten April 23, 2020
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class GUIQuizProjectSample extends JFrame implements ActionListener{
	JPanel panel = new JPanel();
	JTextField nameField = new JTextField (40);
	JLabel nameLabel = new JLabel ("<html>Enter your name: <html>",JLabel.LEFT);
	JLabel quizIntro = new JLabel ("<html>Computer Technology Quiz<html>", JLabel.LEFT);
	JButton nextButton = new JButton ("Next");
	private int counter = -1;
	JLabel Question1 = new JLabel("<html> 1) What is the circuit board that everything in the computer plugs into?</html>", JLabel.CENTER);
	ButtonGroup Q1ButtonGroup = new ButtonGroup();
	JRadioButton Q1A = new JRadioButton ("A) Motherboard");
	JRadioButton Q1B = new JRadioButton("B) Printed Circuit Board");
	JRadioButton Q1C = new JRadioButton("C) Network Card");
	JRadioButton Q1D = new JRadioButton("D) Graphics Card");
	JLabel Q2Label = new JLabel ("</html>2) The heart (and brains) of the computer is the _______.<html>", JLabel.LEFT);
	JTextField Q2TextField = new JTextField();
	JLabel Q3Label = new JLabel("<html>3) The instructions that tell the computer what to do and how to do it:</html>", JLabel.LEFT);
	JComboBox Q3 = new JComboBox();
	JLabel lastPage = new JLabel ("", JLabel.LEFT);

	//CONTRUCTOR
	public GUIQuizProjectSample(){
		super ("GUI QUIZ SAMPLE PROJECT");
		setVisible(true);
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(null);
		add(panel);
		panel.add(quizIntro);
		quizIntro.setBounds(110, 100, 300, 25);
		panel.add(nameLabel);
		nameLabel.setBounds(125, 150, 100, 20);
		panel.add(nameField);
		nameField.setBounds (100, 200, 150, 30);
		Q3.addItem ("Hardware");
		Q3.addItem("Printer");
		Q3.addItem("Software");
		Q3.addItem("Monitor");
		panel.add(nextButton);
		nextButton.setBounds(350,350,100,30);
		nextButton.addActionListener(this);
	}
	//******ACTION LISTENER ********
	public void actionPerformed(ActionEvent event){
		if (event.getSource () == nextButton){
			counter = counter +1; //counts the number of mouse clicks
			if (counter ==0){
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				//Components of Questions#1
				panel.add(Question1);
				Question1.setBounds(27, 80, 400, 25);
				Q1ButtonGroup.add(Q1A);
				Q1ButtonGroup.add(Q1B);
				Q1ButtonGroup.add(Q1C);
				Q1ButtonGroup.add(Q1D);
				panel.add(Q1A);
				Q1A.setBounds (27, 120, 180, 25);
				panel.add(Q1B);
				Q1B.setBounds(27, 180, 130, 25);
				panel.add(Q1C);
				Q1C.setBounds(27, 240, 150, 25);
				panel.add(Q1D);
				Q1D.setBounds(27, 300, 220, 25);
				panel.add(nextButton);
				nextButton.addActionListener(this);
			}

			if (counter == 2){
				//Answer to previous Question
				if (Q1A.isSelected())
					JOptionPane.showMessageDialog(null, "Correct");
				else
					JOptionPane.showMessageDialog(null, "Wrong. The answer is Motherboard");
				//Clear panel
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				//Components of Question #2
				panel.add(Q2Label);
				Q2Label.setBounds (30, 53, 500, 50);
				panel.add(Q2TextField);
				Q2TextField.setBounds(30, 125, 200, 20);
				panel.add (nextButton);
				nextButton.addActionListener(this);
			}
			if (counter == 5){
				//Answer to previous Question
				String Q2Answer = Q2TextField.getText();
				Q2Answer.equalsIgnoreCase(Q2Answer);
				if (Q2Answer.equalsIgnoreCase("CPU")|| Q2Answer.equalsIgnoreCase("Central Processing Unit"))
					JOptionPane.showMessageDialog(null, "Correct");
				else
					JOptionPane.showMessageDialog(null, "Wrong. The answer is CPU. ");
				//Clear panel
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				//Component of Q3 JComboBox
				panel.add (Q3Label);
				Q3Label.setBounds(30, 54, 500, 85);
				panel.add(Q3);
				Q3.setBounds (30, 150, 250, 25);
				panel.add(nextButton);
				nextButton.addActionListener(this);
			}

			if (counter == 9){
				//Answer to previous Question
				String Q3Answer = (String)Q3.getSelectedItem();
				Q3Answer.equalsIgnoreCase(Q3Answer);
				if (Q3Answer.equalsIgnoreCase("Software"))
					JOptionPane.showMessageDialog (null, "Correct");
				else
					JOptionPane.showMessageDialog (null, "Wrong. The answer is Software. ");
				//Clear panel
				panel.removeAll();
				panel.repaint();
				panel.revalidate();
				//Components of last page
				panel.add(lastPage);
				lastPage.setBounds (10, 54, 500, 85);
				String name = nameField.getText();
				String data = ( name + " Congratulations You are DONE! " );
				lastPage.setText(data);
			}
		}
	}//End of ActionListener Method

	public static void main(String[] args) {
		//Create new object called GUIQuizProjectSample (have to be the same name as class
		//name of object is frame
		GUIQuizProjectSample frame = new GUIQuizProjectSample();
	}//End of Main Method
}//End of GUIQuizProjectSample Class
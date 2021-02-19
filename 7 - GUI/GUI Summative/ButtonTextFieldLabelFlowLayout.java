/** GUI SWING EXAMPLE: JButton, JLabel and JTextFiled with ActionListener
 * using JFrame,JPanel and FlowLayout
 * Ms. Stretten April 23, 2020 */
//contains frame and panel methods
import java.awt.FlowLayout;
//contains actionListener method when button is pressed
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//contains all "J" Components
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class ButtonTextFieldLabelFlowLayout extends JFrame implements ActionListener {
	//Create panel and GUI components
	JPanel panel = new JPanel();
	JLabel nameLabel = new JLabel ("<html> Enter Your Name: ", JLabel.RIGHT);
	JTextField nameField = new JTextField(25);
	JLabel num1Label = new JLabel("<html> Enter first number:");
	JTextField num1Field = new JTextField(25);
	JLabel num2Label = new JLabel("<html> Enter second number:");
	JTextField num2Field = new JTextField(25);
	JButton sumButton = new JButton ("Sum");
	JButton prodButton = new JButton ("Product");
	// the CONSTRUCTOR..... GUI Frame object is created here built HERE!
	public ButtonTextFieldLabelFlowLayout()
	{
		//Frame parameters
		super ("GUI SWING SAMPLES");
		setVisible (true);
		setSize (325, 250);
		setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		//using FlowLayout will add all the components in the panel left to right
		FlowLayout flow = new FlowLayout();
		panel.setLayout (flow);
		add(panel);
		//add components in the panel
		panel.add(nameLabel);
		panel.add(nameField);
		panel.add(num1Label);
		panel.add(num1Field);
		panel.add(num2Label);
		panel.add(num2Field);
		panel.add(sumButton);
		sumButton.addActionListener(this);
		panel.add(prodButton);
		prodButton.addActionListener(this);
	}

	//*********** ACTION LISTENER ***********
	public void actionPerformed(ActionEvent event) {
		String name = nameField.getText();
		String numa = num1Field.getText();
		int numaInt = Integer.parseInt(numa);
		String numb = num2Field.getText();
		int numbInt = Integer.parseInt(numb);
		int sum = 0;
		int product=0;
		int point = 0;
		if (event.getSource() == sumButton)
		{
			sum = numaInt + numbInt;
			JOptionPane.showMessageDialog(null, "Hello " + name + " The sum is " + sum);
		}
		if (event.getSource() == prodButton ) //event.getActionCommand().equals("OK")
		{
			product = numaInt * numbInt;
			JOptionPane.showMessageDialog(null, "Hello " + name + " The product is " + product);
		}
	}

	//*****************MAIN METHOD******************
	public static void main (String[] args)
	{
		ButtonTextFieldLabelFlowLayout frame = new ButtonTextFieldLabelFlowLayout();
	}//end of main
}//end of ButtonTextFieldLabelFlowLayout class
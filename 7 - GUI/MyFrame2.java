/**GUI Frame
 *
 */
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame2 extends JFrame implements ActionListener{
	JPanel panel = new JPanel ();
	JLabel name = new JLabel ("Enter your Name:");
	JTextField nameField = new JTextField(20);

	JButton click = new JButton ("press1");
	JButton click2 = new JButton ("press2");

	public MyFrame2(){
		FlowLayout flow = new FlowLayout();
		setLayout(flow);
		setTitle ("My Window");
		setSize (350, 300);
		setBackground (Color.GREEN);

		FlowLayout panelLayout = new FlowLayout();
		panel.setLayout(panelLayout);
		add(panel);

		panel.add(name);
		panel.add(nameField);

		panel.add(click);
		click.addActionListener(this);

		panel.add(click2);
		click2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event){
		String name2;
		if (event.getSource() == click){
			name2 = nameField.getText();
			JOptionPane.showMessageDialog(null, "Hello " + name2);
		}
		else if (event.getSource() == click2){
			name2 = nameField.getText();
			JOptionPane.showMessageDialog(null, name2 + " you pressed button2");

		}

	}



	public static void main(String[] args) {
		MyFrame2 frame = new MyFrame2 ();
		frame.setVisible(true);

	}
}
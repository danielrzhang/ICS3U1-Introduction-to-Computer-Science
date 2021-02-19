/* This program is a BreakAPlate game, which allows users to break plates via randomly generated numbers, and users can win a prize based on number of plate broken.
 * Daniel Zhang
 * May 22, 2020
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BreakAPlate extends JFrame implements ActionListener {
	// Declare and initialize labels for the home (beginning) panel
	JPanel panel = new JPanel();
	JLabel panel1Line1 = new JLabel("Welcome to Break A Plate! In this game, you must try to break all three plates! Random", JLabel.LEFT);
	JLabel panel1Line2 = new JLabel("number generators will be used to determine whether your plate is broken or not. Three", JLabel.LEFT);
	JLabel panel1Line3 = new JLabel("unbroken plates will be generated at the beginning of each round. By clicking \"Play\", three", JLabel.LEFT);
	JLabel panel1Line4 = new JLabel("randomly generated numbers will determine if the plate will be broken. A coloured shape", JLabel.LEFT);
	JLabel panel1Line5 = new JLabel("on the plate will represent if the plate is broken. If all three plates are broken, you win a", JLabel.LEFT);
	JLabel panel1Line6 = new JLabel("plush toy! Otherwise, you win a sticker. By clicking \"Play Again\", the three plates are reset", JLabel.LEFT);
	JLabel panel1Line7 = new JLabel("to unbroken, so that you can play again. You can play for as many times as you want, but to end ", JLabel.LEFT);
	JLabel panel1Line8 = new JLabel("the game, simply close the window. Let's break some plates!", JLabel.LEFT);

	// Declare and initialize the start button, play button, and play again button for the game
	JButton startButton = new JButton("Start");
	JButton playButton = new JButton("Play");
	JButton playAgainButton = new JButton("Play Again");

	int buttonType = 0; // Track what panel the game should be on (0 = home panel, 1 = play panel, 2 = play again panel)

	// Colour array to turn the broken shapes on the plates with randomly generated colours
	Color [] colorArray = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.PINK, Color.CYAN, Color.BLACK};

	public BreakAPlate() {
		super("BreakAPlate"); // Set panel name to "BreakAPlate"
		setVisible(true);
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(null);

		// Add labels, the rules of the game, to the panel
		add(panel);
		panel.add(panel1Line1);
		panel.add(panel1Line2);
		panel.add(panel1Line3);
		panel.add(panel1Line4);
		panel.add(panel1Line5);
		panel.add(panel1Line6);
		panel.add(panel1Line7);
		panel.add(panel1Line8);
		panel.add(startButton);

		// Set the dimensions of the labels for the rules of the game
		panel1Line1.setBounds(130, 50, 800, 40);
		panel1Line2.setBounds(130, 90, 800, 40);
		panel1Line3.setBounds(130, 130, 800, 40);
		panel1Line4.setBounds(130, 170, 800, 40);
		panel1Line5.setBounds(130, 210, 800, 40);
		panel1Line6.setBounds(130, 250, 800, 40);
		panel1Line7.setBounds(130, 290, 800, 40);
		panel1Line8.setBounds(130, 330, 800, 40);

		// Set the dimensions of the start button, play button, and play again button
		startButton.setBounds(355, 375, 80, 40);
		playButton.setBounds(350, 375, 80, 40);
		playAgainButton.setBounds(345, 375, 100, 40);

		// Give the buttons ActionListener to detect if the buttons are clicked
		startButton.addActionListener(this);
		playButton.addActionListener(this);
		playAgainButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		// Checks if the start button or the play again button is pressed, resets to the "Play" panel
		if (event.getSource() == startButton || event.getSource() == playAgainButton) {
			buttonType = 1;
		}

		// Checks if the play button is pressed, resets to the "Play Again" panel
		else if (event.getSource() == playButton) {
			buttonType = 2;
		}

		// Clear the panel of shapes, colours, and buttons
		Drawing();
		clearPanel(panel);
	}

	public void paint(Graphics g) {
		super.paint(g); // Paints the components properly on the JFrame

		// If the panel type is 1, display three unbroken plates with the "Play" button (Play panel)
		if (buttonType == 1) {
			// Sets the background to white
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 800, 600);

			panel.add(playButton); // Add the "Play" button to the panel

			// Use loops to draw the outer circles of the three plates instead of individually drawing three plates
			for (int x = 80; x < 800; x+=250) {
				g.setColor(Color.BLACK);
				g.drawOval(x, 150, 150, 150);
			}

			// Use loops to draw the inner circles of the three plates instead of individually drawing three plates
			for (int x = 105; x < 700; x+=250) {
				g.setColor(Color.BLACK);
				g.drawOval(x, 175, 100, 100);
			}
		}

		// If the panel type is 2, display broken plates with the "Play Again" button
		else if (buttonType == 2) {
			// Generates three random numbers, from 0 - 1, to determine if plate is broken or not
			int randNum1 = (int) (Math.random()*(1 - 0 + 1) - 0);
			int randNum2 = (int) (Math.random()*(1 - 0 + 1) - 0);
			int randNum3 = (int) (Math.random()*(1 - 0 + 1) - 0);

			// Generates three random numbers, from 1 - 6, to choose the shape to display on the broken plate
			int brokenShape1 = (int) (Math.random()*(6 - 1 + 1) + 1);
			int brokenShape2 = (int) (Math.random()*(6 - 1 + 1) + 1);
			int brokenShape3 = (int) (Math.random()*(6 - 1 + 1) + 1);

			// Generates three random numbers, from 0 - 8, to choose the index of the colour array of the random colour
			int randColorIndex1 = (int) (Math.random()*(8 - 0 + 1) + 0);
			int randColorIndex2 = (int) (Math.random()*(8 - 0 + 1) + 0);
			int randColorIndex3 = (int) (Math.random()*(8 - 0 + 1) + 0);


			// CHECKS IF 0 or 1 PLATES ARE BROKEN, SETS THEM TO 2 PLATES BROKEN TO INDICATE LOSS

			// If 0 plates are broken, set the first and third plate to broken
			if (randNum1 == 0 && randNum2 == 0 && randNum3 == 0) {
				randNum1 = 1;
				randNum3 = 1;
			}

			// If the first plate is broken, set the second plate to broken
			else if (randNum1 == 1 && randNum2 == 0 && randNum3 == 0)
				randNum2 = 1;

			// If the second or third plate is broken, set the first plate to broken
			else if ((randNum1 == 0 && randNum2 == 1 && randNum3 == 0) || (randNum1 == 0 && randNum2 == 0 && randNum3 == 1))
				randNum1 = 1;

			// Set the background to white
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, 800, 600);

			panel.add(playAgainButton); // Add the "Play Again" button to the panel

			// Use loops to draw the outer circles of the three plates instead of individually drawing three plates
			for (int x = 80; x < 800; x+=250) {
				g.setColor(Color.BLACK);
				g.drawOval(x, 150, 150, 150);
			}

			// Use loops to draw the inner circles of the three plates instead of individually drawing three plates
			for (int x = 105; x < 700; x+=250) {
				g.setColor(Color.BLACK);
				g.drawOval(x, 175, 100, 100);
			}

			// DRAWING THE RANDOM SHAPES WITH THEIR RANDOM COLOURS TO REPRESENT BROKEN PLATE

			// Checks if the first plate is broken
			if (randNum1 == 1) {

				// I USED SWITCH INSTEAD OF IF STATEMENT BECAUSE IT IS MORE EFFICIENT
				switch (brokenShape1) { // Checks for randomly generated number from 1-6
				case 1:
					g.setColor(colorArray[randColorIndex1]); // Gets the colour at the randomly generated index of the colorArray
					g.fillRect(93, 203, 125, 50); // Draws a rectangle
					break;

				case 2:
					g.setColor(colorArray[randColorIndex1]); // Gets the colour at the randomly generated index of the colorArray
					g.fillOval(80, 215, 150, 20); // Draws an ellipse
					break;

				case 3:
					g.setColor(colorArray[randColorIndex1]); // Gets the colour at the randomly generated index of the colorArray
					fillTriangle(100, 268, 115, g); // Draws a triangle using the fillTriangle method
					break;

				case 4:
					g.setColor(colorArray[randColorIndex1]); // Gets the colour at the randomly generated index of the colorArray
					g.fillArc(120, 185, 70, 70, 60, -220); // Draws an arc using the fillArc method
					break;

				case 5:
					g.setColor(colorArray[randColorIndex1]); // Gets the colour at the randomly generated index of the colorArray
					fillStar(155, 225, 75, g); // Draws a star using the fillStar method
					break;

				case 6:
					g.setColor(colorArray[randColorIndex1]); // Gets the colour at the randomly generated index of the colorArray
					g.drawLine(100, 170, 210, 280); // Draws a line
					g.drawLine(210, 170, 100, 280); // Draws another line
				}
			}

			// Checks if the second plate is broken
			if (randNum2 == 1) {
				switch (brokenShape2) {
				case 1:
					g.setColor(colorArray[randColorIndex2]); // Gets the colour at the randomly generated index of the colorArray
					g.fillRect(343, 203, 125, 50); // Draws a rectangle
					break;

				case 2:
					g.setColor(colorArray[randColorIndex2]); // Gets the colour at the randomly generated index of the colorArray
					g.fillOval(330, 215, 150, 20); // Draws an ellipse
					break;

				case 3:
					g.setColor(colorArray[randColorIndex2]);// Gets the colour at the randomly generated index of the colorArray
					fillTriangle(350, 268, 115, g); // Draws a triangle using the fillTriangle method
					break;

				case 4:
					g.setColor(colorArray[randColorIndex2]); // Gets the colour at the randomly generated index of the colorArray
					g.fillArc(370, 185, 70, 70, 60, -220); // Draws an arc using the fillArc method
					break;

				case 5:
					g.setColor(colorArray[randColorIndex2]); // Gets the colour at the randomly generated index of the colorArray
					fillStar(405, 225, 75, g); // Draws a star using the fillStar method
					break;

				case 6:
					g.setColor(colorArray[randColorIndex2]); // Gets the colour at the randomly generated index of the colorArray
					g.drawLine(350, 170, 460, 280); // Draws a line
					g.drawLine(460, 170, 350, 280); // Draws another line
				}
			}

			// Checks if the third plate is broken
			if (randNum3 == 1) {
				switch (brokenShape3) {
				case 1:
					g.setColor(colorArray[randColorIndex3]); // Gets the colour at the randomly generated index of the colorArray
					g.fillRect(593, 203, 125, 50); // Draws a rectangle
					break;

				case 2:
					g.setColor(colorArray[randColorIndex3]); // Gets the colour at the randomly generated index of the colorArray
					g.fillOval(580, 215, 150, 20); // Draws an ellipse
					break;

				case 3:
					g.setColor(colorArray[randColorIndex3]); // Gets the colour at the randomly generated index of the colorArray
					fillTriangle(600, 268, 115, g); // Draws a triangle using the fillTriangle method
					break;

				case 4:
					g.setColor(colorArray[randColorIndex3]); // Gets the colour at the randomly generated index of the colorArray
					g.fillArc(620, 185, 70, 70, 60, -220); // Draws an arc using the fillArc method
					break;

				case 5:
					g.setColor(colorArray[randColorIndex3]); // Gets the colour at the randomly generated index of the colorArray
					fillStar(655, 225, 75, g); // Draws a star using the fillStar method
					break;

				case 6:
					g.setColor(colorArray[randColorIndex3]); // Gets the colour at the randomly generated index of the colorArray
					g.drawLine(600, 170, 710, 280); // Draws a line
					g.drawLine(710, 170, 600, 280); // Draws another line
				}
			}

			String winPrize = "You win: "; // Declare a string called winPrize
			if (randNum1 == 1 && randNum2 == 1 && randNum3 == 1) // If all the plates are broken (1), the user wins a plush
				winPrize += "plush";
			else // If the user does not break all plates (1), the user wins a sticker
				winPrize += "sticker";

			// Display the text on the frame
			g.setColor(Color.BLACK);
			g.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
			g.drawString(winPrize, 333, 500);

		}
	}

	/* Method to clear JComponents on frame, buttons, specifically)
	 * @param the panel to be cleared
	 */
	public void clearPanel(JPanel panel) {
		panel.removeAll();
		panel.repaint();
		panel.revalidate();
	}

	// Method to clear the graphics on the panel
	public void Drawing() {
		repaint();
	}

	/* Method to draw a triangle given the x, y coordinates and its size
	 * @param the x and y coordinates of the triangle
	 */
	public static void fillTriangle(int x, int y, int size, Graphics g) {
		int [] xTriangle = {x, x + size, x + size / 2}; // Array to store the x coordinates of the points of the triangle
		int [] yTriangle = {y, y, y - size}; // Array to store the y coordinates of the points of the triangle

		Polygon triangle = new Polygon(xTriangle, yTriangle, xTriangle.length); // Declare new object called Polygon to draw triangle
		g.fillPolygon(triangle); // Draw the triangle to the frame
	}

	/* Method to draw a filled-in arc with colour
	 * @param x, y coordinates, width and height, and the start and end angle of the arc
	 */
	public static void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {}

	/* Method to draw a filled-in star
	 * @param x, y coordinates of the star, and its size
	 */
	public static void fillStar(int x, int y, int size, Graphics g) {
		// Arrays of x and y coordinates of the points of the star
		int [] xCoordinates = {x, x - size / 4, x - size, x - size / 4, x, x + size / 4, x + size, x + size / 4};
		int [] yCoordinates = {y - size, y - size / 4, y, y + size / 4, y + size, y + size / 4, y, y - size / 4};

		Polygon star = new Polygon(xCoordinates, yCoordinates, xCoordinates.length); // Declare new object called Polygon to draw star
		g.fillPolygon(star); // Draw the star to the frame
	}

	// Main method
	public static void main(String[] args) {
		BreakAPlate frame = new BreakAPlate();
		frame.Drawing();
	}
}
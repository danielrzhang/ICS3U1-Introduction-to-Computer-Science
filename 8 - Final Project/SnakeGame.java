/* In the game of Hungry Snake, the player uses the arrow keys to direct the snake around 
 * the board and eat the food. The more food the snake eats, the longer it grows and the 
 * higher your score. The game ends when either the snake eats itself or mooves off the board. 
 * The goal is to make the snake as large as possible before that happens.
 * Created by Daniel Zhang
 * June 17, 2020
 */

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import sun.audio.*;
import javax.imageio.*;

public class SnakeGame extends JPanel implements ActionListener {
 
  //-----Data definition------
  
  int [][] board = new int [20][20];    // Board Size 20 x 20
  
  /* The design of the program uses the 2D array to store the snake data, of which stores 
  each row and column of the snake's body pieces. By using this method, the program can
  efficiently check whether the snake eats itself, ensures new food placement to avoid 
  overlapping the snake, and repaints the snake quickly. */
  
  static int [][] snake = new int [400][2]; 
  
  Timer timer = new Timer(150, this);   // Program uses timer to provide automatic time-based movement
  int screenType = 0;
  JPanel homePanel = new JPanel(null);
  
  static int snakeLength = 4;   // Initial snake length
  
   /* Snake move direction 
    * 1 - Up
    * 2 - Right
    * 3 - Down
    * 4 - Left */
  
  static int direction = 2; 
  
  static boolean initializeStatus = true;
  static int [] foodLocation = new int [2];  // Food location records row and column
  static boolean endOfGame = false;
  static int gameOverCode = 1;
  
  // Game images
  static BufferedImage strawberry;
  static BufferedImage snakeHead;
  
  // Game start sound track
  static InputStream gameStartSound;
  static AudioStream gameStartStream;
  
  // Game over sound track
  static InputStream gameOverSound;  
  static AudioStream gameOverStream;
  
  // Eating food sound
  static InputStream eatSound;
  static AudioStream eatStream;
  static Boolean eatFoodSound = false;
  
  // Welcome screen
  JButton playButton = new JButton("Play");
  JLabel snakeGameLabel = new JLabel("Hungry Snake");
  JLabel copyrightLabel = new JLabel("Copyright © 2020");
  JLabel nameLabel = new JLabel("by Daniel Zhang");
  JLabel instructionLine1 = new JLabel("Welcome to the game of Snake. In this game, you control", JLabel.LEFT);
  JLabel instructionLine2 = new JLabel("a snake using the arrow keys. The snake travels around the", JLabel.LEFT);
  JLabel instructionLine3 = new JLabel("board and eats strawberries. For every strawberry it eats,", JLabel.LEFT);
  JLabel instructionLine4 = new JLabel("it grows in length. The snake must survive for as long as", JLabel.LEFT);
  JLabel instructionLine5 = new JLabel("possible without crashing into a wall or eating itself.", JLabel.LEFT);
  JLabel instructionLine6 = new JLabel("Ready? Let's go!", JLabel.LEFT);
  // End of welcome screen
  
  //----List of functions and procedures----//
  
  /*  keyPressed(): Handle key press event.
   *  snakeGame(): Create the main panel, welcome screen and timer.
   *  snakeMovement(): Process snake movement.
   *  eatFood(): Process snake eating food.
   *  gameOver(): Process game over.
   *  paint(): Draw all panel components.
   *  actionPerformed(): Process welcome screen.
   *  createInitialSnake(): Create initial snake.
   *  foodPlacement(): Create a random location of food.
   *  drawSnake(): Draw snake. 
   *  main(): Creat the main frame. */

  static class KAdapter extends KeyAdapter {
    
    /*Procedure to handle the arrow keys event and change snake movement direction accordingly. 
     * Ensures snake cannot go in reverse. */
    
    public void keyPressed(KeyEvent e) {
      
      if (e.getKeyCode() == KeyEvent.VK_UP && direction != 3) {
        direction = 1;
        eatFood();
      }
      else if (e.getKeyCode() == KeyEvent.VK_RIGHT && direction != 4) {
        direction = 2;
        eatFood();
      }
      else if (e.getKeyCode() == KeyEvent.VK_DOWN && direction != 1) {
        direction = 3;
        eatFood();
      }
      else if (e.getKeyCode() == KeyEvent.VK_LEFT && direction != 2) {
        direction = 4;
        eatFood();
      }
    }
  }

  public SnakeGame() { 
    
    add(homePanel);
    setVisible(true);
    setSize(517, 540);
    setLayout(null);
    
    homePanel.setSize(517, 540);
    
    // Intializes the welcome screen components
    snakeGameLabel.setFont(new Font("Arial", Font.BOLD, 40));
    copyrightLabel.setFont(new Font("Arial", Font.BOLD, 15));
    nameLabel.setFont(new Font("Arial", Font.BOLD, 20));
    instructionLine1.setFont(new Font("Arial", Font.PLAIN, 13));
    instructionLine2.setFont(new Font("Arial", Font.PLAIN, 13));
    instructionLine3.setFont(new Font("Arial", Font.PLAIN, 13));
    instructionLine4.setFont(new Font("Arial", Font.PLAIN, 13));
    instructionLine5.setFont(new Font("Arial", Font.PLAIN, 13));
    instructionLine6.setFont(new Font("Arial", Font.PLAIN, 13));
    
    snakeGameLabel.setBounds(130, 70, 500, 50);
    copyrightLabel.setBounds(195, 115, 500, 40);
    nameLabel.setBounds(180, 140, 500, 40);
    instructionLine1.setBounds(90, 200, 500, 40);
    instructionLine2.setBounds(90, 220, 500, 40);
    instructionLine3.setBounds(90, 240, 500, 40);
    instructionLine4.setBounds(90, 260, 500, 40);
    instructionLine5.setBounds(90, 280, 500, 40);
    instructionLine6.setBounds(90, 300, 500, 40);
    playButton.setBounds(210, 350, 80, 40);
    playButton.addActionListener(this);
    
    // Load images of the snake and strawberry
    try {
      strawberry = ImageIO.read(new File("Strawberry.png"));
      snakeHead = ImageIO.read(new File("Snake.png"));
    } catch (IOException ex) {
    }
    
    // Play music when game starts
    try {
      gameStartSound = getClass().getResourceAsStream("Gamestart.wav");
      gameStartStream = new AudioStream(gameStartSound);
      AudioPlayer.player.start(gameStartStream);
      
    } catch (IOException e) {
    }
    
    timer.setInitialDelay(30); 
    timer.start();
  }
  
  // Check the current snake movement direction and snake array. Update the snake array to next location.
  public void snakeMovement() {  
    
    for (int i = snakeLength - 1; i >= 0; i--) {
      snake[i + 1][0] = snake[i][0];
      snake[i + 1][1] = snake[i][1];
    }
    
    switch (direction) {
      case 1: // Up
        snake[0][0]--;
        break;
      case 2: // Right
        snake[0][1]++;
        break;
      case 3: // Down
        snake[0][0]++;
        break;
      case 4: // Left
        snake[0][1]--;
    }
    
    // After snake moves, check if snake eats the food. 
    eatFood();
     
    // Check if it is game over.
    if (gameOver()) {
      String [] options = {"Play Again", "Quit"};
      String gameOverDeath;
      timer.stop();
      
      // Display reason of game over.
      if (gameOverCode == 0) 
        gameOverDeath = "The snake ate itself.";
      else
        gameOverDeath = "The snake hit the wall.";
      
      // Play sound of game over.
      try {
      AudioPlayer.player.stop(eatStream);
      gameOverSound = getClass().getResourceAsStream("GameOver.wav");
      gameOverStream = new AudioStream(gameOverSound);
      AudioPlayer.player.start(gameOverStream);
          }
      catch (IOException e) {
    }
    
      // Calculate and display the score.
      int result = JOptionPane.showOptionDialog(null, gameOverDeath + "\n Your score is " + snakeLength * 50 + ". Well done, player!\n ", "Game Over!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
      
      // If user choose to play again, re-initialize the game.
      if (result == JOptionPane.YES_OPTION) {
          
        AudioPlayer.player.stop(gameOverStream);
        initializeStatus = true;
        timer.restart();
        timer.setInitialDelay(100); 
        direction = 2;
        createInitialSnake();
        foodPlacement();
        snakeLength = 4;
      }
      
      else if (result == JOptionPane.NO_OPTION) {
        System.exit(0);
      }
    }
  }

  public static void eatFood() {
    int nextHeadRow = snake[0][0];
    int nextHeadColumn = snake[0][1];

    // Pre-calculate the next location of snake head.
    switch (direction) { 
      case 1: // Up
        nextHeadRow--;
        break;
      case 2: // Right
        nextHeadColumn++;
        break;
      case 3: // Down
        nextHeadRow++;
        break;
      case 4: // Left
        nextHeadColumn--;
    }
    
    // Check if next location of snake head equals the food location.
    if (nextHeadRow == foodLocation[0] && nextHeadColumn == foodLocation[1]) {
      
      // If matched, grow the snake.
      for (int i = snakeLength - 1; i >= 0; i--) {
        snake[i + 1][0] = snake[i][0];
        snake[i + 1][1] = snake[i][1];
      }
      snake[0][0] = foodLocation[0];
      snake[0][1] = foodLocation[1];
      snakeLength++;
      foodPlacement();
      eatFoodSound = true; 
      }
  }
  
  public static boolean gameOver() {
    boolean gameOver = false;
    
    // Check if the snake eats itself by scanning the snake array.
    for (int i = 1; i < snakeLength; i++) {
      if ((snake[0][0] == snake[i][0] && snake[0][1] == snake[i][1])) { 
        gameOver = true;
        gameOverCode = 0;
        break;
      }
      
      // Check if the snake hit the border.
      else if ((snake[0][0] < 1 || snake[0][0] > 20) || (snake[0][1] < 1 || snake[0][1] > 20)) {
        gameOver = true;
        gameOverCode = 1;
        break;
      }
    }
    return gameOver; 
  }
  
  public void actionPerformed(ActionEvent e) {
    
    // Display the welcome screen
    homePanel.setBackground(Color.WHITE);
    if (screenType == 0) {
      homePanel.add(snakeGameLabel);
      homePanel.add(copyrightLabel);
      homePanel.add(nameLabel);
      homePanel.add(instructionLine1);
      homePanel.add(instructionLine2);
      homePanel.add(instructionLine3);
      homePanel.add(instructionLine4);
      homePanel.add(instructionLine5);
      homePanel.add(instructionLine6);
      homePanel.add(playButton);
      
      if (e.getSource() == playButton) {
        screenType = 1;
        homePanel.removeAll();
        AudioPlayer.player.stop(gameStartStream);
      } 
    }
    
    else {
      repaint();
    }
  }
  
  public void paint(Graphics g) { 
    
    // Draw the main game board
    super.paint(g);
    setBackground(Color.WHITE);
    
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        g.setColor(Color.YELLOW);
        g.drawRect(i * 25, (j * 25), 25, 25);
      }
    }
    
    // Initialize the snake and food
    if (initializeStatus) {
      createInitialSnake();
      foodPlacement();
      initializeStatus = false;
    }
    else
      snakeMovement();
    
    // Draw snake and food by converting row and column to screen coordinates and size.
    drawSnake(g);
    g.drawImage(snakeHead, (snake[0][1] * 25) - 35, (snake[0][0] * 25) - 35, this);
    g.drawImage(strawberry, (foodLocation[1] * 25) - 32, (foodLocation[0] * 25) - 32, this);  
    
    if (eatFoodSound){
      //Play sound of eating food.
      eatSound = getClass().getResourceAsStream("Eat.wav");
      try {
      eatStream = new AudioStream(eatSound);
      AudioPlayer.player.start(eatStream);
      eatFoodSound = false;
      } catch (IOException e) {
      }
    }
  }
  
  // Create initial snake
  public static void createInitialSnake() {
    int randSpawnRow = (int) (Math.random()*(20)) + 1;
    snake[0][1] = 4;
    snake[1][1] = 3;
    snake[2][1] = 2;
    snake[3][1] = 1;
    
    snake[0][0] = randSpawnRow;
    snake[1][0] = randSpawnRow;
    snake[2][0] = randSpawnRow;
    snake[3][0] = randSpawnRow;
  }
  
  public static void foodPlacement() {
    boolean foodOverSnake = true;
    int randRow;
    int randColumn;
    
    // Run a loop to create a random food location until it meets the condition that it is not part of the snake body.
    do {
      randRow = (int) (Math.random()*(20) + 1);
      randColumn = (int) (Math.random()*(20) + 1);
      
      foodOverSnake = false;
      
      // Scan the snake array to ensure new food location doesn't equal any of them.
      for (int i = 0; i < snakeLength; i++) {
        if ((randRow == snake[i][0]) && (randColumn == snake[i][1])) {
          foodOverSnake = true;
          break;
        }
      }
    } while (foodOverSnake);
    
    foodLocation[0] = randRow;
    foodLocation[1] = randColumn;
    eatFood();
    
  }
  
  public static void drawSnake(Graphics g) {
    g.setColor(Color.GREEN);
    // Convert the snake array of rows and columns to screen coordinates and draw snake.
    for (int i = 0; i < snakeLength; i++) {        
      g.fillRect((snake[i][1] - 1) * 25, (snake[i][0] - 1) * 25, 26, 26);
    }
  }

  public static void main(String[] args) {
    
    // Create the main frame.
    JFrame frame = new JFrame("Hungry Snake");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(507, 540);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setVisible(true);
    frame.setFocusable(true);
    frame.add(new SnakeGame());
    
    // Add the keyboard listener.
    frame.addKeyListener(new KAdapter());
  }
}


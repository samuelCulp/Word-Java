package GUI;
import javax.swing.*;

import Game.Game;


public class GUI extends JFrame {


    public JLabel wordDisplay;
    public JTextField guessInput;
    public JLabel feedbackLabel;
    public JLabel guessesLeftLabel;


    public static void Window() {

        Game game = new Game();
        int len = game.randomWord.length();


    JFrame frame = new JFrame("Call of Duty: Hang a Man");

    // Create a label
        String randomWord = game.ReadingWordFile();
    JLabel label = new JLabel(randomWord);

    // Add the label to the frame
        frame.add(label);

    // Set frame properties
        frame.setSize(600,
                600); // Set the size of the frame

    // Close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Make the frame visible
        frame.setVisible(true);
}
}

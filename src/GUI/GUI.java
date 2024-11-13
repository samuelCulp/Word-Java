package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import Game.Game;


public class GUI {

    public static void Window() {

    JFrame frame = new JFrame("Call of Duty: Hang a Man");
    Game game = new Game();
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

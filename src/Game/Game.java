package Game;
import GUI.GUI;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Game  {

    public String randomWord = ReadingWordFile();
    public String[] rightLetter;
    public int incorrectGuesses =0;


    public static String ReadingWordFile() {
        List<String> words = new ArrayList<>();
        try { // getting file
            File wordfile = new File("src/Words.txt");
            Scanner reader = new Scanner(wordfile);
            while (reader.hasNextLine()) {
                words.add(reader.nextLine());
            }
            reader.close();

            if (!words.isEmpty()) { //checking to see if list has a word in it
                Random random = new Random(); // gets a random index and gets the word at that index
                int randomIndex = random.nextInt(words.size());  // Get random index
                return words.get(randomIndex); // Return the word at the random index
            } else {
                System.out.println("No words found");
                return null;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
            return null;
        }
    }

    private void makeGuess() {


        String userIN = guessInput.getText().toLowerCase();

        // Check if the input is valid
        if (userIN.length() != 1 || !Character.isLetter(userIN.charAt(0))) {
            feedbackLabel.setText("Please enter a single valid letter.");
            return;
        }

        boolean containsLetter = false;
        for (int i = 0; i < randomWord.length(); i++) {
            if (randomWord.charAt(i) == userIN.charAt(0)) {
                rightLetter[i] = userIN; // Place correct guess in rightLetter
                containsLetter = true;
            }
        }

        // Update the display based on guess result
        if (containsLetter) {
            feedbackLabel.setText(userIN + " is correct!");
            wordDisplay.setText(String.join(" ", rightLetter));

            // Check if the user has guessed the whole word
            if (String.join("", rightLetter).equals(randomWord)) {
                feedbackLabel.setText("Congratulations! You've guessed the word!");
                guessInput.setEnabled(false);
            }
        } else {
            incorrectGuesses++;
            feedbackLabel.setText(userIN + " is incorrect.");
            guessesLeftLabel.setText("Guesses left: " + (4 - incorrectGuesses));

            // Check if the user has run out of guesses
            if (incorrectGuesses == 4) {
                feedbackLabel.setText("Game Over! The word was: " + randomWord);
                guessInput.setEnabled(false);
            }
        }


}

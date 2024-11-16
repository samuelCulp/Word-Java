package Main;
import GUI.GUI;
import Game.Game;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        Game game = new Game();


        String randomWord = game.ReadingWordFile(); // Get random word from file
        if (randomWord != null) {
            System.out.println(randomWord); // Print random word
        }

        int len = randomWord.length();
        String[] rightLetter = new String[len];


        for (int i = 0; i < len; i++) {
            rightLetter[i] = "_";
        }

        Scanner sc = new Scanner(System.in);
        int incorrectGuesses = 0;

        while (incorrectGuesses < 4) {
            System.out.print("Current progress: ");
            for (String letter : rightLetter) {
                System.out.print(letter + " ");
            }
            System.out.println("\nPlease enter a letter: ");
            String userIN = sc.nextLine();


            if (userIN.length() != 1 || !Character.isLetter(userIN.charAt(0))) {
                System.out.println("Please enter a single valid letter.");
                continue;
            }

            boolean containsLetter = false;

            // Check if the guessed letter is in randomWord and update rightLetter if correct
            for (int i = 0; i < len; i++) {
                if (randomWord.charAt(i) == userIN.charAt(0)) {
                    rightLetter[i] = userIN; // Place correct guess in rightLetter
                    containsLetter = true;
                }
            }


            if (containsLetter) {
                System.out.println(userIN + " is correct!");

                // Check if the word is completely guessed
                if (String.join("", rightLetter).equals(randomWord)) {
                    System.out.println("You win: " + randomWord);
                    break;
                }
            } else {
                incorrectGuesses++;
                System.out.println(userIN + " is incorrect. You have " + (4 - incorrectGuesses) + " guesses left.");
            }


            if (incorrectGuesses == 4) {
                System.out.println("You killed a man. The correct word was: " + randomWord);
                break;
            }
        }

        sc.close();


/*        sc.close();
        GUI gui = new GUI();
        gui.Window();*/

    }
}

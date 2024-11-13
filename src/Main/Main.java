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
        System.out.println(len);
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < len;) {
            int j =0;
            System.out.println("Please enter a letter: ");
            String userIN = sc.nextLine();

            boolean containsLetter = false;
            for (char c : randomWord.toCharArray()) {
                if (userIN.indexOf(c) != -1) {
                    containsLetter = true;
                    break;
                }
            }

            if (containsLetter) {// right
                System.out.println(userIN + " right");

                rightLetter[j] = userIN;
                j++;
                for (int k =0; k < j; k++) {
                    System.out.print(rightLetter[j]+k);
                }

            } else {
                System.out.println(userIN + " wrong");
                i = i+1;
            }

            if (i == 4){
                System.out.println("You killed a man");
                break;
            }
            for (int k =0; k <= j; k++) {
                System.out.print(rightLetter[k]);
                System.out.println("k:" + j);
            }
        }

/*        sc.close();
        GUI gui = new GUI();
        gui.Window();*/

    }
}

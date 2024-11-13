package Game;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Game {
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
}

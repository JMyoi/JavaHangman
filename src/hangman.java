
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class hangman {
    public void play() throws FileNotFoundException {
        Scanner file = new Scanner(new File("words.txt"));
        Scanner cin = new Scanner(System.in);
        String word;
        List<String> words = new ArrayList<>();

        while (file.hasNext()){
            words.add(file.nextLine());

        }
        Random rand = new Random();

        word = words.get(rand.nextInt(words.size()));
        System.out.println(word);

        List<Character> userGuess = new ArrayList<>();
        boolean finished = false;
        finished = printWordState(userGuess, word);
        while (!finished){
        getPlayerGuess(cin, userGuess, word);
        finished = printWordState(userGuess, word);
        }
        System.out.println("Congrats you did it !!!!");
    }
    private void getPlayerGuess(Scanner cin, List<Character> userGuess, String word){
        System.out.println("Please enter a letter: ");
        String input = cin.nextLine();
        userGuess.add(input.charAt(0));

    }
    private boolean printWordState(List<Character> userGuess, String word) {
        for (int i = 0; i<word.length(); i++){
            if(userGuess.contains(word.charAt(i))){
                System.out.print(word.charAt(i));
            }
            else{
                System.out.print("-");
            }
        }
        System.out.println();
        //checks if the user guessed all letters.
        for (int i = 0; i<word.length(); i++){
            if(userGuess.contains(word.charAt(i))){
                continue;
            }
            else{
                return false;
            }
        }
        return true;

    }

}

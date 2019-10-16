package mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MasterMind {

    private static int MAX_ATTEMPTS = 10;
    private Character[] code;
    private int numAttempt = 0;
    private boolean solved = false;

    // TODO - Challenge: make this accept Character[] rather than List<Character>
    public MasterMind(Character[] code) {
        this.code = code;
    }

    // TODO - together, let's change this to throw a specific GameOverException
    // indicating won or lost, rather than GameOverException(..) with a message
    // TODO - change this to accept and return Character[] rather than List<Character>
    public Character[] play(Character[] guess) throws GameOverException {

        if (guess.length != this.code.length) {
            throw new IllegalArgumentException("Guess must be same length as code");
        }

        if (solved == true) {
            throw new GameWonException(this.numAttempt);
        }

        if (numAttempt == MAX_ATTEMPTS) {
            throw new GameLostException(this.numAttempt);
        }

        this.numAttempt++;

        ArrayList<Character> feedback = new ArrayList<>();
        List<Character> copyOfCode = new ArrayList<>();
        copyOfCode.addAll(Arrays.asList(code));

        List<Character> copyOfGuess = new ArrayList<>();
        copyOfGuess.addAll(Arrays.asList(guess));

        // TODO - once you have identified that guess[n] == code[n],
        //        then you must never compare anything to guess[n] or code[n]

        int counter = 0;
        for (int guessIndex = 0; guessIndex < copyOfGuess.size(); guessIndex++) {
            for (int codeIndex = 0; codeIndex < copyOfCode.size(); codeIndex++) {
                if (copyOfGuess.get(guessIndex) == copyOfCode.get(codeIndex)) {
                    if (guessIndex == codeIndex) {
                        feedback.add('R');
                        copyOfCode.remove(codeIndex);
                        copyOfGuess.remove(guessIndex);
                        codeIndex--;
                        guessIndex--;
                        counter++;
                        if (counter == code.length) {
                            solved = true;
                        }
                        break;
                    }
                    else {
                        feedback.add('W');
                    }
                }
            }
        }

        return feedback.toArray(new Character[feedback.size()]);
    }

}

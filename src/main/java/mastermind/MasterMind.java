package mastermind;

import java.util.ArrayList;
import java.util.List;

public class MasterMind {

    private static int MAX_ATTEMPTS = 10;
    private List<Character> code;
    private int numAttempt = 0;

    public MasterMind(List<Character> code) {
        this.code = code;
    }

    public List<Character> play(List<Character> guess) {

        if (numAttempt == MAX_ATTEMPTS) {
            throw new RuntimeException("Game over, you lost!");
        }

        this.numAttempt++;

        ArrayList<Character> feedback = new ArrayList<>();
        List<Character> copyOfCode = new ArrayList<>();
        copyOfCode.addAll(code);

        List<Character> copyOfGuess = new ArrayList<>();
        copyOfGuess.addAll(guess);

        // TODO - once you have identified that guess[n] == code[n],
        //        then you must never compare anything to guess[n] or code[n]

        for (int guessIndex = 0; guessIndex < copyOfGuess.size(); guessIndex++) {
            for (int codeIndex = 0; codeIndex < copyOfCode.size(); codeIndex++) {
                if (copyOfGuess.get(guessIndex) == copyOfCode.get(codeIndex)) {
                    if (guessIndex == codeIndex) {
                        feedback.add('R');
                        copyOfCode.remove(codeIndex);
                        copyOfGuess.remove(guessIndex);
                        codeIndex--;
                        guessIndex--;
                        break;
                    }
                    else {
                        feedback.add('W');
                    }
                }
            }
        }
        return feedback;
    }

}

package mastermind;

import java.util.ArrayList;
import java.util.List;

public class MasterMind {

    private static int MAX_ATTEMPTS = 10;
    private List<Character> code;
    private int numAttempt = 0;
    private boolean solved = false;

    // TODO - Challenge: make this accept Character[] rather than List<Character>
    public MasterMind(List<Character> code) {
        this.code = code;
    }


    // TODO - together, let's change this to throw a specific GameOverException
    // indicating won or lost, rather than GameOverException(..) with a message
    // TODO - change this to accept and return Character[] rather than List<Character>
    public List<Character> play(List<Character> guess) throws GameOverException {

        if (solved == true) {
            throw new GameOverException("Game over, you won!");
        }

        if (numAttempt == MAX_ATTEMPTS) {
            throw new GameOverException("Game over, you lost!");
        }

        this.numAttempt++;

        ArrayList<Character> feedback = new ArrayList<>();
        List<Character> copyOfCode = new ArrayList<>();
        copyOfCode.addAll(code);

        List<Character> copyOfGuess = new ArrayList<>();
        copyOfGuess.addAll(guess);

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
                        if (counter == code.size()) {
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

        return feedback;
    }

}

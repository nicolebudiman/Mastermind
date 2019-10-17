package mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MasterMind {

    private static int MAX_ATTEMPTS = 10;
    private Character[] code;
    private int numAttempt = 0;
    private boolean solved = false;

    private boolean isSameColor(char guessColor, char codeColor) {
        return guessColor == codeColor;
    }

    private boolean isSamePosition(int guessPosition, int codePosition) {
        return guessPosition == codePosition;
    }

    public MasterMind(Character[] code) {
        this.code = code;
    }

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

        List<Integer> positionsWithExactMatch = new ArrayList<>();
            for (int guessIndex = 0; guessIndex < copyOfGuess.size(); guessIndex++) {
                    for (int codeIndex = 0; codeIndex < copyOfCode.size(); codeIndex++) {
                        if(!positionsWithExactMatch.contains(guessIndex) && !positionsWithExactMatch.contains(codeIndex)) {
                            if (isSameColor(copyOfGuess.get(guessIndex), copyOfCode.get(codeIndex))) {
                                if (isSamePosition(guessIndex, codeIndex)) {
                                    positionsWithExactMatch.add(codeIndex);

                                } else {
                                    feedback.add('W');
                                }
                            }
                        }
                }
            }

        for(Integer positionOfExactMatch : positionsWithExactMatch) {
            feedback.add('R');
        }

        if(positionsWithExactMatch.size() == code.length) {
            solved = true;
        }

        return feedback.toArray(new Character[feedback.size()]);
    }

}

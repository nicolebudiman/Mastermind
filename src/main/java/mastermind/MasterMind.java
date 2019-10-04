package mastermind;

import java.util.ArrayList;
import java.util.List;

public class MasterMind {

    private List<Character> code;

    public MasterMind(List<Character> code) {
        this.code = code;
    }

    public List<Character> play(List<Character> guess) {

        ArrayList<Character> feedback = new ArrayList<>();

        // TODO - once you have identified that guess[n] == code[n],
        //        then you must never compare anything to guess[n] or code[n]

        for (int guessIndex = 0; guessIndex < guess.size(); guessIndex++) {
            for (int codeIndex = 0; codeIndex < code.size(); codeIndex++) {
                if (guess.get(guessIndex) == code.get(codeIndex)) {
                    if (guessIndex == codeIndex) {
                        feedback.add('R');
                        code.remove(codeIndex);
                        guess.remove(guessIndex);
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

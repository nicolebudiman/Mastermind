package mastermind;

import java.util.ArrayList;
import java.util.List;

public class MasterMind {
    private Character[] code;

    public MasterMind(Character[] code) {
        this.code = code;
    }


    public Character[] play(Character[] guess) {

        List<Character> feedback = new ArrayList<>();

        for (int guessIndex = 0; guessIndex < guess.length; guessIndex++) {
            for (int codeIndex = 0; codeIndex < code.length; codeIndex++) {
                if (guess[guessIndex] == code[codeIndex]) {
                    if (guessIndex == codeIndex) {
                        feedback.add('R');
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

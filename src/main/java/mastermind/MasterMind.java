package mastermind;

public class MasterMind {
    private Character[] code;

    public MasterMind(Character[] code) {
        this.code = code;
    }


    public Character[] play(Character[] guess) {
        boolean match = false;
        // color matches
        for(Character code_item : this.code) {
            for(Character guess_item : guess ) {
                if (code_item == guess_item) {
                    match = true;
                }
            }
        }


        if (match == true) {
            return new Character[] {'W'};
        }
        else {
            // if no match
            return new Character[0];
        }
    }
}

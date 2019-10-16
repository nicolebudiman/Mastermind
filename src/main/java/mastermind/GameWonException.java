package mastermind;

public class GameWonException extends GameOverException {
    public GameWonException(int numAttempt) {
        super(numAttempt);
    }
}

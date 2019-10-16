package mastermind;

public class GameLostException extends GameOverException {
    public GameLostException(int numAttempt) {
        super(numAttempt);
    }
}
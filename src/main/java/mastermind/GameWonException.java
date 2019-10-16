package mastermind;

public class GameWonException extends GameOverException {
    public GameWonException(String message) {
        super(message);
    }
}

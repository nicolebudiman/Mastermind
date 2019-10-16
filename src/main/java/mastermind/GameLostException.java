package mastermind;

public class GameLostException extends GameOverException {
    public GameLostException(String message) {
        super(message);
    }
}
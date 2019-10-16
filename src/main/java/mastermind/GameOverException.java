package mastermind;

public class GameOverException extends Exception {
    private int numAttempt;

    public GameOverException(int numAttempt) {
        this.numAttempt = numAttempt;
    }

    public int getAttempts() {
        return numAttempt;
    }
}

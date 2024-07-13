import biuoop.DrawSurface;

/**
 * 208765982 Idan Inbar.
 */
public class EndScreen implements Animation {
    private boolean stop;
    private boolean result;
    private Counter score;

    /**
     * the function is a constructor for EndScreen.
     * @param result is true is the user win and false otherwise.
     * @param score is the score of the user.
     */
    public EndScreen(boolean result, Counter score) {
        this.stop = false;
        this.result = result;
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.result) {
            //if the player won
            d.drawText(10, d.getHeight() / 2, "You Win! Your score is : " + this.score.getValue(), 32);
        } else {
            //the player lost
            d.drawText(10, d.getHeight() / 2, "Game Over. Your score is : " + this.score.getValue(), 32);
        }
    }

    @Override
    public boolean shouldStop() {
        return this.stop;
    }
}

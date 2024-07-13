import biuoop.DrawSurface;

/**
 * 208765982 Idan Inbar.
 */
public class PauseScreen implements Animation {
    private boolean stop;

    /**
     * the function is a constructor for PauseScreen.
     * */
    public PauseScreen() {
        this.stop = false;
    }

    /**
     * the function is pausing the game.
     * @param d is the surface we draw on.
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    /**
     * the function stops the game.
     * @return stop.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
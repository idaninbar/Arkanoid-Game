/**
 * 208765982 Idan Inbar.
 */
import biuoop.DrawSurface;
import biuoop.Sleeper;

import java.awt.Color;


/**
 * the class CountdownAnimation.
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private SpriteCollection gameScreen;
    private boolean stop;
    private Sleeper sleeper;
    private int framesPerSecond;
    private double miliSeconds;

    /**
     * the function is a constructor for CountdownAnimation.
     * @param numOfSeconds is the number of seconds we want to count.
     * @param countFrom is the starting number that we want to count.
     * @param gameScreen is our game screen.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSeconds = numOfSeconds;
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.sleeper = new Sleeper();
        this.stop = false;
        this.framesPerSecond = 60;
        this.miliSeconds = numOfSeconds * 1000;
    }

    /**
     * the function is printing a countdown on the users screen before every level.
     * @param d is our surface.
     */
    public void doOneFrame(DrawSurface d) {
        this.gameScreen.drawAllOn(d);
        d.setColor(Color.gray);
        d.drawText(d.getWidth() / 2, d.getHeight() / 2, countFrom + "...", 30);
        if (countFrom != 3) {
            this.sleeper.sleepFor((long) (this.miliSeconds / 3.0));
        }
        if (countFrom == 0) {
            this.stop = true;
        }
        countFrom--;
    }

    /**
     * thr function returns when the doOneFrame should stop.
     * @return true or false.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
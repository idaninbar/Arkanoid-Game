/**
 * 208765982 Idan Inbar.
 */
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * the class AnimationRunner.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;
    private static final int FRAME_RATE = 60;

    /**
     * the function is a constructor for AnimationRunner.
     * @param gui is our GUI.
     */
    public AnimationRunner(GUI gui) {
        this.gui = gui;
        this.framesPerSecond = FRAME_RATE;
        this.sleeper = new Sleeper();
    }

    /**
     * the function is a getter for GUI.
     * @return GUI.
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * the function runs the game.
     * @param animation is the animation that we were given.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}


import biuoop.KeyboardSensor;
import java.util.List;
/**
 * 208765982 Idan Inbar.
 */

public class GameFlow {
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboard;
    private Counter score;
    private boolean result;

    /**
     * the function is a constructor for GameFlow.
     * @param ar is the animation runner we get.
     * @param key is the keyboard we get.
     */
    public GameFlow(AnimationRunner ar, biuoop.KeyboardSensor key) {
        this.animationRunner = ar;
        this.keyboard = key;
        this.score = new Counter();
        this.result = false;
    }

    /**
     * the function runs the levels.
     * @param levels is the level list.
     */
    public void runLevels(List<LevelInformation> levels) {
        //run all the levels is the list
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.keyboard, this.animationRunner,
                    this.score);

            level.initialize();
            level.run();
            //if the player lost
            if (level.getBallCounter().getValue() == 0) {
                break;
            }
        }
        //the player won so print the "you win" message
        EndScreen endScreen = new EndScreen(this.result, this.score);
        this.animationRunner.run(new KeyPressStoppableAnimation(keyboard,
                keyboard.SPACE_KEY, endScreen));
    }
}
import java.util.List;
/**
 * 208765982 Idan Inbar.
 */
public interface LevelInformation {
    /**
     * the function is returning the number of balls.
     * @return the number of balls.
     */
    int numberOfBalls();
    /**
     * the function initial the velocity of each ball.
     * @return a list of the balls.
     */
    List<Velocity> initialBallVelocities();

    /**
     * the function returns the paddle's speed.
     * @return the speed of the paddle.
     */
    int paddleSpeed();

    /**
     * the function returns the paddle's width.
     * @return the paddle's width.
     */
    int paddleWidth();
    /**
     * the function returns the name of the level.
     * @return the level's name.
     */
    String levelName();
    /**
     * the function returns a sprite with the background of the level.
     * @return the sprite with the background of the level.
     */
    Sprite getBackground();
    /**
     * the function creates the block of the level.
     * @return a list of all the blocks that were created.
     */
    List<Block> blocks();
    /**
     * the function returns the number of blocks in the level.
     * @return the number of blocks in the level.
     */
    int numberOfBlocksToRemove();
}
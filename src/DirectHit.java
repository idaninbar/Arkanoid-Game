import java.awt.Color;

import java.util.ArrayList;
import java.util.List;
/**
 * 208765982 Idan Inbar.
 */
public class DirectHit implements LevelInformation {
    //BALLS
    private static final int NUM_OF_BALLS = 1;
    //PADDLE
    private static final int SPEED = 5;
    private static final int PADDLE_SPEED = 10;
    private static final int PADDLE_WIDTH = 100;
    //DIRECT HIT
    private static final String NAME = "Direct Hit";
    //BLOCKS
    private static final int BLOCK_HEIGHT = 30;
    private static final int BLOCK_WIDTH = 30;
    private static final int NUM_OF_BLOCKS_REMOVED = 1;
    //SCREEN
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    @Override
    public int numberOfBalls() {
        return NUM_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> velocities = new ArrayList<>();
        velocities.add(Velocity.fromAngleAndSpeed(0, SPEED));
        return velocities;
    }

    @Override
    public int paddleSpeed() {
        return PADDLE_SPEED;
    }

    @Override
    public int paddleWidth() {
        return PADDLE_WIDTH;
    }

    @Override
    public String levelName() {
        return NAME;
    }

    @Override
    public Sprite getBackground() {
        return new BackgroundDirectHit();
    }

    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        Rectangle rectangle = new Rectangle(new Point(385, 150), BLOCK_WIDTH, BLOCK_HEIGHT);
        Block block = new Block(rectangle, Color.red);
        blockList.add(block);
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUM_OF_BLOCKS_REMOVED;
    }
}

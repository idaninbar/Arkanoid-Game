import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * 208765982 Idan Inbar.
 */

public class WideEasy implements LevelInformation {
    private BackgroundWideEasy backgroundWideEasy = new BackgroundWideEasy();
    //BALLS
    private static final int NUM_OF_BALLS = 10;
    //PADDLE
    private static final int SPEED = 5;
    private static final int PADDLE_SPEED = 3;
    private static final int PADDLE_WIDTH = 620;
    //DIRECT HIT
    private static final String NAME = "Wide Easy";
    //BLOCKS
    private static final int BLOCK_HEIGHT = 20;
    private static final int NUM_OF_BLOCKS_REMOVED = 14;
    //SCREEN
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BORDER_WIDTH = 15;

    @Override
    public int numberOfBalls() {
        return NUM_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        int angle = 10;
        List<Velocity> velocities = new ArrayList<>();
        for (int i = 1; i <= NUM_OF_BALLS; i++) {
            velocities.add(Velocity.fromAngleAndSpeed((50) - (i * angle), SPEED));
        }
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
        return this.backgroundWideEasy;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        Color[] colors = {Color.red, Color.orange, Color.yellow, Color.green, Color.BLUE, Color.pink, Color.cyan};
        //the point that we want to print the first block
        int start = BORDER_WIDTH;
        int blockWidth = (WIDTH - (2 * BORDER_WIDTH)) / this.numberOfBlocksToRemove();
        int temp = 0;
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < 2; j++) {
                Rectangle rectangle = new Rectangle(new Point(start + temp, 200), blockWidth, BLOCK_HEIGHT);
                Block block = new Block(rectangle, colors[i]);
                blockList.add(block);
                temp += blockWidth;
            }
        }
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUM_OF_BLOCKS_REMOVED;
    }
}

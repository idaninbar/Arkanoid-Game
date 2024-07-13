import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * 208765982 Idan Inbar.
 */

public class FinalFour implements LevelInformation {
    private BackgroundFinalFour backgroundFinalFour = new BackgroundFinalFour();
    //BALLS
    private static final int NUM_OF_BALLS = 3;
    //PADDLE
    private static final int SPEED = 5;
    private static final int PADDLE_SPEED = 4;
    private static final int PADDLE_WIDTH = 100;
    //DIRECT HIT
    private static final String NAME = "Final Four";
    //BLOCKS
    private static final int BLOCK_HEIGHT = 20;
    private static final int NUM_OF_BLOCKS_REMOVED = 98;
    private static final int DISTANCE_FROM_TOP = 80;
    private static final int MAX_BLOCKS_IN_ROW = 14;
    //SCREEN
    private static final int WIDTH = 800;
    private static final int HORIZONTAL_BORDER_HEIGHT = 15;
    private static final int BORDER_WIDTH = 15;

    @Override
    public int numberOfBalls() {
        return NUM_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        int angle = -10;
        List<Velocity> velocities = new ArrayList<>();
        for (int i = 1; i <= NUM_OF_BALLS; i++) {
            velocities.add(Velocity.fromAngleAndSpeed(angle, SPEED));
            angle += 10;
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
        return this.backgroundFinalFour;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        Color[] colors = {Color.gray, Color.red, Color.yellow, Color.green, Color.white, Color.pink, Color.cyan};
        int start = HORIZONTAL_BORDER_HEIGHT;
        int blockWidth = (WIDTH - (2 * BORDER_WIDTH)) / MAX_BLOCKS_IN_ROW;
        int distance = DISTANCE_FROM_TOP;
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < 14; j++) {
                Rectangle rectangle = new Rectangle(new Point(start, distance), blockWidth, BLOCK_HEIGHT);
                Block block = new Block(rectangle, colors[i]);
                start += blockWidth;
                blockList.add(block);
            }
            distance += BLOCK_HEIGHT;
            start = HORIZONTAL_BORDER_HEIGHT;
        }
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUM_OF_BLOCKS_REMOVED;
    }
}

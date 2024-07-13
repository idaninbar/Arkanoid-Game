import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * 208765982 Idan Inbar.
 */

public class Green3 implements LevelInformation {
    private BackgroundGreen3 backgroundGreen3 = new BackgroundGreen3();
    //BALLS
    private static final int NUM_OF_BALLS = 2;
    //PADDLE
    private static final int SPEED = 5;
    private static final int PADDLE_SPEED = 5;
    private static final int PADDLE_WIDTH = 95;
    //DIRECT HIT
    private static final String NAME = "Green 3";
    //BLOCKS
    private static final int BLOCK_HEIGHT = 25;
    private static final int BLOCK_WIDTH = 50;
    private static final int NUM_OF_BLOCKS_REMOVED = 40;
    private static final int MAX_BLOCKS_IN_ROW_1 = 10;

    @Override
    public int numberOfBalls() {
        return NUM_OF_BALLS;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        int angle = -30;
        List<Velocity> velocities = new ArrayList<>();
        for (int i = 1; i <= NUM_OF_BALLS; i++) {
            velocities.add(Velocity.fromAngleAndSpeed(angle * i, SPEED));
            angle += 50;
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
        return this.backgroundGreen3;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blockList = new ArrayList<>();
        Color[] colors = {Color.gray, Color.red, Color.yellow, Color.blue, Color.white};
        int x = 285;
        int y = 120;
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < MAX_BLOCKS_IN_ROW_1 - i; j++) {
                Rectangle newRectangle = new Rectangle(
                        new Point(x, y), BLOCK_WIDTH, BLOCK_HEIGHT);
                Block b = new Block(newRectangle, colors[i]);
                blockList.add(b);
                x += BLOCK_WIDTH;
            }
            y += BLOCK_HEIGHT;
            x = 285 + BLOCK_WIDTH * (i + 1);
        }
        return blockList;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return NUM_OF_BLOCKS_REMOVED;
    }
}

/**
 * 208765982 Idan Inbar.
 */
import biuoop.DrawSurface;
import java.awt.Color;
/**
 * the class GameLevel.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private GameEnvironment gameEnvironment;
    private Counter blockCounter;
    private Counter ballCounter;
    private Counter score;
    private AnimationRunner runner;
    private boolean running;
    private biuoop.KeyboardSensor keyboard;
    private LevelInformation levelInformation;
    //SCREEN
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    //BORDERS
    private static final int BORDER_SIZE = 15;


    /**
     * the function is a constructor for GameLevel.
     * @param levelInformation is the level information we get.
     * @param key is the keyboard we get.
     * @param animationRunner is the animation runner we get.
     * @param score is the score we get.
     */
    public GameLevel(LevelInformation levelInformation, biuoop.KeyboardSensor key,
                     AnimationRunner animationRunner, Counter score) {
        this.levelInformation = levelInformation;
        this.sprites = new SpriteCollection();
        this.gameEnvironment = new GameEnvironment();
        this.blockCounter = new Counter();
        this.ballCounter = new Counter();
        this.score = score;
        this.runner = animationRunner;
        this.keyboard = key;
    }


    /**
     * the function adds a new collidable.
     * @param c is the collidable we asked to add.
     */
    public void addCollidable(Collidable c) {
        this.gameEnvironment.addCollidable(c);
    }

    /**
     * the funciton removes collidable.
     * @param c is the collidable we want to remove.
     */
    public void removeCollidable(Collidable c) {
        this.gameEnvironment.removeCollidable(c);
    }

    /**
     * the function adds a new sprite.
     * @param s is the sprite we asked to add.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }
    /**
     * the function removes a sprite given.
     * @param s is the sprite we asked to remove.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * the function creates borders for the game.
     */
    public void createBorders() {
        BallRemover ballRemover = new BallRemover(this, this.ballCounter);
        //creating the game borders and adding them
        Block topBorder = new Block(new Rectangle(new Point(0, 0), WIDTH, BORDER_SIZE), Color.GRAY);
        Block botBorder = new Block(new Rectangle(new Point(0, 600), WIDTH, 100), Color.GRAY);
        Block rightBorder = new Block(new Rectangle(new Point(WIDTH - BORDER_SIZE, 0), BORDER_SIZE, HEIGHT),
                Color.GRAY);
        Block leftBorder = new Block(new Rectangle(new Point(0, 0), BORDER_SIZE, HEIGHT), Color.GRAY);
        topBorder.addToGame(this);
        botBorder.addToGame(this);
        rightBorder.addToGame(this);
        leftBorder.addToGame(this);
        botBorder.addHitListener(ballRemover);
    }

    /**
     * the function creates blocks for the game.
     */
    public void createBlocks() {
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score);
        NameIndicator nameIndicator = new NameIndicator(this.levelInformation.levelName());
        this.sprites.addSprite(scoreIndicator);
        this.sprites.addSprite(nameIndicator);
        BlockRemover blockRemover = new BlockRemover(this, this.blockCounter);
        for (int i = 0; i < this.levelInformation.blocks().size(); i++) {
            Block b = this.levelInformation.blocks().get(i);
                b.addHitListener(blockRemover);
                b.addToGame(this);
                this.blockCounter.increase(1);
                b.addHitListener(scoreTrackingListener);
            }
    }

    /**
     * the function creates balls for the game.
     */
    public void createBalls() {
        for (int i = 0; i < this.levelInformation.numberOfBalls(); i++) {
            Ball ball = new Ball(new Point(400, 400), 6, Color.white);
            ball.setVelocity(this.levelInformation.initialBallVelocities().get(i));
            ball.setGameEnvironment(this.gameEnvironment);
            ball.addToGame(this);
            this.ballCounter.increase(1);
        }
    }

    /**
     * the function initialize the ball, borders and blocks.
     */
    public void initialize() {
        this.sprites.addSprite(this.levelInformation.getBackground());
        //adding balls to the game
        createBalls();
        //adding borders to the game
        createBorders();
        //adding the blocks to the game
        createBlocks();
        Paddle paddle = new Paddle(keyboard, this.levelInformation.paddleWidth(),
                this.levelInformation.paddleSpeed());
        paddle.addToGame(this);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
            this.sprites.drawAllOn(d);
            this.sprites.notifyAllTimePassed();
            //if the user wants to pause
            if (this.keyboard.isPressed("p")) {
                PauseScreen pauseScreen = new PauseScreen();
                this.runner.run(new KeyPressStoppableAnimation(keyboard,
                        keyboard.SPACE_KEY, pauseScreen));
                this.runner.run(new CountdownAnimation(2, 3, sprites));
            }
            //if there are no more balls in the game
            if (this.ballCounter.getValue() == 0) {
                this.running = false;
            }
            //if there are no blocks left
            if (this.blockCounter.getValue() == 0) {
                this.score.increase(100);
                this.running = false;
            }
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }

    /**
     * the function is a getter for the ballCounter.
     * @return the current number of balls.
     */
    public Counter getBallCounter() {
        return ballCounter;
    }

    /**
     * the function is the animation loop that will activate all.
     */
    public void run() {
        // countdown before turn starts.
        this.runner.run(new CountdownAnimation(2, 3, sprites));
        this.running = true;
        this.runner.run(this);
    }
}

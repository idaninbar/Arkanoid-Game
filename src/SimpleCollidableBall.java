/**
 * 208765982 Idan Inbar.
 */
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import java.awt.Color;
import java.util.Random;

/**
 */
public class SimpleCollidableBall {

    /**
     * Creates and draws a bouncing ball with given center and velocity.
     * @param b Ball
     * @param width int
     * @param height int
     */
    private static void drawAnimation(Ball b, int width, int height) {
        GUI gui = new GUI("title", width, height);
        Sleeper sleeper = new Sleeper();
        int framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            for (Collidable c : b.getGameEnvironment().getCollidables()) {
                c.getCollisionRectangle().drawOn(d);
            }
            b.drawOn(d);
            gui.show(d);
            b.moveOneStep();
            sleeper.sleepFor(millisecondsPerFrame);  // wait for 50 milliseconds.
        }
    }

    /**
     * Generate balls by data given.
     * @param width int
     * @param height int
     * @return Ball.
     */
    public static Ball generateBall(int width, int height) {
        Random rand = new Random();
        Ball b = new Ball(new Point(25, 25), 5, Color.BLUE);
        Block screen = new Block(new Point(0, 0), width, height);
        int bordersSize = 10;
        Block frameHelper1 = new Block(new Point(0, 0), width, bordersSize);
        Block frameHelper2 = new Block(new Point(0, 0), bordersSize, height);
        Block frameHelper3 = new Block(new Point(width - bordersSize, 0), bordersSize, height);
        Block frameHelper4 = new Block(new Point(0, height - bordersSize), width, bordersSize);
        screen.setColor(Color.BLUE);
        frameHelper1.setColor(Color.DARK_GRAY);
        frameHelper2.setColor(Color.DARK_GRAY);
        frameHelper3.setColor(Color.DARK_GRAY);
        frameHelper4.setColor(Color.DARK_GRAY);
        /*Block frame2 = new Block(new Point(0, 0), width, 10);
        Block frame3 = new Block(new Point(0, 0), 10, height);
        Block frame4 = new Block(new Point(width - 10, 0), 10, height);
        Block frame5 = new Block(new Point(0, height - 10), width, 10);
        frame1.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        frame2.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        frame3.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        frame4.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        frame5.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        b.addCollidable(frame2);
        b.addCollidable(frame3);
        b.addCollidable(frame4);
        b.addCollidable(frame5);*/
        Block frame2 = new Block(new Point(50, 50), 200, 200);
        //Block frame3 = new Block(new Point(200, 50), 50, 200);
        frame2.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        //frame3.setColor(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        b.getGameEnvironment().addCollidable(frame2);
        b.getGameEnvironment().addCollidable(frameHelper1);
        b.getGameEnvironment().addCollidable(frameHelper2);
        b.getGameEnvironment().addCollidable(frameHelper3);
        b.getGameEnvironment().addCollidable(frameHelper4);
        //b.addCollidable(frame3);
        b.setVelocity(5, 10);
        return b;
    }


    /**
     * @param args Strings[]
     */
    public static void main(String[] args) {
        int width = 300, height = 300;
        Ball b = generateBall(width, height);
        drawAnimation(b, width, height);
    }
}

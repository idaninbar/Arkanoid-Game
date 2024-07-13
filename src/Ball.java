/**
 * 208765982 Idan Inbar.
 */
import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.Color;

/**
 * the class Ball.
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private java.awt.Color color;
    private Velocity velocity;
    private int maxRight;
    private int maxLeft;
    private int maxUp;
    private int maxDown;
    private GameEnvironment gameEnvironment;
    private List<HitListener> hitListeners = new ArrayList<>();

    /**
     * @param center is the center point of the ball.
     * @param r is the radius of the ball.
     * @param color is the color of the ball.
     */
    public Ball(Point center, int r, java.awt.Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        setVelocity(0, 0);
        this.gameEnvironment = new GameEnvironment();
    }

    /**
     * the function is a comstructor for ball.
     * @param x is the x of the center point.
     * @param y is the y of the center point.
     * @param r is the radius of the ball.
     * @param color is the color of the ball.
     */
    public Ball(double x, double y, int r, java.awt.Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        setVelocity(0, 0);
        this.gameEnvironment = new GameEnvironment();
    }

    /**
     * the function is a getter for the center point of the ball.
     * @return the center point of the ball.
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * the function is a setter for the center point of the ball.
     * @param center is the new center point.
     */
    public void setCenter(Point center) {
        this.center = center;
    }

    /**
     * the function sets a new game environment.
     * @param ge is the new game environment we want to set.
     */
    public void setGameEnv(GameEnvironment ge) {
        this.gameEnvironment = ge;
    }

    /**
     * the function is constructor of the ball.
     * @param x is the x of the center point.
     * @param y is the y of the center point.
     * @param r is the radius of the ball.
     * @param color is the color of the ball.
     * @param ge is the game enviroment of the ball.
     */
    public Ball(int x, int y, int r, java.awt.Color color, GameEnvironment ge) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        setVelocity(0, 0);
        this.gameEnvironment = ge;
    }

    /**
     * the function is a constructor the create a ball with bounds and velocity.
     * @param start is the center point of the ball.
     * @param r is the radius of the ball.
     * @param maxRight is the right bound of the ball.
     * @param maxLeft is the left bound of the ball.
     * @param maxUp is the upper bound of the ball.
     * @param maxDown is the lower bound of the ball.
     * @param v is the velocity of the ball.
     * @return a ball that was created by the given parameters.
     */
    public static Ball makeBall(Point start, int r, int maxRight, int maxLeft, int maxUp,
                                int maxDown, Velocity v) {
        Random rand = new Random();
        if (start == null) {
            int x = rand.nextInt((maxRight - maxLeft) - 2 * r) + (maxLeft + r);
            int y = rand.nextInt((maxDown - maxUp) - 2 * r) + (maxUp + r);
            start = new Point(x, y);
        }
        Ball ball = new Ball(start, r, new Color(rand.nextInt(255) + 1, rand.nextInt(255) + 1,
                rand.nextInt(255) + 1));
        ball.maxRight = maxRight;
        ball.maxLeft = maxLeft;
        ball.maxUp = maxUp;
        ball.maxDown = maxDown;
        ball.velocity = v;
        return ball;
    }

    /**
     * the function gets the x of the center point.
     * @return the x of the center point.
     */
    public double getX() {
        return this.center.getX();
    }

    /**
     * the function gets the y of the center point.
     * @return the y of the center point.
     */
    public double getY() {
        return this.center.getY();
    }

    /**
     * the function gets the radius of the ball.
     * @return the radius of the ball.
     */
    public int getSize() {
        return this.r;
    }

    /**
     * the function gets the game enviroment of the ball.
     * @return the game enviroment of the ball.
     */
    public GameEnvironment getGameEnvironment() {
        return this.gameEnvironment;
    }

    /**
     * the function gets the color of the ball.
     * @return the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * the function gets the right bound of the ball.
     * @return the right bound of the ball.
     */
    public int getMaxRight() {
        return this.maxRight;
    }
    /**
     * the function gets the left bound of the ball.
     * @return the left bound of the ball.
     */
    public int getMaxLeft() {
        return this.maxLeft;
    }
    /**
     * the function gets the upper bound of the ball.
     * @return the upper bound of the ball.
     */
    public int getMaxUp() {
        return this.maxUp;
    }
    /**
     * the function gets the lower bound of the ball.
     * @return the lower bound of the ball.
     */
    public int getMaxDown() {
        return this.maxDown;
    }

    /**
     * the function sets the right bound of the ball.
     * @param bound is the bound that need to be set.
     */
    public void setMaxRight(int bound) {
        this.maxRight = bound;
    }
    /**
     * the function sets the left bound of the ball.
     * @param bound is the bound that need to be set.
     */
    public void setMaxLeft(int bound) {
        this.maxLeft = bound;
    }
    /**
     * the function sets the upper bound of the ball.
     * @param bound is the bound that need to be set.
     */
    public void setMaxUp(int bound) {
        this.maxUp = bound;
    }
    /**
     * the function sets the lower bound of the ball.
     * @param bound is the bound that need to be set.
     */
    public void setMaxDown(int bound) {
        this.maxDown = bound;
    }

    /**
     * the function draws a colored ball.
     * @param surface is the surface that the ball drawn on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.getX(), (int) this.getY(), this.getSize());
        drawFrame(surface);
    }
    /**
     * the fucntion draws a colored frame for the ball.
     * @param surface is the surface that the frame is drawn on.
     */
    public void drawFrame(DrawSurface surface) {
        surface.setColor(Color.black);
        surface.drawCircle((int) this.getX(), (int) this.getY(), this.getSize());
    }

    /**
     * the function sets the velocity of the ball.
     * @param v is the velocity that was given.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * the function sets the velocity of the ball.
     * @param dx is the first coordinate of the velocity.
     * @param dy is the second coordinate of the velocity.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * the function gets the velocity of the ball.
     * @return the velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * the fucntion sets a new game enviroment.
     * @param g is the new game enviroment we set.
     */
    public void setGameEnvironment(GameEnvironment g) {
        this.gameEnvironment = g;
    }
    /**
     * the function calculates where the ball will be on a line when we add it's velocity.
     * @return a line which the start of it is the center of the ball and the end is where it will,
     * be after we add it's velocity.
     */
    public Line ballTrajectory() {
        //using math floor to calculate the largest double value
        Point startOfTrajectory = new Point(
                Math.floor(this.center.getX()), Math.floor(this.center.getY()));
        Point endOfTrajectory = new Point(
                Math.floor(this.center.getX() + this.velocity.getDx()),
                Math.floor(this.center.getY() + this.velocity.getDy()));
        return new Line(startOfTrajectory, endOfTrajectory);
    }

    /**
     * the function changes the center of the ball according to the side of the object it hits.
     * @param c is the information that we are given about the hit.
     */
    public void moveCloseToObject(CollisionInfo c) {
        int x = 0, y = 0;
        if (c.collisionPoint().onLine(c.collisionObject().getCollisionRectangle().getUp())) {
            y--;
        }
        if (c.collisionPoint().onLine(c.collisionObject().getCollisionRectangle().getDown())) {
            y++;
        }
        if (c.collisionPoint().onLine(c.collisionObject().getCollisionRectangle().getRight())) {
            x++;
        }
        if (c.collisionPoint().onLine(c.collisionObject().getCollisionRectangle().getLeft())) {
            x--;
        }
        this.center = new Point(this.center.getX() + x, this.center.getY() + y);
    }

    /**
     * the function is sets the moves of the ball.
     */
    public void moveOneStep() {
        CollisionInfo c = this.getGameEnvironment().getClosestCollision(this.ballTrajectory());
        // if there is a hit
        if (c != null) {
            this.moveCloseToObject(c);
            this.setVelocity(c.collisionObject().hit(this, c.collisionPoint(), this.velocity));
        } else {
            //if there is not hit
            this.center = this.velocity.applyToPoint(this.center);
        }
    }


    /**
     * the function activates the function moveOneStep.
     */
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * the function adds ball as a sprite to the game.
     * @param g is the game we add ball to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     * the function removes ball from the game.
     * @param g is the game we remove the ball from.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
    }
}
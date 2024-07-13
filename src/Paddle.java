/**
 * 208765982 Idan Inbar.
 */
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * the class Paddle.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Block paddle;
    private Point upperLeft;
    private int step;
    private java.awt.Color color;
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 600;
    private  int width = 100;
    private  int height = 10;
    private static final int BORDER_WIDTH = 15;
    private List<Ball> list;
    static final double EPSILON = 1E-6;

    /**
     * the function is a constructor for paddle.
     * @param key is the key given.
     * @param width is the width of the paddle.
     * @param step is the speed of the paddle.
     */
    public Paddle(KeyboardSensor key, int width, int step) {
        this.keyboard = key;
        this.upperLeft = new Point((FRAME_WIDTH / 2) - width / 2, FRAME_HEIGHT - height - 40);
        this.color = Color.ORANGE;
        this.paddle = new Block(upperLeft, width, height, Color.orange);
        this.step = step;
        this.list = new ArrayList<>();
        this.width = width;
    }


    /**
     * the function moves the paddle to the left.
     */
    public void moveLeft() {
        double x = this.upperLeft.getX() - this.step;
        double y = this.upperLeft.getY();
        this.upperLeft = new Point(x, y);
        this.paddle = new Block(this.upperLeft, width, height, this.paddle.getColor());
    }

    /**
     * the function moves the paddle to the right.
     */
    public void moveRight() {
        double x = this.upperLeft.getX() + this.step;
        double y = this.upperLeft.getY();
        this.upperLeft = new Point(x, y);
        this.paddle = new Block(this.upperLeft, width, height, this.paddle.getColor());
    }

    /**
     * the function checks what is the players wanted movement and moves accordingly.
     */
    public void timePassed() {
        isInPad();
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            if (this.upperLeft.getX() == BORDER_WIDTH) {
                return;
            }
            if (upperLeft.getX() - this.step < BORDER_WIDTH) {
                this.upperLeft = new Point(BORDER_WIDTH, this.upperLeft.getY());
                changePaddle(this.upperLeft);
            } else {
                moveLeft();
            }
        }
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            if (this.upperLeft.getX() + width == FRAME_WIDTH) {
                return;
            }
            if (upperLeft.getX() + width + this.step > FRAME_WIDTH - BORDER_WIDTH) {
                this.upperLeft = new Point(FRAME_WIDTH - BORDER_WIDTH - width, this.upperLeft.getY());
                changePaddle(this.upperLeft);
            } else {
                moveRight();
            }
        }
    }

    /**
     * the function cahnges the upper ledt point of the paddle.
     * @param upperLeft is the new upper left point.
     */
    public void changePaddle(Point upperLeft) {
        Color paddleColor = this.paddle.getColor();
        this.paddle = new Block(upperLeft, width, height);
        this.paddle.setColor(paddleColor);
    }


    /**
     * the function is a setter for color.
     * @param color is the new color we want to set.
     */
    public void setColor(java.awt.Color color) {
        this.color = color;
    }

    /**
     * the function draws the paddle on the given surface.
     * @param d is the surface that we draw on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.paddle.getCollisionRectangle().getUpperLeft().getX(),
                (int) this.paddle.getCollisionRectangle().getUpperLeft().getY(),
                (int) this.paddle.getCollisionRectangle().getWidth(),
                (int) this.paddle.getCollisionRectangle().getHeight());
        drawFrame(d);
    }
    /**
     * the function draws the paddle frame on the given surface.
     * @param d is the surface that we draw on.
     */
    public void drawFrame(DrawSurface d) {
        d.setColor(Color.black);
        d.drawRectangle((int) this.paddle.getCollisionRectangle().getUpperLeft().getX(),
                (int) this.paddle.getCollisionRectangle().getUpperLeft().getY(),
                (int) this.paddle.getCollisionRectangle().getWidth(),
                (int) this.paddle.getCollisionRectangle().getHeight());
    }

    /**
     * the function gets the collision rectangle.
     * @return a rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.paddle.getCollisionRectangle();
    }
    /**
     * the function checks if a point is on the paddle.
     * @param p is the point we check about.
     * @return true if it's on the paddle and false otherwise.
     */
    public Boolean isOnPad(Point p) {
        Line left = this.paddle.getCollisionRectangle().getLeft();
        Line right = this.paddle.getCollisionRectangle().getRight();
        Line up = this.paddle.getCollisionRectangle().getUp();
        Line down = this.paddle.getCollisionRectangle().getDown();

        return isOn(left.start(), p, left.end()) || isOn(right.start(), p, right.end())
                || isOn(up.start(), p, up.end()) || isOn(down.start(), p, down.end());
    }
    /**
     * the function checks if a point is on a line.
     * @param p1 is the starting point of the line.
     * @param p2 is the point that we check whether it's on the line.
     * @param p3 is the ending point of the line.
     * @return true of p2 is on the line and false otherwise.
     */
    public boolean isOn(Point p1, Point p2, Point p3) {
        return p2.getX() <= Math.max(p1.getX(), p3.getX()) && p2.getX() >= Math.min(p1.getX(), p3.getX())
                && p2.getY() <= Math.max(p1.getY(), p3.getY()) && p2.getY() >= Math.min(p1.getY(), p3.getY());
    }

    /**
     * the function checks if the ball is in the paddle, and changes it center accordingly.
     */
    public void isInPad() {
        for (Ball ball : list) {
            double x = ball.getX();
            double y = ball.getY();
            double xPad = this.upperLeft.getX();
            double yPad = this.upperLeft.getY();
            //if the ball hits the left side of the paddle
            if ((xPad <= x) && (x <= (xPad + width / 2.0)) && (yPad <= y) && (y <= yPad + height)) {
                ball.setCenter(new Point(x - ball.getSize(), y));
                ball.setVelocity(ball.getVelocity().getDx(), ball.getVelocity().getDy());
                //if the ball hits the right side of the paddle
            } else if ((xPad + width / 2.0 <= x) && (x <= xPad + width) && (yPad <= y) && (y <= yPad + height)) {
                ball.setCenter(new Point(x + ball.getSize(), y));
                ball.setVelocity(ball.getVelocity().getDx() * -1, ball.getVelocity().getDy());
            }
        }
    }
    /**
     * the function calculates the new velocity of a sprite after hitting the paddle.
     * @param collisionPoint is the hitting point.
     * @param currentVelocity is the velocity of the sprite.
     * @param hitter is the ball.
     * @return the velocity of the sprite according to the collision point.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if (!isOnPad(collisionPoint)) {
            return currentVelocity;
        }
        //checks where the ball hit on the block
        double location = collisionPoint.distance(this.upperLeft);
        double pace = Math.sqrt(Math.pow(currentVelocity.getDy(), 2) + Math.pow(currentVelocity.getDx(), 2));
        //splitting the paddle's width to 5 regions.
        int leftMost = (width / 5);
        int left = (width / 5) * 2;
        int middle = (width / 5) * 3;
        int right = (width / 5) * 4;
        //if it hits the rightMost side of the paddle
        if ((location <= leftMost) && (collisionPoint.getY() - this.upperLeft.getY() < EPSILON)) {
            return Velocity.fromAngleAndSpeed(300, pace);
            //if it hits between the leftmost and the left
        } else if ((location <= left) && (location >= leftMost)
                && (collisionPoint.getY() - this.upperLeft.getY() < EPSILON)) {
            return Velocity.fromAngleAndSpeed(330, pace);
            //if it hits between the left and the middle
        } else if ((location <= middle) && (location >= left)
                && (collisionPoint.getY() - this.upperLeft.getY() < EPSILON)) {
            return new Velocity(currentVelocity.getDx(), currentVelocity.getDy() * -1);
            //if it hits between the middle and the right
        } else if ((location <= right) && (location >= middle)
                && (collisionPoint.getY() - this.upperLeft.getY() < EPSILON)) {
            return Velocity.fromAngleAndSpeed(30, pace);
            //if it hits between the right and the right most
        } else if ((location <= width) && (collisionPoint.getY() - this.upperLeft.getY() < EPSILON)) {
            return Velocity.fromAngleAndSpeed(60, pace);
        }
        return this.paddle.hit(hitter, collisionPoint, currentVelocity);
    }

    /**
     * the function adds the paddle to the game.
     * @param g is the game we add paddle to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

}

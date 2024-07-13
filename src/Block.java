/**
 * 208765982 Idan Inbar
 */
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * the class Block.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle collisionRectangle;
    private java.awt.Color color;
    private List<HitListener> hitListeners = new ArrayList<>();
    static final double EPSILON = 1E-6;


    /**
     * the function is a constructor for Block.
     * @param rec is the block.
     */
    public Block(Rectangle rec) {
        this.collisionRectangle = rec;
        this.color = Color.GRAY;
    }

    /**
     * the function is a constructor for Block.
     * @param rec is the block.
     * @param color is the color of the block.
     */
    public Block(Rectangle rec,  java.awt.Color color) {
        this.collisionRectangle = rec;
        this.color = color;
    }
    /**
     * the function is a Block constructor.
     * @param upperLeft is the upper left point of the rectangle.
     * @param width is the width of the rectangle.
     * @param height is the height of the rectangle.
     * @param color is the color of the rectangle.
     */
    public Block(Point upperLeft, double width, double height, java.awt.Color color) {
        Rectangle r = new Rectangle(upperLeft, width, height);
        this.collisionRectangle = r;
        this.color = color;
    }

    /**
     * the function is a block constructor.
     * @param upperLeft is the upper left point of the rectangle.
     * @param width is the width of the rectangle.
     * @param height is the height of the rectangle.
     */
    public Block(Point upperLeft, int width, int height) {
        Rectangle r = new Rectangle(upperLeft, width, height);
        this.collisionRectangle = r;
        this.color = Color.gray;
    }


    @Override
    public Rectangle getCollisionRectangle() {
        return this.collisionRectangle;
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
     * the function checks if a point is one the rectangle.
     * @param p is the point we check about.
     * @return true if it's on the rectangle and false otherwise.
     */
    public Boolean isOnRec(Point p) {
        Line left = this.collisionRectangle.getLeft();
        Line right = this.collisionRectangle.getRight();
        Line up = this.collisionRectangle.getUp();
        Line down = this.collisionRectangle.getDown();

        return isOn(left.start(), p, left.end()) || isOn(right.start(), p, right.end())
                || isOn(up.start(), p, up.end()) || isOn(down.start(), p, down.end());
    }

    /**
     * the function checks if a point is on the left or right side of the rectangle.
     * @param p is the point we check about.
     * @return true if it's on the right or left side and false otherwise.
     */
    public Boolean isOnLeftRight(Point p) {
        Line left = this.collisionRectangle.getLeft();
        Line right = this.collisionRectangle.getRight();

        return isOn(left.start(), p, left.end()) || isOn(right.start(), p, right.end());
    }
    /**
     * the function checks if a point is on the upper or lower side of the rectangle.
     * @param p is the point we check about.
     * @return true if it's on the upper or lower side and false otherwise.
     */
    public Boolean isOnUpDown(Point p) {
        Line up = this.collisionRectangle.getUp();
        Line down = this.collisionRectangle.getDown();

        return isOn(up.start(), p, up.end()) || isOn(down.start(), p, down.end());
    }

    /**
     * the function gets the block's color.
     * @return is the color of the block.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * the function sets a new color for block.
     * @param color is the new color.
     */
    public void setColor(java.awt.Color color) {
        this.color = color;
    }
    /**
     * the function checks if a given point is equals the edges of the rectangle.
     * @param p is the point we check about.
     * @return true if it's equal to one of the edges and false otherwise.
     */
    public Boolean isOnEdge(Point p) {
        return p.equals(this.collisionRectangle.getUpperLeft()) || p.equals(this.collisionRectangle.getUpperRight())
                || p.equals(this.collisionRectangle.getLowerLeft())
                || p.equals(this.collisionRectangle.getLowerRight());
    }

    /**
     * the function calculates the velocity according to the heat point.
     * @param collisionPoint is the point of the collision.
     * @param currentVelocity is the current velocity.
     * @return a new velocity according to the hit point.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        this.notifyHit(hitter);
        //if the point isn't on the rectangle return the same velocity
        if (!isOnRec(collisionPoint)) {
            return currentVelocity;
        }
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        //if the point hits the edges change both of the vertical's horizontal and vertical direction.
        if (isOnEdge(collisionPoint)) {
            //if the ball's direction is right and up
           if (dx > 0 && dy < 0) {
               //if the ball hits the upper left corner
               if (collisionPoint.distance(this.collisionRectangle.getUpperLeft()) < EPSILON) {
                   return new Velocity(dx * -1, dy);
               }
               //if the ball hits the bottom left corner
               if (collisionPoint.distance(this.collisionRectangle.getLowerLeft()) < EPSILON) {
                   return new Velocity(dx, dy * -1);
               }
               //if the ball hits the bottom right corner
               if (collisionPoint.distance(this.collisionRectangle.getLowerRight()) < EPSILON) {
                   return new Velocity(dx, dy * -1);
               }
           }
           //if the ball's direction is right and down
           if (dx > 0 && dy > 0) {
               //if the ball hits the upper left corner
               if (collisionPoint.distance(this.collisionRectangle.getUpperLeft()) < EPSILON) {
                   return new Velocity(dx * -1, dy);
               }
               //if the ball hits the bottom left corner
               if (collisionPoint.distance(this.collisionRectangle.getLowerLeft()) < EPSILON) {
                   return new Velocity(dx * -1, dy);
               }
               //if the ball hits the upper right corner
               if (collisionPoint.distance(this.collisionRectangle.getUpperRight()) < EPSILON) {
                   return new Velocity(dx, dy * -1);
               }
           }
           //if the ball's direction is left and up
           if (dx < 0 && dy < 0) {
               //if the ball hits the bottom right corner
               if (collisionPoint.distance(this.collisionRectangle.getLowerRight()) < EPSILON) {
                   return new Velocity(dx, dy * -1);
               }
               //if the ball hits the upper right corner
               if (collisionPoint.distance(this.collisionRectangle.getUpperRight()) < EPSILON) {
                   return new Velocity(dx * -1, dy);
               }
               //if the ball hits the bottom left corner
               if (collisionPoint.distance(this.collisionRectangle.getLowerLeft()) < EPSILON) {
                   return new Velocity(dx, dy * -1);
               }
           }
           //if the ball's direction is left and down
           if (dx < 0 && dy > 0) {
               //if the ball hits the upper right corner
               if (collisionPoint.distance(this.collisionRectangle.getUpperRight()) < EPSILON) {
                   return new Velocity(dx * -1, dy);
               }
               //if the ball hits the bottom right corner
               if (collisionPoint.distance(this.collisionRectangle.getLowerRight()) < EPSILON) {
                   return new Velocity(dx * -1, dy);
               }
               //if the ball hits the upper left corner
               if (collisionPoint.distance(this.collisionRectangle.getUpperLeft()) < EPSILON) {
                   return new Velocity(dx, dy * -1);
               }
           }
        }
        //if the point hits the left or right side change the vertical direction.
        if (isOnLeftRight(collisionPoint) && !isOnEdge(collisionPoint)) {
            dx = dx * -1;
        }
        //if the point hits the upper or lower side change the horizontal direction.
        if (isOnUpDown(collisionPoint) && !isOnEdge(collisionPoint)) {
            dy = dy * -1;
        }
        return new Velocity(dx, dy);
    }

    /**
     * the function draws the block on given surface.
     * @param d is the surface we draw on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.collisionRectangle.getUpperLeft().getX(),
                (int) this.collisionRectangle.getUpperLeft().getY(), (int) this.collisionRectangle.getWidth(),
                (int) this.collisionRectangle.getHeight());
        d.setColor(Color.black);
        drawFrame(d);
    }
    /**
     * the function draws the block's frame on given surface.
     * @param d is the surface we draw on.
     */
    public void drawFrame(DrawSurface d) {
        d.setColor(Color.black);
        d.drawRectangle((int) this.collisionRectangle.getUpperLeft().getX(),
                (int) this.collisionRectangle.getUpperLeft().getY(), (int) this.collisionRectangle.getWidth(),
                (int) this.collisionRectangle.getHeight());
    }
    @Override
    public void timePassed() {
    }

    /**
     * the function adds block to the game as a collidable.
     * @param g is the game we add block to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * the funciton removes block from the game.
     * @param g is the game we remove a block from.
     */
    public void removeFromGame(GameLevel g) {
        g.removeSprite(this);
        g.removeCollidable(this);
    }

    /**
     * the function notify the block that it being hit.
     * @param hitter is the ball that hits the block.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}

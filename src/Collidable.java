/**
 * 208765982 Idan Inbar.
 */
public interface Collidable {
    /**
     * the fucntion gets the rectnagle.
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /** Notify the object that we collided with it at collisionPoint with,
     *  a given velocity.
     * @param collisionPoint is the point of the collision.
     * @param currentVelocity is the current velocity.
     * @param hitter is the ball.
     * @return the new velocity after the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
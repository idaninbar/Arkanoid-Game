/**
 * 208765982 Idan Inbar.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable object;
    /**
     * this function is a constructor for CollisionInfo.
     * @param collisionPoint is the collision point.
     * @param object is the object that collidable.
     */
    public CollisionInfo(Point collisionPoint, Collidable object) {
        this.collisionPoint = collisionPoint;
        this.object = object;
    }

    /**
     * the fucntion returns the collision point.
     * @return the collision point.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * the function returns the collision object.
     * @return the collidabale object.
     */
    public Collidable collisionObject() {
        return this.object;
    }

}

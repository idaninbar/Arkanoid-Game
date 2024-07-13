/**
 * 208765982 Idan Inbar.
 */
import java.util.ArrayList;
import java.util.List;

/**
 * the class GameEnviroment.
 */
public class GameEnvironment {

    private ArrayList<Collidable> list = new ArrayList<>();

    /**
     * the function returns th list of collidables.
     * @return the list of collidables.
     */
    public List<Collidable> getCollidables() {
        return this.list;
    }
    /**
     * the function adds a new collidable to the collidable list.
     * @param c is the new collidable we add.
     */
    public void addCollidable(Collidable c) {
        this.list.add(c);
    }

    /**
     * the function removes collidable from the list.
     * @param c is the collidable we want to remove.
     */
    public void removeCollidable(Collidable c) {
        this.list.remove(c);
    }

    /**
     * the function checks what's the closest collidable from the list of collidables,
     * to the starting point of line trajectory.
     * @param trajectory is the line that we check what collidable is the closest to it's starting point.
     * @return the collision info of the closest collidable.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        Collidable c = null;
        Point temp;
        Point closest = null;
        // loop that's runs on the list of the collidables.
        for (Collidable col : list) {
            //if the closest intersection exist.
            if (trajectory.closestIntersectionToStartOfLine(col.getCollisionRectangle()) != null) {
                temp = trajectory.closestIntersectionToStartOfLine(col.getCollisionRectangle());
                //initializing closest for the first time if such point exist.
                if (closest == null && temp != null) {
                    closest = temp;
                    c = col;
                }
                //checks if there is a point that closer than the current closest point,
                //and changes it if it does closer.
                if (temp.distance(trajectory.start()) < closest.distance(trajectory.start())) {
                    closest = temp;
                    c = col;
                }
            }
        }
        if (closest == null) {
            return null;
        }
        return new CollisionInfo(closest, c);
    }
}

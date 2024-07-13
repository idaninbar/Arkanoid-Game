/**
 * 208765982 Idan Inbar.
 */
import biuoop.DrawSurface;
import java.util.ArrayList;
/**
 * the class SpriteCollection.
 */
public class SpriteCollection {
    private ArrayList<Sprite> list = new ArrayList<>();

    /**
     * the function adds a sprite to the Sprite list.
     * @param s is the sprite we want to add.
     */
    public void addSprite(Sprite s) {
        this.list.add(s);
    }

    /**
     * the funciton removes a sprite from the sprite list.
     * @param s is the sprite we want to remove.
     */
    public void removeSprite(Sprite s) {
        this.list.remove(s);
    }

    /**
     * the function call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        ArrayList<Sprite> sprites = new ArrayList<Sprite>(this.list);
        for (Sprite sprite : sprites) {
            sprite.timePassed();
        }
    }

    /**
     * the function call drawOn(d) on all sprites.
     * @param d is the draw surface we want to draw on.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite sprite : this.list) {
            sprite.drawOn(d);
        }
    }
    /**
     * the function call drawFrame(d) on all sprites.
     * @param d is the draw surface we want to draw on.
     */
    public void drawAllFrame(DrawSurface d) {
        for (Sprite sprite : this.list) {
            sprite.drawFrame(d);
        }
    }
}

import biuoop.DrawSurface;
/**
 * 208765982 Idan Inbar.
 */
public interface Sprite {
    /**
     * the function draw the sprite to the screen.
     * @param d is the surface we draw on.
     */
    void drawOn(DrawSurface d);

    /**
     * the funciton notify the object that the time has passed.
     */
    void timePassed();

    /**
     * the function draws the frame of the sprite to the screen.
     * @param d is the surface we draw on.
     */
    void drawFrame(DrawSurface d);
}
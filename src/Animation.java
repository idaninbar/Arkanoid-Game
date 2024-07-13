/**
 * 208765982 Idan Inbar.
 */
import biuoop.DrawSurface;

/**
 * the interface of Animation.
 */
public interface Animation {
    /**
     * the function doOneFrame signature.
     * @param d is our surface.
     */
    void doOneFrame(DrawSurface d);

    /**
     * the function shouldStop signature.
     * @return a boolean type.
     */
    boolean shouldStop();
}
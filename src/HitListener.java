/**
 * 208765982 Idan Inbar.
 */
public interface HitListener {
    /**
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     * @param beingHit is the object that is hit.
     * @param hitter is the ball that hits.
     */
    void hitEvent(Block beingHit, Ball hitter);
}

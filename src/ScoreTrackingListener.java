/**
 * 208765982 Idan Inbar.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;
    /**
     * the function is a constructor for ScoreTrackingListener.
     * @param scoreCounter is the score counter we get.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * the function is tracking the score according to the hits.
     * @param beingHit is the object that is hit.
     * @param hitter is the ball that hits.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}
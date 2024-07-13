/**
 * 208765982 Idan Inbar.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     * the function is a constructor for BallsRemover.
     * @param game is the game we get.
     * @param removedBalls is the balls that we removed.
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }

    /**
     * the function is removes a block from the game.
     * @param beingHit is the object that is hit.
     * @param hitter is the ball that hits.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}

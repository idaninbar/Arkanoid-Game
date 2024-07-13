/**
 * 208765982 Idan Inbar.
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * the function is a constructor for BlockRemover.
     * @param game is the game we get.
     * @param removedBlocks is the blocks that we removed.
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * the function is removes a block from the game.
     * @param beingHit is the object that is hit.
     * @param hitter is the ball that hits.
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(this.game);
        this.remainingBlocks.decrease(1);
    }
}
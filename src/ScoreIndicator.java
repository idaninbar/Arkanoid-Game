import biuoop.DrawSurface;

import java.awt.Color;


/**
 * 208765982 Idan Inbar.
 */
public class ScoreIndicator implements Sprite, HitNotifier {
    private Counter score;
    /**
     * the function is a constructor for ScoreIndicator.
     * @param score is the current score.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    @Override
    public void addHitListener(HitListener hl) {
    }

    @Override
    public void removeHitListener(HitListener hl) {
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(400, 9, "Score: " + this.score.getValue(), 10);
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void drawFrame(DrawSurface d) {
    }
}

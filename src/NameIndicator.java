import biuoop.DrawSurface;

import java.awt.Color;


/**
 * 208765982 Idan Inbar.
 */
public class NameIndicator implements Sprite {
    private String name;
    /**
     * the function is a constructor for ScoreIndicator.
     * @param name is the current score.
     */
    public NameIndicator(String name) {
        this.name = name;
    }


    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(500, 9, "Level Name: " + this.name, 10);
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void drawFrame(DrawSurface d) {
    }
}

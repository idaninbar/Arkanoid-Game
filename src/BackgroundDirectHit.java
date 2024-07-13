import biuoop.DrawSurface;

import java.awt.Color;

/**
 * 208765982 Idan Inbar.
 */
public class BackgroundDirectHit implements Sprite {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.BLACK);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.BLUE);
        //drawing the circles of the target
        d.drawCircle(400, 162, 60);
        d.drawCircle(400, 162, 90);
        d.drawCircle(400, 162, 120);
        //drawing the lines of the target
        d.drawLine(400, 182, 400, 302);
        d.drawLine(420, 162, 540, 162);
        d.drawLine(380, 162, 260, 162);
        d.drawLine(400, 152, 400, 22);

    }

    @Override
    public void timePassed() {
    }

    @Override
    public void drawFrame(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle(0, 0, WIDTH, HEIGHT);
    }
}

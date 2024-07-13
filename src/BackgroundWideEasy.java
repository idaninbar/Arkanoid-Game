import biuoop.DrawSurface;

import java.awt.Color;

/**
 * 208765982 Idan Inbar.
 */
public class BackgroundWideEasy implements Sprite {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    @Override
    public void drawOn(DrawSurface d) {
        //drawing the screen color
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        //drawing the sun
        d.setColor(Color.decode("#efe7b0"));
        d.fillCircle(200, 80, 60);
        //drawing the lines of the sun
        for (int i = 0; i < 800; i = i + 10) {
            d.drawLine(200, 100, i, 200);
        }
        d.setColor(Color.decode("#ecd749"));
        d.fillCircle(200, 80, 50);
        d.setColor(Color.decode("#ffe118"));
        d.fillCircle(200, 80, 40);

    }

    @Override
    public void timePassed() {
    }

    @Override
    public void drawFrame(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(0, 0, WIDTH, HEIGHT);
    }
}

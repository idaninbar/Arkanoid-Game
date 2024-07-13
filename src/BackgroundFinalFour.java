import biuoop.DrawSurface;

import java.awt.Color;

/**
 * 208765982 Idan Inbar.
 */
public class BackgroundFinalFour implements Sprite {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.decode("#1788d0"));
        d.fillRectangle(0, 0, WIDTH, HEIGHT);
        //the lines under the first cloud
        d.setColor(Color.white);
        for (int i = 0; i < 10; i++) {
            d.drawLine(110 + 10 * i, 440, 100 + i * 15, 650);
        }
        //this lines under the second cloud
        for (int i = 0; i < 10; i++) {
            d.drawLine(610 + 10 * i, 540, 100 + i * 15, 1000);
        }

        //the first cloud
        d.setColor(Color.decode("#cccccc"));
        d.fillCircle(100, 400, 23);
        d.fillCircle(120, 420, 27);
        d.setColor(Color.decode("#bbbbbb"));
        d.fillCircle(145, 400, 25);
        d.fillCircle(155, 435, 29);
        d.setColor(Color.decode("#aaaaaa"));
        d.fillCircle(180, 420, 31);
        d.fillCircle(205, 400, 29);
        d.fillCircle(210, 430, 25);
        //the second cloud
        d.setColor(Color.decode("#cccccc"));
        d.fillCircle(600, 500, 23);
        d.fillCircle(620, 520, 27);
        d.setColor(Color.decode("#bbbbbb"));
        d.fillCircle(645, 500, 25);
        d.fillCircle(655, 535, 29);
        d.setColor(Color.decode("#aaaaaa"));
        d.fillCircle(680, 520, 31);
        d.fillCircle(705, 500, 29);
        d.fillCircle(710, 530, 25);
    }

    @Override
    public void timePassed() {
    }

    @Override
    public void drawFrame(DrawSurface d) {
        d.setColor(Color.decode("#1788d0"));
        d.fillRectangle(0, 0, WIDTH, HEIGHT);
    }
}

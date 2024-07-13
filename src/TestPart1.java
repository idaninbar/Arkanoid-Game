import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TestPart1 {
    public static void main(String[] args) {
        List<Block> lst = new ArrayList<>();
        GameEnvironment gameEnvironment = new GameEnvironment();
        Block topBorder = new Block(new Rectangle(new Point(0, -200), 400, 220), Color.GRAY);
        Block botBorder = new Block(new Rectangle(new Point(0, 380), 400, 220), Color.GRAY);
        Block rightBorder = new Block(new Rectangle(new Point(380, 0), 220, 400), Color.GRAY);
        Block leftBorder = new Block(new Rectangle(new Point(-200, 0), 220, 400), Color.GRAY);
        gameEnvironment.addCollidable(topBorder);
        gameEnvironment.addCollidable(botBorder);
        gameEnvironment.addCollidable(rightBorder);
        gameEnvironment.addCollidable(leftBorder);

        Ball ball = new Ball(50, 150, 5, Color.BLUE);
        ball.setGameEnv(gameEnvironment);
        for (int i = 0; i < 10; i++) {
            Block blk = new Block(new Rectangle(new Point(i*20+20, i*20+20),50,20), Color.GRAY);
            lst.add(blk);
            gameEnvironment.addCollidable(blk);
        }

        GUI gui = new GUI("title", 400, 400);
        Sleeper sleeper = new Sleeper();
        ball.setVelocity(10,-5);
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            for (Collidable blk: gameEnvironment.getCollidables()) {
                d.setColor(Color.PINK);
                d.drawRectangle((int)blk.getCollisionRectangle().getUpperLeft().getX(),
                        (int)blk.getCollisionRectangle().getUpperLeft().getY(),
                        (int)blk.getCollisionRectangle().getWidth(),(int)blk.getCollisionRectangle().getHeight());
                d.fillRectangle((int)blk.getCollisionRectangle().getUpperLeft().getX(),
                        (int)blk.getCollisionRectangle().getUpperLeft().getY(),
                        (int)blk.getCollisionRectangle().getWidth(),(int)blk.getCollisionRectangle().getHeight());
            }
            ball.moveOneStep();
            ball.drawOn(d);
            gui.show(d);
            // wait for 50 milliseconds.
            sleeper.sleepFor(50);
        }

    }
}

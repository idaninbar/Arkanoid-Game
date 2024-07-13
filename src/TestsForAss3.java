//import biuoop.DrawSurface;
//import biuoop.GUI;
//import biuoop.KeyboardSensor;
//
//import java.awt.*;
//import java.util.List;
//
///**
// * This class is a tester for ass3.
// * */
//public class TestsForAss3 {
//    /*assuming screen size of 700 by 700*/
//
//    /**
//     * This is a method to test Rectangle class.
//     * */
//    public void testsForRectangleAndLine() {
//
//        /*in range*/
//        Point s4 = new Point(-50.0, 50.0);
//        Point s5 = new Point(-50.0, -50.0);
//        Point s6 = new Point(50.0, -50.0);
//        Point s7 = new Point(50.0, 50.0);
//
//        Rectangle r4 = new Rectangle(s4, 50.0, 50.0);
//        Rectangle r5 = new Rectangle(s5, 50.0, 50.0);
//        Rectangle r6 = new Rectangle(s6, 50.0, 50.0);
//        Rectangle r7 = new Rectangle(s7, 350.0, 550.0);
//
//
//        /*negative width/height.*/
//        Rectangle r8 = new Rectangle(s7, -50.0, 50.0);
//        Rectangle r9 = new Rectangle(s7, -50.0, -50.0);
//        Rectangle r10 = new Rectangle(s7, 50.0, -50.0);
//        /* 0 width/height.*/
//        Rectangle r11 = new Rectangle(s7, 0.0, 10.0);
//        Rectangle r12 = new Rectangle(s7, 10.0, 0.0);
//        Rectangle r13 = new Rectangle(s7, 0.0, 0.0);
//
//        assert (r7.getHeight() == 550);
//        assert (r7.getWidth() == 350);
//        assert (r7.getUpperLeft().equals(s7));
//
//        /*create lines to intersect with rectangle r7*/
//
//        /*no intersection*/
//        Point e = new Point(200, 800);
//        Point f = new Point(200, 700);
//        Line lj = new Line(e, f);
//
//        assert(r7.intersectionPoints(lj).size() == 0);
//        assert(lj.closestIntersectionToStartOfLine(r7) == null);
//
//        Point g = new Point(500, 300);
//        Point h = new Point(600, 300);
//        Line lk = new Line(g, h);
//
//        assert(r7.intersectionPoints(lk).size() == 0);
//        assert(lk.closestIntersectionToStartOfLine(r7) == null);
//
//        Point i = new Point(600, 600);
//        Point j = new Point(500, 400);
//        Line ll = new Line(e, f);
//
//        assert(r7.intersectionPoints(ll).size() == 0);
//        assert(ll.closestIntersectionToStartOfLine(r7) == null);
//
//        /*lines with more than one intersect with the same side*/
//        Point c = new Point(50, 600);
//        Point a = new Point(50,50);
//        Line lh = new Line(c, a);
//        assert(r7.intersectionPoints(lh).size() == 2);
//        assert (lh.closestIntersectionToStartOfLine(r7).equals(c));
//
//        Point c1 = new Point(50,500);
//        Line lb = new Line(c, c1);
//        assert(r7.intersectionPoints(lb).size() == 1);
//        assert (lb.closestIntersectionToStartOfLine(r7).equals(c));
//
//        Point d1 = new Point(50,500);
//        Point b = new Point(400,50);
//        Line lc = new Line(a, d1);
//        assert(r7.intersectionPoints(lc).size() == 1);
//        assert (lc.closestIntersectionToStartOfLine(r7).equals(a));
//
//        Point i1 = new Point(200,600);
//        Point u = new Point(300,600);
//        Line ld = new Line(i1, u);
//        assert(r7.intersectionPoints(ld).size() == 0);
//        assert (ld.closestIntersectionToStartOfLine(r7) == null);
//
//        /*intersect one point*/
//        Point k = new Point(400, 700);
//        Point d = new Point(400, 600);
//        Line lm = new Line(k, d);
//
//        assert(r7.intersectionPoints(lm).size() == 1 || r7.intersectionPoints(lm).size() == 2);
//        assert(r7.intersectionPoints(lm).get(0).equals(d));
//        assert(lm.closestIntersectionToStartOfLine(r7).equals(d));
//
//        Point l = new Point(500, 600);
//        Line ln = new Line(l, d);
//
//        assert(r7.intersectionPoints(ln).size() == 1 || r7.intersectionPoints(ln).size() == 2);
//        assert(r7.intersectionPoints(ln).get(0).equals(d));
//        assert(ln.closestIntersectionToStartOfLine(r7).equals(d));
//
//        Point m= new Point(500, 200);
//        Point n = new Point(300, 100);
//        Line lp = new Line(m, n);
//
//        assert(r7.intersectionPoints(lp).size() == 1);
//        assert(r7.intersectionPoints(lp).get(0).equals(new Point(400,150)));
//        assert(lp.closestIntersectionToStartOfLine(r7).equals(new Point(400,150)));
//
//        /*intersect with more than one side of rect*/
//
//        Point p = new Point(100,700);
//        Point q = new Point(100,0);
//        Point r = new Point(100,600);
//        Point s = new Point(100,50);
//        Line lq = new Line(p, q);
//        Line lq2 = new Line(q, p);
//
//        assert(r7.intersectionPoints(lq).size() == 2);
//        assert((r7.intersectionPoints(lq).get(0).equals(r)
//                && (r7.intersectionPoints(lq).get(1).equals(s)))
//                || (r7.intersectionPoints(lq).get(1).equals(r)
//                && (r7.intersectionPoints(lq).get(0).equals(s))));
//
//        assert(lq.closestIntersectionToStartOfLine(r7).equals(r));
//        assert(lq2.closestIntersectionToStartOfLine(r7).equals(s));
//
//
//        Point t = new Point(0,300);
//        Point a1 = new Point(50,300);
//        Point b1 = new Point(400,300);
//        Line lr = new Line(g, t);
//
//        assert(r7.intersectionPoints(lr).size() == 2);
//        assert(((r7.intersectionPoints(lr).get(0).equals(a1))
//                && (r7.intersectionPoints(lr).get(1).equals(b1)))
//                || ((r7.intersectionPoints(lr).get(1).equals(a1))
//                && (r7.intersectionPoints(lr).get(0).equals(b1))));
//
//        assert(lr.closestIntersectionToStartOfLine(r7).equals(b1));
//
//        Line ls = new Line(f, j);
////        Point u = new Point(300,600);
//        Point v = new Point(400,500);
//
//        assert(r7.intersectionPoints(ls).size() == 2);
//        assert((r7.intersectionPoints(ls).get(0).equals(u)
//                && r7.intersectionPoints(ls).get(1).equals(v))
//                ||(r7.intersectionPoints(ls).get(1).equals(u)
//                && r7.intersectionPoints(ls).get(0).equals(v)));
//
//        assert(ls.closestIntersectionToStartOfLine(r7).equals(u));
//
//        Point w = new Point(50,150);
//        Point z = new Point(83.33333333333333,50);
//        Line lt = new Line(t, q);
//
//
//        assert(r7.intersectionPoints(lt).size() == 2);
//        assert((r7.intersectionPoints(lt).get(0).equals(w)
//                && r7.intersectionPoints(lt).get(1).equals(z))
//                ||(r7.intersectionPoints(lt).get(1).equals(w)
//                && r7.intersectionPoints(lt).get(0).equals(z)));
//
//        assert(lt.closestIntersectionToStartOfLine(r7).equals(w));
//
//        /*diagonal in rect*/
//
//
//        Line la = new Line(a, d);
//
//        assert(r7.intersectionPoints(la).size() == 2 || r7.intersectionPoints(la).size() == 4);
//        assert((r7.intersectionPoints(la).get(0).equals(a)
//                && r7.intersectionPoints(la).get(1).equals(d)
//                ||(r7.intersectionPoints(la).get(1).equals(a)
//                && r7.intersectionPoints(la).get(0).equals(d))));
//
//        assert(la.closestIntersectionToStartOfLine(r7).equals(a));
//
//    }
//
//    public void testsForBlock() {
//        //add this rectangle as a block- in the way you implemented block class:
//        Point s7 = new Point(50.0, 50.0);
//        Rectangle r7 = new Rectangle(s7, 350.0, 550.0);
//        // if this doesn't work for your implementation- add it on your own
//        Block b1 = new Block(r7);
//
//        assert (b1.getCollisionRectangle().getWidth() == r7.getWidth());
//        assert (b1.getCollisionRectangle().getHeight() == r7.getHeight());
//        assert (b1.getCollisionRectangle().getUpperLeft().equals(r7.getUpperLeft()));
//
//        Point j1 = new Point(50,405);
//        Velocity ve = new Velocity(5, 5);
//
//        assert(b1.hit(j1, ve).getDx() == -ve.getDx());
//        assert(b1.hit(j1, ve).getDy() == ve.getDy());
//
//        Point f1 = new Point(205,50);
//
//        assert(b1.hit(f1, ve).getDx() == ve.getDx());
//        assert(b1.hit(f1, ve).getDy() == -ve.getDy());
//
//        Point g1 = new Point(400,495);
//        Velocity vg = new Velocity(-5, 5);
//
//        assert(b1.hit(g1, vg).getDx() == -vg.getDx());
//        assert(b1.hit(g1, vg).getDy() == vg.getDy());
//
//        Point h1 = new Point(200,600);
//        Velocity vh = new Velocity(5, -5);
//
//        assert(b1.hit(h1, vh).getDx() == vh.getDx());
//        assert(b1.hit(h1, vh).getDy() == -vh.getDy());
//
//        /*hit corner*/
//        Point d = new Point(400,600);
//        Velocity vd = new Velocity(-5, -5);
//        assert(b1.hit(d, vd).getDx() == -vd.getDx());
//        assert(b1.hit(d, vd).getDy() == -vd.getDy());
//
//        /*doesn't hit*/
//        Point s1 = new Point(500,100);
//        Velocity vs1 = new Velocity(-5, -5);
//        assert(b1.hit(s1, vd).getDx() == vs1.getDx());
//        assert(b1.hit(s1, vd).getDy() == vs1.getDy());
//
//
//    }
//
//    public void testsForCollisionInfo() {
//        Point d = new Point(400,600);
//        Velocity vd = new Velocity(-5, -5);
//        Point s7 = new Point(50.0, 50.0);
//        Rectangle r7 = new Rectangle(s7, 350.0, 550.0);
//        // if this doesn't work for your implementation- add it on your own
//        Block b1 = new Block(r7);
//
//        CollisionInfo collisionInfo = new CollisionInfo(d, b1);
//
//        assert(collisionInfo.collisionPoint().equals(d));
//        assert (collisionInfo.collisionObject().getCollisionRectangle().getUpperLeft().equals(s7));
//        assert(collisionInfo.collisionObject().getCollisionRectangle().getHeight() == 550);
//        assert(collisionInfo.collisionObject().getCollisionRectangle().getWidth() == 350);
//
//
//    }
//
//    public void testsForGameEnvironment() {
//        Velocity vd = new Velocity(-5, -5);
//        Point s7 = new Point(50.0, 50.0);
//        Rectangle r7 = new Rectangle(s7, 350.0, 550.0);
//        // if this doesn't work for your implementation- add it on your own
//        Block block = new Block(r7);
//
//        GameEnvironment ge = new GameEnvironment();
//        ge.addCollidable(block);
//
//        /*no intersection*/
//        Point e = new Point(200, 800);
//        Point f = new Point(200, 700);
//        Line lj = new Line(e, f);
//        assert(ge.getClosestCollision(lj) == null);
//
//
//        Point g = new Point(500, 300);
//        Point h = new Point(600, 300);
//        Line lk = new Line(g, h);
//
//        assert(ge.getClosestCollision(lk) == null);
//
//        Point i = new Point(600, 600);
//        Point j = new Point(500, 400);
//        Line ll = new Line(e, f);
//
//        assert(ge.getClosestCollision(ll) == null);
//
//        /*lines with more than one intersect with the same side*/
//        Point c = new Point(50, 600);
//        Point a = new Point(50,50);
//        Line lh = new Line(c, a);
//        assert(ge.getClosestCollision(lh).collisionPoint().equals(c));
//
//        Point c1 = new Point(50,500);
//        Line lb = new Line(c, c1);
//        assert(ge.getClosestCollision(lb).collisionPoint().equals(c));
//
//        Point d1 = new Point(50,500);
//        Line lc = new Line(a, d1);
//        assert(ge.getClosestCollision(lc).collisionPoint().equals(a));
//
//        /*intersect one point*/
//        Point k = new Point(400, 700);
//        Point d = new Point(400, 600);
//        Line lm = new Line(k, d);
//
//        assert(ge.getClosestCollision(lm).collisionPoint().equals(d));
//
//        Point l = new Point(500, 600);
//        Line ln = new Line(l, d);
//
//        assert(ge.getClosestCollision(ln).collisionPoint().equals(d));
//
//        Point m= new Point(500, 200);
//        Point n = new Point(300, 100);
//        Line lp = new Line(m, n);
//
//        assert(ge.getClosestCollision(lp).collisionPoint().equals(new Point(400,150)));
//
//        /*intersect with more than one side of rect*/
//
//        Point p = new Point(100,700);
//        Point q = new Point(100,0);
//        Point r = new Point(100,600);
//        Point s = new Point(100,50);
//        Line lq = new Line(p, q);
//        Line lq2 = new Line(q, p);
//
//        assert(ge.getClosestCollision(lq).collisionPoint().equals(r));
//        assert(ge.getClosestCollision(lq2).collisionPoint().equals(s));
//
//        Point t = new Point(0,300);
//        Point a1 = new Point(50,300);
//        Point b1 = new Point(400,300);
//        Line lr = new Line(g, t);
//
//        assert(ge.getClosestCollision(lr).collisionPoint().equals(b1));
//
//        Line ls = new Line(f, j);
//        Point u = new Point(300,600);
//        Point v = new Point(400,500);
//
//        assert(ge.getClosestCollision(ls).collisionPoint().equals(u));
//
//        Point w = new Point(50,150);
//        Point z = new Point(83.33,50);
//        Line lt = new Line(t, q);
//
//        assert(ge.getClosestCollision(lt).collisionPoint().equals(w));
//
//        /*diagonal in rect*/
//
//
//        Line la = new Line(a, d);
//        assert(ge.getClosestCollision(la).collisionPoint().equals(a));
//
//    }
//
//    public void testForUpgradedBallClass() {
//        //add this rectangle as a block- in the way you implemented block class:
//        Point s7 = new Point(50.0, 50.0);
//        Rectangle r7 = new Rectangle(s7, 350.0, 550.0);
//        // if this doesn't work for your implementation- add it on your own
//        Block block = new Block(r7);
//
//        GameEnvironment ge = new GameEnvironment();
//
//        ge.addCollidable(block);
//
//        Point e1 = new Point(45,400);
//        Velocity ve = new Velocity(5, 5);
//        Ball b1 = new Ball(e1, 5, Color.PINK);
//        b1.setVelocity(ve);
//        b1.setGameEnvironment(ge);
//        b1.moveOneStep();
//
//        assert(b1.getVelocity().getDx() == -ve.getDx());
//        assert(b1.getVelocity().getDy() == ve.getDy());
//
//        Point f1 = new Point(200,45);
//        Ball b2 = new Ball(f1, 5, Color.PINK);
//        b2.setVelocity(ve);
//        b2.setGameEnvironment(ge);
//        b2.moveOneStep();
//
//        assert(b2.getVelocity().getDx() == ve.getDx());
//        assert(b2.getVelocity().getDy() == -ve.getDy());
//
//        Point g1 = new Point(405,500);
//        Velocity vg = new Velocity(-5, 5);
//        Ball b3 = new Ball(g1, 5, Color.PINK);
//        b3.setVelocity(vg);
//        b3.setGameEnvironment(ge);
//        b3.moveOneStep();
//
//        assert(b3.getVelocity().getDx() == -vg.getDx());
//        assert(b3.getVelocity().getDy() == vg.getDy());
//
//        /*check time passed*/
//        Point h1 = new Point(200,605);
//        Velocity vh = new Velocity(5, -5);
//        Ball b4 = new Ball(h1, 5, Color.PINK);
//        b4.setVelocity(vh);
//        b4.setGameEnvironment(ge);
//        b4.timePassed();
//
//        assert(b4.getVelocity().getDx() == vh.getDx());
//        assert(b4.getVelocity().getDy() == -vh.getDy());
//
//        /*hit corner*/
//        Point d = new Point(405,605);
//        Velocity vd = new Velocity(-5, -5);
//        Ball b5 = new Ball(d, 5, Color.PINK);
//        b5.setVelocity(vd);
//        b5.setGameEnvironment(ge);
//        b5.moveOneStep();
//
//        assert(b5.getVelocity().getDx() == -vd.getDx());
//        assert(b5.getVelocity().getDy() == -vd.getDy());
//
//    }
//
//    public void testForSpriteCollection() {
//        SpriteCollection spriteCollection = new SpriteCollection();
//
//        Point a = new Point(50,50);
//        Velocity v1 = new Velocity(5, 5);
//        Ball b1 = new Ball(a, 25, Color.PINK);
//        b1.setVelocity(v1);
//
//
//        Point b = new Point(200,400);
//        Velocity v2 = new Velocity(-5, -5);
//        Ball b2 = new Ball(b, 30, Color.PINK);
//        b2.setVelocity(v2);
//
//        Point c = new Point(300,200);
//        Velocity v3 = new Velocity(-5, 5);
//        Ball b3 = new Ball(c, 50, Color.PINK);
//        b3.setVelocity(v3);
//
//        Point d = new Point(100,300);
//        Velocity v4 = new Velocity(5, -5);
//        Ball b4 = new Ball(d, 25, Color.PINK);
//        b4.setVelocity(v4);
//
//        GameEnvironment ge = new GameEnvironment();
//        //add gameEnvironment to balls
//        b1.setGameEnvironment(ge);
//        b2.setGameEnvironment(ge);
//        b3.setGameEnvironment(ge);
//        b4.setGameEnvironment(ge);
//
//
//        //add all balls to spriteCollection
//        spriteCollection.addSprite(b1);
//        spriteCollection.addSprite(b2);
//        spriteCollection.addSprite(b3);
//        spriteCollection.addSprite(b4);
//
//        spriteCollection.notifyAllTimePassed();
//
//        assert(b1.getX() == a.getX() + v1.getDx());
//        assert(b1.getY() == a.getY() + v1.getDy());
//
//        assert(b2.getX() == b.getX() + v2.getDx());
//        assert(b2.getY() == b.getY() + v2.getDy());
//
//        assert(b3.getX() == c.getX() + v3.getDx());
//        assert(b3.getY() == c.getY() + v3.getDy());
//
//        assert(b4.getX() == d.getX() + v4.getDx());
//        assert(b4.getY() == d.getY() + v4.getDy());
//
//        GUI gui = new GUI("test Sprite Collection", 700, 700);
//        DrawSurface surface = gui.getDrawSurface();
//
//        spriteCollection.drawAllOn(surface);
//        gui.show(surface);
//
//    }
//
//    public void testsForPaddle() {
//        GUI gui = new GUI("test for paddle", 700, 700);
//        KeyboardSensor key = gui.getKeyboardSensor();
//        DrawSurface surface = gui.getDrawSurface();
//
//        Paddle paddle = new Paddle(key);
//        Rectangle rect = paddle.getCollisionRectangle();
//
//        paddle.moveRight();
//        assert(paddle.getCollisionRectangle().getUpperLeft().getX() > rect.getUpperLeft().getX());
//        assert(paddle.getCollisionRectangle().getUpperLeft().getY() == rect.getUpperLeft().getY());
//        rect = paddle.getCollisionRectangle();
//
//        paddle.moveLeft();
//        assert(paddle.getCollisionRectangle().getUpperLeft().getX() < rect.getUpperLeft().getX());
//        assert(paddle.getCollisionRectangle().getUpperLeft().getY() == rect.getUpperLeft().getY());
//
//        paddle.drawOn(surface);
//        rect = paddle.getCollisionRectangle();
//
//        /*region 1*/
//        Point p1 = new Point(rect.getUpperLeft().getX(), rect.getUpperLeft().getY());
//        Point p2 = new Point(rect.getUpperLeft().getX() + 5, rect.getUpperLeft().getY() + 5);
//        Velocity v1 = new Velocity(-5, -5);
//        double distance1 = p2.distance(p1);
//        Velocity newv1 = Velocity.fromAngleAndSpeed(300, distance1);
//
//        assert(paddle.hit(p1, v1).getDx() == newv1.getDx());
//        assert(paddle.hit(p1, v1).getDy() == newv1.getDy());
//
//        /*region 3*/
//        Point p3 = new Point(rect.getUpperLeft().getX() + rect.getWidth()/2, rect.getUpperLeft().getY());
//        Point p4 = new Point(p3.getX() + 5, p3.getY() + 5);
//        double distance2 = p3.distance(p4);
//
//
//        assert(paddle.hit(p3, v1).getDx() == v1.getDx());
//        assert(paddle.hit(p3, v1).getDy() == -v1.getDy());
//
//        /*region 5*/
//        Point p5 = new Point(rect.getUpperLeft().getX() + rect.getWidth(), rect.getUpperLeft().getY());
//        Point p6 = new Point(p5.getX() + 5, p5.getY() + 5);
//        double distance3 = p5.distance(p6);
//        Velocity newv3 = Velocity.fromAngleAndSpeed(60, distance3);
//
//        assert(paddle.hit(p5, v1).getDx() == newv3.getDx());
//        assert(paddle.hit(p5, v1).getDy() == newv3.getDy());
//
//        /*region 2*/
//        Point p7 = new Point(rect.getUpperLeft().getX() + 2 * rect.getWidth()/5, rect.getUpperLeft().getY());
//        Point p8 = new Point(p7.getX() + 5, p7.getY() + 5);
//        double distance4 = p7.distance(p8);
//        Velocity newv4 = Velocity.fromAngleAndSpeed(330, distance4);
//
//        assert(paddle.hit(p7, v1).getDx() == newv4.getDx());
//        assert(paddle.hit(p7, v1).getDy() == newv4.getDy());
//
//        /*region 4*/
//        Point p9 = new Point(rect.getUpperLeft().getX() + 4 * rect.getWidth()/5, rect.getUpperLeft().getY());
//        Point p10 = new Point(p9.getX() + 5, p9.getY() + 5);
//        double distance5 = p9.distance(p10);
//        Velocity newv5 = Velocity.fromAngleAndSpeed(30, distance5);
//
//        assert(paddle.hit(p9, v1).getDx() == newv5.getDx());
//        assert(paddle.hit(p9, v1).getDy() == newv5.getDy());
//
//        /*on side*/
//        Point p11 = new Point(rect.getUpperLeft().getX(), rect.getUpperLeft().getY() + rect.getHeight()/2);
//        Point p12 = new Point(p11.getX() - 5, p11.getY() + 5);
//
//        Velocity v2 = new Velocity(5, -5);
//
//        assert(paddle.hit(p11, v2).getDx() == -v2.getDx());
//        assert(paddle.hit(p11, v2).getDy() == v2.getDy());
//
//        Point p13 = new Point(rect.getUpperLeft().getX() + rect.getWidth(), rect.getUpperLeft().getY() + rect.getHeight()/2);
//        Point p14 = new Point(p13.getX() + 5, p13.getY() + 5);
//
//
//        assert(paddle.hit(p13, v1).getDx() == -v1.getDx());
//        assert(paddle.hit(p13, v1).getDy() == v1.getDy());
//
//
//    }
//
//    public void testForGame() {
//        Game testGame = new Game();
//        Point a = new Point(500, 400);
//        Point b = new Point(500, 150);
//        Point c = new Point(300, 150);
//        Point d = new Point(300, 400);
//        Point f = new Point(200, 350);
//        Point h = new Point(250, 300);
//
//        Line lf = new Line(a, b);
//        Line lg = new Line(b, c);
//        Line lh = new Line(c, d);
//        Line li = new Line(d, a);
//
//        Rectangle rec1 = new Rectangle(c, 200, 350);
//        Rectangle rec2 = new Rectangle(f, 100, 50);
//
//        /*if you implemented differently- add these rectangles as  blocks*/
//        Block block1 = new Block(rec1);
//        Block block2 = new Block(rec2);
//
//        testGame.addCollidable(block1);
//        testGame.addCollidable(block2);
//
//
//
//
//
//    }
//    public static void main(String[] args) {
//        TestsForAss3 tester = new TestsForAss3();
//        tester.testsForRectangleAndLine();
//        System.out.println("Passed test for Rectangle class and new method in line (1/7)");
//
//        tester.testsForBlock();
//        System.out.println("Passed test for Block Class (2/7)");
//
//        tester.testsForCollisionInfo();
//        System.out.println("Passed test for CollisionInfo Class (3/7)");
//
//        tester.testsForGameEnvironment();
//        System.out.println("Passed test forGameEnvironment Class (4/7)");
//
//        tester.testForUpgradedBallClass();
//        System.out.println("Passed test for new methods in Ball Class (5/7)");
//
//        tester.testForSpriteCollection();
//        System.out.println("Passed test for SpriteCollection Class (6/7)");
//
//        tester.testsForPaddle();
//        System.out.println("Passed test for Paddle Class (7/7)");
//
//        System.out.println("Passed all tests!");
//
//
//    }
//
//}

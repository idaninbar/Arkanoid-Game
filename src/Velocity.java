/**
 * 208765982 Idan Inbar.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * the function is a constructor of velocity.
     * @param dx is the first coordinate of the velocity.
     * @param dy is the second coordinate of the velocity.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * the function is incresing the velocity coordinates.
     * @param p is the point that it's value we add to the velocity.
     * @return the new velocity coordinate.
     */
    public Point applyToPoint(Point p) {
        return new Point(this.dx + p.getX(), this.dy + p.getY());
    }

    /**
     * the fucntion gets the first coordinate of the velocity.
     * @return the first coordinate of the velocity.
     */
    public double getDx() {
        return this.dx;
    }
    /**
     * the fucntion gets the second coordinate of the velocity.
     * @return the second coordinate of the velocity.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * the function sets a new first coordinate of the velocity.
     * @param dx is the new coordinate.
     */
    public void setDx(double dx) {
        this.dx = dx;
    }
    /**
     * the function sets a new second coordinate of the velocity.
     * @param dy is the new coordinate.
     */
    public void setDy(double dy) {
        this.dy = dy;
    }

    /**
     * the function calculates the velocity according two the angle and speed.
     * @param angle is the angle of the velocity.
     * @param speed is the speed of the velocity.
     * @return a new velocity according to the new coordinates.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx = Math.sin(Math.toRadians(angle)) * speed;
        double dy = -Math.cos(Math.toRadians(angle)) * speed;
        return new Velocity(dx, dy);
    }
}

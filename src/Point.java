/**
 * 208765982 Idan Inbar.
 */
public class Point {
    private double x = 0;
    private double y = 0;
    public static final double EPSILON = Math.pow(10, -10);


    /**
     * the function is a constructor of point.
     * @param x is the x of the point.
     * @param y is the y of the point/
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * the function calculates the distance between two points.
     * @param other is the second point.
     * @return the distance between the points.
     */
    public double distance(Point other) {
        return Math.sqrt(((this.x - other.x) * (this.x - other.x) + (this.y - other.y) * (this.y - other.y)));
    }

    /**
     * the function checks if two points are equal.
     * @param other is the second point.
     * @return true if they equal and false otherwise.
     */
    public boolean equals(Point other) {
        if (other == null) {
            return false;
        }
        return Math.abs((this.getX() - other.getX())) < EPSILON && Math.abs(other.getY() - this.getY()) < EPSILON;
    }

    /**
     * the function returns the x of a point.
     * @return the x of the point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * the function returns the y of the point.
     * @return the y of the point.
     */
    public double getY() {
        return this.y;
    }

    /**
     * the function checks if point is on line.
     * @param l is the line we check about.
     * @return return true if the point is on the line and false otherwise.
     */
    public boolean onLine(Line l) {
        double x1 = Math.max(l.start().getX(), l.end().getX());
        double x2 = Math.min(l.start().getX(), l.end().getX());
        double y1 = Math.max(l.start().getY(), l.end().getY());
        double y2 = Math.min(l.start().getY(), l.end().getY());
        if (x2 > this.getX() || x1 < this.getX()) {
            return false;
        }
        if (y2 > this.getY() || y1 < this.getY()) {
            return false;
        }
        return true;
    }
}
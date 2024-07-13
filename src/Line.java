/**
 * 208765982 Idan Inbar.
 */
import java.util.List;
import java.util.ArrayList;
/**
 * the class line.
 */
public class Line {
    private Point start = null;
    private Point end = null;

    /**
     * the function is a constructor of a line.
     * @param start is the starting point of the line.
     * @param end   is the end point of the line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * the function is a constructor of a line.
     * @param x1 is the x of the starting point.
     * @param y1 is the y of the starting point.
     * @param x2 is the x of the end point.
     * @param y2 is the y of the end point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * the function calculates the distance between two points.
     * @return the distance between two points.
     */
    public double length() {
        return end.distance(this.start);
    }

    /**
     * the function calculates the middle points.
     * @return the middle point .
     */
    public Point middle() {
        double x = (this.end.getX() + this.start.getX()) / 2;
        double y = (this.end.getY() + this.start.getY()) / 2;
        return new Point(x, y);
    }

    /**
     * the function gets the starting point.
     * @return the starting point of a line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * the function gets the end point.
     * @return the ending point of a line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * the function calculates the slope of a line.
     * @return the slope of the line.
     */
    public double slope() {
        //if the two x are the same
        if (this.start.getX() == this.end.getX()) {
            //checks which one of the y's are greater so the slope won't be negative infinity
            if (this.start.getY() > this.end.getY()) {
                return ((this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX()));
            } else {
                return (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
            }
        }
        return (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
    }
    /**
     * the function checks if a point is on a line.
     * @param p1 is the starting point of the line.
     * @param p2 is the point that we check whether it's on the line.
     * @param p3 is the ending point of the line.
     * @return true of p2 is on the line and false otherwise.
     */
    public boolean isOn(Point p1, Point p2, Point p3) {
        return p2.getX() <= Math.max(p1.getX(), p3.getX()) && p2.getX() >= Math.min(p1.getX(), p3.getX())
                && p2.getY() <= Math.max(p1.getY(), p3.getY()) && p2.getY() >= Math.min(p1.getY(), p3.getY());
    }
    /**
     * the function calculates the B of the line formula.
     * @return two B of the formula two present a line.
     */
    public double findingB() {
        //if the line is parallel to x
        if (this.start.getY() == this.end.getY()) {
            return this.start.getY();
        }
        //if the line is parallel to y
        if (this.start.getX() == this.end.getX()) {
            return this.start.getX();
        }
        return (this.end.getY()) - ((this.slope()) * this.end.getX());
    }
    /**
     * the function checks if the line is parallel to x.
     * @return true if the line parallel to x and false otherwise.
     */
    public boolean parallelToX() {
        return this.start.getY() == this.end.getY();
    }

    /**
     * the function checks if one line is on other line.
     * @param other is the line that we check if it's on the other.
     * @return true if it's on the line and false otherwise.
     */
    public boolean isOnLine(Line other) {
        if ((isOn(this.start, other.start, this.end) && isOn(this.start, other.end, this.end))
                || (isOn(other.start, this.start, other.end) && isOn(other.start, this.end, other.end))) {
            return true;
        }
        return false;
    }

    /**
     * the function checks if one line's tip is touching the other.
     * @param other is the second line we check.
     * @return true if they touch the tips and false otherwise.
     */
    public boolean touchingTips(Line other) {
        if (!this.isOnLine(other)) {
            return this.start.equals(other.start) || this.end.equals(other.end) || this.start.equals(other.end)
                    || this.end.equals(other.start);
        }
        return false;
    }
    /**
     * the function checks which tips are touching and returns the touching point.
     * @param other is the second line that we check about it's tips.
     * @return the touching point or null otherwise.
     */
    public Point touchPoint(Line other) {
        if (this.touchingTips(other)) {
            if (this.start.equals(other.start) || this.start.equals(other.end)) {
                return this.start;
            }
            if (this.end.equals(other.start) || this.end.equals(other.end)) {
                return this.end;
            }
        }
        return null;
    }

    /**
     * the function checks if two parallel to x lines intersect.
     * @param other is the second parallel to x line.
     * @return true if they intersect and false otherwise.
     */
    public boolean intersectX(Line other) {
        if (this.start.getY() == other.start.getY()) {
            if (this.isOnLine(other)) {
                return false;
            }
        }
        if (this.touchingTips(other)) {
            return true;
        }
        return false;
    }

    /**
     * the function check if the line is parallel to y.
     * @return true if the line is parallel to y and false otherwise.
     */
    public boolean parallelToY() {
        return this.start.getX() == this.end.getX();
    }

    /**
     * the function checks if two parallel to y lines intersect.
     * @param other is the second parallel to y line.
     * @return true if they intersect and false otherwise.
     */
    public boolean intersectY(Line other) {
        if (this.start.getX() == other.start.getX()) {
            if (this.isOnLine(other)) {
                return false;
            }
        }
        if (this.touchingTips(other)) {
            return true;
        }
        return false;
    }

    /**
     * the function checks if two lines have the same equation.
     * @param other is the second line that we check about.
     * @return true if they have the same equation and false otherwise.
     */
    public boolean sameLine(Line other) {
        return this.slope() == other.slope() && this.findingB() == other.findingB();
    }

    /**
     * the function checks what is the intersection point if the two lines were infinity.
     * @param other is the second line that we check about.
     * @return the intersection point of the two lines.
     */
    public Point intersectionPoint(Line other) {
        double x, y;
        if (this.parallelToY()) {
            y = (other.slope() * this.start.getX()) + other.findingB();
            return new Point(this.start.getX(), y);
        }
        if (other.parallelToY()) {
            y = (this.slope() * other.start.getX()) + this.findingB();
            return new Point(other.start.getX(), y);
        }
        if (this.parallelToX()) {
            x = (this.findingB() - other.findingB()) / other.slope();
            return new Point(x, this.start.getY());
        }
        if (other.parallelToX()) {
            x = (other.findingB() - this.findingB()) / this.slope();
            return new Point(x, other.start.getY());
        }
        if (this.start.equals(other.start)) {
            return this.start;
        }
        if (this.end.equals(other.start)) {
            return this.end;
        }
        if (this.start.equals(other.end)) {
            return this.start;
        }
        if (this.end.equals(other.end)) {
            return this.end;
        }
        x = (other.findingB() - this.findingB()) / (this.slope() - other.slope());
        y = (this.slope() * x) + this.findingB();
        return new Point(x, y);
    }

    /**
     * the function checks the general case of two intersecting line.
     * if they do not parallel to each other or to x or y and not the same.
     * @param other is the second line we check about.
     * @param inter is the hypothetical intersection point.
     * @return true if the two lines intersect and false otherwise.
     */
    public boolean check(Line other, Point inter) {
        if (isOn(this.start, inter, this.end) && isOn(other.start, inter, other.end)) {
            return true;
        }
        return false;
    }

    /**
     * the function checks if two lines are intersect.
     * @param other is the second line that we check if it intersect with the other.
     * @return true if the line intersect and false otherwise.
     */
    public boolean isIntersecting(Line other) {
        //if the two lines are the same
        if (this.equals(other)) {
            return true;
        }
        //if the two lines parallel to x
        if (this.parallelToX() && other.parallelToX()) {
            return this.intersectX(other);
        }
        //if the two lines parallel to y
        if (this.parallelToY() && other.parallelToY()) {
            return this.intersectY(other);
        }
        //if the two lines have the same equation
        if (this.sameLine(other)) {
//            return this.intersectX(other) && this.intersectY(other);
            if (this.start().getX() < other.start().getX()) { //this is leftmost line
                return other.start().getX() <= this.end().getX();
            } else { //other is leftmost line
                return this.start().getX() <= other.end().getX();
            }
        }
        //if the two lines are parallel but have different equation
        if (this.slope() == other.slope() && this.findingB() != other.findingB()) {
            return false;
        }
        Point inter = this.intersectionPoint(other);
        if (this.check(other, inter)) {
            return true;
        }
        return false;
    }

    /**
     * the function calculates the intersection point between two lines.
     * @param other is the second line that we want to check if it's intersect with the first.
     * @return the intersection point between the two lines.
     */
    public Point intersectionWith(Line other) {
        if (this.equals(other)) {
            return null;
        }
        if (this.sameLine(other) || (this.parallelToY() && other.parallelToY())
                || (this.parallelToX() && other.parallelToX())) {
            return this.touchPoint(other);
        }
        //if they do not intersect return null
        if (!isIntersecting(other)) {
            return null;
        }
        //if they do intersect
        if (this.check(other, this.intersectionPoint(other))) {
            return this.intersectionPoint(other);
        }
        return null;
    }

    /**
     * the function checks if two lines are equals.
     * @param other is the second line that we check if it's equal.
     * @return true if the two line are equal and false othewise.
     */
    public boolean equals(Line other) {
        return (this.start.equals(other.start) && this.end.equals(other.end))
                || (this.start.equals(other.end) && this.end.equals(other.start));
    }

    /**
     * the funciton checks which intersection point is the closest to the line's starting point.
     * @param rect is the rectangle that we check if it's side intersect with the line.
     * @return the closest intersection point to the start of the line.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> list = new ArrayList<Point>();
        list = rect.intersectionPoints(this);
        if (list.isEmpty()) {
            return null;
        }
        Point closest = list.get(0);
        //check which one of the intersection points is the closest to the line's starting point.
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).distance(this.start) < closest.distance(this.start)) {
                closest = list.get(i);
            }
        }
        return closest;
    }
}
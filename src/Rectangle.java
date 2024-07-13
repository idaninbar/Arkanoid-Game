/**
 * 208765982 Idan Inbar.
 */
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;

/**
 * the rectangle class.
 */
public class Rectangle {
    private double width;
    private double height;
    private Point upperLeft;
    private java.awt.Color color;

    /**
     * the function is a constructor for a rectangle class.
     * @param upperLeft is the upper left point of the rectangle.
     * @param width is the width of the rectangle.
     * @param height is the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.color = Color.green;
    }

    /**
     * the function is setter for color.
     * @param color is the new color we want to set.
     */
    public void setColor(java.awt.Color color) {
        this.color = color;
    }

    /**
     * the function is collecting all the intersection points of a given line,
     * with the rectangle sides.
     * @param line is the given line that we check it's intersections.
     * @return an array list of all the intersection points.
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        Line left = getLeft();
        Line right = getRight();
        Line up = getUp();
        Line down = getDown();
        ArrayList<Point> list = new ArrayList<Point>();
        //if the line starting and ending point are exactly on the rectangle edges
        if ((line.start().equals(left.start()) && line.end().equals(right.end()))
        || (line.start().equals(right.end()) && line.end().equals(left.start()))) {
            list.add(line.start());
            list.add(line.end());
            return list;
        }
        if ((line.start().equals(right.start()) && line.end().equals(left.end()))
                || (line.start().equals(left.end()) && line.end().equals(right.start()))) {
            list.add(line.start());
            list.add(line.end());
            return list;
        }
        //if a line is one of the walls return the 2 corners
        if (line.equals(left) || line.equals(right) || line.equals(up) || line.equals(down)) {
            list.add(line.start());
            list.add(line.end());
            return list;
        }
        //if its intersect with the left side of the rectangle
        if (line.isIntersecting(left)) {
            list.add(line.intersectionWith(left));
        }
        //if its intersect with the right side of the rectangle
        if (line.isIntersecting(right)) {
            list.add(line.intersectionWith(right));
        }
        //if its intersect with the upper side of the rectangle
        if (line.isIntersecting(up)) {
           list.add(line.intersectionWith(up));
        }
        //if its intersect with the lower side of the rectangle
        if (line.isIntersecting(down)) {
           list.add(line.intersectionWith(down));
        }
        return list;
    }

    /**
     * the function returns the width.
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }
    /**
     * the function returns the height.
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return  this.height;
    }

    /**
     * the function returns the upper left point of the rectangle.
     * @return the upper left point.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }
    /**
     * the function returns the upper right point of the rectangle.
     * @return the upper right point.
     */
    public Point getUpperRight() {
        return new Point(this.upperLeft.getX() + width, this.upperLeft.getY());
    }
    /**
     * the function returns the lower left point of the rectangle.
     * @return the lower left point.
     */
    public Point getLowerLeft() {
        return new Point(this.upperLeft.getX(), this.upperLeft.getY() + height);
    }
    /**
     * the function returns the lower right point of the rectangle.
     * @return the lower right point.
     */
    public Point getLowerRight() {
        return new Point(getUpperRight().getX(), getUpperRight().getY() + height);
    }

    /**
     * the function creates a line that is the left side of the rectangle.
     * @return the left line of the rectangle.
     */
    public Line getLeft() {
        Point lowerLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + height);
        return new Line(this.upperLeft, lowerLeft);
    }
    /**
     * the function creates a line that is the right side of the rectangle.
     * @return the right line of the rectangle.
     */
    public Line getRight() {
        Point upperRight = new Point(this.upperLeft.getX() + width, this.upperLeft.getY());
        Point lowerRight = new Point(upperRight.getX(), upperRight.getY() + height);
        return new Line(upperRight, lowerRight);
    }
    /**
     * the function creates a line that is the upper side of the rectangle.
     * @return the upper line of the rectangle.
     */
    public Line getUp() {
        Point upperRight = new Point(this.upperLeft.getX() + width, this.upperLeft.getY());
        return new Line(this.upperLeft, upperRight);
    }
    /**
     * the function creates a line that is the lower side of the rectangle.
     * @return the lower line of the rectangle.
     */
    public Line getDown() {
        Point lowerLeft = new Point(this.upperLeft.getX(), this.upperLeft.getY() + height);
        Point upperRight = new Point(this.upperLeft.getX() + width, this.upperLeft.getY());
        Point lowerRight = new Point(upperRight.getX(), upperRight.getY() + height);
        return new Line(lowerLeft, lowerRight);
    }

    /**
     * the function draws a rectangle on surface.
     * @param d is the surface we draw on.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.upperLeft.getX(), (int) this.upperLeft.getY(),
                (int) this.getWidth(), (int) this.getHeight());
    }
}

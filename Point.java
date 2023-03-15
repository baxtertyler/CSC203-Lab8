/**
 * A simple class representing a location in 2D space.
 */
public final class Point {
    private double x;
    private double y;
    private double z;

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }

    public double getZ()
    {
        return this.z;
    }

    public String toString() {
        return (x + ", " + y + ", " + z);
    }

    public boolean equals(Object other) {
        return other instanceof Point && ((Point) other).x == this.x && ((Point) other).y == this.y;
    }

    public int hashCode() {
        double result = 17;
        result = result * 31 + x;
        result = result * 31 + y;
        return (int) result;
    }

}

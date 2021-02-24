package ch.elste.math;

public class Vector2 extends Vector {
	public static final Vector2 X = new Vector2(1, 0);
	public static final Vector2 Y = new Vector2(0, 1);

	/**
	 * Creates a new vector based on the given one.
	 * 
	 * @param v the vector to copy
	 */
	public Vector2(final Vector2 v) {
		x = v.x;
		y = v.y;
	}

	/**
	 * Creates a new vector with given values.
	 * 
	 * @param x the x-coordinate
	 * @param y the y-coordinate
	 */
	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Creates a new vector with {@code d} as all the coordinates.
	 * <p>
	 * The same as calling {@link #Vector2(double, double) new Vector(d, d)}.
	 * </p>
	 * 
	 * @param d the coordinates
	 */
	public Vector2(double d) {
		this(d, d);
	}

	/**
	 * Creates a new Vector initialized at the origin
	 * <p>
	 * The same as calling {@link #Vector2(double, double) new Vector(0, 0)}.
	 * </p>
	 */
	public Vector2() {
		this(0d, 0d);
	}

	/**
	 * Adds {@code v} to this and returns a new independent vector object with the
	 * resulting values. {@code this} isn't changed.
	 * 
	 * @param v the vector to be added
	 * 
	 * @return an independent vector with the resulting values.
	 */
	public Vector2 plus(final Vector2 v) {
		return new Vector2(x + v.x, y + v.y);
	}

	/**
	 * Subtracts {@code v} from this and returns a new independent vector object
	 * with the resulting values. {@code this} isn't changed.
	 * 
	 * @param v the vector to be subtracted
	 * 
	 * @return an independent vector with the resulting values.
	 */
	public Vector2 minus(final Vector2 v) {
		return new Vector2(x - v.x, y - v.y);
	}

	/**
	 * Returns -this.
	 * 
	 * @return -this
	 */
	public Vector2 negative() {
		return new Vector2(-x, -y);
	}

	/**
	 * Returns a scaled vector of this. this isn't changed.
	 * 
	 * @param factor the factor to scale by
	 * 
	 * @return a new independent vector with resulting values
	 */
	public Vector2 scale(final double factor) {
		return new Vector2(x * factor, y * factor);
	}

	/**
	 * Calculates the dot product of this vector and {@code v}.
	 * 
	 * @param v the vector to multiply with
	 * 
	 * @return the dot product as a double
	 */
	public double dot(final Vector2 v) {
		return x * v.x + y * v.y;
	}

	/**
	 * Returns the length of this vector. It is calculated as the square root of the
	 * sum of all the squared coordinates.
	 * 
	 * @return the length of this vector as a double
	 */
	public double length() {
		return Math.sqrt(x * x + y * y);
	}

	/**
	 * Returns this vector normalized to a length of 1. this isn't changed.
	 * 
	 * @return a new independent vector with resulting values
	 */
	public Vector2 normalize() {
		double length = length();
		return new Vector2(x / length, y / length);
	}

	@Override
	public String toString() {
		return String.format("Vector[%.3f,%.3f]\t%s", x, y, super.toString());
	}
}

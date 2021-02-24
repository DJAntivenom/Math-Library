package ch.elste.math;

/**
 * A vector is a mathematical construct holding multiple numbers. This class holds
 * all the essential operations for a 3 by 1 Vector.
 * 
 * @author Dillon Elste
 */
public class Vector3 extends Vector {
	public static final Vector3 X = new Vector3(1, 0, 0);
	public static final Vector3 Y = new Vector3(0, 1, 0);
	public static final Vector3 Z = new Vector3(0, 0, 1);

	/**
	 * Creates a new vector based on the given one.
	 * 
	 * @param v
	 *            the vector to copy
	 */
	public Vector3(Vector3 v) {
		x = v.x;
		y = v.y;
		z = v.z;
	}

	/**
	 * Creates a new vector with given values.
	 * 
	 * @param x
	 *            the x-coordinate
	 * @param y
	 *            the y-coordinate
	 * @param z
	 *            the z-coordinate
	 */
	public Vector3(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Creates a new vector with {@code d} as all the coordinates.
	 * <p>
	 * The same as calling {@link #Vector(double, double, double) new Vector(d, d,
	 * d)}.
	 * </p>
	 * 
	 * @param d
	 *            the coordinates
	 */
	public Vector3(double d) {
		this(d, d, d);
	}

	/**
	 * Creates a new Vector initialized at the origin
	 * <p>
	 * The same as calling {@link #Vector(double, double, double) new Vector(0, 0,
	 * 0)}.
	 * </p>
	 */
	public Vector3() {
		this(0d, 0d, 0d);
	}

	/**
	 * Adds {@code v} to this and returns a new independent vector object with the
	 * resulting values. {@code this} isn't changed.
	 * 
	 * @param v
	 *            the vector to be added
	 * 
	 * @return an independent vector with the resulting values.
	 */
	public Vector3 plus(final Vector3 v) {
		return new Vector3(x + v.x, y + v.y, z + v.z);
	}

	/**
	 * Subtracts {@code v} from this and returns a new independent vector object
	 * with the resulting values. {@code this} isn't changed.
	 * 
	 * @param v
	 *            the vector to be subtracted
	 * 
	 * @return an independent vector with the resulting values.
	 */
	public Vector3 minus(final Vector3 v) {
		return new Vector3(x - v.x, y - v.y, z - v.z);
	}

	/**
	 * Returns -this.
	 * 
	 * @return -this
	 */
	public Vector3 negative() {
		return new Vector3(-x, -y, -z);
	}

	/**
	 * Returns a scaled vector of this. this isn't changed.
	 * 
	 * @param factor
	 *            the factor to scale by
	 * 
	 * @return a new independent vector with resulting values
	 */
	public Vector3 scale(final double factor) {
		return new Vector3(x * factor, y * factor, z * factor);
	}

	/**
	 * Calculates the dot product of this vector and {@code v}.
	 * 
	 * @param v
	 *            the vector to multiply with
	 * 
	 * @return the dot product as a double
	 */
	public double dot(final Vector3 v) {
		return x * v.x + y * v.y + z * v.z;
	}

	/**
	 * Calculates the cross product of this and the given vector.
	 * 
	 * @param v
	 *            the vector to multiply with
	 * 
	 * @return a new vector with resulting values
	 */
	public Vector3 cross(final Vector3 v) {
		return new Vector3(y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y * v.x);
	}

	/**
	 * Returns the length of this vector. It is calculated as the square root of the
	 * sum of all the squared coordinates.
	 * 
	 * @return the length of this vector as a double
	 */
	public double length() {
		return Math.sqrt(x * x + y * y + z * z);
	}

	/**
	 * Returns this vector normalized to a length of 1. this isn't changed.
	 * 
	 * @return a new independent vector with resulting values
	 */
	public Vector3 normalize() {
		double length = length();
		return new Vector3(x / length, y / length, z / length);
	}

	@Override
	public String toString() {
		return String.format("Vector[%.3f,%.3f,%.3f]\t%s", x, y, z, super.toString());
	}
}

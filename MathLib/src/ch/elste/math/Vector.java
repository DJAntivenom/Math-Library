package ch.elste.math;

/**
 * A vector is a mathematical construct holding 3 coordinates. This class holds
 * all the essential operations.
 * 
 * @author Dillon Elste
 */
public class Vector {
	public static final Vector X = new Vector(1, 0, 0);
	public static final Vector Y = new Vector(0, 1, 0);
	public static final Vector Z = new Vector(0, 0, 1);

	public double x, y, z;

	/**
	 * Creates a new vector based on the given one.
	 * 
	 * @param v
	 *            the vector to copy
	 */
	public Vector(Vector v) {
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
	public Vector(double x, double y, double z) {
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
	public Vector(double d) {
		this(d, d, d);
	}

	/**
	 * Creates a new Vector initialized at the origin
	 * <p>
	 * The same as calling {@link #Vector(double, double, double) new Vector(0, 0,
	 * 0)}.
	 * </p>
	 */
	public Vector() {
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
	public Vector plus(final Vector v) {
		return new Vector(x + v.x, y + v.y, z + v.z);
	}

	/**
	 * Adds {@code v1} to {@code v2} without altering them.
	 * 
	 * @param v1
	 *            the first vector to be added
	 * @param v2
	 *            the second vector to be added
	 * 
	 * @return a new vector with the resulting values
	 */
	public static Vector add(final Vector v1, final Vector v2) {
		return new Vector(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
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
	public Vector minus(final Vector v) {
		return new Vector(x - v.x, y - v.y, z - v.z);
	}

	/**
	 * Subtracts {@code v1} from {@code v2} without altering them.
	 * 
	 * @param v1
	 *            the first vector to be subtracted
	 * @param v2
	 *            the second vector to be subtracted
	 * 
	 * @return a new vector with the resulting values
	 */
	public static Vector subtract(final Vector v1, final Vector v2) {
		return new Vector(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
	}

	/**
	 * Returns -this.
	 * 
	 * @return -this
	 */
	public Vector negative() {
		return new Vector(-x, -y, -z);
	}

	/**
	 * Returns -v.
	 * 
	 * @param v
	 *            the vector to be negated
	 * 
	 * @return -v
	 */
	public static Vector negate(final Vector v) {
		return new Vector(-v.x, -v.y, -v.z);
	}

	/**
	 * Returns a scaled vector of this. this isn't changed.
	 * 
	 * @param factor
	 *            the factor to scale by
	 * 
	 * @return a new independent vector with resulting values
	 */
	public Vector scale(final double factor) {
		return new Vector(x * factor, y * factor, z * factor);
	}

	/**
	 * Scales {@code v} by {@code factor} without altering it.
	 * 
	 * @param v
	 *            the vector to scale
	 * @param factor
	 *            the factor to scale by
	 * 
	 * @return a new independent vector
	 */
	public static Vector scale(final Vector v, final double factor) {
		return new Vector(v.x * factor, v.y * factor, v.z * factor);
	}

	/**
	 * Calculates the dot product of this vector and {@code v}.
	 * 
	 * @param v
	 *            the vector to multiply with
	 * 
	 * @return the dot product as a double
	 */
	public double dot(final Vector v) {
		return x * v.x + y * v.y + z * v.z;
	}

	/**
	 * Calculates the dot product of the two given vectors.
	 * 
	 * @param v1
	 *            the first vector to multiply
	 * @param v2
	 *            the second vector to multiply
	 * 
	 * @return the dot product as a double
	 */
	public static double dot(final Vector v1, final Vector v2) {
		return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
	}

	/**
	 * Calculates the cross product of this and the given vector.
	 * 
	 * @param v
	 *            the vector to multiply with
	 * 
	 * @return a new vector with resulting values
	 */
	public Vector cross(final Vector v) {
		return new Vector(y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y * v.x);
	}

	/**
	 * Calculates the cross product of the given vectors.
	 * 
	 * @param v1
	 *            the first vector to multiply
	 * @param v2
	 *            the second vector to multiply
	 * 
	 * @return a new vector with resulting values
	 */
	public static Vector cross(final Vector v1, final Vector v2) {
		return new Vector(v1.y * v2.z - v1.z * v2.y, v1.z * v2.x - v1.x * v2.z, v1.x * v2.y - v1.y * v2.x);
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
	public Vector normalize() {
		double length = length();
		return new Vector(x / length, y / length, z / length);
	}

	/**
	 * Returns the normalized version of {@code v} without altering it.
	 * 
	 * @param v
	 *            the vector to get the normalized version of
	 * 
	 * @return a new normalized vector without altering v
	 */
	public static Vector getNormalized(final Vector v) {
		double length = v.length();
		return new Vector(v.x / length, v.y / length, v.z / length);
	}

	@Override
	public String toString() {
		return String.format("Vector[%.3f,%.3f,%.3f]\t%s", x, y, z, super.toString());
	}

	/**
	 * Returns the three horizontal vectors of {@code m}.
	 * 
	 * @param m
	 *            the matrix to take the vectors from
	 * 
	 * @return the three horizontal vectors
	 */
	public static Vector[] getHorizontalVectors(final Matrix3x3 m) {
		Vector[] temp = new Vector[3];

		for (int i = 0; i < 3; i++) {
			temp[i] = new Vector(m.values[i * 3], m.values[i * 3 + 1], m.values[i * 3 + 2]);
		}

		return temp;
	}

	/**
	 * Returns the three vertical vectors of {@code m}.
	 * 
	 * @param m
	 *            the matrix to take the vectors from
	 * 
	 * @return the three vertical vectors
	 */
	public static Vector[] getVerticalVectors(final Matrix3x3 m) {
		Vector[] temp = new Vector[3];

		for (int i = 0; i < 3; i++) {
			temp[i] = new Vector(m.values[i], m.values[3 + i], m.values[6 + i]);
		}

		return temp;
	}
}

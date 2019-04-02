package ch.elste.math;

/**
 * A vector is a mathematical construct holding multiple numbers. This class
 * holds all the essential operations for a 4 by 1 Vector.
 * 
 * @author Dillon Elste
 */
public class Vector4 {
	public static final Vector4 X = new Vector4(1, 0, 0, 0);
	public static final Vector4 Y = new Vector4(0, 1, 0, 0);
	public static final Vector4 Z = new Vector4(0, 0, 1, 0);
	public static final Vector4 T = new Vector4(0, 0, 0, 1);

	public double x, y, z, t;

	/**
	 * Creates a new Vector4 with given values.
	 * 
	 * @param x the x value
	 * @param y the y value
	 * @param z the z value
	 * @param t the t value
	 */
	public Vector4(final double x, final double y, final double z, final double t) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.t = t;
	}

	/**
	 * Creates a new Vector4 initialized with all {@code d}.
	 * 
	 * @param d the initial value
	 */
	public Vector4(final double d) {
		this(d, d, d, d);
	}

	/**
	 * Creates a new Vector4 initialized with all zeros.
	 */
	public Vector4() {
		this(0, 0, 0, 0);
	}

	/**
	 * Creates a new Vector4 with given values.
	 * 
	 * @param v the x, y and z values
	 * @param t the t value
	 */
	public Vector4(final Vector3 v, final double t) {
		this(v.x, v.y, v.z, t);
	}

	/**
	 * Adds {@code v} to this Vector4 without changing either one
	 * 
	 * @param v the Vector4 to be added
	 * @return a new independent Vector4 with resulting values
	 */
	public Vector4 plus(final Vector4 v) {
		return new Vector4(v.x + x, v.y + y, v.z + z, v.t + t);
	}

	/**
	 * Adds {@code v1} to {@code v2} without altering them.
	 * 
	 * @param v1 the first vector to be added
	 * @param v2 the second vector to be added
	 * 
	 * @return a new vector with the resulting values
	 */
	public static Vector4 add(final Vector4 v1, final Vector4 v2) {
		return new Vector4(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z, v1.t + v2.t);
	}

	/**
	 * Subtracts {@code v} from this and returns a new independent vector object
	 * with the resulting values. {@code this} isn't changed.
	 * 
	 * @param v the vector to be subtracted
	 * 
	 * @return an independent vector with the resulting values.
	 */
	public Vector4 minus(final Vector4 v) {
		return new Vector4(x - v.x, y - v.y, z - v.z, t - v.t);
	}

	/**
	 * Subtracts {@code v1} from {@code v2} without altering them.
	 * 
	 * @param v1 the first vector to be subtracted
	 * @param v2 the second vector to be subtracted
	 * 
	 * @return a new vector with the resulting values
	 */
	public static Vector4 subtract(final Vector4 v1, final Vector4 v2) {
		return new Vector4(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z, v1.t - v2.t);
	}

	/**
	 * Returns -this.
	 * 
	 * @return -this
	 */
	public Vector4 negative() {
		return new Vector4(-x, -y, -z, -t);
	}

	/**
	 * Returns -v.
	 * 
	 * @param v the vector to be negated
	 * 
	 * @return -v
	 */
	public static Vector4 negate(final Vector4 v) {
		return new Vector4(-v.x, -v.y, -v.z, -v.t);
	}

	/**
	 * Returns a scaled vector of this. this isn't changed.
	 * 
	 * @param factor the factor to scale by
	 * 
	 * @return a new independent vector with resulting values
	 */
	public Vector4 scale(final double factor) {
		return new Vector4(x * factor, y * factor, z * factor, t * factor);
	}

	/**
	 * Scales {@code v} by {@code factor} without altering it.
	 * 
	 * @param v      the vector to scale
	 * @param factor the factor to scale by
	 * 
	 * @return a new independent vector
	 */
	public static Vector4 scale(final Vector4 v, final double factor) {
		return new Vector4(v.x * factor, v.y * factor, v.z * factor, v.t * factor);
	}

	/**
	 * Calculates the dot product of this vector and {@code v}.
	 * 
	 * @param v the vector to multiply with
	 * 
	 * @return the dot product as a double
	 */
	public double dot(final Vector4 v) {
		return x * v.x + y * v.y + z * v.z + t * v.t;
	}

	/**
	 * Calculates the dot product of the two given vectors.
	 * 
	 * @param v1 the first vector to multiply
	 * @param v2 the second vector to multiply
	 * 
	 * @return the dot product as a double
	 */
	public static double dot(final Vector4 v1, final Vector4 v2) {
		return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z + v1.t * v2.t;
	}

	/**
	 * Returns the length of this vector. It is calculated as the square root of the
	 * sum of all the squared coordinates.
	 * 
	 * @return the length of this vector as a double
	 */
	public double length() {
		return Math.sqrt(x * x + y * y + z * z + t * t);
	}

	/**
	 * Returns this vector normalized to a length of 1. This vector isn't changed.
	 * 
	 * @return a new independent vector with resulting values
	 */
	public Vector4 normalize() {
		double length = length();
		return new Vector4(x / length, y / length, z / length, t / length);
	}

	/**
	 * Returns the normalized version of {@code v} without altering it.
	 * 
	 * @param v the vector to get the normalized version of
	 * 
	 * @return a new normalized vector without altering v
	 */
	public static Vector4 getNormalized(final Vector4 v) {
		double length = v.length();
		return new Vector4(v.x / length, v.y / length, v.z / length, v.t / length);
	}

	@Override
	public String toString() {
		return String.format("Vector[%.3f,%.3f,%.3f]\t@%s", x, y, z, Integer.toHexString(hashCode()));
	}

	/**
	 * Returns the four horizontal vectors of {@code m}.
	 * 
	 * @param m the matrix to take the vectors from
	 * 
	 * @return the four horizontal vectors
	 */
	public static Vector4[] getHorizontalVectors(final Matrix4x4 m) {
		Vector4[] temp = new Vector4[4];

		for (int i = 0; i < 4; i++) {
			temp[i] = new Vector4(m.values[i * 4], m.values[i * 4 + 1], m.values[i * 4 + 2], m.values[i * 4 + 3]);
		}

		return temp;
	}

	/**
	 * Returns the four vertical vectors of {@code m}.
	 * 
	 * @param m the matrix to take the vectors from
	 * 
	 * @return the four vertical vectors
	 */
	public static Vector4[] getVerticalVectors(final Matrix4x4 m) {
		Vector4[] temp = new Vector4[4];

		for (int i = 0; i < 4; i++) {
			temp[i] = new Vector4(m.values[i], m.values[4 + i], m.values[8 + i], m.values[12 + i]);
		}

		return temp;
	}
}

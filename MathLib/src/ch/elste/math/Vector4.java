package ch.elste.math;

/**
 * A vector is a mathematical construct holding multiple numbers. This class
 * holds all the essential operations for a 4 by 1 Vector.
 * 
 * @author Dillon Elste
 */
public class Vector4 extends Vector {
	public static final Vector4 X = new Vector4(1, 0, 0, 0);
	public static final Vector4 Y = new Vector4(0, 1, 0, 0);
	public static final Vector4 Z = new Vector4(0, 0, 1, 0);
	public static final Vector4 W = new Vector4(0, 0, 0, 1);

	/**
	 * Creates a new Vector4 with given values.
	 * 
	 * @param x the x value
	 * @param y the y value
	 * @param z the z value
	 * @param t the t value
	 */
	public Vector4(final double x, final double y, final double z, final double w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
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
	public Vector4(final Vector3 v, final double w) {
		this(v.x, v.y, v.z, w);
	}

	/**
	 * Adds {@code v} to this Vector4 without changing either one
	 * 
	 * @param v the Vector4 to be added
	 * @return a new independent Vector4 with resulting values
	 */
	public Vector4 plus(final Vector4 v) {
		return new Vector4(v.x + x, v.y + y, v.z + z, v.w + w);
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
		return new Vector4(x - v.x, y - v.y, z - v.z, w - v.w);
	}

	/**
	 * Returns -this.
	 * 
	 * @return -this
	 */
	public Vector4 negative() {
		return new Vector4(-x, -y, -z, -w);
	}

	/**
	 * Returns a scaled vector of this. this isn't changed.
	 * 
	 * @param factor the factor to scale by
	 * 
	 * @return a new independent vector with resulting values
	 */
	public Vector4 scale(final double factor) {
		return new Vector4(x * factor, y * factor, z * factor, w * factor);
	}

	/**
	 * Calculates the dot product of this vector and {@code v}.
	 * 
	 * @param v the vector to multiply with
	 * 
	 * @return the dot product as a double
	 */
	public double dot(final Vector4 v) {
		return x * v.x + y * v.y + z * v.z + w * v.w;
	}

	/**
	 * Returns the length of this vector. It is calculated as the square root of the
	 * sum of all the squared coordinates.
	 * 
	 * @return the length of this vector as a double
	 */
	public double length() {
		return Math.sqrt(x * x + y * y + z * z + w * w);
	}

	/**
	 * Returns this vector normalized to a length of 1. This vector isn't changed.
	 * 
	 * @return a new independent vector with resulting values
	 */
	public Vector4 normalize() {
		double length = length();
		return new Vector4(x / length, y / length, z / length, w / length);
	}

	@Override
	public String toString() {
		return String.format("Vector[%.3f,%.3f,%.3f,%.3f]\t@%s", x, y, z, w, Integer.toHexString(hashCode()));
	}
}

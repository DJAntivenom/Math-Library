package ch.elste.math;

public abstract class Vector {
	public double x, y, z, w;

	/**
	 * Adds {@code v1} to {@code v2} without altering them.
	 * 
	 * @param v1 the first vector to be added
	 * @param v2 the second vector to be added
	 * 
	 * @return a new vector with the resulting values
	 */
	public static Vector2 add(final Vector2 v1, final Vector2 v2) {
		return new Vector2(v1.x + v2.x, v1.y + v2.y);
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
	public static Vector3 add(final Vector3 v1, final Vector3 v2) {
		return new Vector3(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
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
		return new Vector4(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z, v1.w + v2.w);
	}

	/**
	 * Subtracts {@code v1} from {@code v2} without altering them.
	 * 
	 * @param v1 the first vector to be subtracted
	 * @param v2 the second vector to be subtracted
	 * 
	 * @return a new vector with the resulting values
	 */
	public static Vector2 subtract(final Vector2 v1, final Vector2 v2) {
		return new Vector2(v1.x - v2.x, v1.y - v2.y);
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
	public static Vector3 subtract(final Vector3 v1, final Vector3 v2) {
		return new Vector3(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
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
		return new Vector4(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z, v1.w - v2.w);
	}

	/**
	 * Returns -v.
	 * 
	 * @param v the vector to be negated
	 * 
	 * @return -v
	 */
	public static Vector2 negate(final Vector2 v) {
		return new Vector2(-v.x, -v.y);
	}

	/**
	 * Returns -v.
	 * 
	 * @param v
	 *            the vector to be negated
	 * 
	 * @return -v
	 */
	public static Vector3 negate(final Vector3 v) {
		return new Vector3(-v.x, -v.y, -v.z);
	}

	/**
	 * Returns -v.
	 * 
	 * @param v the vector to be negated
	 * 
	 * @return -v
	 */
	public static Vector4 negate(final Vector4 v) {
		return new Vector4(-v.x, -v.y, -v.z, -v.w);
	}

	/**
	 * Scales {@code v} by {@code factor} without altering it.
	 * 
	 * @param v      the vector to scale
	 * @param factor the factor to scale by
	 * 
	 * @return a new independent vector
	 */
	public static Vector2 scale(final Vector2 v, final double factor) {
		return new Vector2(v.x * factor, v.y * factor);
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
	public static Vector3 scale(final Vector3 v, final double factor) {
		return new Vector3(v.x * factor, v.y * factor, v.z * factor);
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
		return new Vector4(v.x * factor, v.y * factor, v.z * factor, v.w * factor);
	}

	/**
	 * Calculates the dot product of the two given vectors.
	 * 
	 * @param v1 the first vector to multiply
	 * @param v2 the second vector to multiply
	 * 
	 * @return the dot product as a double
	 */
	public static double dot(final Vector2 v1, final Vector2 v2) {
		return v1.x * v2.x + v1.y * v2.y;
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
	public static double dot(final Vector3 v1, final Vector3 v2) {
		return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
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
		return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z + v1.w * v2.w;
	}

	/**
	 * Returns the normalized version of {@code v} without altering it.
	 * 
	 * @param v the vector to get the normalized version of
	 * 
	 * @return a new normalized vector without altering v
	 */
	public static Vector2 getNormalized(final Vector2 v) {
		double length = v.length();
		return new Vector2(v.x / length, v.y / length);
	}

	/**
	 * Returns the normalized version of {@code v} without altering it.
	 * 
	 * @param v
	 *            the vector to get the normalized version of
	 * 
	 * @return a new normalized vector without altering v
	 */
	public static Vector3 getNormalized(final Vector3 v) {
		double length = v.length();
		return new Vector3(v.x / length, v.y / length, v.z / length);
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
		return new Vector4(v.x / length, v.y / length, v.z / length, v.w / length);
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
	public static Vector3 cross(final Vector3 v1, final Vector3 v2) {
		return new Vector3(v1.y * v2.z - v1.z * v2.y, v1.z * v2.x - v1.x * v2.z, v1.x * v2.y - v1.y * v2.x);
	}

	/**
	 * Returns the three horizontal vectors of {@code m}.
	 * 
	 * @param m the matrix to take the vectors from
	 * 
	 * @return the three horizontal vectors
	 */
	public static Vector2[] getHorizontalVectors(final Matrix2x2 m) {
		Vector2[] temp = new Vector2[2];

		for (int i = 0; i < 3; i++) {
			temp[i] = new Vector2(m.values[i * 2], m.values[i * 2 + 1]);
		}

		return temp;
	}

	/**
	 * Returns the three horizontal vectors of {@code m}.
	 * 
	 * @param m
	 *            the matrix to take the vectors from
	 * 
	 * @return the three horizontal vectors
	 */
	public static Vector3[] getHorizontalVectors(final Matrix3x3 m) {
		Vector3[] temp = new Vector3[3];

		for (int i = 0; i < 3; i++) {
			temp[i] = new Vector3(m.values[i * 3], m.values[i * 3 + 1], m.values[i * 3 + 2]);
		}

		return temp;
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
	 * Returns the three vertical vectors of {@code m}.
	 * 
	 * @param m the matrix to take the vectors from
	 * 
	 * @return the three vertical vectors
	 */
	public static Vector2[] getVerticalVectors(final Matrix2x2 m) {
		Vector2[] temp = new Vector2[2];

		for (int i = 0; i < 3; i++) {
			temp[i] = new Vector2(m.values[i], m.values[2 + i]);
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
	public static Vector3[] getVerticalVectors(final Matrix3x3 m) {
		Vector3[] temp = new Vector3[3];

		for (int i = 0; i < 3; i++) {
			temp[i] = new Vector3(m.values[i], m.values[3 + i], m.values[6 + i]);
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

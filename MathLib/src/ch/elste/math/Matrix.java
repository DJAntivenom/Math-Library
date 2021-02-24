package ch.elste.math;

/**
 * A utility class for creation and management of MatriNxN objects.
 * 
 * @author Dillon Elste
 * 
 * @version 09.02.2021
 * 
 * @see Matrix2x2
 * @see Matrix3x3
 * @see Matrix4x4
 */
public abstract class Matrix {
	/**
	 * The entries of the matrix
	 */
	public double[] values;

	/**
	 * Creates a new matrix with given columns.
	 * 
	 * @param v1 the left vector
	 * @param v2 the right vector
	 * 
	 * @return a new matrix
	 */
	public static Matrix2x2 fromVerticalVectors(Vector2 v1, Vector2 v2) {
		return new Matrix2x2(v1.x, v2.x, v1.y, v2.y);
	}

	/**
	 * Creates a new matrix with given columns.
	 * 
	 * @param v1 the first vector
	 * @param v2 the second vector
	 * @param v3 the third vector
	 * 
	 * @return a new matrix
	 */
	public static Matrix3x3 fromVerticalVectors(Vector3 v1, Vector3 v2, Vector3 v3) {
		double[] temp = { v1.x, v2.x, v3.x, v1.y, v2.y, v3.y, v1.z, v2.z, v3.z };
		return new Matrix3x3(temp);
	}

	/**
	 * Creates a new matrix with given columns.
	 * 
	 * @param v1 the first vector
	 * @param v2 the second vector
	 * @param v3 the third vector
	 * @param v4 the fourth vector
	 * 
	 * @return a new matrix
	 */
	public static Matrix4x4 fromVerticalVectors(Vector4 v1, Vector4 v2, Vector4 v3, Vector4 v4) {
		double[] temp = { v1.x, v2.x, v3.x, v4.x, v1.y, v2.y, v3.y, v4.y, v1.z, v2.z, v3.z, v4.z, v1.w, v2.w, v3.w,
				v4.w };
		return new Matrix4x4(temp);
	}

	/**
	 * Creates a new matrix with given rows.
	 * 
	 * @param v1 the upper row
	 * @param v2 the lower row
	 * 
	 * @return a new matrix with given values
	 */
	public static Matrix2x2 fromHorizontalVectors(Vector2 v1, Vector2 v2) {
		return new Matrix2x2(v1.x, v1.y, v2.x, v2.y);
	}

	/**
	 * Creates a new matrix with given rows.
	 * 
	 * @param v1 the upper row
	 * @param v2 the middle row
	 * @param v3 the lower row
	 * 
	 * @return a new matrix
	 */
	public static Matrix3x3 fromHorizontalVectors(Vector3 v1, Vector3 v2, Vector3 v3) {
		double[] temp = { v1.x, v1.y, v1.z, v2.x, v2.y, v2.z, v3.x, v3.y, v3.z };
		return new Matrix3x3(temp);
	}

	/**
	 * Creates a new matrix with given rows.
	 * 
	 * @param v1 the uppermost row
	 * @param v2 the second row from the top
	 * @param v3 the second row from the bottom
	 * @param v4 the row at the bottom
	 * 
	 * @return a new matrix
	 */
	public static Matrix4x4 fromHorizontalVectors(Vector4 v1, Vector4 v2, Vector4 v3, Vector4 v4) {
		double[] temp = { v1.x, v1.y, v1.z, v1.w, v2.x, v2.y, v2.z, v2.w, v3.x, v3.y, v3.z, v3.w, v4.x, v4.y, v4.z,
				v4.w };
		return new Matrix4x4(temp);
	}

	/**
	 * Adds {@code m1} and {@code m2} without altering them.
	 * 
	 * @param m1 the first matrix to be added
	 * @param m2 the second matrix to be added
	 * 
	 * @return a new independent matrix
	 */
	public static Matrix2x2 add(Matrix2x2 m1, Matrix2x2 m2) {
		double[] temp = new double[m1.values.length];

		for (int i = 0; i < temp.length; i++) {
			temp[i] = m1.values[i] + m2.values[i];
		}

		return new Matrix2x2(temp);
	}

	/**
	 * Adds {@code m1} and {@code m2} without altering them.
	 * 
	 * @param m1 the first matrix to be added
	 * @param m2 the second matrix to be added
	 * 
	 * @return a new independent matrix
	 */
	public static Matrix3x3 add(Matrix3x3 m1, Matrix3x3 m2) {
		double[] temp = new double[m1.values.length];

		for (int i = 0; i < temp.length; i++) {
			temp[i] = m1.values[i] + m2.values[i];
		}

		return new Matrix3x3(temp);
	}

	/**
	 * Adds {@code m1} and {@code m2} without altering them.
	 * 
	 * @param m1 the first matrix to be added
	 * @param m2 the second matrix to be added
	 * 
	 * @return a new independent matrix
	 */
	public static Matrix4x4 add(Matrix4x4 m1, Matrix4x4 m2) {
		double[] temp = new double[m1.values.length];

		for (int i = 0; i < temp.length; i++) {
			temp[i] = m1.values[i] + m2.values[i];
		}

		return new Matrix4x4(temp);
	}

	/**
	 * Scales {@code m} with {@code d}. {@code m} is not altered.
	 * 
	 * @param m the matrix to scale
	 * @param d the factor to scale with
	 * 
	 * @return a new independent matrix
	 */
	public static Matrix2x2 scale(Matrix2x2 m, double d) {
		double[] temp = new double[m.values.length];

		for (int i = 0; i < temp.length; i++) {
			temp[i] = m.values[i] * d;
		}

		return new Matrix2x2(temp);
	}

	/**
	 * Scales {@code m} with {@code d}. {@code m} is not altered.
	 * 
	 * @param m the matrix to scale
	 * @param d the factor to scale with
	 * 
	 * @return a new independent matrix
	 */
	public static Matrix3x3 scale(Matrix3x3 m, double d) {
		double[] temp = new double[m.values.length];

		for (int i = 0; i < temp.length; i++) {
			temp[i] = m.values[i] * d;
		}

		return new Matrix3x3(temp);
	}

	/**
	 * Scales {@code m} with {@code d}. {@code m} is not altered.
	 * 
	 * @param m the matrix to scale
	 * @param d the factor to scale with
	 * 
	 * @return a new independent matrix
	 */
	public static Matrix4x4 scale(Matrix4x4 m, double d) {
		double[] temp = new double[m.values.length];

		for (int i = 0; i < m.values.length; i++) {
			temp[i] = m.values[i] * d;
		}

		return new Matrix4x4(temp);
	}

	/**
	 * Multiplies m1 times m2 without altering them.
	 * 
	 * @param m1 the first matrix
	 * @param m2 the second matrix
	 * 
	 * @return a new independent matrix which is the product of m1 and m2
	 */
	public static Matrix2x2 mult(Matrix2x2 m1, Matrix2x2 m2) {
		double[] temp = new double[m1.values.length];
		Vector2[] m1Vecs = Vector2.getHorizontalVectors(m1);
		Vector2[] m2Vecs = Vector2.getVerticalVectors(m2);

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				temp[i * 2 + j] = Vector2.dot(m1Vecs[i], m2Vecs[j]);
			}
		}

		return new Matrix2x2(temp);
	}

	/**
	 * Multiplies m1 times m2 without altering them.
	 * 
	 * @param m1 the first matrix
	 * @param m2 the second matrix
	 * 
	 * @return a new independent matrix which is the product of m1 times m2
	 */
	public static Matrix3x3 mult(Matrix3x3 m1, Matrix3x3 m2) {
		double[] temp = new double[9];
		Vector3[] m1Vecs = Vector3.getHorizontalVectors(m1);
		Vector3[] m2Vecs = Vector3.getVerticalVectors(m2);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				temp[i * 3 + j] = Vector3.dot(m1Vecs[i], m2Vecs[j]);
			}
		}

		return new Matrix3x3(temp);
	}

	/**
	 * Multiplies m1 times m2 without altering them.
	 * 
	 * @param m1 the first matrix
	 * @param m2 the second matrix
	 * 
	 * @return a new independent matrix which is the product of m1 times m2
	 */
	public static Matrix4x4 mult(Matrix4x4 m1, Matrix4x4 m2) {
		double[] temp = new double[m1.values.length];
		Vector4[] m1Vecs = Vector4.getHorizontalVectors(m1);
		Vector4[] m2Vecs = Vector4.getVerticalVectors(m2);

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				temp[i * 4 + j] = Vector4.dot(m1Vecs[i], m2Vecs[j]);
			}
		}

		return new Matrix4x4(temp);
	}

	/**
	 * Multiplies m with v. This is actually a normal matrix multiplication with a
	 * 3x1 matrix.
	 * 
	 * @param m the matrix to multiply
	 * @param v the vector to multiply
	 * 
	 * @return the resulting vector
	 */
	public static Vector2 mult(Matrix2x2 m, Vector2 v) {
		Vector2 res = new Vector2();
		Vector2[] temp = Vector2.getHorizontalVectors(m);
		res.x = temp[0].dot(v);
		res.y = temp[1].dot(v);

		return res;
	}

	/**
	 * Multiplies m with v. This is actually a normal matrix multiplication with a
	 * 3x1 matrix.
	 * 
	 * @param m the matrix to multiply
	 * @param v the vector to multiply
	 * 
	 * @return the resulting vector
	 */
	public static Vector3 mult(Matrix3x3 m, Vector3 v) {
		Vector3 res = new Vector3();
		Vector3[] temp = Vector3.getHorizontalVectors(m);
		res.x = temp[0].dot(v);
		res.y = temp[1].dot(v);
		res.z = temp[2].dot(v);

		return res;
	}

	/**
	 * Multiplies m with v. This is actually a normal matrix multiplication with a
	 * 4x1 matrix.
	 * 
	 * @param m the matrix to multiply
	 * @param v the vector to multiply
	 * 
	 * @return the resulting vector
	 */
	public static Vector4 mult(Matrix4x4 m, Vector4 v) {
		Vector4 res = new Vector4();
		Vector4[] temp = Vector4.getHorizontalVectors(m);
		res.x = temp[0].dot(v);
		res.y = temp[1].dot(v);
		res.z = temp[2].dot(v);
		res.w = temp[3].dot(v);

		return res;
	}

	/**
	 * Creates a matrix where the diagonal values are the values of d or just d if
	 * it is a singular value.
	 * 
	 * @param dimension the dimension of the matrix to be created. 2, 3 or 4.
	 * @param d    the values for the diagonal or just one value for the whole
	 *             diagonal.
	 * 
	 * @return a new matrix
	 */
	public static Matrix diag(int dimension, double... d) {
		if (dimension == 2) {
			return diag2(d);
		} else if (dimension == 3) {
			return diag3(d);
		} else if (dimension == 4) {
			return diag4(d);
		} else {
			throw new IllegalArgumentException("This is not a valid dimension for a matrix");
		}
	}

	private static Matrix diag2(double... d) {
		double[] temp;
		if (d.length == 1) {
			temp = new double[] { d[0], 0, 0, d[0] };
		} else if (d.length == 2) {
			temp = new double[] { d[0], 0, 0, d[1] };
		} else {
			throw new IllegalArgumentException("Invalid number of arguments " + d.length + " for 1 or 2");
		}

		return new Matrix2x2(temp);
	}

	private static Matrix diag3(double... d) {
		double[] temp;
		if (d.length == 1) {
			temp = new double[] { d[0], 0, 0, 0, d[0], 0, 0, 0, d[0] };
		} else if (d.length == 3) {
			temp = new double[] { d[0], 0, 0, 0, d[1], 0, 0, 0, d[2] };
		} else {
			throw new IllegalArgumentException("Invalid number of arguments " + d.length + " for 1 or 3");
		}

		return new Matrix3x3(temp);
	}

	private static Matrix diag4(double... d) {
		double[] temp;
		if (d.length == 1) {
			temp = new double[] { d[0], 0, 0, 0, 0, d[0], 0, 0, 0, 0, d[0], 0, 0, 0, 0, d[0] };
		} else if (d.length == 3) {
			temp = new double[] { d[0], 0, 0, 0, 0, d[1], 0, 0, 0, 0, d[2], 0, 0, 0, 0, d[0] };
		} else {
			throw new IllegalArgumentException("Invalid number of arguments " + d.length + " for 1 or 4");
		}

		return new Matrix4x4(temp);
	}
}

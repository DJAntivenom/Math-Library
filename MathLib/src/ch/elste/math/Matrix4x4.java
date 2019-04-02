package ch.elste.math;

import java.util.Arrays;

/**
 * A matrix is a mathematical construct to hold multiple numbers. This class
 * implements a 4 by 4 matrix.
 * 
 * @author Dillon Elste
 */
public class Matrix4x4 {
	public double[] values = new double[16];

	/**
	 * Creates a new matrix with given values.
	 * 
	 * @param values the values of this matrix
	 * 
	 * @throws IllegalArgumentException if {@code values.length} is not equal to 16
	 */
	public Matrix4x4(double[] values) {
		if (values.length != this.values.length)
			throw new IllegalArgumentException("There have to be 9 values!");

		this.values = values;
	}

	/**
	 * Creates a new matrix where all values are {@code d}.
	 * 
	 * @param d the value of all components
	 */
	public Matrix4x4(double d) {
		Arrays.fill(values, d);
	}

	/**
	 * Creates a new matrix initialized with zeros.
	 * <p>
	 * This is equal to calling {@link #Matrix4x4(double) new Matrix4x4(0)}.
	 */
	public Matrix4x4() {
	}

	/**
	 * Creates a new matrix with given columns.
	 * 
	 * @param v1
	 *            the first vector
	 * @param v2
	 *            the second vector
	 * @param v3
	 *            the third vector
	 * @param v4 
	 * 			  the fourth vector
	 * 
	 * @return a new matrix
	 */
	public static Matrix4x4 fromVerticalVectors(Vector4 v1, Vector4 v2, Vector4 v3, Vector4 v4) {
		double[] temp = { 
				v1.x, v2.x, v3.x, v4.x,
				v1.y, v2.y, v3.y, v4.y,
				v1.z, v2.z, v3.z, v4.z,
				v1.t, v2.t, v3.t, v4.t };
		return new Matrix4x4(temp);
	}
	
	/**
	 * Adds {@code m} to this matrix without changing them and returns a new
	 * independent matrix object with given values.
	 * 
	 * @param m the matrix to add
	 * 
	 * @return a new independent matrix object with resulting values
	 */
	public Matrix4x4 add(Matrix4x4 m) {
		double temp[] = Arrays.copyOf(values, values.length);

		for (int i = 0; i < values.length; i++) {
			temp[i] += m.values[i];
		}

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
	public static Matrix4x4 add(Matrix4x4 m1, Matrix4x4 m2) {
		double[] temp = new double[m1.values.length];

		for (int i = 0; i < temp.length; i++) {
			temp[i] = m1.values[i] + m2.values[i];
		}

		return new Matrix4x4(temp);
	}

	/**
	 * Scales each value of this matrix by {@code d} without altering them.
	 * 
	 * @param d the factor to scale with
	 * 
	 * @return a new independent matrix
	 */
	public Matrix4x4 scale(double d) {
		double temp[] = Arrays.copyOf(values, values.length);

		for (int i = 0; i < values.length; i++) {
			temp[i] *= d;
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
	public static Matrix4x4 scale(Matrix4x4 m, double d) {
		double[] temp = new double[m.values.length];

		for (int i = 0; i < m.values.length; i++) {
			temp[i] = m.values[i] * d;
		}

		return new Matrix4x4(temp);
	}

	/**
	 * Multiplies {@code this} with {@code m}. The values of this matrix are not
	 * changed.
	 * 
	 * @param m the matrix to multiply
	 * 
	 * @return a new independent matrix
	 */
	public Matrix4x4 mult(Matrix4x4 m) {
		double[] temp = new double[values.length];
		Vector4[] thisVecs = Vector4.getHorizontalVectors(this);
		Vector4[] mVecs = Vector4.getVerticalVectors(m);

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				temp[i * 4 + j] = Vector4.dot(thisVecs[i], mVecs[j]);
			}
		}

		return new Matrix4x4(temp);
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
	 * Multiplies this matrix with v. This is actually a normal matrix
	 * multiplication with a 4x1 matrix.
	 * 
	 * @param v the vector to multiply with
	 * 
	 * @return the resulting vector
	 */
	public Vector4 mult(Vector4 v) {
		Vector4 res = new Vector4();
		Vector4[] temp = Vector4.getHorizontalVectors(this);
		res.x = temp[0].dot(v);
		res.y = temp[1].dot(v);
		res.z = temp[2].dot(v);
		res.t = temp[3].dot(v);

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
		res.t = temp[3].dot(v);

		return res;
	}

	/**
	 * Sets the value at {@code row, column} to {@code value}.
	 * 
	 * @param row    the row
	 * @param column the column
	 * @param value  the new value
	 * 
	 * @throws IllegalArgumentException if {@code row} or {@code column} is not
	 *                                  between 0 and 3
	 */
	public void set(int row, int column, double value) {
		if (row > 3 || row < 0 || column > 3 || column < 0)
			throw new IllegalArgumentException("row and column must be between 0 and 3");

		values[row * 4 + column] = value;
	}

	/**
	 * Returns the value at {@code row, column}.
	 * 
	 * @param row    the row
	 * @param column the column
	 * 
	 * @return the specified value
	 * 
	 * @throws IllegalArgumentException if {@code row} or {@code column} is not
	 *                                  between 0 and 3
	 */
	public double get(int row, int column) {
		if (row > 3 || row < 0 || column > 3 || column < 0)
			throw new IllegalArgumentException("row and column must be between 0 and 3");

		return values[row * 4 + column];
	}

	@Override
	public String toString() {
		return String.format(
				"Matrix:@%s%n" + "%5.3f\t%5.3f\t%5.3f\t%5.3f%n" + "%5.3f\t%5.3f\t%5.3f\t%5.3f%n"
						+ "%5.3f\t%5.3f\t%5.3f\t%5.3f%n" + "%5.3f\t%5.3f\t%5.3f\t%5.3f%n",
				Integer.toHexString(hashCode()), values[0], values[1], values[2], values[3], values[4], values[5], values[6],
				values[7], values[8], values[9], values[10], values[11], values[12], values[13], values[14],
				values[15]);
	}
}

package ch.elste.math;

import java.util.Arrays;

/**
 * A matrix is a mathematical construct to hold multiple numbers. This class
 * implements a 3 by 3 matrix.
 * 
 * @author Dillon Elste
 */
public class Matrix3x3 {
	public double[] values = new double[9];

	/**
	 * Creates a new matrix with given values.
	 * 
	 * @param values
	 *            the values of this matrix
	 * 
	 * @throws IllegalArgumentException
	 *             if {@code values.length} is not equal to 9
	 */
	public Matrix3x3(double[] values) {
		if (values.length != this.values.length)
			throw new IllegalArgumentException("There have to be 9 values!");

		this.values = values;
	}

	/**
	 * Creates a new matrix where all values are {@code d}.
	 * 
	 * @param d
	 *            the value of all components
	 */
	public Matrix3x3(double d) {
		Arrays.fill(values, d);
	}

	/**
	 * Creates a new matrix initialized with zeros.
	 * <p>
	 * This is equal to calling {@link #Matrix3x3(double) new Matrix3x3(0)}.
	 */
	public Matrix3x3() {
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
	 * 
	 * @return a new matrix
	 */
	public static Matrix3x3 fromVerticalVectors(Vector3 v1, Vector3 v2, Vector3 v3) {
		double[] temp = { 
				v1.x, v2.x, v3.x, 
				v1.y, v2.y, v3.y, 
				v1.z, v2.z, v3.z };
		return new Matrix3x3(temp);
	}

	/**
	 * Adds {@code m} to this matrix without changing it and returns a new independent matrix object
	 * with the resulting values.
	 * 
	 * @param m
	 *            the matrix to add
	 * 
	 * @return a new independent matrix object with resulting values
	 */
	public Matrix3x3 add(Matrix3x3 m) {
		double[] temp = Arrays.copyOf(values, values.length);
		
		for (int i = 0; i < temp.length; i++) {
			temp[i] += m.values[i];
		}
		
		return new Matrix3x3(temp);
	}

	/**
	 * Adds {@code m1} and {@code m2} without altering them.
	 * 
	 * @param m1
	 *            the first matrix to be added
	 * @param m2
	 *            the second matrix to be added
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
	 * Returns a scaled version of this matrix without changing it.
	 * 
	 * @param d
	 *            the factor to scale with
	 * 
	 * @return a new independent matrix
	 */
	public Matrix3x3 scale(double d) {
		double[] temp = Arrays.copyOf(values, values.length);
		
		for (int i = 0; i < temp.length; i++) {
			temp[i] *= d;
		}

		return new Matrix3x3(temp);
	}

	/**
	 * Scales {@code m} with {@code d}. {@code m} is not altered.
	 * 
	 * @param m
	 *            the matrix to scale
	 * @param d
	 *            the factor to scale with
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
	 * Multiplies {@code this} with {@code m}. The values of this matrix are not changed.
	 * 
	 * @param m
	 *            the matrix to multiply
	 * 
	 * @return a new independent matrix
	 */
	public Matrix3x3 mult(Matrix3x3 m) {
		double[] temp = new double[values.length];
		Vector3[] thisVecs = Vector3.getHorizontalVectors(this);
		Vector3[] mVecs = Vector3.getVerticalVectors(m);

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				temp[i * 3 + j] = Vector3.dot(thisVecs[i], mVecs[j]);
			}
		}

		return new Matrix3x3(temp);
	}

	/**
	 * Multiplies m1 times m2 without altering them.
	 * 
	 * @param m1
	 *            the first matrix
	 * @param m2
	 *            the second matrix
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
	 * Multiplies this matrix with v. This is actually a normal matrix
	 * multiplication with a 3x1 matrix.
	 * 
	 * @param v
	 *            the vector to multiply with
	 * 
	 * @return the resulting vector
	 */
	public Vector3 mult(Vector3 v) {
		Vector3 res = new Vector3();
		Vector3[] temp = Vector3.getHorizontalVectors(this);
		res.x = temp[0].dot(v);
		res.y = temp[1].dot(v);
		res.z = temp[2].dot(v);

		return res;
	}

	/**
	 * Multiplies m with v. This is actually a normal matrix multiplication with a
	 * 3x1 matrix.
	 * 
	 * @param m
	 *            the matrix to multiply
	 * @param v
	 *            the vector to multiply
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
	 * Sets the value at {@code row, column} to {@code value}.
	 * 
	 * @param row
	 *            the row
	 * @param column
	 *            the column
	 * @param value
	 *            the new value
	 */
	public void set(int row, int column, double value) {
		if (row > 2 || row < 0 || column > 2 || column < 0)
			throw new IllegalArgumentException("row and column must be between 0 and 2");

		values[row * 3 + column] = value;
	}

	/**
	 * Returns the value at {@code row, column}.
	 * 
	 * @param row
	 *            the row
	 * @param column
	 *            the column
	 * 
	 * @return the specified value
	 */
	public double get(int row, int column) {
		return values[row * 3 + column];
	}

	@Override
	public String toString() {
		return String.format(
				"Matrix:\t%s%n" + "%5.3f\t%5.3f\t%5.3f\t%n" + "%5.3f\t%5.3f\t%5.3f\t%n" + "%5.3f\t%5.3f\t%5.3f\t",
				super.toString(), values[0], values[1], values[2], values[3], values[4], values[5], values[6],
				values[7], values[8]);
	}
}

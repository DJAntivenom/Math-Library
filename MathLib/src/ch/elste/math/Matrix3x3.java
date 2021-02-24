package ch.elste.math;

import java.util.Arrays;

/**
 * A matrix is a mathematical construct to hold multiple numbers. This class
 * implements a 3 by 3 matrix.
 * 
 * @author Dillon Elste
 */
public class Matrix3x3 extends Matrix {
	/**
	 * The identity matrix given by {@link Matrix#diag(int, double...) diag(3, 1)}.
	 */
	public static final Matrix3x3 I = new Matrix3x3(1, 0, 0, 0, 1, 0, 0, 0, 1);
	
	/**
	 * Creates a new matrix with given values.
	 * 
	 * @param values the values of this matrix
	 * 
	 * @throws IllegalArgumentException if {@code values.length} is not equal to 9
	 */
	public Matrix3x3(double...values) {
		this();
		if (values.length != this.values.length)
			throw new IllegalArgumentException("There have to be 9 values!");

		this.values = values;
	}

	/**
	 * Creates a new matrix where all values are {@code d}.
	 * 
	 * @param d the value of all components
	 */
	public Matrix3x3(double d) {
		this();
		Arrays.fill(values, d);
	}

	/**
	 * Creates a new matrix initialized with zeros.
	 * <p>
	 * This is equal to calling {@link #Matrix3x3(double) new Matrix3x3(0)}.
	 */
	public Matrix3x3() {
		values = new double[9];
	}

	/**
	 * Adds {@code m} to this matrix without changing it and returns a new
	 * independent matrix object with the resulting values.
	 * 
	 * @param m the matrix to add
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
	 * Returns a scaled version of this matrix without changing it.
	 * 
	 * @param d the factor to scale with
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
	 * Multiplies {@code this} with {@code m}. The values of this matrix are not
	 * changed.
	 * 
	 * @param m the matrix to multiply
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
	 * Multiplies this matrix with v. This is actually a normal matrix
	 * multiplication with a 3x1 matrix.
	 * 
	 * @param v the vector to multiply with
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
	 * Sets the value at {@code row, column} to {@code value}.
	 * 
	 * @param row    the row
	 * @param column the column
	 * @param value  the new value
	 */
	public void set(int row, int column, double value) {
		if (row > 2 || row < 0 || column > 2 || column < 0)
			throw new IllegalArgumentException("row and column must be between 0 and 2");

		values[row * 3 + column] = value;
	}

	/**
	 * Returns the value at {@code row, column}.
	 * 
	 * @param row    the row
	 * @param column the column
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

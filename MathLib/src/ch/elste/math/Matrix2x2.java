package ch.elste.math;

import java.util.Arrays;

/**
 * This class offers basic functionality for 2x2 matrices.
 * 
 * @author Dillon Elste
 * @version 09.02.2021
 */
public class Matrix2x2 extends Matrix {
	/**
	 * The identity matrix given by {@link Matrix#diag(int, double...) diag(2, 1)}.
	 */
	public static final Matrix3x3 I = new Matrix3x3(1, 0, 0, 1);
	
	/**
	 * Creates a new matrix with given values.
	 * 
	 * @param values the values of this matrix
	 * 
	 * @throws IllegalArgumentException if {@code values.length} is not equal to 9
	 */
	public Matrix2x2(double... values) {
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
	public Matrix2x2(double d) {
		this();
		Arrays.fill(values, d);
	}

	/**
	 * Creates a new matrix initialized with zeros.
	 * <p>
	 * This is equal to calling {@link #Matrix2x2(double) new Matrix2x2(0)}.
	 */
	public Matrix2x2() {
		values = new double[4];
	}

	/**
	 * Adds {@code m} to this matrix without changing it and returns a new
	 * independent matrix object with the resulting values.
	 * 
	 * @param m the matrix to add
	 * 
	 * @return a new independent matrix object with resulting values
	 */
	public Matrix2x2 add(Matrix2x2 m) {
		double[] temp = Arrays.copyOf(values, values.length);

		for (int i = 0; i < temp.length; i++) {
			temp[i] += m.values[i];
		}

		return new Matrix2x2(temp);
	}

	/**
	 * Returns a scaled version of this matrix without changing it.
	 * 
	 * @param d the factor to scale with
	 * 
	 * @return a new independent matrix
	 */
	public Matrix2x2 scale(double d) {
		double[] temp = Arrays.copyOf(values, values.length);

		for (int i = 0; i < temp.length; i++) {
			temp[i] *= d;
		}

		return new Matrix2x2(temp);
	}
	
	/**
	 * Multiplies {@code this} with {@code m}. The values of this matrix are not
	 * changed.
	 * 
	 * @param m the matrix to multiply
	 * 
	 * @return a new independent matrix
	 */
	public Matrix2x2 mult(Matrix2x2 m) {
		double[] temp = new double[values.length];
		Vector2[] thisVecs = Vector2.getHorizontalVectors(this);
		Vector2[] mVecs = Vector2.getVerticalVectors(m);

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				temp[i * 2 + j] = Vector2.dot(thisVecs[i], mVecs[j]);
			}
		}

		return new Matrix2x2(temp);
	}

	/**
	 * Multiplies this matrix with v. This is actually a normal matrix
	 * multiplication with a 3x1 matrix.
	 * 
	 * @param v the vector to multiply with
	 * 
	 * @return the resulting vector
	 */
	public Vector2 mult(Vector2 v) {
		Vector2 res = new Vector2();
		Vector2[] temp = Vector2.getHorizontalVectors(this);
		res.x = temp[0].dot(v);
		res.y = temp[1].dot(v);

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
		if (row > 1 || row < 0 || column > 1 || column < 0)
			throw new IllegalArgumentException("row and column must be between 0 and 2");

		values[row * 2 + column] = value;
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
		return values[row * 2 + column];
	}

	@Override
	public String toString() {
		return String.format("Matrix:\t%s%n" + "%5.3f\t%5.3f%n" + "%5.3f\t%5.3f%n", super.toString(), values[0],
				values[1], values[2], values[3]);
	}
}

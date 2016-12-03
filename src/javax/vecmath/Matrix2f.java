/*
 * Copyright Gregery Barton
 * All rights reserved
 */
/*
 * $RCSfile: Matrix3f.java,v $
 *
 * Copyright 1996-2008 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 *
 * $Revision: 1.8 $
 * $Date: 2008/02/28 20:18:50 $
 * $State: Exp $
 */
package javax.vecmath;

/**
 *
 * @author Gregery Barton
 */
public class Matrix2f {

	/**
	 * The first matrix element in the first row.
	 */
	public float m00;

	/**
	 * The second matrix element in the first row.
	 */
	public float m01;
	/**
	 * The first matrix element in the second row.
	 */
	public float m10;

	/**
	 * The second matrix element in the second row.
	 */
	public float m11;

	public Matrix2f() {
	}

	/**
	 * Constructs and initializes a Matrix3f from the specified four values.
	 *
	 * @param m00
	 * @param m01
	 * @param m10
	 * @param m11
	 */
	public Matrix2f(float m00, float m01, float m10, float m11) {
		this.m00 = m00;
		this.m01 = m01;
		this.m10 = m10;
		this.m11 = m11;
	}

	/**
	 * Constructs a new matrix with the same values as the Matrix3f parameter.
	 *
	 * @param m1 the source matrix
	 */
	public Matrix2f(Matrix2f m1) {
		this.m00 = m1.m00;
		this.m01 = m1.m01;
		this.m10 = m1.m10;
		this.m11 = m1.m11;
	}

	/**
	 * Get the first matrix element in the first row.
	 *
	 * @return Returns the m00.
	 *
	 */
	public final float getM00() {
		return m00;
	}

	/**
	 * Set the first matrix element in the first row.
	 *
	 * @param m00 The m00 to set.
	 * @return this for chaining
	 *
	 */
	public final Matrix2f setM00(float m00) {
		this.m00 = m00;
		return this;
	}

	/**
	 * Get the second matrix element in the first row.
	 *
	 * @return Returns the m01.
	 *
	 *
	 */
	public final float getM01() {
		return m01;
	}

	/**
	 * Set the second matrix element in the first row.
	 *
	 * @param m01 The m01 to set.
	 * @return this for chaining
	 *
	 */
	public final Matrix2f setM01(float m01) {
		this.m01 = m01;
		return this;
	}

	/**
	 * Get first matrix element in the second row.
	 *
	 * @return Returns the m10.
	 *
	 */
	public final float getM10() {
		return m10;
	}

	/**
	 * Set first matrix element in the second row.
	 *
	 * @param m10 The m10 to set.
	 * @return this for chaining
	 *
	 */
	public final Matrix2f setM10(float m10) {
		this.m10 = m10;
		return this;
	}

	/**
	 * Get second matrix element in the second row.
	 *
	 * @return Returns the m11.
	 *
	 */
	public final float getM11() {
		return m11;
	}

	/**
	 * Set the second matrix element in the second row.
	 *
	 * @param m11 The m11 to set.
	 * @return this for chaining
	 *
	 */
	public final Matrix2f setM11(float m11) {
		this.m11 = m11;
		return this;
	}

	/**
	 * Constructs and initializes a Matrix3f from the specified nine-element array. this.m00 =v[0], this.m01=v[1], etc.
	 *
	 * @param v the array of length 4 containing in order
	 */
	public Matrix2f(float[] v) {
		this.m00 = v[0];
		this.m01 = v[1];
		this.m10 = v[2];
		this.m11 = v[3];
	}

	/**
	 * Set the elements of this matrix to the abs value of the corresponding element in m1.
	 *
	 * @param m1 the matrix to get values
	 * @return this for chaining
	 */
	public final Matrix2f abs(Matrix2f m1) {
		abs(this, m1);
		return this;
	}

	/**
	 * Set each element of this matrix to its abs value
	 *
	 * @return this for chaining.
	 */
	public final Matrix2f abs() {
		abs(this, this);
		return this;
	}

	private static void abs(Matrix2f dest, Matrix2f mat) {
		dest.m00 = Math.abs(mat.m00);
		dest.m01 = Math.abs(mat.m01);
		dest.m10 = Math.abs(mat.m10);
		dest.m11 = Math.abs(mat.m11);
	}

	/**
	 * Adds a scalar to each component of this matrix.
	 *
	 * @param scalar the scalar adder
	 * @return this for chaining
	 */
	public final Matrix2f add(float scalar) {
		m00 += scalar;
		m01 += scalar;
		m10 += scalar;
		m11 += scalar;
		return this;
	}

	/**
	 * Adds a scalar to each component of the matrix m1 and places the result into this. Matrix m1 is not modified.
	 *
	 * @param scalar the scalar adder.
	 * @param m1 the original matrix values
	 * @return this for chaining
	 */
	public final Matrix2f add(float scalar, Matrix2f m1) {
		this.m00 = m1.m00 + scalar;
		this.m01 = m1.m01 + scalar;
		this.m10 = m1.m10 + scalar;
		this.m11 = m1.m11 + scalar;
		return this;
	}

	/**
	 * Sets the value of this matrix to the matrix sum of matrices m1 and m2.
	 *
	 * @param m1 the first matrix
	 * @param m2 the second matrix
	 * @return this for chaining
	 */
	public final Matrix2f add(Matrix2f m1, Matrix2f m2) {
		this.m00 = m1.m00 + m2.m00;
		this.m01 = m1.m01 + m2.m01;

		this.m10 = m1.m10 + m2.m10;
		this.m11 = m1.m11 + m2.m11;

		return this;
	}

	/**
	 * Sets the value of this matrix to the matrix sum of itself and matrix m1.
	 *
	 * @param m1 the other matrix
	 * @return this for chaining
	 */
	public final Matrix2f add(Matrix2f m1) {
		this.m00 += m1.m00;
		this.m01 += m1.m01;
		this.m10 += m1.m10;
		this.m11 += m1.m11;

		return this;
	}

	/**
	 * Sets the value of this matrix to the matrix difference of matrices m1 and m2.
	 *
	 * @param m1 the first matrix
	 * @param m2 the second matrix
	 * @return this for chaining
	 */
	public final Matrix2f sub(Matrix2f m1, Matrix2f m2) {
		this.m00 = m1.m00 - m2.m00;
		this.m01 = m1.m01 - m2.m01;
		this.m10 = m1.m10 - m2.m10;
		this.m11 = m1.m11 - m2.m11;
		return this;
	}

	/**
	 * Sets the value of this matrix to the matrix difference of itself and matrix m1 (this = this - m1).
	 *
	 * @param m1 the other matrix
	 * @return this for chaining
	 */
	public final Matrix2f sub(Matrix2f m1) {
		this.m00 -= m1.m00;
		this.m01 -= m1.m01;
		this.m10 -= m1.m10;
		this.m11 -= m1.m11;
		return this;
	}

	/**
	 * Sets the value of this matrix to its transpose.
	 *
	 * @return this for chaining
	 */
	public final Matrix2f transpose() {
		float temp;
		temp = this.m10;
		this.m10 = this.m01;
		this.m01 = temp;
		return this;
	}

	/**
	 * Sets the value of this matrix to the transpose of the argument matrix.
	 *
	 * @param m1 the matrix to be transposed
	 * @return this for chaining
	 */
	public final Matrix2f transpose(Matrix2f m1) {
		if (this != m1) {
			this.m00 = m1.m00;
			this.m01 = m1.m10;
			this.m10 = m1.m01;
			this.m11 = m1.m11;
		} else {
			this.transpose();
		}
		return this;
	}

	/**
	 * Sets the values in this Matrix3f equal to the row-major array parameter (ie, the first three elements of the array
	 * will be copied into the first row of this matrix, etc.).
	 *
	 * @param m the single precision array of length 9
	 * @return this for chaining
	 */
	public final Matrix2f set(float[] m) {
		m00 = m[0];
		m01 = m[1];
		m10 = m[2];
		m11 = m[3];
		return this;
	}

	/**
	 * Sets the value of this matrix to the value of the Matrix3f argument.
	 *
	 * @param m1 the source matrix3f
	 * @return this for chaining
	 */
	public final Matrix2f set(Matrix2f m1) {

		this.m00 = m1.m00;
		this.m01 = m1.m01;
		this.m10 = m1.m10;
		this.m11 = m1.m11;

		return this;
	}

	/**
	 * Computes the determinant of this matrix.
	 *
	 * @return the determinant of this matrix
	 */
	public final float determinant() {
		return m00 * m11 - m01 * m10;
	}

	/**
	 * Sets the value of this matrix to the matrix inverse of the passed matrix m1.
	 *
	 * @param m1 the matrix to be inverted
	 * @return this for chaining
	 */
	public final Matrix2f invert(Matrix2f m1) {
		this.set(m1);
		invertGeneral(this);
		return this;
	}

	/**
	 * Inverts this matrix in place.
	 *
	 * @return this for chaining
	 */
	public final Matrix2f invert() {
		invertGeneral(this);
		return this;
	}

	private static void invertGeneral(Matrix2f m1) {
		float invdet = 1.0f / m1.determinant();
		float a = m1.m00;
		float b = m1.m01;
		float c = m1.m10;
		float d = m1.m11;
		m1.m00 = d * invdet;
		m1.m01 = -b * invdet;
		m1.m10 = -c * invdet;
		m1.m11 = a * invdet;
	}

	/**
	 * Sets the value of this matrix to a scale matrix with the passed scale amount.
	 *
	 * @param scale the scale factor for the matrix
	 * @return this for chaining
	 */
	public final Matrix2f set(float scale) {
		this.m00 = scale;
		this.m01 = (float) 0.0;
		this.m10 = (float) 0.0;
		this.m11 = scale;
		return this;
	}

	/**
	 * Multiplies each element of this matrix by a scalar.
	 *
	 * @param scalar the scalar multiplier
	 * @return this for chaining
	 */
	public final Matrix2f mul(float scalar) {
		m00 *= scalar;
		m01 *= scalar;
		m10 *= scalar;
		m11 *= scalar;
		return this;
	}

	/**
	 * Multiplies each element of matrix m1 by a scalar and places the result into this. Matrix m1 is not modified.
	 *
	 * @param scalar the scalar multiplier
	 * @param m1 the original matrix
	 * @return this for chaining
	 */
	public final Matrix2f mul(float scalar, Matrix2f m1) {
		this.m00 = scalar * m1.m00;
		this.m01 = scalar * m1.m01;
		this.m10 = scalar * m1.m10;
		this.m11 = scalar * m1.m11;
		return this;
	}

	/**
	 * Sets the value of this matrix to the result of multiplying itself with matrix m1.
	 *
	 * @param m1 the other matrix
	 * @return this for chaining
	 */
	public final Matrix2f mul(Matrix2f m1) {
		float n00, n01,
			n10, n11;

		n00 = m00 * m1.m00 + m01 * m1.m10;
		n01 = m00 * m1.m10 + m01 * m1.m11;
		n10 = m10 * m1.m00 + m11 * m1.m10;
		n11 = m10 * m1.m10 + m11 * m1.m11;
		this.m00 = n00;
		this.m01 = n01;
		this.m10 = n10;
		this.m11 = n11;
		return this;
	}

	/**
	 * Sets the value of this matrix to the result of multiplying the two argument matrices together.
	 *
	 * @param m1 the first matrix
	 * @param m2 the second matrix
	 * @return this for chaining
	 */
	public final Matrix2f mul(Matrix2f m1, Matrix2f m2) {
		if (this != m1 && this != m2) {
			set(m1);
			mul(m2);
		} else {
			set(new Matrix2f(m1).mul(m2));
		}

		return this;
	}

	/**
	 * Multiplies this matrix by matrix m1, does an SVD normalization of the result, and places the result back into this
	 * matrix. this = SVDnorm(this*m1).
	 *
	 * @param m1 the matrix on the right hand side of the multiplication
	 * @return this for chaining
	 */
	public final Matrix2f mulNormalize(Matrix2f m1) {
		Matrix2f tmp = new Matrix2f();
		tmp.mul(this, m1);
		getScaleRotate(tmp, new Vector2f(), this);
		return this;
	}

	/**
	 * Multiplies matrix m1 by matrix m2, does an SVD normalization of the result, and places the result into this matrix.
	 * this = SVDnorm(m1*m2).
	 *
	 * @param m1 the matrix on the left hand side of the multiplication
	 * @param m2 the matrix on the right hand side of the multiplication
	 * @return this for chaining
	 */
	public final Matrix2f mulNormalize(Matrix2f m1, Matrix2f m2) {
		Matrix2f tmp = new Matrix2f();
		tmp.mul(m1, m2);
		getScaleRotate(tmp, new Vector2f(), this);
		return this;
	}

	/**
	 * Scale the columns of matrix m1 by the components of s and store the result in this matrix
	 *
	 * @param m1 the matrix to scale
	 * @param s scale values
	 * @return this for chaining
	 */
	public final Matrix2f mul(Matrix2f m1, Tuple2f s) {
		scale(this, m1, s);
		return this;
	}

	/**
	 * Scale the columns of this matrix by the components of s and store the result in this matrix
	 *
	 * @param s scale values
	 * @return this for chaining
	 */
	public final Matrix2f mul(Tuple2f s) {
		scale(this, this, s);
		return this;
	}

	static void getScaleRotate(Matrix2f m1, Tuple2f scale, Matrix2f rotate) {
		double[] tmp = new double[4];  // scratch matrix
		tmp[0] = m1.m00;
		tmp[1] = m1.m10;
		tmp[2] = m1.m01;
		tmp[3] = m1.m11;

		SingularValueDecomposition svd = new Matrix(tmp, 2).svd();

		Matrix u = svd.getU();
		Matrix vt = svd.getV().transpose();
		Matrix R = u.times(vt);

		double[] singles = svd.getSingularValues();
		scale.x = (float) (singles[0]);
		scale.y = (float) (singles[1]);

		rotate.m00 = (float) R.get(0, 0);
		rotate.m01 = (float) R.get(0, 1);
		rotate.m10 = (float) R.get(1, 0);
		rotate.m11 = (float) R.get(1, 1);
	}

	private static void getScale(Matrix2f m1, Tuple2f scale) {
		double[] tmp = new double[4];  // scratch matrix
		tmp[0] = m1.m00;
		tmp[1] = m1.m10;
		tmp[2] = m1.m01;
		tmp[3] = m1.m11;

		SingularValueDecomposition svd = new Matrix(tmp, 2).svd();

		Matrix u = svd.getU();
		Matrix vt = svd.getV().transpose();
		Matrix R = u.times(vt);

		double[] singles = svd.getSingularValues();
		scale.x = (float) (singles[0]);
		scale.y = (float) (singles[1]);

	}

	private static void scale(Matrix2f dest, Matrix2f mat, Tuple2f s) {
		dest.m00 = mat.m00 * s.x;
		dest.m01 = mat.m01 * s.y;
		dest.m10 = mat.m10 * s.x;
		dest.m11 = mat.m11 * s.y;
	}

	/**
	 * Negates the value of this matrix: this = -this.
	 *
	 * @return this for chaining
	 */
	public final Matrix2f negate() {
		this.m00 = -this.m00;
		this.m01 = -this.m01;
		this.m10 = -this.m10;
		this.m11 = -this.m11;
		return this;
	}

	/**
	 * Sets the value of this matrix equal to the negation of the Matrix3f parameter.
	 *
	 * @param m1 the source matrix
	 * @return this for chaining
	 */
	public final Matrix2f negate(Matrix2f m1) {
		this.m00 = -m1.m00;
		this.m01 = -m1.m01;
		this.m10 = -m1.m10;
		this.m11 = -m1.m11;
		return this;
	}

	/**
	 * Multiply this matrix by the tuple t and place the result back into the tuple (t = this*t).
	 *
	 * @param t the tuple to be multiplied by this matrix and then replaced
	 * @return t for chaining
	 */
	public final Tuple2f transform(Tuple2f t) {
		float x, y;
		x = m00 * t.x + m01 * t.y;
		y = m10 * t.x + m11 * t.y;
		t.set(x, y);
		return t;
	}

	/**
	 * Multiply this matrix by the tuple t and and place the result into the tuple "result" (result = this*t).
	 *
	 * @param t the tuple to be multiplied by this matrix
	 * @param result the tuple into which the product is placed
	 * @return result for chaining
	 */
	public final Tuple2f transform(Tuple2f t, Tuple2f result) {
		float x, y;
		x = m00 * t.x + m01 * t.y;
		y = m10 * t.x + m11 * t.y;
		result.set(x, y);
		return result;
	}

	/**
	 * Sets this matrix to all zeros.
	 *
	 * @return this for chaining
	 */
	public final Matrix2f setZero() {
		m00 = 0.0f;
		m01 = 0.0f;
		m10 = 0.0f;
		m11 = 0.0f;
		return this;
	}

	/**
	 * Sets this matrix to identity.
	 *
	 * @return this for chaining
	 */
	public final Matrix2f setIdentity() {
		this.m00 = (float) 1.0;
		this.m01 = (float) 0.0;
		this.m10 = (float) 0.0;
		this.m11 = (float) 1.0;
		return this;
	}

	/**
	 * Sets the specified element of this matrix to the value provided.
	 *
	 * @param row the row number to be modified (zero indexed)
	 * @param column the column number to be modified (zero indexed)
	 * @param value the new value
	 * @return this for chaining
	 */
	public final Matrix2f setElement(int row, int column, float value) {
		switch (row) {
			case 0:
				switch (column) {
					case 0:
						this.m00 = value;
						break;
					case 1:
						this.m01 = value;
						break;
					default:
						throw new ArrayIndexOutOfBoundsException();
				}
				break;

			case 1:
				switch (column) {
					case 0:
						this.m10 = value;
						break;
					case 1:
						this.m11 = value;
						break;
					default:
						throw new ArrayIndexOutOfBoundsException();
				}
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return this;
	}

	/**
	 * Retrieves the value at the specified row and column of this matrix.
	 *
	 * @param row the row number to be retrieved (zero indexed)
	 * @param column the column number to be retrieved (zero indexed)
	 * @return the value at the indexed element.
	 */
	public final float getElement(int row, int column) {
		switch (row) {
			case 0:
				switch (column) {
					case 0:
						return (this.m00);
					case 1:
						return (this.m01);
				}
				break;
			case 1:
				switch (column) {
					case 0:
						return (this.m10);
					case 1:
						return (this.m11);
				}
				break;
		}
		throw new ArrayIndexOutOfBoundsException();
	}

	/**
	 * Sets the value of this matrix to a counter clockwise rotation.
	 *
	 * @param angle the angle to rotate by in radians
	 * @return this for chaining
	 */
	public final Matrix2f rot(float angle) {
		float sinAngle = (float) Math.sin((float) angle);
		float cosAngle = (float) Math.cos((float) angle);
		this.m00 = cosAngle;
		this.m01 = -sinAngle;
		this.m10 = sinAngle;
		this.m11 = cosAngle;
		return this;
	}

	/**
	 * Sets the specified column of this matrix to the values provided.
	 *
	 * @param column the column number to be modified (zero indexed)
	 * @param x the first row element
	 * @param y the second row element
	 * @return this for chaining
	 */
	public final Matrix2f setColumn(int column, float x, float y) {
		switch (column) {
			case 0:
				this.m00 = x;
				this.m10 = y;
				break;

			case 1:
				this.m01 = x;
				this.m11 = y;
				break;

			default:
				throw new ArrayIndexOutOfBoundsException();
		}
		return this;
	}

}
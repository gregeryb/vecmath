package javax.vecmath;

import java.util.Arrays;

/**
 * Jama = Java Matrix class.
 * <P>
 * The Java Matrix Class provides the fundamental operations of numerical linear algebra. Various
 * constructors create Matrices from two dimensional arrays of double precision floating point
 * numbers. Various "gets" and "sets" provide access to submatrices and matrix elements. Several
 * methods implement basic matrix arithmetic, including matrix addition and multiplication, matrix
 * norms, and element-by-element array operations. Methods for reading and printing matrices are
 * also included. All the operations in this version of the Matrix Class involve real matrices.
 * Complex matrices may be handled in a future version.
 * <P>
 * Five fundamental matrix decompositions, which consist of pairs or triples of matrices,
 * permutation vectors, and the like, produce results in five decomposition classes. These
 * decompositions are accessed by the Matrix class to compute solutions of simultaneous linear
 * equations, determinants, inverses and other matrix functions. The five decompositions are:
 * <P>
 * <UL>
 * <LI>Cholesky Decomposition of symmetric, positive definite matrices.
 * <LI>LU Decomposition of rectangular matrices.
 * <LI>QR Decomposition of rectangular matrices.
 * <LI>Singular Value Decomposition of rectangular matrices.
 * <LI>Eigenvalue Decomposition of both symmetric and nonsymmetric square matrices.
 * </UL>
 * <DL>
 * <DT><B>Example of use:</B></DT>
 * <P>
 * <DD>Solve a linear system A x = b and compute the residual norm, ||b - A x||.
 * <P>
 * <
 * PRE>
 * double[][] vals = {{1.,2.,3},{4.,5.,6.},{7.,8.,10.}}; Matrix A = new Matrix(vals); Matrix b =
 * Matrix.random(3,1); Matrix x = A.solve(b); Matrix r = A.times(x).minus(b); double rnorm =
 * r.normInf();
 * </PRE></DD>
 * </DL>
 *
 * @author The MathWorks, Inc. and the National Institute of Standards and Technology.
 * @version 5 August 1998
 */
public class Matrix implements java.io.Serializable {

 static final long serialVersionUID = 1L;
 /*
	 * ------------------------ Class variables ------------------------
  */
 /**
  * Array for internal storage of elements.
  *
  * @serial internal array storage.
  */
 private double[][] A;
 /**
  * Row and column dimensions.
  *
  * @serial row dimension.
  * @serial column dimension.
  */
 private final int m, n;

 /*
	 * ------------------------ Constructors ------------------------
  */
 /**
  * Construct an m-by-n matrix of zeros.
  *
  * @param m Number of rows.
  * @param n Number of colums.
  */
 public Matrix(int m, int n) {
  this.m = m;
  this.n = n;
  A = new double[m][n];
 }

 /**
  * Construct an m-by-n constant matrix.
  *
  * @param m Number of rows.
  * @param n Number of colums.
  * @param s Fill the matrix with this scalar value.
  */
 public Matrix(int m, int n, double s) {
  this.m = m;
  this.n = n;
  A = new double[m][n];
  for (int i = 0; i < m; i++) {
   for (int j = 0; j < n; j++) {
    A[i][j] = s;
   }
  }
 }

 /**
  * Construct a matrix from a 2-D array.
  *
  * @param A Two-dimensional array of doubles.
  * @exception IllegalArgumentException All rows must have the same length
  * @see #constructWithCopy
  */
 public Matrix(double[][] A) {
  m = A.length;
  n = A[0].length;
  for (int i = 0; i < m; i++) {
   if (A[i].length != n) {
    throw new IllegalArgumentException("All rows must have the same length.");
   }
  }
  this.A = new double[A.length][];
  for (int i = 0; i < A.length; ++i) {
   this.A[i] = Arrays.copyOf(A[i], A[i].length);
  }
 }

 /**
  * Construct a matrix quickly without checking arguments.
  *
  * @param A Two-dimensional array of doubles.
  * @param m Number of rows.
  * @param n Number of colums.
  */
 public Matrix(double[][] A, int m, int n) {
  this.A = new double[A.length][];
  for (int i = 0; i < A.length; ++i) {
   this.A[i] = Arrays.copyOf(A[i], A[i].length);
  }
  this.m = m;
  this.n = n;
 }

 /**
  * Construct a matrix from a one-dimensional packed array
  *
  * @param vals One-dimensional array of doubles, packed by columns (ala Fortran).
  * @param m Number of rows.
  * @exception IllegalArgumentException Array length must be a multiple of m.
  */
 public Matrix(double vals[], int m) {
  this.m = m;
  n = (m != 0 ? vals.length / m : 0);
  if (m * n != vals.length) {
   throw new IllegalArgumentException("Array length must be a multiple of m.");
  }
  A = new double[m][n];
  for (int i = 0; i < m; i++) {
   for (int j = 0; j < n; j++) {
    A[i][j] = vals[i + j * m];
   }
  }
 }

 /*
	 * ------------------------ Public Methods ------------------------
  */
 /**
  * Construct a matrix from a copy of a 2-D array.
  *
  * @param A Two-dimensional array of doubles.
  * @return
  * @exception IllegalArgumentException All rows must have the same length
  */
 public static Matrix constructWithCopy(double[][] A) {
  int m = A.length;
  int n = A[0].length;
  Matrix X = new Matrix(m, n);
  double[][] C = X.getArray();
  for (int i = 0; i < m; i++) {
   if (A[i].length != n) {
    throw new IllegalArgumentException("All rows must have the same length.");
   }
   System.arraycopy(A[i], 0, C[i], 0, n);
  }
  return X;
 }

 /**
  * Make a deep copy of a matrix
  *
  * @return
  */
 public Matrix copy() {
  Matrix X = new Matrix(m, n);
  double[][] C = X.getArray();
  for (int i = 0; i < m; i++) {
   System.arraycopy(A[i], 0, C[i], 0, n);
  }
  return X;
 }

 /**
  * Access the internal two-dimensional array.
  *
  * @return Pointer to the two-dimensional array of matrix elements.
  */
 public double[][] getArray() {
  return A;
 }

 /**
  * Copy the internal two-dimensional array.
  *
  * @return Two-dimensional array copy of matrix elements.
  */
 public double[][] getArrayCopy() {
  double[][] C = new double[m][n];
  for (int i = 0; i < m; i++) {
   System.arraycopy(A[i], 0, C[i], 0, n);
  }
  return C;
 }

 /**
  * Make a one-dimensional column packed copy of the internal array.
  *
  * @return Matrix elements packed in a one-dimensional array by columns.
  */
 public double[] getColumnPackedCopy() {
  double[] vals = new double[m * n];
  for (int i = 0; i < m; i++) {
   for (int j = 0; j < n; j++) {
    vals[i + j * m] = A[i][j];
   }
  }
  return vals;
 }

 /**
  * Make a one-dimensional row packed copy of the internal array.
  *
  * @return Matrix elements packed in a one-dimensional array by rows.
  */
 public double[] getRowPackedCopy() {
  double[] vals = new double[m * n];
  for (int i = 0; i < m; i++) {
   System.arraycopy(A[i], 0, vals, i * n, n);
  }
  return vals;
 }

 /**
  * Get row dimension.
  *
  * @return m, the number of rows.
  */
 public int getRowDimension() {
  return m;
 }

 /**
  * Get column dimension.
  *
  * @return n, the number of columns.
  */
 public int getColumnDimension() {
  return n;
 }

 /**
  * Get a single element.
  *
  * @param i Row index.
  * @param j Column index.
  * @return A(i,j)
  * @exception ArrayIndexOutOfBoundsException
  */
 public double get(int i, int j) {
  return A[i][j];
 }

 /**
  * Get a submatrix.
  *
  * @param i0 Initial row index
  * @param i1 Final row index
  * @param j0 Initial column index
  * @param j1 Final column index
  * @return A(i0:i1,j0:j1)
  * @exception ArrayIndexOutOfBoundsException Submatrix indices
  */
 public Matrix getMatrix(int i0, int i1, int j0, int j1) {
  Matrix X = new Matrix(i1 - i0 + 1, j1 - j0 + 1);
  double[][] B = X.getArray();
  try {
   for (int i = i0; i <= i1; i++) {
    for (int j = j0; j <= j1; j++) {
     B[i - i0][j - j0] = A[i][j];
    }
   }
  } catch (ArrayIndexOutOfBoundsException e) {
   throw new ArrayIndexOutOfBoundsException("Submatrix indices");
  }
  return X;
 }

 /**
  * Get a submatrix.
  *
  * @param r Array of row indices.
  * @param c Array of column indices.
  * @return A(r(:),c(:))
  * @exception ArrayIndexOutOfBoundsException Submatrix indices
  */
 public Matrix getMatrix(int[] r, int[] c) {
  Matrix X = new Matrix(r.length, c.length);
  double[][] B = X.getArray();
  try {
   for (int i = 0; i < r.length; i++) {
    for (int j = 0; j < c.length; j++) {
     B[i][j] = A[r[i]][c[j]];
    }
   }
  } catch (ArrayIndexOutOfBoundsException e) {
   throw new ArrayIndexOutOfBoundsException("Submatrix indices");
  }
  return X;
 }

 /**
  * Get a submatrix.
  *
  * @param i0 Initial row index
  * @param i1 Final row index
  * @param c Array of column indices.
  * @return A(i0:i1,c(:))
  * @exception ArrayIndexOutOfBoundsException Submatrix indices
  */
 public Matrix getMatrix(int i0, int i1, int[] c) {
  Matrix X = new Matrix(i1 - i0 + 1, c.length);
  double[][] B = X.getArray();
  try {
   for (int i = i0; i <= i1; i++) {
    for (int j = 0; j < c.length; j++) {
     B[i - i0][j] = A[i][c[j]];
    }
   }
  } catch (ArrayIndexOutOfBoundsException e) {
   throw new ArrayIndexOutOfBoundsException("Submatrix indices");
  }
  return X;
 }

 /**
  * Get a submatrix.
  *
  * @param r Array of row indices.
  * @param j0 Initial column index
  * @param j1 Final column index
  * @return A(r(:),j0:j1)
  * @exception ArrayIndexOutOfBoundsException Submatrix indices
  */
 public Matrix getMatrix(int[] r, int j0, int j1) {
  Matrix X = new Matrix(r.length, j1 - j0 + 1);
  double[][] B = X.getArray();
  try {
   for (int i = 0; i < r.length; i++) {
    for (int j = j0; j <= j1; j++) {
     B[i][j - j0] = A[r[i]][j];
    }
   }
  } catch (ArrayIndexOutOfBoundsException e) {
   throw new ArrayIndexOutOfBoundsException("Submatrix indices");
  }
  return X;
 }

 /**
  * Set a single element.
  *
  * @param i Row index.
  * @param j Column index.
  * @param s A(i,j).
  * @exception ArrayIndexOutOfBoundsException
  */
 public void set(int i, int j, double s) {
  A[i][j] = s;
 }

 /**
  * Set a submatrix.
  *
  * @param i0 Initial row index
  * @param i1 Final row index
  * @param j0 Initial column index
  * @param j1 Final column index
  * @param X A(i0:i1,j0:j1)
  * @exception ArrayIndexOutOfBoundsException Submatrix indices
  */
 public void setMatrix(int i0, int i1, int j0, int j1, Matrix X) {
  try {
   for (int i = i0; i <= i1; i++) {
    for (int j = j0; j <= j1; j++) {
     A[i][j] = X.get(i - i0, j - j0);
    }
   }
  } catch (ArrayIndexOutOfBoundsException e) {
   throw new ArrayIndexOutOfBoundsException("Submatrix indices");
  }
 }

 /**
  * Set a submatrix.
  *
  * @param r Array of row indices.
  * @param c Array of column indices.
  * @param X A(r(:),c(:))
  * @exception ArrayIndexOutOfBoundsException Submatrix indices
  */
 public void setMatrix(int[] r, int[] c, Matrix X) {
  try {
   for (int i = 0; i < r.length; i++) {
    for (int j = 0; j < c.length; j++) {
     A[r[i]][c[j]] = X.get(i, j);
    }
   }
  } catch (ArrayIndexOutOfBoundsException e) {
   throw new ArrayIndexOutOfBoundsException("Submatrix indices");
  }
 }

 /**
  * Set a submatrix.
  *
  * @param r Array of row indices.
  * @param j0 Initial column index
  * @param j1 Final column index
  * @param X A(r(:),j0:j1)
  * @exception ArrayIndexOutOfBoundsException Submatrix indices
  */
 public void setMatrix(int[] r, int j0, int j1, Matrix X) {
  try {
   for (int i = 0; i < r.length; i++) {
    for (int j = j0; j <= j1; j++) {
     A[r[i]][j] = X.get(i, j - j0);
    }
   }
  } catch (ArrayIndexOutOfBoundsException e) {
   throw new ArrayIndexOutOfBoundsException("Submatrix indices");
  }
 }

 /**
  * Set a submatrix.
  *
  * @param i0 Initial row index
  * @param i1 Final row index
  * @param c Array of column indices.
  * @param X A(i0:i1,c(:))
  * @exception ArrayIndexOutOfBoundsException Submatrix indices
  */
 public void setMatrix(int i0, int i1, int[] c, Matrix X) {
  try {
   for (int i = i0; i <= i1; i++) {
    for (int j = 0; j < c.length; j++) {
     A[i][c[j]] = X.get(i - i0, j);
    }
   }
  } catch (ArrayIndexOutOfBoundsException e) {
   throw new ArrayIndexOutOfBoundsException("Submatrix indices");
  }
 }

 /**
  * Matrix transpose.
  *
  * @return A'
  */
 public Matrix transpose() {
  Matrix X = new Matrix(n, m);
  double[][] C = X.getArray();
  for (int i = 0; i < m; i++) {
   for (int j = 0; j < n; j++) {
    C[j][i] = A[i][j];
   }
  }
  return X;
 }

 /**
  * C = A + B
  *
  * @param B another matrix
  * @return A + B
  */
 public Matrix plus(Matrix B) {
  checkMatrixDimensions(B);
  Matrix X = new Matrix(m, n);
  double[][] C = X.getArray();
  for (int i = 0; i < m; i++) {
   for (int j = 0; j < n; j++) {
    C[i][j] = A[i][j] + B.A[i][j];
   }
  }
  return X;
 }

 /**
  * A = A + B
  *
  * @param B another matrix
  * @return A + B
  */
 public Matrix plusEquals(Matrix B) {
  checkMatrixDimensions(B);
  for (int i = 0; i < m; i++) {
   for (int j = 0; j < n; j++) {
    A[i][j] = A[i][j] + B.A[i][j];
   }
  }
  return this;
 }

 /**
  * C = A - B
  *
  * @param B another matrix
  * @return A - B
  */
 public Matrix minus(Matrix B) {
  checkMatrixDimensions(B);
  Matrix X = new Matrix(m, n);
  double[][] C = X.getArray();
  for (int i = 0; i < m; i++) {
   for (int j = 0; j < n; j++) {
    C[i][j] = A[i][j] - B.A[i][j];
   }
  }
  return X;
 }

 /**
  * A = A - B
  *
  * @param B another matrix
  * @return A - B
  */
 public Matrix minusEquals(Matrix B) {
  checkMatrixDimensions(B);
  for (int i = 0; i < m; i++) {
   for (int j = 0; j < n; j++) {
    A[i][j] = A[i][j] - B.A[i][j];
   }
  }
  return this;
 }

 /**
  * Element-by-element multiplication, C = A.*B
  *
  * @param B another matrix
  * @return A.*B
  */
 public Matrix arrayTimes(Matrix B) {
  checkMatrixDimensions(B);
  Matrix X = new Matrix(m, n);
  double[][] C = X.getArray();
  for (int i = 0; i < m; i++) {
   for (int j = 0; j < n; j++) {
    C[i][j] = A[i][j] * B.A[i][j];
   }
  }
  return X;
 }

 /**
  * Element-by-element multiplication in place, A = A.*B
  *
  * @param B another matrix
  * @return A.*B
  */
 public Matrix arrayTimesEquals(Matrix B) {
  checkMatrixDimensions(B);
  for (int i = 0; i < m; i++) {
   for (int j = 0; j < n; j++) {
    A[i][j] = A[i][j] * B.A[i][j];
   }
  }
  return this;
 }

 /**
  * Element-by-element right division, C = A./B
  *
  * @param B another matrix
  * @return A./B
  */
 public Matrix arrayRightDivide(Matrix B) {
  checkMatrixDimensions(B);
  Matrix X = new Matrix(m, n);
  double[][] C = X.getArray();
  for (int i = 0; i < m; i++) {
   for (int j = 0; j < n; j++) {
    C[i][j] = A[i][j] / B.A[i][j];
   }
  }
  return X;
 }

 /**
  * Multiply a matrix by a scalar, C = s*A
  *
  * @param s scalar
  * @return s*A
  */
 public Matrix times(double s) {
  Matrix X = new Matrix(m, n);
  double[][] C = X.getArray();
  for (int i = 0; i < m; i++) {
   for (int j = 0; j < n; j++) {
    C[i][j] = s * A[i][j];
   }
  }
  return X;
 }

 /**
  * Multiply a matrix by a scalar in place, A = s*A
  *
  * @param s scalar
  * @return replace A by s*A
  */
 public Matrix timesEquals(double s) {
  for (int i = 0; i < m; i++) {
   for (int j = 0; j < n; j++) {
    A[i][j] = s * A[i][j];
   }
  }
  return this;
 }

 /**
  * Linear algebraic matrix multiplication, A * B
  *
  * @param B another matrix
  * @return Matrix product, A * B
  * @exception IllegalArgumentException Matrix inner dimensions must agree.
  */
 public Matrix times(Matrix B) {
  if (B.m != n) {
   throw new IllegalArgumentException("Matrix inner dimensions must agree.");
  }
  Matrix X = new Matrix(m, B.n);
  double[][] C = X.getArray();
  double[] Bcolj = new double[n];
  for (int j = 0; j < B.n; j++) {
   for (int k = 0; k < n; k++) {
    Bcolj[k] = B.A[k][j];
   }
   for (int i = 0; i < m; i++) {
    double[] Arowi = A[i];
    double s = 0;
    for (int k = 0; k < n; k++) {
     s += Arowi[k] * Bcolj[k];
    }
    C[i][j] = s;
   }
  }
  return X;
 }

 /**
  *
  * @return
  */
 public SingularValueDecomposition svd() {
  return new SingularValueDecomposition(this);
 }

 /**
  *
  * @return
  */
 public int rank() {
  return new SingularValueDecomposition(this).rank();
 }

 /**
  * Matrix condition (2 norm)
  *
  * @return ratio of largest to smallest singular value.
  */
 public double cond() {
  return new SingularValueDecomposition(this).cond();
 }

 /**
  * Matrix trace.
  *
  * @return sum of the diagonal elements.
  */
 public double trace() {
  double t = 0;
  for (int i = 0; i < Math.min(m, n); i++) {
   t += A[i][i];
  }
  return t;
 }

 /**
  * Generate matrix with random elements
  *
  * @param m Number of rows.
  * @param n Number of colums.
  * @return An m-by-n matrix with uniformly distributed random elements.
  */
 public static Matrix random(int m, int n) {
  Matrix A = new Matrix(m, n);
  double[][] X = A.getArray();
  for (int i = 0; i < m; i++) {
   for (int j = 0; j < n; j++) {
    X[i][j] = Math.random();
   }
  }
  return A;
 }

 /**
  * Generate identity matrix
  *
  * @param m Number of rows.
  * @param n Number of colums.
  * @return An m-by-n matrix with ones on the diagonal and zeros elsewhere.
  */
 public static Matrix identity(int m, int n) {
  Matrix A = new Matrix(m, n);
  double[][] X = A.getArray();
  for (int i = 0; i < m; i++) {
   for (int j = 0; j < n; j++) {
    X[i][j] = (i == j ? 1.0 : 0.0);
   }
  }
  return A;
 }
 
 /*
	 * ------------------------ Private Methods ------------------------
  */
 /**
  * Check if size(A) == size(B) *
  */
 private void checkMatrixDimensions(Matrix B) {
  if (B.m != m || B.n != n) {
   throw new IllegalArgumentException("Matrix dimensions must agree.");
  }
 }
}

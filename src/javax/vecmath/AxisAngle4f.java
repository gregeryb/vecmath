/*
 * $RCSfile: AxisAngle4f.java,v $
 *
 * Copyright 1997-2008 Sun Microsystems, Inc.  All Rights Reserved.
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

import static javax.vecmath.VecMath.atan2;
import static javax.vecmath.VecMath.sqrt;

/**
 * A four-element axis angle represented by single-precision floating point x,y,z,angle components.
 * An axis angle is a rotation of angle (radians) about the vector (x,y,z).
 *
 */
public class AxisAngle4f implements java.io.Serializable  {

 // Compatible with 1.1
 static final long serialVersionUID = -163246355858070601L;
 /**
  * The x coordinate.
  */
 public float x;
 /**
  * The y coordinate.
  */
 public float y;
 /**
  * The z coordinate.
  */
 public float z;
 /**
  * The angle of rotation in radians.
  */
 public float angle;
 final static float EPS = 0.0001f;

 /**
  * Constructs and initializes a AxisAngle4f from the specified xyzw coordinates.
  *
  * @param x the x coordinate
  * @param y the y coordinate
  * @param z the z coordinate
  * @param angle the angle of rotation in radians
  */
 public AxisAngle4f(float x, float y, float z, float angle) {
  this.x = x;
  this.y = y;
  this.z = z;
  this.angle = angle;
 }

 /**
  * Constructs and initializes an AxisAngle4f from the array of length 4.
  *
  * @param a the array of length 4 containing x,y,z,angle in order
  */
 public AxisAngle4f(float[] a) {
  this.x = a[0];
  this.y = a[1];
  this.z = a[2];
  this.angle = a[3];
 }

 /**
  * Constructs and initializes an AxisAngle4f from the specified AxisAngle4f.
  *
  * @param a1 the AxisAngle4f containing the initialization x y z angle data
  */
 public AxisAngle4f(AxisAngle4f a1) {
  this.x = a1.x;
  this.y = a1.y;
  this.z = a1.z;
  this.angle = a1.angle;
 }

 /**
  * Constructs and initializes an AxisAngle4f from the specified axis and angle.
  *
  * @param axis the axis
  * @param angle the angle of rotation in radians
  *
  * @since vecmath 1.2
  */
 public AxisAngle4f(Tuple3f axis, float angle) {
  this.x = axis.x;
  this.y = axis.y;
  this.z = axis.z;
  this.angle = angle;
 }

 /**
  * Constructs and initializes an AxisAngle4f to (0,0,1,0).
  */
 public AxisAngle4f() {
  this.x = 0.0f;
  this.y = 0.0f;
  this.z = 1.0f;
  this.angle = 0.0f;
 }

 /**
  * Sets the value of this axis-angle to the specified x,y,z,angle.
  *
  * @param x the x coordinate
  * @param y the y coordinate
  * @param z the z coordinate
  * @param angle the angle of rotation in radians
  * @return this for chaining
  */
 public AxisAngle4f set(float x, float y, float z, float angle) {
  this.x = x;
  this.y = y;
  this.z = z;
  this.angle = angle;
  return this;
 }

 /**
  * Sets the value of this axis-angle to the specified values in the array of length 4.
  *
  * @param a the array of length 4 containing x,y,z,angle in order
  * @return this for chaining
  */
 public AxisAngle4f set(float[] a) {
  this.x = a[0];
  this.y = a[1];
  this.z = a[2];
  this.angle = a[3];
  return this;
 }

 /**
  * Sets the value of this axis-angle to the value of axis-angle a1.
  *
  * @param a1 the axis-angle to be copied
  * @return this for chaining
  */
 public AxisAngle4f set(AxisAngle4f a1) {
  this.x = a1.x;
  this.y = a1.y;
  this.z = a1.z;
  this.angle = a1.angle;
  return this;
 }

 /**
  * Sets the value of this AxisAngle4f to the specified axis and angle.
  *
  * @param axis the axis
  * @param angle the angle of rotation in radians
  * @return this for chaining
  *
  * @since vecmath 1.2
  */
 public AxisAngle4f set(Tuple3f axis, float angle) {
  this.x = axis.x;
  this.y = axis.y;
  this.z = axis.z;
  this.angle = angle;
  return this;
 }

 /**
  * Copies the value of this axis-angle into the array a.
  *
  * @param a the array
  * @return a for chaining
  */
 public float[] get(float[] a) {
  a[0] = this.x;
  a[1] = this.y;
  a[2] = this.z;
  a[3] = this.angle;
  return a;
 }

 /**
  * Sets the value of this axis-angle to the rotational equivalent of the passed quaternion. If the
  * specified quaternion has no rotational component, the value of this AxisAngle4f is set to an
  * angle of 0 about an axis of (0,1,0).
  *
  * @param q1 the Quat4f
  * @return this for chaining
  */
 public AxisAngle4f set(Quat4f q1) {
  float mag = q1.x * q1.x + q1.y * q1.y + q1.z * q1.z;
  mag = sqrt(mag);
  float invMag = 1.0f / mag;
  x = (q1.x * invMag);
  y = (q1.y * invMag);
  z = (q1.z * invMag);
  angle = (2.0f * atan2(mag, q1.w));
  return this;
 }

 /**
  * Sets the value of this axis-angle to the rotational component of the passed matrix. If the
  * specified matrix has no rotational component, the value of this AxisAngle4f is set to an angle
  * of 0 about an axis of (0,1,0).
  *
  * @param m1 the matrix4f
  * @return this for chaining
  */
 public AxisAngle4f set(Matrix4f m1) {
  Matrix3f m3f = new Matrix3f();
  m1.get(m3f);
  x = m3f.m21 - m3f.m12;
  y = m3f.m02 - m3f.m20;
  z = m3f.m10 - m3f.m01;
  float mag = lengthSquared(x, y, z);
  if (mag > EPS) {
   mag = sqrt(mag);
   float sin = 0.5f * mag;
   float cos = 0.5f * (m3f.m00 + m3f.m11 + m3f.m22 - 1.0f);
   angle = atan2(sin, cos);
   float invMag = 1.0f / mag;
   x = (x * invMag);
   y = (y * invMag);
   z = (z * invMag);
  } else {
   x = 0.0f;
   y = 1.0f;
   z = 0.0f;
   angle = 0.0f;
  }
  return this;
 }

 /**
  * Sets the value of this axis-angle to the rotational component of the passed matrix. If the
  * specified matrix has no rotational component, the value of this AxisAngle4f is set to an angle
  * of 0 about an axis of (0,1,0).
  *
  * @param m1 the matrix3f
  * @return this for chaining
  */
 public AxisAngle4f set(Matrix3f m1) {
  x = (m1.m21 - m1.m12);
  y = (m1.m02 - m1.m20);
  z = (m1.m10 - m1.m01);
  float mag = lengthSquared(x, y, z);
  if (mag > EPS) {
   mag = sqrt(mag);
   float sin = 0.5f * mag;
   float cos = 0.5f * (m1.m00 + m1.m11 + m1.m22 - 1.0f);
   angle = atan2(sin, cos);
   float invMag = 1.0f / mag;
   x = (x * invMag);
   y = (y * invMag);
   z = (z * invMag);
  } else {
   x = 0.0f;
   y = 1.0f;
   z = 0.0f;
   angle = 0.0f;
  }
  return this;
 }

 /**
  * Returns a string that contains the values of this AxisAngle4f. The form is (x,y,z,angle).
  *
  * @return the String representation
  */
 @Override
 public String toString() {
  return "(" + this.x + ", " + this.y + ", " + this.z + ", " + this.angle + ")";
 }

 /**
  * Returns true if all of the data members of AxisAngle4f a1 are equal to the corresponding data
  * members in this AxisAngle4f.
  *
  * @param a1 the axis-angle with which the comparison is made
  * @return true or false
  */
 public boolean equals(AxisAngle4f a1) {
  try {
   return (this.x == a1.x && this.y == a1.y && this.z == a1.z &&
     this.angle == a1.angle);
  } catch (NullPointerException e2) {
   return false;
  }
 }

 /**
  * Returns true if the Object o1 is of type AxisAngle4f and all of the data members of o1 are equal
  * to the corresponding data members in this AxisAngle4f.
  *
  * @param o1 the object with which the comparison is made
  * @return true or false
  */
 @Override
 public boolean equals(Object o1) {
  try {
   AxisAngle4f a2 = (AxisAngle4f) o1;
   return (this.x == a2.x && this.y == a2.y && this.z == a2.z &&
     this.angle == a2.angle);
  } catch (NullPointerException | ClassCastException e2) {
   return false;
  }
 }

 /**
  * Returns a hash code value based on the data values in this object. Two different AxisAngle4f
  * objects with identical data values (i.e., AxisAngle4f.equals returns true) will return the same
  * hash code value. Two objects with different data members may return the same hash value,
  * although this is not likely.
  *
  * @return the integer hash code value
  */
 @Override
 public int hashCode() {
  int hash = 3;
  hash = 59 * hash + Float.floatToIntBits(this.x);
  hash = 59 * hash + Float.floatToIntBits(this.y);
  hash = 59 * hash + Float.floatToIntBits(this.z);
  hash = 59 * hash + Float.floatToIntBits(this.angle);
  return hash;
 }
 
 /**
  * Get the axis angle, in radians.<br>
  * An axis angle is a rotation angle about the vector (x,y,z).
  *
  * @return Returns the angle, in radians.
  *
  * @since vecmath 1.5
  */
 public float getAngle() {
  return angle;
 }

 /**
  * Set the axis angle, in radians.<br>
  * An axis angle is a rotation angle about the vector (x,y,z).
  *
  * @param angle The angle to set, in radians.
  * @return this for chaining
  *
  * @since vecmath 1.5
  */
 public AxisAngle4f setAngle(float angle) {
  this.angle = angle;
  return this;
 }

 /**
  * Get value of <i>x</i> coordinate.
  *
  * @return the <i>x</i> coordinate.
  *
  * @since vecmath 1.5
  */
 public float getX() {
  return x;
 }

 /**
  * Set a new value for <i>x</i> coordinate.
  *
  * @param x the <i>x</i> coordinate.
  * @return this for chaining
  *
  * @since vecmath 1.5
  */
 public AxisAngle4f setX(float x) {
  this.x = x;
  return this;
 }

 /**
  * Get value of <i>y</i> coordinate.
  *
  * @return the <i>y</i> coordinate
  *
  * @since vecmath 1.5
  */
 public float getY() {
  return y;
 }

 /**
  * Set a new value for <i>y</i> coordinate.
  *
  * @param y the <i>y</i> coordinate.
  * @return this for chaining
  *
  * @since vecmath 1.5
  */
 public AxisAngle4f setY(float y) {
  this.y = y;
  return this;
 }

 /**
  * Get value of <i>z</i> coordinate.
  *
  * @return the <i>z</i> coordinate.
  *
  * @since vecmath 1.5
  */
 public float getZ() {
  return z;
 }

 /**
  * Set a new value for <i>z</i> coordinate.
  *
  * @param z the <i>z</i> coordinate.
  * @return this for chaining
  *
  * @since vecmath 1.5
  */
 public AxisAngle4f setZ(float z) {
  this.z = z;
  return this;
 }

 private static float lengthSquared(float x, float y, float z) {
  return (x * x + y * y + z * z);
 }
}

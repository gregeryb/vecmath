/*
 * $RCSfile: Tuple3b.java,v $
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
 * $Revision: 1.7 $
 * $Date: 2008/02/28 20:18:51 $
 * $State: Exp $
 */
package javax.vecmath;

/**
 * A three byte tuple. Note that Java defines a byte as a signed integer in the range [-128, 127].
 * However, colors are more typically represented by values in the range [0, 255]. Java 3D
 * recognizes this and, in those cases where Tuple3b is used to represent color, treats the bytes as
 * if the range were [0, 255]---in other words, as if the bytes were unsigned. Values greater than
 * 127 can be assigned to a byte variable using a type cast. For example:
 * <ul>byteVariable = (byte) intValue; // intValue can be > 127</ul>
 * If intValue is greater than 127, then byteVariable will be negative. The correct value will be
 * extracted when it is used (by masking off the upper bits).
 *
 * @param <T>
 */
public abstract class Tuple3b<T extends Tuple3b> implements java.io.Serializable {

 static final long serialVersionUID = -483782685323607044L;
 /**
  * The first value.
  */
 public byte x;
 /**
  * The second value.
  */
 public byte y;
 /**
  * The third value.
  */
 public byte z;

 /**
  * Constructs and initializes a Tuple3b from the specified three values.
  *
  * @param b1 the first value
  * @param b2 the second value
  * @param b3 the third value
  */
 public Tuple3b(byte b1, byte b2, byte b3) {
  this.x = b1;
  this.y = b2;
  this.z = b3;
 }

 /**
  * Constructs and initializes a Tuple3b from input array of length 3.
  *
  * @param t the array of length 3 containing b1 b2 b3 in order
  */
 public Tuple3b(byte[] t) {
  this.x = t[0];
  this.y = t[1];
  this.z = t[2];
 }

 /**
  * Constructs and initializes a Tuple3b from the specified Tuple3b.
  *
  * @param t1 the Tuple3b containing the initialization x y z data
  */
 public Tuple3b(Tuple3b t1) {
  this.x = t1.x;
  this.y = t1.y;
  this.z = t1.z;
 }

 /**
  * Constructs and initializes a Tuple3b to (0,0,0).
  */
 public Tuple3b() {
 }

 /**
  * Returns a string that contains the values of this Tuple3b.
  *
  * @return a String with the values
  */
 @Override
 public String toString() {
  return ("(" + ((int) this.x & 0xff) +
    ", " + ((int) this.y & 0xff) +
    ", " + ((int) this.z & 0xff) + ")");
 }

 /**
  * Places the value of the x,y,z components of this Tuple3b into the array of length 3.
  *
  * @param t array of length 3 into which the component values are copied
  * @return t for chaining
  */
 public byte[] get(byte[] t) {
  t[0] = this.x;
  t[1] = this.y;
  t[2] = this.z;
  return t;
 }

 /**
  * Places the value of the x,y,z components of this tuple into the tuple t1.
  *
  * @param <S>
  * @param t1 the tuple into which the values are placed
  * @return t1 for chaining
  */
 public <S extends Tuple3b> S get(S t1) {
  t1.x = this.x;
  t1.y = this.y;
  t1.z = this.z;
  return t1;
 }

 /**
  * Sets the value of the data members of this tuple to the value of the argument tuple t1.
  *
  * @param t1 the source tuple for the memberwise copy
  * @return this for chaining
  */
 public T set(Tuple3b t1) {
  this.x = t1.x;
  this.y = t1.y;
  this.z = t1.z;
  return (T) this;
 }

 /**
  * Sets the value of the x,y,z, data members of this tuple to the values in the array t of length
  * 3.
  *
  * @param t array of length 3 which is the source for the memberwise copy
  * @return this for chaining
  */
 public T set(byte[] t) {
  this.x = t[0];
  this.y = t[1];
  this.z = t[2];
  return (T) this;
 }

 /**
  * Returns true if all of the data members of tuple t1 are equal to the corresponding data members
  * in this tuple.
  *
  * @param t1 the tuple with which the comparison is made
  * @return true or false
  */
 public boolean equals(Tuple3b t1) {
  try {
   return (this.x == t1.x && this.y == t1.y && this.z == t1.z);
  } catch (NullPointerException e2) {
   return false;
  }
 }

 /**
  * Returns true if the Object t1 is of type Tuple3b and all of the data members of t1 are equal to
  * the corresponding data members in this Tuple3b.
  *
  * @param t1 the object with which the comparison is made
  */
 @Override
 public boolean equals(Object t1) {
  try {
   Tuple3b t2 = (Tuple3b) t1;
   return (this.x == t2.x && this.y == t2.y && this.z == t2.z);
  } catch (NullPointerException | ClassCastException e2) {
   return false;
  }
 }

 /**
  * Returns a hash code value based on the data values in this object. Two different Tuple3b objects
  * with identical data values (i.e., Tuple3b.equals returns true) will return the same hash code
  * value. Two objects with different data members may return the same hash value, although this is
  * not likely.
  *
  * @return the integer hash code value
  */
 @Override
 public int hashCode() {
  return ((((int) x & 0xff)) |
    (((int) y & 0xff) << 8) |
    (((int) z & 0xff) << 16));
 }
 
 /**
  * Get <i>x</i>, the first value.
  *
  * @return the first value.
  *
  * @since vecmath 1.5
  */
 public byte getX() {
  return x;
 }

 /**
  * Set <i>x</i>, the first value.
  *
  * @param x the first value to set.
  * @return this for chaining
  *
  * @since vecmath 1.5
  */
 public T setX(byte x) {
  this.x = x;
  return (T) this;
 }

 /**
  * Get <i>y</i>, the second value.
  *
  * @return the second value.
  *
  * @since vecmath 1.5
  */
 public byte getY() {
  return y;
 }

 /**
  * Set <i>y</i>, the second value.
  *
  * @param y the second value to set.
  * @return this for chaining
  *
  * @since vecmath 1.5
  */
 public T setY(byte y) {
  this.y = y;
  return (T) this;
 }

 /**
  * Get <i>z</i>, the third value.
  *
  * @return the third value.
  *
  * @since vecmath 1.5
  */
 public byte getZ() {
  return z;
 }

 /**
  * Set <i>z</i>, the third value.
  *
  * @param z the third value to set.
  * @return this for chaining
  *
  * @since vecmath 1.5
  */
 public T setZ(byte z) {
  this.z = z;
  return (T) this;
 }

 /**
  * Sets each component of this tuple to its absolute value.
  *
  * @return this for chaining
  */
 public T absolute() {
  abs();
  return (T) this;
 }

 /**
  * Sets each component of the tuple parameter to its absolute value and places the modified values
  * into this tuple.
  *
  * @param t the source tuple, which will not be modified
  * @return this for chaining
  */
 public T absolute(Tuple3b t) {
  abs(t);
  return (T) this;
 }

 /**
  * Sets each component of this tuple to its abs value.
  *
  * @return this for chaining
  */
 public T abs() {
  x = (byte) Math.abs(x);
  y = (byte) Math.abs(y);
  z = (byte) Math.abs(z);
  return (T) this;
 }

 /**
  * Sets each component of the tuple parameter to its abs value and places the modified values into
  * this tuple.
  *
  * @param t the source tuple, which will not be modified
  * @return this for chaining
  */
 public T abs(Tuple3b t) {
  x = (byte) Math.abs(t.x);
  y = (byte) Math.abs(t.y);
  z = (byte) Math.abs(t.z);
  return (T) this;
 }
}

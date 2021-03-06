/*
  * Copyright (c) 2017  Gregery Barton
  * 
  * This software is provided 'as-is', without any express or implied warranty.
 * In no event will the authors be held liable for any damages arising from the use of this software.
 * Permission is granted to anyone to use this software for any purpose, 
 * including commercial applications, and to alter it and redistribute it freely, 
 * subject to the following restrictions:
 * 
 * 1. The origin of this software must not be misrepresented; you must not claim that you wrote the original software. If you use this software in a product, an acknowledgment in the product documentation would be appreciated but is not required.
 * 2. Altered source versions must be plainly marked as such, and must not be misrepresented as being the original software.
 * 3. This notice may not be removed or altered from any source distribution.
 */
package javax.vecmath;

/**
 *
 * @author Gregery Barton
 */
public class VecMath {
 
 /**
  *
  */
 public static final float PI = (float) Math.PI;

 /**
  *
  * @param x
  * @return
  */
 public static float sin(float x) {
  return (float) Math.sin(x);
 }

 public static float asin(float x) {
  return (float) Math.asin(x);
 }

 /**
  *
  * @param x
  * @return
  */
 public static float cos(float x) {
  return (float) Math.cos(x);
 }

 /**
  *
  * @param x
  * @return
  */
 public static float tan(float x) {
  return (float) Math.tan(x);
 }

 /**
  *
  * @param x
  * @return
  */
 public static float atan(float x) {
  return (float) Math.atan(x);
 }

 /**
  *
  * @param x
  * @param y
  * @return
  */
 public static float atan2(float x, float y) {
  return (float) Math.atan2(x, y);
 }

 /**
  *
  * @param x
  * @return
  */
 public static float sqrt(float x) {
  return (float) Math.sqrt(x);
 }

 /**
  *
  * @param x
  * @return
  */
 public static float acos(float x) {
  return (float) Math.acos(x);
 }

 /**
  *
  * @param x
  * @return
  */
 public static double sin(double x) {
  return (double) Math.sin(x);
 }

 public static double asin(double x) {
  return (double) Math.asin(x);
 }

 /**
  *
  * @param x
  * @return
  */
 public static double cos(double x) {
  return (double) Math.cos(x);
 }

 /**
  *
  * @param x
  * @return
  */
 public static double tan(double x) {
  return (double) Math.tan(x);
 }

 /**
  *
  * @param x
  * @return
  */
 public static double atan(double x) {
  return (double) Math.atan(x);
 }

 /**
  *
  * @param x
  * @param y
  * @return
  */
 public static double atan2(double x, double y) {
  return (double) Math.atan2(x, y);
 }

 /**
  *
  * @param x
  * @return
  */
 public static double sqrt(double x) {
  return (double) Math.sqrt(x);
 }

 /**
  *
  * @param x
  * @return
  */
 public static double acos(double x) {
  return (double) Math.acos(x);
 }

 public static float pow(float x, float y) {
  return (float) Math.pow(x, y);
 }

 public static double pow(double x, double y) {
  return (double) Math.pow(x, y);
 }

 public static boolean different_epsilon(float a, float b, float epsilon) {
  float diff = a - b;
  if (Float.isNaN(diff)) {
   return false;
  }
  return Math.abs(diff) > epsilon;
 }

 public static boolean is_good_matrix(Matrix4f m) {
  if (Math.abs(m.determinant()) < 0.001f) {
   return false;
  }
  for (int r = 0; r < 4; ++r) {
   for (int c = 0; c < 4; ++c) {
    if (!Float.isFinite(m.getElement(r, c))) {
     return false;
    }
   }
  }
  return true;
 }

 public static boolean is_good_matrix(Matrix3f m) {
  if (Math.abs(m.determinant()) < 0.00001f) {
   return false;
  }
  for (int r = 0; r < 3; ++r) {
   for (int c = 0; c < 3; ++c) {
    if (!Float.isFinite(m.getElement(r, c))) {
     return false;
    }
   }
  }
  return true;
 }

 public static boolean zero_denormals(Matrix4f m, float epsilon) {
  boolean zeroed = false;
  for (int r = 0; r < 4; ++r) {
   for (int c = 0; c < 4; ++c) {
    float e = Math.abs(m.getElement(r, c));
    if (e > 0 && e < epsilon) {
     m.setElement(r, c, 0);
     zeroed = true;
    }
   }
  }
  return zeroed;
 }

 public static boolean zero_denormals(Matrix3f m, float epsilon) {
  boolean zeroed = false;
  for (int r = 0; r < 3; ++r) {
   for (int c = 0; c < 3; ++c) {
    float e = Math.abs(m.getElement(r, c));
    if (e > 0 && e < epsilon) {
     m.setElement(r, c, 0);
     zeroed = true;
    }
   }
  }
  return zeroed;
 }

 public static boolean zero_denormals(Tuple3f m, float epsilon) {
  boolean zeroed = false;
  for (int r = 0; r < 3; ++r) {
   float e = Math.abs(m.getElement(r));
   if (e > 0 && e < epsilon) {
    m.setElement(r, 0);
    zeroed = true;
   }
  }
  return zeroed;
 }

 public static boolean zero_denormals(Tuple4f m, float epsilon) {
  boolean zeroed = false;
  for (int r = 0; r < 4; ++r) {
   float e = Math.abs(m.getElement(r));
   if (e > 0 && e < epsilon) {
    m.setElement(r, 0);
    zeroed = true;
   }
  }
  return zeroed;
 }

 public static boolean epsilon_equals(float a, float b, float epsilon) {
  float diff = Math.abs(a - b);
  return diff <= epsilon;
 }
}

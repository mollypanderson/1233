import java.util.Arrays;


/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Molly Anderson (MPA0012@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  2019-01-15
*
*/
public final class Selector {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { }


   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int min(int[] a) {
      if (a.length == 0) {
         throw new IllegalArgumentException("array has length of 0");
      }
      
      if (a == null) {
         throw new IllegalArgumentException("array is null");
      }
      
      
      int minimum = a[0];
      
      for (int i = 1; i < a.length; i++) {
         
         if (a[i] < minimum) {
            minimum = a[i];
         }
         
      }
      
      return minimum;
   }


   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int max(int[] a) {
      if (a.length == 0) {
         throw new IllegalArgumentException("array has length of 0");
      }
      
      if (a == null) {
         throw new IllegalArgumentException("array is null");
      }
      
      int maximum = a[0];
      
      for (int i = 1; i < a.length; i++) {
         
         if (a[i] > maximum) {
            maximum = a[i];
         }
      }
      
      return maximum;
   }


   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmin(int[] a, int k) {
      return -99;
   }


   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmax(int[] a, int k) {
      return -99;
   }


   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    */
   public static int[] range(int[] a, int low, int high) {
      if (a.length == 0) {
         throw new IllegalArgumentException("array has length of 0");
      }
      
      if (a == null) {
         throw new IllegalArgumentException("array is null");
      }
      
      
      int inc = 0;
   
      for (int i = 0; i < a.length; i++) {
         if ((a[i] >= low) && (a[i] <= high)) {
            inc++;
         }
      }
      int[] rangeList = new int[inc];
      int j = 0;
      for (int k = 0; k < rangeList.length + 1; k++) {
         
         if ((a[k] >= low) && (a[k] <= high)) {
            rangeList[j] = a[k];
            j++;
         }
      }
      
      
      
      return rangeList;
   }


   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int ceiling(int[] a, int key) {
      return -99;
   }


   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int floor(int[] a, int key) {
      return -99;
   }

}

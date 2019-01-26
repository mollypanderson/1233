import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Defines a library of selection methods on Collections.
 *
 * @author  Molly Anderson (MPA0012@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2019-01-24
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
    * Returns the minimum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the minimum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
    
            
    
   public static <T> T min(Collection<T> coll, Comparator<T> comp) {
      
      if (coll == null) {
         throw new IllegalArgumentException("array is null");
      }
      
      if (comp == null) {
         throw new IllegalArgumentException("array is null");
      }
   
      
      if (coll.size() == 0) {
         throw new NoSuchElementException("array has length of 0");
      }
      
               
      T minimum = null;
      
      for (T element : coll) {
         if (minimum == null) {
            minimum = element;
         }
         
         if (comp.compare(element, minimum) < 0) {
            minimum = element;
         } 
                     
                     
      }
      
      return minimum;
   }


   /**
    * Selects the maximum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the maximum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T max(Collection<T> coll, Comparator<T> comp) {
      if (coll == null) {
         throw new IllegalArgumentException("array is null");
      }
      
      if (comp == null) {
         throw new IllegalArgumentException("array is null");
      }
   
      
      if (coll.size() == 0) {
         throw new NoSuchElementException("array has length of 0");
      }
      
      T maximum = null;
      
      for (T element : coll) {
         if (maximum == null) {
            maximum = element;
         }
         
         if (comp.compare(element, maximum) > 0) {
            maximum = element;
         }
      }
      
      return maximum;
   
   }


   /**
    * Selects the kth minimum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth minimum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth minimum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) {
      
      // collection is null, illegalargumentexception
      if (coll == null) {
         throw new IllegalArgumentException("collection is null");
      }
      
      // comparator is null, illegalargumentexception
      if (comp == null) {
         throw new IllegalArgumentException("Comparator is null");
      }
      
      // collection is empty, nosuchelementexception
      if (coll.size() == 0) {
         throw new NoSuchElementException("collection is empty");
      }
      
      // no kth min value (k < 1, k > coll.size(), k > distinct values in coll), nosuchelementexception
      if (k < 1) {
         throw new NoSuchElementException("no kth value: k is less than 1");
      }
      
      if (k > coll.size()) {
         throw new NoSuchElementException("no kth value: k is less the number of" 
                              + " values in the collection");
      }
      
      
      
      // make a copy of the collection as an ArrayList
      ArrayList<T> kminList = new ArrayList<T>();
      
      for (T element : coll) {
         kminList.add(element);
            
      }
   
      
      // sort the array into whatever order, using comp as the param
      java.util.Collections.sort(kminList, comp);
      
      
      // create a new array with only distinct values
      ArrayList<T> uniqueList = new ArrayList<T>();
      
      if ((k == 1) && (kminList.size() == 1)) {
         return kminList.get(0);
      }
      
      uniqueList.add(kminList.get(0));
      
      for (int i = 1; i < kminList.size() - 1; i++) {
         if (i == 1) {
            if ((!(comp.compare(kminList.get(0), kminList.get(1)) == 0)) 
               && (!(comp.compare(kminList.get(1), kminList.get(2)) == 0))) {
               uniqueList.add(kminList.get(1));
            }
                        
         
         } 
         else if (!(comp.compare(kminList.get(i - 1), kminList.get(i)) == 0)) {
            uniqueList.add(kminList.get(i));
         
         }
         
         
      }
      
      // if the last two values are unique, add the last value to uniqueList
      if (!(comp.compare(kminList.get(kminList.size() - 2), kminList.get(kminList.size() - 1)) == 0 )) {
         uniqueList.add(kminList.get(kminList.size() - 1));
      }
      
     
      
      if (k > uniqueList.size()) {
         throw new NoSuchElementException("no kth value: k is greater than" 
                            + " the number of distinct values");
      }
      
      // save kminimum value
      T kminimum = uniqueList.get(k - 1);
      
      
      return kminimum;
   }


   /**
    * Selects the kth maximum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth maximum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth maximum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) {
         // collection is null, illegalargumentexception
      if (coll == null) {
         throw new IllegalArgumentException("collection is null");
      }
      
      // comparator is null, illegalargumentexception
      if (comp == null) {
         throw new IllegalArgumentException("Comparator is null");
      }
      
      // collection is empty, nosuchelementexception
      if (coll.size() == 0) {
         throw new NoSuchElementException("collection is empty");
      }
      
      // no kth max value (k < 1, k > coll.size(), k > distinct values in coll), nosuchelementexception
      if (k < 1) {
         throw new NoSuchElementException("no kth value: k is less than 1");
      }
      
      if (k > coll.size()) {
         throw new NoSuchElementException("no kth value: k is less the number of" 
                              + " values in the collection");
      }
      
      
      
      // make a copy of the collection as an ArrayList
      ArrayList<T> kmaxList = new ArrayList<T>();
      
      for (T element : coll) {
         kmaxList.add(element);
            
      }
   
      
      // sort the array into whatever order, using comp as the param
      java.util.Collections.sort(kmaxList, comp);
      
      
      // create a new array with only distinct values
      ArrayList<T> uniqueList = new ArrayList<T>();
      
      if ((k == 1) && (kmaxList.size() == 1)) {
         return kmaxList.get(0);
      }
      
      uniqueList.add(kmaxList.get(0));
      
      for (int i = 1; i < kmaxList.size() - 1; i++) {
         if (i == 1) {
            if ((!(comp.compare(kmaxList.get(0), kmaxList.get(1)) == 0)) 
               && (!(comp.compare(kmaxList.get(1), kmaxList.get(2)) == 0))) {
               uniqueList.add(kmaxList.get(1));
            }
                        
         
         } 
         else if (!(comp.compare(kmaxList.get(i - 1), kmaxList.get(i)) == 0)) {
            uniqueList.add(kmaxList.get(i));
         
         }
         
         
      }
      
      // if the last two values are unique, add the last value to uniqueList
      if (!(comp.compare(kmaxList.get(kmaxList.size() - 2), kmaxList.get(kmaxList.size() - 1)) == 0 )) {
         uniqueList.add(kmaxList.get(kmaxList.size() - 1));
      }
      
     
      
      if (k > uniqueList.size()) {
         throw new NoSuchElementException("no kth value: k is greater than" 
                            + " the number of distinct values");
      }
      
      // save kmaximum value
      T kmaximum = uniqueList.get(uniqueList.size() - k);
      
      
      return kmaximum;
   }


   


   /**
    * Returns a new Collection containing all the values in the Collection coll
    * that are greater than or equal to low and less than or equal to high, as
    * defined by the Comparator comp. The returned collection must contain only
    * these values and no others. The values low and high themselves do not have
    * to be in coll. Any duplicate values that are in coll must also be in the
    * returned Collection. If no values in coll fall into the specified range or
    * if coll is empty, this method throws a NoSuchElementException. If either
    * coll or comp is null, this method throws an IllegalArgumentException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the range values are selected
    * @param low     the lower bound of the range
    * @param high    the upper bound of the range
    * @param comp    the Comparator that defines the total order on T
    * @return        a Collection of values between low and high
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> Collection<T> range(Collection<T> coll, T low, T high,
                                         Comparator<T> comp) {
      if (coll == null) {
         throw new IllegalArgumentException("array is null");
      }
      
      // comparator is null
      if (comp == null) {
         throw new NoSuchElementException("array has length of 0");
      }
      
      
      // create a new ArrayList to copy into
      ArrayList<T> rangeList = new ArrayList<T>();
      
      
      // for each element int he original array, check if the
      // element is within the range
      
      for (T element : coll) {
         if ((comp.compare(element, low) >= 0) && (comp.compare(element, high) <= 0)) {
            // add the value to rangeList
            rangeList.add(element);
            
         }
      }
      
      // no qualifying values for range
      if (rangeList.size() == 0) {
         throw new NoSuchElementException("array has length of 0");
      
      }
      
      return rangeList;
   }


   /**
    * Returns the smallest value in the Collection coll that is greater than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the ceiling value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the ceiling value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) {
      
      
      
      if (coll == null) {
         throw new IllegalArgumentException("array is null");
      }
      
      if (comp == null) {
         throw new IllegalArgumentException("array is null");
      }
   
      
      if (coll.size() == 0) {
         throw new NoSuchElementException("array has length of 0");
      }
      
      // search the collection looking for the c value
      
      T c = null;
      for (T element : coll) {
         if (comp.compare(element, key) >= 0) {
            c = element;
            break;
         }
      }
      
      for (T element : coll) {
         
         if ((comp.compare(element, key) >= 0) && (comp.compare(element, c) < 0)) {
            c = element;
         }
      }
      
      
      // if no ceiling is found
      if (c == null) {
         throw new NoSuchElementException("array has length of 0");
      }
   
   
      
      return c;
   }


   /**
    * Returns the largest value in the Collection coll that is less than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the floor value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the floor value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) {
      
      if (coll == null) {
         throw new IllegalArgumentException("array is null");
      }
      
      if (comp == null) {
         throw new IllegalArgumentException("array is null");
      }
   
      
      if (coll.size() == 0) {
         throw new NoSuchElementException("array has length of 0");
      }
      
      // search the collection looking for the f value
      
      T f = null;
      for (T element : coll) {
         if (comp.compare(element, key) <= 0) {
            f = element;
            break;
         }
      }
      
      for (T element : coll) {
         
         if ((comp.compare(element, key) <= 0) && (comp.compare(element, f) > 0)) {
            f = element;
         }
      }
      
      
      // if no floor is found
      if (f == null) {
         throw new NoSuchElementException("array has length of 0");
      }
   
   
      
      return f;
   
   }

}

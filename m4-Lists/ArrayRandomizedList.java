import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;


/**
 * Array-based implementation of the RandomizedList interface.
 *
 * @author Molly Anderson (MPA0012@auburn.edu)
 * @version 2019-02-09
 */


public class ArrayRandomizedList<T> implements RandomizedList<T> {
   
   // constant default size of elements array
   private static final int DEFAULT_CAPACITY = 5;
   
   // physical storage
   private T[] elements;
   
   // keep track of size of elements array
   private int size;
   
   
   //constuctor
   // default array size is used when no size parameter input is given.
   
   /**
    * ArrayRandomizedList. 
    */
   public ArrayRandomizedList() {
     
      // instantiate an ArrayRandomizedList with default capacity. 
      this(DEFAULT_CAPACITY);
      //RandomizedList<T> rlist = new ArrayRandomizedList<T>();
     
      //size = 0;
   
   }
   
   // constructor used if array size is given via parameter input.
   @SuppressWarnings("unchecked")
   public ArrayRandomizedList(int capacity) {
      elements = (T[]) new Object[capacity]; 
      size = 0;
   }
   
   //overriden methods. 
   
   public int size() {
      return size; 
   }
   
   public boolean isEmpty() {
      return size == 0;
   }
   
   
   /** 
    * @return new ArrayIterator.
    */
   public Iterator<T> iterator() {
      
      return new ArrayIterator(elements, size);
   }
   
   
   /**
    * @param element.
    */
   public void add(T element) {
      // check if size == elements.length. if so, increase size of array
      // by calling resize(). this will be O(1) ammortized
      if (element == null) {
         throw new IllegalArgumentException("null input");
      }
      if (size == elements.length) {
            // dynamically resize()
         resize(elements.length * 2);
            
      }
      
      // add element to end of array. 
      elements[size] = element;
      size++;
      
       
   }
   
   // selects a random element and removes it. if empty, return null. 
   
   /** 
    *@return result.
    */
   public T remove() {
     
     
      // if array is empty
      if (isEmpty()) {
         return null;
      }
      
      
      //select random element
      int i = randomIndex();
      //T rand = elements[randomIndex()];
      
      // remove that element 
      // replace with last 
      T result = elements[i];
      elements[i] = elements[--size];
      elements[size] = null;
      //dynamically resize if necessary
      
      return result;
      
   }

   // selects an element uniformly at random from the list. if empty, return null.
   public T sample() {
      T element = elements[randomIndex()];
      return element;
   }
   
   // new methods. 
   
   @SuppressWarnings("unchecked")
   private void resize(int capacity) {
      T[] a = (T[]) new Object[capacity];
      for (int i = 0; i < size(); i++) {
         a[i] = elements[i];
      }
      elements = a;
   }
   
   /**
    * @return result.
    */
   public int randomIndex() {
      int max = size - 1;
      int min = 0;
      int range = max - min + 1;
      int index = (int) (Math.random() * range) + min;
      return index;
   }
   
   /**
    * @return result.
    */
   
   public String toString() {
      String result = "[";
      for (T e : elements) {
         
         result = result + e + ", ";
      }
      result = result + "]";
      
      return result;
   }
   
   
   
   // searches for and returns t/f if the list contains a certain element.
   //O(N) worst case 
   //public boolean contains(T element) {
      //boolean result = false;
      // linear search
      //for (int i = 0; i < size; i++) {
         //if (elements[i].equals(element)) {
            //return true;
         //}
      //}
      
      //return false;
   //}
   
   
   // shuffle method. knuth shuffle
   
   /**
    * @param a.
    */
   public void shuffle(T[] a) {
      for (int i = 0; i < size; i++) {
         // choose index uniformly
         int r = (int) (Math.random() * (i + 1));
         T swap = a[r];
         a[r] = a[i];
         a[i] = swap;
      }
   }
   
   
   // NESTED ITERATOR CLASS.
   
   private class ArrayIterator implements Iterator<T> {
      // array of elements to be iterated over
      // make a copy of current array
      private T[] iteration;
      
      // number of elements in the array
      private int count;
      
      // current position in the iteration
      private int current;
      
      
      
      // constructor
      @SuppressWarnings("unchecked")
      public ArrayIterator(T[] elements, int size) {
         iteration = (T[]) new Object[size()];
         
         // make iteration a copy of elements
         for (int i = 0; i < size; i++) {
            iteration[i] = elements[i];
         }
         
         
         
         // shuffle method
         shuffle(iteration);
         
         count = size;
         current = 0;
      }
      
      // methods
      
      public boolean hasNext() {
         return (current < count);
      }
      
      public T next() {
         
         if (!hasNext()) {
            throw new NoSuchElementException();
            
         } 
         
         return iteration[current++];
      }
      
      public void remove() {
         throw new UnsupportedOperationException();
      }
   
   
   }
   
         
   
}
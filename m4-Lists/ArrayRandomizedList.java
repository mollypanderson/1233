import java.util.Iterator;
import java.util.Random;
import java.util.NoSuchElementException;

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
   
   public Iterator<T> iterator() {
      
      return null;
   }
   
   
   public void add(T element) throws IllegalArgumentException {
      // check if size == elements.length. if so, increase size of array
      // by calling resize(). this will be O(1) ammortized
      
      //if (size == elements.length) {
         
      //}
      
      // else, add element to end of array. 
      elements[size] = element;
      size++;
      
       
   }
   
   // selects a random element and removes it. if empty, return null. 
   public T remove() {
     // randomly selected element
      T rand = null;
      // if array is empty
      if (size == 0) {
         return null;
      }
      
      //select random element
      
      // remove that element (dynamic resizing)
      // replace with last 
      rand = elements[--size];
      elements[size] = null;
      return rand;
      
   }

   // selects an element uniformly at random from the list. if empty, return null.
   public T sample() {
      T element = null;
      return element;
   }
   
   // new methods. 
   
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
         for (int i = 0; i < elements.length; i++) {
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
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;


/**
 * Node-based implementation of the DoubleEndedList interface.
 *
 * @author Molly Anderson (MPA0012@auburn.edu)
 * @version 2019-02-09
 */


public class LinkedDoubleEndedList<T> implements DoubleEndedList<T> { 

   private Node front;
   private Node rear;
   private int size;
         
   
   /**
    * constructor.
    */
   public LinkedDoubleEndedList() {
      
      front = null;
      size = 0;
   }
   
   /** 
    * @return size.
    */
   public int size() {
      return size;
   }
   
   public boolean isEmpty() {
      return size == 0;
   }
   
   // add element to front of list. if null, throw exception. 
   /** 
    * @param element.
    */
   public void addFirst(T element) {
      
      if (element == null) {
         throw new IllegalArgumentException("null input");
      }
      
      Node n = new Node(element);
      
      if (isEmpty()) {
         front = n;
         rear = n;
      }
      
      else {
         n.next = front;
         front.prev = n;
         front = n;
         //n = front.prev;
         //front = n;
      }
      
      size++;
      
   }
   
   // adds element to end of list. if null, throw error. 
   /** 
    * @param element.
    */
   public void addLast(T element) {
   
      if (element == null) {
         throw new IllegalArgumentException("null input");
      }
      
      Node n = new Node(element);
      
      // if empty
      if (isEmpty()) {
         front = n;
         rear = n;
      }
      
      else {
         n.prev = rear;
         rear.next = n;
         rear = n;
        
         
      }
      size++;
      
   }
   
   /**  
    * @return result.
    */
   public T removeFirst() {
      
      if (isEmpty()) {
         return null;
      }
      
      T result = front.element;
      front = front.next;
      size--;
      
      return result;
   }
   
   /** 
    * @return result.
    */
   
   public T removeLast() {
      
      if (isEmpty()) {
         
         return null;
      }
      
      T result = rear.element;
      
      if (size == 1) {
         front = null;
         rear = null;
      }
      
      else {
         Node newRear = rear.prev;
         rear.next = null;
         rear.prev = null;
         rear = newRear;
         rear.next = null;
      }
      
      --size;
      
      return result;
   }
   
   public String toString() {
      LinkedDoubleEndedList<T>.LinkedIterator itr = new LinkedIterator();
      String result = "[";
      while (itr.hasNext()) {
         
         result = result + itr.next() + ", ";
      }
      result = result + "]";
      
      return result;
   }
   
   public Iterator<T> iterator() {
      return new LinkedIterator();
   }
   
   private class Node {
      private T element;
      private Node next;
      private Node prev;
      
      public Node(T e) {
         element = e;
      }
      
      public Node(T e, Node n) {
         element = e;
         next = n;
      }
   }
   
   private class LinkedIterator implements Iterator<T> { 
      private Node current = front;
      //private int count;
      //private int current;
      
      public boolean hasNext() {
         return current != null;
      }
      
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         
         T result = current.element;
         current = current.next;
         return result;
      }
      
      
      public void remove() {
         throw new UnsupportedOperationException();
      }
      
   }
        

}
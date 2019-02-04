import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Line.java
 * Models a line segment as a sorted set of points.
 *
 * @author  Molly Anderson (MPA0012@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2019-01-29
 *
 */
public class Line implements Comparable<Line>, Iterable<Point> {
 
   SortedSet<Point> line;
   
   /** 
    * Creates a new line containing no points.
    *
    * THIS METHOD IS PROVIDED FOR YOU AND MUST NOT BE CHANGED.
    */
   public Line() {
      line = new TreeSet<Point>();
   
   }
   
   /** 
    * Creates a new line with containing all distinct collinear points in the
    * Collection c.
    */
   public Line(Collection<Point> c) {
      // takes a a collection of Point objects
      // iterate thru whole collection c
      // add every item (the add method filters them as necessary)
      line = new TreeSet<Point>();
      for (Point element : c) {
         if (line.size() < 2) {
            this.add(element);
         }
         else {
            if (element.slopeOrder.compare(line.first(), line.last()) == 0) {
               this.add(element);
            
            }
         } 
      
      
      }
   }
   
 
   /** 
    * Adds the point p to this line if p is collinear with all points already
    * in the line and p itself is not already in the line. Returns true if this
    * line is changed as a result, false otherwise.
    */
   public boolean add(Point p) {
      boolean result = false;
      // if line.size() == 0 or 1, just add it. 
      // if list.size() >= 2, do the following: 
         // find slope of first two Point objects in line
         // compare slope of first.slopeTo(last) with b.slopeTo(p)         
            // if result of comparePointsBySlope == 0, 
            // this.add(p) to line and return true
            // else, return false and do not add
      if (line.size() < 2) {
         result = line.add(p);
      }
      
      
      else {
         if (p.slopeOrder.compare(line.first(), line.last()) == 0) {
            result = line.add(p);
         }
      }
      
      
      return result;
   }
   
   /** 
    * Returns the first (minimum) point in this line or null if this line
    * contains no points.
    */
   public Point first() {
      Point result = null;
      if (line.size() > 0) {
         result = line.first();
      }
      
      return result;
   }
   
   /** 
    * Returns the last (maximum) point in this line or null if this line
    * contains no points.
    */
   public Point last() {
      Point result = null;
      if (line.size() > 0) {
         result = line.last();
      }
      return result;
   }
   
   /** 
    * Returns the number of points in this line.
    */
   public int length() {
      return line.size();
   }

   /**
    * Compares this line with the specified line for order. Returns a negative
    * integer, zero, or a positive integer if this line is less than, equal to,
    * or greater than the specified line. Lines are ordered first by their
    * first point then by their last point. An empty line is less than any
    * non-empty line, and all empty lines are equal. All three properties of
    * compareTo as specified in the Comparable interface are met, and this
    * implementation is consistent with equals.
    */
   @Override
   public int compareTo(Line that) {
      int returnValue = -2;
      if (this.first() == null) {
        // Both lines are empty
         if (that.first() == null) {
            returnValue = 0;
         } // Only "this" is empty
         else {
            returnValue = -1;
         }
      }
      
      // Only "that" is empty
      else if (that.first() == null) {
         returnValue = 1;
      }
      else if ((this.first().compareTo(that.first()) == 0) && (this.last().compareTo(that.last()) == 0)) {
         returnValue = 0;
      }
      //else if (this.length() == 0 && that.length() == 0) {
      //returnValue = 0;
      //}
      else if (this.first().compareTo(that.first()) > 0) {
         returnValue = 1;
      }
      else if (this.first().compareTo(that.first()) < 0) {
         returnValue = -1;
      }
      else {
         if (this.last().compareTo(that.last()) > 0) {
            returnValue = 1;
         }
         else {
            returnValue = -1;
         }
      }
   
      return returnValue;    
   }     

   /** 
    * Provide an iterator over all the points in this line. The order in which
    * points are returned must be ascending natural order.
    */
   @Override
   public Iterator<Point> iterator() {
      //iterator that uses ascending natural order
      //line.iterator();
      return line.iterator();
   }
   
   /** 
    * Return true if this line's first and last points are equal to the
    * parameter's first and last points. Empty lines are equal to each other
    * but are not equal to any non-empty line.
    *
    * THIS METHOD IS PROVIDED FOR YOU AND MUST NOT BE CHANGED.
    */
   @Override 
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }
      if (obj == this) {
         return true;
      }
      if (!(obj instanceof Line)) {
         return false;
      }
      Line that = (Line) obj;
      if ((this.length() == 0) && (that.length() == 0)) {
         return true;
      }
      if ((this.length() == 0) && (that.length() != 0)) {
         return false;
      }
      if ((this.length() != 0) && (that.length() == 0)) {
         return false;
      }
      return (this.first().equals(that.first())) && (this.last().equals(that.last()));
   }
 
   /** 
    * Return a string representation of this line.
    *
    * THIS METHOD IS PROVIDED FOR YOU AND MUST NOT BE CHANGED.
    */
   @Override
   public String toString() {
      if (length() == 0) {
         return "";
      }
      StringBuilder s = new StringBuilder();
      for (Point p : line) {
         s.append(p + " -> ");
      }
      s = s.delete(s.length() - 4, s.length());
      return s.toString();
   }
 
}

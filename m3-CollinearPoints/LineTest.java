import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.ArrayList;


public class LineTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   //@Test public void defaultTest() {
      //Assert.assertEquals("Default test added by jGRASP. Delete "
         //   + "this test once you have added your own.", 0, 1);
   //}
   
   
   @Test public void addTest1() {
      SortedSet<Point> l = new TreeSet<Point>();
      Point a = new Point(4, 4);
      Point b = new Point(1, 1);
      Point c = new Point(3, 3);
      l.add(a);
      l.add(b);
      
      boolean expected = true;
      boolean actual = l.add(c);
      Assert.assertEquals(expected, actual);
         
   }
   
   @Test public void addTest3() {
      SortedSet<Point> l = new TreeSet<Point>();
      Point a = new Point(4, 4);
      Point b = new Point(1, 1);
      Point c = new Point(9, 9);
      Point d = new Point(3, 3);
      Point k = new Point(9, 9);
      l.add(a);
      l.add(b);
      l.add(d);
      l.add(k);
      
      boolean expected = false;
      boolean actual = l.add(c);
      Assert.assertEquals(expected, actual);
         
   }
   
   
   @Test public void addTest2() {
      Line line = new Line();
      
      
      Point a = new Point(4, 4);
      Point b = new Point(1, 1);
      Point c = new Point(3, 8);
      Point d = new Point(3, 3);
      Point k = new Point(9, 9);
      line.add(a);
      line.add(b);
      line.add(d);
      line.add(k);
      
      boolean expected = false;
      boolean actual = line.add(c);
      Assert.assertEquals(expected, actual);
         
   }
   
   @Test public void addTest4() {
      Line line = new Line();
      
      
      Point a = new Point(4, 4);
      Point b = new Point(4, 4);
      
      line.add(a);
      line.add(b);
      
      
      boolean expected = false;
      boolean actual = line.add(b);
      Assert.assertEquals(expected, actual);
         
   }
   
   @Test public void compareToTest1() {
   
   // line 1 is less than line 2
      Line l = new Line();
      Line m = new Line();
      Point a = new Point(1, 1);
      Point b = new Point(3, 3);
      l.add(a);
      l.add(b);
      Point y = new Point(5, 5);
      Point z = new Point(4, 2);
      m.add(y);
      m.add(z);
      int expected = -1;
      int actual = l.compareTo(m);
      Assert.assertEquals(expected, actual);
      
   }
   
   @Test public void compareToTest2() {
   
   // line 1 is greater than line 2
      Line l = new Line();
      Line m = new Line();
      Point a = new Point(9, 9);
      Point b = new Point(8, 8);
      l.add(a);
      l.add(b);
      Point y = new Point(5, 4);
      Point z = new Point(4, 2);
      m.add(y);
      m.add(z);
      int expected = 1;
      int actual = l.compareTo(m);
      Assert.assertEquals(expected, actual);
      
   }
   
   @Test public void compareToTest3() {
   
   // line 1 is greater than line 2
      Line l = new Line();
      Line m = new Line();
      Point a = new Point(9, 9);
      Point b = new Point(8, 8);
      l.add(a);
      l.add(b);
      Point y = new Point(9, 9);
      Point z = new Point(8, 8);
      m.add(y);
      m.add(z);
      int expected = 0;
      int actual = l.compareTo(m);
      Assert.assertEquals(expected, actual);
      
   }
   
   @Test public void compareToTest4() {
   
   // both lines are empty
      Line l = new Line();
      Line m = new Line();
      int expected = 0;
      int actual = l.compareTo(m);
      Assert.assertEquals(expected, actual);
      
   }

   
   @Test public void lengthTest1() {
   
   // length 4
      Line l = new Line();
     
      Point a = new Point(9, 9);
      Point b = new Point(8, 8);
      l.add(a);
      l.add(b);
      Point y = new Point(2, 2);
      Point z = new Point(3, 3);
      l.add(y);
      l.add(z);
      int expected = 4;
      int actual = l.length();
      Assert.assertEquals(expected, actual);
      
   }
   
   @Test public void lastTest1() {
   
      Line l = new Line();
     
      Point a = new Point(9, 9);
      Point b = new Point(8, 8);
      l.add(a);
      l.add(b);
      Point y = new Point(2, 2);
      Point z = new Point(3, 3);
      l.add(y);
      l.add(z);
      Point expected = a;
      Point actual = l.last();
      Assert.assertEquals(expected, actual);
      
   }
   
   @Test public void lastTest2() {
   
      Line l = new Line();
     
      Point a = new Point(9, 9);
      Point b = new Point(8, 8);
      
      Point y = new Point(2, 2);
      Point z = new Point(3, 3);
      
      Point expected = null;
      Point actual = l.last();
      Assert.assertEquals(expected, actual);
      
   }
   
   @Test public void firstTest1() {
   
      Line l = new Line();
     
      Point a = new Point(9, 9);
      Point b = new Point(8, 8);
      l.add(a);
      l.add(b);
      Point y = new Point(2, 2);
      Point z = new Point(3, 3);
      l.add(y);
      l.add(z);
      Point expected = y;
      Point actual = l.first();
      Assert.assertEquals(expected, actual);
      
   }
   
   
   @Test public void firstTest2() {
   
      Line l = new Line();
     
      Point a = new Point(9, 9);
      Point b = new Point(8, 8);
      
      Point y = new Point(2, 2);
      Point z = new Point(3, 3);
      
      Point expected = null;
      Point actual = l.first();
      Assert.assertEquals(expected, actual);
      
   }
   
   @Test public void constructorTest2() {
   
      ArrayList<Point> coll = new ArrayList<Point>();
      Point a = new Point(9, 9);
      Point b = new Point(8, 8);
      Point c = new Point(1, 3);
      Point d = new Point(4, 3);
      Point y = new Point(2, 2);
      Point z = new Point(10, 11);
      coll.add(a);
      coll.add(b);
      coll.add(c);
      coll.add(d);
      coll.add(y);
      coll.add(z);
      Line l = new Line(coll);
      Point expected = a;
      Point actual = l.last();
      Assert.assertEquals(expected, actual);
      
   }
   
      



 

}

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class PointTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   //@Test public void defaultTest() {
      //Assert.assertEquals("Default test added by jGRASP. Delete "
         //   + "this test once you have added your own.", 0, 1);
   //}
   
   @Test public void compareToTest1() {
   
   // xy1 and xy2 are equal
      Point a = new Point(5, 5);
      Point b = new Point(5, 5);
      int expected = 0;
      int actual = a.compareTo(b);
      Assert.assertEquals(expected, actual);
      
   }
   
   // y1 is less than y2
   @Test public void compareToTest2() {
   
      Point a = new Point(5, 2);
      Point b = new Point(5, 5);
      int expected = -1;
      int actual = a.compareTo(b);
         
   }
   
   //y1 and x2 are greater than x1 and x2
   
   @Test public void compareToTest3() {
   
      Point a = new Point(5, 5);
      Point b = new Point(1, 1);
      int expected = 1;
      int actual = a.compareTo(b);
      Assert.assertEquals(expected, actual);
      
   }
   
   // y1 is greater than y2
   @Test public void compareToTest4() {
   
      Point a = new Point(5, 7);
      Point b = new Point(5, 5);
      int expected = 1;
      int actual = a.compareTo(b);
      Assert.assertEquals(expected, actual);
         
   }
   
   // ys are equal, x1 is less than x2
   @Test public void compareToTest5() {
   
      Point a = new Point(2, 5);
      Point b = new Point(5, 5);
      int expected = -1;
      int actual = a.compareTo(b);
      Assert.assertEquals(expected, actual);
         
   }
   
   // ys are equal, x1 is greater than x2
   @Test public void compareToTest6() {
   
      Point a = new Point(7, 5);
      Point b = new Point(5, 5);
      int expected = 1;
      int actual = a.compareTo(b);
      Assert.assertEquals(expected, actual);
         
   }
   
   // slope
   @Test public void slopeToTest1() {
   
      Point a = new Point(4, 5);
      Point b = new Point(3, 3);
      double expected = 2.0;
      double actual = a.slopeTo(b);
      Assert.assertEquals(expected, actual, .001);
         
   }
   
   // slope
   @Test public void slopeToTest2() {
   
      Point a = new Point(5, 2);
      Point b = new Point(3, 3);
      double expected = -0.5;
      double actual = a.slopeTo(b);
      Assert.assertEquals(expected, actual, .001);            
   }

   @Test public void slopeToTest3() {
   
      Point a = new Point(1, 1);
      Point b = new Point(3, 3);
      double expected = 1.0;
      double actual = a.slopeTo(b);
      Assert.assertEquals(expected, actual, .001);
         
   }
   
   // horizontal slope should be 0
   @Test public void slopeToTest4() {
   
      Point a = new Point(1, 3);
      Point b = new Point(3, 3);
      double expected = 0;
      double actual = a.slopeTo(b);
      Assert.assertEquals(expected, actual, .001);
         
   }
   
   // slope of vertical line should be +infinity
   @Test public void slopeToTest5() {
   
      Point a = new Point(3, 5);
      Point b = new Point(3, 3);
      double expected = Double.POSITIVE_INFINITY;
      double actual = a.slopeTo(b);
      Assert.assertEquals(expected, actual, .001);
         
   }
   
   // slope of vertical line should be +infinity
   @Test public void slopeToTest6() {
   
      Point a = new Point(3, 3);
      Point b = new Point(3, 3);
      double expected = Double.NEGATIVE_INFINITY;
      double actual = a.slopeTo(b);
      Assert.assertEquals(expected, actual, .001);
         
   }
   
   @Test public void ComparePointsBySlopeTest1() {
   
      Point a = new Point(5, 2);
      Point b = new Point(1, 1);
      Point c = new Point(3, 3);
      
      int expected = -1;
      int actual = c.slopeOrder.compare(a, b);
      Assert.assertEquals(expected, actual);
         
   }
   
   @Test public void ComparePointsBySlopeTest2() {
   
      Point a = new Point(4, 5);
      Point b = new Point(1, 1);
      Point c = new Point(3, 3);
      
      int expected = -1;
      int actual = c.slopeOrder.compare(b, a);
      Assert.assertEquals(expected, actual);
         
   }
   
   @Test public void ComparePointsBySlopeTest3() {
   
      Point a = new Point(4, 4);
      Point b = new Point(1, 1);
      Point c = new Point(3, 7);
      
      int expected = -1;
      int actual = c.slopeOrder.compare(a, b);
      Assert.assertEquals(expected, actual);
         
   }
   
         
   

   
   

   
   

   
   
}

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;


public class SelectorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   @Test public void minTestOne() {
      int[] m = {5, 2, 3, 9};
      int expected = 2;
      int actual = Selector.min(m);
      assertEquals(expected, actual);
   }
   
   @Test public void minTestTwo() {
      int[] m = {9, 7, 5, 2};
      int expected = 2;
      int actual = Selector.min(m);
      assertEquals(expected, actual);
   }
   
   @Test public void maxTestOne() {
      int[] m = {7, 9, 5, 2};
      int expected = 9;
      int actual = Selector.max(m);
      assertEquals(expected, actual);
   }
   
   @Test public void rangeTestOne() {
      int[] m = {7, 9, 5, 6, 7, 2};
      int[] expected = {7, 5, 6, 7};
      int[] actual = Selector.range(m, 4, 8);
      assertEquals(expected[3], actual[3]);
   }


   @Test public void rangeTestTwo() {
      int[] m = {1, 1, 1, 1, 1, 1};
      int[] expected = {1, 1, 1, 1, 1, 1};
      int[] actual = Selector.range(m, 1, 1);
      assertEquals(expected[2], actual[2]);
   }
   
   @Test public void ceilingTestOne() {
      int[] m = {4, 10, 6, 7, 2};
      
      int expected = 4;
      int actual = Selector.ceiling(m, 3);
      assertEquals(expected, actual);
   }
   
   @Test public void ceilingTestTwo() {
      int[] m = {1, 2, 3, 4};
      
      int expected = 2;
      int actual = Selector.ceiling(m, 2);
      assertEquals(expected, actual);
   }
   
   @Test public void ceilingTestThree() {
      int[] m = {1, 1, 1, 1};
      
      int expected = 1;
      int actual = Selector.ceiling(m, 1);
      assertEquals(expected, actual);
   }
   
   @Test public void ceilingTestFour() {
      int[] m = {2, 3, 4, 5};
      
      int expected = 2;
      int actual = Selector.ceiling(m, 2);
      assertEquals(expected, actual);
   }
   
   @Test public void floorTestOne() {
      int[] m = {4, 10, 6, 7, 2};
      
      int expected = 2;
      int actual = Selector.floor(m, 3);
      assertEquals(expected, actual);
   }


   @Test public void floorTestTwo() {
      int[] m = {6, 1, 10, 12};
      
      int expected = 10;
      int actual = Selector.floor(m, 10);
      assertEquals(expected, actual);
   }

   @Test public void floorTestThree() {
      int[] m = {11, 11, 11, 11};
      
      int expected = 11;
      int actual = Selector.floor(m, 12);
      assertEquals(expected, actual);
   }
   
   @Test public void kminTestOne() {
      int[] m = {2, 9, 8, 3, 5};
      
      int expected = 8;
      int actual = Selector.kmin(m, 4);
      assertEquals(expected, actual);
   }
   
   @Test public void kminTestTwo() {
      int[] m = {2, 8, 7, 3, 4};
      
      int expected = 2;
      int actual = Selector.kmin(m, 1);
      assertEquals(expected, actual);
   }
   
   @Test public void kminTestThree() {
      int[] m = {5, 9, 1, 7, 3};
      
      int expected = 5;
      int actual = Selector.kmin(m, 3);
      assertEquals(expected, actual);
   }
   
   @Test public void kminTestFour() {
      int[] m = {8, 7, 6, 5, 4};
      
      int expected = 8;
      int actual = Selector.kmin(m, 5);
      assertEquals(expected, actual);
   }

   
   @Test public void kminTestFive() {
      int[] m = {2, 8, 8, 7, 3, 3, 4};
      
      int expected = 4;
      int actual = Selector.kmin(m, 3);
      assertEquals(expected, actual);
   }








}

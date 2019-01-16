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



}

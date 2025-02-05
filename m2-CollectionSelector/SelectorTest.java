import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;



public class SelectorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   //@Test public void defaultTest() {
      //Assert.assertEquals("Default test added by jGRASP. Delete "
         //   + "this test once you have added your own.", 0, 1);
   //}
   
   // min tests
        
   @Test
   public void testMinTypical1() {
      Collection<Integer> coll = Arrays.<Integer>asList(new
         Integer[]{3, 69, 45, 777, 420});
      Comparator<Integer> comp = 
         new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
               return i1.compareTo(i2);
            }
         };
      Integer min = Selector.min(coll, comp);
      Integer expected = 3;
      Assert.assertEquals(expected, min);
   }
   
   @Test
   public void testMinTypical2() {
      Collection<String> coll = Arrays.<String>asList(new
         String[]{"A", "Z", "R", "I", "E"});
      Comparator<String> comp = 
         new Comparator<String>() {
            public int compare(String s1, String s2) {
               return s1.compareTo(s2);
            }
         };
      String min = Selector.min(coll, comp);
      String expected = "A";
      Assert.assertEquals(expected, min);
   }
   
        
   // max tests
   
   @Test
   public void testMaxTypical1() {
      Collection<Integer> coll = Arrays.<Integer>asList(new
         Integer[]{3, 69, 45, 777, 420});
      Comparator<Integer> comp = 
         new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
               return i1.compareTo(i2);
            }
         };
      Integer max = Selector.max(coll, comp);
      Integer expected = 777;
      Assert.assertEquals(expected, max);
   }

   
   @Test
   public void testMaxTypical2() {
      Collection<String> coll = Arrays.<String>asList(new
         String[]{"A", "Z", "R", "I", "E"});
      Comparator<String> comp = 
         new Comparator<String>() {
            public int compare(String s1, String s2) {
               return s1.compareTo(s2);
            }
         };
      String max = Selector.max(coll, comp);
      String expected = "Z";
      Assert.assertEquals(expected, max);
   }
   
   // range tests
   @Test
   public void testRangeTypical1() {
      Collection<Integer> coll = Arrays.<Integer>asList(new
         Integer[]{3, 69, 45, 777, 420});
      Comparator<Integer> comp = 
         new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
               return i1.compareTo(i2);
            }
         };
      Collection<Integer> range = Selector.range(coll, 40, 71, comp);
      Integer[] expected = new Integer[]{45, 69};
      Assert.assertEquals(expected, range);
   }

   @Test
   public void testCeilingTypical1() {
      Collection<Integer> coll = Arrays.<Integer>asList(new
         Integer[]{3, 69, 45, 777, 420});
      Comparator<Integer> comp = 
         new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
               return i1.compareTo(i2);
            }
         };
      Integer ceiling = Selector.ceiling(coll, 35, comp);
      Integer expected = 45;
      Assert.assertEquals(expected, ceiling);
   }
   
   @Test
   public void testCeilingTypical2() {
      Collection<String> coll = Arrays.<String>asList(new
         String[]{"A", "Z", "R", "I", "E"});
      Comparator<String> comp = 
         new Comparator<String>() {
            public int compare(String s1, String s2) {
               return s1.compareTo(s2);
            }
         };
      String ceiling = Selector.ceiling(coll, "B", comp);
      String expected = "E";
      Assert.assertEquals(expected, ceiling);
   }
   
   @Test
   public void testFloorTypical1() {
      Collection<Integer> coll = Arrays.<Integer>asList(new
         Integer[]{3, 69, 45, 777, 420});
      Comparator<Integer> comp = 
         new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
               return i1.compareTo(i2);
            }
         };
      Integer floor = Selector.floor(coll, 35, comp);
      Integer expected = 3;
      Assert.assertEquals(expected, floor);
   }
   
   @Test
   public void testkminTypical1() {
      Collection<Integer> coll = Arrays.<Integer>asList(new
         Integer[]{3, 69, 45, 777, 420});
      Comparator<Integer> comp = 
         new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
               return i1.compareTo(i2);
            }
         };
      Integer kmin = Selector.kmin(coll, 3, comp);
      Integer expected = 69;
      Assert.assertEquals(expected, kmin);
   }
   
   @Test
   public void testkminTypical2() {
      Collection<Integer> coll = Arrays.<Integer>asList(new
         Integer[]{2, 8, 7, 3, 4});
      Comparator<Integer> comp = 
         new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
               return i1.compareTo(i2);
            }
         };
      Integer kmin = Selector.kmin(coll, 1, comp);
      Integer expected = 2;
      Assert.assertEquals(expected, kmin);
   }

   
   @Test
   public void testkminTypical3() {
      Collection<String> coll = Arrays.<String>asList(new
         String[]{"A", "Z", "R", "I", "E"});
      Comparator<String> comp = 
         new Comparator<String>() {
            public int compare(String s1, String s2) {
               return s1.compareTo(s2);
            }
         };
      String kmin = Selector.kmin(coll, 2, comp);
      String expected = "E";
      Assert.assertEquals(expected, kmin);
   }
   
   @Test
   public void testkminTypical4() {
      Collection<Integer> coll = Arrays.<Integer>asList(new
         Integer[]{3});
      Comparator<Integer> comp = 
         new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
               return i1.compareTo(i2);
            }
         };
      Integer kmin = Selector.kmin(coll, 1, comp);
      Integer expected = 3;
      Assert.assertEquals(expected, kmin);
   }
   
   @Test
   public void testkminTypical5() {
      Collection<Integer> coll = Arrays.<Integer>asList(new
         Integer[]{3,7,3,3,1,9,1,1,1,5});
      Comparator<Integer> comp = 
         new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
               return i1.compareTo(i2);
            }
         };
      Integer kmin = Selector.kmin(coll, 2, comp);
      Integer expected = 3;
      Assert.assertEquals(expected, kmin);
   }

   @Test
   public void testkmaxTypical1() {
      Collection<Integer> coll = Arrays.<Integer>asList(new
         Integer[]{3, 69, 45, 777, 420});
      Comparator<Integer> comp = 
         new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
               return i1.compareTo(i2);
            }
         };
      Integer kmax = Selector.kmax(coll, 3, comp);
      Integer expected = 69;
      Assert.assertEquals(expected, kmax);
   }
   
  
   
   @Test
   public void testkmaxTypical2() {
      Collection<Integer> coll = Arrays.<Integer>asList(new
         Integer[]{5, 7});
      Comparator<Integer> comp = 
         new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
               return i1.compareTo(i2);
            }
         };
      Integer kmax = Selector.kmax(coll, 1, comp);
      Integer expected = 7;
      Assert.assertEquals(expected, kmax);
   }
   
   @Test
   public void testkmaxTypical3() {
      Collection<String> coll = Arrays.<String>asList(new
         String[]{"A", "Z", "R", "I", "E"});
      Comparator<String> comp = 
         new Comparator<String>() {
            public int compare(String s1, String s2) {
               return s1.compareTo(s2);
            }
         };
      String kmax = Selector.kmax(coll, 2, comp);
      String expected = "R";
      Assert.assertEquals(expected, kmax);
   }



   
}

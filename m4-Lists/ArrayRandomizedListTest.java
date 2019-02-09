import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class ArrayRandomizedListTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   //@Test public void defaultTest() {
      //Assert.assertEquals("Default test added by jGRASP. Delete "
         //   + "this test once you have added your own.", 0, 1);
   //}
   
   
   // test case that instantiates bag
   @Test public void addTest1() {}
      RandomizedList<Integer> rl = new ArrayRandomizedList<Integer>(10);
      //Integer a = 24;
      //Integer b = 53;
      rl.add(23);
      rl.add(53);
      Integer expected = 1;
      //Integer actual = elements[1];
      Assert.assertEquals(expected, actual);
   
   
   // expected value from calling add
   
   
   // 
}

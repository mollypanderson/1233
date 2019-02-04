import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.ArrayList;


public class ExtractorTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** A test that always fails. **/
   //@Test public void defaultTest() {
      //Assert.assertEquals("Default test added by jGRASP. Delete "
         //   + "this test once you have added your own.", 0, 1);
   //}
   
   // @Test public void constructorTest1() {
   //    //fake data points String
      // String dataFile = "5\n11000 11000\n12000 10000\n13000 10000\n"
         // + "14000 10000\n15000 10000";
   //    // call constructor method
   //    // create extractor object
      // Extractor e = new Extractor();
      // Extractor(dataFile);
      // int expected = 0;
      // int actual = 0;
      // Assert.assertEquals(expected, actual);
   // }
   
   @Test public void getLinesBruteTest1() {
      
      Point a = new Point(4, 4);
      Point b = new Point(1, 1);
      Point c = new Point(3, 3);
      Point d = new Point(9, 9);
      Point e = new Point(5, 5);
      SortedSet<Point> coll = new TreeSet<Point>();
      coll.add(a);
      coll.add(b);
      coll.add(c);
      coll.add(d);
      coll.add(e);
      Extractor ex = new Extractor(coll);
      ex.getLinesBrute();
      
      int expected = -1;
      SortedSet<Line> actual = ex.getLinesBrute();
      Assert.assertEquals(expected, actual);
         
   }
   
   @Test public void getLinesBruteTest2() {
      
      Point a = new Point(21, 21);
      Point b = new Point(3, 2);
      Point c = new Point(8, 8);
      Point d = new Point(8,8);
      Point e = new Point(1,1);
      Point z = new Point(2,1);
      Point y = new Point(4,2);
      Point x = new Point(6,3);
      Point q = new Point(12,6);
      SortedSet<Point> coll = new TreeSet<Point>();
      coll.add(a);
      coll.add(b);
      coll.add(c);
      coll.add(d);
      coll.add(e);
      coll.add(z);
      coll.add(y);
      coll.add(x);
      coll.add(q);
      Extractor ex = new Extractor(coll);
      ex.getLinesBrute();
      
      int expected = -1;
      SortedSet<Line> actual = ex.getLinesBrute();
      Assert.assertEquals(expected, actual);
         
   }
   
   @Test public void getLinesBruteTest3() {
      
      Point a = new Point(11000, 11000);
      Point b = new Point(12000, 10000);
      Point c = new Point(13000, 10000);
      Point d = new Point(14000, 10000);
      Point e = new Point(15000, 10000);
      SortedSet<Point> coll = new TreeSet<Point>();
      coll.add(a);
      coll.add(b);
      coll.add(c);
      coll.add(d);
      coll.add(e);
      
      Extractor ex = new Extractor(coll);
      ex.getLinesBrute();
      
      int expected = -1;
      SortedSet<Line> actual = ex.getLinesBrute();
      Assert.assertEquals(expected, actual);
         
   }
   
   // @Test public void getLinesFastTest3() {
   //    
      // Point a = new Point(2, 2);
      // Point b = new Point(4, 4);
      // Point c = new Point(3, 3);
      // Point d = new Point(5, 5);
      // Point e = new Point(6, 5);
      // Point f = new Point(9, 4);
      // Point g = new Point(1, 1);
      // Point h = new Point(11,11);
      // Point i = new Point(1, 2);
      // Point j = new Point(2, 4);
      // Point k = new Point(4, 8);
      // Point m = new Point(8, 16);
      // SortedSet<Point> coll = new TreeSet<Point>();
      // coll.add(a);
      // coll.add(b);
      // coll.add(c);
      // coll.add(d);
      // coll.add(e);
      // coll.add(f);
      // coll.add(g);
      // coll.add(h);
      // coll.add(i);
      // coll.add(j);
      // coll.add(k);
      // coll.add(m);
      // Extractor ex = new Extractor(coll);
   //    
      // SortedSet<Line> x = new TreeSet<Line>();
      // Line l = new Line();
      // l.add(g);
      // l.add(a);
      // l.add(b);
      // l.add(c);
      // l.add(d);
      // l.add(h);
   //    
      // Line p = new Line();
      // p.add(i);
      // p.add(j);
      // p.add(k);
      // p.add(m);
      // x.add(l);
      // x.add(p);
   //    
      // SortedSet<Line> expected = x;
      // SortedSet<Line> actual = ex.getLinesFast();
      // Assert.assertEquals(expected, actual);
   //       
   // }
   
   @Test public void getLinesFast3() {
      Point a = new Point(1,6);
      Point b = new Point(2,2);
      Point c = new Point(2,5);
      Point d = new Point(3,1);
      Point e = new Point(3,2);
      Point f = new Point(3,3);
      Point g = new Point(3,4);
      Point h = new Point(3,5);
      Point i = new Point(4,3);
      Point j = new Point(4,4);
      Point k = new Point(5,2);
      Point l = new Point(5,5);
      
      SortedSet<Point> coll = new TreeSet<Point>();
      coll.add(a);
      coll.add(b);
      coll.add(c);
      coll.add(d);
      coll.add(e);
      coll.add(f);
      coll.add(g);
      coll.add(h);
      coll.add(i);
      coll.add(j);
      coll.add(k);
      coll.add(l);
      Extractor ex = new Extractor(coll);
      SortedSet<Line> x = new TreeSet<Line>();
      Line z = new Line();
      z.add(a);
      z.add(c);
      z.add(i);
      z.add(k);
      z.add(g);
      Line m = new Line();
      m.add(d);
      m.add(e);
      m.add(f);
      m.add(h);
      m.add(g);
      
      SortedSet<Line> expected = x;
      x.add(z);
      x.add(m);
      SortedSet<Line> actual = ex.getLinesFast(); 
      Assert.assertEquals(expected, actual);
   
      
   }


}

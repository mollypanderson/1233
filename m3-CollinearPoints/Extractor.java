import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;


/**
 * Extractor.java. Implements feature extraction for collinear points in
 * two dimensional data.
 *
 * @author  Molly Anderson (MPA0012@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2019-02-01
 *
 */
public class Extractor {
   
   /** raw data: all (x,y) points from source data. */
   private Point[] points;
   
   /** lines identified from raw data. */
   private SortedSet<Line> lines;
  
   /**
    * Builds an extractor based on the points in the file named by filename. 
    */
   public Extractor(String filename) throws FileNotFoundException {
      // create a scanner to read in the file
      Scanner scanFile = new Scanner(new File(filename));
      // scan in first line of file
      int length = scanFile.nextInt();
      points = new Point[length];
      // local variables
      int x;
      int y;
      // scan in rest of file line by line x number of times
      for (int i = 0; i < length; i++) {
         x = scanFile.nextInt();
         // trim data and save to x
         // trim data and save to y
         y = scanFile.nextInt();
         // add new Point(x, y) to points array
         points[i] = new Point(x, y);
         // copy the contents of this array into another public array
      }
   
   }
  
   /**
    * Builds an extractor based on the points in the Collection named by pcoll. 
    *
    * THIS METHOD IS PROVIDED FOR YOU AND MUST NOT BE CHANGED.
    */
   public Extractor(Collection<Point> pcoll) {
      points = pcoll.toArray(new Point[]{});
   }
  
   /**
    * Returns a sorted set of all line segments of exactly four collinear
    * points. Uses a brute-force combinatorial strategy. Returns an empty set
    * if there are no qualifying line segments.
    */
   public SortedSet<Line> getLinesBrute() {
      lines = new TreeSet<Line>();
      // new array
      Point[] sortedPoints = new Point[points.length];
      //copy contents of old points array into new sortedPoints
      for (int i = 0; i < points.length; i++) {
         sortedPoints[i] = points[i];
      }
      // sort new array
      Arrays.sort(sortedPoints);
      
      for (int i = 0; i < points.length; i++) {
         for (int j = i + 1; j < points.length; j++) {
            for (int k = j + 1; k < points.length; k++) {
               for (int l = k + 1; l < points.length; l++) {
                     // create temp collection of these 4 points
                  //Point[] temp = new Point[4];
                  Collection<Point> c = new TreeSet<Point>();
                  // add current points to temp collection c
                  
                  c.add(sortedPoints[i]);
                  c.add(sortedPoints[j]);
                  c.add(sortedPoints[k]);
                  c.add(sortedPoints[l]);
                      // add collection to temp Line object  
                  Line line = new Line(c);
                  
                  if (line.length() == 4) {
                  // add Line to lines
                     lines.add(line);
                  }
                  
                                        
                                          
               }
            }
         }
      }
               
      
      return lines;
   }
  
   /**
    * Returns a sorted set of all line segments of at least four collinear
    * points. The line segments are maximal; that is, no sub-segments are
    * identified separately. A sort-and-scan strategy is used. Returns an empty
    * set if there are no qualifying line segments.
    */
   public SortedSet<Line> getLinesFast() {
      lines = new TreeSet<Line>();
      // create a copy of points. This copy will be sorted with respect to
      // the slopeTo a given reference point on each 
      // interation of the loop below 
      
      //copy of points array to sort (sort on each iteration using a
      // different reference point
      Point[] pointsBySlope = Arrays.<Point>copyOf(points, points.length);
      
      // arrange points in ascending natural order
      Arrays.sort(points);
      
      // on each iteration, ID a set of 3+ points that are mutually collinear
      // with the ref point
      
      for (int refPoint = 0; refPoint < points.length; refPoint++) {
         // SORT into ascending order of slope to the reference point
         
         Arrays.<Point>sort(pointsBySlope, points[refPoint].slopeOrder);
         
         // SCAN sorted array
         // add refPoint to line object
         
         
         //line.add(pointsBySlope[0]);
         //Collection<Point> c = new TreeSet<Point>();         
         Line line = new Line(); 
         line.add(points[refPoint]);
         
         for (int currentPoint = 1; currentPoint < pointsBySlope.length; currentPoint++) {
            
            //line.add(pointsBySlope[currentPoint]);
            if (line.add(pointsBySlope[currentPoint]) == false) {
               if (line.length() >= 4) {
                  lines.add(line);
               }
               line = new Line();
               line.add(points[refPoint]);
               line.add(pointsBySlope[currentPoint]);
            
            }
            
                               
         }
         if (line.length() >= 4) {
            lines.add(line);
         }
      
         
      }
      
      return lines;
   }      
}

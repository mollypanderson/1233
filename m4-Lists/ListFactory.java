/**
 * ListFactory.java.
 * Implements the factory method pattern (https://en.wikipedia.org/wiki/Factory_method_pattern)
 * for lists in this assignment.
 *
 * @author Molly Anderson (MPA0012@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2019-02-04
 */
public class ListFactory {

   /**
    * Return an instance of a class that implements RandomizedList.
    */
   public static <T> RandomizedList<T> makeRandomizedList() {
      // Replace the following return statement with one that returns
      // an instance of the class you wrote to implement the
      // RandomizedList interface.
      return null;
   }

   /**
    * Return an instance of a class that implements DoubleEndedList.
    */
   public static <T> DoubleEndedList<T> makeDoubleEndedList() {
      // Replace the following return statement with one that returns
      // an instance of the class you wrote to implement the
      // DoubleEndedList interface.
      return new LinkedDoubleEndedList<T>();
   }

}

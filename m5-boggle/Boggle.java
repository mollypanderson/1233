
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


/**
 * TreeSet implementation of the WordSearchGame interface.
 *
 * @author Molly Anderson (MPA0012@auburn.edu)
 * @version 2019-02-14
 */


public class Boggle implements WordSearchGame { 

// instantiate a lexicon object
   TreeSet<String> lexicon = new TreeSet<String>();
   String[] board;


   private String getFirstWord(String text) {
      if (text.indexOf(' ') > -1) {
         return text.substring(0, text.indexOf(' '));
      }
      return text;
   }


/**
 * @param fileName.
 */
   public void loadLexicon(String fileName) {
      // take a param of fileName and iterate through, adding each item. 
      
      try {
         // create scanner object
         Scanner scanFile = new Scanner(new File(fileName));
         // scan in file, one line at a time, adding to lexicon object
         // scan the first line
         String input = scanFile.next();
         String word = getFirstWord(input).toUpperCase();
         lexicon.add(word);
         // scan the rest
         while (scanFile.hasNext()) {
            input = scanFile.nextLine();
            word = getFirstWord(input).toUpperCase();
            lexicon.add(word);
         }
      }
      catch (FileNotFoundException e) {
         
         throw new IllegalArgumentException("invalid file: input"
                               + " is null or cannot be opened.");
      }         
      
   }
   
   /**
 * @param letterArray.
 */
   
   public void setBoard(String[] letterArray) {
      //copy letterArray into a new String[] array 1D
      
      if (letterArray == null) {
         throw new IllegalArgumentException("input is null.");
      }
      
      if (letterArray.length == 0) {
         throw new IllegalArgumentException("input is null.");
      }
      
      int x = (int) Math.sqrt(letterArray.length);
      
      if (Math.pow(x, 2) != letterArray.length) {
         throw new IllegalArgumentException("array length must be a square.");
      }
      
      
      
      board = new String[letterArray.length];
      for (int i = 0; i < board.length; i++) {
         board[i] = letterArray[i];
      }
   }
   
   public String getBoard() {
      String boardToString = "";
      int x = (int) Math.sqrt(board.length);
      int k = 0;
      for (int j = 0; j < x; j++) { 
         for (int i = 0; i < x; i++) {
            boardToString += board[k] + "   ";
            k++;
         }
         boardToString += "\n";
      
      }
      
      return boardToString;
   }
   
   public SortedSet<String> getAllValidWords(int minimumWordLength) {
      SortedSet<String> s = new TreeSet<String>();
      return s;
   }
   
   public int getScoreForWords(SortedSet<String> words, int minimumWordLength) {
      return 0;
   }
   
   /**
 * @return boolean.
 */
   public boolean isValidWord(String wordToCheck) {
      // once you have the words stored in the lexicon,
      // use contains() method of TreeSet (take case into account, .toUpperCase()
      if (wordToCheck == null) {
         throw new IllegalArgumentException("input is null");
      }
       
      if (lexicon == null) {
         throw new IllegalStateException("loadLexicon has not been called");
      }
      
      String word = wordToCheck.toUpperCase();
      if (lexicon.contains(word)) {
         return true;
      }
      
      
     
      
      return false;
   }
   
   /**
 * @return boolean. 
 */
   public boolean isValidPrefix(String prefixToCheck) {
       
      String pUpper = prefixToCheck.toUpperCase();
      pUpper = pUpper.trim();
       
      if (prefixToCheck == null || pUpper.trim().equals("")) {
         throw new IllegalArgumentException("input is null");
      }
       
      if (lexicon == null) {
         throw new IllegalStateException("loadLexicon has not been called");
      }
      
      String c = lexicon.ceiling(pUpper);
      if (c != null && c.contains(pUpper)) {
         return true;
      }
      
      return false;
   }
   
   /**
 * @param wordToCheck. 
 * @return path.
 */
   public List<Integer> isOnBoard(String wordToCheck) {
      List<Integer> path = new ArrayList<>();
      return path;
   }
   
   /**
 * @param args.
 */
   public static void main(String[] args) {
      WordSearchGame game = WordSearchGameFactory.createGame();
      game.loadLexicon("wordfiles/words_tiny.txt");
      System.out.println(game.isValidWord("small"));
      System.out.println(game.isValidPrefix("d"));
      System.out.println(game.isValidPrefix("sm"));
      System.out.println(game.isValidPrefix("lexi"));
      System.out.println(game.isValidPrefix("dsds"));
      
   }

}
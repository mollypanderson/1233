
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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
   String[][] board;
   public int BOARD_SIZE;
   public boolean[][] visited;
   
   


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
      
      if (fileName == null) {
         throw new IllegalArgumentException("input is null.");
      }
      
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
      
      
      BOARD_SIZE = x;
      board = new String[BOARD_SIZE][BOARD_SIZE];
      
      
      int k = 0;
      for (int i = 0; i < BOARD_SIZE; i++) {
         for (int j = 0; j < BOARD_SIZE; j++) {
            board[i][j] = letterArray[k];
            k++;
         }
      }
   }
   
   /**
    * @return boardToString.
    */
   public String getBoard() {
      String boardToString = "";
      int x = board.length;
      int k = 0;
      for (int i = 0; i < BOARD_SIZE; i++) { 
         for (int j = 0; j < BOARD_SIZE; j++) {
            boardToString += board[i][j] + "   ";
            k++;
         }
         boardToString += "\n";
      
      }
      
      return boardToString;
   }
   
   public SortedSet<String> getAllValidWords(int minimumWordLength) {
      SortedSet<String> s = new TreeSet<String>();
      if (minimumWordLength < 1) {
         throw new IllegalArgumentException("minimumWordLength should be >= 1");
      }
      
      if (lexicon.size() == 0) {
         throw new IllegalStateException("loadLexicon has not been called.");
      }
      
      // loop through entire lexicon 
         // isOnBoard = true?
         // .add to SortedSet s
       
         
      for (String w : lexicon) {
         if (w.length() >= minimumWordLength) {
            if (isOnBoard(w).size() >= 1) {
               if (w.length() >= minimumWordLength) {
                  s.add(w);
               }
            }
         }
      }
      
      
      
      return s;
   }
   
   public int getScoreForWords(SortedSet<String> words, int minimumWordLength) {
      // iterate over loop of words found (SortedSet words)
         // make sure it meets min word length requirement (>= minimumWordLength)
         // make sure it's a valid for (isValidWord = true)
         // make sure it's on the board (isOnBoard = true)
      
      if (minimumWordLength < 1) {
         throw new IllegalArgumentException("minimumWordLength should be >= 1");
      }
      
      if (lexicon == null) {
         throw new IllegalStateException("loadLexicon has not been called.");
      }
      
      
      int score = 0;
         
      for (String w : words) {
         if (w.length() >= minimumWordLength) {
            if (isValidWord(w)) {
               if (!(isOnBoard(w) == null)) {
                     // calculate score. 1 + (word length - minimum length)
                  score += 1 + (w.length() - minimumWordLength);
               }
            }
         }
      }
      
      
      
      return score;
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
 * @param wordToCheck
 * @return path.
 */
   public List<Integer> isOnBoard(String wordToCheck) {
      // checks if param word is on the board (can be put together with the
      // strings in the array)
      //
      visited = new boolean[BOARD_SIZE][BOARD_SIZE];
      // 1) initialize an empty list
      List<Integer> path = new ArrayList<>();
      StringBuilder wordSoFar = new StringBuilder();
      wordSoFar.append("");
      
      // 2) launch dfs (from potentially every position on the board)
      
      // for each board position, 
      
      for (int i = 0; i < BOARD_SIZE; i++) {
         for (int j = 0; j < BOARD_SIZE; j++) {
            if (wordToCheck.startsWith(board[i][j])) {
               if  
                  (dfsOneWord(i, j, wordToCheck, 
                  wordSoFar, path));
                  
            }
         }
      }
      
         // if the string at this position is a prefix for wordToCheck
         // aka if wordToCheck starts with the contents of the current board position
         
               // if (dfsOneWord());
      
      
      
      return path;
   }
   
   private boolean dfsOneWord(int i, int j, String wordToCheck, 
               StringBuilder wordSoFar, List<Integer> path) {
               // fields 
   
      //GridSearcher gs = new GridSearcher();
      Position pos = new Position(i, j);
      
      
      // check if the position on the board (is it valid?) if not, return false
      if (!(pos.isValid(pos))) {
         return false;
      }
      
      // check if you already visited this position. if yes, return false.
      if (visited[pos.x][pos.y]) {
         return false;
      }
      
      // is this a dead end? if word so far is CAX for CATALOG, dead end, and need to back up (return false). 
      if (!(wordToCheck.startsWith(wordSoFar.toString()))) {
         return false;
      }
      
      // we haven't been here before && wordSoFar is a prefix of wordToCheck. so far so good. continue search. 
      // visit and process this position
         // 1) mark it visited
      pos.visit(pos);
         // 2) add the contents of the current board position to wordSofar (concat to the string)
      wordSoFar.append(board[i][j]);
         // 3) add row major (index) to path List
      int index = (int) (i * BOARD_SIZE) + (j);
      path.add(index);
         
      // if ( wordSoFar.equals(wordToCheck))  return true;
      if (wordSoFar.toString().equals(wordToCheck)) {
         return true;
      }
      // continue search from neighbors
         // for each neighbor
         
         
      for (Position p : pos.neighbors()) {
       // if (dfsOneWord(i (new row index), j (new column index), wordToCheck, wordSoFar, path));
               // return true;
         if (dfsOneWord(p.x, p.y, wordToCheck, wordSoFar, path)) {
            return true;
         }
      }
            
      // if you reach this point, clean up and backtrack. 
      // 1) mark current position as unvisited
      pos.unvisit(pos);
      
      
      // 2) remove the contents of the current board position from wordSoFar
      // take wordSoFar (hoq) and remove the characters at the current board position from it, so length-- sort of
      String temp =  wordSoFar.substring(0, (wordSoFar.length() - (board[i][j].length())));
      
      wordSoFar.replace(0, wordSoFar.length(), temp); 
      
      // 3) remove row major (index) to path List
      path.remove(path.size() - 1);
      
    
     
      return false; 
      
   }
   
   

            
   class Position {
      int[][] grid; // represents the search space, record order visited on this
      // t/f as to whether the cells have been visited
      int width = BOARD_SIZE;
      int height = BOARD_SIZE;
      final int MAX_NEIGHBORS = 8; 
      int order; // counter that keeps track of the order explored.
       
      
      int x;
      int y;
         
        // constructor for Position object x,y   
      public Position(int x, int y) {
         this.x = x;
         this.y = y;
         
      }   
      
      private boolean isValid(Position p) {
         return (p.x >= 0) && (p.x < BOARD_SIZE) &&
               (p.y >= 0) && (p.y < BOARD_SIZE);
      }
    
            
      @Override
         public String toString() {
         return "(" + x + ", " + y + ")";
      }
        
      public Position[] neighbors() {
         Position[] nbrs = new Position[MAX_NEIGHBORS];
         int count = 0;
         Position p;
            // generate all ___ neighbor positions
            // add to return value if valid
         for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
               if (!((i ==0) && (j == 0))) {
                  p = new Position(x + i, y + j);
                  if (isValid(p)) {
                     nbrs[count++] = p;
                  }
               }
            }
         }
            
         return Arrays.copyOf(nbrs, count);
      }
         
      
         
      //private boolean isVisited(Position p) {
         //return visited[p.x][p.y];
      //}
         
      private void visit(Position p) {
         visited[p.x][p.y] = true;
      }
         
      private void unvisit(Position p) {
         visited[p.x][p.y] = false;
      }
         
      private void process(Position p) {
         grid[p.x][p.y] = order++;
      }
        
   }
      
   //}
   
   /**
 * @param args.
 */
   public static void main(String[] args) {
      
      WordSearchGame game = WordSearchGameFactory.createGame();
      game.loadLexicon("wordfiles/words.txt");
      game.setBoard(new String[]{"E", "E", "C", "A", "A", "L", "E", "P", "H", 
                                 "N", "B", "O", "Q", "T", "T", "Y"});
      System.out.print("LENT is on the board at the following positions: ");
      System.out.println(game.isOnBoard("LENT"));
      SortedSet<String> s = new TreeSet<>();
      s.add("LENT");
      
      System.out.println(game.getScoreForWords(s, 2));
      System.out.print("POPE is not on the board: ");
      System.out.println(game.isOnBoard("POPE"));
      System.out.println("All words of length 6 or more: ");
      System.out.println(game.getAllValidWords(6));
   
      
   }

}
   
import java.io.File;
import java.io.FileNotFoundException;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Provides an implementation of the WordLadderGame interface. The lexicon
 * is stored as a HashSet of Strings.
 *
 * @author Molly Anderson (MPA0012@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2019-02-26
 */
public class Doublets implements WordLadderGame {

   // The word list used to validate words.
   // Must be instantiated and populated in the constructor.
   private HashSet<String> lexicon;


   /**
    * Instantiates a new instance of Doublets with the lexicon populated with
    * the strings in the provided InputStream. The InputStream can be formatted
    * in different ways as long as the first string on each line is a word to be
    * stored in the lexicon.
    */
   public Doublets(InputStream in) {
      try {
         lexicon = new HashSet<String>();
         Scanner s =
            new Scanner(new BufferedReader(new InputStreamReader(in)));
         while (s.hasNext()) {
            String str = s.next();
            /////////////////////////////////////////////////////////////
            // INSERT CODE HERE TO APPROPRIATELY STORE str IN lexicon. //
            lexicon.add(str.toUpperCase());
            /////////////////////////////////////////////////////////////
            s.nextLine();
         }
         in.close();
      }
      catch (java.io.IOException e) {
         System.err.println("Error reading from InputStream.");
         System.exit(1);
      }
   }


   //////////////////////////////////////////////////////////////
   // ADD IMPLEMENTATIONS FOR ALL WordLadderGame METHODS HERE  //
   //////////////////////////////////////////////////////////////

   public int getHammingDistance(String str1, String str2) {
      int hd = 0; 
      
      if ((str1.length() - str2.length()) != 0) {
         return -1;
      }
      
      for (int i = 0; i < str1.length(); i++) {
         int y = str1.charAt(i);
         int z = str2.charAt(i);
         
         if (y != z) {
            hd++;
         }
      }
      
      
      return hd;
   }
   
   public List<String> getMinLadder(String start, String end) {
      List<String> ladderList = new ArrayList<>();
      markAllUnvisited();
      Position start = new Position(x, y);
      if (isValid(start)) {
         order = 1;
         bfsMemory(start);
      }
      
      
      return ladderList;
   }
   
   private void bfsMemory(Position start) {
   
   // 2d area to search
   private int[][] grid;

   // visited positions in the search area
   private boolean[][] visited;

   // dimensions of the search area
   private int width;
   private int height;

   // number of neighbors, degrees of motion
   private final int MAX_NEIGHBORS = 8;

   // order in which positions are visited.
   // used to enumerate positions in the grid.
   private int order;

   /**
    * Construct a new GridSearcher object initialized
    * with a default grid.
    */
   public GridSearcher() {
      this(new int[][]{{0,0},{0,0}});
   }

   
      Deque<Node> queue = new ArrayDeque<>();
      visit(start);
      process(start);
      queue.addLast(new Node(start, null));
      while (!queue.isEmpty()) {
         Node n = queue.removeFirst();
         Position position = n.position;
         for (Position neighbor : position.neighbors()) {
            if (!isVisited(neighbor)) {
               visit(neighbor);
               process(neighbor);
               queue.addLast(new Node(neighbor, n));
            }
         }
      }
   }


   /**
    * Constructs a node for linking positions together.
    */
   private class Node {
      Position position;
      Node predecessor;
   
      public Node(Position p, Node pred) {
         position = p;
         predecessor = pred;
      }
   }
   
   public List<String> getNeighbors(String word) {
      List<String> neighborsList = new ArrayList<>();
      word = word.toUpperCase();
      StringBuilder temp = new StringBuilder(word);
      // outer loop iterates over whole word. incrementing charAt each time
      //int i = 0;
      //char j = 'A';
      for (int i = 0; i < word.length(); i++) {
         
         // inner loop iterates over charAt(i)
         for (char j = 'A'; j <= 'Z'; j++) {
            
            temp.setCharAt(i, j);  
            String strTemp = temp.toString();
            if (isWord(strTemp) && (getHammingDistance(word, strTemp) == 1)) {
               neighborsList.add(strTemp);
            }
            if (j == 'Z') {
               temp.setCharAt(i, word.charAt(i));
            }
         }
      }
      
      
      return neighborsList;
   }
   
   public int getWordCount() {
      // get size of lexicon
      int wordCount = lexicon.size();
      
      return wordCount;
   }
   
   public boolean isWord(String str) {
      if (str == null) {
         throw new IllegalArgumentException("input is null");
         
      }
      
      if (lexicon == null) {
         throw new IllegalStateException("loadLexicon has not been called");
      }
      
      str = str.toUpperCase();
      
      if (lexicon.contains(str)) {
         return true;
      }
      
      
      return false;
   }
   
   public boolean isWordLadder(List<String> sequence) {
      // verify isWord
      sequence.toArray();
      
      if (sequence == null) {
         return false;
      }
      
      if (sequence.size() == 0) {
         return false;
      }
      
      for (int i = 0; i < sequence.size() - 1; i++) {
         if (!((isWord(sequence.get(i))) && (getHammingDistance(sequence.get(i), 
                                          sequence.get(i + 1)) == 1))) {
                                          
            return false;
         }
      }
      //for (String s : sequence) {
         //if (isWord(s) && (getHammingDistance(s, s.next()) == 1)) {
            
         //}
      //}         
      // verify hd == 1
      
      return true;
   }
   
   

   
     /** Drives execution. */
   public static void main(String[] args) throws FileNotFoundException {
      WordLadderGame doublets = new Doublets(new FileInputStream(new File("txt-files/sowpods.txt")));
      
      
   
      System.out.println(doublets.getHammingDistance("tiger", "tiger"));
      System.out.println(doublets.getHammingDistance("tiger", "eagle"));
      System.out.println(doublets.getHammingDistance("war", "eagle"));
      System.out.println(doublets.getHammingDistance("barner", "bammer"));
   
      System.out.println(doublets.isWord("tiger"));
      System.out.println(doublets.isWord("eagle"));
      System.out.println(doublets.isWord("aubie"));
   
      System.out.println(doublets.getWordCount());
   
      System.out.println(doublets.isWordLadder(Arrays.asList("cat", "cot", "zot", "dot")));
      System.out.println(doublets.isWordLadder(Arrays.asList("cat", "cot", "pot", "dot")));
   
      System.out.println(doublets.getNeighbors("tiger"));
   
      //System.out.println(doublets.getMinLadder("cat", "hat"));
   }


}


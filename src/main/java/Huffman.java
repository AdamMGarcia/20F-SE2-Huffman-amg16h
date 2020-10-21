import java.util.stream.Node;

import sun.rmi.runtime.NewThreadAction;

/******************************************************************************
 *  Author : amg16h Adam Garcia
 *  Course : CS375 Software Engineering II
 *  Date   : Fall 2020
 *
 *  Program: Huffman
 *  File   : Huffman.java
 *  Compile: 
 *  Execute: 
 * 
 *  Note   : Copies everything from stdin to stdout. 
 *
 * 
 ******************************************************************************/

import java.io.File;

public class Huffman {

   // helper class
   private static class Node implements Comparable<Node> {
      private final char character;
      private final int frequency;
      private final Node left, right;

      // Node points to left and right nodes
      Node(char ch, int freq, Node left, Node right) {
         this.frequency = freq;
         this.character = ch;
         this.left = null;
         this.right = null;
      }

      // check to see if Node is leaf Node
      private boolean isLeaf() {
         return (left == null && right == null);
      }

      public int compare(Node other) {
         return this.frequency - other.frequency;
      }
   }

   public void compress(String sourceFile, String compressedFile) {
      // creates new file destination
      fileChecker(sourceFile, compressedFile);

      // read input from sourceFile and store in array

      // comparison
         // find the two smallest values in the tri
         // add them together for value (frequency)
         
      // create a new huffman object
         // assign calcuate frequency to new huffman object

      // point huffman object to current 2 smallest Nodes

   }

   // build the Huffman trie given frequencies
   private static Node buildTrie(int[] freq) {

   }

   // write bitstring-encoded trie to standard output
   private static void writeTrie(Node x) {

   }

   // make a lookup table from symbols and their encodings
   private static void buildCode(String[] st, Node x, String s) {

   }

   // dont need for this project
   // expand Huffman-encoded input from standard input and write to standard output
   public static void expand() {

   }

   private static Node readTrie() {

   }

   // destroys entire trie
   public void reset() {

   }

   // returns true if oldFile exists and newFile exists and is empty, otherwise returns false
   private static boolean fileChecker(String sourceFile, String compressedFile) {
      try {
         File fileSrc = new File(sourceFile);
         File fileDest = new File(compressedFile);

         if(fileSrc.exists()) {
            if(!fileDest.exists()){
               fileDest.createNewFile();
            } else {
               // delete existing file and recreate empty
               fileDest.delete();
               fileDest.createNewFile();
            }
         } else {
            System.out.println("Source file does not exist.");
            return false;
         }
      } catch (Exception e) {
         System.out.println("Could not compress file");
         return false;
      }
      return true;
   }

   public static void main(String[] args) {

   }
}
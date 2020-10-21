/******************************************************************************
 *  Author : amg16h Adam Garcia
 *  Course : CS375 Software Engineering II
 *  Date   : Fall 2020
 *
 *  Program: HuffmanSE2
 *  Compile: javac HuffmanSE2.java
 *  Execute: java HuffmanSE2.java  uncompressed-file-name  compressed-file-name
 * 
 *  Note   : Uses Huffman encoding to compress a file.
 * 
 * reference used from: https://algs4.cs.princeton.edu/code/edu/princeton/cs/algs4/Huffman.java.html
 * Authors : Robert Sedgewick, Kevin Wayne
 * 
 ******************************************************************************/

import java.io.File;
import java.io.FileReader;
import java.util.stream.*;
import sun.rmi.runtime.NewThreadAction;

public class Huffman {

   // helper Node class
   private static class Node {
      private final char character;
      private final int frequency;
      private final Node left, right;

      // constructor
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

      // compare frequency to other nodes
      public int compare(Node other) {
         return this.frequency - other.frequency;
      }
   }



   public void compress(String sourceFile, String compressedFile) {
      
      // creates new file destination
      if (!fileChecker(sourceFile, compressedFile)) {
         return;
      }

      // read the input from file
      char[] input;
      try (FileReader fr = new FileReader(sourceFile)){
         int content;
         int i = 0;
         while((content = fr.read()) != -1) {
            input[i] = (char)content;
            i++;
         }
      } catch (Exception e) {
         System.out.println("Could not read from File");
         return;
      }

      // tabulate frequency counts
      int[] freq = new int[256];
      for (int i = 0; i < input.length; i++)
         freq[input[i]]++;

      // build Huffman trie
      Node root = buildTrie(freq);

      // build code table
      String[] st = new String[256];
      buildCode(st, root, "");

      // print trie for decoder
      writeTrie(root);
      //Systemn.out.println("writeTrie");

      // print number of bytes in original uncompressed message
     
      //Systemn.out.println("writing input length " + input.length);

      //Systemn.out.println("encoding... ");
      
      // use Huffman code to encode input
      for (int i = 0; i < input.length; i++) {
         String code = st[input[i]];
         //Systemn.out.println("Char " + input[i] + " ");
         for (int j = 0; j < code.length(); j++) {
            if (code.charAt(j) == '0') {
              //Systemn.out.println("0");
            }
            else if (code.charAt(j) == '1') {   
               //Systemn.out.println("1");
            }
            else throw new RuntimeException("Illegal state");
         }
         //Systemn.out.println("");
      }
   }

   // build the Huffman trie given frequencies
   private static Node buildTrie(int[] freq) {
      // use priortiy queue
      Node newNode= new Node();
      return newNode;
   }

   // write encoded trie to standard output
   private static void writeTrie(Node x) {

   }

   // make a lookup table from symbols and their encodings
   private static void buildCode(String[] st, Node x, String s) {
      if(!x.isLeaf()) {
         buildCode(st, x.left, s + "0");
         buildCode(st, x.right, s + "1");
      } else {
         st[toString(x.ch)] = s;
      }
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
            //System.out.println("Source file does not exist.");
            return false;
         }
      } catch (Exception e) {
         //System.out.println("Could not compress file");
         return false;
      }
      return true;
   }
}
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
import java.io.FileReader;
import java.util.stream.*;
import sun.rmi.runtime.NewThreadAction;

public class Huffman {

   // helper class
   private static class Node {
      private final char character;
      private final int frequency;
      private final Node left, right;

      // constructor
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

      // comparison
         // find the two smallest values in the tri
         // add them together for value (frequency)
         
      // create a new huffman object
         // assign calcuate frequency to new huffman object

      // point huffman object to current 2 smallest Nodes

      //********************************************* */

      // read the input from file
      try (FileReader fr = new FileReader(sourceFile)){
         int content;
         while((content = fr.read()) != -1) {
            String s = (char)content;
         }
      } catch (Exception e) {
         System.out.println("Could not read from File");
         return;
      }

      // enter into a string
      char[] input = s.toCharArray();

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
      Systemn.out.println("writeTrie");

      // print number of bytes in original uncompressed message
      BinaryStdOut.write(input.length);
      Systemn.out.println("writing input length " + input.length);

      Systemn.out.println("encoding... ");
      // use Huffman code to encode input
      for (int i = 0; i < input.length; i++) {
         String code = st[input[i]];
         Systemn.out.println("Char " + input[i] + " ");
         for (int j = 0; j < code.length(); j++) {
            if (code.charAt(j) == '0') {
               BinaryStdOut.write(false);
               Systemn.out.println("0");
               }
               else if (code.charAt(j) == '1') {
                  BinaryStdOut.write(true);
                  Systemn.out.println("1");
               }
               else throw new RuntimeException("Illegal state");
           }
         Systemn.out.println("");
       }

       // flush output stream
       BinaryStdOut.flush();
   }

   // build the Huffman trie given frequencies
   private static Node buildTrie(int[] freq) {
      // use priortiy queue
      Node newNode= new Node();
      return newNode;
   }

   // write bitstring-encoded trie to standard output
   private static void writeTrie(Node x) {

   }

   // make a lookup table from symbols and their encodings
   private static void buildCode(String[] st, Node x, String s) {
      if(!x.isLeaf()) {
         buildCode(st, x.left, s + "0");
         buildCode(st, x.right, s + "1");
      } else {
         st[x.ch] = s;
      }
   }

   // dont need for this project
   // expand Huffman-encoded input from standard input and write to standard output
   public static void expand() {

   }

   // private static Node readTrie() {
   //    Node newNode = new Node(char ch, int freq, Node left, Node right);
      
   //    if(isLeaf) {
   //       char x = purple;
   //       return new Node(x, -1, null, null);
   //    } else {
   //       return new Node('\0', -1, readTrie(), readTrie());
   //    }
   // }

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

   // public static void main(String[] args) {
   //    // checks terminal input
   //    if(args.length != 2) {
	// 		System.out.println("Incorrect number of filenames entered. Two filenames are required.");
	// 		return;
	// 	}

	// 	String oldFile = args[0];
	// 	String newFile = args[1];
		
   //    // compress file
	// 	try {
	// 		compress(oldFile, newFile);
	// 		System.out.println("Sucessfully compressed file!");
	// 	} catch (Exception e) {
	// 		System.out.print("code broke\n");
	// 	}
   // }
}
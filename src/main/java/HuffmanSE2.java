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
import java.util.PriorityQueue;

public class HuffmanSE2 {

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
   }
   
   // used to output errors and updates
   // because System.out.print does not work
   public static void err_print(String msg) {
	   System.err.print(msg);
   }

   public static void err_println(String msg) {
		System.err.println(msg);
   }

   public static void compress(String sourceFile, String compressedFile) {
      
      // creates new file destination
      if (!fileChecker(sourceFile, compressedFile)) {
         return;
      }

      //////////////////// OG HUFFMAN
      // read the input
      String s = BinaryStdIn.readString();
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
      err_println("writeTrie");

      // print number of bytes in original uncompressed message
      BinaryStdOut.write(input.length);
      err_println("writing input length " + input.length);

      err_println("happily encoding... ");
      // use Huffman code to encode input
      for (int i = 0; i < input.length; i++) {
         String code = st[input[i]];
         err_print("Char " + input[i] + " ");
         for (int j = 0; j < code.length(); j++) {
            if (code.charAt(j) == '0') {
               BinaryStdOut.write(false);
               err_print("0");
            }
            else if (code.charAt(j) == '1') {
               BinaryStdOut.write(true);
               err_print("1");
            }
            else throw new RuntimeException("Illegal state");
         }
         err_println("");
      }

      // flush output stream
      BinaryStdOut.flush();
   }



   private static Node buildTrie(int[] freq) {

      // initialze priority queue with singleton trees
      MinPQ<Node> pq = new MinPQ<Node>();
      for(char i = 0; i < 256; i++)
         if(freq[i] > 0)
            pq.insert(new Node(i, freq[i], null, null));

      // merge two smallest trees
      while(pq.size() > 1) {
         Node left  = pq.delMin();
         Node right = pq.delMin();
         Node parent = new Node('\0', left.frequency + right.frequency, left, right);
         err_println("buildTrie parent " + left.frequency + " " + right.frequency);
         pq.insert(parent);
      }
      return pq.delMin();
  }


   // write encoded trie to standard output
   private static void writeTrie(Node x) {
      if (x.isLeaf()) {
          BinaryStdOut.write(true);
          BinaryStdOut.write(x.character);
         err_println("T" + x.character);
          return;
      }
      BinaryStdOut.write(false);
      err_print("F");

      writeTrie(x.left);
      writeTrie(x.right);
  }

   // make a lookup table from symbols and their encodings
   private static void buildCode(String[] st, Node x, String s) {
      if(!x.isLeaf()) {
         buildCode(st, x.left, s + "0");
         buildCode(st, x.right, s + "1");
      } else {
         st[x.character] = s;
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
            err_println("Source file does not exist");
            return false;
         }
      } catch (Exception e) {
         err_println("Could not compress file");
         return false;
      }
      return true;
   }

   public static void main(String[] args)
   {
		// checks terminal input
         if(args.length != 2) {
			System.out.println("Incorrect number of filenames entered. Two filenames are required.");
			return;
		}

		String oldFile = args[0];
      String newFile = args[1];
      
      compress(oldFile, newFile);
   }
}
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
 * 
 ******************************************************************************/

import java.io.IOException;

public class HuffmanSE2 {

    public static void main(String[] args)
    {
		// checks terminal input
        if(args.length != 2) {
			System.out.println("Incorrect number of filenames entered. Two filenames are required.");
			return;
		}

		String oldFile = args[0];
		String newFile = args[1];
		
        // calls Huffman
		try {
			Huffman yeet = new Huffman();
			yeet.compress(oldFile, newFile);
			System.out.println("Sucessfully compressed file!");
		} catch (Exception e) {
			System.out.print("code broke\n");
		}
    }
}
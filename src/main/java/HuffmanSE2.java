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

public class Main {

    public void main(String[] args)
    {
        if(args.length != 2) {
			System.out.println("Incorrect number of filenames entered. Two filenames are required.");
			return;
		}

        // calls Huffman
		try {
			Huffman yeet = new Huffman();
			yeet.compress();
		} catch (Exception e) {
			System.out.print("code broke\n");
		}
    }
}
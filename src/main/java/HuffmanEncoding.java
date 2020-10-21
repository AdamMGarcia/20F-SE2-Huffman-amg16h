/******************************************************************************
 *  Author : amg16h Adam Garcia
 *  Course : CS375 Software Engineering II
 *  Date   : Fall 2020
 *
 *  Program: CopyStdIn 
 *  Compile: javac CopyStdIn.java
 *  Execute: java CopyStdIn
 * 
 *  Note   : Copies everything from stdin to stdout. 
 *
 * 
 ******************************************************************************/

import java.io.IOException;

public class HuffmanEncoding {

    public static void main(String[] args)
    {
        int i;
        do {  
            System.out.write(i = System.in.read());
        } while (i != -1);
    }

    public static void huffman() {
        
    }
}
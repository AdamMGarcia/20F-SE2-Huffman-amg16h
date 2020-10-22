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
 ******************************************************************************/

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class HuffmanTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    // reads file completly into byte array
    public static byte[] toByteArray(String fileName)
   {
       try {
            Path path = Paths.get(fileName);
            byte[] data = Files.readAllBytes(path);
            return data;
       } catch (IOException e) {
            byte[] fail = new byte[0];
            return fail;
       }
   }

    // The file to be compressed is empty
    @Test
    public void test1() throws IOException {
        String[] args = {"test1.txt", "test1Dest.txt"};

        Huffman.main(args);
        assertEquals(toByteArray("test1Solution.txt"), toByteArray(args[1]));
    }

    // Normal Case
    @Test
    public void test2() throws IOException {
        String[] args = {"test2.txt", "test2Dest.txt"};

        Huffman.main(args);
        assertEquals(toByteArray("test2Solution.txt"), toByteArray(args[1]));
    }

    // The file to be compressed does not exist
    @Test
    public void test3() throws IOException {
        String[] args = {"test3.txt", "test3Dest.txt"};

        Huffman.main(args);
        assertEquals(toByteArray("test3Solution.txt"), toByteArray(args[1]));
    }

    // The file to be compressed contains many things
    @Test
    public void test4() throws IOException {
        String[] args = {"test4.txt", "test4Dest.txt"};

        Huffman.main(args);
        assertEquals(toByteArray("test4Solution.txt"), toByteArray(args[1]));
    }

    // The user passes in the wrong amount of arguments
    @Test
    public void test5() throws IOException {
        String[] args = {"test5.txt", "test5Dest.txt", "yeet"};

        Huffman.main(args);
        assertEquals(toByteArray("test5Solution.txt"), toByteArray(args[1]));
    }

    // The file to be compressed contains one really long word with no spaces
    @Test
    public void test6() throws IOException {
        String[] args = {"test6.txt", "test6Dest.txt"};

        Huffman.main(args);
        assertEquals(toByteArray("test6Solution.txt"), toByteArray(args[1]));
    }

    // The file to be compressed contains only lowercase or only uppercase characters
    @Test
    public void test7() throws IOException {
        String[] args = {"test7.txt", "test7Dest.txt"};

        Huffman.main(args);
        assertEquals(toByteArray("test7Solution.txt"), toByteArray(args[1]));
    }
}
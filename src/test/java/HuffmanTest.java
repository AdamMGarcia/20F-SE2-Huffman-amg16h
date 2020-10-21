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

/*
    The file to be compressed is empty
    Normal Case
    The file to be compressed does not exist
    The file to be compressed contains many things
    The user passes in the wrong amount of arguments
    The file to be compressed contains one really long word with no spaces
    The file to be compressed contains only lowercase or only uppercase characters
    Any other relevant edge cases you can think of
*/

public class HuffmanTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    Huffman huffman;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        huffman.reset();
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    //***//  change to checkBytes 
    // compares each byte of each file to see if they are the same
    public void inOut(String tosend) throws IOException {
        ByteArrayInputStream in = new ByteArrayInputStream(tosend.getBytes());
        System.setIn(in);

        // now call main
        CopyStdIn.main(new String[] {"Yes"});

        // reset to normal stdlin
        System.setIn(System.in);

        // extra character at end, delete it
        String outs = outContent.toString();
        outs = outs.substring(0, outs.length() - 1);

        assertEquals("Checking stdout from stdin.", tosend, outs);
    }

    The file to be compressed is empty
    Normal Case
    The file to be compressed does not exist
    The file to be compressed contains many things
    The user passes in the wrong amount of arguments
    The file to be compressed contains one really long word with no spaces
    The file to be compressed contains only lowercase or only uppercase characters
    Any other relevant edge cases you can think of

    // The file to be compressed is empty
    @Test
    public void test1() throws IOException {
        String[] args = {"test1.txt", "test1Dest.txt"};

        HuffmanSE2.main(args);
        assertEquals(true, checkBytes(args));
    }

    // Normal Case
    @Test
    public void test2() throws IOException {
        String[] args = {"test2.txt", "test2Dest.txt"};

        HuffmanSE2.main(args);
        assertEquals(true, checkBytes(args));
    }

    // The file to be compressed does not exist
    @Test
    public void test3() throws IOException {
        String[] args = {"test3.txt", "test3Dest.txt"};

        HuffmanSE2.main(args);
        assertEquals(true, checkBytes(args));
    }

    // The file to be compressed contains many things
    @Test
    public void test4() throws IOException {
        String[] args = {"test4.txt", "test4Dest.txt"};

        HuffmanSE2.main(args);
        assertEquals(true, checkBytes(args));
    }

    // The user passes in the wrong amount of arguments
    @Test
    public void test5() throws IOException {
        String[] args = {"test5.txt", "test5Dest.txt"};

        HuffmanSE2.main(args);
        assertEquals(true, checkBytes(args));
    }

    // The file to be compressed contains one really long word with no spaces
    @Test
    public void test6() throws IOException {
        String[] args = {"test6.txt", "test6Dest.txt"};

        HuffmanSE2.main(args);
        assertEquals(true, checkBytes(args));
    }

    // The file to be compressed contains only lowercase or only uppercase characters
    @Test
    public void test7() throws IOException {
        String[] args = {"test7.txt", "test7Dest.txt"};

        HuffmanSE2.main(args);
        assertEquals(true, checkBytes(args));
    }
}
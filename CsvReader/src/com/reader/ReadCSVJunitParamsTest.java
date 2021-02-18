package com.reader;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.util.Scanner;

import org.junit.Test;

public class ReadCSVJunitParamsTest {
	
	 @Test
	    public void testCsvCount() throws IOException {
		 URL url = new URL("https://raw.githubusercontent.com/vamstar/challenge/master/Dataset3.csv");
	        assertEquals(52, ReaderCsv.fileRowCount(url));
	    }
	 
	 @Test
	    public void testCsvSize() throws IOException {
		 URL url = new URL("https://raw.githubusercontent.com/vamstar/challenge/master/Dataset3.csv");
	        assertEquals(BigInteger.valueOf(3441), ReaderCsv.fileSize(url));
	    }
	 
	 @Test
	    public void testCsvHeader() throws IOException {
		 URL url = new URL("https://raw.githubusercontent.com/vamstar/challenge/master/Dataset3.csv");
		 Scanner scan = new Scanner(url.openStream());
	        assertEquals(9, ReaderCsv.fileHeaders(scan));
	    }
}

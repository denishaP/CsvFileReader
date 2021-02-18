package com.reader;

import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Logger;

public class ReaderCsv {
	static Logger logger = Logger.getLogger(ReaderCsv.class.getName());

	public static void main(String[] args) throws Exception {
		// parsing a CSV file into Scanner class constructor
		URL url = new URL("https://raw.githubusercontent.com/vamstar/challenge/master/Dataset3.csv");
		Scanner scan = new Scanner(url.openStream());
		fileHeaders(scan);
		fileSize(url);
		fileRowCount(url);
		scan.close(); // closes the scanner
	}

	static int fileRowCount(URL url) throws IOException {
		Scanner scan = new Scanner(url.openStream());
		int rowCounter = 0;
		scan.useDelimiter("\\n");
		while (scan.hasNext()) // returns a boolean value
		{
			String next = scan.next();
			//System.out.println(next);
			rowCounter++;
		}
		System.out.println("The total number of rows in file including header are: " + rowCounter);
		return rowCounter;
	}

	static BigInteger fileSize(URL url) {
		System.out.println();
		BigInteger size = new BigInteger("1");
		HttpURLConnection conn;
		try {
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("HEAD");
			conn.getInputStream();
			// store size of file
			size = BigInteger.valueOf(conn.getContentLength());
			System.out.println("The Size of file is:" + size + " bytes");
			conn.getInputStream().close();
		} catch (Exception e) {
			System.out.println("Connection failed");
		}
		return size;
	}

	static int fileHeaders(Scanner scan) {
		scan.useDelimiter(";|\\n"); // sets the delimiter pattern
		int count =0;
		System.out.println("The Headers in the file are:");
		while (scan.hasNext()) // returns a boolean value
		{
			String next = scan.next();
			int d = 0;
			try {
				d = Integer.parseInt(next);

			} catch (NumberFormatException nfe) {
				System.out.print(next + " ");
				count++;
			}
			if (d != 0) {
				break;
			}
		}
		return count;
	}
}

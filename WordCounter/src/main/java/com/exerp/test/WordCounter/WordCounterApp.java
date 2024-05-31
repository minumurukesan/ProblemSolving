package com.exerp.test.WordCounter;

import java.util.Scanner;

import com.exerp.exception.IncorrectFilePathException;
import com.exerp.exception.IndexOutOfBoundException;
import com.exerp.exception.WordCounterException;

/**
 * 
 * @author Minu M Murukesan
 *
 */
public class WordCounterApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file path ..");
		String filePath = sc.nextLine();
		System.out.println("Enter how many top unique words to print..");
		int n = sc.nextInt();
		try {
			PriorityQueue<WordDTO> priorityQueue = WordCounter.countAndPrintUniqueWords(filePath);
			priorityQueue.printFirstNElements(n);
		} catch (IncorrectFilePathException | WordCounterException | IndexOutOfBoundException e) {
			System.out.println("Error occurred while processing the file : "+e.getMessage());
		} finally {
			sc.close();
		}
	}

}

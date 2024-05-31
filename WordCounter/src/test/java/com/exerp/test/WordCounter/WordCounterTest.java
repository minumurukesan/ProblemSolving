package com.exerp.test.WordCounter;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.exerp.exception.IncorrectFilePathException;
import com.exerp.exception.WordCounterException;

/**
 * Unit test for WordCounter.
 */
public class WordCounterTest 
{
	@Test
    public void testCountAndPrintUniqueWordsFileNotFoundFailure()
    {
		try {
			Assertions.assertThrows(IncorrectFilePathException.class,()->WordCounter.countAndPrintUniqueWords("tempest.t"));
		} catch (Exception e) {
			System.out.println("Exception :: "+e.getMessage());
		}
    }
	
	@Test
    public void testCountAndPrintUniqueWordsWordCounterExcpetionFailure()
    {
		try {
			Assertions.assertThrows(WordCounterException.class,()->WordCounter.countAndPrintUniqueWords("abc.txt"));
		} catch (Exception e) {
			System.out.println("Exception :: "+e.getMessage());
		}
    }
	
	@Test
	public void testCountAndPrintUniqueWordsSuccess() {
		try {
			PriorityQueue<WordDTO> pq = WordCounter.countAndPrintUniqueWords("tempest.txt");
			assertNotNull(pq);
			assertTrue(pq.contains(new WordDTO("the",513)));
			assertFalse(pq.contains(null));
			assertFalse(pq.contains(new WordDTO("",0)));

		}catch(Exception e) {
			System.out.println("Exception :: "+e.getMessage());
		}
	}
	
}

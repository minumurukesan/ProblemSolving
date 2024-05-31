package com.exerp.test.WordCounter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import com.exerp.exception.IncorrectFilePathException;
import com.exerp.exception.WordCounterException;
/**
 * 
 * @author Minu M Murukesan
 *
 */
public class WordCounter {

	/**
	 * Find count of each word in a text file and print n elements with high priority
	 * @param filePath
	 * @param n
	 * @return PriorityQueue<WordDTO>
	 * @throws IncorrectFilePathException 
	 * @throws WordCounterException 
	 */
	public static PriorityQueue<WordDTO> countAndPrintUniqueWords(String filePath) throws IncorrectFilePathException, WordCounterException {
		Map<String, Integer> wordCount = new HashMap<>();
		PriorityQueue<WordDTO> priorityQueue = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] words = line.split("\\s+");
				for (String word : words) {
					String cleanedWord = word.replaceAll("[^a-zA-Z0-9'-]", "").toLowerCase();
					if (!cleanedWord.isEmpty()) {						
						int value = (wordCount.containsKey(cleanedWord))? wordCount.get(cleanedWord)+1:1;					
						wordCount.put(cleanedWord, value);
					}
				}
			}

			PriorityQueue<WordDTO> pq = new PriorityQueue<WordDTO>(wordCount.size()+1);
			wordCount.entrySet().stream().forEach(w-> pq.insert(w.getKey(), w.getValue()));;
			priorityQueue = pq;

		} catch (FileNotFoundException e) {
			if (!isCorrectFilePath(filePath)) {
				throw new IncorrectFilePathException("Incorrect filename : " + filePath );
			} else {
				throw new WordCounterException("File not found : "+e.getMessage());
			}
		} catch (Exception e) {
			throw new WordCounterException("File word processing failed due to : "+e.getMessage());
		}
		return priorityQueue;
	}

	/**
	 * Checks whether the file path is valid text file or not.
	 * @param filePath
	 * @return
	 */
	private static boolean isCorrectFilePath(String filePath) {
		return (filePath.contains(".txt"));
	}

}

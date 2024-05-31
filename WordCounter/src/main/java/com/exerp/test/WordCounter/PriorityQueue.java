package com.exerp.test.WordCounter;

import com.exerp.exception.IndexOutOfBoundException;
/**
 * 
 * @author Minu M Murukesan
 *
 */
public class PriorityQueue<T> { 
	private WordDTO[] heap; 
	private int heapSize, capacity;

	/** Constructor **/
	public PriorityQueue(int capacity)
	{    
		this.capacity = capacity;
		heap = new WordDTO[this.capacity];
		heapSize = 0;
	}
	/** function to clear **/
	public void clear()
	{
		heap = new WordDTO[capacity];
		heapSize = 0;
	}
	/** function to check if empty **/
	public boolean isEmpty()
	{
		return heapSize == 0;
	}
	/** function to check if full **/
	public boolean isFull()
	{
		return heapSize == capacity - 1;
	}
	/** function to get Size **/
	public int size()
	{
		return heapSize;
	}
	/** function to insert entry **/
	public void insert(String word, int count)
	{
		WordDTO wordDto = new WordDTO(word, count);

		heap[++heapSize] = wordDto;
		int pos = heapSize;
		while (pos != 1 && wordDto.getCount() > heap[pos/2].getCount())
		{
			heap[pos] = heap[pos/2];
			pos /=2;
		}
		heap[pos] = wordDto;    
	}
	/** function to remove entry **/
	public WordDTO remove()
	{
		int parent, child;
		WordDTO item, temp;
		if (isEmpty() )
		{
			System.out.println("Heap is empty");
			return null;
		}

		item = heap[1];
		temp = heap[heapSize--];

		parent = 1;
		child = 2;
		while (child <= heapSize)
		{
			if (child < heapSize && heap[child].getCount() < heap[child + 1].getCount())
				child++;
			if (temp.getCount() >= heap[child].getCount())
				break;

			heap[parent] = heap[child];
			parent = child;
			child *= 2;
		}
		heap[parent] = temp;

		return item;
	}

	/** function to print first n elements 
	 * @throws IndexOutOfBoundException **/
	public void printFirstNElements(int n) throws IndexOutOfBoundException {
		if(n>heapSize) {
			throw new IndexOutOfBoundException("Index exceeds the actual size");
		}
		for (int i = 0; i < n; i++) {
			WordDTO entry = this.remove();
			if (entry == null) {
				break;
			}
			System.out.println(entry.getWord() + " (" + entry.getCount() + ")");
		}
	}
	/** function to check whether an element is present or not **/
	public boolean contains(WordDTO wordDto) {
		if(null == wordDto || null == wordDto.getWord() || wordDto.getWord().isEmpty() | 0 == wordDto.getCount()) {
			return false;
		}
		int low = 1, high = heapSize;
		while (low <= high) {
			if(heap[low].equals(wordDto)) {
				return true;
			}
			low++;
		}
		return false;
	}
}

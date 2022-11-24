package sorting.n2;

import checkers.Exceptions;
import sorting.AbstractSorting;
import util.Util;

/**
 * - Insertion Sort is a sort by comparison algorithm 
 * and is a little better than bubble sort, however it can be useful in some situations.
 * - Example: if you have a sorted array and need to place an element in this array in an sorted way, 
 * Insertion Sort may be an option for that situation. (This is the concept of Insertion Sort)
 * 
 * @author Joseff
 *
 * @param <T>
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * - In this method we choose the first element as the pivot and from that people we will choose 
	 * the element after the pivot.
	 * - This second element must be inserted from the pivot element (on the left side of it). 
	 * - This process is carried out until the array is properly sorted.
	 * 
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		Exceptions.exceptionCheck(array.length,leftIndex, rightIndex);
		
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			int target = i; 
			int size = array[target].compareTo(array[target-1]);
			
			while (target != 0 && size < 0) {
				Util.swap(array, target, target-1);
				target--;
				if (target > 0) {
					size = array[target].compareTo(array[target-1]);
				}
			}
		}
	}
}

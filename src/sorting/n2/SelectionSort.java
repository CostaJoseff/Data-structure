package sorting.n2;

import checkers.Exceptions;
import sorting.AbstractSorting;
import util.Util;

/**
 * - Selection Sort is a Θ(n2).
 * - In this ordering, we choose the first element and define it as the supposed smallest element, 
 * we go through the entire array checking if there are smaller ones than it (if we find it, 
 * we substitute the smallest for this new value). At the end of the array we replace the pivot, 
 * which in this case is the first. after replacement, we guarantee that the smallest element will be 
 * in its proper place.
 * - After this routine, we advance the pivot.
 * 
 */
public class SelectionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * - In this case the pivot is chosen by the for loop index
	 * 
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		Exceptions.exceptionCheck(array.length,leftIndex, rightIndex);
		
		for (int i = 0; i < array.length; i++) {
			int smallest = i;
			
			for (int j = i + 1; j < array.length; j++) {
				if (array[j].compareTo(array[smallest]) < 0) {
					smallest = j;
				}
			}
			Util.swap(array, i, smallest);
		}
	}
}

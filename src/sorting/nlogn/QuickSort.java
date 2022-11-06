package sorting.nlogn;

import checkers.Exceptions;
import sorting.AbstractSorting;
import util.Util;

/**
 * Quick Sort is a comparison sort algorithm that uses the divide and conquer strategy.
 * This sort is n*logn in the best case but n² in the worst case.
 * This class use the recursive way to resolve the problem.
 * 
 * @author Joseff
 *
 * @param <T>
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * - The first contact with the class to sort the generic array.
	 * - This method throws the exceptions, if find, and calls the quickSort routine.
	 * - Sort once, placing pivot at correct index and separate array into two partitions.
	 * - After that, do the same thing on two new partitions.
	 * 
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int pivotIndex = quickSort(array, leftIndex, rightIndex);
			sort(array, leftIndex, pivotIndex - 1);
			sort(array, pivotIndex + 1, rightIndex);
		}
	}
	
	/**
	 * - quickSort is a straight to the point routine, doesn't use auxiliary methods in class.
	 * - In this method we choose the left index to be a pivot.
	 * - All elements smaller than the pivot are placed in a row next to the pivot, then the 
	 * last element is exchanged with the pivot (which will be in the first position) 
	 * ensuring that all elements smaller than it are before it, making it stay in your place.
	 * 
	 * @param array - The generic array that will be sorted.
	 * @param leftIndex - The first element of the partition
	 * @param rightIndex - The last element of the partition ( not necessarily == array.length )
	 * @return - The pivot, which will be the new last element for a partition 1 and the new first element
	 * for a partition 2.
	 */
	private int quickSort(T[] array, int leftIndex, int rightIndex) {
		int iPointer = leftIndex;
		
		for (int jPointer = iPointer + 1; jPointer <= rightIndex; jPointer++) {
			int result = array[jPointer].compareTo(array[leftIndex]);
			if (result < 0) {
				iPointer++;
				Util.swap(array, iPointer, jPointer);
			}
		}
		
		Util.swap(array, leftIndex, iPointer);
		
		return iPointer;
	}
}

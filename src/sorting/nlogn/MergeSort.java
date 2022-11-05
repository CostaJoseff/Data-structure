package sorting.nlogn;

import checkers.Exceptions;
import sorting.AbstractSorting;

/**
 * - Merge Sort is a comparison sort algorithm that uses the divide and conquer strategy.
 * - This sort is Θ(n∗logn) for better, worse and average cases.
 * - This class use the recursive way to resolve the problem.
 * 
 * @author Joseff
 *
 * @param <T>
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * - The first contact with the class to sort the generic array.
	 * - This method throws the exceptions, if find, and calls the mergeSort and merge routine.
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		Exceptions.exceptionCheck(array.length,leftIndex, rightIndex);
		mergeSort(array, leftIndex, rightIndex);
	}
	
	/**
	 * - The first routine method.
	 * - This method 'breaks' the array in small parts using only indexes to determine it.
	 * - The goal here is to get the smallest sorted array possible, in this case an array with
	 * only 1 index.
	 * 
	 * @param array - The generic array that will be sorted.
	 * @param leftIndex - Sorting start point
	 * @param rightIndex - Sorting end point
	 */
	private void mergeSort(T[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int middle = (leftIndex + rightIndex) / 2;
			mergeSort(array, leftIndex, middle);
			mergeSort(array, middle + 1, rightIndex);
			merge(array, leftIndex, middle, rightIndex);
		}
	}

	/**
	 * - Finally the compare routine.
	 * 
	 * - This method takes two sorted partitions and performs a merge, 
	 * resulting in the ordered union of the 2 partitions.
	 * 
	 * @param array - The generic array that will be sorted. There was no size change in this array.
	 * @param leftIndex - The first element of the partition 1
	 * @param middle - The first element of the partition 2
	 * @param rightIndex - The last element of the partition 2
	 */
	private void merge(T[] array, int leftIndex, int middle, int rightIndex) {
		T[] helper = (T[]) new Comparable[array.length];
		int index1 = leftIndex;
		int index2 = middle + 1;
		int indexHelper = leftIndex;
		for (int i = leftIndex; i <= rightIndex; i++) {
			helper[i] = array[i];
		}
		
		while (index1 <= middle && index2 <= rightIndex) {
			int result = helper[index1].compareTo(helper[index2]);
			if (result <= 0) {
				array[indexHelper] = helper[index1];
				index1++;
			} else {
				array[indexHelper] = helper[index2];
				index2++;
			}
			indexHelper++;
		}
		
		while (index1 <= middle) {
			array[indexHelper] = helper[index1];
			index1++;
			indexHelper++;
		}
		
		while (index2 <= rightIndex) {
			array[indexHelper] = helper[index2];
			index2++;
			indexHelper++;
		}
	}
}

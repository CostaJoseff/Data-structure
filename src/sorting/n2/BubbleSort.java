package sorting.n2;

import checkers.Exceptions;
import sorting.AbstractSorting;
import util.Util;

/**
 * - Here's the best way to find out the worst way to do something.
 * - Bubble Sort is a sort comparison algorithm that uses 'while true' 
 * to loop through the array over and over until it is properly sorted.
 * - This is your only routine to order.
 * - Because it is extremely inefficient, the utility of this sort is 
 * only to introduce someone to the universe of orderers.
 * 
 * @author Joseff
 *
 * @param <T>
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * - Checks the exceptions ( use this sort is a exception c: ).
	 * - Here is the only logic applied to this sort.
	 * 
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		Exceptions.exceptionCheck(array.length,leftIndex, rightIndex);
		
		boolean change = true;
		while (change) {
			change = false;
			for (int i = 0; i < array.length - 1; i++) {
				int result = array[i].compareTo(array[i+1]);
				if (result <= 0) {
					continue;
				}
				Util.swap(array, i, i+1);
				change = true;
			}
		}
	}
}

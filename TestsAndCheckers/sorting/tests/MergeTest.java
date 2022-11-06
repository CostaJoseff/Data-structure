package sorting.tests;

import org.junit.Before;
import org.junit.Test;

import sorting.nlogn.MergeSort;

public class MergeTest extends InitTest {

	@Before
	public void mergeSetUp() {
		this.sort = new MergeSort<Integer>();
	}
	
	@Test
	public void testArrayGigante() {
		preencheArray(100000);
		testeGlobal(arrayGigante, giganteOrdenado);
	}

}

package sorting.tests;

import org.junit.Before;
import org.junit.Test;

import sorting.n2.SelectionSort;

public class SelectionTest extends InitTest {

	@Before
	public void selectionSetUp() throws Exception {
		this.sort = new SelectionSort<Integer>();
	}

	@Test
	public void test() {
		preencheArray(40000);
		testeGlobal(arrayGigante, giganteOrdenado);
	}

}

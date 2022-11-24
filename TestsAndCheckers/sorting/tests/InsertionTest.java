package sorting.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sorting.n2.InsertionSort;

public class InsertionTest extends InitTest {

	@Before
	public void insertionSetUp(){
		this.sort = new InsertionSort<Integer>();
	}

	@Test
	public void test() {
		preencheArray(30000);
		testeGlobal(arrayGigante, giganteOrdenado);
	}

}

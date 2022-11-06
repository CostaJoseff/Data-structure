package sorting.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sorting.nlogn.QuickSort;

public class QuickTest extends InitTest{

	@Before
	public void quickSetUp() {
		this.sort = new QuickSort<Integer>();
	}

	@Test
	public void test() {
		preencheArray(1000000);
		testeGlobal(arrayGigante, giganteOrdenado);
	}
	
	@Test
	public void testExceptions() {
	}
	
	@Test
	public void testArrayVazio() {
	}

}

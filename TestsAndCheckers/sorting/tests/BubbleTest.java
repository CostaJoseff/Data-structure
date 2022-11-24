package sorting.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sorting.n2.BubbleSort;

public class BubbleTest extends InitTest {

	@Before
	public void bubbleSetUp(){
		this.sort = new BubbleSort<Integer>();
	}

	@Test
	public void test() {
		preencheArray(20000);
		testeGlobal(arrayGigante, giganteOrdenado);
	}

}

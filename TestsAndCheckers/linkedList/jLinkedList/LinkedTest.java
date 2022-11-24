package linkedList.jLinkedList;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import linkedList.JLinkedList;

public class LinkedTest<T> {
	
	JLinkedList<T> list;
	String str = "[1][4][66][36]";

	@Before
	public void setUp() {
		list = new JLinkedList<>();
	}
	
	private void feedList() {
		assertEquals(1, this.list.putLast((T) new Integer(1)));
		assertEquals(4, this.list.putLast((T) new Integer(4)));
		assertEquals(66, this.list.putLast((T) new Integer(66)));
		assertEquals(36, this.list.putLast((T) new Integer(36)));
	}
	
	private void testHTS(Integer head, Integer tail, int size) {
		assertEquals(head, this.list.head());
		assertEquals(tail, this.list.tail());
		assertEquals(size, this.list.size());
	}
	

	@Test
	public void testEmpty() {
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		assertNull(list.head());
		assertNull(list.tail());
		try {
			list.removeLast();
			fail("RuntimeException was not thrown");
		} catch (RuntimeException re) {}
	}
	
	@Test
	public void testAddRemoveOne() {
		assertEquals(1, this.list.putLast((T) new Integer(1)));
		assertFalse(this.list.isEmpty());
		assertEquals(1, this.list.head());
		assertEquals(1, this.list.tail());
		assertEquals(1, this.list.size());
		assertEquals(1, this.list.removeLast());
		testEmpty();
	}
	
	@Test
	public void testAddRemove() {
		feedList();
		
		assertFalse(this.list.isEmpty());
		testHTS(1, 36, 4);
		assertEquals(36, this.list.removeLast());
		testHTS(1, 66, 3);
		assertEquals(66, this.list.removeLast());
		testHTS(1, 4, 2);
		assertEquals(36, this.list.putLast((T) new Integer(36)));
		testHTS(1, 36, 3);
		assertEquals(36, this.list.removeLast());
		testHTS(1, 4, 2);
		assertEquals(4, this.list.removeLast());
		testHTS(1, 1, 1);
		assertEquals(1, this.list.removeLast());
		testHTS(null, null, 0);
	}
	
	@Test
	public void testContains() {
		feedList();
		assertFalse(this.list.contains((T) new Integer(888)));
		assertTrue(this.list.contains((T) new Integer(66)));
		assertTrue(this.list.contains((T) new Integer(1)));
		assertTrue(this.list.contains((T) new Integer(36)));
	}
	
	@Test
	public void testIndexOf() {
		feedList();
		assertEquals(-1, this.list.indexOf(null));
		assertEquals(-1, this.list.indexOf((T) new Integer(555)));
		assertEquals(0, this.list.indexOf((T) new Integer(1)));
		assertEquals(3, this.list.indexOf((T) new Integer(36)));
		assertEquals(2, this.list.indexOf((T) new Integer(66)));
	}
	
	@Test
	public void testElementAf() {
		feedList();
		assertEquals(null, this.list.elementAt(-88));
		assertEquals(null, this.list.elementAt(50));
		assertEquals(1, this.list.elementAt(0));
		assertEquals(36, this.list.elementAt(3));
		assertEquals(66, this.list.elementAt(2));
		assertEquals(null, this.list.elementAt(4));
	}
	
	@Test
	public void testPutOnIndex() {
		feedList();
		assertNull(this.list.putOnIndex(-1, (T) new Integer(7)));
		assertNull(this.list.putOnIndex(46, (T) new Integer(7)));
		assertEquals(str, this.list.toString());
		try {
			this.list.putOnIndex(46, null);
			fail("NullPointerException was not thrown");
		} catch (NullPointerException npe) {}
		assertEquals(7, this.list.putOnIndex(1, (T) new Integer(7)));
		str = "[1][7][4][66][36]";
		assertEquals(str, this.list.toString());
		assertEquals(50, this.list.putOnIndex(0, (T) new Integer(50)));
		str = "[50][1][7][4][66][36]";
		assertEquals(str, this.list.toString());
		assertEquals(50, this.list.putOnIndex(5, (T) new Integer(50)));
		str = "[50][1][7][4][66][50][36]";
		assertEquals(str, this.list.toString());
		assertEquals(50, this.list.putOnIndex(7, (T) new Integer(50)));
		str = "[50][1][7][4][66][50][36][50]";
		assertEquals(str, this.list.toString());
	}
	
	@Test
	public void testPutFirst() {
		feedList();
		assertNull(this.list.putFirst(null));
		assertEquals(4, this.list.putFirst((T) new Integer(4)));
		assertEquals(4, this.list.elementAt(0));
		assertEquals(123, this.list.putFirst((T) new Integer(123)));
		assertEquals(4, this.list.elementAt(1));
		assertEquals(123, this.list.elementAt(0));
	}
	
	@Test
	public void testRemoveAllBehindOfIndex() {
		feedList();
		assertEquals(str, this.list.toString());
		try {
			this.list.removeAllBehindOfIndex(-1);
		} catch (IndexOutOfBoundsException ioobe) {}
		try {
			this.list.removeAllBehindOfIndex(52);
		} catch (IndexOutOfBoundsException ioobe) {}
		
		this.list.removeAllBehindOfIndex(2);
		str = "[66][36]";
		assertEquals(str, this.list.toString());
		assertEquals(2, this.list.size());
		
		this.list.clear();
		assertEquals("", this.list.toString());
		feedList();
		str = "[1][4][66][36]";
		this.list.removeAllBehindOfIndex(0);
		assertEquals(str, this.list.toString());
		assertEquals(4, this.list.size());
		this.list.removeAllBehindOfIndex(4);
		assertEquals("", this.list.toString());
		assertEquals(0, this.list.size());
		try {
			this.list.removeAllBehindOfIndex(1);
		} catch (IndexOutOfBoundsException ioobe) {}
	}

}

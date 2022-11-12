package test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.Iterator;
import utilities.MyDLL;

class MyDLLTest {

	private MyDLL<String> dll;
	@BeforeEach
	void setUp() throws Exception {
		 dll= new MyDLL<String>();
	}

	@AfterEach
	void tearDown() throws Exception {
		dll.clear();
	}
	

	@Test
	void testSize() {
		dll.add("a");
		assertEquals( 1, dll.size());
	}

	@Test
	void testClear() {
		dll.add("a");
		dll.clear();
		assertEquals( 0, dll.size());
	}

	@Test
	void testAddIntE() {
		dll.add("a");
		dll.add("b");
		dll.add(1,"c");
		assertEquals( "c", dll.get(2));
		dll.add(0,"d");
		assertEquals( "d", dll.get(1));
		dll.add(4,"e");
		assertEquals( "e", dll.get(5));
	}

	@Test
	void testAddE() {
		dll.add("a");
		dll.add("b");
		assertEquals( "a", dll.get(1));
		assertEquals( "b", dll.get(2));
	}

	@Test
	void testAddAll() {
		dll.add("a");
		dll.add("b");
		MyDLL<String>	 dll2= new MyDLL<String>();
		dll2.add("c");
		dll2.add("d");
		dll.addAll(dll2);
		assertEquals( "c", dll.get(3));
		assertEquals( "d", dll.get(4));
		
	}

	@Test
	void testGet() {
		dll.add("a");
		assertEquals( "a", dll.get(1));
	}

	@Test
	void testRemoveInt() {
		dll.add("a");
		dll.add("b");
		assertEquals( "b", dll.remove(2));
		assertEquals( "a", dll.remove(1));
		dll.add("a");
		dll.add("b");
		assertEquals( "a", dll.remove(1));
		dll.add("c");
		dll.add("d");
		assertEquals( "c", dll.remove(2));
	}

	@Test
	void testRemoveE() {
		dll.add("a");
		dll.add("b");
		assertEquals( "a", dll.remove("a"));
	}

	@Test
	void testSet() {
		dll.add("a");
		dll.add("b");
		dll.set(1, "B");
		assertEquals( "B", dll.get(1));
	}

	@Test
	void testIsEmpty() {
		assertTrue(dll.isEmpty());
	}

	@Test
	void testContains() {
		dll.add("a");
		dll.add("b");
		assertTrue(dll.contains("a"));
	}

	@Test
	void testToArrayEArray() {
		dll.add("ab");
		dll.add("cd");
		String[] expected = {"ab","cd"};
		assertArrayEquals(expected, dll.toArray(new String[0]));
	}

	@Test
	void testToArray() {
		dll.add("ab");
		dll.add("cd");
		String[] expected = {"ab","cd"};
		assertArrayEquals(expected, dll.toArray());
	}

	@Test
	void testIterator() {
		dll.add("ab");
		dll.add("cd");
		Iterator<String> it=dll.iterator();
		assertTrue(it.hasNext());
		assertEquals("ab",it.next());
		assertTrue(it.hasNext());
		assertEquals("cd",it.next());
		assertFalse(it.hasNext());
	}

}

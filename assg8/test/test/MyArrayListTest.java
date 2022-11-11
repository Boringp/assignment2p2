package test;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.Iterator;
import utilities.MyArrayList;

class MyArrayListTest {
	MyArrayList<String> myList= new MyArrayList<>();
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		myList=null;
	}

	@Test
	void testHasNext() {
		
		Iterator<String> a=myList.iterator();
		assertFalse(a.hasNext());
		myList.add("ab");
		assertTrue(a.hasNext());
	}

	@Test
	void testNext() {
		Iterator<String> a=myList.iterator();
		
		myList.add("ab");
		assertEquals( "ab", a.next());
		myList.add("cd");
		assertEquals( "cd", a.next());
	}

	@Test
	void testSize() {
		myList.add("ab");
		myList.add("cd");
		myList.add("ef");
		myList.add("ef");
		assertEquals( 4, myList.size());
	}

	@Test
	void testClear() {
		myList.clear();
		
	}

	@Test
	void testAddIntE() {
		myList.add("ab");
		myList.add("cd");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("fh");
		myList.add(10,"gg");
		assertEquals( "gg", myList.get(11));
	}

	@Test
	void testAddE() {

		myList.add("ab");
		myList.add("cd");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("fh");
		assertEquals( "ab",myList.get(1));
		assertEquals( "cd",myList.get(2));
		assertEquals("fh",myList.get(11));
	}

	@Test
	void testAddAll() {
		MyArrayList<String> toAdd= new MyArrayList<>();
		myList.add("ab");
		myList.add("cd");
		myList.add("ef");
		toAdd.add("a");
		toAdd.add("b");
		toAdd.add("c");
		toAdd.add("d");
		myList.addAll(toAdd);
		assertEquals(myList.get(4), "a");
		assertEquals(myList.get(5), "b");
		assertEquals(myList.get(7), "d");
	}

	@Test
	void testGet() {
		myList.add("ab");
		assertEquals(myList.get(1), "ab");
	}

	@Test
	void testRemoveInt() {
		myList.add("ab");
		myList.add("cd");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("fh");
		myList.add(10,"gg");
		assertEquals("gg",myList.remove(11));
	}

	@Test
	void testRemoveE() {
		myList.add("ab");
		myList.add("cd");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("fh");
		myList.add(10,"gg");
		assertEquals("gg",myList.remove("gg"));
		assertEquals(null,myList.remove("ggg"));
	}

	@Test
	void testSet() {
		myList.add("ab");
		myList.add("cd");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("fh");
		myList.set(11, "qe");
		assertEquals("qe",myList.get(11) );
	}

	@Test
	void testIsEmpty() {
		
		assertTrue( myList.isEmpty());
	}

	@Test
	void testContains() {
		myList.add("ab");
		myList.add("cd");
		myList.add("ef");
		assertTrue(myList.contains("ab"));
		assertFalse(myList.contains("aa"));
	}

	@Test
	<E> void testToArrayEArray() {
		myList.add("ab");
		myList.add("cd");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("ef");
		myList.add("fh");
		String[] toHold=new String[10] ;
		
		assertArrayEquals(myList.toArray(),myList.toArray(toHold));
		for(String  i :toHold) {
			System.out.print(i);
		}
	}

	@Test
	void testToArray() {
		myList.add("ab");
		myList.add("cd");
		myList.add("ef");
		myList.add("ef");
		String[] expected = {"ab","cd","ef","ef"};
		assertArrayEquals(expected, myList.toArray());
	}

	@Test
	void testIterator() {
		myList.add("ab");
		myList.add("cd");
		Iterator<String> it=myList.iterator();
		assertTrue(it.hasNext());
		assertEquals("ab",it.next());
		assertTrue(it.hasNext());
		assertEquals("cd",it.next());
		assertFalse(it.hasNext());
	}

}

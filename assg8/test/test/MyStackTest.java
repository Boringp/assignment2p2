package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.Iterator;
import utilities.MyArrayList;
import utilities.MyStack;

class MyStackTest {
	 MyStack<String> s=new MyStack<> () ;
	@BeforeEach
	void setUp() throws Exception {
		 
	}

	@AfterEach
	void tearDown() throws Exception {
	}


	@Test
	void testPush() {
	 s.push("a");
	
		
	}

	@Test
	void testPop() {
		s.push("a");
		s.push("b");
		assertEquals( s.pop(), "b");
	}

	@Test
	void testPeek() {
		 s.push("a");
		
		assertEquals( s.peek(), "a");
	}

	@Test
	void testClear() {
		s.push("a");
		s.clear();
		assertTrue(s.isEmpty());
	}

	@Test
	void testIsEmpty() {
		assertTrue(s.isEmpty());
	}

	@Test
	void testToArray() {
		s.push("ab");
		s.push("cd");
		s.push("ef");
		s.push("ef");
		String[] expected = {"ab","cd","ef","ef"};
		assertArrayEquals(expected,s.toArray());
	}

	@Test
	void testToArrayEArray() {
		s.push("ab");
		s.push("cd");
		s.push("ef");
		s.push("ef");
		String[] expected = {"ab","cd","ef","ef"};
		
		
		assertArrayEquals(expected,s.toArray(new String[1]));
	}

	@Test
	void testContains() {
		s.push("a");
		String ab="a";
		assertTrue(s.contains(ab));
		assertFalse(s.contains("b"));;
	}

	@Test
	void testSearch() {
		s.push("a");
		s.push("b");
		s.push("c");
		s.push("d");
		assertEquals(  3,s.search("a"));
		assertEquals( -1,s.search("f"));
	}

	@Test
	void testIterator() {
		s.push("ab");
		s.push("cd");
		Iterator<String> it=s.iterator();
		assertTrue(it.hasNext());
		assertEquals("ab",it.next());
		assertTrue(it.hasNext());
		assertEquals("cd",it.next());
		assertFalse(it.hasNext());
	}

	@Test
	void testEqualsStackADTOfE() {
		s.push("a");
		s.push("b");
		MyStack<String> e=new MyStack<> () ;
		e.push("a");
		e.push("b");
		assertTrue(s.equals(e));
		e.push("c");
		assertFalse(s.equals(e));
	}

	@Test
	void testSize() {
		s.push("ab");
		s.push("cd");
		s.push("ef");
		s.push("ef");
		assertEquals( 4,s.size());
	}

}

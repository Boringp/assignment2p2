package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.MyArrayList;
import utilities.myStack;

class myStackTest {
	 myStack<String> s=new myStack<> () ;
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
		assertArrayEquals(s.toArray(),expected);
	}

	@Test
	void testToArrayEArray() {
		s.push("ab");
		s.push("cd");
		s.push("ef");
		s.push("ef");
		String[] expected = {"ab","cd","ef","ef"};
		String[] toHold = null;
		
		assertArrayEquals(s.toArray(toHold),expected);
	}

	@Test
	void testContains() {
		s.push("a");
		assertTrue(s.contains("a"));
		assertFalse(s.contains("b"));;
	}

	@Test
	void testSearch() {
		s.push("a");
		s.push("b");
		s.push("c");
		s.push("d");
		assertEquals( s.search("a"), 3);
		assertEquals( s.search("f"), -1);
	}

	@Test
	void testIterator() {
		fail("Not yet implemented");
	}

	@Test
	void testEqualsStackADTOfE() {
		s.push("a");
		s.push("b");
		myStack<String> e=new myStack<> () ;
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
		assertEquals( s.size(), 4);
	}

}

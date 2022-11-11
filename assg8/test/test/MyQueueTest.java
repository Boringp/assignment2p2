package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utilities.MyQueue;

class MyQueueTest {
	MyQueue<String> q=new MyQueue<>();
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}



	@Test
	void testEnqueue() {
		q.enqueue("a");
		q.enqueue("b");
		assertEquals( "b", q.peek());
	}

	@Test
	void testDequeue() {
		q.enqueue("a");
		q.enqueue("b");
		assertEquals( "b", q.dequeue());
		assertEquals( "a", q.peek());
		
	}

	@Test
	void testPeek() {
		q.enqueue("a");
		assertEquals( "a", q.peek());
	}

	@Test
	void testDequeueAll() {
		q.enqueue("a");
		q.enqueue("b");
		q.dequeueAll();
		assertTrue(q.isEmpty());
	}

	@Test
	void testIsEmpty() {
		assertTrue(q.isEmpty());
		q.enqueue("a");
		assertFalse(q.isEmpty());
	}

	@Test
	void testIterator() {
		q.enqueue("a");
		q.enqueue("b");
	}

	@Test
	void testEqualsQueueADTOfE() {
		q.enqueue("a");
		q.enqueue("b");
		MyQueue<String> q2=new MyQueue<>();
		q2.enqueue("a");
		q2.enqueue("b");
		assertTrue(q.equals(q2));
	}

	@Test
	void testToArray() {
		q.enqueue("a");
		q.enqueue("b");
		String[] expected = {"b","a"};
		assertArrayEquals(expected, q.toArray());
	
	}

	@Test
	void testToArrayEArray() {
		fail("Not yet implemented");
	}

	@Test
	void testIsFull() {
		assertFalse(q.isFull());
	}

	@Test
	void testSize() {
		q.enqueue("a");
		q.enqueue("b");
		assertEquals(2, q.size());
	}

}

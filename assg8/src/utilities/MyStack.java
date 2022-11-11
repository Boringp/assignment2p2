package utilities;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

import utilities.MyArrayList.myIterator;

public class MyStack<E> implements StackADT<E> {
	private MyArrayList<E> stack;
	public MyStack () {
		stack=new MyArrayList();
		  
	   }
	@Override
	public void push(E toAdd) throws NullPointerException {
		stack.add(toAdd);
		
	}

	@Override
	public E pop() throws EmptyStackException {
		return stack.remove(stack.size());
	}

	@Override
	public E peek() throws EmptyStackException {
		return stack.get(stack.size());
	}

	@Override
	public void clear() {
		stack=new MyArrayList();
		
	}

	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public Object[] toArray() {
		
		return stack.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		
		return stack.toArray(holder);
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		return stack.contains(toFind);
	}

	@Override
	public int search(E toFind) {
		boolean find=false;
		int position = 0;
		for(int i = 0;i<stack.size()+1;i++) {
			 if (stack.get(i+1)==toFind) {
				 find=true;
				 position=i+1;
			 } 
		 }
		if(find) {
			return stack.size()-position;
		}
		else {
			return -1;
		}
		
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return stack.iterator();
	}
	
	
	@Override
	public boolean equals(StackADT<E> that) {
		// TODO Auto-generated method stub
		
		
			return this.toArray().equals(that.toArray());
			
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return stack.size();
	}

}

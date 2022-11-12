package utilities;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import utilities.MyArrayList.myIterator;

public class MyDLL<E> implements ListADT<E>{

	private DLLNode<E> head, tail;
	
	public MyDLL() {
			// Construct an empty DLL.
		this.head=new DLLNode();
		this.tail=new DLLNode(); 
		}

	@Override
	public int size() {
		int i = 0;
		DLLNode<E> current=this.head.getNext();
		while(current!=null) {
			i++;
			current=current.getNext();
		}
		return i;
	}

	@Override
	public void clear() {
		this.head=new DLLNode();
		this.tail=new DLLNode(); 
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(index >this.size())
			throw new IndexOutOfBoundsException();
		boolean status=false;
		if(this.isEmpty()) {
			DLLNode<E> added= new DLLNode<E> (toAdd);
			this.head.setNext(added);
			this.tail.setPrev(added);
			status =true;
		}
		else if(index==0){
			DLLNode<E> added= new DLLNode<E> (toAdd);
			added.setNext(this.head.getNext());
			this.head.getNext().setPrev(added);
			this.head.setNext(added);
			status =true;
		}
		else if(index==this.size()) {
			DLLNode<E> added= new DLLNode<E> (toAdd);
			added.setPrev(this.tail.getPrev());
			this.tail.getPrev().setNext(added);
			this.tail.setPrev(added);
			status =true;
		}
		else {
			DLLNode<E> curr=this.head;
			DLLNode<E> aftercurr;
			for(int i = 0;i<index;i++) {
				curr=curr.getNext();
			}
			aftercurr=curr.getNext();
			DLLNode<E> added= new DLLNode<E> (toAdd);
			added.setPrev(curr);
			added.setNext(aftercurr);
			curr.setNext(added);
			aftercurr.setPrev(added);
			status =true;
		}
		return status;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		
		return add(this.size(),toAdd);
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
	
		for(int i =0;i<toAdd.size();i++) {
			add(toAdd.get(i+1));
		}
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		DLLNode<E> curr=this.head;
		for(int i = 0;i<index;i++) {
			curr=curr.getNext();
		}
		return curr.getElement();
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if(index >this.size())
			throw new IndexOutOfBoundsException();
		DLLNode<E> curr=this.head;
		for(int i = 0;i<index;i++) {
			curr=curr.getNext();
		}
		if(this.size()==1) {
			this.clear();
		}
		else if(index==1){
			curr.getNext().setPrev(null);
			this.head.setNext(curr.getNext());
			
		}
		else if(index==this.size()) {
			curr.getPrev().setNext(null);
			this.tail.setPrev(curr.getPrev());
			
		}
		else {
			DLLNode<E> nex=curr.getNext();
			DLLNode<E> pre=curr.getPrev();
			nex.setPrev(pre);
			pre.setNext(nex);
		}
		return curr.getElement();
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
	    int index =this.size();
	    DLLNode<E> curr=this.head;
	    for(int i = 0;i<index;i++) {
			curr=curr.getNext();
			if(curr.getElement()==toRemove) {
				index = i;
				break;
			}
		}
	    return remove(index+1);
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		DLLNode<E> curr=this.head;
		for(int i = 0;i<index;i++) {
			curr=curr.getNext();
		}
		E value =curr.getElement();
		curr.setElement(toChange);
		return value;
	}

	@Override
	public boolean isEmpty() {
		return this.head.getNext()==null;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		DLLNode<E> curr=this.head;
		boolean find = false;
		for(int i = 0;i<this.size();i++) {
			curr=curr.getNext();
			if(curr.getElement()==toFind)
				find = true;
		}
		return find;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if(toHold.length>=this.size()) {
			toHold= (E[]) Array.newInstance(toHold.getClass().getComponentType(), this.size());
			for(int i = 0;i<this.size();i++) {
				toHold[i]=this.get(i+1);
			}
		}else
		{
			toHold= (E[]) Array.newInstance(toHold.getClass().getComponentType(), this.size()); 
			for(int i = 0;i<this.size();i++) {
				toHold[i]=this.get(i+1);
		
			
		}
	}
		return toHold;
	}

	@Override
	public Object[] toArray() {
		E[] temp=(E[]) new Object[this.size()];
		for(int i = 0;i<this.size();i++) {
			temp[i]=this.get(i+1);
		}
		return temp;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new myIterator();
	}
	class myIterator<E> implements Iterator<E> {
		int cursor=0;
		@Override
		public boolean hasNext() {
			return cursor<size() ;
				
		}

		@Override
		public E next() throws NoSuchElementException {
			E temp=(E) get(cursor+1);
			cursor++;
			return temp;
			
		}
		
	}
}

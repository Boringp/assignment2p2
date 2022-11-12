package utilities;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class MyArrayList<E> implements ListADT<E> {
   private int maxSize=10 ;
   private int size;
   E[] myArrayList;
   final int INCREASE=10;
   
   public MyArrayList () {
	   myArrayList=(E[]) new Object[maxSize];
	   size=0;
   }
	

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void clear() {
		myArrayList=(E[]) new Object[maxSize];
		   size=0;
		
		
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		try {
			if(size+1<=maxSize)
			{
				E[] temp=(E[]) Array.newInstance(toAdd.getClass(), maxSize);
				 for(int i = 0;i<size+1;i++) {
					 if(i<index) {
					 temp[i]=myArrayList[i];
					 }
					 else if (i==index) {
						 temp[i]=toAdd;
					 }
					 else {
						 temp[i]=myArrayList[1+i];
					 }
				 }
				 myArrayList=temp;
				 size++;
				 return true;
			}
			else {
				maxSize=maxSize+INCREASE;
				E[] temp=(E[]) Array.newInstance(myArrayList.getClass(), maxSize);
				 for(int i = 0;i<size+1;i++) {
					 if(i<=index) {
					 temp[i]=myArrayList[i];
					 }
					 else if (i==index+1) {
						 temp[i]=toAdd;
					 }
					 else {
						 temp[i]=myArrayList[1+i];
					 }
				 }
		    myArrayList=temp;
			size++;
			return true;
				 
			}
		}catch(NullPointerException|IndexOutOfBoundsException ex) {
			return false;
		}
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		try {
			if(size+1<=maxSize)
			{
			myArrayList[size]=toAdd;
			size++;
			
			}
			else {
				maxSize=maxSize+INCREASE;
				 E[] temp=(E[]) Array.newInstance(toAdd.getClass(), maxSize);
				 for(int i = 0;i<size;i++) {
					 temp[i]=myArrayList[i];
				 }
				 temp[size]=toAdd;
				 myArrayList=temp;
				 size++;
				 
				 
			}
		}catch( NullPointerException np){
			return false;
		}
		return true;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		maxSize= maxSize+toAdd.size();
		E[] temp=(E[]) new Object[maxSize];
		try{
			for(int i =0;i<this.size();i++) {
		
			 temp[i]=myArrayList[i];
		}
		for(int i =0;i<toAdd.size();i++) {
			temp[this.size]=toAdd.get(i+1);
			this.size++;
		}
		myArrayList=temp;
		return true;
		}catch (NullPointerException np) {
			return false;
		}
	
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		
		return  myArrayList[index-1];
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if(index>size) {
			throw new IndexOutOfBoundsException(); 
		}
		E removed = null;
		
		E[] temp=(E[]) new Object[maxSize];
		 for(int i = 0;i<size;i++) {
			 if(i<index-1) {
			 temp[i]=myArrayList[i];
			 }
			 else if (i==index-1) {
				 removed=myArrayList[i];
			 }
			 else {
				 temp[i-1]=myArrayList[1+i];
			 }
		 }
		 size--;
		 myArrayList= temp;
		 return removed;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		boolean find=false;
		E removed = null;
		E[] temp= (E[]) new Object[maxSize];
		for(int i = 0;i<size;i++) {
			 if(myArrayList[i]!=toRemove&&find==false) {
			 temp[i]=myArrayList[i];
			 }
			 else if (myArrayList[i]==toRemove&&find==false) {
				 removed=myArrayList[i];
				 find=true;
			 }
			 else {
				 temp[i-1]=myArrayList[1+i];
			 }
		 }
		if(find=true) {
		size--;
		 myArrayList= temp;
		 return removed;}
		else {
			return removed;
		}
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if(index>size) {
			throw new IndexOutOfBoundsException(); 
		}
		E removed = null;
		
		E[] temp=(E[]) new Object[maxSize];
		 for(int i = 0;i<size;i++) {
			 if(i==index-1) {
				 removed=myArrayList[i];
				 temp[i]=toChange;
			 }
			 else {
				 temp[i]=myArrayList[i]; 
			 }
		 }
		 myArrayList= temp;
		 return removed;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
			
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		boolean find=false;
		for(int i = 0;i<size;i++) {
			 if (myArrayList[i].equals(toFind)) {
				 find=true;
			 } 
		 }
		return find;
	}

	@Override
	public  E[] toArray(E[] toHold) throws NullPointerException {
		
		if(toHold.length>=this.size()) {
			toHold= (E[]) Array.newInstance(toHold.getClass().getComponentType(), this.size());
			for(int i = 0;i<this.size;i++) {
				toHold[i]=myArrayList[i];
			}
		}else
		{
			toHold= (E[]) Array.newInstance(toHold.getClass().getComponentType(), this.size()); 
			for(int i = 0;i<this.size;i++) {
				toHold[i]=myArrayList[i];
		
			
		}
	}
		return toHold;
	}

	@Override
	public Object[] toArray() {
		E[] temp=(E[]) new Object[this.size()];
		for(int i = 0;i<this.size;i++) {
			temp[i]=myArrayList[i];
		}
		return temp;
	}

	@Override
	public Iterator<E> iterator() {
		return new myIterator();
	}
	class myIterator<E> implements Iterator<E> {
		int cursor=0;
		@Override
		public boolean hasNext() {
			return cursor<size ;
				
		}

		@Override
		public E next() throws NoSuchElementException {
			E temp=(E) get(cursor+1);
			cursor++;
			return temp;
			
		}
		
	}
}

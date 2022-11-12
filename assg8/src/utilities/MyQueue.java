package utilities;

public class MyQueue<E> implements QueueADT<E> {
	private MyDLL<E> queue;
	
	public MyQueue () {
		queue=new MyDLL();
		  
	   }
	@Override
	
	public void enqueue(E toAdd) throws NullPointerException {
		queue.add(0,toAdd);
		
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		
		return queue.remove(1);
	}

	@Override
	public E peek() throws EmptyQueueException {
		// TODO Auto-generated method stub
		return queue.get(1);
	}

	@Override
	public void dequeueAll() {
		queue=new MyDLL();
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return queue.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return queue.iterator();
	}

	@Override
	public boolean equals(QueueADT<E> that) {
		boolean eq  = true;
		if(this.size()!= that.size()) {
			eq  = false;
		}
		else {
			Iterator<E> i1 = this.iterator();
			Iterator<E> i2 = that.iterator();
			while(i1.hasNext()) {
				if(i1.next()!=i2.next()) {
					eq  = false;
					break;
				}
			}
		}
		return eq;
		
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return queue.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		// TODO Auto-generated method stub
		return queue.toArray(holder);
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return queue.size();
	}

}

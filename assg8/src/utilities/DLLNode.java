package utilities;


public class DLLNode<E> {
	private E element;
	private DLLNode<E> prev, next;
	public DLLNode(E elem, DLLNode<E> prev, 
			DLLNode<E> next){
			this.setElement(elem);
			this.setPrev(prev);
			this.setNext(next);
		}
	public DLLNode(E elem){
			this.setElement(elem);
			this.setPrev(null);
			this.setNext(null);
		}
	public DLLNode() {
		this.setElement(null);
		this.setPrev(null);
		this.setNext(null);
	}
	public DLLNode<E> getPrev() {
		return prev;
	}
	public void setPrev(DLLNode<E> prev) {
		this.prev = prev;
	}
	public DLLNode<E> getNext() {
		return next;
	}
	public void setNext(DLLNode<E> next) {
		this.next = next;
	}
	public E getElement() {
		return element;
	}
	public void setElement(E element) {
		this.element = element;
	}

		}

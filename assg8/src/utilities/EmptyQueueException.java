package utilities;

public class EmptyQueueException extends RuntimeException {
	public EmptyQueueException() {
		super("Empty queue");
    }
}

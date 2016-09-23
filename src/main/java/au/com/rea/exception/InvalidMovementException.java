package au.com.rea.exception;

public class InvalidMovementException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public InvalidMovementException(String message) {
		super(message);
	}
}

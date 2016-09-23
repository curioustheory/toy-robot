package au.com.rea.exception;

/**
 * An exception that catches movement outside the boundary of the terrain
 * 
 * @author Tony Wang
 *
 */
public class InvalidMovementException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default constructor
	 * 
	 * @param message an error message
	 */
	public InvalidMovementException(String message) {
		super(message);
	}
}

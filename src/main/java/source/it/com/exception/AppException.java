package source.it.com.exception;
/**
 * 
 * @author Vitaliy
 *
 */
public class AppException extends Exception {

	private static final long serialVersionUID = 5288779062647218925L;

	public AppException() {
		super();
	}

	public AppException(String message, Throwable cause) {
		super(message, cause);
	}

	public AppException(String message) {
		super(message);
	}

}

package diploma.com.exception;

import java.sql.SQLException;

/**
 * 
 * @author Vitaliy
 *
 */
public class AppException extends SQLException {

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

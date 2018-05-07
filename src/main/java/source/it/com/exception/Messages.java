package source.it.com.exception;

/**
 * Holder for messages of exceptions.
 * 
 * @author Vitaliy Klyuev
 *
 */
public final class Messages {

	private Messages() {
	}

	// Manipulate Data base errors
	public static final String ERR_CANNOT_OBTAIN_CONNECTION = "Cannot obtain a connection from the pool";
	public static final String ERR_CANNOT_CLOSE_CONNECTION = "Cannot close a connection";
	public static final String ERR_CANNOT_CLOSE_RESULTSET = "Cannot close a result set";
	public static final String ERR_CANNOT_CLOSE_STATEMENT = "Cannot close a statement";
	public static final String ERR_CANNOT_OBTAIN_DATA_SOURCE = "Cannot obtain the data source";

	// Manipulate Users errors
	public static final String ERR_CANNOT_OBTAIN_USER_BY_ID = "Cannot obtain a user by its id";
	public static final String ERR_CANNOT_DELETE_USER = "Cannot delete  user ";
	public static final String ERR_CANNOT_OBTAIN_USERS = "Cannot obtain users";
	public static final String ERR_CANNOT_OBTAIN_USER_BY_LOGIN = "Cannot obtain a user by its login";
	public static final String ERR_CANNOT_UPDATE_USER = "Cannot update a user";
	public static final String ERR_CANNOT_OBTAIN_USERS_BY_ROLE_NAME = "Cannot obtain users by the role name";
	public static final String ERR_CANNOT_CREATE_USER = "Cannot create a user";
	public static final String ERR_CANNOT_OBTAIN_USER_BY_CREDIT_CARD_ID = "Cannot obtain a user by a credit card id";
	public static final String ERR_CANNOT_UPDATE_USER_TO_BLOCKED = "Cannot update a user to the blocked state";
	public static final String ERR_CANNOT_UPDATE_USER_TO_UNBLOCKED = "Cannot update a user to the unblocked state";
	public static final String ERR_CANNOT_LOGIN = "Cannot log in";
	public static final String ERR_CANNOT_REGISTRATION = "Cannot registration";
	public static final String ERR_CANNOT_OBTAIN_CLIENTS = "Cannot obtain clients";
	
	// Manipulate Roles errors
	public static final String ERR_CANNOT_OBTAIN_ROLE_BY_USER_ID = "Cannot obtain a role by a user id";
	public static final String ERR_CANNOT_OBTAIN_ROLE_BY_ROLE_NAME = "Cannot obtain a role by a role name";

	// Manipulate Credit Cards errors
	public static final String ERR_CANNOT_ADD_CREDIT_CARD = "Cannot insert credit card";
	public static final String ERR_CANNOT_OBTAIN_CREDIT_CARD_BY_ID = "Cannot obtain a credit card by id";
	public static final String ERR_CANNOT_OBTAIN_CREDIT_CARD_BY_USER_ID = "Cannot obtain a credit card by user id";
	public static final String ERR_CANNOT_UPDATE_CREDIT_CARD = "Cannot update a credit card";
	public static final String ERR_CANNOT_UPDATE_CREDIT_CARD_TO_BLOCKED_STATE = "Cannot update a credit card to the blocked state";
	public static final String ERR_CANNOT_UPDATE_CREDIT_CARD_TO_UNBLOCKED_STATE = "Cannot update a credit card to the unblocked state";
	
	// Manipulate Unblock Requests errors
	public static final String ERR_CANNOT_INSERT_UNBLOCK_REQUEST = "Cannot insert an unblock request";
	public static final String ERR_CANNOT_OBTAIN_UNBLOCK_REQUEST_BY_STATE = "Cannot obtain an unblock requests by state";
	public static final String ERR_CANNOT_OBTAIN_COUNT_UNBLOCK_REQUESTS = "Cannot obtain a count unblock requests";
	public static final String ERR_CANNOT_UPDATE_UNBLOCK_REQUEST = "Cannot update an unblock request";

	// Manipulate Payments errors
	public static final String ERR_CANNOT_ADD_USER_PAYMENT = "Cannot insert payment";
	public static final String ERR_CANNOT_OBTAIN_PAYMENTS_BY_PAYMENT_STATE_NAME = "Cannot obtain payments by payment state name";
	public static final String ERR_CANNOT_ADD_PREPEARED_PAYMENT = "Cannot insert a prepeared payment";
	public static final String ERR_CANNOT_OBTATIN_PAYMENT_STATE_BY_ID = "Cannot obtain the payment state by payment state id";
	public static final String ERR_CANNOT_OBTATIN_PAYMENT_BY_ID = "Cannot obtain the payment by payment id";
	public static final String ERR_CANNOT_UPDATE_PAYMENT_TO_SEND = "Cannot update a payment to sent";
	public static final String ERR_CANNOT_OBTAIN_PAYMENTS_BY_USER_ID = "Cannot obtain payments by a user id";
	public static final String ERR_CANNOT_DELETE_PREPARED_PAYMENT = "Cannot delete a prepared payment";
	
	//Application errors
	public static final String ERR_CANNOT_CHANGE_LOCALE = "Cannot change locale";	
	public static final String ERR_CANNOT_GENERATE_TOKEN= "Cannot generate token";

	public static final String ERR_CANNOT_OBTAIN_USER_PAYMENTS = "Cannot obtain user_payments";
	
}
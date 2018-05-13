package diploma.com.exception;

/**
 * Holder for messages of exceptions.
 * 
 * @author Vitaliy Klyuev
 *
 */
public interface Messages {

	// Manipulate Data base errors
	 String ERR_CANNOT_OBTAIN_CONNECTION = "Cannot obtain a connection from the pool";
	 String ERR_CANNOT_CLOSE_CONNECTION = "Cannot close a connection";
	 String ERR_CANNOT_CLOSE_RESULTSET = "Cannot close a result set";
	 String ERR_CANNOT_CLOSE_STATEMENT = "Cannot close a statement";
	 String ERR_CANNOT_OBTAIN_DATA_SOURCE = "Cannot obtain";
	// Manipulate Users errors
	 String ERR_CANNOT_OBTAIN_USER_BY_ID = "Cannot obtain a user by its id";
	 String ERR_CANNOT_DELETE_USER = "Cannot delete  user ";
	 String ERR_CANNOT_OBTAIN_USERS = "Cannot obtain users";
	 String ERR_CANNOT_OBTAIN_USER_BY_LOGIN = "Cannot obtain a user by its login";
	 String ERR_CANNOT_UPDATE_USER = "Cannot update a user";
	 String ERR_CANNOT_OBTAIN_USERS_BY_ROLE_NAME = "Cannot obtain users by the role name";
	 String ERR_CANNOT_CREATE_USER = "Cannot create a user";
	 String ERR_CANNOT_OBTAIN_USER_BY_CREDIT_CARD_ID = "Cannot obtain a user by a credit card id";
	 String ERR_CANNOT_UPDATE_USER_TO_BLOCKED = "Cannot update a user to the blocked state";
	 String ERR_CANNOT_UPDATE_USER_TO_UNBLOCKED = "Cannot update a user to the unblocked state";
	 String ERR_CANNOT_LOGIN = "Cannot log in";
	 String ERR_CANNOT_REGISTRATION = "Cannot registration";
	 String ERR_CANNOT_UPDATE_USER_STATE = "Cannot update user state";

	// Manipulate Roles errors
	 String ERR_CANNOT_OBTAIN_ROLE_BY_USER_ID = "Cannot obtain a role by a user id";
	 String ERR_CANNOT_OBTAIN_ROLE_BY_ROLE_NAME = "Cannot obtain a role by a role name";

	// Manipulate Credit Cards errors
	 String ERR_CANNOT_ADD_CREDIT_CARD = "Cannot insert credit card";
	 String ERR_CANNOT_OBTAIN_CREDIT_CARD_BY_ID = "Cannot obtain a credit card by id";
	 String ERR_CANNOT_OBTAIN_CREDIT_CARD_BY_USER_ID = "Cannot obtain a credit card by user id";
	 String ERR_CANNOT_UPDATE_CREDIT_CARD = "Cannot update a credit card";
	 String ERR_CANNOT_UPDATE_BALANCE_BY_CREDIT_CARD = "Cannot update balance by credit card";
	 String ERR_CANNOT_UPDATE_CREDIT_CARD_TO_BLOCKED_STATE = "Cannot update a credit card to the blocked state";
	 String ERR_CANNOT_UPDATE_CREDIT_CARD_TO_UNBLOCKED_STATE = "Cannot update a credit card to the unblocked state";
	
	// Manipulate Unblock Requests errors
	 String ERR_CANNOT_INSERT_UNBLOCK_REQUEST = "Cannot insert an unblock request";
	 String ERR_CANNOT_OBTAIN_UNBLOCK_REQUEST_BY_STATE = "Cannot obtain an unblock requests by state";
	 String ERR_CANNOT_OBTAIN_COUNT_UNBLOCK_REQUESTS = "Cannot obtain a count unblock requests";
	 String ERR_CANNOT_UPDATE_UNBLOCK_REQUEST = "Cannot update an unblock request";
	String ERR_CANNOT_DELETE_CREDIT_CARD = "Cannot delete  credit card ";

	// Manipulate Payments errors
	 String ERR_CANNOT_ADD_USER_PAYMENT = "Cannot insert payment";
	 String ERR_CANNOT_OBTAIN_PAYMENTS_BY_PAYMENT_STATE_NAME = "Cannot obtain payments by payment state name";
	 String ERR_CANNOT_ADD_PREPEARED_PAYMENT = "Cannot insert a prepeared payment";
	 String ERR_CANNOT_OBTATIN_PAYMENT_STATE_BY_ID = "Cannot obtain the payment state by payment state id";
	 String ERR_CANNOT_OBTATIN_PAYMENT_BY_ID = "Cannot obtain the payment by payment id";
	 String ERR_CANNOT_UPDATE_PAYMENT_TO_SEND = "Cannot update a payment to sent";
	 String ERR_CANNOT_OBTAIN_PAYMENTS_BY_USER_ID = "Cannot obtain payments by a user id";
	 String ERR_CANNOT_DELETE_PREPARED_PAYMENT = "Cannot delete a prepared payment";
	
	//Application errors
	 String ERR_CANNOT_CHANGE_LOCALE = "Cannot change locale";
	 String ERR_CANNOT_GENERATE_TOKEN= "Cannot generate token";

	 String ERR_CANNOT_OBTAIN_USER_PAYMENTS = "Cannot obtain user_payments";
	
}
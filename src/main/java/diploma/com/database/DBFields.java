package diploma.com.database;

public class DBFields {

	//users table
	public static final String USER_ID = "user_id";
	public static final String USER_FULL_NAME = "full_name";
	public static final String PASSWORD = "password";
	public static final String LOGIN = "login";
	public static final String EMAIL = "email";
	public static final String REGISTER_DATE = "register_date";
	public static final String ROLE_ID = "role_id";
	public static final String ROLE_NAME = "role_name";
	//
	//credit_cards table
	public static final String BILL = "bill";
	public static final String CREDIT_CARD_NUMBER = "credit_card_number";
	public static final String DESCRIPTION = "description";
	public static final String MONTH_EXPIRATION = "month_expiration";
	public static final String YEAR_EXPIRATION = "year_expiration";
	public static final String CVS = "cvs";
	public static final String BLOCKED = "blocked";
	public static final String BALANCE = "balance";
	public static final String CREDIT_CARD_ID = "credit_card_id";
    //payment_states table
	public static final String STATE = "state";
	public static final String STATE_NAME = "state_name";
    //unblock_requests table

	public static final String CREATION_DATE = "creation_date";
    //user_payments table
	public static final String PAYMENT_ID = "payment_id";
	public static final String SUM = "sum";
	public static final String RECIPIENT_BILL = "recipient_bill";


}

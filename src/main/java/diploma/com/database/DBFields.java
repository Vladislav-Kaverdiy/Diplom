package diploma.com.database;

public interface DBFields {

    //users table
    String USER_ID = "user_id";
    String USER_FULL_NAME = "full_name";
    String PASSWORD = "password";
    String LOGIN = "login";
    String EMAIL = "email";
    String REGISTER_DATE = "register_date";
    String ROLE_ID = "role_id";
    String ROLE_NAME = "role_name";

    //credit_cards table
    String BILL = "bill";
    String CREDIT_CARD_NUMBER = "credit_card_number";
    String DESCRIPTION = "description";
    String MONTH_EXPIRATION = "month_expiration";
    String YEAR_EXPIRATION = "year_expiration";
    String CVS = "cvs";
    String BLOCKED = "blocked";
    String BALANCE = "balance";
    String CREDIT_CARD_ID = "credit_card_id";

    //user_payment table
    String CREATION_DATE = "creation_date";
    String STATE = "state";
    String PAYMENT_ID = "payment_id";
    String SUM = "sum";
    String RECIPIENT_BILL = "recipient_bill";
}

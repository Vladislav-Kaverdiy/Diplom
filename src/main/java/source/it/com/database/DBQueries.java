package source.it.com.database;

public final class DBQueries {
    // Queries for User, UserDao class
    public static final String SQL_FIND_ALL_USERS = "SELECT * FROM users";
    public static final String SQL_FIND_USER_BY_LOGIN = "SELECT * FROM users WHERE login=?";
    public static final String SQL_FIND_ROLE_BY_ROLE_NAME = "SELECT * FROM roles WHERE role_name=?";
    public static final String SQL_FIND_USER_ROLE = "SELECT * FROM roles WHERE role_id=?";
    public static final String SQL_INSERT_USER = "INSERT INTO users(full_name, email,login,password,register_date,role_id,blocked)VALUE(?,?,?,?,?,?,?)";
    public static final String SQL_UPDATE_USER_STATE = "UPDATE users SET blocked=?"
            + "	WHERE user_id=?";
    public static final String SQL_UPDATE_USER = "UPDATE users SET full_name=?, email=?, password=?, login=?"
            + "	WHERE user_id=?";
    public static final  String SQL_DELETE_USER_BY_LOGIN_ID = "DELETE FROM users WHERE login=?";

    //Queries for CreditCard, CreditCardDao class
    public static final String SQL_INSERT_CREDIT_CARD = "INSERT INTO credit_cards(bill, credit_card_number, description, month_expiration, year_expiration, cvs, blocked, balance, user_id)VALUE(?,?,?,?,?,?,?,?,?)";
    public static final String SQL_FIND_ALL_CREDIT_CARDS_BY_USER_ID = "SELECT * FROM credit_cards WHERE user_id=?";
    public static final String SQL_FIND_NOT_BLOCKED_CREDIT_CARD_BY_ID = "SELECT * FROM credit_cards WHERE blocked = 1 AND credit_card_id=?";
    public static final String SQL_FIND_CREDIT_CARD_BY_ID = "SELECT * FROM credit_cards WHERE credit_card_id=?";
    public static final String SQL_UPDATE_CREDIT_CARD_STATE = "UPDATE credit_cards SET blocked=?"
            + " WHERE credit_card_id=?";

    public static final String SQL_UPDATE_CREDIT_CARD = "UPDATE credit_cards SET bill=?, credit_card_number=?, description=?, month_expiration=?, year_expiration=?, cvs=?, balance=?"
            + " WHERE credit_card_id=?";
    public static final String SQL_UPDATE_BALANCE_CREDIT_CARD = "UPDATE credit_cards SET balance=?"
            + " WHERE credit_card_id=?";



    public static final String SQL_INSERT_BALANCE_CREDIT_CARD = "INSERT INTO credit_cards (balance)VALUE(?)";


//Queries for UserPayment, UserPaymentDao class
public static final String SQL_FIND_ALL_USER_PAYMENTS = "SELECT * FROM user_payments";
public static final String SQL_INSERT_USER_PAYMENTS = "INSERT INTO user_payments(confirmation_date, creation_date, state_id, credit_card_id, sum, description, recipient_bill)VALUE(?,?,?,?,?,?,?)";
public static final String SQL_FIND_USER_PAYMENTS_BY_ID = "SELECT * user_payments WHERE payment_id=?";
public static final String SQL_UPDATE_USER_PAYMENTS_STATE = "UPDATE user_payments SET blocked=?"
        + "	WHERE payment_id=?";
public static final String SQL_UPDATE_USER_PAYMENTS = "UPDATE user_payments SET confirmation_date=?, creation_date=?, state_id=?, credit_card_id=?, sum=?, description=?, recipient_bill=?"
            + "	WHERE payment_id=?";
}
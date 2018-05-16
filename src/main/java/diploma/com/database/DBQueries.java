package diploma.com.database;

public interface DBQueries {
    // Queries for User, UserDaoImpl class
     String SQL_FIND_ALL_USERS = "SELECT * FROM users";
     String SQL_FIND_USER_BY_LOGIN = "SELECT * FROM users WHERE login=?";
     String SQL_FIND_USER_BY_ID = "SELECT * FROM users WHERE user_id=?";
     String SQL_FIND_ROLE_BY_ROLE_NAME = "SELECT * FROM roles WHERE role_name=?";
     String SQL_FIND_USER_ROLE = "SELECT * FROM roles WHERE role_id=?";
     String SQL_INSERT_USER = "INSERT INTO users(full_name, email,login,password,register_date,role_id,blocked)VALUE(?,?,?,?,?,?,?)";
     String SQL_UPDATE_USER_STATE = "UPDATE users SET blocked=?"
            + "	WHERE user_id=?";
     String SQL_UPDATE_USER = "UPDATE users SET full_name=?, email=?, login=?, register_date=?"
            + "	WHERE user_id=?";


      String SQL_DELETE_USER_BY_ID = "DELETE FROM users WHERE user_id=?";

    //Queries for CreditCard, CreditCardDaoImpl class
     String SQL_INSERT_CREDIT_CARD = "INSERT INTO credit_cards(bill, credit_card_number, description, month_expiration, year_expiration, cvs, blocked, balance, user_id)VALUE(?,?,?,?,?,?,?,?,?)";
     String SQL_FIND_ALL_CREDIT_CARDS_BY_USER_ID = "SELECT * FROM credit_cards WHERE user_id=?";
     String SQL_FIND_CREDIT_CARD_BY_ID = "SELECT * FROM credit_cards WHERE credit_card_id=?";

 String SQL_FIND_USER_PAYMENTS_BY_ID = "SELECT * FROM user_payments WHERE payment_id=?";

     String SQL_UPDATE_CREDIT_CARD_STATE = "UPDATE credit_cards SET blocked=?"
            + " WHERE credit_card_id=?";

     String SQL_UPDATE_CREDIT_CARD = "UPDATE credit_cards SET bill=?, credit_card_number=?, description=?, month_expiration=?, year_expiration=?, cvs=?, balance=?"
            + " WHERE credit_card_id=?";
     String SQL_UPDATE_BALANCE_CREDIT_CARD = "UPDATE credit_cards SET balance=?"
            + " WHERE credit_card_id=?";


     String SQL_DELETE_CREDIT_CARD_BY_CREDIT_CARD_ID = "DELETE FROM credit_cards WHERE credit_card_id=?";



//Queries for UserPaymentDao, UserPaymentDao class
String SQL_FIND_USER_PAYMENT_BY_CREDIT_CARD_ID = "SELECT * FROM user_payments WHERE credit_card_id=?";
 String SQL_FIND_ALL_USER_PAYMENTS = "SELECT * FROM user_payments";

 String SQL_DELETE_USER_PAYMENT_BY_ID = "DELETE FROM user_payments WHERE payment_id=?";

 String SQL_INSERT_USER_PAYMENTS = "INSERT INTO user_payments(creation_date, state,  sum, description, recipient_bill, credit_card_id)VALUE(?,?,?,?,?,?)";

 String SQL_UPDATE_USER_PAYMENT = "UPDATE user_payments SET creation_date=?, credit_card_id=?, sum=?, description=?, recipient_bill=?"
         + " WHERE payment_id=?";

 String SQL_UPDATE_USER_PAYMENT_STATE = "UPDATE user_payments SET state=?"
         + " WHERE payment_id=?";


 String SQL_UPDATE_USER_PAYMENTS_STATE = "UPDATE user_payments SET blocked=?"
        + "	WHERE payment_id=?";
 String SQL_UPDATE_USER_PAYMENTS = "UPDATE user_payments SET confirmation_date=?, creation_date=?, state_id=?, credit_card_id=?, sum=?, description=?, recipient_bill=?"
            + "	WHERE payment_id=?";
}
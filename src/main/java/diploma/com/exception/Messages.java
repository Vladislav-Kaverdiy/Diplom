package diploma.com.exception;

public interface Messages {

    // Manipulate Data base errors
    String ERR_CANNOT_OBTAIN_CONNECTION = "Cannot obtain a connection from the pool";

    // Manipulate Users errors
    String ERR_CANNOT_OBTAIN_USER_BY_ID = "Cannot obtain a user by its id";
    String ERR_CANNOT_DELETE_USER = "Cannot delete  user ";
    String ERR_CANNOT_OBTAIN_USERS = "Cannot obtain users";
    String ERR_CANNOT_OBTAIN_USER_BY_LOGIN = "Cannot obtain a user by its login";
    String ERR_CANNOT_UPDATE_USER = "Cannot update a user";
    String ERR_CANNOT_CREATE_USER = "Cannot create a user";
    String ERR_CANNOT_LOGIN = "Cannot log in";
    String ERR_CANNOT_REGISTRATION = "Cannot registration";
    String ERR_CANNOT_UPDATE_USER_STATE = "Cannot update user state";

    // Manipulate Roles errors
    String ERR_CANNOT_OBTAIN_ROLE_BY_ROLE_NAME = "Cannot obtain a role by a role name";

    // Manipulate Credit Cards errors
    String ERR_CANNOT_ADD_CREDIT_CARD = "Cannot insert credit card";
    String ERR_CANNOT_OBTAIN_CREDIT_CARD_BY_USER_ID = "Cannot obtain a credit card by user id";
    String ERR_CANNOT_UPDATE_CREDIT_CARD = "Cannot update a credit card";
    String ERR_CANNOT_UPDATE_BALANCE_BY_CREDIT_CARD = "Cannot update balance by credit card";
    String ERR_CANNOT_DELETE_CREDIT_CARD = "Cannot delete  credit card ";

    // Manipulate Payments errors
    String ERR_CANNOT_OBTAIN_USER_PAYMENT_BY_CREDIT_CARD_ID = "Cannot obtain a user payment by credit card id";
    String ERR_CANNOT_ADD_USER_PAYMENT = "Cannot insert payment";
    String ERR_CANNOT_OBTAIN_PAYMENTS_BY_CREDIT_CARD_ID = "Cannot obtain payments by credit card id";
    String ERR_CANNOT_DELETE_USER_PAYMENT = "Cannot delete  user payment ";
    String ERR_CANNOT_UPDATE_USER_PAYMENT = "Cannot update a user payment";
    //Application errors
    String ERR_CANNOT_CHANGE_LOCALE = "Cannot change locale";


}
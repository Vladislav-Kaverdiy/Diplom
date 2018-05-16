package diploma.com.servlets.commands;

import java.util.Arrays;
import java.util.Optional;

/**
 * Created by Student on 22.11.2017.
 */
public  enum CommandTypes {
    REGISTRATION("registration"),
    LOGIN("login"),
    MANAGE_CREDIT_CARD("manageCreditCard"),
    CREATE_CREDIT_CARD("createCreditCard"),
    ADD_MONEY("addMoney"),
    MANAGE_USER("manageUser"),
    MANAGE_REQUEST("manageRequest"),
    ADD_PAYMENT("addPayment"),
    SHOW_ADD_PAYMENT("showAddPayment"),
    MANAGE_PAYMENTS("managePayments"),
    SHOW_EDIT_PAYMENT("showEditPayment"),
    EDIT_PAYMENT("editPayment"),
    DELETE_PAYMENT_ADMIN("deletePaymentAdmin"),
    MANAGE_PAYMENT_ADMIN("managePaymentAdmin"),
    DELETE_PAYMENT("deletePayment"),
    CHANGE_LOCALE("changeLocale"),
    BLOCK_USER("block_user"),
    CREATE_USER_PAYMENT("createUserPayment"),
    SHOW_CHANGE_BALANCE("showChangeBalance"),
    DELETE_USER("deleteUser"),
    DELETE_CREDIT_CARD("deleteCreditCard"),
    BLOCK_CREDIT_CARD("blockCreditCard"),
    EDIT_CREDIT_CARD("editCreditCard"),
    MANAGE_CREDIT_CARD_ADMIN("manageCreditCardAdmin"),
    SHOW_EDIT_CREDIT_CARD("showEditCreditCard"),
    EDIT_USER("editUser"),
    SHOW_EDIT_USER("showEditUser"),

    CHANGE_STATE_PAYMENT("changeStatePayment"),

    DELETE_CREDIT_CARD_ADMIN("deleteCreditCardAdmin"),
    LOGOUT("logout");

    private String commandName;

    CommandTypes(String commandName){
        this.commandName = commandName;
    }

    public String getCommandName(){
        return this.commandName;
    }

    public static CommandTypes getType(String value){
       Optional<CommandTypes> cm = Arrays.stream( CommandTypes.values()).filter(name -> name.getCommandName().equals(value))
               .findFirst();
        return cm.isPresent() ? cm.get() : null;
    }

}

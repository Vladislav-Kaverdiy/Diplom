package diploma.com.servlets.commands;

import java.util.Arrays;
import java.util.Optional;

public enum CommandTypes {
    REGISTRATION("registration"),
    LOGIN("login"),
    LOGOUT("logout"),
    CHANGE_LOCALE("changeLocale"),

    MANAGE_USER("manageUser"),
    SHOW_EDIT_USER("showEditUser"),
    EDIT_USER("editUser"),
    BLOCK_USER("block_user"),
    DELETE_USER("deleteUser"),

    CREATE_CREDIT_CARD("createCreditCard"),
    MANAGE_CREDIT_CARD("manageCreditCard"),
    MANAGE_CREDIT_CARD_ADMIN("manageCreditCardAdmin"),
    SHOW_EDIT_CREDIT_CARD("showEditCreditCard"),
    EDIT_CREDIT_CARD("editCreditCard"),
    SHOW_CHANGE_BALANCE("showChangeBalance"),
    ADD_MONEY("addMoney"),
    BLOCK_CREDIT_CARD("blockCreditCard"),
    DELETE_CREDIT_CARD("deleteCreditCard"),
    DELETE_CREDIT_CARD_ADMIN("deleteCreditCardAdmin"),

    CREATE_USER_PAYMENT("createUserPayment"),
    ADD_PAYMENT("addPayment"),
    MANAGE_PAYMENTS("managePayments"),
    MANAGE_PAYMENT_ADMIN("managePaymentAdmin"),
    SHOW_ADD_PAYMENT("showAddPayment"),
    SHOW_EDIT_PAYMENT("showEditPayment"),
    EDIT_PAYMENT("editPayment"),
    DELETE_PAYMENT_ADMIN("deletePaymentAdmin"),
    CHANGE_STATE_PAYMENT("changeStatePayment"),
    DELETE_PAYMENT("deletePayment");

    private String commandName;

    CommandTypes(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return this.commandName;
    }

    public static CommandTypes getType(String value) {
        Optional<CommandTypes> cm = Arrays.stream(CommandTypes.values()).filter(name -> name.getCommandName().equals(value))
                .findFirst();
        return cm.orElse(null);
    }

}

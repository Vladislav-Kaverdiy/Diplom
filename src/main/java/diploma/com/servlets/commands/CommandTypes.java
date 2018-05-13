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
    MANAGE_PAYMENTS("managePayments"),
    CHANGE_LOCALE("changeLocale"),
    BLOCK_USER("block_user"),
    CREATE_USER_PAYMENT("createUserPayment"),
    SHOW_CHANGE_BALANCE("showChangeBalance"),
    DELETE_USER("deleteUser"),
    DELETE_CREDIT_CARD("deleteCreditCard"),
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

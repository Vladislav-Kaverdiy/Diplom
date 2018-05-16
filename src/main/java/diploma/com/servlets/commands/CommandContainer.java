package diploma.com.servlets.commands;

import diploma.com.servlets.commands.admin.*;
import diploma.com.servlets.commands.commandsShow.ShowAddPayment;
import diploma.com.servlets.commands.commandsShow.ShowChangeBalance;
import diploma.com.servlets.commands.commandsShow.ShowEditCreditCard;
import diploma.com.servlets.commands.application.ChangeLocaleCommand;
import diploma.com.servlets.commands.commandsShow.ShowEditUser;
import diploma.com.servlets.commands.customer.*;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {


    private static Map<CommandTypes, Command> commands = new HashMap<>();


    static {
        commands.put(CommandTypes.DELETE_USER, new DeleteUser());
        commands.put(CommandTypes.DELETE_CREDIT_CARD, new DeleteCreditCard());
        commands.put(CommandTypes.REGISTRATION, new Registration());
        commands.put(CommandTypes.LOGIN, new Login());
        commands.put(CommandTypes.LOGOUT, new Logout());
        commands.put(CommandTypes.MANAGE_CREDIT_CARD, new ManageCreditCard());
        commands.put(CommandTypes.MANAGE_USER, new ManageUsers());
        commands.put(CommandTypes.CREATE_CREDIT_CARD, new AddCreditCard());
        commands.put(CommandTypes.ADD_MONEY, new AddMoney());
        commands.put(CommandTypes.CHANGE_LOCALE, new ChangeLocaleCommand());
        commands.put(CommandTypes.BLOCK_USER, new BlockUser());
        commands.put(CommandTypes.MANAGE_PAYMENTS, new ManagePayments());
        commands.put(CommandTypes.CREATE_USER_PAYMENT, new AddPayment());
        commands.put(CommandTypes.BLOCK_CREDIT_CARD, new BlockCreditCard());
        commands.put(CommandTypes.EDIT_CREDIT_CARD, new EditCreditCard());
        commands.put(CommandTypes.SHOW_EDIT_CREDIT_CARD, new ShowEditCreditCard());
        commands.put(CommandTypes.MANAGE_CREDIT_CARD_ADMIN, new ManageCreditCardAdmin());
        commands.put(CommandTypes.EDIT_USER, new EditUser());
        commands.put(CommandTypes.DELETE_CREDIT_CARD_ADMIN, new DeleteCreditCardAdmin());
        commands.put(CommandTypes.SHOW_EDIT_USER, new ShowEditUser());
        commands.put(CommandTypes.SHOW_CHANGE_BALANCE, new ShowChangeBalance());
        commands.put(CommandTypes.ADD_PAYMENT, new AddPayment());
        commands.put(CommandTypes.SHOW_ADD_PAYMENT, new ShowAddPayment());

    }

    public static Command get(CommandTypes commandTypes) {
        return commands.get(commandTypes);
    }


}

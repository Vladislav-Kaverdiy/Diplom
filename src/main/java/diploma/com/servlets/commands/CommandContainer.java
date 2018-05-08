package diploma.com.servlets.commands;

import org.apache.log4j.Logger;
import diploma.com.servlets.commands.admin.BlockUser;
import diploma.com.servlets.commands.admin.DeleteUser;
import diploma.com.servlets.commands.admin.ManageUsers;
import diploma.com.servlets.commands.application.ChangeLocaleCommand;
import diploma.com.servlets.commands.customer.*;

import java.util.HashMap;
import java.util.Map;

public class CommandContainer {
    static final Logger LOG = Logger.getLogger(CommandContainer.class);

    private static Map<CommandTypes, Command> commands = new HashMap<>();


    static {
        commands.put(CommandTypes.DELETE_USER, new DeleteUser());
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
        commands.put(CommandTypes.SHOW_CHANGE_BALANCE, new ShowChangeBalance());

    }

    public static Command get(CommandTypes commandTypes) {
        return commands.get(commandTypes);
    }


}

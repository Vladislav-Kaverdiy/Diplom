package diploma.com.servlets.commands.admin;

import org.apache.log4j.Logger;
import diploma.com.database.daoImpl.UserDaoImpl;
import diploma.com.exception.AppException;
import diploma.com.exception.Messages;
import diploma.com.model.User;
import diploma.com.servlets.Path;
import diploma.com.servlets.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class ManageUsers implements Command {
    private Logger LOG = Logger.getLogger(ManageUsers.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        try {
            LOG.debug("Command starts");
            UserDaoImpl userManager = new UserDaoImpl();
            List<User> users = userManager.getUsers();
            LOG.trace("Get all users");
            request.setAttribute("users", users);

        } catch (Exception ex) {
            LOG.error(Messages.ERR_CANNOT_OBTAIN_CREDIT_CARD_BY_USER_ID, ex);
            request.setAttribute("errorMessage",
                    Messages.ERR_CANNOT_OBTAIN_CREDIT_CARD_BY_USER_ID);
            request.setAttribute("exceptionMessage", ex.getMessage());
            return Path.PAGE_ERROR_PAGE;
        }
        LOG.debug("Command finished");
        return Path.USERS_PAGE;
    }
}

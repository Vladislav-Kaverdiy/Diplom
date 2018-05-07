package source.it.com.servlets.commands.admin;

import org.apache.log4j.Logger;
import source.it.com.database.dao.UserDao;
import source.it.com.exception.AppException;
import source.it.com.exception.Messages;
import source.it.com.model.User;
import source.it.com.servlets.Path;
import source.it.com.servlets.commands.Command;

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
            UserDao userManager = new UserDao();
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

package source.it.com.servlets.commands;

import org.apache.log4j.Logger;
import source.it.com.database.Role;
import source.it.com.database.dao.UserDao;
import source.it.com.exception.Messages;
import source.it.com.model.User;
import source.it.com.servlets.Path;
import source.it.com.servlets.helper.ConvertPassword;
import source.it.com.servlets.validators.Validator;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class Login implements Command {

    private Logger LOG = Logger.getLogger(Login.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        try {

            String login = request.getParameter("login");
            String password = request.getParameter("password");
            LOG.debug("Request parameter: login --> " + login);



            LOG.debug("Command starts");
            List<String> errors = Validator.getLoginErrors(request);
            if (errors.size() > 0) {
                setValidateParameters(request);
                request.setAttribute("errors", errors);
                return Path.LOGIN_PAGE;
            }

            UserDao userManager = new UserDao();
            User user = userManager.findUserByLogin(login);

            String mdPassword = new ConvertPassword().convertToMD5(password);
            if (user == null || !mdPassword.equals(user.getPassword())) {
                return Path.PAGE_ERROR_PAGE;
            }
            Role role = Role.getRole(userManager.findUserRole(user));
            LOG.info("User " + user + " logged as " + role.getName().toLowerCase());

            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            LOG.trace("Set the session attribute: user --> " + user);

            session.setAttribute("role", role.getName().toLowerCase());
            LOG.trace("Set the session attribute: userRole --> " + Role.CLIENT);


            LOG.info("User " + user + " logged as "
                    + Role.CLIENT.getName().toLowerCase());
            session.setAttribute("currentLocale", "");
            LOG.debug("Command finished");

            return role == Role.CLIENT ? Path.COMMAND_CLIENT_MANAGE_CREDIT_CARD : Path.SERVLET_USERS_PAGE;



        } catch (Exception ex) {
            LOG.error(Messages.ERR_CANNOT_LOGIN, ex);
            request.setAttribute("errorMessage",
                    Messages.ERR_CANNOT_LOGIN);
            request.setAttribute("exceptionMessage", ex.getMessage());
            return Path.PAGE_ERROR_PAGE;
        }
    }

    private HttpServletRequest setValidateParameters(HttpServletRequest request) {
        request.setAttribute("name", request.getParameter("name"));
        return request;
    }
}

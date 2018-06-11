package diploma.com.servlets.commands;

import diploma.com.service.UserService;
import diploma.com.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import diploma.com.database.Role;
import diploma.com.exception.Messages;
import diploma.com.model.User;
import diploma.com.servlets.Path;
import diploma.com.servlets.helper.ConvertPassword;
import diploma.com.servlets.validators.RegistrationValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


public class Registration implements Command {

    private UserService userService = new UserServiceImpl();

    private static final Logger LOG = Logger.getLogger(Registration.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            LOG.debug("Command starts");
            List<String> errors = new RegistrationValidator().validate(request);// check validators
            if (errors.size() != 0) {
               setValidateParameters(request);
                request.setAttribute("errors", errors);
                return Path.PAGE_REGISTRATION;
            }
            String login = request.getParameter("login");
            LOG.trace("Request parameter: loging --> " + login);


            User user = userService.findUserByLogin(login);

            /////////// Check writing to database

            if (user != null) {
                LOG.trace("Set the request attribute: error");
                setValidateParameters(request);
                errors.add("rs_user_with_such_login_exist");
                request.setAttribute("errors", errors);
                return Path.PAGE_REGISTRATION;
            }
            user = new User();
            user.setFullName(request.getParameter("userName"));
            user.setEmail(request.getParameter("email"));
            user.setLogin(login);
            user.setPassword(new ConvertPassword().convertToMD5(request
                   .getParameter("password")));
            LOG.info("User " + user + " logged as "
                    + Role.CLIENT.getName().toLowerCase());
            user.setRoleId(userService
                    .findRoleByRoleName(Role.CLIENT.getName()).getRoleId());
            user.setRegisterDate(new Date());
            user.setBlocked(false);
            userService.createUser(user);
            user = userService.findUserByLogin(user.getLogin());
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", Role.CLIENT.getName());
            LOG.trace("Set the session attribute: user --> " + user);

            session.setAttribute("userRole", Role.CLIENT);
            LOG.trace("Set the session attribute: userRole --> " + Role.CLIENT);

            LOG.info("User " + user + " logged as "
                    + Role.CLIENT.getName().toLowerCase());
            session.setAttribute("currentLocale", "");
            LOG.debug("Command finished");

            return Path.COMMAND_CLIENT_MANAGE_CREDIT_CARD;

        } catch (Exception ex) {
            LOG.error(Messages.ERR_CANNOT_REGISTRATION, ex);
            request.setAttribute("errorMessage",
                    Messages.ERR_CANNOT_REGISTRATION);
            request.setAttribute("exceptionMessage", ex.getMessage());
            return Path.PAGE_ERROR_PAGE;
        }
    }

    private HttpServletRequest setValidateParameters(HttpServletRequest request) {
        request.setAttribute("userName", request.getParameter("userName"));
        request.setAttribute("email", request.getParameter("email"));
        request.setAttribute("login", request.getParameter("login"));
        return request;
    }
}


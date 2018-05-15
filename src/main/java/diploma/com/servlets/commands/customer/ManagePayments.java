package diploma.com.servlets.commands.customer;

import diploma.com.database.daoImpl.UserPaymentImpl;
import org.apache.log4j.Logger;
import diploma.com.exception.AppException;
import diploma.com.exception.Messages;
import diploma.com.model.User;
import diploma.com.model.UserPayment;
import diploma.com.servlets.Path;
import diploma.com.servlets.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ManagePayments implements Command {
    private static final Logger LOG = Logger
            .getLogger(ManageCreditCard.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException,

            AppException {
        try {
            LOG.debug("Command starts");
            User user = (User) request.getSession(false).getAttribute("user");
            UserPaymentImpl userPaymentDao = new UserPaymentImpl();
          //  List<UserPayment> payments = UserPaymentImpl.getUserPaymentByUserId(user.getUserId());
            LOG.trace("Get payment of user--> " + user.getFullName());
           // request.setAttribute("userPayment", payments);

        } catch (Exception ex) {
            LOG.error(Messages.ERR_CANNOT_OBTAIN_PAYMENTS_BY_USER_ID, ex);
            request.setAttribute("errorMessage",
                    Messages.ERR_CANNOT_OBTAIN_PAYMENTS_BY_USER_ID);
            request.setAttribute("exceptionMessage", ex.getMessage());
            return Path.PAGE_ERROR_PAGE;
        }
        LOG.debug("Command finished");
        return Path. PAGE_CLIENT_MANAGE_PAYMENT;
    }
}

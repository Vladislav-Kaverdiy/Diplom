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
            .getLogger(ManagePayments.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException,

            AppException {

        try {
            LOG.debug("Command starts");
            //User user = (User) request.getSession(false).getAttribute("user");
            UserPaymentImpl userPaymentImpl = new UserPaymentImpl();
            Integer creditCardId = Integer.parseInt(request.getParameter("creditCardId"));
            List<UserPayment> userPayment = userPaymentImpl.getPaymentByCreditCardId(creditCardId);


            request.setAttribute("userPayment", userPayment);
            request.setAttribute("creditCardId", creditCardId);

        } catch (Exception ex) {
            LOG.error(Messages.ERR_CANNOT_OBTAIN_PAYMENTS_BY_CREDIT_CARD_ID, ex);
            request.setAttribute("errorMessage",
                    Messages.ERR_CANNOT_OBTAIN_PAYMENTS_BY_CREDIT_CARD_ID);
            request.setAttribute("exceptionMessage", ex.getMessage());
            return Path.PAGE_ERROR_PAGE;
        }
        LOG.debug("Command finished");
        return Path. PAGE_CLIENT_MANAGE_PAYMENT;
    }
}

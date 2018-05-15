package diploma.com.servlets.commands.customer;

import diploma.com.database.dao.UserPaymentDao;
import diploma.com.database.daoImpl.UserPaymentImpl;
import org.apache.log4j.Logger;
import diploma.com.exception.AppException;
import diploma.com.exception.Messages;
import diploma.com.model.CreditCard;
import diploma.com.model.UserPayment;
import diploma.com.servlets.Path;
import diploma.com.servlets.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddPayment implements Command {
    private static final Logger LOG = Logger.getLogger(AddPayment.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException,
            AppException {
        LOG.debug("Command starts");
        try {
            UserPayment userPayment = new UserPayment();
            userPayment.setDescription(String.valueOf((request.getParameter("description"))));
            userPayment.setSum(Double.valueOf((request.getParameter("sum"))));
            userPayment.setRecipientBill(Long.valueOf((request.getParameter("recipientBill"))));
            userPayment.setCreditCardId(((CreditCard) request.getSession(false).getAttribute("creditCard")).getCreditCardId());

            LOG.trace("Get request parameters and crete user payment--> "
                    + userPayment.toString());
            UserPaymentImpl userPaymentDao = new UserPaymentImpl();
            userPaymentDao.addUserPayment(userPayment);

        } catch (Exception ex) {
            LOG.error(Messages.ERR_CANNOT_ADD_USER_PAYMENT, ex);
            request.setAttribute("errorMessage",
                    Messages.ERR_CANNOT_ADD_USER_PAYMENT);
            request.setAttribute("exceptionMessage", ex.getMessage());
            return Path.PAGE_CLIENT_ERROR_PAGE;
        }

        LOG.debug("Command finished");

        return Path.COMMAND_MANAGE_PAYMENTS;
    }
}


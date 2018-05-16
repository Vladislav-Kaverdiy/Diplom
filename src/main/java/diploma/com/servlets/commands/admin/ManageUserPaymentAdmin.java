package diploma.com.servlets.commands.admin;

import diploma.com.database.daoImpl.UserPaymentImpl;
import diploma.com.exception.AppException;
import diploma.com.exception.Messages;
import diploma.com.model.UserPayment;
import diploma.com.servlets.Path;
import diploma.com.servlets.commands.Command;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ManageUserPaymentAdmin implements Command {

    private static final Logger LOG = Logger
            .getLogger(ManageUserPaymentAdmin.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException, SQLException {
        try {

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
        return Path. PAGE_ADMIN_MANAGE_PAYMENT;
    }
}

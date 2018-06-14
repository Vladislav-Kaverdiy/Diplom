package diploma.com.servlets.commands.customer;

import diploma.com.database.daoImpl.UserPaymentImpl;
import diploma.com.servlets.validators.PaymentValidator;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import diploma.com.exception.AppException;
import diploma.com.exception.Messages;
import diploma.com.model.UserPayment;
import diploma.com.servlets.Path;
import diploma.com.servlets.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class AddPayment implements Command {
    private static final Logger LOG = Logger.getLogger(AddPayment.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException,
            AppException {


        request.setAttribute("creditCardId", request.getParameter("creditCardId"));
        try {
            LOG.debug("Command starts");
            List<String> errors = new PaymentValidator().validate(request);// check validators
            if (errors.size() != 0) {
                setValidateParameters(request);
                request.setAttribute("errors", errors);
                return Path.PAGE_ADD_PAYMENT;
            }else {
                UserPayment userPayment = new UserPayment();
                userPayment.setCreationDate(new Date());
                userPayment.setState(false);
                userPayment.setSum(Double.valueOf((request.getParameter("sum"))));
                userPayment.setDescription(String.valueOf((request.getParameter("description"))));
                userPayment.setRecipientBill(Long.valueOf((request.getParameter("recipientBill"))));

                String Id = request.getParameter("creditCardId");
                if (StringUtils.isNotEmpty(Id)) {

                    Integer creditCardId = Integer.parseInt(Id);
                    userPayment.setCreditCardId(creditCardId);
                }
                LOG.trace("Get request parameters and crete user payment--> "
                        + userPayment.toString());
                UserPaymentImpl userPaymentDao = new UserPaymentImpl();
                userPaymentDao.addUserPayment(userPayment);
            }
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
    private HttpServletRequest setValidateParameters(HttpServletRequest request) {
        request.setAttribute("sum", request.getParameter("sum"));
        request.setAttribute("description", request.getParameter("description"));
        request.setAttribute("recipientBill", request.getParameter("recipientBill"));
        return request;
    }
}


package diploma.com.servlets.commands.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import diploma.com.database.daoImpl.CreditCardDaoImpl;
import diploma.com.servlets.validators.CreditCardValidator;
import org.apache.log4j.Logger;

import diploma.com.exception.AppException;
import diploma.com.exception.Messages;
import diploma.com.model.CreditCard;
import diploma.com.model.User;
import diploma.com.model.helper.CreditCardHelper;
import diploma.com.servlets.Path;
import diploma.com.servlets.commands.Command;


public class AddCreditCard implements Command {
    private static final Logger LOG = Logger.getLogger(AddCreditCard.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException,
            AppException {

        try {
            LOG.debug("Command starts");
            List<String> errors = new CreditCardValidator().validate(request);// check validators
            if (errors.size() != 0) {
                setValidateParameters(request);
                request.setAttribute("errors", errors);
                return Path.PAGE_CREATE_CREDIT_CARD;
            }else {
                CreditCard creditCard = new CreditCard();
                CreditCardHelper creditCardHelper = new CreditCardHelper();
                creditCard.setCreditCardNumber(Long.valueOf((request.getParameter("creditcardNumber"))));
                creditCard.setMonthExpiration(Integer.valueOf((request.getParameter("creditcardMonth"))));
                creditCard.setYearExpiration(Integer.valueOf((request.getParameter("creditcardYear"))));
                creditCard.setCvs(Integer.valueOf((request.getParameter("creditcardCVS"))));
                creditCard.setBalance(Double.valueOf((request.getParameter("balance"))));
                creditCard.setDescription(request.getParameter("description"));
                creditCard.setBlocked(false);
                creditCard.setBill(creditCardHelper.generateBillForCard(creditCard.getCreditCardNumber()));
                creditCard.setUserId(((User) request.getSession(false).getAttribute("user")).getUserId());

                LOG.trace("Get request parameters and crete credit card--> "
                        + creditCard.toString());
                CreditCardDaoImpl creditCardDaoImpl = new CreditCardDaoImpl();
                creditCardDaoImpl.addCreditCards(creditCard);
            }
        } catch (Exception ex) {
            LOG.error(Messages.ERR_CANNOT_ADD_CREDIT_CARD, ex);
            request.setAttribute("errorMessage",
                    Messages.ERR_CANNOT_ADD_CREDIT_CARD);
            request.setAttribute("exceptionMessage", ex.getMessage());
            return Path.PAGE_CLIENT_ERROR_PAGE;
        }

        LOG.debug("Command finished");

        return Path.COMMAND_CLIENT_MANAGE_CREDIT_CARD;
    }
    private HttpServletRequest setValidateParameters(HttpServletRequest request) {
        request.setAttribute("creditcardNumber", request.getParameter("creditcardNumber"));
        request.setAttribute("creditcardMonth", request.getParameter("creditcardMonth"));
        request.setAttribute("creditcardYear", request.getParameter("creditcardYear"));
        request.setAttribute("creditcardCVS", request.getParameter("creditcardCVS"));
        request.setAttribute("balance", request.getParameter("balance"));
        request.setAttribute("description", request.getParameter("description"));
        return request;
    }
}


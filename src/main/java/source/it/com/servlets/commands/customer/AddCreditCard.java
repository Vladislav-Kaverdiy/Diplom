package source.it.com.servlets.commands.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import source.it.com.database.dao.CreditCardDao;
import source.it.com.exception.AppException;
import source.it.com.exception.Messages;
import source.it.com.model.CreditCard;
import source.it.com.model.User;
import source.it.com.model.helper.CreditCardHelper;
import source.it.com.servlets.Path;
import source.it.com.servlets.commands.Command;


public class AddCreditCard implements Command {
    private static final Logger LOG = Logger.getLogger(AddCreditCard.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException,
            AppException {
        LOG.debug("Command starts");
        try {
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
            CreditCardDao creditCardDao = new CreditCardDao();
            creditCardDao.addCreditCards(creditCard);

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
}


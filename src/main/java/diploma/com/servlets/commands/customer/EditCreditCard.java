package diploma.com.servlets.commands.customer;

import diploma.com.database.daoImpl.CreditCardDaoImpl;
import diploma.com.exception.AppException;
import diploma.com.model.CreditCard;
import diploma.com.model.User;
import diploma.com.model.helper.CreditCardHelper;
import diploma.com.servlets.Path;
import diploma.com.servlets.commands.Command;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EditCreditCard implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException, SQLException {

        CreditCardDaoImpl creditCardDaoImpl = new CreditCardDaoImpl();
        CreditCard creditCard = new CreditCard();

        String Id = request.getParameter("creditCardId");

        if (StringUtils.isNotEmpty(Id)) {
            Integer creditCardId = Integer.parseInt(Id);
            creditCard = creditCardDaoImpl.findCreditCardById(creditCardId);
        }

        CreditCardHelper creditCardHelper = new CreditCardHelper();
        creditCard.setCreditCardNumber(Long.valueOf((request.getParameter("creditcardNumber"))));
        creditCard.setMonthExpiration(Integer.valueOf((request.getParameter("creditcardMonth"))));
        creditCard.setYearExpiration(Integer.valueOf((request.getParameter("creditcardYear"))));
        creditCard.setCvs(Integer.valueOf((request.getParameter("creditcardCVS"))));
        creditCard.setBalance(Double.valueOf((request.getParameter("balance"))));
        creditCard.setDescription(request.getParameter("description"));
        creditCard.setBlocked(false);
        creditCard.setBill(creditCardHelper.generateBillForCard(creditCard.getCreditCardNumber()));

        creditCardDaoImpl.updateCreditCard(creditCard);


        return Path.COMMAND_CLIENT_MANAGE_CREDIT_CARD;

    }
}


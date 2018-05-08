package diploma.com.servlets.commands.customer;

import org.apache.commons.lang3.StringUtils;
import diploma.com.database.dao.CreditCardDao;
import diploma.com.exception.AppException;
import diploma.com.model.CreditCard;
import diploma.com.servlets.commands.Command;
import diploma.com.servlets.commands.CommandContainer;
import diploma.com.servlets.commands.CommandTypes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddMoney implements Command {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException,
            AppException, SQLException {

        CreditCardDao creditCardDao = new CreditCardDao();
        CreditCard creditCard = new CreditCard();


        String Id = request.getParameter("creditCardId");


        if (StringUtils.isNotEmpty(Id)) {

            Integer creditCardId = Integer.parseInt(Id);
            creditCard = creditCardDao.findCreditCardById(creditCardId);
        }


        /*creditCard.setBalance(Double.valueOf(request.getParameter("balance")));
        creditCardDao.updateCreditCardBalance(creditCard);*/
        creditCard.setBalance(Double.valueOf((request.getParameter("balance"))));
        creditCardDao.updateCreditCardBalance(creditCard);




        return CommandContainer.get(CommandTypes.MANAGE_CREDIT_CARD).execute(request, response);
}
}






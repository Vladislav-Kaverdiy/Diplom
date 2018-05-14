package diploma.com.servlets.commands.customer;
import diploma.com.database.daoImpl.CreditCardDaoImpl;
import diploma.com.model.CreditCard;
import diploma.com.servlets.commands.Command;
import diploma.com.servlets.commands.CommandContainer;
import diploma.com.servlets.commands.CommandTypes;
import org.apache.commons.lang3.StringUtils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteCreditCard implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {

        CreditCardDaoImpl creditCardDaoImpl = new CreditCardDaoImpl();
        CreditCard creditCard = new CreditCard();

        String Id = request.getParameter("creditCardId");

        if (StringUtils.isNotEmpty(Id)) {

            Integer creditCardId = Integer.parseInt(Id);
            creditCard = creditCardDaoImpl.findCreditCardById(creditCardId);
        }

        creditCardDaoImpl.deleteCreditCardById(creditCard.getCreditCardId());
        return CommandContainer.get(CommandTypes.MANAGE_CREDIT_CARD).execute(request, response);
    }
}
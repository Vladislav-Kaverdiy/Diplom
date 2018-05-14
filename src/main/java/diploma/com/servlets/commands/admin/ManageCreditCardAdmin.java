package diploma.com.servlets.commands.admin;

import diploma.com.database.daoImpl.CreditCardDaoImpl;
import diploma.com.exception.AppException;
import diploma.com.exception.Messages;
import diploma.com.model.CreditCard;
import diploma.com.model.User;
import diploma.com.servlets.Path;
import diploma.com.servlets.commands.Command;
import diploma.com.servlets.commands.customer.ManageCreditCard;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ManageCreditCardAdmin  implements Command {
    private static final Logger LOG = Logger.getLogger(ManageCreditCard.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException,
            AppException {
        try {

            CreditCardDaoImpl creditCardDaoImpl = new CreditCardDaoImpl();
            Integer userId = Integer.parseInt(request.getParameter("userId"));
            List<CreditCard> creditCards = creditCardDaoImpl.getCreditCardsByUserId(userId);

            request.setAttribute("creditCards", creditCards);
            request.setAttribute("userId", userId);

        } catch (Exception ex) {
            LOG.error(Messages.ERR_CANNOT_OBTAIN_CREDIT_CARD_BY_USER_ID, ex);
            request.setAttribute("errorMessage", Messages.ERR_CANNOT_OBTAIN_CREDIT_CARD_BY_USER_ID);
            request.setAttribute("exceptionMessage", ex.getMessage());
            return Path.PAGE_CLIENT_ERROR_PAGE;
        }
        LOG.debug("Command finished");
        return Path.PAGE_ADMIN_MANAGE_BILLS;
    }

}

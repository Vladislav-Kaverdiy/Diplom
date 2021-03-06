package source.it.com.servlets.commands.customer;

import  org.apache.log4j.Logger;
import source.it.com.database.dao.CreditCardDao;
import source.it.com.exception.AppException;
        import source.it.com.exception.Messages;
        import source.it.com.model.CreditCard;
        import source.it.com.model.User;
        import source.it.com.servlets.Path;
        import source.it.com.servlets.commands.Command;

        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.util.List;

public class ManageCreditCard implements Command {
    private static final Logger LOG = Logger.getLogger(ManageCreditCard.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException,
            AppException {
        try {
            LOG.debug("Command starts");
            User user = (User) request.getSession(false).getAttribute("user");
            CreditCardDao creditCardDao = new CreditCardDao();
            List<CreditCard> creditCards = creditCardDao.getCreditCardsByUserId(user.getUserId());
            LOG.trace("Get credit cards of user--> " + user.getFullName());
            request.setAttribute("creditCards", creditCards);

        } catch (Exception ex) {
            LOG.error(Messages.ERR_CANNOT_OBTAIN_CREDIT_CARD_BY_USER_ID, ex);
            request.setAttribute("errorMessage", Messages.ERR_CANNOT_OBTAIN_CREDIT_CARD_BY_USER_ID);
            request.setAttribute("exceptionMessage", ex.getMessage());
            return Path.PAGE_CLIENT_ERROR_PAGE;
        }
        LOG.debug("Command finished");
        return Path.PAGE_CLIENT_MANAGE_BILLS;
    }

}

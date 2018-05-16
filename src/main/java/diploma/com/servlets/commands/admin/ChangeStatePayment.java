package diploma.com.servlets.commands.admin;

import diploma.com.database.daoImpl.CreditCardDaoImpl;
import diploma.com.database.daoImpl.UserPaymentImpl;
import diploma.com.exception.AppException;
import diploma.com.model.CreditCard;
import diploma.com.model.UserPayment;
import diploma.com.servlets.commands.Command;
import diploma.com.servlets.commands.CommandContainer;
import diploma.com.servlets.commands.CommandTypes;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ChangeStatePayment implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException, SQLException {
        request.setAttribute("creditCardId", request.getParameter("creditCardId"));
        request.setAttribute("paymentId", request.getParameter("paymentId"));

        UserPaymentImpl userPaymentImpl = new UserPaymentImpl();
        UserPayment userPayment = new UserPayment();

        String Id = request.getParameter("paymentId");

        if (StringUtils.isNotEmpty(Id)) {

            Integer paymentId = Integer.parseInt(Id);
            userPayment = userPaymentImpl.findUserPaymentById(paymentId);
        }

       userPaymentImpl.updateUserPaymentState(!userPayment.isState(),userPayment.getPaymentId());

        return CommandContainer.get(CommandTypes.MANAGE_PAYMENT_ADMIN).execute(request, response);
    }
}
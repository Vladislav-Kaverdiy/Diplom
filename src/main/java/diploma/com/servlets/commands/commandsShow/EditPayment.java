package diploma.com.servlets.commands.commandsShow;

import diploma.com.database.daoImpl.UserPaymentImpl;
import diploma.com.exception.AppException;
import diploma.com.model.UserPayment;
import diploma.com.servlets.Path;
import diploma.com.servlets.commands.Command;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

public class EditPayment implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException, SQLException {

        UserPaymentImpl userPaymentImpl = new UserPaymentImpl();
        UserPayment userPayment = new UserPayment();

        String Id = request.getParameter("paymentId");

        if (StringUtils.isNotEmpty(Id)) {
            Integer paymentId = Integer.parseInt(Id);
            userPayment = userPaymentImpl.findUserPaymentById(paymentId);
        }

        userPayment.setCreationDate(new Date());
        userPayment.setSum(Double.valueOf((request.getParameter("sum"))));
        userPayment.setDescription(String.valueOf((request.getParameter("description"))));
        userPayment.setRecipientBill(Long.valueOf((request.getParameter("recipientBill"))));

        userPaymentImpl.updateUserPayment(userPayment);

        return Path.COMMAND_MANAGE_PAYMENTS;
    }
}

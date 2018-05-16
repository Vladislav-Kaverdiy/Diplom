package diploma.com.servlets.commands.commandsShow;

import diploma.com.exception.AppException;
import diploma.com.servlets.Path;
import diploma.com.servlets.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ShowEditPayment implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException, SQLException {
        request.setAttribute("creditCardId",request.getParameter("creditCardId"));
        request.setAttribute("paymentId",request.getParameter("paymentId"));
        return Path.PAGE_EDIT_PAYMENT;
    }
}
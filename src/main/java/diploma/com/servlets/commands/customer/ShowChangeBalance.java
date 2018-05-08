package diploma.com.servlets.commands.customer;

import diploma.com.exception.AppException;
import diploma.com.servlets.Path;
import diploma.com.servlets.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class ShowChangeBalance implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        request.setAttribute("creditCardId",request.getParameter("creditCardId"));
        return Path.PAGE_ADD_BAlANCE;
    }
}
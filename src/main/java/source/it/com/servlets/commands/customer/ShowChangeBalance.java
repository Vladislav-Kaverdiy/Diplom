package source.it.com.servlets.commands.customer;

import source.it.com.exception.AppException;
import source.it.com.servlets.Path;
import source.it.com.servlets.commands.Command;

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
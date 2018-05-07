package source.it.com.servlets.commands;

import source.it.com.exception.AppException;
import source.it.com.servlets.Path;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Student on 02.12.2017.
 */
public class Logout implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException {
        request.getSession().invalidate();
        return Path.HOME_PAGE;
    }
}

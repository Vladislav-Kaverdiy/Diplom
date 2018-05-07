package source.it.com.servlets.commands;

import source.it.com.exception.AppException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Student on 22.11.2017.
 */
public interface Command {
    String execute(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException, AppException, SQLException;


}

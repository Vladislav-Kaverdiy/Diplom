package source.it.com.servlets.commands.admin;

import source.it.com.database.dao.UserDao;
import source.it.com.exception.AppException;
import source.it.com.model.User;
import source.it.com.servlets.commands.Command;
import source.it.com.servlets.commands.CommandContainer;
import source.it.com.servlets.commands.CommandTypes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteUser implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException, SQLException {


        UserDao userManager = new UserDao();
        String login = request.getParameter("login");
        userManager.findUserByLogin(login);
        userManager.deleteUserByLogin(login);

        return CommandContainer.get(CommandTypes.MANAGE_USER).execute(request, response);
    }
}
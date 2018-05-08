package diploma.com.servlets.commands.admin;

import diploma.com.database.daoImpl.UserDaoImpl;
import diploma.com.exception.AppException;
import diploma.com.servlets.commands.Command;
import diploma.com.servlets.commands.CommandContainer;
import diploma.com.servlets.commands.CommandTypes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DeleteUser implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException, SQLException {

        UserDaoImpl userManager = new UserDaoImpl();
        String userId = (request.getParameter("userId"));
        userManager.findUserById(Integer.parseInt(userId));
        userManager.deleteUserById(Integer.valueOf(userId));

        return CommandContainer.get(CommandTypes.MANAGE_USER).execute(request, response);
    }
}
package diploma.com.servlets.commands.admin;

import diploma.com.database.daoImpl.UserDaoImpl;
import diploma.com.exception.AppException;
import diploma.com.exception.Messages;
import diploma.com.model.User;
import diploma.com.servlets.Path;
import diploma.com.servlets.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;


import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;


public class EditUser implements Command {
    private static final Logger LOG = Logger.getLogger(EditUser.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, AppException, SQLException {

        request.setAttribute("fullName", request.getParameter("fullName"));
        request.setAttribute("email", request.getParameter("email"));
        request.setAttribute("login", request.getParameter("login"));


        UserDaoImpl userDaoImpl = new UserDaoImpl();
        User user = new User();


        String Id = request.getParameter("userId");

        if (StringUtils.isNotEmpty(Id)) {
            Integer userId = Integer.parseInt(Id);
            user = userDaoImpl.findUserById(userId);
        }

        user.setFullName(request.getParameter("userName"));
        user.setEmail(request.getParameter("email"));
        user.setLogin(request.getParameter("login"));
        user.setRegisterDate(new Date());

        userDaoImpl.updateUser(user);

        return Path.COMMAND_MANAGE_USER;


    }

}



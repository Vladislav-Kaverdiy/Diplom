package source.it.com.servlets;

import source.it.com.exception.AppException;
import source.it.com.servlets.commands.Command;
import source.it.com.servlets.commands.CommandContainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import source.it.com.servlets.commands.CommandTypes;


public class DispatcherServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(DispatcherServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            process(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            process(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        LOG.debug("Controller starts");

        // extract command name from the request
        String commandName = request.getParameter("command");
        LOG.trace("Request parameter: command --> " + commandName);

        // obtain command object by its name
        Command command = CommandContainer.get(CommandTypes.getType(commandName));
        LOG.trace("Obtained command --> " + command);

        // execute command and get forward address
        String forward = "error";
        try {
            forward = command.execute(request, response);
        } catch (AppException ex) {
            throw new RuntimeException(ex.getMessage());
            //request.setAttribute("errorMessage", ex.getMessage());
        }
        LOG.trace("Forward address --> " + forward);

        LOG.debug("Controller finished, now go to forward address --> " + forward);

        if (!response.isCommitted()) {
            request.getRequestDispatcher(forward).forward(request, response);
        }


    }

}

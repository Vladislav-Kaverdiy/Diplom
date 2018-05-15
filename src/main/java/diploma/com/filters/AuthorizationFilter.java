package diploma.com.filters;

import diploma.com.database.Role;
import diploma.com.servlets.Path;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorizationFilter implements Filter {
    private static final Map<String, List<String>> AUTHORIZATION_COMMANDS = new HashMap<>();
    private static final String OUT_OF_CONTROL = "out-of-control";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String commandsNames = filterConfig.getInitParameter(Role.ADMINISTRATOR.getName());
        AUTHORIZATION_COMMANDS.put(Role.ADMINISTRATOR.getName(), Arrays.asList(commandsNames.split(" ")));
        commandsNames = filterConfig.getInitParameter(Role.CLIENT.getName());
        AUTHORIZATION_COMMANDS.put(Role.CLIENT.getName(), Arrays.asList(commandsNames.split(" ")));
        commandsNames = filterConfig.getInitParameter(OUT_OF_CONTROL);
        AUTHORIZATION_COMMANDS.put(OUT_OF_CONTROL, Arrays.asList(commandsNames.split(" ")));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (accessAllowed(request)) {
            chain.doFilter(request, response);
        } else {
            String errorMessasge = "You do not have permission to access the requested resource";
            request.setAttribute("errorMessage", errorMessasge);
            request.getRequestDispatcher(Path.PAGE_ERROR_PAGE).forward(request, response);
        }
    }

    private boolean accessAllowed(ServletRequest request) {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String commandName = request.getParameter("command");
        if (commandName == null || commandName.isEmpty()) {
            return false;
        }
        if (AUTHORIZATION_COMMANDS.get(OUT_OF_CONTROL).contains(commandName)) {
            return true;
        }
        HttpSession session = httpRequest.getSession();
        if (session == null) {
            return false;
        }
        String userRole = (String)session.getAttribute("role");
        if (userRole == null) {
            return false;
        }
        return AUTHORIZATION_COMMANDS.get(userRole).contains(commandName);
    }

    @Override
    public void destroy() {
    }
}

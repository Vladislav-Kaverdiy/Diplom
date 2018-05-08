package diploma.com.servlets.commands.application;

import com.google.gson.Gson;
import diploma.com.exception.AppException;
import diploma.com.exception.Messages;
import diploma.com.servlets.Path;
import diploma.com.servlets.commands.Command;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.util.Locale;


/**
 * Created by Student on 09.12.2017.
 */
public class ChangeLocaleCommand implements Command {
    private static final Logger LOG = Logger.getLogger(ChangeLocaleCommand.class);

    @Override
    public String execute(HttpServletRequest request,
                          HttpServletResponse response) throws IOException, ServletException,
            AppException {
        LOG.debug("Command starts");
        try {
            String requestLocale = request.getParameter("locale");
            LOG.trace("Get locale --> " + requestLocale);
            Locale locale = new Locale(requestLocale);
            Config.set(request.getSession(false), Config.FMT_LOCALE, locale);
            HttpSession session = request.getSession(false);
            if (session != null) {
                request.getSession(false).removeAttribute("currentLocale");
                if (requestLocale.equals("en")) {
                    request.getSession(false).setAttribute("currentLocale", "");
                } else {
                    request.getSession(false).setAttribute("currentLocale", requestLocale);
                }
            }
            String json = new Gson().toJson(true);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
            LOG.debug("Command finished");
            return "";

        } catch (Exception ex) {
            LOG.error(Messages.ERR_CANNOT_CHANGE_LOCALE, ex);
            request.setAttribute("errorMessage", Messages.ERR_CANNOT_CHANGE_LOCALE);
            request.setAttribute("exceptionMessage", ex.getMessage());
            return Path.PAGE_ERROR_PAGE;
        }
    }
}

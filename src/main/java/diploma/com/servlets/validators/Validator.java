package diploma.com.servlets.validators;


import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    public static List<String> getLoginErrors(HttpServletRequest request) {
        List<String> result = new ArrayList<>();
        if (request.getParameter("login").equals("")) {
            result.add("Login cannot be empty");
        }
        if (request.getParameter("password").equals("")) {
            result.add("Password cannot be empty");
        }
        return result;
    }

    public static List<String> getRegistrationErrors(HttpServletRequest request) {
        List<String> result = new ArrayList<>();
        if (request.getParameter("name").equals("")) {
            result.add("Name cannot be empty");
        }
        if (request.getParameter("email").equals("")) {
            result.add("Email cannot be empty");
        }
        if (request.getParameter("login").equals("")) {
            result.add("Login cannot be empty");
        }
        if (request.getParameter("password").equals("")) {
            result.add("Password cannot be empty");
        }
        return result;
    }
}



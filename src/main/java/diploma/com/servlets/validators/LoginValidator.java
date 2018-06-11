package diploma.com.servlets.validators;


import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

public class LoginValidator {
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
}



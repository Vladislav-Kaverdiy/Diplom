package source.it.com.servlets.validators;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Student on 25.11.2017.
 */

public class RegistrationValidator {
    Pattern pattern;
    Matcher matcher;

    public List<String> validate(HttpServletRequest request){
        List<String> errors = new ArrayList<>();

//////////////////User Name////////////////////////////////////////

        String userName = request.getParameter("userName");
        String checkName = "^[a-zA-Z0-9_-]{3,15}$";
        pattern = Pattern.compile(checkName);
        matcher = pattern.matcher(userName);
        if(userName == null || userName.isEmpty()){
            errors.add("User Name cannot be empty!");
        }
        else  if(!matcher.matches())
        {
            errors.add("Your UserName  is invalid!");
        }

//////////////////////////Login//////////////////////////////////

        String login = request.getParameter("login");
        String checkLogin = "^[a-zA-Z0-9_-]{3,15}$";
        pattern = Pattern.compile(checkLogin);
        matcher = pattern.matcher(login);
        if(login == null || login.isEmpty()){
            errors.add("Login cannot be empty!");
        }
        else  if(!matcher.matches()) {
            errors.add("Your Login  is invalid!");
        }

        //////////////////////////Email//////////////////////////////////

        String email = request.getParameter("email");
        String checkEmail = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
        pattern = Pattern.compile(checkEmail);
        matcher = pattern.matcher(email);
        if (email == null || email.isEmpty()) {
            errors.add("Email cannot empty!");
        }
        else  if(!matcher.matches()) {
            errors.add("Your email address is invalid!(You have to enter for example ****@mail/gmail.ru/com)");
        }

//////////////////////////Password//////////////////////////////////

        String password = request.getParameter("password");
        String checkPassword = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,14})";
        pattern = Pattern.compile(checkPassword);
        matcher = pattern.matcher(password);

        if(password == null || password.isEmpty()){
            errors.add("Password cannot be empty!");
        }
        else  if(!matcher.matches()) {
            errors.add("Your password is invalid!(You must enter at least 8 characters, lower and uppercase," +
                    "must contain at least 1 digit)");
        }

        return  errors;
    }


}

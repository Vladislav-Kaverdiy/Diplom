package diploma.com.servlets.validators;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreditCardValidator {

    Pattern pattern;
    Matcher matcher;

    public List<String> validate(HttpServletRequest request) {
        List<String> errors = new ArrayList<>();

/////////////////credit card Number////////////////////////////////////////

        String creditcardNumber = request.getParameter("creditcardNumber");
        String checkName = "[0-9]{13,16}";
        pattern = Pattern.compile(checkName);
        matcher = pattern.matcher(creditcardNumber);
        if (creditcardNumber == null || creditcardNumber.isEmpty()) {
            errors.add("Credit Card Number cannot be empty!");
        } else if (!matcher.matches()) {
            errors.add("Your Credit Card Number  is invalid!");
        }

        return  errors;
    }
}

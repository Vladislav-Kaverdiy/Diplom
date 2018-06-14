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

        /////////////////credit card Month////////////////////////////////////////

        String creditcardMonth = request.getParameter("creditcardMonth");
        String checkMonth = "[0-9]{1,2}";
        pattern = Pattern.compile(checkMonth);
        matcher = pattern.matcher(creditcardMonth);
        if (creditcardMonth == null || creditcardMonth.isEmpty()) {
            errors.add("Month cannot be empty!");
        } else if (!matcher.matches()) {
            errors.add("Your Month  is invalid!");
        }
        /////////////////credit card Year ////////////////////////////////////////

        String creditcardYear = request.getParameter("creditcardYear");
        String checkYear = "[0-9]{4}";
        pattern = Pattern.compile(checkYear);
        matcher = pattern.matcher(creditcardYear);
        if (creditcardYear == null || creditcardYear.isEmpty()) {
            errors.add("Year cannot be empty!");
        } else if (!matcher.matches()) {
            errors.add("Your Year  is invalid!");
        }

        /////////////////credit card CVS ////////////////////////////////////////

        String creditcardCVS = request.getParameter("creditcardCVS");
        String checkCVS = "[0-9]{3}";
        pattern = Pattern.compile(checkCVS);
        matcher = pattern.matcher(creditcardCVS);
        if (creditcardCVS == null || creditcardCVS.isEmpty()) {
            errors.add("CVV cannot be empty!");
        } else if (!matcher.matches()) {
            errors.add("Your CVV  is invalid!");
        }

        /////////////////Balance ////////////////////////////////////////

        String balance = request.getParameter("balance");
        matcher = pattern.matcher(balance);
        if (balance == null || balance.isEmpty()) {
            errors.add("Balance cannot be empty!");
        }
        /////////////////Description ////////////////////////////////////////

        String description = request.getParameter("description");
        matcher = pattern.matcher(description);
        if (description == null || description.isEmpty()) {
            errors.add("Description cannot be empty!");
        }
        return  errors;
    }
}

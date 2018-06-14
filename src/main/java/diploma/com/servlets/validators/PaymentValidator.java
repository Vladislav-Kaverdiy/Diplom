package diploma.com.servlets.validators;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentValidator {
    Pattern pattern;
    Matcher matcher;

    public List<String> validate(HttpServletRequest request) {
        List<String> errors = new ArrayList<>();

/////////////////Sum////////////////////////////////////////

        String sum = request.getParameter("sum");
        matcher = pattern.matcher(sum);
        if (sum == null || sum.isEmpty()) {
            errors.add("Sum cannot be empty!");
        }

        /////////////////description////////////////////////////////////////

        String description = request.getParameter("description");
        matcher = pattern.matcher(description);
        if (description == null || description.isEmpty()) {
            errors.add("Description cannot be empty!");
        }

        /////////////////recipient Bill ////////////////////////////////////////

        String recipientBill = request.getParameter("recipientBill");

        matcher = pattern.matcher(recipientBill);
        if (recipientBill == null || recipientBill.isEmpty()) {
            errors.add("Recipient Bill cannot be empty!");
        }
        return errors;
    }
}


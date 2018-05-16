package diploma.com.servlets;

/**
 * Created by Student on 22.11.2017.
 */
public interface Path {
    String PAGE_ERROR_PAGE = "/errorPage.jsp";
    String COMMAND_CLIENT_MANAGE_CREDIT_CARD = "/servlet.do?command=manageCreditCard";
    String COMMAND_MANAGE_USER = "/servlet.do?command=manageUser";

    String COMMAND_CLIENT_MANAGE_CREDIT_CARD_ADMIN = "/servlet.do?command=manageCreditCardAdmin";
    String PAGE_CLIENT_MANAGE_BILLS = "/creditCards.jsp";
    String PAGE_ADMIN_MANAGE_BILLS = "/creditCardsAdmin.jsp";
    String PAGE_CLIENT_ERROR_PAGE = "/errorPage.jsp";
    String PAGE_REGISTRATION = "/registration.jsp";
    String LOGIN_PAGE = "/login.jsp";
    String COMMAND_CLIENT_MANAGE_USER_PAYMENT = "/servlet.do?command=managePayments";
    String PAGE_CLIENT_MANAGE_PAYMENT = "/userPayment.jsp";
    String HOME_PAGE = "/home.jsp";
    String SERVLET_USERS_PAGE = "/servlet.do?command=manageUser";
    String USERS_PAGE = "/users.jsp";
    String REQUESTS_PAGE = "/servlet.do?command=manageRequest";
    String COMMAND_MANAGE_PAYMENTS = "/servlet.do?command=managePayments";
    String PAGE_ADD_BAlANCE = "/addMoney.jsp";
    String PAGE_EDIT_CREDIT_CARD= "/editCreditCard.jsp";
    String PAGE_EDIT_USER= "/editUser.jsp";
    String PAGE_ADD_PAYMENT = "/addPayment.jsp";
    String PAGE_EDIT_PAYMENT = "/editPayment.jsp";
}

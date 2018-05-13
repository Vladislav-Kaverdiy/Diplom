package diploma.com.service;

import diploma.com.database.DBManager;
import diploma.com.exception.DBException;
import diploma.com.model.UserPayment;

import java.sql.Connection;

/**
 * Created by Student on 29.11.2017.
 */
public class PaymentService {
    public void createPayment(UserPayment userPayment) throws DBException {

        Connection connection = DBManager.getInstance().getConnection();

/*
        try {
            CreditCardDaoImpl creditCardDao = new CreditCardDaoImpl();
            UserPaymentDao userPaymentDao = new UserPaymentDao();
            CreditCard creditCard = creditCardDao.getCreditCardsById(connection);
            creditCard.setBalance(creditCard.getBalance()- userPayment.getSum());
            creditCardDao.updateCreditCard(creditCard, connection);
            userPaymentDao.addUserPayment(userPayment, connection);
            connection.commit();
        } catch (SQLException e) {
            connection.rollback();
            e.printStackTrace();
        }*/
    }
}

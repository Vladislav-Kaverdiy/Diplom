package source.it.com.service;

import source.it.com.database.DBManager;
import source.it.com.database.dao.CreditCardDao;
import source.it.com.database.dao.UserPaymentDao;
import source.it.com.exception.DBException;
import source.it.com.model.CreditCard;
import source.it.com.model.UserPayment;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Student on 29.11.2017.
 */
public class PaymentService {
    public void createPayment(UserPayment userPayment) throws DBException {

        Connection connection = DBManager.getInstance().getConnection();

/*
        try {
            CreditCardDao creditCardDao = new CreditCardDao();
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

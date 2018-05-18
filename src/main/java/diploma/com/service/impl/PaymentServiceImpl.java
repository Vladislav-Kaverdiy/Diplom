package diploma.com.service.impl;

import diploma.com.database.dao.UserPaymentDao;
import diploma.com.database.daoImpl.UserPaymentImpl;
import diploma.com.model.UserPayment;
import diploma.com.service.PaymentService;

import java.sql.SQLException;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {

    UserPaymentDao userPaymentDao = new UserPaymentImpl();

    @Override
    public List<UserPayment> getPaymentByCreditCardId(Integer creditCardId) throws SQLException {
        return userPaymentDao.getPaymentByCreditCardId(creditCardId);
    }

    @Override
    public void addUserPayment(UserPayment userPayment) throws SQLException {
        userPaymentDao.addUserPayment(userPayment);
    }

    @Override
    public UserPayment findUserPaymentById(Integer paymentId) throws SQLException {
        return userPaymentDao.findUserPaymentById(paymentId);
    }

    @Override
    public void deleteUserPaymentById(Integer paymentId) throws SQLException {
        userPaymentDao.deleteUserPaymentById(paymentId);
    }

    @Override
    public void updateUserPayment(UserPayment userPayment) throws SQLException {
        userPaymentDao.updateUserPayment(userPayment);
    }

    @Override
    public void updateUserPaymentState(boolean state, Integer paymentId) throws SQLException {
        userPaymentDao.updateUserPaymentState(state, paymentId);
    }
}

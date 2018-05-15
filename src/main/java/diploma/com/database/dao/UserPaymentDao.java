package diploma.com.database.dao;

import diploma.com.model.UserPayment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UserPaymentDao {

     List<UserPayment> getPaymentByCreditCardId(Integer creditCardId) throws SQLException;

     void addUserPayment(UserPayment userPayment) throws SQLException;

     UserPayment extractUserPayment(ResultSet rs) throws SQLException;

     UserPayment findUserPaymentById(Integer paymentId) throws SQLException;

     void deleteUserPaymentById(Integer paymentId) throws SQLException;

     void updateUserPayment(UserPayment userPayment) throws SQLException;

     void updateUserPaymentState(boolean state, Integer paymentId) throws SQLException;
}

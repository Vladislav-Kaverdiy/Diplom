/*
package diploma.com.database.dao;

import org.junit.Test;
import diploma.com.exception.DBException;
import diploma.com.model.UserPayment;

import static org.junit.Assert.assertNotEquals;

public class UserPaymentDaoTest {
    @Test
    public void shouldCreateUserPayment() throws DBException {
        UserPaymentDao userPaymentDao = new UserPaymentDao();
        UserPayment userPayment = new UserPayment();
        userPayment.setConfirmationDate(1);
        userPayment.setCreationDate(2);
        userPayment.setStateId(1);
        userPayment.setCreditCardId(1);
        userPayment.setSum(100);
        userPayment.setDescription("First UserPayment");
        userPayment.setRecipientBill(100);
        UserPayment userPayment1 = userPaymentDao.addUserPayment(userPayment);
        assertNotEquals(userPayment1.getPaymentId(),0);

    }
    @Test
    public void shouldGetUserPayment() throws DBException {
        UserPaymentDao userPaymentDao = new UserPaymentDao();
        UserPayment userPayment = new UserPayment();
        userPayment.setConfirmationDate(1);
        userPayment.setCreationDate(2);
        userPayment.setStateId(1);
        userPayment.setCreditCardId(1);
        userPayment.setSum(100);
        userPayment.setDescription("First UserPayment");
        userPayment.setRecipientBill(100);
        userPaymentDao.getUserPayment();

    }
    @Test
    public void shouldFindUserPaymentById()throws DBException{
        UserPaymentDao userPaymentDao = new UserPaymentDao();
        UserPayment userPayment = new UserPayment();
        userPayment.setConfirmationDate(1);
        userPayment.setCreationDate(2);
        userPayment.setStateId(1);
        userPayment.setCreditCardId(1);
        userPayment.setSum(100);
        userPayment.setDescription("First UserPayment");
        userPayment.setRecipientBill(100);
        userPayment.setPaymentId(1);
        userPaymentDao.findUserPaymentById(1);

    }
    @Test
    public void shouldUpdateUserPaymentState() throws DBException {
        UserPaymentDao userPaymentDao = new UserPaymentDao();
        UserPayment userPayment = new UserPayment();
        userPayment.setConfirmationDate(1);
        userPayment.setCreationDate(2);
        userPayment.setStateId(1);
        userPayment.setCreditCardId(1);
        userPayment.setSum(100);
        userPayment.setDescription("First UserPayment");
        userPayment.setRecipientBill(100);
        userPayment.setPaymentId(1);
        userPaymentDao.addUserPayment(userPayment);
        userPaymentDao.updateUserPaymentState(false,1);
    }
    @Test
    public void shouldUpdateUserPayment() throws DBException {
        UserPaymentDao userPaymentDao = new UserPaymentDao();
        UserPayment userPayment = new UserPayment();
        userPayment.setConfirmationDate(1);
        userPayment.setCreationDate(2);
        userPayment.setStateId(1);
        userPayment.setCreditCardId(1);
        userPayment.setSum(100);
        userPayment.setDescription("First UserPayment");
        userPayment.setRecipientBill(100);
        userPayment.setPaymentId(1);
        userPaymentDao.addUserPayment(userPayment);
        userPayment.setSum(200);
        userPaymentDao.updateUserPayment(userPayment);
    }



}
*/

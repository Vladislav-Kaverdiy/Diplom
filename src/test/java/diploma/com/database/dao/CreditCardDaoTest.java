/*
package diploma.com.database.dao;

import org.junit.Test;

import diploma.com.exception.DBException;
import diploma.com.model.CreditCard;


public class CreditCardDaoTest {
    @Test
    public void shouldCreateCreditCard() throws DBException {
        CreditCardDao creditCardDao = new CreditCardDao();
        CreditCard card = new CreditCard();
        card.setBill(100);
        card.setCreditCardNumber(123);
        card.setDescription("First creditCard");
        card.setMonthExpiration(8);
        card.setYearExpiration(2);
        card.setCvs(10);
        card.setBlocked(false);
        card.setBalance(10);
        card.setUserId(1);
        creditCardDao.addCreditCards(card);

    }

    @Test
    public void shouldGetCreditCardsByUserId() throws DBException {
        CreditCardDao creditCardDao = new CreditCardDao();
        CreditCard card = new CreditCard();
        card.setBill(1000);
        card.setCreditCardNumber(351234);
        card.setDescription("First creditCard");
        card.setMonthExpiration(12);
        card.setYearExpiration(2018);
        card.setCvs(10);
        card.setBlocked(false);
        card.setBalance(255.5);
        card.setUserId(1);
        creditCardDao.getCreditCardsByUserId(1);

    }

    @Test
    public void shouldGetNotBlockedCreditCardsByUserId() throws DBException {
        CreditCardDao creditCardDao = new CreditCardDao();
        CreditCard card = new CreditCard();
        card.setBill(1000);
        card.setCreditCardNumber(351234);
        card.setDescription("First creditCard");
        card.setMonthExpiration(12);
        card.setYearExpiration(2018);
        card.setCvs(10);
        card.setBlocked(false);
        card.setBalance(255.5);
        card.setUserId(2);
        creditCardDao.getNotBlockedCreditCardsByUserId(2);

    }

    @Test
    public void shouldFindCreditCardById() throws DBException {
        CreditCardDao creditCardDao = new CreditCardDao();
        CreditCard card = new CreditCard();
        card.setBill(1000);
        card.setCreditCardNumber(351234);
        card.setDescription("First creditCard");
        card.setMonthExpiration(12);
        card.setYearExpiration(2018);
        card.setCvs(10);
        card.setBlocked(false);
        card.setBalance(255.5);
        card.setUserId(1);
        card.setCreditCardId(1);
        creditCardDao.findCreditCardById(1);


    }

    @Test
    public void shouldUpdateCreditCard() throws DBException {
        CreditCardDao creditCardDao = new CreditCardDao();
        CreditCard card = new CreditCard();
        card.setBill(1000);
        card.setCreditCardNumber(351234);
        card.setDescription("First creditCard");
        card.setMonthExpiration(12);
        card.setYearExpiration(2018);
        card.setCvs(10);
        card.setBlocked(false);
        card.setBalance(255.5);
        card.setUserId(1);
        creditCardDao.updateCreditCard(card);

    }
    @Test
    public void shouldUpdateCreditCardState() throws DBException {
        CreditCardDao creditCardDao = new CreditCardDao();
        CreditCard card = new CreditCard();
        card.setBill(1000);
        card.setCreditCardNumber(351234);
        card.setDescription("First creditCard");
        card.setMonthExpiration(12);
        card.setYearExpiration(2018);
        card.setCvs(10);
        card.setBlocked(true);
        card.setBalance(255.5);
        card.setUserId(1);
        creditCardDao.addCreditCards(card);
        card.setBlocked(false);
        creditCardDao.updateCreditCardState(true, 1);
    }
}*/

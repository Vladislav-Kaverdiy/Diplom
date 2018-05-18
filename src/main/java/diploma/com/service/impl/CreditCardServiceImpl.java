package diploma.com.service.impl;

import diploma.com.database.dao.CreditCardDao;
import diploma.com.database.daoImpl.CreditCardDaoImpl;
import diploma.com.model.CreditCard;
import diploma.com.service.CreditCardService;

import java.sql.SQLException;
import java.util.List;

public class CreditCardServiceImpl implements CreditCardService {
    private CreditCardDao creditCardDao = new CreditCardDaoImpl();

    @Override
    public List<CreditCard> getCreditCardsByUserId(Integer userId) throws SQLException {
        return creditCardDao.getCreditCardsByUserId(userId);
    }

    @Override
    public void addCreditCards(CreditCard creditCard) throws SQLException {
        creditCardDao.addCreditCards(creditCard);
    }

    @Override
    public CreditCard findCreditCardById(Integer creditCardId) throws SQLException {
        return creditCardDao.findCreditCardById(creditCardId);
    }

    @Override
    public void updateCreditCardBalance(CreditCard creditCard) throws SQLException {
        creditCardDao.updateCreditCardBalance(creditCard);
    }

    @Override
    public void deleteCreditCardById(Integer creditCardId) throws SQLException {
        creditCardDao.deleteCreditCardById(creditCardId);
    }

    @Override
    public void updateCreditCard(CreditCard creditCard) throws SQLException {
        creditCardDao.updateCreditCard(creditCard);
    }

    @Override
    public void updateCreditCardState(boolean creditCardState, Integer creditCardId) throws SQLException {
        creditCardDao.updateCreditCardState(creditCardState, creditCardId);
    }
}

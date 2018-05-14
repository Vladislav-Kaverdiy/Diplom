package diploma.com.database.dao;

import diploma.com.model.CreditCard;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CreditCardDao {

    List<CreditCard> getCreditCardsByUserId(Integer userId) throws SQLException;

    void addCreditCards(CreditCard creditCard) throws SQLException;

    CreditCard findCreditCardById(Integer creditCardId) throws SQLException;

    void updateCreditCardBalance(CreditCard creditCard) throws SQLException;

    void deleteCreditCardById(Integer creditCardId) throws SQLException;

    void updateCreditCard(CreditCard creditCard) throws SQLException;

    void updateCreditCardState(boolean creditCardState, Integer creditCardId) throws SQLException;

    CreditCard extractCreditCard(ResultSet rs) throws SQLException;
}

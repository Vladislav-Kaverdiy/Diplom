package diploma.com.database.daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import diploma.com.database.dao.CreditCardDao;
import org.apache.log4j.Logger;

import diploma.com.database.DBFields;
import diploma.com.database.DBManager;
import diploma.com.database.DBQueries;
import diploma.com.exception.Messages;
import diploma.com.model.CreditCard;


public class CreditCardDaoImpl implements CreditCardDao {

    private DBManager db = DBManager.getInstance();
    private static final Logger LOG = Logger.getLogger(CreditCardDaoImpl.class);

    @Override
    public List<CreditCard> getCreditCardsByUserId(Integer userId) throws SQLException {

        List<CreditCard> creditCards = new ArrayList<>();

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_FIND_ALL_CREDIT_CARDS_BY_USER_ID)) {

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                creditCards.add(extractCreditCard(resultSet));
            }
            LOG.error(Messages.ERR_CANNOT_OBTAIN_CREDIT_CARD_BY_USER_ID);
        }
        return creditCards;
    }

    @Override
    public void addCreditCards(CreditCard creditCard) throws SQLException {

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_INSERT_CREDIT_CARD)) {

            preparedStatement.setLong(1, creditCard.getBill());
            preparedStatement.setLong(2, creditCard.getCreditCardNumber());
            preparedStatement.setString(3, creditCard.getDescription());
            preparedStatement.setInt(4, creditCard.getMonthExpiration());
            preparedStatement.setInt(5, creditCard.getYearExpiration());
            preparedStatement.setInt(6, creditCard.getCvs());
            preparedStatement.setBoolean(7, creditCard.isBlocked());
            preparedStatement.setDouble(8, creditCard.getBalance());
            preparedStatement.setInt(9, creditCard.getUserId());
            Integer result = preparedStatement.executeUpdate();
            if (result > 0) {
                LOG.trace("-- Credit card inserted -->" + creditCard.toString());
            } else {
                LOG.error(Messages.ERR_CANNOT_ADD_CREDIT_CARD
                        + creditCard.toString());
            }
            LOG.error(Messages.ERR_CANNOT_ADD_CREDIT_CARD);
        }
    }

    @Override
    public CreditCard findCreditCardById(Integer creditCardId) throws SQLException {
        CreditCard creditCard = null;

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_FIND_CREDIT_CARD_BY_ID)) {

            preparedStatement.setInt(1, creditCardId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                creditCard = extractCreditCard(resultSet);
            }
        }
        return creditCard;
    }

    @Override
    public void updateCreditCardBalance(CreditCard creditCard) throws SQLException {

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_UPDATE_BALANCE_CREDIT_CARD)) {

            preparedStatement.setDouble(1, creditCard.getBalance());
            preparedStatement.setInt(2, creditCard.getCreditCardId());
            preparedStatement.executeUpdate();
            LOG.error(Messages.ERR_CANNOT_UPDATE_BALANCE_BY_CREDIT_CARD);
        }
    }

    @Override
    public void deleteCreditCardById(Integer creditCardId) throws SQLException {

        try(Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_DELETE_CREDIT_CARD_BY_CREDIT_CARD_ID))
        {
            preparedStatement.setInt(1, creditCardId);
            preparedStatement.executeUpdate();
            LOG.error(Messages.ERR_CANNOT_DELETE_CREDIT_CARD);
        }
    }

    @Override
    public void updateCreditCard(CreditCard creditCard) throws SQLException {

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_UPDATE_CREDIT_CARD)) {

            preparedStatement.setBoolean(1, creditCard.isBlocked());
            preparedStatement.setDouble(2, creditCard.getBalance());
            preparedStatement.setInt(3, creditCard.getCreditCardId());
            preparedStatement.executeUpdate();
            LOG.error(Messages.ERR_CANNOT_UPDATE_CREDIT_CARD);
        }
    }

    @Override
    public void updateCreditCardState(boolean creditCardState, Integer creditCardId) throws SQLException {

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_UPDATE_CREDIT_CARD_STATE)) {

            preparedStatement.setBoolean(1, creditCardState);
            preparedStatement.setInt(2, creditCardId);
            preparedStatement.executeUpdate();
            LOG.error(Messages.ERR_CANNOT_UPDATE_CREDIT_CARD);
        }
    }

    @Override
    public void insertCreditCardBalance(CreditCard creditCard) throws SQLException {

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_INSERT_BALANCE_CREDIT_CARD)) {

            preparedStatement.setDouble(1, creditCard.getBalance());
            preparedStatement.executeUpdate();
            LOG.error(Messages.ERR_CANNOT_UPDATE_CREDIT_CARD);
        }
    }

    @Override
    public List<CreditCard> getNotBlockedCreditCardsByUserId(Integer userId) throws SQLException {
        List<CreditCard> creditCards = new ArrayList<>();

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_FIND_NOT_BLOCKED_CREDIT_CARD_BY_ID)) {

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                creditCards.add(extractCreditCard(resultSet));
            }
            LOG.error(Messages.ERR_CANNOT_OBTAIN_CREDIT_CARD_BY_USER_ID);
        }
        return creditCards;
    }

    @Override
    public CreditCard extractCreditCard(ResultSet rs) throws SQLException {
        CreditCard creditCard = new CreditCard();
        creditCard.setBill(rs.getLong(DBFields.BILL));
        creditCard.setCreditCardNumber(rs.getLong(DBFields.CREDIT_CARD_NUMBER));
        creditCard.setDescription(rs.getString(DBFields.DESCRIPTION));
        creditCard.setMonthExpiration(rs.getInt(DBFields.MONTH_EXPIRATION));
        creditCard.setYearExpiration(rs.getInt(DBFields.YEAR_EXPIRATION));
        creditCard.setCvs(rs.getInt(DBFields.CVS));
        creditCard.setBlocked(rs.getBoolean(DBFields.BLOCKED));
        creditCard.setBalance(rs.getDouble(DBFields.BALANCE));
        creditCard.setUserId(rs.getInt(DBFields.USER_ID));
        creditCard.setCreditCardId(rs.getInt(DBFields.CREDIT_CARD_ID));
        return creditCard;
    }
}

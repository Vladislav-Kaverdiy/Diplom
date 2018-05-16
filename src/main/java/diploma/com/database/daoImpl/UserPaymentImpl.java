package diploma.com.database.daoImpl;

import diploma.com.database.DBFields;
import diploma.com.database.DBManager;
import diploma.com.database.DBQueries;
import diploma.com.database.dao.UserPaymentDao;
import diploma.com.exception.Messages;
import diploma.com.model.UserPayment;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserPaymentImpl implements UserPaymentDao {

    private DBManager db = DBManager.getInstance();
    private static final Logger LOG = Logger.getLogger(UserPaymentImpl.class);

    @Override
    public List<UserPayment> getPaymentByCreditCardId(Integer creditCardId) throws SQLException {

        List<UserPayment> userPayments = new ArrayList<>();

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_FIND_USER_PAYMENT_BY_CREDIT_CARD_ID)) {

            preparedStatement.setInt(1, creditCardId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                userPayments.add(extractUserPayment(resultSet));
            }
            LOG.error(Messages.ERR_CANNOT_OBTAIN_USER_PAYMENT_BY_CREDIT_CARD_ID);
        }
        return userPayments;
    }

    @Override
    public void addUserPayment(UserPayment userPayment) throws SQLException {

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_INSERT_USER_PAYMENTS)) {
            preparedStatement.setDate(1,new java.sql.Date (userPayment.getCreationDate().getTime()));
            preparedStatement.setBoolean(2, userPayment.isState());
            preparedStatement.setDouble(3, userPayment.getSum());
            preparedStatement.setString(4, userPayment.getDescription());
            preparedStatement.setLong(5, userPayment.getRecipientBill());
            preparedStatement.setInt(6, userPayment.getCreditCardId());
            Integer result = preparedStatement.executeUpdate();
            if (result > 0) {
                LOG.trace("-- Credit card inserted -->" + userPayment.toString());
            } else {
                LOG.error(Messages.ERR_CANNOT_ADD_USER_PAYMENT
                        + userPayment.toString());
            }
            LOG.error(Messages.ERR_CANNOT_ADD_USER_PAYMENT);
        }
    }

    @Override
    public UserPayment findUserPaymentById(Integer paymentId) throws SQLException {
        UserPayment userPayment = null;

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_FIND_USER_PAYMENTS_BY_ID)) {

            preparedStatement.setInt(1, paymentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                userPayment = extractUserPayment(resultSet);
            }
        }
        return userPayment;
    }


    @Override
    public void deleteUserPaymentById(Integer paymentId) throws SQLException {

        try(Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_DELETE_USER_PAYMENT_BY_ID))
        {
            preparedStatement.setInt(1, paymentId);
            preparedStatement.executeUpdate();
            LOG.error(Messages.ERR_CANNOT_DELETE_USER_PAYMENT);
        }
    }

    @Override
    public void updateUserPayment(UserPayment userPayment) throws SQLException {

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_UPDATE_USER_PAYMENT)) {

            preparedStatement.setDate(1,new java.sql.Date (userPayment.getCreationDate().getTime()));
            preparedStatement.setDouble(2, userPayment.getSum());
            preparedStatement.setString(3, userPayment.getDescription());
            preparedStatement.setLong(4, userPayment.getRecipientBill());
            preparedStatement.setInt(5, userPayment.getPaymentId());
            preparedStatement.executeUpdate();
            LOG.error(Messages.ERR_CANNOT_UPDATE_USER_PAYMENT);
        }
    }

    @Override
    public void updateUserPaymentState(boolean state, Integer paymentId) throws SQLException {

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_UPDATE_USER_PAYMENT_STATE)) {

            preparedStatement.setBoolean(1, state);
            preparedStatement.setInt(2, paymentId);
            preparedStatement.executeUpdate();
            LOG.error(Messages.ERR_CANNOT_UPDATE_USER_PAYMENT);
        }
    }

    @Override
    public UserPayment extractUserPayment(ResultSet rs) throws SQLException {
        UserPayment userPayment = new UserPayment();
        userPayment.setPaymentId(rs.getInt(DBFields.PAYMENT_ID));
        userPayment.setCreationDate(rs.getDate(DBFields.CREATION_DATE));
        userPayment.setState(rs.getBoolean(DBFields.STATE));
        userPayment.setCreditCardId(rs.getInt(DBFields.CREDIT_CARD_ID));
        userPayment.setSum(rs.getDouble(DBFields.SUM));
        userPayment.setDescription(rs.getString(DBFields.DESCRIPTION));
        userPayment.setRecipientBill(rs.getLong(DBFields.RECIPIENT_BILL));

        return userPayment;
    }
}


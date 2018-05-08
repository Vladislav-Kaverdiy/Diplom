package diploma.com.database.dao;

import diploma.com.database.daoImpl.UserDaoImpl;
import org.apache.log4j.Logger;
import diploma.com.database.DBFields;
import diploma.com.database.DBManager;
import diploma.com.database.DBQueries;
import diploma.com.exception.DBException;
import diploma.com.exception.Messages;
import diploma.com.model.UserPayment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserPaymentDao {
    private static DBManager db;
    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class);

    public List<UserPayment> getUserPayment() throws DBException {
        List<UserPayment> userPayments = new ArrayList<UserPayment>();
        Statement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(DBQueries.SQL_FIND_ALL_USER_PAYMENTS);
            while (rs.next()) {
                userPayments.add(extractUserPayment(rs));
            }
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_OBTAIN_USER_PAYMENTS, ex);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_USER_PAYMENTS, ex);
        } finally {
            db.close(con, stmt, rs);
        }
        return userPayments;
    }
    public static List<UserPayment> getUserPaymentByUserId(int userId)
            throws DBException {
        List<UserPayment> userPayments = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con
                    .prepareStatement(DBQueries.SQL_FIND_ALL_CREDIT_CARDS_BY_USER_ID);
            pstmt.setInt(1, userId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                userPayments.add(extractUserPayment(rs));
            }
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_OBTAIN_CREDIT_CARD_BY_USER_ID, ex);
            throw new DBException(
                    Messages.ERR_CANNOT_OBTAIN_CREDIT_CARD_BY_USER_ID, ex);
        } finally {
            db.close(con, pstmt, rs);
        }
        return userPayments;
    }

    public UserPayment addUserPayment(UserPayment userPayment) throws DBException {
        PreparedStatement pstmt = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_INSERT_USER_PAYMENTS, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1,(userPayment.getConfirmationDate()));
            pstmt.setInt(2,(userPayment.getCreationDate()));
            pstmt.setInt(3,userPayment.getStateId());
            pstmt.setInt(4,userPayment.getCreditCardId());
            pstmt.setDouble(5,userPayment.getSum());
            pstmt.setString(6, userPayment.getDescription());
            pstmt.setLong(7,userPayment.getRecipientBill());
            int result = pstmt.executeUpdate();
            if (result > 0) {
                LOG.trace("-- UserPayments inserted -->" + userPayment.toString());
            } else {
                LOG.error(Messages.ERR_CANNOT_ADD_CREDIT_CARD
                        + userPayment.toString());
            }
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                userPayment.setPaymentId(generatedKeys.getInt(1));
            }
            con.commit();
            return userPayment;
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_ADD_CREDIT_CARD, ex);
            throw new DBException(Messages.ERR_CANNOT_ADD_CREDIT_CARD, ex);
        } finally {
            db.close(con);
            db.close(pstmt);
        }
    }
    public UserPayment findUserPaymentById(int paymentId) throws DBException {
        UserPayment userPayment = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_FIND_USER_PAYMENTS_BY_ID);
            pstmt.setInt(1, paymentId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                userPayment = extractUserPayment(rs);
            }
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);

        } finally {
            db.close(con, pstmt, rs);
        }
        return userPayment;
    }


    public void updateUserPaymentState(boolean userPaymentState, int paymentId)
            throws DBException {

        PreparedStatement pstmt = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_UPDATE_USER_PAYMENTS_STATE);
            int counter = 1;
            pstmt.setBoolean(counter++, userPaymentState);
            pstmt.setInt(counter++, paymentId);
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);

        } finally {
            db.close(con, pstmt);
        }
    }

    public void updateUserPayment(UserPayment userPayment) throws DBException {

        PreparedStatement pstmt = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_UPDATE_USER_PAYMENTS);
            int counter = 1;
            pstmt.setInt(counter++, userPayment.getConfirmationDate());
            pstmt.setInt(counter++, userPayment.getCreationDate());
            pstmt.setInt(counter++, userPayment.getStateId());
            pstmt.setInt(counter++, userPayment.getCreditCardId());
            pstmt.setDouble(counter++, userPayment.getSum());
            pstmt.setString(counter++, userPayment.getDescription());
            pstmt.setLong(counter++, userPayment.getRecipientBill());
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);

        } finally {
            db.close(con, pstmt);
        }
    }

    private static UserPayment extractUserPayment(ResultSet rs) throws SQLException {
        UserPayment userPayment = new UserPayment();
        userPayment.setPaymentId(rs.getInt(DBFields.PAYMENT_ID));
        userPayment.setConfirmationDate(rs.getInt(DBFields.CONFIRMATION_DATE));
        userPayment.setCreationDate(rs.getInt(DBFields.CREATION_DATE));
        userPayment.setStateId(rs.getInt(DBFields.STATE_ID));
        userPayment.setCreditCardId(rs.getInt(DBFields.CREDIT_CARD_ID));
        userPayment.setSum(rs.getDouble(DBFields.SUM));
        userPayment.setDescription(rs.getString(DBFields.DESCRIPTION));
        userPayment.setRecipientBill(rs.getLong(DBFields.RECIPIENT_BILL));

        return userPayment;
    }

}

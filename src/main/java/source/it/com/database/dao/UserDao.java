package source.it.com.database.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import source.it.com.database.DBFields;
import source.it.com.database.DBManager;
import source.it.com.database.DBQueries;
import source.it.com.exception.DBException;
import source.it.com.exception.Messages;
import source.it.com.model.Role;
import source.it.com.model.User;

public class UserDao {
    private DBManager db;
    private static final Logger LOG = Logger.getLogger(UserDao.class);

    public List<User> getUsers() throws DBException {
        List<User> users = new ArrayList<User>();
        Statement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(DBQueries.SQL_FIND_ALL_USERS);
            while (rs.next()) {
                users.add(extractUser(rs));
            }
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_OBTAIN_USERS, ex);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_USERS, ex);
        } finally {
            db.close(con, stmt, rs);
        }
        return users;
    }

    public User findUserByLogin(String login) throws DBException {
        User user = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_FIND_USER_BY_LOGIN);
            pstmt.setString(1, login);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                user = extractUser(rs);
            }
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_OBTAIN_USER_BY_LOGIN, ex);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_USER_BY_LOGIN, ex);
        } finally {
            db.close(con, pstmt, rs);
        }
        return user;
    }

    public Role findRoleByRoleName(String roleName) throws DBException {
        Role role = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_FIND_ROLE_BY_ROLE_NAME);
            pstmt.setString(1, roleName);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                role = extractRole(rs);
            }
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_OBTAIN_ROLE_BY_ROLE_NAME, ex);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_ROLE_BY_ROLE_NAME,
                    ex);
        } finally {
            db.close(con, pstmt, rs);
        }
        return role;
    }
    public Role findUserRole(User user) throws DBException {
        Role role = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_FIND_USER_ROLE);
            pstmt.setInt(1, user.getRoleId());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                role = extractRole(rs);
            }
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_OBTAIN_ROLE_BY_ROLE_NAME, ex);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_ROLE_BY_ROLE_NAME,
                    ex);
        } finally {
            db.close(con, pstmt, rs);
        }
        return role;
    }
    public User createUser(User user) throws DBException {
        PreparedStatement pstmt = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getFullName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getLogin());
            pstmt.setString(4, user.getPassword());
            pstmt.setDate(5, new java.sql.Date(user.getRegisterDate().getTime()));
            pstmt.setInt(6, user.getRoleId());
            pstmt.setBoolean(7, user.isBlocked());
            int result = pstmt.executeUpdate();
            if (result > 0) {
                LOG.trace("-- User inserted -->" + user.toString());
            } else {
                LOG.error(Messages.ERR_CANNOT_ADD_CREDIT_CARD
                        + user.toString());
            }
            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setUserId(generatedKeys.getInt(1));
            }
            con.commit();
            return user;
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_ADD_CREDIT_CARD, ex);
            throw new DBException(Messages.ERR_CANNOT_ADD_CREDIT_CARD, ex);
        } finally {
            db.close(con);
            db.close(pstmt);
        }
    }

    public void updateUserState(boolean userState, int userId)
            throws DBException {

        PreparedStatement pstmt = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_UPDATE_USER_STATE);
            int counter = 1;
            pstmt.setBoolean(counter++, userState);
            pstmt.setInt(counter++, userId);
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_UPDATE_USER, ex);
            throw new DBException(Messages.ERR_CANNOT_UPDATE_USER, ex);
        } finally {
            db.close(con, pstmt);
        }
    }

    public void updateUser(User user) throws DBException {

        PreparedStatement pstmt = null;
        Connection con = null;
        try {
            db = DBManager.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_UPDATE_USER);
            int counter = 1;
            pstmt.setString(counter++, user.getFullName());
            pstmt.setString(counter++, user.getEmail());
            pstmt.setString(counter++, user.getPassword());
            pstmt.setString(counter++, user.getLogin());
            pstmt.setInt(counter++, user.getUserId());
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
            LOG.error(Messages.ERR_CANNOT_UPDATE_USER, ex);
            throw new DBException(Messages.ERR_CANNOT_UPDATE_USER, ex);
        } finally {
            db.close(con, pstmt);
        }
    }


    public void deleteUserByLogin(String login) throws DBException {
        PreparedStatement pstmt = null;
        Connection con = null;
        try {
            db.getInstance();
            con = db.getConnection();
            pstmt = con.prepareStatement(DBQueries.SQL_DELETE_USER_BY_LOGIN_ID);
            pstmt.setString(1, login);
            pstmt.executeUpdate();
            con.commit();
        } catch (SQLException ex) {
            db.rollback(con);
           // LOG.error(Messages.ERR_CANNOT_DELETE_DEPARTMENT, ex);
            throw new DBException(ex.getMessage(),
                    ex);
        } finally {
            db.close(con, pstmt);
        }
    }


    private User extractUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt(DBFields.USER_ID));
        user.setLogin(rs.getString(DBFields.LOGIN));
        user.setPassword(rs.getString(DBFields.PASSWORD));
        user.setRegisterDate(rs.getDate(DBFields.REGISTER_DATE));
        user.setRoleId(rs.getInt(DBFields.ROLE_ID));
        user.setFullName(rs.getString(DBFields.USER_FULL_NAME));
        user.setEmail(rs.getString(DBFields.EMAIL));
        user.setBlocked(rs.getBoolean(DBFields.BLOCKED));
        return user;
    }

    private Role extractRole(ResultSet rs) throws SQLException {
        Role role = new Role();
        role.setRoleId(rs.getInt(DBFields.ROLE_ID));
        role.setRoleName(rs.getString(DBFields.ROLE_NAME));
        return role;
    }
}

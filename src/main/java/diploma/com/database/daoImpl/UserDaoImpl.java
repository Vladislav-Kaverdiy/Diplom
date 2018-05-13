package diploma.com.database.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import diploma.com.database.dao.UserDao;
import org.apache.log4j.Logger;

import diploma.com.database.DBFields;
import diploma.com.database.DBManager;
import diploma.com.database.DBQueries;
import diploma.com.exception.Messages;
import diploma.com.model.Role;
import diploma.com.model.User;

public class UserDaoImpl implements UserDao {

    private DBManager db = DBManager.getInstance();
    private static final Logger LOG = Logger.getLogger(UserDaoImpl.class);

    @Override
    public List<User> getUsers() throws SQLException {
        List<User> users = new ArrayList<>();

        try (Connection connection = db.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(DBQueries.SQL_FIND_ALL_USERS)) {

            while (resultSet.next()) {
                users.add(extractUser(resultSet));
            }
            LOG.error(Messages.ERR_CANNOT_OBTAIN_USERS);

            return users;
        }
    }

    @Override
    public User createUser(User user) throws SQLException {

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setDate(5, new java.sql.Date(user.getRegisterDate().getTime()));
            preparedStatement.setInt(6, user.getRoleId());
            preparedStatement.setBoolean(7, user.isBlocked());
            Integer result = preparedStatement.executeUpdate();
            if (result > 0) {
                LOG.trace("-- User inserted -->" + user.toString());
            } else {
                LOG.error(Messages.ERR_CANNOT_CREATE_USER
                        + user.toString());
            }
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setUserId(generatedKeys.getInt(1));
            }
            LOG.error(Messages.ERR_CANNOT_CREATE_USER);
            return user;
        }
    }

    @Override
    public void deleteUserById(Integer userId) throws SQLException {

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_DELETE_USER_BY_ID)) {

            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
            LOG.error(Messages.ERR_CANNOT_DELETE_USER);
        }
    }

    @Override
    public void updateUserState(boolean userState, Integer userId) throws SQLException {

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_UPDATE_USER_STATE)) {

            preparedStatement.setBoolean(1, userState);
            preparedStatement.setInt(2, userId);
            preparedStatement.executeUpdate();
            LOG.error(Messages.ERR_CANNOT_UPDATE_USER_STATE);
        }
    }

    @Override
    public void updateUser(User user) throws SQLException {

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_UPDATE_USER)) {

            preparedStatement.setString(1, user.getFullName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.setInt(5, user.getUserId());
            preparedStatement.executeUpdate();
            LOG.error(Messages.ERR_CANNOT_UPDATE_USER);
        }
    }

    @Override
    public Role findRoleByRoleName(String roleName) throws SQLException {
        Role role = null;
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_FIND_ROLE_BY_ROLE_NAME)) {

            preparedStatement.setString(1, roleName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                role = extractRole(resultSet);
            }
            LOG.error(Messages.ERR_CANNOT_OBTAIN_ROLE_BY_ROLE_NAME);

            return role;
        }
    }

    @Override
    public User findUserByLogin(String login) throws SQLException {
        User user = null;

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_FIND_USER_BY_LOGIN)) {

            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = extractUser(resultSet);
            }
            LOG.error(Messages.ERR_CANNOT_OBTAIN_USER_BY_LOGIN);

            return user;
        }
    }

    @Override
    public User findUserById(Integer userId) throws SQLException {
        User user = null;

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_FIND_USER_BY_ID)) {

            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user = extractUser(resultSet);
            }
            LOG.error(Messages.ERR_CANNOT_OBTAIN_USER_BY_ID);

            return user;
        }
    }

    @Override
    public Role findUserRole(User user) throws SQLException {
        Role role = null;

        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DBQueries.SQL_FIND_USER_ROLE)) {

            preparedStatement.setInt(1, user.getRoleId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                role = extractRole(resultSet);
            }
            LOG.error(Messages.ERR_CANNOT_OBTAIN_ROLE_BY_ROLE_NAME);

            return role;
        }
    }

    @Override
    public User extractUser(ResultSet rs) throws SQLException {
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

    @Override
    public Role extractRole(ResultSet rs) throws SQLException {
        Role role = new Role();
        role.setRoleId(rs.getInt(DBFields.ROLE_ID));
        role.setRoleName(rs.getString(DBFields.ROLE_NAME));
        return role;
    }
}

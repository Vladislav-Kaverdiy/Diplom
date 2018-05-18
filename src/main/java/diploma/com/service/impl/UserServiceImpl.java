package diploma.com.service.impl;

import diploma.com.database.dao.UserDao;
import diploma.com.database.daoImpl.UserDaoImpl;
import diploma.com.model.Role;
import diploma.com.model.User;
import diploma.com.service.UserService;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> getUsers() throws SQLException {
        return userDao.getUsers();
    }

    @Override
    public User createUser(User user) throws SQLException {
        return userDao.createUser(user);
    }

    @Override
    public void deleteUserById(Integer userId) throws SQLException {
        userDao.deleteUserById(userId);
    }

    @Override
    public void updateUserState(boolean userState, Integer userId) throws SQLException {
        userDao.updateUserState(userState, userId);
    }

    @Override
    public void updateUser(User user) throws SQLException {
        userDao.updateUser(user);
    }

    @Override
    public Role findRoleByRoleName(String roleName) throws SQLException {
        return userDao.findRoleByRoleName(roleName);
    }

    @Override
    public User findUserByLogin(String login) throws SQLException {
        return userDao.findUserByLogin(login);
    }

    @Override
    public User findUserById(Integer userId) throws SQLException {
        return userDao.findUserById(userId);
    }

    @Override
    public Role findUserRole(User user) throws SQLException {
        return userDao.findUserRole(user);
    }

}

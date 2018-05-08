package diploma.com.database.dao;
import diploma.com.model.Role;
import diploma.com.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    List<User> getUsers() throws SQLException;

    Role findRoleByRoleName(String roleName) throws SQLException;

    User createUser(User user) throws SQLException;

    void updateUserState(boolean userState, Integer userId) throws SQLException;

    void updateUser(User user) throws SQLException;

    User extractUser(ResultSet rs) throws SQLException;

    Role extractRole(ResultSet rs) throws SQLException;

    Role findUserRole(User user) throws SQLException;

    User findUserByLogin(String login) throws SQLException;

    User findUserById(Integer userId) throws SQLException;

    void deleteUserById(Integer userId) throws SQLException;

}

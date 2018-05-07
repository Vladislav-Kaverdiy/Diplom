/*
package source.it.com.database.dao;


import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import source.it.com.exception.DBException;
import source.it.com.model.User;

public class UserDaoTest {

    @Test
    public void shouldCreateUser() throws DBException {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setBlocked(false);
        user.setEmail("adasd@asdff.c");
        user.setFullName("Vladislav");
        user.setLogin("login");
        user.setPassword("1111");
        user.setRoleId(1);
        user.setRegisterDate(new Date());
        User user1 = userDao.createUser(user);
        assertNotEquals(user1.getUserId(), 0);
    }
    @Test
    public void shouldFindUserByLogin()throws DBException{
        User user = new User();
        user.setBlocked(false);
        user.setEmail("adasd@asdff.c");
        user.setFullName("Vladislav");
        user.setLogin("login");
        user.setPassword("1111");
        user.setRoleId(1);
        user.setRegisterDate(new Date());
        UserDao userDao = new UserDao();
        userDao.findUserByLogin("login");

    }
    @Test
    public void shouldGetUsers()throws DBException{
        User user = new User();
        user.setBlocked(false);
        user.setEmail("adasd@asdff.c");
        user.setFullName("Vladislav");
        user.setLogin("login");
        user.setPassword("1111");
        user.setRoleId(1);
        user.setRegisterDate(new Date());
        UserDao userDao = new UserDao();
        userDao.getUsers();

    }
    @Test
    public void shouldFindRoleByRoleName()throws DBException{
        User user = new User();
        user.setBlocked(false);
        user.setEmail("adasd@asdff.c");
        user.setFullName("Vladislav");
        user.setLogin("login");
        user.setPassword("1111");
        user.setRoleId(1);
        user.setRegisterDate(new Date());
        UserDao userDao = new UserDao();
        userDao.findRoleByRoleName("admin");

    }
    @Test
    public void shouldUpdateUser()throws DBException{
        User user = new User();
        user.setBlocked(false);
        user.setEmail("adasd@asdff.c");
        user.setFullName("Vova");
        user.setLogin("login1");
        user.setPassword("11112");
        user.setRoleId(2);
        user.setRegisterDate(new Date());
        UserDao userDao = new UserDao();
        userDao.updateUser(user);

    }
    @Test
    public void shouldUserState()throws DBException{
        User user = new User();
        user.setBlocked(false);
        user.setEmail("adasd@asdff.c");
        user.setFullName("Ivan");
        user.setLogin("login3");
        user.setPassword("111123");
        user.setRoleId(3);
        user.setRegisterDate(new Date());
        UserDao userDao = new UserDao();
        userDao.updateUserState(false,1);
    }
}
*/

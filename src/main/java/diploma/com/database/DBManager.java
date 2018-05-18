package diploma.com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.apache.log4j.Logger;

import diploma.com.exception.DBException;
import diploma.com.exception.Messages;

import static diploma.com.database.DBCreateTables.SQL_CREATE_TABLE_USERS;
import static diploma.com.database.DBCreateTables.SQL_CREATE_TABLE_ROLES;
import static diploma.com.database.DBCreateTables.SQL_CREATE_TABLE_CREDIT_CARDS;
import static diploma.com.database.DBCreateTables.SQL_CREATE_TABLE_USER_PAYMENTS;

public final class DBManager {

    private static final Logger LOG = Logger.getLogger(DBManager.class);


    private static DBManager instance;


    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;

    }

    private DBManager() {

        try (Statement statement = getConnection().createStatement()) {
            statement.execute(SQL_CREATE_TABLE_USERS);
            statement.execute(SQL_CREATE_TABLE_ROLES);
            statement.execute(SQL_CREATE_TABLE_CREDIT_CARDS);
            statement.execute(SQL_CREATE_TABLE_USER_PAYMENTS);

        } catch (Exception e) {
            LOG.error("Cant create table", e);

        }
    }

    public Connection getConnection() throws DBException {
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/diploma", "root", "KaVeRdIy1996");
            connection.setAutoCommit(true);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        } catch (Exception ex) {
            LOG.error(Messages.ERR_CANNOT_OBTAIN_CONNECTION, ex);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_CONNECTION, ex);
        }
        return connection;
    }
}
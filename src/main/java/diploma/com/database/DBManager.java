package diploma.com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import diploma.com.exception.DBException;
import diploma.com.exception.Messages;


public final class DBManager {

    private static final Logger LOG = Logger.getLogger(DBManager.class);


    private static DBManager instance;


    public static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;

    }
    private DBManager()  {

        try(Statement statement = getConnection().createStatement()){

           // statement.execute(SQL_CREATE_TABLE_DEPARTMENTS);
           // statement.execute(SQL_CREATE_TABLE_WORKERS);


        } catch (Exception e) {
            LOG.error("Cant create table", e);

        }
    }




    public Connection getConnection() throws DBException {
        Connection con ;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payments", "root", "KaVeRdIy1996");
            con.setAutoCommit(true);
            con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        } catch (Exception ex) {
            LOG.error(Messages.ERR_CANNOT_OBTAIN_CONNECTION, ex);
            throw new DBException(Messages.ERR_CANNOT_OBTAIN_CONNECTION, ex);
        }
        return con;
    }

    public void close(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                LOG.error(Messages.ERR_CANNOT_CLOSE_CONNECTION, ex);
            }
        }
    }

    public void close(Statement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                LOG.error(Messages.ERR_CANNOT_CLOSE_STATEMENT, ex);
            }
        }
    }

    /**
     * Closes a result set object.
     */
    public void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                LOG.error(Messages.ERR_CANNOT_CLOSE_RESULTSET, ex);
            }
        }
    }

    /**
     * Closes resources.
     */
    public void close(Connection con, Statement stmt) {
        close(stmt);
        close(con);
    }

    /**
     * Closes resources.
     */
    public void close(Connection con, Statement stmt, ResultSet rs) {
        close(rs);
        close(stmt);
        close(con);
    }

    /**
     * Rollbacks a connection.
     *
     * @param con Connection to be rollbacked.
     */
    public void rollback(Connection con) {
        if (con != null) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                LOG.error("Cannot rollback transaction", ex);
            }
        }
    }
}
package tercertrimestre.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager
{
    /// FIELDS
    private Connection connection;

    /// CONSTRUCTOR
    public ConnectionManager() throws SQLException
    {
        connection = startConnection();
    }

    /// METHODS
    private Connection startConnection() throws SQLException
    {
        return DriverManager.getConnection(DatabaseConstants.CONNECTION_URL, DatabaseConstants.CONNECTION_USER, DatabaseConstants.CONNECTION_PASS);
    }

    private void closeConnection() throws SQLException
    {
        if ((connection != null) && (!connection.isClosed())) { connection.close(); }
    }

    public Connection getConnection() throws SQLException
    {
        if ((connection != null) && (connection.isClosed())) { connection = startConnection(); }
        return connection;
    }
}

package gov.iti.presistance;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

public class ConnectionManager {
    private static ConnectionManager instance;
    public Connection connection = null ;

    private ConnectionManager() throws SQLException {
            DataSource dataSource = DataSourceFactory.getDataSource();
            connection = dataSource.getConnection();
    }

    public static ConnectionManager getInstance() throws SQLException{
        if(instance == null)
            instance = new ConnectionManager();
        return instance;    
    }

    public void closeConnection() throws SQLException{
        connection.close();
    }
    
    public Connection getStatement() {
        return connection;
    }
    
}

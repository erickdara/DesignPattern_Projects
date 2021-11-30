package factorymethod.factory;



import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLAdapter implements IDBAdapter {
    static{
        try {
            new Driver();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() {
        try {
            String connectionString = getConnectionString();
            String user = "erick";
            String password = "erick";
            Connection connection = DriverManager.getConnection(connectionString, user, password);
            System.out.println("Connection class => " + connection.getClass().getCanonicalName());
            return connection;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private String getConnectionString(){
        return "jdbc:mysql://localhost:3306/pos?useSSL=false";
    }
}

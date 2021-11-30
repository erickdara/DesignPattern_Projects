package factorymethod.factory;

import factorymethod.enums.DBType;

import java.io.InputStream;
import java.util.Properties;

public class DBAdapterFactory {

    private static final String DB_TYPE = "dbadaptertype";

    public static IDBAdapter getAdapter() {

        try {

            Properties p = loadProperties();
            String dbType = p.getProperty(DB_TYPE);
            return (IDBAdapter) Class.forName(dbType).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Properties loadProperties() {
            Properties p = new Properties();
        try {
            InputStream stream = DBAdapterFactory.class.getClassLoader().getResourceAsStream("dbadapter.properties");
            p.load(stream);
            return p;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


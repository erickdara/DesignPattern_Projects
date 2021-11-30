import entitys.Product;
import factorymethod.dao.ProductDAO;
import factorymethod.enums.DBType;
import factorymethod.factory.DBAdapterFactory;
import factorymethod.factory.IDBAdapter;
import factorymethod.factory.MySQLAdapter;
import factorymethod.factory.OracleAdapter;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {

       /* MySQLAdapter mySQLAdapter = new MySQLAdapter();
        Connection connection = mySQLAdapter.getConnection();*/

        /*IDBAdapter adapter = DBAdapterFactory.getAdapter(DBType.MYSQL);
        Connection connection = adapter.getConnection();*/

        Product product1 = new Product(3L,"Producto3", 30);

        ProductDAO productDAO = new ProductDAO();
        productDAO.saveProduct(product1);

        List<Product> allProducts= productDAO.getAllProducts();
        for (Product current: allProducts) {
            System.out.println("current = " + current);
        }

    }
}

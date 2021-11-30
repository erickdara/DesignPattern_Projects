package factorymethod.dao;

import entitys.Product;
import factorymethod.enums.DBType;
import factorymethod.factory.DBAdapterFactory;
import factorymethod.factory.IDBAdapter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private IDBAdapter adapter;

    public ProductDAO (){
        adapter = DBAdapterFactory.getAdapter();
    }

    public void saveProduct(Product product){
try{
        String sql = "insert into productos values(?,?,?)";
        Connection connection = adapter.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, product.getId());
        statement.setString(2, product.getName());
        statement.setDouble(3, product.getPrice());
        statement.executeUpdate();
    }catch (Exception e){
        e.printStackTrace();
    }

}
    public List<Product> getAllProducts(){
        try {
        String sql = "select * from productos";
        Connection connection = adapter.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        List<Product> products = new ArrayList<>();

            while (result.next()){
                Long id = result.getLong(1);
                String name = result.getString(2);
                Double price = result.getDouble(3);

                Product current = new Product(id, name,price);
                products.add(current);
            }
            return products;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}

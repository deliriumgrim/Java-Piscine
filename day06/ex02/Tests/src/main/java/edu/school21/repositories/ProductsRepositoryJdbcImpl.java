package edu.school21.repositories;

import edu.school21.models.Product;

import javax.sql.DataSource;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository {

    private final DataSource dataSource;

    public ProductsRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Product> findAll() throws SQLException {
        final String query = "SELECT * FROM products";
        List<Product> list = new LinkedList<>();
        ResultSet res = null;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(query);
        res = statement.executeQuery();
        while (res.next()) {
            list.add(new Product(res.getLong("identifier"),
                    res.getString("name"),
                    res.getLong("price")));
        }
        connection.close();
        statement.close();
        res.close();
        return list;
    }

    @Override
    public Optional<Product> findById(Long id) throws SQLException {
        Optional<Product> optionalProduct = null;
        String request = "SELECT * FROM products WHERE identifier = " + id;
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet res;
        res = statement.executeQuery(request);
        res.next();
        Long productId = res.getLong("identifier");
        String name = res.getString("name");
        Long price = res.getLong("price");
        optionalProduct = Optional.of(new Product(productId, name, price));
        connection.close();
        statement.close();
        res.close();
        return optionalProduct;
    }

    @Override
    public void save(Product product) throws SQLException {
        String request = "INSERT INTO products (identifier, name, price) " +
                "VALUES (" + product.getId() + ", " +
                "'" + product.getName() + "', " +
                product.getPrice() + ");";
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(request);
        statement.execute();
        connection.close();
        statement.close();
    }

    @Override
    public void update(Product product) throws SQLException {
        String sqlRequest = "UPDATE products SET " +
                "identifier = ?, " +
                "name = ?, " +
                "price = ? " +
                "WHERE identifier = ?";
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sqlRequest);
        statement.setLong(1, product.getId());
        statement.setString(2, product.getName());
        statement.setLong(3, product.getPrice());
        statement.setLong(4, product.getId());
        statement.execute();
        connection.close();
        statement.close();
    }

    @Override
    public void delete(Long id) throws SQLException {
        String req = "DELETE FROM products WHERE identifier=?";
        if (findById(id).isPresent()) {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(req);
            statement.setLong(1, id);
            statement.execute();
            connection.close();
            statement.close();
        }
    }
}

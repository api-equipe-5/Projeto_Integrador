package com.tecsus.ddc.product;

import com.tecsus.ddc.repository.InnerRepository;
import com.tecsus.ddc.connection.ConnectionImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductRepository implements InnerRepository<Product> {

    private ConnectionImpl<Product> connection;

    public ProductRepository(final Connection connection) {
        this.connection = new ConnectionImpl<>(connection, this);
    }

    @Override
    public void saveAll(List<Product> list, String key) {
        list.forEach(product -> save(product, key));
    }

    @Override
    public void save(Product product, String key) {
        connection.save(ProductQueryFactory.insert(), product, key);
    }

    @Override
    public Optional<Product> find(Product object, String key) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll(Product object, String key) {
        return null;
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement, Product product, String key) throws SQLException {
        preparedStatement.setString(1, product.getProductType().getValue());
        preparedStatement.setBigDecimal(2, product.getValue());
        preparedStatement.setString(3, key);
        preparedStatement.setBigDecimal(4, product.getQuantity());
    }
}

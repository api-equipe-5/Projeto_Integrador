package com.tecsus.ddc.bill.water;

import com.tecsus.ddc.bill.BillRepository;
import com.tecsus.ddc.connection.ConnectionImpl;
import com.tecsus.ddc.product.ProductRepository;
import com.tecsus.ddc.repository.Repository;
import com.tecsus.ddc.repository.RepositoryStatement;
import com.tecsus.ddc.tribute.TributeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class WaterBillRepository implements Repository<WaterBill>, RepositoryStatement<WaterBill> {

    private final ConnectionImpl<WaterBill> connection;
    private final BillRepository billRepository;
    private final ProductRepository productRepository;
    private final TributeRepository tributeRepository;

    public WaterBillRepository(Connection connection) {
        this.connection = new ConnectionImpl<WaterBill>(connection, this);
        billRepository = new BillRepository(connection);
        productRepository = new ProductRepository(connection);
        tributeRepository = new TributeRepository(connection);
    }

    @Override
    public void saveAll(List<WaterBill> list) {
        list.forEach(this::save);
    }

    @Override
    public void save(WaterBill waterBill) {
        billRepository.save(waterBill.getBill());
        connection.save(WaterBillQueryFactory.insert(), waterBill);

        String billNum = waterBill.getBill().getBillNum();
        waterBill.getProducts().forEach(product -> productRepository.save(product, billNum));
        waterBill.getTributes().forEach(tribute -> tributeRepository.save(tribute, billNum));
    }

    @Override
    public Optional<WaterBill> find(Object id) {
        return Optional.empty();
    }

    @Override
    public List<WaterBill> findAll() {
        return null;
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement, WaterBill waterBill) throws SQLException {
        preparedStatement.setString(1, waterBill.getBill().getBillNum());
        preparedStatement.setString(2, waterBill.getLocation());
        preparedStatement.setString(3, waterBill.getCategory().getValue());
        preparedStatement.setInt(4, waterBill.getGroup());
    }
}

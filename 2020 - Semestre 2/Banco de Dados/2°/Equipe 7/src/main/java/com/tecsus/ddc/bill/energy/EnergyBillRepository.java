package com.tecsus.ddc.bill.energy;

import com.tecsus.ddc.bill.BillRepository;
import com.tecsus.ddc.flag.TariffFlagRepository;
import com.tecsus.ddc.product.ProductRepository;
import com.tecsus.ddc.repository.Repository;
import com.tecsus.ddc.connection.ConnectionImpl;
import com.tecsus.ddc.repository.RepositoryStatement;
import com.tecsus.ddc.tribute.TributeRepository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class EnergyBillRepository implements RepositoryStatement<EnergyBill>, Repository<EnergyBill> {

    private final ConnectionImpl<EnergyBill> connection;
    private final BillRepository billRepository;
    private final ProductRepository productRepository;
    private final TariffFlagRepository tariffFlagRepository;
    private final TributeRepository tributeRepository;

    public EnergyBillRepository(final Connection connection) {
        this.connection = new ConnectionImpl<>(connection, this);
        billRepository = new BillRepository(connection);
        productRepository = new ProductRepository(connection);
        tariffFlagRepository = new TariffFlagRepository(connection);
        tributeRepository = new TributeRepository(connection);
    }

    @Override
    public void saveAll(List<EnergyBill> list) {
        list.forEach(this::save);
    }

    @Override
    public void save(final EnergyBill energyBill) {
        billRepository.save(energyBill.getBill());
        connection.save(EnergyBillQueryFactory.insert(), energyBill);

        String billNum = energyBill.getBill().getBillNum();
        energyBill.getProducts().forEach(product -> productRepository.save(product, billNum));
        energyBill.getTariffFlags().forEach(tariffFlag -> tariffFlagRepository.save(tariffFlag, billNum));
        energyBill.getTributes().forEach(tribute -> tributeRepository.save(tribute, billNum));
    }

    @Override
    public Optional<EnergyBill> find(Object id) {
        return Optional.empty();
    }

    @Override
    public List<EnergyBill> findAll() {
        return null;
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement, EnergyBill energyBill) throws SQLException {
        preparedStatement.setString(1, energyBill.getBill().getBillNum());
        preparedStatement.setString(2, energyBill.getGroup().name());
        preparedStatement.setString(3, energyBill.getSubGroup().name());
        preparedStatement.setString(4, energyBill.getClasse().name());
        preparedStatement.setString(5, energyBill.getSubClasse().name());
        preparedStatement.setDate(6, (Date) energyBill.getEmission());
        preparedStatement.setInt(7, energyBill.getTension());
        preparedStatement.setString(8, energyBill.getPhase().name());
    }
}

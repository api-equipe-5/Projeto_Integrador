package com.tecsus.ddc.bill;

import com.tecsus.ddc.repository.InnerRepository;
import com.tecsus.ddc.repository.Repository;
import com.tecsus.ddc.bill.type.BillTypeRepository;
import com.tecsus.ddc.connection.ConnectionImpl;
import com.tecsus.ddc.repository.RepositoryStatement;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Slf4j
public class BillRepository implements RepositoryStatement<Bill>, Repository<Bill>, InnerRepository<Bill> {

    private final ConnectionImpl<Bill> connection;
    private final ConnectionImpl<Bill> innerConnection;
    private final BillTypeRepository billTypeRepository;

    public BillRepository(final Connection connection) {
        this.connection = new ConnectionImpl<Bill>(connection, (RepositoryStatement<Bill>) this);
        this.innerConnection = new ConnectionImpl<Bill>(connection,(InnerRepository<Bill>) this);
        this.billTypeRepository = new BillTypeRepository(connection);
    }

    @Override
    public void saveAll(final List<Bill> bills) {
        bills.forEach(this::save);
    }

    @Override
    public void save(final Bill bill) {
        connection.save(BillQueryFactory.insert(), bill);
        billTypeRepository.save(bill);
    }

    @Override
    public Optional<Bill> find(Object id) {
        String billNum = (String) id;
        Optional<ResultSet> resultSet = innerConnection.find(BillQueryFactory.select(), new Bill(), billNum);
        if (resultSet.isPresent()) {
            Bill bill = Bill.constructFrom(resultSet.get());
            ConnectionImpl.closeResultSet(resultSet.get());
            return Optional.of(bill);
        }
        return Optional.empty();
    }

    @Override
    public List<Bill> findAll() {
        return null;
    }



    @Override
    public void prepareStatement(final PreparedStatement preparedStatement, final Bill bill) throws SQLException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        preparedStatement.setString(1, bill.getBillNum());
        preparedStatement.setString(2, bill.getInstalation().getInstalationNumber());
        preparedStatement.setBigDecimal(3, bill.getValue());
        preparedStatement.setDate(4, Date.valueOf(format.format(bill.getRefMonth())));
        preparedStatement.setDate(5, Date.valueOf(format.format(bill.getPreviousRead())));
        preparedStatement.setBigDecimal(6, bill.getPreviousReadValue());
        preparedStatement.setDate(7, Date.valueOf(format.format(bill.getActualRead())));
        preparedStatement.setBigDecimal(8, bill.getActualReadValue());
        preparedStatement.setDate(9, Date.valueOf(format.format(bill.getNextRead())));
        preparedStatement.setDate(10, Date.valueOf(format.format(bill.getDueDate())));
        preparedStatement.setInt(11, bill.getConsum());
        preparedStatement.setInt(12, bill.getConsumPeriod());
        preparedStatement.setString(13, bill.getMeter().getMeterNumber());
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement, Bill object, String key) throws SQLException {
        preparedStatement.setString(1, key);
    }

    @Override
    public void saveAll(List<Bill> list, String key) {

    }

    @Override
    public void save(Bill object, String key) {

    }

    @Override
    public Optional<Bill> find(Bill object, String key) {
        return Optional.empty();
    }

    @Override
    public List<Bill> findAll(Bill object, String key) {
        return null;
    }
}

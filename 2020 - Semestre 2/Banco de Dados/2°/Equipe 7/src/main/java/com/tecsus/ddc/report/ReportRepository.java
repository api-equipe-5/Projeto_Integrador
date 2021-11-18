package com.tecsus.ddc.report;

import com.tecsus.ddc.connection.ConnectionImpl;
import com.tecsus.ddc.instalation.TransformTo;
import com.tecsus.ddc.repository.InnerRepository;
import com.tecsus.ddc.repository.MidRepository;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

public class ReportRepository implements InnerRepository<Report>, TransformTo<Report>, MidRepository {

    private ConnectionImpl<Report> connection;

    public ReportRepository(Connection connection) {
        this.connection = new ConnectionImpl<Report>(connection, this);
    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement, Report object, String key) throws SQLException {

    }

    @Override
    public void prepareStatement(PreparedStatement preparedStatement, Object object) throws SQLException {
        if (!(object instanceof ReportKey)) return;
        ReportKey reportKey = (ReportKey) object;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        preparedStatement.setDate(1, Date.valueOf(format.format(reportKey.getStart())));
        preparedStatement.setDate(2, Date.valueOf(format.format(reportKey.getFinish())));
        preparedStatement.setString(3, reportKey.getClient());
    }

    @Override
    public void saveAll(List<Report> list, String key) {

    }

    @Override
    public void save(Report object, String key) {

    }

    @Override
    public Optional<Report> find(Report object, String key) {
        return Optional.empty();
    }

    @Override
    public List<Report> findAll(Report object, String key) {
        return null;
    }

    public List<Report> findAll(ReportKey reportKey) {
        return connection.findAll(Report.selectByClient(), this, Report.class, this, reportKey, "");
    }

    @Override
    public Report object(ResultSet resultSet, Class<Report> object) {
        try {
            return Report.builder()
                    .consum(resultSet.getBigDecimal("consum"))
                    .value(resultSet.getBigDecimal("value"))
                    .refMonth(resultSet.getDate("ref_month"))
                    .build();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}

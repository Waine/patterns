package com.eakonovalov.pattern.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

/**
 * Created by Waine on 14.02.2017.
 */
@Component
public class DatabaseTable {

    private DataSource dataSource;

    private String query;

    private Connection con;
    private PreparedStatement ps;

    public DatabaseTable(String tableName) {
        this.query = "SELECT * FROM " + tableName;
    }

    public ResultSetMetaData getResultSetMetaData() throws SQLException {
        con = DataSourceUtils.getConnection(dataSource);
        ps = con.prepareStatement(query);
        return ps.getMetaData();
    }

    public ResultSet getResultSet() throws SQLException {
        return ps.executeQuery();
    }

    public void close() {
        JdbcUtils.closeStatement(ps);
        DataSourceUtils.releaseConnection(con, dataSource);
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}

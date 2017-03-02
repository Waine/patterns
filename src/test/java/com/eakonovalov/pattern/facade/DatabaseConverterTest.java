package com.eakonovalov.pattern.facade;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * Created by Waine on 11.02.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "applicationContext.xml")
public class DatabaseConverterTest {

    @Autowired
    private DatabaseConverter converter;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Before
    public void setup() {
        jdbcTemplate.execute("CREATE TABLE test_table (\n" +
                "   id INT NOT NULL,\n" +
                "   title VARCHAR(50) NOT NULL,\n" +
                "   author VARCHAR(20) NOT NULL,\n" +
                "   date DATE,\n" +
                "   PRIMARY KEY (id) \n" +
                ");");

        jdbcTemplate.execute("INSERT INTO PUBLIC.TEST_TABLE VALUES (" +
                "1, 'Aaa', 'Bbb', NOW())");
    }

    @Test
    public void testExport() throws Exception {
        converter.exportToExcel("test_table", "test_table.xlsx");
    }

    @Test
    public void testImport() throws Exception {
        converter.importFromExcel("test_table.xlsx", "test_table2");
    }

}

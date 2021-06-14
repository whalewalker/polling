package com.example.pollapp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Slf4j
class PollAppApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void checkIfApplicationCanConnectToDataBaseTest(){
        assertThat(dataSource).isNotNull();
        log.info("Create connection to database --> {}", dataSource);

        try {
            Connection connection = dataSource.getConnection();
            assertThat(connection).isNotNull();
            assertThat(connection.getCatalog()).isEqualTo("polldb");
        } catch (SQLException throwable) {
            log.info("Error occurred while connection to database --> {}", throwable.getMessage());
        }

    }

}

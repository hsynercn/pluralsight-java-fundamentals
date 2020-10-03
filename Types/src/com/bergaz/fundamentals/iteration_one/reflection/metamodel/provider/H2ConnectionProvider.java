package com.bergaz.fundamentals.iteration_one.reflection.metamodel.provider;

import com.bergaz.fundamentals.iteration_one.reflection.metamodel.annotation.Provides;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2ConnectionProvider {
    @Provides
    public Connection buildConnection() throws SQLException {
        Connection connection =
                DriverManager.getConnection(
                        "jdbc:h2:C:/Pluralsight/pluralsight-java-fundamentals/Types/db-files/db-pluralsight",
                        "sa", "");
        return connection;
    }
}

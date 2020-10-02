package com.bergaz.fundamentals.iteration_one.reflection.metamodel.db;

import org.h2.tools.Server;

import java.sql.SQLException;

/**HOW TO CREATE DB WITH H2 PAGE:
 * Before running the Server pass this argument "-ifNotExists" to program parameters
 * Use this URL
 * jdbc:h2:C:/Pluralsight/pluralsight-java-fundamentals/Types/db-files/db-pluralsight
*/
public class DBLauncher {
    public static void main(String[] args) throws SQLException {
        Server.main(args);
        System.out.println("DB Launched");
    }
}

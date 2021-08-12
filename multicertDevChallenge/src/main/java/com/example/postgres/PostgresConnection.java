package com.example.postgres;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresConnection {

    Connection connection;
    String serverString;
    String username;
    String password;

    public PostgresConnection(String serverString, String username, String password) {
        this.serverString = serverString;
        this.username = username;
        this.password = password;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager
                    .getConnection("jdbc:postgresql://" + serverString,
                            username, password);
            System.out.println("Opened database successfully");


        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0); }
    }

    public Connection getConnection() {
        return connection;
    }
}

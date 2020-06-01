package com.patrimoine.website.config.interfaces;


import java.sql.*;


public class ConnectDatabase {


    private  String driver;
    private  String url ;
    private  String login ;
    private  String password;
    private Connection connection;


    public ConnectDatabase(){
        driver ="com.mysql.cj.jdbc.Driver";
        url ="jdbc:mysql://localhost:3306/patrimoine?serverTimezone=UTC";
        login ="moi";
        password ="moi";
        connection =null;


    }
    public ConnectDatabase(String driver, String url, String login, String password) {
        this.driver = driver;
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Boolean isConnected() {



        try {
            connection = DriverManager.getConnection(url, login, password);
            return true;

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("url "+ url +
                    "logon "+ login+"pass"+ password );
        }

        return false;
    }

    public Connection getConnection() {
        return connection;
    }

    public void doStatement(Connection connection) {

    }






}

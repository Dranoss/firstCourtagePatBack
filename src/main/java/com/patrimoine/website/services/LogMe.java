package com.patrimoine.website.services;

import com.patrimoine.website.config.interfaces.ConnectDatabase;
import com.patrimoine.website.config.interfaces.LogPatrimoine;


public class LogMe implements LogPatrimoine {
    private String role;
    private  String login;
    private  String password;

     ConnectDatabase connection;
    public String     getLogin(){
        return  login;

    }

    public String     getPassword(){
        return  password;


    }

    public Boolean  prepareConnection()  {

        //   connection
        return  true;

    }




}

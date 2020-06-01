package com.patrimoine.website.config.interfaces;

import java.sql.SQLException;


public interface LogPatrimoine {



    // gestion login et mot de passe


    public String     getLogin();
    public String     getPassword();

    public Boolean prepareConnection() throws SQLException;
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackdis.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Roberto
 */
public class PostgreSqlConnection implements IConnection{
    private Connection _connection;
    private String _host;
    private String _port;
    private String _database;
    private String _userName;
    private String _password;
    private String _driver; 
    private String _url;

    public PostgreSqlConnection(String _host, String _port, String _database, String _userName, String _password, String _driver) {
        this._host = _host;
        this._port = _port;
        this._database = _database;
        this._userName = _userName;
        this._password = _password;
        this._driver = _driver;
    }
    
    @Override
    public Connection startConnection() {
        try{
           this._url = "jdbc:postgresql://"+this._host+":"+this._port+"/"+this._database;           
           Class.forName(this._driver);            
           this._connection = DriverManager.getConnection(this._url, this._userName, this._password);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        return _connection;
    }

    @Override
    public void stopConnection() throws Exception {
        try{
            this._connection.close();
        }catch(Exception e){
            throw new Exception("Error al cerrar la conexión", e);
        }
    }

    @Override
    public String testConnection() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

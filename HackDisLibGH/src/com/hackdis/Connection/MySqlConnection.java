/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackdis.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * MySqlConnection es la clase encargada de crear un nueva conexión con el motor MySQL
 * 
 * @author Roberto
 */
public class MySqlConnection implements IConnection {
    private Connection _connection;
    private String _host;
    private String _port;
    private String _database;
    private String _userName;
    private String _password;
    private String _driver; 
    private String _url;
    
    /**
     * Constructor que se encarga de asginar el valor a las variables internas de la clase
     *  
     * @param _host : host o servidor al cual se hará la conexión
     * @param _port : puerto por el cual se iniciara la conexión
     * @param _database : nombre de la base de datos 
     * @param _userName : nombre del usuario 
     * @param _password : contraseña del usuario
     * @param _driver  : nombre del diver utilizado para la conexion
     */
    public MySqlConnection(String _host, String _port, String _database, String _userName, String _password, String _driver) {
        this._host = _host;
        this._port = _port;
        this._database = _database;
        this._userName = _userName;
        this._password = _password;
        this._driver = _driver;
    }
    
    /**
     * Inicia una nueva Conexiòn de tipo JDBC con el Motor MySQL, este metodo es implementado desde la Interface {@link com.hackdis.Connection.IConnection}
     * 
     * @return Connection : Conexion con el Motor
     */
    @Override
    public Connection startConnection() {
       try{
           this._url = "jdbc:mysql://"+this._host+":"+this._port+"/"+this._database;           
           Class.forName(this._driver);            
           this._connection = DriverManager.getConnection(this._url, this._userName, this._password);
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }catch(SQLException sqle){
            sqle.printStackTrace();
        }
        return _connection;
    }
    /**
     * Detiene la Conexiòn de tipo JDBC con el Motor MySQL, este metodo es implementado desde la Interface {@link com.hackdis.Connection.IConnection}
     * @throws Exception 
     */
    @Override
    public void stopConnection() throws Exception{
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

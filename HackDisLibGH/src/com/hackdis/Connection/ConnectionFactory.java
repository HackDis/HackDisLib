/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackdis.Connection;

import java.sql.Connection;

/**
 * ConnectionFactory es la clase encargada de poder construir los distintos tipos
 * de objetos que se encargan de la conexion a la base de datos.
 * <p>
 * Estos Objetos son:
 * <ul>
 * <li>{@link com.hackdis.Connection.MySqlConnection }</li>
 * <li>{@link com.hackdis.Connection.OracleConnection }</li>
 * <li>{@link com.hackdis.Connection.PostgreSqlConnection }</li>
 * <li>{@link com.hackdis.Connection.SqlServerConnection }</li>
 * </ul>
 * </p>
 * @author Roberto
 */
public class ConnectionFactory implements IConnectionFactory{
    
    private IConnection _iConnection;
    private ConnectionConfig _connectionConfig;
    
    /**
     * Constructor de ConnectionFactory
     * <br/>
     * 
     * Se encarga de revisar el Driver configurado en el archivo ConnectionConfig.properties
     * para así poder crear el objeto necesario para la conexion necesaria
     * 
     */
    public ConnectionFactory(){
        _connectionConfig = ConnectionConfig.getInstance();
        switch(Integer.parseInt(_connectionConfig.getProperty(ConnectionConfig.DRIVER))){
            case 1 :  this._iConnection = new PostgreSqlConnection(_connectionConfig.getProperty(ConnectionConfig.HOST),
                                                                   _connectionConfig.getProperty(ConnectionConfig.PORT),
                                                                   _connectionConfig.getProperty(ConnectionConfig.DATABASE),
                                                                   _connectionConfig.getProperty(ConnectionConfig.USER),
                                                                   _connectionConfig.getProperty(ConnectionConfig.PASSWD),
                                                                   DriverList.PostgreSQL.getDriverName());
                break;
            case 2 : this._iConnection = new OracleConnection(_connectionConfig.getProperty(ConnectionConfig.HOST),
                                                                   _connectionConfig.getProperty(ConnectionConfig.PORT),
                                                                   _connectionConfig.getProperty(ConnectionConfig.DATABASE),
                                                                   _connectionConfig.getProperty(ConnectionConfig.USER),
                                                                   _connectionConfig.getProperty(ConnectionConfig.PASSWD),
                                                                   DriverList.Oracle.getDriverName());
                break;
            case 3 : this._iConnection = new SqlServerConnection(_connectionConfig.getProperty(ConnectionConfig.HOST),
                                                                   _connectionConfig.getProperty(ConnectionConfig.PORT),
                                                                   _connectionConfig.getProperty(ConnectionConfig.DATABASE),
                                                                   _connectionConfig.getProperty(ConnectionConfig.USER),
                                                                   _connectionConfig.getProperty(ConnectionConfig.PASSWD),
                                                                   DriverList.SQLServer.getDriverName());
                break;
            case 4 : this._iConnection = new MySqlConnection(_connectionConfig.getProperty(ConnectionConfig.HOST),
                                                                   _connectionConfig.getProperty(ConnectionConfig.PORT),
                                                                   _connectionConfig.getProperty(ConnectionConfig.DATABASE),
                                                                   _connectionConfig.getProperty(ConnectionConfig.USER),
                                                                   _connectionConfig.getProperty(ConnectionConfig.PASSWD),
                                                                   DriverList.MySQL.getDriverName());
                break;
            default:
                break;
        }        
    }
    
    @Override
    public Connection startConnection() {
        
        return this._iConnection.startConnection();
    }

    @Override
    public void stopConnection() throws Exception {
        try{
            if(this._iConnection != null)
                this._iConnection.stopConnection();
            else
               throw new Exception("No existen Conexiones abiertas");
        }catch(Exception ex){
            throw new Exception("Error al parar conexion",ex);
        }
    }    
    
}

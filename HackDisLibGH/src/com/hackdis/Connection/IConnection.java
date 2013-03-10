/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackdis.Connection;
import java.sql.Connection;
/**
 * IConnection
 * 
 * Interface que establece los metodos a utilizar
 * 
 * @author Roberto
 * @version 1.0
 */
public interface IConnection {
    
    /**
     * Inicia la Conexion con la Base de Datos.
     * @return Connection : Conexion con la base de datos   
     */
    public Connection startConnection();
    /**
     * Detiene la Conexion con la Base de Datos
     * @throws Exception : Error en caso de que no se pueda cerrar la conexion 
     */
    public void stopConnection() throws Exception;
    /**
     * Realiza una Prueba de Conexion ejecutando una consulta simple Select 1 
     * @return String : Mensaje de salida para la prueba de conexion
     */
    public String testConnection();    
}

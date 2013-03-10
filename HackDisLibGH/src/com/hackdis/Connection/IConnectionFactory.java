/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackdis.Connection;
import java.sql.Connection;
/**
 * IConnectionFactory
 * 
 * Inteface que establece los metodos a utilizar
 * 
 * @author Roberto
 * @version 1.0
 */
public interface IConnectionFactory {
    /**
     * Inicia la Conexion con la Base de Datos
     * @return Connection : Conexion con la base de datos  
     * @see IConnection#startConnection() 
     */
    public Connection startConnection();
    /**
     * Detiene la Conexion con la Base de Datos
     * @throws Exception : Error en caso de que no se pueda cerrar la conexion 
     * 
     */
    public void stopConnection() throws Exception;
    
}

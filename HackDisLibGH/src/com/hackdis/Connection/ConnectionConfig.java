/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackdis.Connection;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * ConnectionConfig es la clase encargada de la lectura del Fichero ConnectionConfig.properties,
 * obteniendo de este las siguientes propiedades :
 * <ul>
 * <li><h4>Driver</h3>Se Encarga de Establecer el motor de base de datos con el cual se creará la conexion.</li>
 * <li><h4>Host</h4>Es el Nombre o Direccion IP del Servidor donde se aloja la base de datos, si el host es el equipo local este tendra el nombre de "localhost" o la direccion IP "127.0.0.0"</li>
 * <li><h4>Port</h4>Este es el Puerto por el cual se iniciara la Conexion el Servidor de Bases de Datos, el puerto difiere del Motor de Base de datos que se esta usando, los puertos por defectos de los distintod motores son los siguienes:
 * <ul>
 * <li><h5>MySql: 3306</h5></li>
 * <li><h5>Oracle: 1521</h5></li>
 * <li><h5>PostgreSql: 5432<h5></li>
 * <li><h5>MSSqlServer: 1433<h5></li>
 * </ul></li>
 * <li><h4>DataBase</h4>Este es el Nombre de la base de datos a la cual se quiere realizar la conexion</li>
 * <li><h4>User</h4>Este es el Nombre de Usuario de la base de datos, con este nombre de usuario se podra tener acceso dependiendo de los permisos que este posea dentro de la base de datos en cuestión</li>
 * <li><h4>Passwd</h4>Este es el Password o Contraseña del usuario mencionado en el punto anterior</li>
 * </ul>
 * <h5>Importante: El archivo .properties debe estar en la raiz de la aplicacion, quiere decir donde se encuentra el archivo .jar</h5>
 * @author Roberto
 * @version 1.0
 */
public class ConnectionConfig {
    Properties _properties;

    /**
     * Constante que representa el Nombre del archivo de Configuracion : ConnectionConfig.properties
     */    
    public final static String CONFIG_FILE_NAME ="ConnectionConfig.properties";
    /**
     * Constante que hace referencia a la propiedad "driver" del archivo de configuración
     */    
    public final static String DRIVER ="driver";
    /**
     * Constante que hace referencia a la propiedad "host" del archivo de configuración
     */    
    public final static String HOST ="host";
    /**
     * Constante que hace referencia a la propiedad "port" del archivo de configuración
     */    
    public final static String PORT ="port";
    /**
     * Constante que hace referencia a la propiedad "database" del archivo de configuración
     */    
    public final static String DATABASE ="database";
    /**
     * Constante que hace referencia a la propiedad "user" del archivo de configuración
     */    
    public final static String USER ="user";
    /**
     * Constante que hace referencia a la propiedad "passwd" del archivo de configuración
     */    
    public final static String PASSWD ="passwd";
     
    /**
     * Construtor de la clase, se encarga de leer el archivo de propiedades desde la ruta absoluta de la aplicacion
     */    
    private ConnectionConfig(){
        this._properties = new Properties();
        try{            
            System.out.println(new File(CONFIG_FILE_NAME).getAbsolutePath());
            _properties.load(new FileInputStream(new File(CONFIG_FILE_NAME).getAbsolutePath()));
        }catch(Exception e ){
            e.printStackTrace();
        }
    }
    
    /**
     * Crea una unica instancia de la clase ConnectionConfig
     * @return ConnectionConfig
     */
    public static ConnectionConfig getInstance(){
        return ConfigurationHolder.INSTANCE;
    }
    /**
     * Esta clase interna se encarga de mantener solo 1 instancia de ConnectionConfig almacenandola en una Constante llamada INSTANCE
     */
    public static class ConfigurationHolder{
        private final static ConnectionConfig INSTANCE = new ConnectionConfig();
    }
    /**
     * Obtiene el valor de un atributo o propiedad del archivo .properties
     * @param key : llave o nombre del atributo
     * @return String: valor del atributo
     */
    public String getProperty(String key){
        return this._properties.getProperty(key);
    }
}

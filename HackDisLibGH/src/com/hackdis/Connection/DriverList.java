/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hackdis.Connection;

/**
 * Enumeracion que almacena los distintos nombre de Driver necesarios para la conexiòn
 * @author Roberto
 * @version 1.0
 */
public enum DriverList {
    /**
     * "org.postgresql.Driver"
     */
    PostgreSQL("org.postgresql.Driver"),
    /**
     * "-"
     */
    Oracle(""),
    /**
     * "-"
     */
    SQLServer(""),
    /**
     * "com.mysql.jdbc.Driver"
     */
    MySQL("com.mysql.jdbc.Driver");

    private String _driverName;
    
    DriverList(String driverName){
        this._driverName = driverName;
    }
    public String getDriverName(){
        return this._driverName;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.dbconfig;

import main.pojo.BasePojo;

/**
 *
 * @author tera
 */
public abstract class MysqlQuery {
    String tableName;
    
    public MysqlQuery(String tableName) {
        this.tableName = tableName;
    }
    
    public String queryGetAll() {
        return "SELECT * FROM " + tableName;
    }
    
    public String queryGet(String MoreQuery) {
        return this.queryGetAll() + MoreQuery;
    }
    
    public String queryAdd(String dataId, BasePojo obj) {
        return "INSERT INTO " + tableName + " VALUES ('" + dataId + "'," + obj.toSQLValue() + ')';
    }
    
    public String queryAdd(BasePojo obj) {
        return "INSERT INTO " + tableName + " VALUES (" + obj.toSQLValue() + ')';
    }
    
    public String queryUpdate(String where, String whereValue, BasePojo obj) {
        return "UPDATE " + tableName + " SET " + obj.toSetDataValue() + " WHERE " + where + "='" + whereValue + "'";
    }
    
    public String queryDelete(String where, String whereValue) {
        return "DELETE FROM " + tableName + " WHERE " + where + "='" + whereValue + "'";
     }
}

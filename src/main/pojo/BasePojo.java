/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.pojo;

/**
 *
 * @author tera
 */
public abstract class BasePojo extends Object {
    public abstract String toSQLValue();
    public abstract String toSetDataValue();
}

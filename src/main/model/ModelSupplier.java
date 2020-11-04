/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import main.pojo.Supplier;
import main.dbconfig.Database;
import main.dbconfig.MysqlQuery;
import main.pojo.ResponseSQL;

/**
 *
 * @author tera
 */
public class ModelSupplier extends MysqlQuery {
    Database db = new Database();
    
    public ModelSupplier() {
        super("supplier");
    }
    
    public List<Supplier> getAll() {
        db.connect();
        List<Supplier> supplierList = new ArrayList<>();
        
        String query = this.queryGetAll();
        ResponseSQL response = db.executeQuery(query);
        boolean isSuccess = response.getSuccess();
        
        if(!isSuccess) {
            System.out.println(response.getMessage());
            return supplierList;
        }
        
        try {
            ResultSet rset = (ResultSet) response.getData();
            while(rset.next()) {
                Supplier supplier = new Supplier();
                supplier.setKdsplr(rset.getString("kdsplr"));
                supplier.setNm_splr(rset.getString("nm_splr"));
                supplier.setNm_brg(rset.getString("nm_brg"));
                supplier.setBnyk_brg(rset.getInt("bnyk_brg"));
                supplierList.add(supplier);
            }
        } catch (SQLException e) {
            System.out.println("Error main.model.ModelSupplier.getall()");
            System.out.println(e);
        }
        return supplierList;
    }
    
    public void add(Supplier supplier) {
        db.connect();
                
        String query = this.queryAdd(supplier.getKdsplr(), supplier);
        ResponseSQL response = db.executeUpdate(query);
        if (response.getSuccess()) {
            JOptionPane.showMessageDialog(
                null,
                response.getMessage(),
                "Berhasil",JOptionPane.YES_NO_OPTION
            );
        }
    }
    
    public void delete(String kdsplr) {
        db.connect();
        
        String query = this.queryDelete("kdsplr", kdsplr);
        ResponseSQL response = db.executeUpdate(query);
        if(response.getSuccess()) {
            JOptionPane.showMessageDialog(
                null,
                response.getMessage(),
                "Berhasil",JOptionPane.YES_NO_OPTION
            );
        }
    }
}

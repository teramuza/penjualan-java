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
import main.dbconfig.Database;
import main.dbconfig.MysqlQuery;
import main.pojo.Penjualan;
import main.pojo.ResponseSQL;
import main.pojo.Supplier;

/**
 *
 * @author tera
 */
public class ModelPenjualan extends MysqlQuery {
    Database db = new Database();
    
    public ModelPenjualan() {
        super("penjualan");
    }
    
    public List<Penjualan> getAll() {
        db.connect();
        String query = this.queryGetAll();
        ResponseSQL response = db.executeQuery(query);
        boolean isSuccess = response.getSuccess();
        if (!isSuccess) {
            System.out.println(response.getMessage());
            return null;
        }
        List<Penjualan> penjualanList = new ArrayList<>();
        
        try {
            ResultSet rset = (ResultSet) response.getData();
            while(rset.next()) {
                Penjualan penjualan = new Penjualan();
                penjualan.setKd_brg(rset.getString("kd_brg"));
                penjualan.setTgl(rset.getTimestamp("tgl").toString());
                penjualan.setTtl_byr(rset.getInt("ttl_byr"));
                penjualan.setByr(rset.getInt("byr"));
                penjualan.setJml_beli(rset.getInt("jml_beli"));
                penjualan.setPtng(rset.getInt("ptng"));
                penjualanList.add(penjualan);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return penjualanList;
    }
    
    public void add(Penjualan penjualan) {
        db.connect();
                
        String query = this.queryAdd(penjualan);
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

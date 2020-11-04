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
import main.pojo.Barang;
import main.pojo.ResponseSQL;

/**
 *
 * @author tera
 */
public class ModelBarang extends MysqlQuery {
    Database db = new Database();

    public ModelBarang() {
        super("barang");
    }
    
    public List<Barang> getAll() {
        db.connect();
        List<Barang> barangList = new ArrayList<>();
        
        String query = this.queryGetAll();
        ResponseSQL response = db.executeQuery(query);
        boolean isSuccess = response.getSuccess();
        
        if (!isSuccess) {
            System.out.println(response.getMessage());
            return barangList;
        }

        try {
            ResultSet rset = (ResultSet) response.getData();
            while(rset.next()) {
                Barang barang = new Barang();
                barang.setKd_brg(rset.getString("kd_brg"));
                barang.setNm_brg(rset.getString("nm_brg"));
                barang.setJns(rset.getString("jns"));
                barang.setJml(rset.getInt("jml"));
                barang.setPbl(rset.getInt("pbl"));
                barang.setPjl(rset.getInt("pjl"));
                barangList.add(barang);
            }
        } catch (SQLException e) {
            System.out.println("Error main.model.ModelBarang.getall()");
            System.out.println(e);
        }
        
        return barangList;
    }
    
    private Barang getBarang(String where, String value) {
        db.connect();
        Barang barang = new Barang();
        
        String query = this.queryGet("WHERE " + where + '=' + value);
        ResponseSQL response = db.executeQuery(query);
        boolean isSuccess = response.getSuccess();
        
        if (!isSuccess) {
            System.out.println(response.getMessage());
            return barang;
        }
        
        try {
            ResultSet rset = (ResultSet) response.getData();
            while(rset.next()) {
                barang = new Barang();
                barang.setKd_brg(rset.getString("kd_brg"));
                barang.setNm_brg(rset.getString("nm_brg"));
                barang.setJns(rset.getString("jns"));
                barang.setJml(rset.getInt("jml"));
                barang.setPbl(rset.getInt("pbl"));
                barang.setPjl(rset.getInt("pjl"));
            }
        } catch (SQLException e) {
            System.out.println("Error: main.model.ModelBarang.getBarang(" + where + ',' + value + ')');
            System.out.println(e);
        }
        
        return barang;
    }
    
    public Barang getOne(String kd_brg) {
        return this.getBarang("kd_brg", kd_brg);
    }
    
    public Barang getOneByName(String nm_brg) {
        return this.getBarang("nm_brg", nm_brg);
    }
    
    public void add(Barang barang) {
        db.connect();
                
        String query = this.queryAdd(barang.getKd_brg(), barang);
        ResponseSQL response = db.executeUpdate(query);
        if (response.getSuccess()) {
            JOptionPane.showMessageDialog(
                null,
                response.getMessage(),
                "Berhasil",JOptionPane.YES_NO_OPTION
            );
        }
    }
    
    public void update(String kd_brg, Barang barang) {
        db.connect();
        
        String query = this.queryUpdate("kd_brg", kd_brg, barang);
        ResponseSQL response = db.executeUpdate(query);
        if (response.getSuccess()) {
            JOptionPane.showMessageDialog(
                null,
                response.getMessage(),
                "Berhasil",JOptionPane.YES_NO_OPTION
            );
        }
    }
    
    public void delete(String kd_brg) {
        db.connect();
        
        String query = this.queryDelete("kd_brg", kd_brg);
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

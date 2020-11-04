/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.pojo;

import lombok.Data;

/**
 *
 * @author tera
 */
@Data
public class Penjualan extends BasePojo {
    String kd_brg;
    String tgl;
    int ttl_byr;
    int byr;
    int jml_beli;
    int ptng;
    
    public Penjualan() {};
    
    public Penjualan(String kd_brg, String tgl, int ttl_byr, int byr, int jml_beli, int ptng) {
        this.kd_brg = kd_brg;
        this.tgl = tgl;
        this.ttl_byr = ttl_byr;
        this.byr = byr;
        this.jml_beli = jml_beli;
        this.ptng = ptng;
    }
    
    @Override
    public String toSQLValue() {
        return kd_brg+','+tgl+','+ttl_byr+','+byr+','+jml_beli+','+ptng;
    }
    
    @Override
    public String toSetDataValue() {
        return "";
    }
}

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
public class Barang extends BasePojo {
    String kd_brg;
    String nm_brg;
    String jns;
    int jml;
    int pbl;
    int pjl;
    
    public Barang() {}
    
    public Barang (String kd_brg, String nm_brg, String jns, int jml, int pbl, int pjl) {
        this.kd_brg = kd_brg;
        this.nm_brg = nm_brg;
        this.jns = jns;
        this.jml = jml;
        this.pbl = pbl;
        this.pjl = pjl;
    }
    
    @Override
    public String toSQLValue() {
        return "'" + nm_brg+"','"+jns+"','"+jml+"','"+pbl+"','"+pjl+"'";
    }
    
    @Override
    public String toSetDataValue() {
        return "nm_brg='" + nm_brg + "',jns='" + jns + "',jml='" + jml + "',pbl='" + pbl + "',pjl='" + pjl + "'";
    }
}

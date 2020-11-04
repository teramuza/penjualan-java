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
public class Supplier extends BasePojo {
    String kdsplr;
    String nm_splr;
    String nm_brg;
    int bnyk_brg;
    
    public Supplier() {};
    
    public Supplier(String kdsplr, String nm_splr, String nm_brg, int bnyk_brg) {
        this.kdsplr = kdsplr;
        this.nm_splr = nm_splr;
        this.nm_brg = nm_brg;
        this.bnyk_brg = bnyk_brg;
    }

    @Override
    public String toSQLValue() {
        return kdsplr+','+nm_splr+','+nm_brg+','+bnyk_brg;
    }

    @Override
    public String toSetDataValue() {
        return "";
    }
}

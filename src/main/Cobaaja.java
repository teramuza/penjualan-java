/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.List;
import main.model.ModelBarang;
import main.pojo.Barang;

/**
 *
 * @author tera
 */
public class Cobaaja {
    public static void main(String args[]){
        ModelBarang barangProcess = new ModelBarang();
        try {
            List<Barang> barangList = barangProcess.getAll();
            for(int i = 0; i < barangList.size(); i++) {
                System.out.println(barangList.get(i));
            }
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}

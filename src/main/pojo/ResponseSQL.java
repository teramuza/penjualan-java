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
public class ResponseSQL {
    private boolean success;
    private String message;
    private Object data;
    
    public ResponseSQL() {};
    
    public ResponseSQL(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }
    
    public ResponseSQL(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean getSuccess() {
        return success;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yourcad;

/**
 *
 * @author MaXx
 */
public class Cliente {

    public Cliente(int cliente_id, String cliente_nome, String cliente_documento) {
        this.cliente_id = cliente_id;
        this.cliente_nome = cliente_nome;
        this.cliente_documento = cliente_documento;
    }

    Cliente() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getCliente_nome() {
        return cliente_nome;
    }

    public void setCliente_nome(String cliente_nome) {
        this.cliente_nome = cliente_nome;
    }

    public String getCliente_documento() {
        return cliente_documento;
    }

    public void setCliente_documento(String cliente_documento) {
        this.cliente_documento = cliente_documento;
    }
    
    private int cliente_id;
    private String cliente_nome;
    private String cliente_documento;

    void setCliente_id(String cliente_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

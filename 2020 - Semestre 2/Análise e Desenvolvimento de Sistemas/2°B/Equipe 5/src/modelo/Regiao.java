/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Leandro
 */
public class Regiao {
    private String _estado;
    private String _sigla;
    private String _regiao;
    private String _valorHoraExtra;
    
    public String getEstado() {
        return _estado;
    }

    public void setEstado(String _estado) {
        this._estado = _estado;
    }
    
    public String getSigla() {
        return _sigla;
    }

    public void setSigla(String _sigla) {
        this._sigla = _sigla;
    }
    
    public String getRegiao() {
        return _regiao;
    }

    public void setRegiao(String _regiao) {
        this._regiao = _regiao;
    }
    
    public String getValorHoraExtra() {
        return _valorHoraExtra;
    }

    public void setValorHoraExtra(String _valorHoraExtra) {
        this._valorHoraExtra = _valorHoraExtra;
    }
}

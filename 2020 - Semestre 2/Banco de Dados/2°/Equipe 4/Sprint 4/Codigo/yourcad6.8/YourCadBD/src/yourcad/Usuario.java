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
public class Usuario 
{
    private int usuario_Id;
    private String usuario_Nome;
    private String usuario_Login;
    private String usuario_Senha;
    private String usuario_Email;
    private String usuario_Nivel_Acesso;
    private String usuario_status;

    
    public String getUsuario_status() {
        return usuario_status;
    }

    public void setUsuario_status(String usuario_status) {
        this.usuario_status = usuario_status;
    }
    public int getUsuario_Id() {
        return usuario_Id;
    }

    public void setUsuario_Id(int usuario_Id) {
        this.usuario_Id = usuario_Id;
    }

    public String getUsuario_Nome() {
        return usuario_Nome;
    }

    public void setUsuario_Nome(String usuario_Nome) {
        this.usuario_Nome = usuario_Nome;
    }

    public String getUsuario_Login() {
        return usuario_Login;
    }

    public void setUsuario_Login(String usuario_Login) {
        this.usuario_Login = usuario_Login;
    }

    public String getUsuario_Senha() {
        return usuario_Senha;
    }

    public void setUsuario_Senha(String usuario_Senha) {
        this.usuario_Senha = usuario_Senha;
    }

    public String getUsuario_Email() {
        return usuario_Email;
    }

    public void setUsuario_Email(String usuario_Email) {
        this.usuario_Email = usuario_Email;
    }

    public String getUsuario_Nivel_Acesso() {
        return usuario_Nivel_Acesso;
    }

    public void setUsuario_Nivel_Acesso(String usuario_Nivel_Acesso) {
        this.usuario_Nivel_Acesso = usuario_Nivel_Acesso;
    }

    public Usuario(int usuario_Id, String usuario_Nome, String usuario_Login, String usuario_Senha, String usuario_Email, String usuario_Nivel_Acesso, String usuario_status) 
    {
        this.usuario_Id = usuario_Id;
        this.usuario_Nome = usuario_Nome;
        this.usuario_Login = usuario_Login;
        this.usuario_Senha = usuario_Senha;
        this.usuario_Email = usuario_Email;
        this.usuario_Nivel_Acesso = usuario_Nivel_Acesso;
        this.usuario_status = usuario_status;
    }

    
    
    
    
}

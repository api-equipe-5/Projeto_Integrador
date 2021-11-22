package br.com.fatec.springbootpi.model;

public class MensagemForm {
    private String conteudoMsg;
    private Long idUsuario, idConversa;

    public String getConteudoMsg() {
        return conteudoMsg;
    }

    public Long getIdConversa() {
        return idConversa;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setConteudoMsg(String conteudoMsg) {
        this.conteudoMsg = conteudoMsg;
    }

    public void setIdConversa(Long idConversa) {
        this.idConversa = idConversa;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package source;

public class ContaLuz {
    
    private String instalacao;
    private String nomeCliente;
    private String vencimento;
    private String contaMes;
    private String consumo;
    private String tarifa;
    private String pis;
    private String cofins;
    private String icms;
    private String totalPagar;
    
    
    public ContaLuz(String instalacao, String nomeCliente, String vencimento, String contaMes, String consumo, String tarifa, String pis, String cofins, String icms, String totalPagar) {
        
        this.instalacao = instalacao;
        this.nomeCliente = nomeCliente;
        this.vencimento = vencimento;
        this.contaMes = contaMes;
        this.consumo = consumo;
        this.tarifa = tarifa;
        this.pis = pis;
        this.cofins = cofins;
        this.icms = icms;
        this.totalPagar = totalPagar;
    }

    public void setInstalacao(String instalacao) {
        this.instalacao = instalacao;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    public void setContaMes(String contaMes) {
        this.contaMes = contaMes;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public void setCofins(String cofins) {
        this.cofins = cofins;
    }

    public void setIcms(String icms) {
        this.icms = icms;
    }

    public void setTotalPagar(String totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getInstalacao() {
        return instalacao;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getVencimento() {
        return vencimento;
    }

    public String getContaMes() {
        return contaMes;
    }

    public String getConsumo() {
        return consumo;
    }

    public String getTarifa() {
        return tarifa;
    }

    public String getPis() {
        return pis;
    }

    public String getCofins() {
        return cofins;
    }

    public String getIcms() {
        return icms;
    }

    public String getTotalPagar() {
        return totalPagar;
    }

    public String toString() {
        return "INSTALACAO=" + instalacao + ",NOME=" + nomeCliente + ",VENCIMENTO=" + vencimento + ",CONTA DO MES=" + contaMes + ",CONSUMO=" + consumo + ",TARIFA=" + tarifa + ",PIS=" + pis + ",COFINS=" + cofins + ",ICMS=" + icms + ",TOTAL A PAGAR=" + totalPagar + '\n';
    }
    
    
    
    
    
}

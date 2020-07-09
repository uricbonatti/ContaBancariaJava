package io.uric.clientes;

public class Cliente{
    private long idCliente;
    private String nomeCliente;
    private String telefone;
    public Cliente(long idCliente, String nomeCliente, String telefone){
      this.idCliente=idCliente;
      this.nomeCliente=nomeCliente;
      this.telefone=telefone;
    }
    public long getIdCliente() {
        return idCliente;
    }
    public String imprimir(){
        return ""+idCliente+" - "+nomeCliente;
    }
    public String contato(){
        return "Identificador: "+idCliente+"\nCliente: "+nomeCliente+"\nTelefone: "+telefone;
    }


}

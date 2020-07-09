package io.uric.controle;

public class RegistradorTransfer extends Registrador{
    private String contaAlvo;

    public RegistradorTransfer(long numConta, OperacaoENUM tipoOperacaoENUM, double valor, String banco, long numContaAlvo) {
        super(numConta, tipoOperacaoENUM, valor);
        this.contaAlvo = banco+" "+numContaAlvo;
    }
    public String imprimir (){
        return ""+this.idOperacao+" - "+this.numConta+" -> "+this.tipoOperacaoENUM +" R$ "+this.valor+" -> "+this.contaAlvo;
    }
}

package io.uric.controle;

public class Registrador {
    protected long idOperacao;
    protected long numConta;
    protected OperacaoENUM tipoOperacaoENUM;
    protected double valor;
    public Registrador(long numConta, OperacaoENUM tipoOperacaoENUM, double valor) {
        this.idOperacao = Movimentacao.numRegistros++;
        this.numConta = numConta;
        this.tipoOperacaoENUM = tipoOperacaoENUM;
        this.valor = valor;
    }
    public String imprimir (){
        return ""+this.idOperacao+" - "+this.numConta+" -> "+this.tipoOperacaoENUM +" R$ "+this.valor;
    }
}

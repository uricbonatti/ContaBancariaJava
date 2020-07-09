package io.uric.contas;

abstract public class ComAnuidade extends Conta{
    protected static double TED = 19.50;
    public boolean transferir(double valor, long numContaAlvo,String banco){
        if(banco.equals("0001")){
            for (Conta conta:ListaDeContas.listaContas) {
                if (numContaAlvo == conta.numConta){
                    if (this.sacar(valor+TED)) {
                        conta.depositar(valor);
                        return true;
                    }
                }
            }
            return false;
        }
        if(this.sacar(valor+TED)) {
            ListaDeContas.saldoBancario-=valor;
            return true;
        }
        return false;
    }
}

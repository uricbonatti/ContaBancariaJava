package io.uric.contas;

import io.uric.clientes.Cliente;

public class Especial extends ComAnuidade{
    private double limiteEspecial;
    public Especial(long numConta, Cliente cliente, double limiteEspecial){
        this.limiteEspecial=limiteEspecial;
        this.numConta=numConta;
        this.cliente=cliente;
        this.saldo=0;
    }
    public boolean sacar(double valor){
        if((valor <= 0 ) || (valor > (saldo+limiteEspecial))){
            return false;
        }
        saldo-=valor;
        return true;
    }
}


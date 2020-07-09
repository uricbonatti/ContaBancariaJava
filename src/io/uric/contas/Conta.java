package io.uric.contas;

import io.uric.clientes.Cliente;

abstract public class Conta {
    protected long numConta;
    protected Cliente cliente;
    protected double saldo;

    public double getSaldo() {
        return saldo;
    }

    public boolean sacar(double valor){
        if((valor <= 0 ) || (valor > saldo)){
            return false;
        }
        saldo-=valor;
        return true;
    }
    public boolean depositar(double valor){
        if(valor<=0){
            return false;
        }
        saldo+=valor;
        return true;
    }
}

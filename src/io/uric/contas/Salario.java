package io.uric.contas;

import io.uric.clientes.Cliente;

public class Salario extends Conta{
    public Salario(long numConta, Cliente cliente){
        this.numConta=numConta;
        this.cliente=cliente;
        this.saldo=0;
    }
}

package io.uric.contas;

import io.uric.clientes.Cliente;

public class Simples extends ComAnuidade{
    public Simples(long numConta, Cliente cliente){
        this.numConta=numConta;
        this.cliente=cliente;
        this.saldo=0;
    }
}

package io.uric;

import io.uric.clientes.ListaDeClientes;
import io.uric.contas.ListaDeContas;
import io.uric.controle.Movimentacao;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static boolean caseWhile (int opcao) {
        switch (opcao){
            case 1:
                System.out.println("=================================================");
                System.out.println("Cadastrar Cliente Selecionado");
                ListaDeClientes.cadastrarCliente();
                break;
            case 2:

                System.out.println("=================================================");
                System.out.println("Cadastrar Conta Selecionado");
                if(ListaDeClientes.listaClientes.size()>0){
                    ListaDeContas.cadastrarConta();
                    break;
                }
                System.out.println("Não existe cliente cadastrado, impossivel realizar esta operação.");
                break;
            case 3:
                System.out.println("=================================================");
                System.out.println("Operar Conta Selecionado");
                if(ListaDeContas.listaContas.size()>0){
                    ListaDeContas.operarConta();
                    break;
                }
                System.out.println("Não existe conta cadastrada, impossivel realizar esta operação.");
                break;
            case 4:
                System.out.println("=================================================");
                System.out.println("Emitir Relatorio de Movimentação Selecionado");
                try {
                    Movimentacao.listarMovimentacao();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 0:
                System.out.println("Saindo....");
                break;
            default:
                System.out.println("Opção Invalida! Retornando ao Menu...");

        }
        return opcao != 0;
    }
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int opcao;
        while (true) {
            System.out.println("=================================================");
            System.out.println("========= Banco Mais do que Furada ==============");
            System.out.println("============== Seja Bem Vindo ===================");
            System.out.println("=================================================");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Conta");
            System.out.println("3 - Operar Conta");
            System.out.println("4 - Emitir Relatorio de Movimentação");
            System.out.println("0 - Sair");
            opcao = ler.nextInt();
            if (!caseWhile(opcao)) {
                break;
            }
        }
    }
}

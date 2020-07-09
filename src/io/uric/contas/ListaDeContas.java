package io.uric.contas;

import io.uric.clientes.Cliente;
import io.uric.clientes.ListaDeClientes;
import io.uric.controle.Movimentacao;
import io.uric.controle.OperacaoENUM;
import io.uric.controle.Registrador;
import io.uric.controle.RegistradorTransfer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaDeContas {
    public static List<Conta> listaContas = new ArrayList<Conta>();
    public static double saldoBancario =10000;
    public static long qtdContas =0;

    public static List<Conta> buscarConta(long numConta){
        List<Conta> encontrados = new ArrayList<>();
        for(Conta conta:listaContas){
            if(conta.numConta==numConta){
                encontrados.add(conta);
            }
        }
        return encontrados;
    }

    public static void cadastrarConta(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite no identificador do cliente: ");
        long idCliente  = ler.nextLong();
        List<Cliente> clientes = ListaDeClientes.buscarCliente(idCliente);
        if(clientes.isEmpty()){
            System.out.println("Cliente não encontrado retornando ao menu...");
            return;
        }
            System.out.println("Digite a opção de conta que deseja criar:");
            System.out.println("1 - Conta Especial");
            System.out.println("2 - Conta Simples");
            System.out.println("3 - Conta Salario");
            System.out.println("Any - Retornar ao Menu");
        int opcao  = ler.nextInt();
        switch (opcao){
            case 1:
                System.out.println();
                System.out.println("Digite o Limite do cheque especial: ");
                int limite = ler.nextInt();
                listaContas.add(new Especial(++qtdContas,clientes.get(0),limite));
                System.out.println();
                System.out.println("O numero de sua conta é: " + qtdContas);
                System.out.println();
                return;
            case 2:
                listaContas.add(new Simples(++qtdContas,clientes.get(0)));
                System.out.println();
                System.out.println("O numero de sua conta é: " + qtdContas);
                System.out.println();
                return;
            case 3:
                listaContas.add(new Salario(++qtdContas,clientes.get(0)));
                System.out.println();
                System.out.println("O numero de sua conta é: " + qtdContas);
                System.out.println();
                return;
            default:
                return;
        }

    }

    private static boolean transferirEspecial(ComAnuidade conta){
        Scanner ler = new Scanner(System.in);
        System.out.println("Transferencia foi selecionado");
        System.out.println("Digite o Valor que deseja transferir: ");
        String valorTransferenciaString = ler.nextLine();
        double valorTransferencia = Double.parseDouble(valorTransferenciaString);
        System.out.println("Digite o Banco da Conta que deseja transferir: \n(Para este banco digite '0001') ");
        String banco = ler.nextLine();
        System.out.println("Digite o Numero da Conta que deseja transferir: ");
        long numContaAlvo = ler.nextLong();
        if(conta.transferir(valorTransferencia,numContaAlvo,banco)) {
            Movimentacao.movimentacao.add(new RegistradorTransfer(conta.numConta, OperacaoENUM.TRASFERIR, valorTransferencia, banco, numContaAlvo));
            return true;
        }
        return false;
    }
    public static void operarConta(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite o numero da conta: ");
        long numConta  = ler.nextLong();
        List<Conta> contas = ListaDeContas.buscarConta(numConta);
        if(contas.isEmpty()){
            System.out.println("Conta não encontrada retornando ao menu...");
            return;
        }
        Conta conta = contas.get(0);
        String tipoConta = conta.getClass().getSimpleName();
        System.out.println("===============================================");
        System.out.println("Digite a operação que deseja realizar: ");
        System.out.println("1 - Depositar");
        System.out.println("2 - Sacar");
        if(tipoConta.equals("Simples")||tipoConta.equals("Especial")){
            System.out.println("3 - Transferir");
        }
        System.out.println("4 - Consultar Salto");
        System.out.println("Any - Voltar ao Menu Inicial ");
        int opcao = ler.nextInt();
        if((opcao==3) && !(tipoConta.equals("Simples")||tipoConta.equals("Especial"))){
            opcao=0;
        }
        switch (opcao){
            case 1:
                Scanner lerValor1 = new Scanner(System.in);
                System.out.println("Depositar foi selecionado");
                System.out.println("Digite o Valor que deseja depositar: ");
                String valorDepositoString = lerValor1.nextLine();
                double valorDeposito = Double.parseDouble(valorDepositoString);
                if(conta.depositar(valorDeposito)){
                    System.out.println("Valor Aceito -> Deposito Realizado com Sucesso");
                    Movimentacao.movimentacao.add(new Registrador(conta.numConta, OperacaoENUM.DEPOSITAR,valorDeposito));
                    break;
                };
                System.out.println("Valor Recusado -> Deposito Falhou");
                break;
            case 2:
                    Scanner lerValor2 = new Scanner(System.in);
                    System.out.println("Sacar foi selecionado");
                    System.out.println("Digite o Valor que deseja sacar: ");
                    String valorSaqueString = lerValor2.nextLine();
                    double valorSaque = Double.parseDouble(valorSaqueString);

                    if (conta.sacar(valorSaque)) {
                        System.out.println("Valor Aceito -> Saque Realizado com Sucesso");
                        Movimentacao.movimentacao.add(new Registrador(conta.numConta, OperacaoENUM.SACAR, valorSaque));
                        break;
                    }
                    System.out.println("Valor Recusado -> Saque falhou");
                    break;
            case 3:
                if(transferirEspecial((ComAnuidade) conta)){
                    System.out.println("Transferencia Aceita -> Transferencia Realizada com Sucesso");
                    break;
                };
                System.out.println("Tranferencia Recusada -> Transferencia Falhou");
                break;
            case 4:
                System.out.println(" O saldo na sua conta "+tipoConta+" é de R$"+conta.getSaldo());
                break;
            default:
                break;
        }
    }

}

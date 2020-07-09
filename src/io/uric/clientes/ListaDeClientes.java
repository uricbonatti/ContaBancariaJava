package io.uric.clientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaDeClientes {
    public static List<Cliente> listaClientes = new ArrayList<Cliente>();
    public static long numClientes=0;
    public static void listarClientes(){
        for (Cliente cliente:listaClientes) {
            cliente.imprimir();
        }
    }
    public static void cadastrarCliente(){
        Scanner ler = new Scanner(System.in);
        System.out.println("=================================================");
        System.out.println("Para cadastrar um novo cliente forneça as informações:");
        System.out.println("-> Nome:");
        String nome = ler.nextLine();
        System.out.println("-> Telefone:");
        String telefone = ler.nextLine();
        listaClientes.add(new Cliente(++numClientes,nome,telefone));
        System.out.println("Seu numero de cliente é: "+numClientes);
        System.out.println("Cliente Cadastrado retornando ao menu inicial...");
        System.out.println("=================================================");
        System.out.println("\n\n");
    }
    public static List<Cliente> buscarCliente(long idBuscar){
        List<Cliente> encontrados = new ArrayList<>();
        for(Cliente cliente:listaClientes){
            if(cliente.getIdCliente()==idBuscar){
                encontrados.add(cliente);
            }
        }
        return encontrados;
    }
}

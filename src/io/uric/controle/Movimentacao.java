package io.uric.controle;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Movimentacao {
    public static List<Registrador> movimentacao = new ArrayList<Registrador>();
    public static long numRegistros;

    public static void listarMovimentacao() throws IOException {
        try {
            FileWriter writer = new FileWriter("resultado.txt");
            for (Registrador registro : movimentacao) {
                writer.write(registro.imprimir() + System.lineSeparator());
            }
            writer.close();
        }catch (IOException e){
            System.out.println("Falha em gravar o arquivo de movimentação");
        }
    }
}

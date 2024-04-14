import br.com.alura.modelos.Conta;

import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {
        int option = 0;

        Conta conta = new Conta("Rogerio corbo","Conta corrente",1599.99);

        conta.exibeDadosConta();
        Scanner entrada = new Scanner(System.in);

        while (option != 4) {
            option = conta.menu(entrada);

            if (option == 1) {
                conta.exibeDadosConta();
            } else if (option == 2) {
                conta.movimentaValores(entrada, option);
            } else if (option == 3) {
                conta.movimentaValores(entrada, option);
            } else if (option != 4) {
                System.out.println("Opção inválida !");
            }
        }
    }
}
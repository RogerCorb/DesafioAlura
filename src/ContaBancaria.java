import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {
        String nome = "Rogerio corbo";
        String tipoConta = "Conta corrente";
        double saldoConta = 1599.99;
        int option = 0;

        cabecalho(nome, tipoConta, saldoConta);

        Scanner entrada = new Scanner(System.in);
        while (option != 4) {
            option = menu(entrada);

            if (option == 1) {
                cabecalho(nome, tipoConta, saldoConta);
            } else if (option == 2) {
                saldoConta = movimentaValores(saldoConta, entrada, option);
                cabecalho(nome, tipoConta, saldoConta);
            } else if (option == 3) {
                saldoConta = movimentaValores(saldoConta, entrada, option);
                cabecalho(nome, tipoConta, saldoConta);
            } else if (option != 4) {
                System.out.println("Opção inválida !");
            }
        }
    }

    public static double movimentaValores(double valor, Scanner entrada, int opcao) {


        if (opcao == 2) {
            System.out.println("Qual o valor que deseja transferir : ");
            double valorRetirada = entrada.nextDouble();
            if (valorRetirada > valor) {
                System.out.println("Não ha saldo para realizar a transferência !");
            } else {
                valor -= valorRetirada;
                imprimeSaldo("Novo Saldo", valor);
            }
        } else if (opcao == 3) {
            System.out.println("Digite o valor a Receber : ");
            double valorEntrada = entrada.nextDouble();
            valor += valorEntrada;
            imprimeSaldo("Novo Saldo", valor);
        }
        return valor;
    }

    public static void cabecalho(String paramum, String paramdois, Double valor) {
        System.out.println("***********************************");
        System.out.println("Nome Cliente : " + paramum);
        System.out.println("Tipo de conta : " + paramdois);
        imprimeSaldo("Saldo Atual", valor);
        System.out.println("***********************************");
    }

    public static int menu(Scanner opcao) {
        String menu = """
                **** escolha a sua opção ****
                1 - consultar saldo
                2 - transferir valor
                3 - receber valor
                4 - sair
                """;
        System.out.println(menu);
        System.out.println("Digite sua opção .: ");
        return opcao.nextInt();
    }

    public static void imprimeSaldo(String mensagem, double valor) {
        System.out.println(String.format(mensagem + ": R$ %.2f ", valor));
    }
}
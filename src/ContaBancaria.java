import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {
        String nome = "Rogerio corbo";
        String tipoConta = "Conta corrente";
        double saldoConta = 1599.99;
        int option = 0 ;

        cabecalho(nome,tipoConta,saldoConta);

        Scanner entrada = new Scanner(System.in);
        while (option != 4 ){
            menu();
            System.out.println("Digite sua opção .: ");
            option = entrada.nextInt();
            if (option == 1) {
                cabecalho(nome,tipoConta,saldoConta);
            } else if (option == 2) {
                saldoConta = retirada(saldoConta,entrada);
                cabecalho(nome,tipoConta,saldoConta);
            } else if (option == 3) {
                saldoConta = deposito(saldoConta,entrada);
                cabecalho(nome,tipoConta,saldoConta);
            } else if (option > 4 || option < 0 ) {
                System.out.println("Opção inválida !");
            }
        }
    }
    public static double retirada(double valor, Scanner entrada) {

        System.out.println("Digite o valor a transferir : ");
        double valorRetirada = entrada.nextDouble();
        if(valorRetirada > valor) {
            System.out.println("Valor a transferir é maior que saldo em conta !");
        } else {
            valor -= valorRetirada;
            System.out.println("Seu saldo atual é de :" + valor);
        }
        return valor;
    }
    public static double deposito(double valor,Scanner entrada) {

        System.out.println("Digite o valor a Receber : ");
        double valorEntrada = entrada.nextDouble();
        valor += valorEntrada;
        System.out.println("Seu saldo atual é de :" + valor);
        return valor;
    }

    public static void cabecalho(String paramum,String paramdois,Double valor) {
        System.out.println("***********************************");
        System.out.println("Nome Cliente : " + paramum );
        System.out.println("Tipo de conta : " + paramdois);
        System.out.println("Saldo Atual : " +valor);
        System.out.println("***********************************");
    }

    public static void menu() {
        String menu = """
                **** escolha a sua opção **** 
                1 - consultar saldo 
                2 - transferir valor
                3 - receber valor
                4 - sair
                """;
        System.out.println(menu);
    }
}
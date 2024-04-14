package br.com.alura.modelos;

import java.util.Scanner;

public class Conta {
    private String nome;
    private String tipoConta;
    private double saldoConta;


    // Constructor
    public Conta(String nome, String tipoConta, double saldoConta) {
        this.nome = nome;
        this.tipoConta = tipoConta;
        this.saldoConta = saldoConta;
    }

    // Métodos
    public void exibeDadosConta(){

        System.out.println("***********************************");
        System.out.println("Nome Cliente : " + getNome());
        System.out.println("Tipo de conta : " + getTipoConta());
        imprimeSaldo("Saldo Atual ");
        System.out.println("***********************************");
    }

    private double transfere(double valor){
        double saldo = getSaldoConta();
        saldo -= valor;
        return saldo;
    }

    private double deposita(double valor){
        double saldo = getSaldoConta();
        saldo += valor;
        return saldo;
    }

    private void imprimeSaldo(String mensagem) {
        System.out.println(String.format(mensagem + ": R$ %.2f ", getSaldoConta()));
    }

    public int menu(Scanner opcao) {
        String menu = """
                *********   Menu Opções   *********
                1 - consultar saldo
                2 - transferir valor
                3 - receber valor
                4 - sair
                """;
        System.out.println(menu);
        System.out.println("Digite sua opção .: ");
        return opcao.nextInt();
    }

    public void movimentaValores(Scanner entrada, int opcao) {
        double saldo = getSaldoConta();

        if (opcao == 2) {
            System.out.println("Qual o valor que deseja transferir : ");
            double valorRetirada = entrada.nextDouble();

            if (valorRetirada > saldo) {
                System.out.println("Não ha saldo para realizar a transferência !");
            } else {
                setSaldoConta(transfere(valorRetirada));
                imprimeSaldo("Novo Saldo");
            }
        } else {
            System.out.println("Digite o valor a Receber : ");

            setSaldoConta(deposita(entrada.nextDouble()));
            imprimeSaldo("Novo Saldo");
        }
    }

    // Getters and setters //
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldoConta() {
        return saldoConta;
    }
    private void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }

}

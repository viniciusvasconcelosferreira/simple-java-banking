/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gerenciabanco;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Vinicius Vasconcelos Ferreira
 * @version 1.0.0
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = new ContaBancaria();

        System.out.println("Bem-vindo ao Gerenciamento Bancário!");

        boolean continuar = true;

        do {
            exibirMenu();
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Informe seu nome: ");
                    String nome = scanner.next();
                    scanner.nextLine();
                    conta.setNome(nome);

                    System.out.print("Informe seu sobrenome: ");
                    String sobrenome = scanner.next();
                    scanner.nextLine();
                    conta.setSobrenome(sobrenome);

                    System.out.print("Informe seu CPF: ");
                    String cpf = scanner.next();
                    scanner.nextLine();
                    conta.setCpf(cpf);
                    break;
                case 2:
                    if (conta.getNome() == null || conta.getSobrenome() == null || conta.getCpf() == null) {
                        System.out.println("Por favor, informe seu nome, sobrenome e CPF primeiro.");
                    } else {
                        conta.consultarSaldo();
                    }
                    break;
                case 3:
                    if (conta.getNome() == null || conta.getSobrenome() == null || conta.getCpf() == null) {
                        System.out.println("Por favor, informe seu nome, sobrenome e CPF primeiro.");
                    } else {
                        System.out.print("Informe o valor do depósito: ");
                        double valorDeposito = scanner.nextDouble();
                        conta.depositar(valorDeposito);
                    }
                    break;
                case 4:
                    if (conta.getNome() == null || conta.getSobrenome() == null || conta.getCpf() == null) {
                        System.out.println("Por favor, informe seu nome, sobrenome e CPF primeiro.");
                    } else {
                        System.out.print("Informe o valor do saque: ");
                        double valorSaque = scanner.nextDouble();
                        conta.sacar(valorSaque);
                    }
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        } while (continuar);

        System.out.println("Obrigado por utilizar o Gerenciamento Bancário!");
        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1 - Informar dados pessoais");
        System.out.println("2 - Consultar saldo");
        System.out.println("3 - Realizar depósito");
        System.out.println("4 - Realizar saque");
        System.out.println("5 - Encerrar aplicação");
        System.out.print("Escolha uma opção: ");
    }

}

class ContaBancaria {

    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque.");
        }
    }

    public void consultarSaldo() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        String saldoFormatado = df.format(saldo);
        System.out.println("Saldo atual: R$ " + saldoFormatado);
    }
}

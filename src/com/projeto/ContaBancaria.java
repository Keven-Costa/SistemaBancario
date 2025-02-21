package com.projeto;

import java.util.Random; 

public class ContaBancaria {
	// Atributos
	private Cliente cliente;
	private int numeroConta;

	// Construtor
	ContaBancaria(Cliente cliente) {
		this.cliente = cliente;
		this.numeroConta = gerarNumeroConta(); // Gerando um número aleatório

	}

	// Getts e Sets
	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	// Métodos
	void saque(float valorSaque) {

		if (cliente.getSaldo() == 0) {
			System.out.println("Ímpossivel realizar o Saque");
			System.out.print("Seu saldo R$");
			System.out.println(cliente.getSaldo());
			System.out.println("\n\n");

			
		} else {
			float novoSaldo = cliente.getSaldo();
			novoSaldo -= valorSaque;
			cliente.setSaldo(novoSaldo);
			System.out.println("Saque realizado com sucesso!");
			System.out.println("\n\n");

		}

	}

	void deposito(float valorDeposito) {
		float novoSaldo = cliente.getSaldo();
		novoSaldo += valorDeposito;
		cliente.setSaldo(valorDeposito);
		System.out.println("Deposito realizado com sucesso!");
		System.out.println("\n\n");

	}

	private int gerarNumeroConta() {
		Random random = new Random();
		return 1 + random.nextInt(100); // Gera um número inteiro entre 1 e 1000
	}
}

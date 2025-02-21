package com.projeto;

import java.util.Scanner; // Importação da classe Scanner

public class Main {

	public static void main(String[] args) {
		Cliente cliente;
		ContaBancaria conta;
		Scanner scanner = new Scanner(System.in);
		String nome;
		float valor;
		int opcaoCliente;

		System.out.println("Digite seu nome: ");
		nome = scanner.next();
		
		
		nome = nome.toLowerCase(); // Transforma em minusculo
		
		System.out.println(nome);
		
		// Verifica usuário VIP
		if (nome.equals("anderson")) {
			System.out.println("Usuário VIP detectado");
			System.out.println("Bonus de R$ 100,00");
			System.out.println("\n\n");

			cliente = new Cliente(nome, 100);
			conta = new ContaBancaria(cliente);

		}else {
			cliente = new Cliente(nome, 0);
			conta = new ContaBancaria(cliente);
		}
		



		System.out.println("==================== Seja bem vindo ao banco UNI9 ====================");
		System.out.println("\n\n");


		do {
		System.out.println("Escolha uma opção: ");
		System.out.println("1- Clinte");
		System.out.println("2- Saque");
		System.out.println("3- Depósito");
		System.out.println("4- Sair");

		opcaoCliente = scanner.nextInt();

		switch (opcaoCliente) {
		case 1: {
			System.out.println("==================== Informações do cliente ====================");
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("Saldo: " + cliente.getSaldo());
			System.out.println("Número da Conta: " + conta.getNumeroConta());
			System.out.println("\n\n");
			
			break;
		}
		case 2: {
			System.out.println("==================== Saque ====================");
			System.out.println("Digite o valor do saque:");
			System.out.print("R$ ");
			valor = scanner.nextFloat();
			conta.saque(valor);
			break;
		}
		case 3: {
			System.out.println("==================== Depósito ====================");
			System.out.println("Digite o valor do Depósito:");
			System.out.println("R$ ");
			valor = scanner.nextFloat();
			conta.deposito(valor);
			break;
		}
		case 4: {

			System.out.println("Até mais....");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcaoCliente);
		}
		
		} while (opcaoCliente != 4);

	}

}

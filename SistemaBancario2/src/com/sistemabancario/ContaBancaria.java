package com.sistemabancario;
import java.util.Random; 

public class ContaBancaria {
	private int numeroConta;
	private Cliente cliente;
	
	// Construtor
	ContaBancaria(Cliente cliente) {
		this.cliente = cliente;
		this.numeroConta = gerarNumeroConta(); // Gerando um número aleatóri
		

	}
	ContaBancaria(){
		this.numeroConta = gerarNumeroConta(); // Gerando um número aleatório
		this.cliente = new Cliente();
	}
	
	// Getts e Sets
	public int getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	
	// Métodos
	public void transferir(double valor, Cliente cliente, Cliente clienteTranferencia) {
		
		double novoSaldo = cliente.getSaldo();
		double mesmoSaldo = clienteTranferencia.getSaldo();
		novoSaldo -= valor;
		cliente.setSaldo(novoSaldo);
		clienteTranferencia.setSaldo(mesmoSaldo + valor);
		
		
		System.out.println("Trasnferencia realizado com sucesso!");
		System.out.println("\n\n");
	}
	void deposito(float valorDeposito, Cliente clienteDesejado) {
		double novoSaldo = clienteDesejado.getSaldo();
		novoSaldo += valorDeposito;
		clienteDesejado.setSaldo(novoSaldo);
		System.out.println("Deposito realizado com sucesso!");
		System.out.println("\n\n");

	}
	
	public void saque(double valorSaque, Cliente clienteDesejado) {
		if (clienteDesejado.getSaldo() == 0) {
			System.out.println("Ímpossivel realizar o Saque");
			System.out.print("Seu saldo R$");
			System.out.println(clienteDesejado.getSaldo());
			System.out.println("\n\n");

			
		} else {
			double novoSaldo = clienteDesejado.getSaldo();
			novoSaldo -= valorSaque;
			clienteDesejado.setSaldo(novoSaldo);
			System.out.println("Saque realizado com sucesso!");
			System.out.println("\n\n");

		}
	}
	private int gerarNumeroConta() {
		Random random = new Random();
		return 1 + random.nextInt(100); // Gera um número inteiro entre 1 e 1000
	}
	
	
	
	
}

package com.sistemabancario;

import java.util.ArrayList;

public class Cliente {
	private String nome;
	private double saldo;
	private ContaBancaria conta;

	// Construtores
	Cliente(String nome, double saldo) {
		this.nome = nome;
		this.saldo = saldo;
		this.conta = new ContaBancaria(); //

	}

	Cliente() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public ContaBancaria getConta() {
		return conta;
	}

	public void setConta(ContaBancaria conta) {
		this.conta = conta;
	}
	

}

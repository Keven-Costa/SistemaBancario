package com.projeto;

public class Cliente {
	// Atributos
	private String nome;
	private float saldo;

	// Construtores
	Cliente(String nome, float saldo) {
		this.nome = nome;
		this.saldo = saldo;
	}

	Cliente() {

	}

	// Getts e Sets
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

}

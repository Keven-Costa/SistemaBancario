package com.sistemabancario;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Cliente> clientes = new ArrayList<>();
		// ArrayList<ContaBancaria> contasBancarias = new ArrayList<>();
		Cliente cliente;
		// ContaBancaria conta;
		Cliente clienteDesejado;

		String nome;
		//double saldo;
		int numeroConta;

		int escolhaUsuario = 0;
		boolean credenciaisAceita;

		while (escolhaUsuario != 8) {

			System.out.println("********** MENU PRINCIPAL – SISTEMA BANCÁRIO **********");
			System.out.println("1 – Cadastrar Cliente / Conta");
			System.out.println("2 – Consultar Dados  do Cliente");
			System.out.println("3 – Excluir Cliente");
			System.out.println("4 – Alterar Dado do Cliente");
			System.out.println("5 – Depósito");
			System.out.println("6 – Saque");
			System.out.println("7 – Transferência de Valor");
			System.out.println("8 – Sair do sistema\n");

			System.out.println("*****************************************************");
			System.out.println("Quantidade de Clientes: " + clientes.size());
			System.out.println("*****************************************************\n");

			escolhaUsuario = scan.nextInt();

			switch (escolhaUsuario) {
			case 1:
				System.out.println("==================== Cadastro de Cliente ====================");
				System.out.print("Digite seu nome: ");
				nome = scan.next();

				cliente = new Cliente(nome, 0); // Cria um novo cliente com saldo R$0,00
				clientes.add(cliente); // Adiciona o cliente á Lista

				int ultimoItem = clientes.size() - 1;

				// Exibi informações da conta criada
				System.out.println("Conta Crianda com Sucesso!");
				System.out.println("Seja bem-vido(a): " + clientes.get(ultimoItem).getNome());
				System.out.println("Saldo da conta R$" + clientes.get(ultimoItem).getSaldo());
				System.out.println("Número da conta: " + clientes.get(ultimoItem).getConta().getNumeroConta());
				System.out.println("\n");
				break;

			case 2:
				System.out.println("==================== Consultar Dados  do Cliente ====================");
				System.out.print("Digite o nome do cliente: ");
				nome = scan.next();

				clienteDesejado = pesquisarCliente(clientes, nome);

				// Verificando se o cliente foi encontrado
				if (clienteDesejado != null) {

					// Exibi informações do Cliente
					System.out.println("Nome: " + clienteDesejado.getNome());
					System.out.println("Saldo da conta R$" + clienteDesejado.getSaldo());
					System.out.println("Número da conta: " + clienteDesejado.getConta().getNumeroConta());
					System.out.println("\n");

				} else {
					System.out.println("Cliente não encontrado.");
				}

				break;

			case 3:
				System.out.println("==================== Excluir Cliente ====================");
				System.out.print("Digite o nome do cliente: ");
				nome = scan.next();

				// Chama função responsável para deletar o cliente desejado
				deletarCliente(clientes, nome);
				break;

			case 4:
				System.out.println("==================== Alterar Dados do Cliente ====================");
				System.out.print("Digite o nome do cliente: ");
				nome = scan.next();

				// Chama a função responsável por alterar os dados do clientes
				alterarDadosCliente(clientes, nome);

				break;

			case 5:
				System.out.println("==================== Deposito ====================");
				System.out.print("Digite o nome: ");
				nome = scan.next();

				System.out.print("Digite o numero da sua conta: ");
				numeroConta = scan.nextInt();

				// Chama a função responsável para verificar as credenciais (nome e numero da
				// conta)
				credenciaisAceita = vericarCredenciais(clientes, nome, numeroConta);

				// Verifica o valor retornado da função 'vericarCredenciais'
				if (credenciaisAceita) {
					// Busca o cliente e exibi as informações dele
					clienteDesejado = pesquisarCliente(clientes, nome);
					System.out.println("Nome: " + clienteDesejado.getNome());
					System.out.println("Saldo da conta R$" + clienteDesejado.getSaldo());
					System.out.println("Número da conta: " + clienteDesejado.getConta().getNumeroConta());
					System.out.println("\n");

					System.out.println("Digite o valor de Deposito: ");
					float valorDeposito = scan.nextFloat();

					// Chama a função resposável pelo depósito
					clienteDesejado.getConta().deposito(valorDeposito, clienteDesejado);

				} else {
					System.out.println("Credenciais incorretas");
					System.out.println("Tente novamente!");
				}

				break;

			case 6:
				System.out.println("==================== Saque ====================");
				System.out.print("Digite o nome: ");
				nome = scan.next();

				System.out.print("Digite o numero da sua conta: ");
				numeroConta = scan.nextInt();

				// Chama a função responsável para verificar as credenciais (nome e numero da
				// conta)
				credenciaisAceita = vericarCredenciais(clientes, nome, numeroConta);

				if (credenciaisAceita) {
					clienteDesejado = pesquisarCliente(clientes, nome);

					System.out.println("Seu Saldo R$" + clienteDesejado.getSaldo());

					System.out.print("Digite o valor do saque: ");
					double valorSaque = scan.nextDouble();

					// Chama o método responsável para efetuar o saque
					clienteDesejado.getConta().saque(valorSaque, clienteDesejado);
				}

				break;

			case 7:
				System.out.println("==================== Transferência ====================");

				System.out.print("Digite o nome: ");
				nome = scan.next();

				System.out.print("Digite o numero da sua conta: ");
				numeroConta = scan.nextInt();

				// Chama o método responsável para vericicar as credenciais
				credenciaisAceita = vericarCredenciais(clientes, nome, numeroConta);

				// Verifica o valor retornado do método 'vericarCredenciais'
				if (credenciaisAceita) {
					// Pesquisa o cliente desejado e exibi as informações dele
					clienteDesejado = pesquisarCliente(clientes, nome);
					System.out.print("SEUS DADOS: ");
					System.out.println("Nome: " + clienteDesejado.getNome());
					System.out.println("Saldo da conta R$" + clienteDesejado.getSaldo());
					System.out.println("Número da conta: " + clienteDesejado.getConta().getNumeroConta());
					System.out.println("\n");

					System.out.print("Digie o Nome da pessoa que vai receber a Transferencia:");
					String nomePessoaDeposito = scan.next();

					System.out.print("Digite o numero da conta: ");
					int numeroContaDeposito = scan.nextInt();

					System.out.print("Digite o valor de Transferencia: ");
					float valorDeposito = scan.nextFloat();

					// Busca o cliente pelo nome e armazena o objeto encontrado na variável
					// clienteTrasferencia
					Cliente clienteTrasferencia = pesquisarCliente(clientes, nomePessoaDeposito);

					// Chama o método responsável pela trasferencia
					clienteDesejado.getConta().transferir(valorDeposito, clienteDesejado, clienteTrasferencia);
					System.out.println("Saldo atual da conta R$" + clienteDesejado.getSaldo());

				} else {
					System.out.println("Credenciais incorretas");
					System.out.println("Tente novamente!");
				}

			case 8:
				System.out.println("Saindo...");

			default:
				break;
			}
		}

		scan.close();

	}

	// Métodos
	public static Cliente pesquisarCliente(ArrayList<Cliente> clientes, String clienteDesejado) {
		// Itera sobre a lista de clientes
		for (Cliente cliente : clientes) {
			// Compara o nome do cliente com o nome desejado
			if (cliente.getNome().equals(clienteDesejado)) {
				return cliente; // Retorna o cliente encontrado
			}
		}
		return null; // Retorna null se o cliente não for encontrado
	}

	public static void deletarCliente(ArrayList<Cliente> clientes, String clienteDesejado) {
		// Pesquisa o cliente na lista de clientes
		Cliente clientePesquisado = pesquisarCliente(clientes, clienteDesejado);

		// Verificando se o cliente foi encontrado
		if (clienteDesejado != null) {
			clientes.remove(clientePesquisado);
			System.out.println("Cliente Excluído com Sucesso");
		} else {
			System.out.println("Cliente não encontrado.");
		}

	}

	public static void alterarDadosCliente(ArrayList<Cliente> clientes, String clienteDesejado) {
		// Pesquisa o cliente na lista de clientes
		Cliente clientePesquisado = pesquisarCliente(clientes, clienteDesejado);

		Scanner scan = new Scanner(System.in);
		String nome;

		// Verificando se o cliente foi encontrado
		if (clientePesquisado != null) {
			System.out.println("Nome do Cliente atual: " + clientePesquisado.getNome());
			System.out.print("Digite o novo nome do Cliente: ");
			nome = scan.next();

			clientePesquisado.setNome(nome);

			System.out.println("Dados do Cliente Alterado com Sucesso\n");
		} else {
			System.out.println("Cliente não encontrado.");
		}
		//
	}

	public static boolean vericarCredenciais(ArrayList<Cliente> clientes, String nomeCliente, int numeroConta) {
		// Pesquisa o cliente na lista de clientes
		Cliente clientePesquisado = pesquisarCliente(clientes, nomeCliente);
		boolean credenciaisAceitas = false;

		// Verificando se o cliente foi encontrado
		if (clientePesquisado != null) {

			String clienteExistente = clientePesquisado.getNome();
			int numeroContaExistente = clientePesquisado.getConta().getNumeroConta();

			// Verifica as Credenciasis (Nome do Cliente e Número da Conta)
			if (clienteExistente.equals(nomeCliente) && numeroContaExistente == numeroConta) {
				credenciaisAceitas = true;
				return credenciaisAceitas;
			} else {
				System.out.println("Credenciais incorretas");
				System.out.println("Tente novamente!");
				credenciaisAceitas = false;
			}

		} else {
			System.out.println("Credenciais incorretas");
			System.out.println("Tente novamente!");
			credenciaisAceitas = false;

		}
		return credenciaisAceitas;
	}
}

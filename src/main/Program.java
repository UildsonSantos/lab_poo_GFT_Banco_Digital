package main;

import entities.Cliente;
import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;
import exceptions.SaldoInsuficienteException;

public class Program {

	public static void main(String[] args) {
		Cliente cliente = new Cliente();
		cliente.setNome("Pedro");
		
		Conta cc = new ContaCorrente(cliente);
		Conta cp = new ContaPoupanca(cliente);

		cc.depositar(100);
		
		
		try {
			cc.sacar(100);
			cc.transferir(200, cp);
		} catch (SaldoInsuficienteException e) {
			System.err.println("Prezado cliente, Consulte seu gerente: " +e.getMessage());
		}
		
		cc.imprimirExtrato();
		cp.imprimirExtrato();
	}
}

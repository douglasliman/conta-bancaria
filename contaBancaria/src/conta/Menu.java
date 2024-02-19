package conta;

import conta.model.Conta;

public class Menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Conta conta1 = new Conta(123456,123,2,"Douglas Lima de Queiroz", 2000.0f);
		
		System.out.println("Número da conta");
		System.out.println(conta1.getNumero());
		System.out.println();
		
		System.out.println("Número da agencia");
		System.out.println(conta1.getAgencia());
		System.out.println();
		
		System.out.println("Número da agencia");
		System.out.println(conta1.getTipo());
		System.out.println();
		
		if(conta1.getTipo() == 1) {
			System.out.println("Conta poupança.");
		}else if(conta1.getTipo() == 2) {
			System.out.println("Conta Corrente.");
		}else {
			System.out.println("Conta Salário.");
		}
		System.out.println();
		
		System.out.println("Nome do Titular");
		System.out.println(conta1.getTitular());
		System.out.println();
		
		System.out.println("Novo Saldo");
		System.out.println(conta1.getSaldo());
		System.out.println();
		
		conta1.setSaldo(4000.0f);
		System.out.println("Seu novo aldo é");
		System.out.println(conta1.getSaldo());
		System.out.println();
	}

}

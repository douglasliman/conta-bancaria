package conta;

import conta.model.ContaCorrente;

public class Menu {

	public static void main(String[] args) {
		
		ContaCorrente c1 = new ContaCorrente(12345,002,2,"Douglas Queiroz", 2500.0f,400.0f);
	
		System.out.println("Meu saldo é: " + c1.getSaldo());
		
		System.out.println("------------------------");
		System.out.println("");
		
		c1.sacar(3000);
		
		System.out.println("------------------------");
		System.out.println("");
		
		c1.visualizar();
		
		System.out.println("------------------------");
		System.out.println("");
		
		c1.sacar(2700);
		
		System.out.println("------------------------");
		System.out.println("");
		
		c1.visualizar();
		
		System.out.println("------------------------");
		System.out.println("");
		
		c1.depositar(2000);
		
		System.out.println("");
		
		System.out.println("------------------------");
		c1.depositar(0);
	}

}

package conta.model;

public class ContaCorrente extends Conta {

	private float limite;

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		// TODO Auto-generated constructor stub
		this.limite = limite;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	@Override
	public boolean sacar(float valor) {
		if (this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\nSaldo insuficiente");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		System.out.println("\nSaque de "+ valor+ " efetuado, seu saldo atual é: " + this.getSaldo());
		return true;
	}



	@Override
	public void depositar(float valor) {
		if(valor > 0) {
			float newSaldo = this.getSaldo() + valor;
			System.out.println("Saldo efetuado com sucesso");
			System.out.println("Seu novo Saldo é: "+ newSaldo);
		}else {
		System.out.println("Impossivel depositar valores menores ou iguais a 0");
		}
		
	}

	@Override
	public void visualizar() {
		String tipoConta;
		switch (this.getTipo()) {
		case 1: {
			tipoConta = "Conta corrente";
			break;
		}
		case 2: {
			tipoConta = "Conta poupança";
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + this.getTipo());
		}

		System.out.println("**********************************");
		System.out.println("--------- Dados da conta ---------");
		System.out.println("**********************************");

		System.out.println("Número da conta: " + this.getNumero());
		System.out.println("Agencia da conta: " + this.getAgencia());
		System.out.println("Tipo  da conta: " + tipoConta);
		System.out.println("Titular da conta: " + this.getTitular());
		System.out.println("Saldo da conta: " + this.getSaldo());
		System.out.println("Limite da conta: " + this.limite);
		
	}

	

}
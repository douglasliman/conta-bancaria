package conta.repository;



public interface ContaRepositoy {
		
	
	public boolean sacar(int numero, float valor);
	public void depositar(int numero, float valor);
	public void visualizar();
}

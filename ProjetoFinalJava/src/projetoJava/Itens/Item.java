package projetoJava.Itens;

public abstract class Item {

	
	private String nome;
	private float valor;
	
	
	public Item (String nome, float valor) {
		this.nome = nome;
		this.valor = valor;
	}



	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public float getValor() {
		return valor;
	}


	public void setValor(float valor) {
		this.valor = valor;
	}
	

	
}

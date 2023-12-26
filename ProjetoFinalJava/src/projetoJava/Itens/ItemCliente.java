package projetoJava.Itens;

public class ItemCliente extends ItemLojista{
	
	public int quantidade;

	public ItemCliente(int quantidade, int id, String nome, float valor) {
		super(id, nome, valor);
		this.quantidade = quantidade;
	}

	//getters e setters 
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	

	public void verc(int quantidade, int id,  String nome, float valor) {
		System.out.println(quantidade + "\t" + id + "\t" + nome + "\tR$" + valor);
	}
}

package projetoJava.Itens;

public class ItemLojista extends Item{

	public int id;
	public ItemLojista(int id, String nome, float valor) {
		super(nome, valor);
		this.id = id;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void ver(int id, String nome, float valor) {
		System.out.println(id + "\t" + nome + "\tR$" + valor);
	}
	

}

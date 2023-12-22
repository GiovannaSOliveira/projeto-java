package projetoJava.Repository;

import projetoJava.Itens.Item;

public interface Repositorio {

	
	//CRUD
	
		public Item procurarPorId(int id);
		public void listarTodas();
		public void adicionar (Item item);
		public void atualizar (Item item);
		public void deletar (Item item);
		
		
}

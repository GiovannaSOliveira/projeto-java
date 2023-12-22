package projetoJava.Repository;

import projetoJava.Itens.ItemLojista;

public interface Repositorio {

	
	//CRUD
	
		public ItemLojista procurarPorId(int id);
		public void listarTodas();
		public void adicionar (ItemLojista item);
		public void atualizar (ItemLojista item);
		public void deletar (ItemLojista item);
		
		
}

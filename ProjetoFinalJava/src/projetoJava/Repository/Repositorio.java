package projetoJava.Repository;

import projetoJava.Itens.ItemCliente;
import projetoJava.Itens.ItemLojista;

public interface Repositorio {

	
	//CRUD
	
		public ItemLojista procurarPorId(int id);
		public void listarTodas();
		public void adicionar (ItemLojista item);
		public void atualizar (ItemLojista item);
		public void deletar (ItemLojista item);
		
		
		public ItemCliente procurarId(int id);
		public void listarCarrinho();
		public void adicionar (int id, int quantidade);
		public void atualizar (ItemCliente item);
		public void deletar (ItemCliente item);
}

package projetoJava.Estoque;

import java.util.ArrayList;

import projetoJava.Itens.ItemLojista;
import projetoJava.Repository.Repositorio;

public class Controle implements Repositorio {
	
	private ArrayList<ItemLojista> estoque = new ArrayList<ItemLojista>();
	
	@Override
	public ItemLojista procurarPorId (int id) {
		for (ItemLojista item : estoque) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}
	

	@Override
	public void listarTodas() {
		for (ItemLojista item: estoque) {
			item.ver(item.getId(), item.getNome(), item.getValor());
		}
		
	}

	@Override
	public void adicionar(ItemLojista item) {
		estoque.add(item);
		System.out.println("Item adicionado com sucesso.");
	}

	
	@Override
	public void atualizar(ItemLojista item) {
		ItemLojista itemFound = procurarPorId(item.getId());
		if (itemFound != null) {
			itemFound.setNome(item.getNome());
			itemFound.setValor(item.getValor());
			System.out.println("\nItemLojista atualizado.");
		}
		else {
			System.out.println("\nItemLojista não encontrado.");
		}
	}
	

	@Override
	public void deletar(ItemLojista item) {
		ItemLojista itemFound = procurarPorId(item.getId());
		if (itemFound != null) {
			estoque.remove(itemFound);
			System.out.println("\nItemLojista removido.");
		}
		else {
			System.out.println("\nItemLojista não encontrado.");
		}
		
	}

	
}

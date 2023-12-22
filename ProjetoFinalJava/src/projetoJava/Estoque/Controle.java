package projetoJava.Estoque;

import java.util.ArrayList;

import projetoJava.Itens.Item;
import projetoJava.Repository.Repositorio;

public class Controle implements Repositorio {
	
	private ArrayList<Item> estoque = new ArrayList<Item>();
	
	@Override
	public Item procurarPorId (int id) {
		for (Item item : estoque) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}
	

	@Override
	public void listarTodas() {
		for (Item item: estoque) {
			item.ver();
		}
		
	}

	@Override
	public void adicionar(Item item) {
		estoque.add(item);
		System.out.println("Item adicionado com sucesso.");
	}

	
	@Override
	public void atualizar(Item item) {
		Item itemFound = procurarPorId(item.getId());
		if (itemFound != null) {
			itemFound.setNome(item.getNome());
			itemFound.setValor(item.getValor());
			System.out.println("\nItem atualizado.");
		}
		else {
			System.out.println("\nItem não encontrado.");
		}
	}
	

	@Override
	public void deletar(Item item) {
		Item itemFound = procurarPorId(item.getId());
		if (itemFound != null) {
			estoque.remove(itemFound);
			System.out.println("\nItem removido.");
		}
		else {
			System.out.println("\nItem não encontrado.");
		}
		
	}
	
}

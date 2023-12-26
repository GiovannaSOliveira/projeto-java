package projetoJava.Estoque;

import java.util.ArrayList;
import projetoJava.Itens.ItemCliente;
import projetoJava.Itens.ItemLojista;
import projetoJava.Repository.Repositorio;

public class Controle implements Repositorio {
	
	private ArrayList<ItemLojista> estoque = new ArrayList<ItemLojista>();
	private ArrayList <ItemCliente> carrinho = new ArrayList <ItemCliente>();
	
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
			System.out.println("\nItem atualizado.");
		}
		else {
			System.out.println("\nItem não encontrado.");
		}
	}
	

	@Override
	public void deletar(ItemLojista item) {
		ItemLojista itemFound = procurarPorId(item.getId());
		if (itemFound != null) {
			estoque.remove(itemFound);
			System.out.println("\nItem removido.");
		}
		else {
			System.out.println("\nItem não encontrado.");
		}
		
	}
	
	

	
	@Override
	public ItemCliente procurarId (int id) {
		for (ItemCliente compra : carrinho) {
			if (compra.getId() == id) {
				return compra;
			}
		}
		return null;
	}
	
	@Override
	public void listarCarrinho() {
		for (ItemCliente compra: carrinho) {
			compra.verc(compra.getQuantidade(), compra.getId(),  compra.getNome(), compra.getValor());
		}
		
	}

	
	@Override
	public void adicionar(int quantidade, int id) {
		ItemLojista itemAchado = procurarPorId(id);
		if (itemAchado != null) {
			ItemCliente compra = new ItemCliente (quantidade, itemAchado.getId(),  
					 itemAchado.getNome(), itemAchado.getValor());
			carrinho.add(compra);
			System.out.println("\nItem adicionado ao carrinho.");
		}
		else {
			System.out.println("\nItem fora de estoque.");
		}
	}


	@Override
	public void atualizar(ItemCliente item) {
		ItemCliente itemFound = procurarId(item.getId());
		if (itemFound != null) {
			System.out.println("\nCompra atualizada.");
		}
		else {
			System.out.println("\nItem não encontrado.");
		}
		
	}


	@Override
	public void deletar(ItemCliente item) {
		ItemCliente itemFound = procurarId(item.getId());
		if (itemFound != null) {
			carrinho.remove(itemFound);
			System.out.println("\nItem removido do carrinho.");
		}
		else {
			System.out.println("\nItem não encontrado.");
		}
	}

	
	public float valorFinal() {
		float valorTotal = 0;
		for (ItemCliente compra : carrinho) {
			valorTotal += compra.getValor() * compra.getQuantidade();
		}
		
		return valorTotal;
	}


}

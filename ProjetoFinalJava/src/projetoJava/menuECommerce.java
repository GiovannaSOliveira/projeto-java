package projetoJava;

import java.util.Scanner;

public class menuECommerce {

	public static void main(String[] args) {
		
		/*
		 * menu: inserir um item, remover um item, alterar um item, ver estoque
		 * possivel cliente: adicionar ao carrinho, remover do carrinho, alterar item do carrinho
		 * ver carrinho, checkout.
		 */
		Scanner leia = new Scanner (System.in);
		int opcm, opcv, opcc;
		
		System.out.println("Escolha uma opção:");
		System.out.println("\n1- Vendedor");
		System.out.println("2- Cliente");
		opcm = leia.nextInt();
		
		
		switch(opcm) {
		case 1:
			
			do {
			System.out.println("\n*************************");
			System.out.println("\n\t  Menu");
			System.out.println("\n*************************");
			System.out.println("\n1 - Inserir um item.");
			System.out.println("\n2 - Ver estoque.");
			System.out.println("\n3 - Alterar um item.");
			System.out.println("\n4 - Remover um item.");
			System.out.println("\n0 - Sair");
			System.out.println("\n*************************");
			opcv = leia.nextInt();
			
			
			switch (opcv) {
			case 1:
				System.out.println("INSERIR UM ITEM");
				
				break;
				
			case 2:
				System.out.println("VER ESTOQUE");
				
				break;
				
			case 3:
				System.out.println("ALTERAR ITEM");
				
				break;
				
			case 4:
				System.out.println("REMOVER ITEM");
				
				break;
				
			case 0:
				System.out.println("\nCompra concluída com sucesso! \nObrigada por comprar conosco!");
				
				break;
				
			default:
				System.out.println("Escolha uma opção válida!");
				}
			
			}
			while (opcv !=0);
			break;
			
			
		
		case 2:
			System.out.println("\n********************************");
			System.out.println("\n\t  Carrinho");
			System.out.println("\n********************************");
			System.out.println("\n1 - Adicionar item ao carrinho.");
			System.out.println("\n2 - Ver carrinho.");
			System.out.println("\n3 - Alterar item no carrinho.");
			System.out.println("\n4 - Remover item do carrinho.");
			System.out.println("\n0 - Checkout.");
			System.out.println("\n********************************");
			break;
		default: 
			System.out.println("Escolha uma opção válida!");
		}
		
		
	
		
		
		
		
	leia.close();	
	}

}

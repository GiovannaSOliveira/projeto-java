package projetoJava;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import projetoJava.Estoque.*;

import projetoJava.Itens.*;


public class menuECommerce{

	public static void main(String[] args) {
		
		Controle controle = new Controle();
		
		Scanner leia = new Scanner (System.in);
		int opc, id;
		String nome;
		float valor;
		
		try {
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
			opc = leia.nextInt();
			
			
			leia.skip("\\R?");			
			
			switch (opc) {
			case 1:
				System.out.println("INSERIR UM ITEM");
				System.out.println("\nDigite a id do item:");
				id = leia.nextInt();
				leia.skip("\\R?");
				
				System.out.println("\nDigite  o nome do item:");
				nome = leia.nextLine();
				
				
				System.out.println("\nDigite o preço do item:");
				leia.skip("\\R?");
				valor = leia.nextFloat();
				
				controle.adicionar(new ItemLojista (id, nome, valor));
				
				keyPress();
				
				break;
				
			case 2:
				System.out.println("VER ESTOQUE");
				System.out.println("\nId   Nome   Preço");
				controle.listarTodas();
				
				break;
				
			case 3:
				System.out.println("ALTERAR ITEM");
				System.out.println("\nDigite o id do item:");
				id = leia.nextInt();
		        leia.skip("\\R?");

		        ItemLojista itemEncontrado = controle.procurarPorId(id);
		       
		        if (itemEncontrado != null) {
		            System.out.println("\nDigite o novo nome do item:");
		            nome = leia.nextLine();
		            

		            System.out.println("\nDigite o novo valor do item:");
		            leia.skip("\\R?");
		            valor = leia.nextFloat();
		            leia.skip("\\R?");

		            controle.atualizar(itemEncontrado);
		            System.out.println("\nItem atualizado com sucesso.");
		        } else {
		            System.out.println("\nItem não encontrado.");
		        }
				
		        keyPress();
				
				break;
				
			case 4:
				System.out.println("REMOVER ITEM");
				System.out.println("\nDigite o id do item:");
				id = leia.nextInt();
		        leia.skip("\\R?");

		        itemEncontrado = controle.procurarPorId(id);
		        
		        if (itemEncontrado != null) {
		        	controle.deletar(itemEncontrado);
		        }
		        else {
		        	System.out.println("\nItem não encontrado.");
		        }
		        
		        keyPress();
				
				break;
				
			case 0:
				System.out.println("\nPrograma finalizado.");
				sobre();
				leia.close();
				System.exit(0);
				
				break;
				
			default:
				System.out.println("Escolha uma opção válida!");
				}
			
			}
			while (opc !=0);
		}
		catch(InputMismatchException erro) {
			System.err.println("\nFormato inválido!");
			leia.nextLine();
		}
		catch (NumberFormatException erro) {
			System.err.println("\nFormato inválido!");
			leia.nextLine();
		}
			
			
			
		
		
	leia.close();	
	}

	public static void sobre() {
		System.out.println("*******************************************");
		System.out.println("\nProjeto desenvolvido por: ");
		System.out.println("Giovanna Oliveira - giovannasoliveira58@gmail.com");
		System.out.println("https://github.com/GiovannaSOliveira\n");
		System.out.println("*******************************************");
	}
	
	public static void keyPress() {
		try {
			System.out.println("\n\nPressione ENTER para continuar...");
			System.in.read();
		}
		catch(IOException erro) {
			System.err.println("Tecla inválida.");
		}
	}
	
}


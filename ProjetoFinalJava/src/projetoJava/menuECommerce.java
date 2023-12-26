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
		int opcid, opcv, opcc, id, quantidade;
		String nome;
		float valor;
		
		
		try {
			do {
		System.out.println("\n\nVocê é cliente ou vendedor?");
		System.out.println("\n1 - Cliente");
		System.out.println("\n2 - Vendedor");
		System.out.println("\n0 - Sair");
		opcid = leia.nextInt();
		leia.nextLine();
		
		
		switch (opcid) {
		
		case 1:
			do {
			System.out.println("\n*******************************");
			System.out.println("\n\t     MENU");
			System.out.println("\n*******************************");
			System.out.println("\n1 - Adicionar item ao carrinho.");
			System.out.println("\n2 - Ver carrinho.");
			System.out.println("\n3 - Editar carrinho.");
			System.out.println("\n4 - Remover item do carrinho.");
			System.out.println("\n5 - Checkout.");
			System.out.println("\n0 - Sair");
			System.out.println("\n*******************************");
			opcc = leia.nextInt();
			
			switch (opcc) {
				case 1:
					System.out.println("\nADICIONAR AO CARRINHO");
					System.out.println("\nId   Nome   Preço");
					controle.listarTodas();
					System.out.println("\nDigite a id do item:");
					id = leia.nextInt();
					leia.skip("\\R?");
					
					System.out.println("\nDigite a quantidade:");
					quantidade = leia.nextInt();
					leia.skip("\\R?");
					
					controle.adicionar(quantidade, id);
					
					keyPress();
					
					break;
					
				case 2:
					System.out.println("\nVER CARRINHO");
					System.out.println("\nQuantidade\tId\tNome\tPreço");
					controle.listarCarrinho();
					keyPress();
					break;
					
				case 3:
					System.out.println("\nEDITAR CARRINHO");
					System.out.println("\nQuantidade\tId\tNome\tPreço");
					controle.listarCarrinho();
					System.out.println("\nDigite o id do item:");
					id = leia.nextInt();
			        leia.skip("\\R?");

			        ItemCliente itemAchado = controle.procurarId(id);
			       
			        if (itemAchado != null) {
			        	controle.deletar(itemAchado);
			        	System.out.println("\nEscolha um novo item");
			        	System.out.println("\nId   Nome   Preço");
						controle.listarTodas();
						
						System.out.println("\nDigite a id do novo item");
						id = leia.nextInt();
				        leia.skip("\\R?");
				        
				        
				        ItemLojista itemEncontrado = controle.procurarPorId(id);
			        	
					        if (itemEncontrado != null) {
					        	System.out.println("\nDigite a quantidade desejada:");
					        	quantidade=leia.nextInt();
					        	leia.skip("\\R?");
					        	
					        	controle.adicionar(quantidade, id);
					        	}
					        else {
					        	System.out.println("\nItem inválido.");
					        }
			        	
			            System.out.println("\nItem atualizado com sucesso.");
			        } else {
			            System.out.println("\nItem não encontrado.");
			        }
					
			        keyPress();
					break;
		
				case 4:
					System.out.println("\nREMOVER ITEM DO CARRINHO");
					System.out.println("\nQuantidade\tId\tNome\tPreço");
					controle.listarCarrinho();
					System.out.println("\nDigite a id do item a ser removido:");
					id=leia.nextInt();
					
					ItemCliente itemDeletar = controle.procurarId(id);
						if (itemDeletar != null) {
							controle.deletar(itemDeletar);
						}
						
						else {
							System.out.println("Item não encontrado.");
						}
					
					keyPress();
					break;
	
				case 5:
					System.out.println("\nCHECKOUT");
					System.out.println("\nSeu carrinho atual:");
					System.out.println("\nQuantidade\tId\tNome\tPreço");
					controle.listarCarrinho();
					System.out.println("\n\tValor total:  R$" + controle.valorFinal());
					
					System.out.println("\nObrigada por comprar conosco!");
					opcid = 0;
					keyPress();
					break;
		
				case 0:
					System.out.println("\nCompras finalizadas.");
					keyPress();
					break;
					
				default:
					
			} 
			}
			while (opcc!= 0);	
			break;
			
			
//----------------------------------------------------------------------------------------------------------		
		case 2:
			do {
				System.out.println("\n*************************");
				System.out.println("\n\t  MENU");
				System.out.println("\n*************************");
				System.out.println("\n1 - Inserir um item.");
				System.out.println("\n2 - Ver estoque.");
				System.out.println("\n3 - Alterar um item.");
				System.out.println("\n4 - Remover um item.");
				System.out.println("\n0 - Sair");
				System.out.println("\n*************************");
				opcv = leia.nextInt();
				
				
				leia.skip("\\R?");			
				
				switch (opcv) {
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

			            itemEncontrado.setNome(nome);
			            itemEncontrado.setValor(valor);
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
					System.out.println("\nEstoque finalizado.");
					keyPress();
					break;
					
				default:
					System.out.println("Escolha uma opção válida!");
					}
				
				}
				while (opcv !=0);
			
			break;
			
		case 0:
			System.out.println("\nPrograma finalizado.");
			sobre();
			leia.close();
			System.exit(0);
			
			break;
		
		
		}
		
			}
			while(opcid!=0);
		
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


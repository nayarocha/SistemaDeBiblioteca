package br.ifrn.tads.poo.biblioteca.app;

public  class  Menu  {
	
	public static void menuPrincipal(){
		System.out.println("------------------SISTEMA DE BIBLIOTECA-----------------------");
		System.out.println("                   [1] - CADASTRAR NOVO USU�RIO               ");
		System.out.println("                   [2] - LISTAR USU�RIOS CADASTRADOS"          );
		System.out.println("                                                  "            );
		System.out.println("                   [3] - CADASTRAR ITEM NO SISTEMA"            );
		System.out.println("                   [4] - LISTAR ITENS CADASTRADOS NO SISTEMA"  );
		System.out.println("                                                  "            );
		System.out.println("                   [5] - ALUGAR ITEM"                          );
		System.out.println("                   [6] - LISTAR ITENS ALUGADOS"                );
		System.out.println("                                                  "            );
		System.out.println("                   [7] - RESERVAR ITEM"                        );
		System.out.println("                   [8] - LISTAR ITENS RESERVADOS"              );
		System.out.println("                   [9] - DEVOLVER ITEM "                       );
		System.out.println("                   [10] - ALUGAR ITEM RESERVADO "              );
		System.out.println("                                                  "            );
		System.out.println("                   [11] -REMOVER USUARIO DO SISTEMA "          );
		System.out.println("-------------------------------------------------------------" );
		
	}
	
	public static void menuItensAcervo(){
		System.out.println("--------CADASTRAR ITEM NO SISTEMA--------");
		System.out.println("[1] - LIVRO ");
		System.out.println("[2] - APOSTILA");
		System.out.println("[3] - TEXTO");
	}
}

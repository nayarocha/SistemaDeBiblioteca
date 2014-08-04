package br.ifrn.tads.poo.biblioteca.app;

public  class  Menu  {
	
	public static void menuPrincipal(){
		System.out.println("----------SISTEMA DE BIBLIOTECA----------");
		System.out.println("[1] - CADASTRAR USUARIO");
		System.out.println("[2] -LISTAR USUÁRIOS CADASTRADOS");
		System.out.println("[3] -CADASTRAR ITEM NO SISTEMA");
		System.out.println("[4] -LISTAR ITENS CADASTRADOS NO SISTEMA");
		System.out.println("-----------------------------------------");
		System.out.println("[5] -ESCOLHER ITEM PARA ALUGAR");
	}
	
	public static void menuItensAcervo(){
		System.out.println("--------CADASTRAR ITEM NO SISTEMA--------");
		System.out.println("[1] - LIVRO ");
		System.out.println("[2] - APOSTILA");
		System.out.println("[3] - TEXTO");
	}
}

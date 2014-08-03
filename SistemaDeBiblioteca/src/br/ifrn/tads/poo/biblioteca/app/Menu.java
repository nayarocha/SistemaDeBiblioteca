package br.ifrn.tads.poo.biblioteca.app;

public  class  Menu  {
	
	public static void menuPrincipal(){
		System.out.println("----------SISTEMA DE BIBLIOTECA----------");
		System.out.println("[1] - CADASTRAR USUARIO");
		System.out.println("[2] - LISTAR USUÁRIOS CADASTRADOS");
		System.out.println("[3] - CADASTRAR ITEN DE ACERVO");
	}
	
	public static void menuItensAcervo(){
		System.out.println("--------ITEN A CADASTRAR--------");
		System.out.println("[1] - LIVRO ");
		System.out.println("[2] - APOSTILA");
		System.out.println("[3] - TEXTO");
	}
}

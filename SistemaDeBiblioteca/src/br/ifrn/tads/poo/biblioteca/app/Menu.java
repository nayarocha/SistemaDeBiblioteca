package br.ifrn.tads.poo.biblioteca.app;

public  class  Menu  {
	
	public static void menuPrincipal(){
		System.out.println("----------SISTEMA DE BIBLIOTECA----------");
		System.out.println("[1] - CADASTRAR NOVO USUÁRIO");
		System.out.println("[2] - LISTAR USUÁRIOS CADASTRADOS");
		System.out.println("[3] - CADASTRAR ITEM NO SISTEMA");
		System.out.println("[4] - LISTAR ITENS CADASTRADOS NO SISTEMA");
		System.out.println("[5] - ALUGAR ITEM");
		System.out.println("[6] - LISTAR ITENS ALUGADOS");
		System.out.println("[7] - RESERVAR ITEM");
		System.out.println("[8] - LISTAR ITENS RESERVADOS");
		System.out.println("-----------------------------------------");
	}
	
	public static void menuItensAcervo(){
		System.out.println("--------CADASTRAR ITEM NO SISTEMA--------");
		System.out.println("[1] - LIVRO ");
		System.out.println("[2] - APOSTILA");
		System.out.println("[3] - TEXTO");
	}

	public static void aluguel() {
		System.out.println("--------ALUGUEL DE ITENS--------");
		System.out.println("[1] - ALUGUEL DIRETO ");
		System.out.println("[2] - ALUGUEL POR RESERVA");
	}
}

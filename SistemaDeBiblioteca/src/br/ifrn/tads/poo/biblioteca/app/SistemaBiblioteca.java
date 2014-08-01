package br.ifrn.tads.poo.biblioteca.app;

import java.util.Scanner;

import br.ifrn.tads.poo.biblioteca.Biblioteca;
import br.ifrn.tads.poo.biblioteca.acervo.Livro;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;
	


public class SistemaBiblioteca {
	static Biblioteca biblioteca = new Biblioteca();
	public static void addUsuario(){
		//ler código 
		System.out.println("CÓDIGO");
		Scanner cod1 = new Scanner(System.in);
		int cod = cod1.nextInt();
		//ler nome
		System.out.println("NOME COMPLETO: ");
		Scanner nome1 = new Scanner(System.in);
		String nome = nome1.nextLine();
		//ler endereco 
		System.out.println("ENDEREÇO:");
		Scanner endereco1 = new Scanner(System.in);
		String endereco = endereco1.nextLine();
		//ler cpf
		System.out.println("CPF:  ");
		Scanner cpf1 = new Scanner(System.in);
		String cpf = cpf1.nextLine();
		//cria um novo usuário
		Usuario novoUsuario = new Usuario( cod, nome, endereco,cpf);
		//Insere o novo usuario no arraylist
		biblioteca.cadastraUsuario(novoUsuario);
	}
	
	public static void main(String[] args) {
		
		Menu menu = new Menu();
		
		menu.menuPrincipal();
		
		int fim = -1;
		do{
			int opcao = 0;
			Scanner lerOpcao = new Scanner(System.in);
			opcao = lerOpcao.nextInt();
			switch(opcao){
			
			//Cadastrar usuario
			case 1:
				addUsuario();
				menu.menuPrincipal();
			break;
			
			
			}
			fim = 0;
			
		}while(fim != 0);
		

		
		
		
		/*usuario maria
		Usuario maria = new Usuario();
		maria.setCodUsuario(01);
		maria.setCpf("088.234.100-01");
		maria.setEndereco("rua bla bla bla");
		maria.setNome("Maria");
		
		biblioteca.cadastraUsuario(maria);
		
		//usuario jose
		Usuario jose = new Usuario();
		jose.setCodUsuario(02);
		jose.setCpf("088.234.100-00");
		jose.setEndereco("rua bla bla bla");
		jose.setNome("Jose");
		
		
		//cadastro jose
		biblioteca.cadastraUsuario(jose);
		biblioteca.quantUsuarios();*/
		//-----------------------------------------------------------------------------------------------------------//
		
		/*Livro pequenoprincipe = new Livro("Pequeno principe", "Antoine", "374837", 2, 30.50);
		biblioteca.cadastraItens(pequenoprincipe);*/
		
		//System.out.println("CODIGO -" +maria.getCodUsuario() + "NOME -" + maria.getNome()+ "CPF -"+ maria.getCpf());	
		//System.out.println("CODIGO -" +jose.getCodUsuario() + "NOME -" + jose.getNome()+ "CPF -"+ jose.getCpf());
		//System.out.println("ISBN" + pequenoprincipe.getIsbn() + "CUSTO: " +pequenoprincipe.getCusto());*/
	
		
	}
}

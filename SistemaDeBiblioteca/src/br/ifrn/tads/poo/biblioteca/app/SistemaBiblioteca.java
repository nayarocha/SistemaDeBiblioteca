package br.ifrn.tads.poo.biblioteca.app;

import java.util.Random;
import java.util.Scanner;

import br.ifrn.tads.poo.biblioteca.Biblioteca;
import br.ifrn.tads.poo.biblioteca.acervo.Livro;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;
	


public class SistemaBiblioteca {
	//criando biblioteca
	static Biblioteca biblioteca = new Biblioteca();
	private static Scanner nome1;
	private static Scanner endereco1;
	private static Scanner cpf1;
	
	//Cadastrar usuários
	public static void addUsuario(){	
		//ler nome
		System.out.println("NOME COMPLETO: ");
		nome1 = new Scanner(System.in);
		String nome = nome1.nextLine();	
		//ler endereco 
		System.out.println("ENDEREÇO:");
		endereco1 = new Scanner(System.in);
		String endereco = endereco1.nextLine();
		//ler cpf
		System.out.println("CPF:  ");	
		cpf1 = new Scanner(System.in);
		String cpf = cpf1.nextLine();
		//Gerador de código automático para cada novo usuário
		Random geraCod = new Random();		
		int codUsuario = geraCod.nextInt(1000)*2; 	
		
		//cria um novo usuário
		Usuario novoUsuario = new Usuario(codUsuario,nome, endereco,cpf);
		//Insere o novo usuario no arraylist
		biblioteca.cadastraUsuario(novoUsuario);
		
		System.out.println("COdigo gerado para usuario: " + novoUsuario.getCodUsuario()); // testando código automático
	}
	
	public static void main(String[] args) {
		
		Menu menu = new Menu();
		Scanner lerOpcao = new Scanner(System.in);
		int opcao;
		int fim = -1;
		
		do{
			menu.menuPrincipal();
			opcao = lerOpcao.nextInt();
			switch(opcao){
			
			//Cadastrar usuario
			case 1:
				addUsuario();
				
			break;
			
			//listar usuários cadastrados
			case 2:
				biblioteca.listaUsuarios();
			break;
			
			
			}
			
			
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

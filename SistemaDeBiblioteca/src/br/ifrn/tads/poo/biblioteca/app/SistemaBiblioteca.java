package br.ifrn.tads.poo.biblioteca.app;

import java.util.Random;
import java.util.Scanner;

import br.ifrn.tads.poo.biblioteca.Biblioteca;
import br.ifrn.tads.poo.biblioteca.acervo.Apostila;
import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
import br.ifrn.tads.poo.biblioteca.acervo.Livro;
import br.ifrn.tads.poo.biblioteca.acervo.Texto;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;

public class SistemaBiblioteca {
	//criando biblioteca
	static Biblioteca biblioteca = new Biblioteca();
	
	
		private static Scanner nome1;
		private static Scanner endereco1;
		private static Scanner cpf1;
		private static Scanner cod1;
		
		//CADASTRAR USUARIOS
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
		
		//ADICIONAR LIVRO NO ACERVO
		public static void addItemLivro(){
			System.out.println("||Cadastrando livro no sistema||");
			
			 System.out.println("Código");
			 cod1 = new Scanner(System.in);
			 int cod = cod1.nextInt();
			
			System.out.println("Título");
			 Scanner title1 = new Scanner(System.in);
			 String title = title1.nextLine();
			
			 System.out.println("Autor:");
			 Scanner autor1 = new Scanner(System.in);
			 String autor = autor1.nextLine();
			
			 System.out.println("ISBN:");
			 Scanner isbn1 = new Scanner(System.in);
			String isbn = isbn1.nextLine();
			
			 System.out.println("Edição:");
			 Scanner edicao1 = new Scanner(System.in);
			 int edicao = edicao1.nextInt();
			
			 //Cria um novo item no acervo
			 ItemAcervo livro = new Livro(title,autor,isbn,edicao); 
			
			 //Insere novo item no arraylist
			 biblioteca.cadastraItem(livro);
		}
		
		//ADICIONAR LIVRO NO ACERVO
		public static void addItemApostila(){
			System.out.println("||Cadastrando apostila no sistema||");
						
			System.out.println("TÍTULO");
			Scanner a = new Scanner(System.in);
			String title = a.nextLine();				
			
			System.out.println("AUTOR");
			Scanner b = new Scanner(System.in);
			String autor = b.nextLine();
						
			//Cria um novo item no acervo
			ItemAcervo apostila = new Apostila(title,autor); 
						
			//Insere novo item no arraylist
			biblioteca.cadastraItem(apostila);
		}
		
		//ADICIONAR TEXTO NO ACERVO
		public static void addItemTexto(){
			System.out.println("||Cadastrando TEXTO no sistema||");
																
			System.out.println("AUTOR");
			Scanner b = new Scanner(System.in);
			String autor = b.nextLine();
									
			//Cria um novo item no acervo
			ItemAcervo texto = new Texto(autor); 
									
			//Insere novo item no arraylist
			biblioteca.cadastraItem(texto);
		}
			
	public static void main(String[] args) {
			
		Scanner lerOpcao = new Scanner(System.in);
		int opcao;
		int fim = -1;
		
		do{
			Menu.menuPrincipal();
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
			
			//Cadastrar iten
			case 3:
				addItenAcervo();
			break;
			
			case 4:
				biblioteca.listaItemAcervo();
			break;
			
			}
			
			
		}while(fim != 0);
			
	}

	private static void addItenAcervo() {
		Scanner lerOpcao2 = new Scanner(System.in);
		int opcao2;
		//int fim2 = -1;
		
		//do{
			Menu.menuItensAcervo();
			
			opcao2 = lerOpcao2.nextInt();
			switch(opcao2){
			
			//LIVRO
			case 1:
				addItemLivro();			
			break;
			
			//APOSTILA
			case 2:
				addItemApostila();
			break;
			
			//TEXTO
			case 3:
				addItemTexto();
			break;
			}
			
			
		//}while(fim2 != 0);
	}			
}




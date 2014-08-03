package br.ifrn.tads.poo.biblioteca.app;

import java.util.Random;
import java.util.Scanner;

import br.ifrn.tads.poo.biblioteca.Biblioteca;
import br.ifrn.tads.poo.biblioteca.acervo.Livro;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;

public class SistemaBiblioteca {
	//criando biblioteca
	static Biblioteca biblioteca = new Biblioteca();
	
	
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
			
			//listar usu�rios cadastrados
			case 2:
				biblioteca.listaUsuarios();
			break;
			
			//Cadastrar iten
			case 3:
				addItenAcervo();
			break;
			}
			
			
		}while(fim != 0);
			
	}

	private static void addItenAcervo() {
		Scanner lerOpcao2 = new Scanner(System.in);
		int opcao2;
		int fim2 = -1;
		
		do{
			Menu.menuItensAcervo();
			opcao2 = lerOpcao2.nextInt();
			switch(opcao2){
			
			//LIVRO
			case 1:
//				ADICIONAR LIVRO
			break;
			
//			APOSTILA
			case 2:
//				ADICIONAR APOSTILA
			break;
			
			//TEXTO
			case 3:
//				ADICIONAR TEXTO
			break;
			}
			
			
		}while(fim2 != 0);
	}

		//Cadastrar usu�rios
		private static Scanner nome1;
		private static Scanner endereco1;
		private static Scanner cpf1;
		
		public static void addUsuario(){	
			
			//ler nome
			System.out.println("NOME COMPLETO: ");
			nome1 = new Scanner(System.in);
			String nome = nome1.nextLine();	
			//ler endereco 
			System.out.println("ENDERE�O:");
			endereco1 = new Scanner(System.in);
			String endereco = endereco1.nextLine();
			//ler cpf
			System.out.println("CPF:  ");	
			cpf1 = new Scanner(System.in);
			String cpf = cpf1.nextLine();
			//Gerador de c�digo autom�tico para cada novo usu�rio
			Random geraCod = new Random();		
			int codUsuario = geraCod.nextInt(1000)*2; 	
			
			//cria um novo usu�rio
			Usuario novoUsuario = new Usuario(codUsuario,nome, endereco,cpf);
			//Insere o novo usuario no arraylist
			biblioteca.cadastraUsuario(novoUsuario);
			
			System.out.println("COdigo gerado para usuario: " + novoUsuario.getCodUsuario()); // testando c�digo autom�tico
		}
		
		
}


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


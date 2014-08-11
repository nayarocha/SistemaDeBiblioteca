package br.ifrn.tads.poo.biblioteca.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import br.ifrn.tads.poo.biblioteca.Biblioteca;
import br.ifrn.tads.poo.biblioteca.CodigoInvalidoException;
import br.ifrn.tads.poo.biblioteca.Locacao;
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
	private static Usuario novoUsuario;
	private static int escolha;
	static File file = new File("registro_bliblioteca.txt");
	
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
		novoUsuario = new Usuario(codUsuario,nome, endereco,cpf);
		//Insere o novo usuario no arraylist
		biblioteca.cadastraUsuario(novoUsuario);

		System.out.println("COdigo gerado para usuario: " + novoUsuario.getCodUsuario()); // testando código automático
		salvarArquivo("Novo usuario cadastrado		", novoUsuario.toString());
		
	}
	
	public static void addUsuariosDoArquivo(){
		File arquivo = new File("arquivo_usuarios.txt");
		try (FileReader freader = new FileReader(arquivo)){
			BufferedReader br = new BufferedReader(freader);
				//equanto houver mais linhas
			while( br.ready() ){
				//lê a proxima linha
				String nome = br.readLine();
				String endereco = br.readLine();
				String cpf = br.readLine();
				
				
				Random geraCod = new Random();		
				int codUsuario = geraCod.nextInt(1000)*2; 	
	
				//cria um novo usuário
				novoUsuario = new Usuario(codUsuario,nome, endereco,cpf);
				//Insere o novo usuario no arraylist
				biblioteca.cadastraUsuario(novoUsuario);
				System.out.println("COdigo gerado para usuario: " + novoUsuario.getCodUsuario()); // testando código automático
				salvarArquivo("Novo usuario cadastrado		", novoUsuario.toString());
			
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
				
	}
	
	private static void addItenAcervo() {
		Scanner lerOpcao2 = new Scanner(System.in);
		int opcao2;

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


		
	}			

	//ADICIONAR LIVRO NO ACERVO
	public static void addItemLivro(){
		System.out.println("||Cadastrando livro no sistema||");
		File arquivo = new File("arquivo_livros.txt");
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
		
		salvarArquivo("Novo livro cadastrado	", livro.toString());
	}

	//ADICIONAR APOSTILA NO ACERVO
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
		
		salvarArquivo("Nova apostila cadastrada		", apostila.toString());
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
		
		//atualizar arquivo acervo
		salvarArquivo("Novo texto adicionado ao acervo	", texto.toString());
	}
	
	public static void criarAcervo(){
		File arquivo = new File("arquivo_livros.txt");
		try (FileReader freader = new FileReader(arquivo)){
			BufferedReader br = new BufferedReader(freader);
				//equanto houver mais linhas
			while( br.ready() ){
				//lê a proxima linha
				String title = br.readLine();
				String autor = br.readLine();
				String isbn = br.readLine();
				String edicao1 = br.readLine();
				//Integer.parseInt(); 
				int edicao = Integer.parseInt(edicao1); 
				
				ItemAcervo livro = new Livro(title,autor,isbn,edicao); 

				//Insere novo item no arraylist
				biblioteca.cadastraItem(livro);				
				
				salvarArquivo("Novo livro cadastrado	", livro.toString());
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void salvarArquivo(String mensagem, String atualizacao) {
		try {	
//			 o true adiciona o q se vai escrever no final do arquivo
			FileWriter atualizaArquivo = new FileWriter(file, true);
//			sem o true cira um novo arquivo e exclui o antigo
//			FileWriter atualizaArquivo = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(atualizaArquivo);
			atualizaArquivo.write(mensagem);
			atualizaArquivo.write(atualizacao);
			
			bw.newLine();
			bw.close();
			atualizaArquivo.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		addUsuariosDoArquivo();
		criarAcervo();
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

			case 5:
				/*	ItemAcervo escolhido = null;
				//while(escolhido == null){
				try{
					System.out.println("Insira o código do item");
					Scanner ler = new Scanner(System.in);
					escolha = ler.nextInt();
				
					escolhido = biblioteca.escolherItemAcervo(escolha);
				}catch(CodigoInvalidoException e){
					System.out.println(e.getMessage());
				}
				//	} */
				break;

			case 6:
				biblioteca.listaItemAcervo();
				
				System.out.println("Insira  cod do usuario");
				Scanner a = new Scanner(System.in);
				String codUser = a.nextLine();
				//int codUser = a.nextInt();
				
				Usuario usuario = null;
				
				//usuario = biblioteca.selecionaUsuario(codUser);
				usuario = biblioteca.selecionaUsuario(codUser);
				
				
				//COdigo do livro
				System.out.println("insira codigo do livro");
				Scanner cod = new Scanner(System.in);
				int codigo = cod.nextInt();
				
				ItemAcervo item = null;
				try {
					item = biblioteca.escolherItemAcervo(codigo);
				} catch (CodigoInvalidoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				Locacao locar = new Locacao(usuario, item);
				
				biblioteca.cadastraEmprestimo(locar);
				
				biblioteca.listaEmprestimos();
				
				break;

			}


		}while(fim != 0);

	}

}


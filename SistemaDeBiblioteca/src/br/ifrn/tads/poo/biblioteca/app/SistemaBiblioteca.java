package br.ifrn.tads.poo.biblioteca.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import br.ifrn.tads.poo.biblioteca.Biblioteca;
import br.ifrn.tads.poo.biblioteca.CodigoInvalidoException;
import br.ifrn.tads.poo.biblioteca.Locacao;
import br.ifrn.tads.poo.biblioteca.Reserva;
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
		novoUsuario = new Usuario(codUsuario, nome, endereco,cpf);
		//Insere o novo usuario no arraylist
		biblioteca.cadastraUsuario(novoUsuario);
		
		//salva no banco
		Arquivo.salvaNoBanco(nome, endereco,cpf);

		System.out.println("COdigo gerado para usuario: " + novoUsuario.getCodUsuario()); // testando código automático
		Arquivo.salvar("Novo usuario cadastrado		", novoUsuario.toString());
		
	}
	
	public static void addUsuariosDoArquivo(){
		File arquivo = new File("arquivo_usuarios.txt");
		try (FileReader freader = new FileReader(arquivo)){
			BufferedReader br = new BufferedReader(freader);
			String espaco = " ";
			espaco = br.readLine();
			
			//verifica se o arquivo esta vazio
			if(espaco != null){
			    //equanto houver mais linhas
				while( br.ready() ){
					//lê a proxima linha
					String nome = br.readLine();
					String endereco = br.readLine();
					String cpf = br.readLine();
					
					if(br.readLine() == Arquivo.linha ){
						Arquivo.linha = null;	
					}
					
					Random geraCod = new Random();		
					int codUsuario = geraCod.nextInt(1000)*2; 	
		
					//cria um novo usuário
					novoUsuario = new Usuario(codUsuario,nome, endereco,cpf);
					//Insere o novo usuario no arraylist
					biblioteca.cadastraUsuario(novoUsuario);
					Arquivo.salvar("Novo usuario cadastrado		", novoUsuario.toString());
				
				}
					
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
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
		
		//salva no banco
		Arquivo.salvaLivroNoBanco(title,autor,isbn,edicao);
		
		Arquivo.salvar("Novo livro cadastrado	", livro.toString());
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
		
		//salva no banco
		Arquivo.salvaApostilanoBanco(title,autor);
		
		Arquivo.salvar("Nova apostila cadastrada		", apostila.toString());
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
		
		//salvando no banco
		salvaTextoNoBanco(autor);
		
		//atualizar arquivo acervo
		Arquivo.salvar("Novo texto adicionado ao acervo	", texto.toString());
	}
	
	private static void salvaTextoNoBanco(String autor) {
		File bancoUsuarios = new File("arquivo_textos.txt");
		try {	
//			 o true adiciona o q se vai escrever no final do arquivo
			FileWriter atualizaArquivo = new FileWriter(bancoUsuarios, true);
			BufferedWriter escreve = new BufferedWriter(atualizaArquivo);
			escreve.newLine();
			escreve.write(autor);
			
			escreve.close();
			atualizaArquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
				
				Arquivo.salvar("Novo livro cadastrado	", livro.toString());
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private static void reservar() {
		//escolher usuario e item
		System.out.println("Insira  CPF do usuario");
		Scanner c = new Scanner(System.in);
		String cpfUser1 = c.nextLine();
		Usuario usuario2 = null;
		
		usuario2 = biblioteca.selecionaUsuario(cpfUser1);
		
		//COdigo do Item
		System.out.println("insira codigo do livro");
		Scanner codReserva = new Scanner(System.in);
		int codigoReserva = codReserva .nextInt();
		
		ItemAcervo itemReserva = null;
		try {
			itemReserva  = biblioteca.escolherItemAcervo(codigoReserva);
		} catch (CodigoInvalidoException e) {
			e.printStackTrace();
		}
		//efetivar reserva
		if(itemReserva != null){
			Reserva reservaItem = new Reserva(usuario2, itemReserva);
			biblioteca.cadastraReserva(reservaItem);
			Arquivo.salvar("", reservaItem.toString());
		}else{
			System.out.println("Impossivel reservar este item");
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
				
				System.out.println("Insira  CPF do usuario");
				Scanner a = new Scanner(System.in);
				String cpfUser = a.nextLine();
				//int codUser = a.nextInt();
				
				Usuario usuario = null;
				
				//usuario = biblioteca.selecionaUsuario(codUser);
				usuario = biblioteca.selecionaUsuario(cpfUser);
				
				//COdigo do livro
				System.out.println("insira codigo do livro");
				Scanner cod = new Scanner(System.in);
				int codigo = cod.nextInt();
				
				ItemAcervo item = null;
				try {
					item = biblioteca.escolherItemAcervo(codigo);
				} catch (CodigoInvalidoException e) {
					e.printStackTrace();
				}
				
				if(item != null){
					Date dataEmprestimo = biblioteca.dataEmprestimo();
					String dataDevolucao = biblioteca.dataDevolucao();
					Locacao locar = new Locacao(usuario, item, dataEmprestimo, dataDevolucao);
					biblioteca.cadastraEmprestimo(locar);
					System.out.println(locar.toString());
				}else{
					System.out.println("item alugado");
				}
				
				
				break;
				
			case 7:
				//RESERVAR ITEN
				biblioteca.listaItemAcervo();
				reservar();
				
				break;

			}


		}while(fim != 0);

	}

	
}


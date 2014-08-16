package br.ifrn.tads.poo.biblioteca.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		RegistrosBiblioteca.salvaNoBanco(nome, endereco,cpf);

		System.out.println("COdigo gerado para usuario: " + novoUsuario.getCodUsuario()); // testando código automático
		RegistrosBiblioteca.salvar("Novo usuario cadastrado		", novoUsuario.toString());		
	}
	
	//LER USUARIOS CADASTRADOS DO ARQUIVO
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
					
					if(br.readLine() == RegistrosBiblioteca.linha ){
						RegistrosBiblioteca.linha = null;	
					}
					
					Random geraCod = new Random();		
					int codUsuario = geraCod.nextInt(1000)*2; 	
		
					//cria um novo usuário
					novoUsuario = new Usuario(codUsuario,nome, endereco,cpf);
					//Insere o novo usuario no arraylist
					biblioteca.cadastraUsuario(novoUsuario);
					RegistrosBiblioteca.salvar("Novo usuario cadastrado		", novoUsuario.toString());			
				}					
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}				
	}
	
	//ADICIONA ITEM NO ACERVO (LIVRO - APOSTILA - TEXTO)
	private static void addItemAcervo() {
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
		RegistrosBiblioteca.salvaLivroNoBanco(title,autor,isbn,edicao);	
		RegistrosBiblioteca.salvar("Novo livro cadastrado	", livro.toString());
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
		
		//salva no arquivo_apostila.txt
		RegistrosBiblioteca.salvaApostilanoBanco(title,autor);	
		RegistrosBiblioteca.salvar("Nova apostila cadastrada		", apostila.toString());
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
		
		//Salva  no arquivo_textos.txt
		RegistrosBiblioteca.salvaTextoNoBanco(autor);
		
		//atualizar arquivo acervo
		RegistrosBiblioteca.salvar("Novo texto adicionado ao acervo	", texto.toString());
	}
		
	//CARREGA ACERVO DO SISTEMA
	public static void criarAcervo(){
		File arquivo = new File("arquivo_livros.txt");
		try (FileReader freader = new FileReader(arquivo)){
			BufferedReader br = new BufferedReader(freader);
			
			while( br.ready() ){
				
				String title = br.readLine();
				String autor = br.readLine();
				String isbn = br.readLine();
				String edicao1 = br.readLine();		
				int edicao = Integer.parseInt(edicao1); 
				
				ItemAcervo livro = new Livro(title,autor,isbn,edicao); 
				biblioteca.cadastraItem(livro);				
				RegistrosBiblioteca.salvar("Novo livro cadastrado	", livro.toString());			
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	//ALUGAR ITEM DO ACERVO
	public static void alugarItem(){
		System.out.println("Insira  CPF do usuario");
		Scanner a = new Scanner(System.in);
		String cpfUser = a.nextLine();
		Usuario usuario = null;	
		usuario = biblioteca.selecionaUsuario(cpfUser);	
		
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
			
			Arquivo.salvar("Locacao >> ", locar.toString());
		}else{
			System.out.println("item alugado");
		}	
	}
	
	//RESERVA ITEM DO ACERVO
	public static void reservar() {	
		System.out.println("Insira  CPF do usuario");
		Scanner c = new Scanner(System.in);
		String cpfUser1 = c.nextLine();
		Usuario usuario2 = null;	
		usuario2 = biblioteca.selecionaUsuario(cpfUser1);
			
		System.out.println("insira codigo do livro");
		Scanner codReserva = new Scanner(System.in);
		int codigoReserva = codReserva .nextInt();
		
		ItemAcervo itemReserva = null;
		try {
			itemReserva  = biblioteca.escolherItemAcervo(codigoReserva);
		} catch (CodigoInvalidoException e) {
			e.printStackTrace();
		}
	
		if(itemReserva != null){
			Reserva reservaItem = new Reserva(usuario2, itemReserva);
			biblioteca.cadastraReserva(reservaItem);
			RegistrosBiblioteca.salvar("", reservaItem.toString());
		}else{
			System.out.println("Impossível reservar este item");
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

			//Cadastrar item
			case 3:
				addItemAcervo();
			break;
			
			//Listar itens do acervo
			case 4:
				biblioteca.listaItemAcervo();
			break;
			
			//Fazer empréstimo
			case 5:
				Menu.aluguel();
				Scanner c1 = new Scanner(System.in);
				int ok = c1.nextInt();
				if(ok == 1){//ALUGUEL DIRETO
					biblioteca.listaItemAcervo();//ten de listar itens disponiveis 
					alugarItem();
				}else if(ok == 2){//ALUGUEL POR RESERVA
					
					System.out.println("Insira  CPF do usuario");
					Scanner c = new Scanner(System.in);
					String cpfUser1 = c.nextLine();
					Usuario usuario2 = biblioteca.selecionaUsuario(cpfUser1);
					
					Reserva novaLocacao = biblioteca.buscarReserva(usuario2);
					biblioteca.cadastraEmprestimo(novaLocacao);
					Locacao jaLocado = novaLocacao; 
					
					System.out.println(jaLocado.toString());		//o tostring ta chamando o da reserva
					Arquivo.salvar("Locacao >> ", jaLocado.toString());
				}else//volta ao menu
					break;
				
			break;
			
			//Listar itens alugados
			case 6:
				
			break;	
			
			//Reservar item do acervo
			case 7:	
				biblioteca.listaItemAcervo();
				reservar();	
			break;
			
			//Listar itens reservados
			case 8:	
				
			break;
			
			}
		}while(fim != 0);
	}	
}


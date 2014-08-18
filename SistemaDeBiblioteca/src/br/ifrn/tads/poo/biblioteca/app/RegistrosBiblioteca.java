package br.ifrn.tads.poo.biblioteca.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RegistrosBiblioteca {
	static File file = new File("registro_bliblioteca.txt");
	static String linha = "-----------------------------------------------";

	//Registra novas intera��es do sistema no arquivo.biblioteca.txt
	public static void salvar(String mensagem, String atualizacao) {
		try {	
			FileWriter atualizaArquivo = new FileWriter(file, true);
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

	//Adiciona novo usuario no arquivo_usuarios.txt
	public static void salvaNoBanco(String nome, String endereco, String cpf) {
		File bancoUsuarios = new File("arquivo_usuarios.txt");
		try {		
			FileWriter atualizaArquivo = new FileWriter(bancoUsuarios, true);
			BufferedWriter escreve = new BufferedWriter(atualizaArquivo);
			escreve.newLine();
			escreve.write(nome);
			escreve.newLine();
			escreve.write(endereco);
			escreve.newLine();
			escreve.write(cpf);
			escreve.newLine();
			escreve.write(linha);
			escreve.close();
			atualizaArquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Adiciona novo livro no arquivo_livros.txt
	public static void salvaLivroNoBanco(String title, String autor,
			String isbn, int edicao) {
		File bancoUsuarios = new File("arquivo_livros.txt");
		try {	
			FileWriter atualizaArquivo = new FileWriter(bancoUsuarios, true);
			BufferedWriter escreve = new BufferedWriter(atualizaArquivo);
			escreve.newLine();
			escreve.write(title);
			escreve.newLine();
			escreve.write(autor);
			escreve.newLine();
			escreve.write(isbn);
			escreve.newLine();
			String ed = Integer.toString(edicao);
			escreve.write(ed);		
			escreve.close();
			atualizaArquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Adiciona nova apostila no arquivo_apostilas.txt
	public static void salvaApostilanoBanco(String title, String autor) {
		File bancoUsuarios = new File("arquivo_apostilas.txt");
		try {	
			FileWriter atualizaArquivo = new FileWriter(bancoUsuarios, true);
			BufferedWriter escreve = new BufferedWriter(atualizaArquivo);
			escreve.newLine();
			escreve.write(title);
			escreve.newLine();
			escreve.write(autor);		
			escreve.close();
			atualizaArquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Adiciona novo texto no arquivo_textos.txt
	public static void salvaTextoNoBanco(String autor) {
		File bancoUsuarios = new File("arquivo_textos.txt");
		try {	
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
}

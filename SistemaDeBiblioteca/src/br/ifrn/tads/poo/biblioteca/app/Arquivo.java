package br.ifrn.tads.poo.biblioteca.app;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {
	static File file = new File("registro_bliblioteca.txt");
	static String linha = "-----------------------------------------------";

	public static void salvar(String mensagem, String atualizacao) {
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

	public static void salvaNoBanco(String nome, String endereco, String cpf) {

		File bancoUsuarios = new File("arquivo_usuarios.txt");
		try {	
			
			//o true adiciona o q se vai escrever no final do arquivo
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
	
	public static void salvaLivroNoBanco(String title, String autor,
			String isbn, int edicao) {
		File bancoUsuarios = new File("arquivo_livros.txt");
		try {	
//			 o true adiciona o q se vai escrever no final do arquivo
			FileWriter atualizaArquivo = new FileWriter(bancoUsuarios, true);
			BufferedWriter escreve = new BufferedWriter(atualizaArquivo);
			escreve.newLine();
			escreve.write(title);
			escreve.newLine();
			escreve.write(autor);
			escreve.newLine();
			escreve.write(isbn);
			escreve.newLine();
			escreve.write(edicao);
			
			escreve.close();
			atualizaArquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void salvaApostilanoBanco(String title, String autor) {
		File bancoUsuarios = new File("arquivo_apostilas.txt");
		try {	
//			 o true adiciona o q se vai escrever no final do arquivo
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
}

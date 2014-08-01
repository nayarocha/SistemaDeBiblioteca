package br.ifrn.tads.poo.biblioteca;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;

public class Biblioteca {
	private String nomeBiblioteca;	
	private ItemAcervo acervoBiblioteca[] = new ItemAcervo[50];
	private int quantUsuarios;
	private int quantItens;
	
	ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
	
	public Biblioteca(){

	}
	
	//Cadastra Usu�rio
	public void cadastraUsuario(Usuario usuario){
		usuarios.add(usuario);
		System.out.println("Usuario cadastrado");
		System.out.println("USUARIOS CADASTRADOS :" +usuarios.size());
	}
	
	//Lista usuarios cadastrados
	public void listaUsuarios(){
		// Imprime os objetos que esta no arraylist.Para isso foi necess�rio
		//sobrescrever o m�todo toString na classe usuario
		System.out.println("||Usu�rios cadastrados no sistema||");
		for(Usuario u: usuarios){
			System.out.println(u);
		}		
	}	
	
	//CADASTRAR LIVROS
	public void cadastraItens(ItemAcervo itemacervo){
		for (int i = 0; i < acervoBiblioteca.length; i++) {
			if(acervoBiblioteca[i]==null){
				acervoBiblioteca[i] = itemacervo;
				
			}
			
		}
		quantItens++;
		System.out.println("Item  cadastrado");
		System.out.println("Quantidade de itens cadastrados:" +quantItens);
	}
	
	
	//GERANDO ACERVO	
	public void gerarAcervo(){
		for (int i = 0; i < acervoBiblioteca.length; i++) {
			
		}
	}
	
	
	
	//CALCULAR VALOR DAS MULTAS
	public double calcularValorMultas(Date dia){
		return 0;
	}	
	
	
}




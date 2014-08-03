package br.ifrn.tads.poo.biblioteca;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;

public class Biblioteca {
	private String nomeBiblioteca;	
	private int quantUsuarios;
	private int quantItens;
	
	ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
	ArrayList<ItemAcervo> itemDeAcervo = new ArrayList <ItemAcervo>();
	
	public Biblioteca(){

	}
	
	//Cadastra Usuário
	public void cadastraUsuario(Usuario usuario){
		usuarios.add(usuario);
		System.out.println("Usuario cadastrado");
		System.out.println("USUARIOS CADASTRADOS :" +usuarios.size());
	}
	
	//Lista usuarios cadastrados
	public void listaUsuarios(){
		// Imprime os objetos que esta no arraylist.Para isso foi necessário
		//sobrescrever o método toString na classe usuario
		System.out.println("||Usuários cadastrados no sistema||");
		for(Usuario u: usuarios){
			System.out.println(u);
		}		
	}	
	
	//Cadastra item no acervo
	public void cadastraItem(ItemAcervo item){
		itemDeAcervo.add(item);	
		System.out.println("Item cadastrado com sucesso!");
	}
	
	
	
	
	//CALCULAR VALOR DAS MULTAS
	public double calcularValorMultas(Date dia){
		return 0;
	}	
	
	
}




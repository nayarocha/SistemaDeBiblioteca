package br.ifrn.tads.poo.biblioteca;

import java.util.ArrayList;
import java.util.Date;


import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;

public class Biblioteca {
	private String nomeBiblioteca;	
	
	
	
	ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
	ArrayList<ItemAcervo> itemDeAcervo = new ArrayList <ItemAcervo>();
	ArrayList<String> emprestimos = new ArrayList <String>();
	
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
	
	//Lista itens cadastrados no acervo
	public void listaItemAcervo(){
		System.out.println("===== ITENS CADASTRADOS NO SISTEMA =====");
		for(ItemAcervo i: itemDeAcervo){
			System.out.println(i);
		}
	}
	
	public void cadastraEmprestimo(String usuario, String codAcervo){	
		emprestimos.add(usuario);
		emprestimos.add(codAcervo);
	}
	
	public void listaEmprestimos(){
		for(String e: emprestimos){
			System.out.println(e);
		}
	}
	

	public ItemAcervo escolherItemAcervo(int num){
		ItemAcervo escolha = null;
		for(ItemAcervo i: itemDeAcervo){
			if(i.getCodigoItem() == num){
				escolha=  i;
				System.out.println("Item escolhido:" + i.getCodigoItem());		
			}
		}
		
		return escolha;
	}
	
	
	
	//CALCULAR VALOR DAS MULTAS
	public double calcularValorMultas(Date dia){
		return 0;
	}	
	
	
}




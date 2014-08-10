package br.ifrn.tads.poo.biblioteca;

import java.util.ArrayList;
import java.util.Date;


import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;

public class Biblioteca {
	private String nomeBiblioteca;	
	
	ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
	ArrayList<ItemAcervo> itemDeAcervo = new ArrayList <ItemAcervo>();
	ArrayList<Locacao> emprestimos = new ArrayList <Locacao>();
	
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
	
	public void listaEmprestimos(){
		// Imprime os objetos que esta no arraylist.Para isso foi necessário
		//sobrescrever o método toString na classe usuario
		System.out.println("||Emprestimos||");
		for(Locacao e: emprestimos){
			System.out.println(e);
		}		
	}	
	
	public ArrayList<ItemAcervo> buscaUsuarios(String cpf){
		// Imprime os objetos que esta no arraylist.Para isso foi necessário
		//sobrescrever o método toString na classe usuario
		System.out.println("||buscando|");
		for(Usuario u: usuarios){
			if(u.getCpf() == cpf)
			System.out.println(u.getNome());
		}	
		
		return itemDeAcervo;
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
	
	public void cadastraEmprestimo(Locacao locacao){	
		emprestimos.add(locacao);
		System.out.println("Emprestimo feito com sucesso");
	}
	
	/*public void listaEmprestimos(){
		for(String e: emprestimos){
			System.out.println(e);
		}
	}*/
	

	public ItemAcervo escolherItemAcervo(int num) throws CodigoInvalidoException{
		ItemAcervo escolha = null;
		for(ItemAcervo i: itemDeAcervo){
			if(i.getCodigoItem() == num){
				escolha=  i;
				System.out.println("Item escolhido:" + i.getCodigoItem());		
			}
		}
		if(escolha == null)
			throw new CodigoInvalidoException();
		
		return escolha;
	}
	
	public Usuario selecionaUsuario(int cod){
		Usuario seleciona = null;
		for(Usuario u: usuarios){
			if(u.getCodUsuario() == cod){
				seleciona = u;
				System.out.println("USUARIO" + u.getCpf());	
			}
		}
		return seleciona;
		
		
	}
	
	
	
	//CALCULAR VALOR DAS MULTAS
	public double calcularValorMultas(Date dia){
		return 0;
	}	
	
	
}




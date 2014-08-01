package br.ifrn.tads.poo.biblioteca;
import java.util.ArrayList;
import java.util.Date;

import br.ifrn.tads.poo.biblioteca.*;
import br.ifrn.tads.poo.biblioteca.acervo.*;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;

public class Biblioteca {
	private String nomeBiblioteca;	
	
	//private Usuario usuario;
	// ItemAcervo itemAcervo;
	
	private ItemAcervo acervoBiblioteca[] = new ItemAcervo[50];
	//private Usuario usuarios[] = new Usuario[10];
	private int quantUsuarios;
	private int quantItens;
	
	ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
	
	public Biblioteca(){

	}
	
	public void cadastraUsuario(Usuario usuario){
		usuarios.add(usuario);
		System.out.println("Usuario cadastrado");
		System.out.println("USUARIOS CADASTRADOS :" +usuarios.size());
	}
	
	
	
	
	/*CADASTRA USUARIOS 
	public void cadastraUsuario(Usuario usuario){
		for (int i = 0; i < usuarios.length; i++) {
			if(usuarios[i]==null){
				usuarios[i] = usuario;
				
			}
			
		}
		quantUsuarios++;
		System.out.println("Usuario cadastrado");
		System.out.println("Quantidade de usuarios cadastrados:" +quantUsuarios);
	}*/
	
	
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




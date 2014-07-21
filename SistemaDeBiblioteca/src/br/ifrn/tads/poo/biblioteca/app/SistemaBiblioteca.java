package br.ifrn.tads.poo.biblioteca.app;

import java.util.Scanner;

import br.ifrn.tads.poo.biblioteca.Biblioteca;
import br.ifrn.tads.poo.biblioteca.acervo.Livro;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;

public class SistemaBiblioteca {
	public static void main(String[] args) {
		Biblioteca biblioteca = new Biblioteca();
		
		//usuario maria
		Usuario maria = new Usuario();
		maria.setCodUsuario(01);
		maria.setCpf("088.234.100-01");
		maria.setEndereco("rua bla bla bla");
		maria.setNome("Maria");
		
		biblioteca.cadastraUsuario(maria);
		
		//usuario jose
		Usuario jose = new Usuario();
		jose.setCodUsuario(02);
		jose.setCpf("088.234.100-00");
		jose.setEndereco("rua bla bla bla");
		jose.setNome("Jose");
		
		biblioteca.cadastraUsuario(jose);
		//-----------------------------------------------------------------------------------------------------------//
		
		Livro pequenoprincipe = new Livro("Pequeno principe", "Antoine", "374837", 2, 30.50);
		biblioteca.cadastraItens(pequenoprincipe);
		
		System.out.println("CODIGO -" +maria.getCodUsuario() + "NOME -" + maria.getNome()+ "CPF -"+ maria.getCpf());	
		System.out.println("CODIGO -" +jose.getCodUsuario() + "NOME -" + jose.getNome()+ "CPF -"+ jose.getCpf());
		System.out.println("ISBN" + pequenoprincipe.getIsbn() + "CUSTO: " +pequenoprincipe.getCusto());
	
		
	}
}

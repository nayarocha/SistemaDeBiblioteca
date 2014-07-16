package br.ifrn.tads.poo.biblioteca;
import java.util.Date;
import br.ifrn.tads.poo.biblioteca.*;
import br.ifrn.tads.poo.biblioteca.acervo.*;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;

public class Biblioteca {
	private String nomeBiblioteca;	
	private ItemAcervo acervoBiblioteca[] = new ItemAcervo[50];
	private Usuario usuarios[] = new Usuario[10];
	
	public Biblioteca(){

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




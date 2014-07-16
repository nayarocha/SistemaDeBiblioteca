package br.ifrn.tads.poo.biblioteca.acervo;
import java.util.Date;

import br.ifrn.tads.poo.biblioteca.usuario.Usuario;
public abstract class ItemAcervo {
	private double custo;		//isso eh a MULTA?????
	private Date dataAluguel;		//setados no aluguel 
	private Date dataDevolucao;
	private int codigoItem;//	no uml eh da classe Iten	identificador unico do iten de acervo
	private boolean pago;
	private static int contador=0;// refere-se a qtidade de itens inseridoa no acervo
	
	public void alugar(){
		/**
		 * sai do array do acervo 
		 * seta a data de aluguel pra mais 15 dias
		 * da data atual toda vez q for chamado
		 */
					
	}
	
	public double devolver() {
		/**
		 * volta pro array do acervo
		 */
		
		return custo;//retorna o que de double
	}
	
	public boolean estaPago() {//eh um get pago
		return pago;
	}
	
	public void reservar(Usuario jose) {
		/**
		 * um atriduto para reservado??
		 * como impedir esse de ser alugado por outros usuarios??
		 * 
		 */
	}

	public int getCodigoItem() {
		return codigoItem;
	}

	public ItemAcervo() {
		this.contador ++;	//altera a qtidade de itens no acervo
		this.codigoItem = this.contador;//seta o codigo de iten so aqui
	}        /***inutil criar um item de acervo sem tipo
	 		*****  necessarios tipos apostila livro e texto
	 		*/    
	
	
	
	
		/**
	 * itens de acervo tem comportamentos diferentes
	 * quando na biblioteca
	 * quando reservados
	 * quando fora da biblioteca
	 * 
	 * podem ser interfaces???
	 * 
	 */
	
	
	
	
	
	
	
	/***
	 * poderia ter um tostring pra o usuario ver o status do iten
	 */
	
	
	
	
	
}


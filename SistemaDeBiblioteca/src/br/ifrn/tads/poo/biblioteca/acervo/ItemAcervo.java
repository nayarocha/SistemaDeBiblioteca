package br.ifrn.tads.poo.biblioteca.acervo;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;
import java.util.Date;


public abstract class ItemAcervo {
	private double custo;	//isso eh a MULTA?????
	private Date dataAluguel = null;	//setados no aluguel
	private Date dataDevolucao = null;
	private int codigoItem;// no uml eh da classe Iten identificador unico do iten de acervo
	private boolean pago = true;
	private static int contador=0;// refere-se a qtidade de itens inseridoa no acervo

	
	protected ItemAcervo(double custo){
		this.custo = custo;
		//altera a qtidade de itens no acervo
		this.contador ++;	
		//gera codigo do item adicionado 
		this.codigoItem = this.contador;
	}
	
	public void gerarAcervo(){
		
	}
	
	
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

	 /***inutil criar um item de acervo sem tipo
***** necessarios tipos apostila livro e texto
*/




/**
* itens de acervo tem comportamentos diferentes
* quando na biblioteca
* quando reservados
* quando fora da biblioteca
*
* podem ser INTERFACES???
*
*/







/***
* poderia ter um tostring pra o usuario ver o status do iten
*/





}
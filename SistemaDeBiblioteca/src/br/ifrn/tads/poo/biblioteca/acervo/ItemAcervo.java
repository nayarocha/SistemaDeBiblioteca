package br.ifrn.tads.poo.biblioteca.acervo;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;
import java.util.Date;


public abstract class ItemAcervo {
	protected double custo;	//isso eh a MULTA?????
	protected Date dataAluguel = null;	//setados no aluguel
	protected Date dataDevolucao = null;
	protected int codigoItem;// no uml eh da classe Iten identificador unico do iten de acervo
	protected boolean pago = true;
	protected static int contador=0;// refere-se a qtidade de itens inseridoa no acervo

	
	protected ItemAcervo(){
		this.custo = 0.0;
		//altera a qtidade de itens no acervo
		contador ++;	
		//gera codigo do item adicionado 
		this.codigoItem = contador;
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
	
	
	public double getCusto() {
		// TODO Auto-generated method stub
		return custo;
	}
	

	public void gerarAcervo(){
		
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
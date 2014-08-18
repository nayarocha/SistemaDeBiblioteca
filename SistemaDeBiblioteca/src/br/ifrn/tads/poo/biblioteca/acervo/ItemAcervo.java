package br.ifrn.tads.poo.biblioteca.acervo;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;

import java.util.Date;


public abstract class ItemAcervo {
	protected double custo = 0.0;	
	protected int codigoItem;
	private static int geracodigo = 1000;
	protected boolean pago = true;
	
	
	
	protected ItemAcervo(){
		this.codigoItem = geracodigo;
		this.geracodigo++;
	}

	public int getCodigoItem() {
	return codigoItem;
	}
	
	
	public double getCusto() {
		// TODO Auto-generated method stub
		return custo;
	}
	
	
	/*public String toString() {
		
		return getClass().getName().toString();
	}*/
}
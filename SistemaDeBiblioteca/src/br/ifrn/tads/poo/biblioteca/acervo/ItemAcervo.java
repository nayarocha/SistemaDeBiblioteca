package br.ifrn.tads.poo.biblioteca.acervo;

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
		return custo;
	}
}
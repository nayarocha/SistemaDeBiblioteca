package br.ifrn.tads.poo.biblioteca.acervo;

public class Texto extends ItemAcervo {
	private String autor;

	public Texto(String autor){	
		super();
		this.autor = autor;
		super.custo = custo;
	}

	public String getAutor() {
		return autor;
	}
	
	@Override
	public String toString() {
		return "CODIGO: " + super.codigoItem + "||TEXTO - " + this.autor;
	}
	
}

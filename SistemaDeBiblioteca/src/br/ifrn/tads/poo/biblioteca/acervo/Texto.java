package br.ifrn.tads.poo.biblioteca.acervo;

public class Texto extends ItemAcervo {
	private String autor;

	public Texto(String autor){	
		this.autor = autor;
		super.custo = custo;
	}

	public String getAutor() {
		return autor;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "APOSTILA - " + this.autor;
	}
	
}

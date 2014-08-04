package br.ifrn.tads.poo.biblioteca.acervo;

public class Texto extends ItemAcervo {
	private String autor;

	public Texto(int cod,String autor){	
		super.codigoItem = cod;
		this.autor = autor;
		super.custo = custo;
	}

	public String getAutor() {
		return autor;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "CÓDIGO: " + super.codigoItem + "APOSTILA -" + this.autor;
		
	}
	
}

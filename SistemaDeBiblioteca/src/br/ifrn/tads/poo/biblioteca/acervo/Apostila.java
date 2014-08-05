package br.ifrn.tads.poo.biblioteca.acervo;

public class Apostila extends ItemAcervo{
	private String titulo;
	private String autor;
	private int quantidade = 0;

	public Apostila(int cod,String titulo, String autor) {
		
		super.codigoItem = cod;
		this.titulo = titulo;
		this.autor = autor;
		super.custo = custo;
		this.quantidade++;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "CÓDIGO: " + super.codigoItem + "TÍTULO: " + this.titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public int getQuantidade() {
		return quantidade;
	}

}

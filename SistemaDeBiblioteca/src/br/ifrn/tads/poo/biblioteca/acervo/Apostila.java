package br.ifrn.tads.poo.biblioteca.acervo;

public class Apostila {
	private String titulo;
	private String autor;
	private int quantidade = 0;

	public Apostila(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
		this.quantidade++;
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

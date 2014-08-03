package br.ifrn.tads.poo.biblioteca.acervo;

public class Livro extends ItemAcervo {
	
	private String titulo;
	private String autor;
	private String isbn;
	private int edicao;//no UML EH integer
	private int quantidade = 0;

	
	public Livro(String titulo, String autor, String isbn, int edicao){
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.edicao = edicao;
		this.quantidade++;
		
	}

	
	public String getTitulo() {
		return titulo;
	}


	public String getAutor() {
		return autor;
	}


	public String getIsbn() {
		return isbn;
	}


	public int getEdicao() {
		return edicao;
	}


	public int getQuantidade() {
		return quantidade;
	}


	
	
	
}

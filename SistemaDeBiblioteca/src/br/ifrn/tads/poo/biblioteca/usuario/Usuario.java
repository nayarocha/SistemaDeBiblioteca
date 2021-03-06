package br.ifrn.tads.poo.biblioteca.usuario;


public class Usuario {
	protected int codUsuario;
	protected String nome;
	protected String endereco;
	protected String cpf;
	
	
	//adicionando usuarios
	public Usuario(int codUsuario,String nome, String endereco, String cpf){
		this.codUsuario = codUsuario;
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
	}
	
	
	
	
	@Override
	public String toString() {
		return this.codUsuario + " | " + this.nome +  " | ";
	}
	
	
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}

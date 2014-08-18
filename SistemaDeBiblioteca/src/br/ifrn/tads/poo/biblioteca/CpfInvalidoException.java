package br.ifrn.tads.poo.biblioteca;

public class CpfInvalidoException extends Exception {
	public CpfInvalidoException(){
		super("Cpf inválido");
	}
}
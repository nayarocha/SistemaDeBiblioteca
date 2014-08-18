package br.ifrn.tads.poo.biblioteca;

public class reservaInexistenteException extends Exception {

	public reservaInexistenteException(){
		super("Nenhuma reserva cadastrada");
	}

}

package br.ifrn.tads.poo.biblioteca;

import java.text.DateFormat;
import java.util.ArrayList;


import java.util.Calendar;
import java.util.Date;

import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;

public class Locacao {
	Usuario user;
	ItemAcervo item;
	Date dataEmprestimo = null;
	String dataDevolucao = null;
	
	public Locacao( Usuario usuario, ItemAcervo item , Date dataEmprestimo, String dataDevolucao){
		this.user = usuario;
		this.item =item;
		this.dataEmprestimo = dataEmprestimo;	
		this.dataDevolucao = dataDevolucao;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		Calendar c = Calendar.getInstance();
		c.setTime(dataEmprestimo);
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		return "Item alugado:" +item + "\n" + "Usuário:" + this.user + "\n" + "Data de emprestimo : " +df.format(c.getTime()) + "\n" +
		"data de devolução : " + this.dataDevolucao;
	}

}

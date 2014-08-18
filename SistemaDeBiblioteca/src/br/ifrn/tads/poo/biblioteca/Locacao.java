package br.ifrn.tads.poo.biblioteca;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import java.util.Calendar;
import java.util.Date;

import javax.xml.crypto.Data;

import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;

public class Locacao {
	Usuario user;
	ItemAcervo item;
	String dataEmprestimo = null;
	String dataDevolucao = null;
	
	
	public Locacao(){
		
	}
	
	public Locacao(Usuario usuario, ItemAcervo item , String dataEmprestimo, String dataDevolucao){
		this.user = usuario;
		this.item =item;
		this.dataEmprestimo = dataEmprestimo;	
		this.dataDevolucao = dataDevolucao;
	}
	
	
	public  Locacao(Usuario usuario, ItemAcervo item, String dataDevolucao){
		this.user = usuario;
		this.item = item;
		this.dataDevolucao = dataDevolucao;
	}
	
	
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		/*Calendar c = Calendar.getInstance();
		c.setTime(dataEmprestimo);
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);*/
		return "Item alugado:" +item + "\n" + "Usuário:" + this.user + "\n" + "Data de emprestimo : " +this.dataEmprestimo + "\n" +
		"data de devolução : " + this.dataDevolucao;
	}

}

package br.ifrn.tads.poo.biblioteca;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;

public class Locacao {
	protected Usuario user;
	protected ItemAcervo item;
	protected Date dataEmprestimo = null;
	protected String dataDevolucao = null;
	
	public Locacao(Usuario usuario, ItemAcervo item , Date dataEmprestimo, String dataDevolucao){
		this.user = usuario;
		this.item =item;
		this.dataEmprestimo = dataEmprestimo;	
		this.dataDevolucao = dataDevolucao;
	}
	
	public Locacao(){
		
	}
	
	public void setDataDevolucao(){
		Calendar agora = Calendar.getInstance();
		agora.add(Calendar.DAY_OF_MONTH, 20);	
		Format formato = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println();
		this.dataDevolucao = formato.format(agora.getTime());	
	}
	
	public void setDataEmprestimo() {
		this.dataEmprestimo = new Date();
	}


	@Override
	public String toString() {
		Calendar c = Calendar.getInstance();
		c.setTime(dataEmprestimo);
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		return "Item alugado:" +item + "\n" + "Usuário:" + this.user + "\n" + "Data de emprestimo : " +df.format(c.getTime()) + "\n" +
		"data de devolução : " + this.dataDevolucao;
	}

}

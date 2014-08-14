package br.ifrn.tads.poo.biblioteca;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;

public class Reserva extends Locacao{
	private Date dataReserva = null;
	private String dataEspira= null;
	

	public Reserva(Usuario usuario, ItemAcervo item, Date dataEmprestimo,
			String dataDevolucao) {
		
		// TODO Auto-generated constructor stub
	}
	
//	public Reserva( Usuario usuario, ItemAcervo item , Date dataReserva){
//		this.user = usuario;
//		this.item =item;
//		this.dataReserva= dataReserva;	
////		this.dataEspira= dataReserva+3;
//	}
	
	@Override
	public String toString() {
		Calendar c = Calendar.getInstance();
		c.setTime(dataReserva);
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		return "Item reservado: " + item + "\n" + "Usuário: " + this.user + "\n" + "Data de emprestimo: " +df.format(c.getTime()) + "\n" +
		"Data que espira a reserva: " + this.dataEspira;
	}

}

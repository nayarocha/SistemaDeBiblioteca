package br.ifrn.tads.poo.biblioteca;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;

public class Reserva extends Locacao{
	
	
	
	public Reserva(Usuario usuario, ItemAcervo item, String dataDevolucao) {
		super(usuario, item, dataDevolucao);
		this.dataReserva = new Date();
		this.setDataEspira();
		super.user = usuario;
		super.item = item;
	}


	private Date dataReserva =  null;
	private String dataEspira= null;
	

	/*public Reserva(Usuario usuario, ItemAcervo item){
		
	}*/
	
	public void setDataEspira(){
		Calendar agora = Calendar.getInstance();
		agora.add(Calendar.DAY_OF_MONTH, 3);	
		Format formato = new SimpleDateFormat("dd/MM/yyyy");
		this.dataEspira = formato.format(agora.getTime());	
	}

	
	@Override
	public String toString() {
		Calendar c = Calendar.getInstance();
		c.setTime(dataReserva);
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		return "Item reservado: " + item + " || " + "Usuário: " + this.user + " || "
				+ "Data da reserva: " +df.format(c.getTime()) + " || " +
				"Data que espira a reserva: " + this.dataEspira;
	}


	public void setDataEmprestimo() {
		// TODO Auto-generated method stub
		
	}


	public void setDataDevolucao() {
		// TODO Auto-generated method stub
		
	}
	
	

}

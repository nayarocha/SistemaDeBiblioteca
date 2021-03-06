package br.ifrn.tads.poo.biblioteca;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;





import java.util.GregorianCalendar;
import java.util.Iterator;

import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;

public class Biblioteca {
	private String nomeBiblioteca;	
	
	ArrayList <Usuario> usuarios = new ArrayList <Usuario>();
	ArrayList<ItemAcervo> itemDeAcervo = new ArrayList <ItemAcervo>();
	ArrayList<Locacao> emprestimos = new ArrayList <Locacao>();
	ArrayList<Reserva> reservados = new ArrayList <Reserva>();
	
	public Biblioteca(){}
	
	//Cadastra novo item no acervo
	public void cadastraItem(ItemAcervo item){
		itemDeAcervo.add(item);	
	}
			
	//Cadastra novo Usu�rio
	public void cadastraUsuario(Usuario usuario){
		usuarios.add(usuario);		
	}
		
	//Cadastra novo emprestimo 
	public void cadastraEmprestimo(Locacao locacao){		
		emprestimos.add(locacao);
		System.out.println("Emprestimo feito com sucesso");		
	}
	
	//Cadastra nova reserva
	public void cadastraReserva(Reserva reserva){
		reservados.add(reserva);
		System.out.println("Reserva efetuada com sucesso");
	}
	
	//Cadastra emprestimo de um item reservado
	public void cadastraEmprestimo(Reserva reserva){	
		reserva.setDataEmprestimo();
		reserva.setDataDevolucao();
		emprestimos.add(reserva);
		reservados.remove(reserva);
		System.out.println("Emprestimo feito com sucesso");	
	}
	
	//Cadastra nova devolucao
	public void cadastraDevolucao(Locacao locacao){
		emprestimos.remove(locacao);
		System.out.println("Devolucao feita com sucesso");
	}	
	
	
	//seleciona item para devolver
	public Locacao devolucaoItemAcervo(int num){
		Locacao escolha = null;
		
		for(Locacao l: emprestimos){
			if(l.item.getCodigoItem() == num){
				escolha = l;
			}

		}
		return escolha;	
	}
		
	//Seleciona item de acervo para alugar
	public ItemAcervo escolherItemAcervo(int num) throws CodigoInvalidoException{
		ItemAcervo escolha = null;
		//VERIFICA SE O ITEM JA ESTA LOCADO
		for(Locacao l: emprestimos){
			if(l.item.getCodigoItem() == num)
				return null;
		}
		
		//verifica se o item ja esta reservado
		for(Reserva r: reservados){
			if(r.item.getCodigoItem() == num){
				System.out.println("O item "+ r.item.getCodigoItem() + "encontra-se reservado.");
				return null;
			}				
		}
		
		for(ItemAcervo i: itemDeAcervo){
			if(i.getCodigoItem() == num){
				escolha=  i;
			System.out.println("Item escolhido:" + i.getCodigoItem());		
			}
		}
		if(escolha == null)
			throw new CodigoInvalidoException();
		
		return escolha;
	}
	
	//Seleciona usuario a partir do CPF
	public Usuario selecionaUsuario(String cpf){
		Usuario seleciona = null;
		for(Usuario u: usuarios){
			if(u.getCpf().equalsIgnoreCase(cpf)){ 
				seleciona = u;
				System.out.println("USUARIO" + u.getNome());	
			}
		}
		return seleciona;
	}	
	
	//lista usuarios 
	public void listaUsuarios(){
		System.out.println("||Usu�rios cadastrados no sistema||");
		for(Usuario u: usuarios){
			System.out.println(u);
		}		
	}	
	
	//listaritens locados
	public void listaEmprestimos(){
		System.out.println("||Emprestimos||");
		for(Locacao e: emprestimos){
			System.out.println(e);
		}		
	}
	
	//lista itens reservados
	public void listaReservados(){
		System.out.println("||Reservados||");
		for(Reserva e: reservados){
			System.out.println(e);
		}
	}
	
	//Lista itens cadastrados no acervo
	public void listaItemAcervo(){
		System.out.println("===== ITENS CADASTRADOS NO SISTEMA =====");
		for(ItemAcervo i: itemDeAcervo){
			System.out.println(i);
		}
	}
	
	//Buscar reserva
	public Reserva buscarReserva(Usuario usuario2) throws reservaInexistenteException {
		Reserva reservaBuscada = null; 
		for(Reserva u: reservados){
			if(usuario2.getCodUsuario() == u.user.getCodUsuario()){
				reservaBuscada = u;
				System.out.println("Voce reservou o item " + reservaBuscada.item.toString());
			}
		}
		if(reservaBuscada == null){
			throw new reservaInexistenteException();			
		}
		return reservaBuscada;
	}
	
	
	public void verificaCpfRepetido(String cpf) throws CpfInvalidoException {
		for(Usuario u: usuarios){
			if(u.getCpf().equalsIgnoreCase(cpf)){ 
				throw new CpfInvalidoException();
			}
		}
	}

	
	public void verificaCpfCadastrado(String cpfUser) throws CpfInvalidoException {
		for(Usuario u: usuarios){
			if(!(u.getCpf().equalsIgnoreCase(cpfUser))){ 
				throw new CpfInvalidoException();
			}
		}
	}
	
	
	public String dataEmprestimo(){
		Calendar agora = Calendar.getInstance();
		Format formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(agora.getTime());	
	}
	
	//Data de devolucao
	public String dataDevolucao(){
		Calendar agora = Calendar.getInstance();
		agora.add(Calendar.DAY_OF_MONTH, 20);	
		Format formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(agora.getTime());	
	}
		
	
	//Data da reserva 
	public String dataEspira(){
		Calendar agora = Calendar.getInstance();
		agora.add(Calendar.DAY_OF_MONTH, 3);	
		Format formato = new SimpleDateFormat("dd/MM/yyyy");
		return formato.format(agora.getTime());	
	}

	
	
	public String removeUsuario(Usuario usuario){
		usuarios.remove(usuario);
		return "Usuario removido com sucesso";	
	}
	
	public String removeItem(ItemAcervo item){
		itemDeAcervo.remove(item);
		
		return "Item removido com sucesso";
		
	}
}




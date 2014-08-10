package br.ifrn.tads.poo.biblioteca;

import java.util.ArrayList;

import br.ifrn.tads.poo.biblioteca.acervo.ItemAcervo;
import br.ifrn.tads.poo.biblioteca.usuario.Usuario;

public class Locacao {
	Usuario user;
	ItemAcervo item;
	
	public Locacao( Usuario usuario, ItemAcervo item){
		this.user = usuario;
		this.item =item;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Item alugado:" +item +"|" + "Usuário:" + this.user;
	}

}

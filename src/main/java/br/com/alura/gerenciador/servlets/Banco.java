package br.com.alura.gerenciador.servlets;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.gerenciador.models.Empresa;

public class Banco {

	private static List<Empresa> listaEmpresas = new ArrayList<Empresa>();
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Google");
		
		listaEmpresas.add(empresa);
		listaEmpresas.add(empresa2);
	}
	
	public void adiciona(Empresa empresa) {
		listaEmpresas.add(empresa);
	}

	public List<Empresa> getEmpresas(){
		return Banco.listaEmpresas;
	}
}

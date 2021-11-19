package br.com.alura.gerenciador.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> listaEmpresas = new ArrayList<Empresa>();
	private static List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	//simulando o id 
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		empresa.setId(chaveSequencial++);
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Google");
		empresa2.setId(chaveSequencial++);
		listaEmpresas.add(empresa);
		listaEmpresas.add(empresa2);
	
		Usuario u1 = new Usuario();
		u1.setLogin("joao");
		u1.setSenha("1234");
		Usuario u2 = new Usuario();
		u2.setLogin("ana");
		u2.setSenha("4321");
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		listaEmpresas.add(empresa);
	}

	public List<Empresa> getEmpresas(){
		return Banco.listaEmpresas;
	}

	public void removeEmpresa(Integer id) {
		
		Iterator<Empresa> it = listaEmpresas.iterator();
		
		while(it.hasNext()) {
			Empresa empresa = it.next();
			if(empresa.getId() == id) {
				it.remove();
			}
		}

//		O laço não funcionará por apagar os itens que estão sendo iterados.
//		for (Empresa empresa : listaEmpresas) {
//			if(empresa.getId() == id) {
//				listaEmpresas.remove(empresa);
//			}
//		}
	}

	public Empresa buscaEmpresaPorId(Integer id) {
		for (Empresa empresa : listaEmpresas) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for (Usuario usuario : listaUsuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}


}

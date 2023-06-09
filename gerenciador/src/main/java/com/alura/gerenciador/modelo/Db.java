package com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.oracle.wls.shaded.org.apache.bcel.generic.RETURN;

public class Db {

	private static List<Empresa> listaEmpresas = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer llaveSecuencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(Db.llaveSecuencial++);
		empresa.setNombre("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(Db.llaveSecuencial++);
		empresa2.setNombre("Smart");
		
		listaEmpresas.add(empresa);
		listaEmpresas.add(empresa2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("Ana");
		u1.setContrasena("123");
		Usuario u2 = new Usuario();
		u2.setLogin("Pedro");
		u2.setContrasena("321");
		
		listaUsuarios.add(u1);
		listaUsuarios.add(u2);
	}
	
	public void agregarEmpresa(Empresa empresa) {
		empresa.setId(Db.llaveSecuencial++);
		Db.listaEmpresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return Db.listaEmpresas;
	}

	public void eliminarEmpresa(Integer id) {
		
		Iterator<Empresa> it = listaEmpresas.iterator();
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Empresa buscarEmpresaPorId(Integer id) {
		for (Empresa empresa : listaEmpresas) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String paramLogin, String paramContrasena) {
		for(Usuario usuario: listaUsuarios) {
			if(usuario.esIgual(paramLogin, paramContrasena)) {
				return usuario;
			}
		}
		return null;
	}
}

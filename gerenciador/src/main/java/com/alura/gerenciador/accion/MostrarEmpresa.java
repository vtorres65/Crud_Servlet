package com.alura.gerenciador.accion;

import java.io.IOException;

import com.alura.gerenciador.modelo.Db;
import com.alura.gerenciador.modelo.Empresa;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MostrarEmpresa implements Accion {

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String paramid = request.getParameter("id");
		Integer id = Integer.valueOf(paramid);
		
		System.out.println("Mostrando una Empresa" + id);
		
		Db db = new Db();
		Empresa emp = db.buscarEmpresaPorId(id);
		
		System.out.println(emp.getNombre());
		
		request.setAttribute("empresas", emp);
		
		return "forward:formModificarEmpresa.jsp";
	}
}

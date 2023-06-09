package com.alura.gerenciador.accion;

import java.io.IOException;

import com.alura.gerenciador.modelo.Db;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EliminarEmpresa implements Accion {

	public String ejecutar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String paramid = request.getParameter("id");
		Integer id = Integer.valueOf(paramid);
		
		System.out.println("Eliminando una Empresa " + id);
		
		Db db = new Db();
		db.eliminarEmpresa(id);
		
		return "redirect:entrada?accion=ListaEmpresas";
		
	}
}

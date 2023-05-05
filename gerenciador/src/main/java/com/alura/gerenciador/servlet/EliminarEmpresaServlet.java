package com.alura.gerenciador.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EliminarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramid = request.getParameter("id");
		Integer id = Integer.valueOf(paramid);
		
		System.out.println(id);
		
		Db db = new Db();
		db.eliminarEmpresa(id);
		
		response.sendRedirect("listaEmpresas");
	}

}

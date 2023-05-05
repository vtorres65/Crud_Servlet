package com.alura.gerenciador.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MostrarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramid = request.getParameter("id");
		Integer id = Integer.valueOf(paramid);
		
		System.out.println(id);
		
		Db db = new Db();
		Empresa emp = db.buscarEmpresaPorId(id);
		
		System.out.println(emp.getNombre());
		
		request.setAttribute("empresas", emp);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formModificarEmpresa.jsp");
		rd.forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}

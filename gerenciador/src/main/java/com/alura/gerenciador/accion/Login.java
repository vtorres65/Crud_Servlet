package com.alura.gerenciador.accion;

import java.io.IOException;

import com.alura.gerenciador.modelo.Db;
import com.alura.gerenciador.modelo.Usuario;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Login implements Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String paramLogin = request.getParameter("login");
		String paramContrasena = request.getParameter("contrasena");
		
		System.out.println("Login"+paramLogin);
		
		Db db = new Db();
		Usuario usuario = db.existeUsuario(paramLogin,paramContrasena);
		
		if(usuario != null) {
			System.out.println("Usuario correcto");
			HttpSession sesion = request.getSession();
			sesion.setAttribute("loginUsuario", usuario);
			return "redirect:entrada?accion=ListaEmpresas";
		}else {
			return "redirect:entrada?accion=LoginForm";
		}
	}
}

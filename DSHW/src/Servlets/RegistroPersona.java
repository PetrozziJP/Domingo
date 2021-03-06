package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Persona;
import Utilities.DSHMensaje;

/**
 * Servlet implementation class RegistroPersona
 */
@WebServlet("/RegistroPersona")
public class RegistroPersona extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	public HttpSession session;

    public RegistroPersona() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Persona p = new Persona();
		p.setMensaje(new DSHMensaje());
		p.setUser(request.getParameter("user").trim());
		p.setPassword(request.getParameter("password").trim());
		p.setNombre(request.getParameter("nombre").trim());
		p.setApellido(request.getParameter("apellido").trim());
		p.setEmail(request.getParameter("email").trim());
		p = p.create();
		
		session = request.getSession(true);
		session.setAttribute(p.getMensaje().getKey(), p.getMensaje().getMessage());
		if (p.getMensaje().getKey().equals("mensajeOK"))
			response.sendRedirect("index.jsp");
		else 
			response.sendRedirect("nuevaCuenta.jsp");
	}
}

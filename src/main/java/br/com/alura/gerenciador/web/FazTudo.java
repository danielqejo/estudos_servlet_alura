package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/fazTudo")
public class FazTudo extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String tarefa = req.getParameter("tarefa");
		if(tarefa == null){
			throw new IllegalArgumentException("Voce não passou a tarefa");
		}
		String nomeDaClasse = "br.com.alura.gerenciador.web." + tarefa;
		Class type;
		try {
			type = Class.forName(nomeDaClasse);
			Tarefa novaTarefa = (Tarefa) type.newInstance();			
			RequestDispatcher requestDispatcher = req.getRequestDispatcher(novaTarefa.executa(req, resp));
			requestDispatcher.forward(req, resp);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
	}
}

package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns="/busca")
public class BuscaEmpresa extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmpresaDAO dao = new EmpresaDAO();
		String filtro = req.getParameter("filtro");
		Collection<Empresa> empresas = dao.buscaPorSimilaridade(filtro);

		req.setAttribute("empresas", empresas);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/buscaEmpresa.jsp");
		requestDispatcher.forward(req, resp);
	}

}

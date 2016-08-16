package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		
		Cookie usuario = getUsuario(req.getCookies());
		
		String usuarioLogado = "<deslogado>";
		
		if(usuario != null)
			usuarioLogado = usuario.getValue();
		
		System.out.println("O usuario " + usuarioLogado + " acessou a URL: " + uri);
		
		chain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	
	private Cookie getUsuario(Cookie[] cookies){
		if(cookies != null){		
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("usuario_logado")){
					return cookie;
				}
			}
		}
		return null;
	}
	
}
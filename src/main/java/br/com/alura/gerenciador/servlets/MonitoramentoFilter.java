package br.com.alura.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/entrada") //todas as requisições passam no filter antes da servlet
public class MonitoramentoFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		long antes = System.currentTimeMillis();
		
		//tudo que dá pra fazer na servlet dá pra fazer no filter
		String acao = request.getParameter("acao");
		
		//Executa a ação
		filterChain.doFilter(request, response);
		
		long depois = System.currentTimeMillis();
		System.out.println("Tempo de execução da acao "+ acao + ": " + (depois - antes));
		
		
	}
	
}

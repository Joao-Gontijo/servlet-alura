package br.com.alura.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acoes.Acao;
import br.com.alura.gerenciador.acoes.AlteraEmpresa;
import br.com.alura.gerenciador.acoes.ListaEmpresas;
import br.com.alura.gerenciador.acoes.MostraEmpresa;
import br.com.alura.gerenciador.acoes.NovaEmpresa;
import br.com.alura.gerenciador.acoes.NovaEmpresaForm;
import br.com.alura.gerenciador.acoes.RemoveEmpresa;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramAcao = request.getParameter("acao");
		 
		
		String nomeClasse = "br.com.alura.gerenciador.acoes." + paramAcao;
		
		String nome;
		try {
			@SuppressWarnings("rawtypes")
			Class classe = Class.forName(nomeClasse);
			@SuppressWarnings("deprecation")
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException | IOException e) {
			throw new ServletException(e);
		}
		
		String[] tipoEndereco = nome.split(":");
		if(tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEndereco[1]);
		}
		
	}

}

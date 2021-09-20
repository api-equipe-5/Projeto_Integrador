package br.com.pineapple.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import static java.lang.System.out;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pineapple.dao.ProjetoDAO;
import br.com.pineapple.domain.Projeto;

@WebServlet("/ProjetoUpdate")
public class ProjetoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProjetoDAO pdao = new ProjetoDAO();
	
    public ProjetoUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String inicio = request.getParameter("inicio");
		String entrega = request.getParameter("entrega");
		
			Projeto registro = new Projeto();
			registro.setNome(nome);
			registro.setInicio(inicio);
			registro.setEntrega(entrega);		

			try {
				pdao.atualizar(registro);
				response.sendRedirect("index.jsp#t3");
				}catch(SQLException ex) {
					ex.printStackTrace();
					ex.getMessage();
					out.println(ex);
				}
	}

}

package br.com.pineapple.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pineapple.dao.TarProjDAO;
import br.com.pineapple.domain.TarProj;

@WebServlet("/TarefaProjetoServlet")
public class TarProjServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TarProjDAO tpdao = new TarProjDAO();
       
	
    public TarProjServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome_tarefa= request.getParameter("nome_tarefa");
		String nome_projeto = request.getParameter("nome_projeto");
		
			TarProj registro = new TarProj();
			registro.setNome_tarefa(nome_tarefa);
			registro.setNome_projeto(nome_projeto);
			
			try {
			tpdao.salvar(registro);
			response.sendRedirect("index.jsp#t3");
			}catch(SQLException ex) {
				ex.printStackTrace();
				ex.getMessage();
			}
	}
	
}

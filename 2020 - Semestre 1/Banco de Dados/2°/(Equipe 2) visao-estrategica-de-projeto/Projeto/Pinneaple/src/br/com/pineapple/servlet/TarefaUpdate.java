package br.com.pineapple.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pineapple.dao.TarefaDAO;
import br.com.pineapple.domain.Tarefa;

@WebServlet("/TarefaUpdate")
public class TarefaUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TarefaDAO tdao = new TarefaDAO();
       
    public TarefaUpdate() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String data_inicio = request.getParameter("data_inicio");
		String data_termino = request.getParameter("data_termino");
		String nome_tarefa = request.getParameter("nome_tarefa");
		
		
			Tarefa registro = new Tarefa();
			registro.setNome_tarefa(nome_tarefa);
			registro.setData_termino(data_termino);
			registro.setData_inicio(data_inicio);

			try {
				tdao.atualizar(registro);	
				response.sendRedirect("index.jsp#t4");
				}catch(SQLException ex) {
					ex.printStackTrace();
					ex.getMessage();
				}
	}

}

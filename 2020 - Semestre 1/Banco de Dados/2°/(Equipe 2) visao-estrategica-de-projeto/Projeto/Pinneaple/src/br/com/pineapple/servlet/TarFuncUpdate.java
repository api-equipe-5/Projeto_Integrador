package br.com.pineapple.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pineapple.domain.TarFunc;
import br.com.pineapple.dao.TarFuncDAO;
import br.com.pineapple.dao.TarProjDAO;

@WebServlet("/TarFuncUpdate")
public class TarFuncUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TarFuncDAO tfdao = new TarFuncDAO();
	
    public TarFuncUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome_tarefa = request.getParameter("nome_tarefa");
		String cpf = request.getParameter("cpf");
		
		
			TarFunc registro = new TarFunc();
			registro.setNome_tarefa(nome_tarefa);
			registro.setCpf(cpf);

			try {
				tfdao.atualizar(registro);	
				response.sendRedirect("index.jsp#t4");
				}catch(SQLException ex) {
					ex.printStackTrace();
					ex.getMessage();
				}

		
	}

}

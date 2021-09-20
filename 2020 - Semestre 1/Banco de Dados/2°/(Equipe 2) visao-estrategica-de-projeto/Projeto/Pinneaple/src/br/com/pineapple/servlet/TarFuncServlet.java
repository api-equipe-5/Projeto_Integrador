package br.com.pineapple.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pineapple.dao.TarFuncDAO;
import br.com.pineapple.domain.TarFunc;

@WebServlet("/TarFuncServlet")
public class TarFuncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TarFuncDAO tfdao = new TarFuncDAO();

	
    public TarFuncServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome_tarefa = request.getParameter("nomeF");
		String cpf = request.getParameter("funcionarios");
		
		TarFunc tf = new TarFunc();
		tf.setNome_tarefa(nome_tarefa);
		tf.setCpf(cpf);
		
		try {
			tfdao.salvar(tf);
			response.sendRedirect("index.jsp#t4");
			}catch(SQLException ex) {
				ex.printStackTrace();
				ex.getMessage();
			}
		System.out.println("saida: " + nome_tarefa);
		System.out.println("saida: " + cpf);
		
	}

}

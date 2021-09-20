package br.com.pineapple.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pineapple.dao.FuncionarioDAO;
import br.com.pineapple.domain.Funcionario;

@WebServlet("/FuncionarioUpdate")
public class FuncionarioUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FuncionarioDAO fdao = new FuncionarioDAO();
	
    public FuncionarioUpdate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String cpf = request.getParameter("cpf");
		
		
			Funcionario registro = new Funcionario();
			registro.setCpf(cpf);
			registro.setEmail(email);
			registro.setNome(nome);

			try {
				fdao.atualizar(registro);	
				response.sendRedirect("index.jsp#t2");
				}catch(SQLException ex) {
					ex.printStackTrace();
					ex.getMessage();
				}
	}

}

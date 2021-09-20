package br.com.pineapple.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pineapple.dao.ProjFuncDAO;
import br.com.pineapple.dao.TarFuncDAO;
import br.com.pineapple.domain.ProjFunc;
import br.com.pineapple.domain.TarFunc;

@WebServlet("/ProjFuncServlet")
public class ProjFuncServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProjFuncServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String funcionario = request.getParameter("funcionarios");
		String projeto = request.getParameter("nomeP");
		
		ProjFunc r = new ProjFunc();
		// Setando resultados
		r.setCpf(funcionario);
		r.setNome(projeto);
		
		ProjFuncDAO pfdao = new ProjFuncDAO();
		
		try {
			pfdao.salvar(r);
			response.sendRedirect("index.jsp#t3");
		}catch(SQLException ex) {
			ex.printStackTrace();
			ex.getMessage();
		}
	
	}

}

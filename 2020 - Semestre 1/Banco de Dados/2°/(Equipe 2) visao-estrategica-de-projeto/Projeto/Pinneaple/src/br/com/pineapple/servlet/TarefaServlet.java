package br.com.pineapple.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pineapple.dao.TarProjDAO;
import br.com.pineapple.dao.TarefaDAO;
import br.com.pineapple.domain.TarProj;
import br.com.pineapple.domain.Tarefa;

/**
 * Servlet implementation class TarefaServlet
 */
@WebServlet("/TarefaServlet")
public class TarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TarefaDAO tdao = new TarefaDAO();
	private TarProjDAO tpdao = new TarProjDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TarefaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String data_inicio = request.getParameter("data_inicio");
		String data_termino = request.getParameter("data_termino");
		String nome_tarefa= request.getParameter("nome_tarefa");
		String nome_projeto = request.getParameter("projetos");

			Tarefa registro = new Tarefa();
			TarProj tp = new TarProj();
			registro.setNome_tarefa(nome_tarefa);
			registro.setData_termino(data_termino);
			registro.setData_inicio(data_inicio);
			tp.setNome_projeto(nome_projeto);
			tp.setNome_tarefa(nome_tarefa);
			try {
			tdao.salvar(registro);
			tpdao.salvar(tp);
			response.sendRedirect("index.jsp#t4");
			}catch(SQLException ex) {
				ex.printStackTrace();
				ex.getMessage();
			}
	}

}

package br.com.pineapple.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pineapple.dao.ProjFuncDAO;
import br.com.pineapple.dao.ProjetoDAO;
import br.com.pineapple.domain.ProjFunc;
import br.com.pineapple.domain.Projeto;

@WebServlet("/ProjetoServlet")
public class ProjetoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProjetoServlet() {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recebimento de strings da pagina de cadastro
        String nome = request.getParameter("nome");
        String inicio = request.getParameter("inicio");
        String entrega = request.getParameter("entrega");
        String funcionario = request.getParameter("funcionarios");

        // Instanciando variavel tipo
        Projeto p = new Projeto();
        // Setando resultados
        p.setNome(nome);
        p.setInicio(inicio);
        p.setEntrega(entrega);

        ProjFunc f = new ProjFunc();
        f.setCpf(funcionario);
        f.setNome(nome);
        ProjFuncDAO pf = new ProjFuncDAO();


        ProjetoDAO pdao = new ProjetoDAO();
        try {
            pdao.salvar(p);
            pf.salvar(f);
            response.sendRedirect("index.jsp#t3");
        }catch(SQLException ex) {
            System.out.println(ex);
        }

    }

}
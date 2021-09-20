package br.com.fatec.controller;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.awt.Frame;
import java.awt.FileDialog;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import br.com.fatec.model.ToConvert;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/Parametrizacao")
public class Parametrizacao extends HttpServlet {
    public static ToConvert conv;
    private static final long serialVersionUID = 1L;
    
    static {
        Parametrizacao.conv = new ToConvert();
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/");
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final FileDialog fd = new FileDialog((Frame)null, "Selecionar Shapefile", 0);
        fd.setFile("*.shp");
        fd.setVisible(true);
        if (fd.getFile() != null) {
            final File selected = fd.getFiles()[0];
            final String name = selected.getName();
            final HttpSession session = request.getSession();
            session.setAttribute("Arquivo", (Object)("temp_" + name.replace(".shp", "").toLowerCase()));
            session.setAttribute("Alvo", (Object)request.getParameter("ShapeToPost"));
            try {
                Parametrizacao.conv.shapeToPost(selected.getAbsolutePath());
            }
            catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            response.sendRedirect("parametrizacao.jsp");
        }
        else {
            response.sendRedirect("/");
        }
    }
}
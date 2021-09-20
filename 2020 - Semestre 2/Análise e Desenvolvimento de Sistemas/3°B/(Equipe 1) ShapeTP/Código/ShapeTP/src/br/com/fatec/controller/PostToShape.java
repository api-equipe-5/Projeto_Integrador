package br.com.fatec.controller;

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

@WebServlet("/PostToShape")
public class PostToShape extends HttpServlet {
    public static ToConvert conv;
    private static final long serialVersionUID = 1L;
    
    static {
        PostToShape.conv = new ToConvert();
    }
    
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/");
    }
    
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        final FileDialog fd = new FileDialog((Frame)null, "Salvar Shapefile", 1);
        fd.setVisible(true);
        if (fd.getFile() != null) {
            final File selected = fd.getFiles()[0];
            try {
                PostToShape.conv.postToShape(selected.getAbsolutePath(), request.getParameter("PostToShape"));
            }
            catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/op/sucesso.html");
        }
        else {
            response.sendRedirect("/");
        }
    }
}
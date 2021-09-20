package controller;


import java.io.IOException;

 
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/SendMailAttachServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2,   // 2MB
maxFileSize = 1024 * 1024 * 10,         // 10MB
maxRequestSize = 1024 * 1024 * 50)      // 50MB
public class SendMailAttachServlet extends HttpServlet {
    private String host;
    private String port;
    private String user;
    private String pass;
 
    public void init() {
        // lê o SMTP server setado no arquivo web.xml 
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
 
    //form.jsp
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        String recipient = request.getParameter("recipient");
        String subject = request.getParameter("subject");
       
 
        String resultMessage = "";
 
        try {
            EmailUtility.sendEmailWithAttachment(host, port, user, pass, recipient, subject);
             
            resultMessage = "Um email foi enviado contendo algumas informações sobre o uso do seus dados.";
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "Houve um erro: " + ex.getMessage();
        } finally {
            //deleteUploadFiles(uploadedFiles);
            request.setAttribute("message", resultMessage);
            getServletContext().getRequestDispatcher("/Result1.jsp").forward(
                    request, response);
        }
    }
 }

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.Servlets;

import ELearning.services.client.aluno.Aluno;
import ELearning.services.client.professor.Professor;
import ELearning.services.client.professor.ProfessorService;
import ELearning.services.client.professor.ProfessorService_Service;
import ELearning.services.client.usuario.Usuario;
import ELearning.services.client.usuario.UsuarioService;
import ELearning.services.client.usuario.UsuarioService_Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Acessa SP
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */

            Usuario user = new Usuario();
            user.setLogin((String)request.getParameter("login"));
            user.setSenha((String)request.getParameter("senha"));

           UsuarioService_Service service = new UsuarioService_Service();
           UsuarioService port = service.getUsuarioServicePort();
           user = port.validaLogin(user);
           request.getSession().setAttribute("user",user);

            if(user != null){
                switch(user.getTipoUsuario()){
                    case 1:
                        response.sendRedirect("/ELearning/admin/adminUI.jsp");
                        break;
                    case 2:
                        Professor professor = new Professor();
                        professor.setIdUsuario(user.getIdUsuario());
                        ProfessorService_Service profService = new ProfessorService_Service();
                        ProfessorService profPort = profService.getProfessorServicePort();

                        List<Professor> lista = profPort.procurarProfessor(professor);

                        Professor usuario = null;
                        if(lista.size() > 0)
                            usuario = (Professor)lista.get(0);

                        request.getSession().setAttribute("user",usuario);

                        response.sendRedirect("/ELearning/professor/professorUI.jsp");
                        break;
                    case 3:
                        RequestDispatcher r = request.getRequestDispatcher("Aluno");
                        r.forward(request, response);
                        //response.sendRedirect("/ELearning/student/studentUI.jsp");
                        break;
                }
            }else{
                out.println("Erro<br/><br/><a href='javascript:history.back()'>Voltar</a>");
            }
            
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

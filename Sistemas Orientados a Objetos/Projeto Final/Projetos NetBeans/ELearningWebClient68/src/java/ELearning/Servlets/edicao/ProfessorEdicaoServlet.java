/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.Servlets.edicao;

import ELearning.services.client.professor.Professor;
import ELearning.services.client.professor.ProfessorService;
import ELearning.services.client.professor.ProfessorService_Service;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ProfessorEdicaoServlet", urlPatterns = {"/ProfessorEdicao"})
public class ProfessorEdicaoServlet extends HttpServlet {

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
            out.println("<title>Servlet ProfessorEdicaoServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfessorEdicaoServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            Professor professor = new Professor();
            Professor oldProfessor = (Professor)request.getSession().getAttribute("editUser");
            professor.setIdUsuario(oldProfessor.getIdUsuario());
            professor.setLogin((String)request.getParameter("loginProfessor"));
            professor.setSenha((String)request.getParameter("senhaProfessor"));
            professor.setEndereco((String)request.getParameter("enderecoProfessor"));
            professor.setTelefone((String)request.getParameter("telefoneProfessor"));
            professor.setTipoUsuario(oldProfessor.getTipoUsuario());
            ProfessorService_Service service = new ProfessorService_Service();
            ProfessorService port = service.getProfessorServicePort();

            if(port.editarProfessor(oldProfessor,professor) != null){
                out.println("Sucesso<br/><br/><a href='/ELearning/admin/adminUI.jsp'>Voltar</a>");
            }else{
                out.println("Erro<br/><br/><a href='/ELearning/admin/adminUI.jsp'>Voltar</a>");
            }
            request.getSession().removeAttribute("editUser");
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

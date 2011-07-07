/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.Servlets.edicao;

import ELearning.services.client.aluno.Aluno;
import ELearning.services.client.aluno.AlunoService;
import ELearning.services.client.aluno.AlunoService_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Acessa SP
 */
@WebServlet(name = "AlunoEdicaoServlet", urlPatterns = {"/AlunoEdicao"})
public class AlunoEdicaoServlet extends HttpServlet {

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
            out.println("<title>Servlet AlunoEdicaoServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AlunoEdicaoServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            Aluno aluno = new Aluno();
            Aluno oldAluno = (Aluno)request.getSession().getAttribute("editUser");
            aluno.setIdUsuario(oldAluno.getIdUsuario());
            aluno.setLogin((String)request.getParameter("loginAluno"));
            aluno.setSenha((String)request.getParameter("senhaAluno"));
            aluno.setEndereco((String)request.getParameter("enderecoAluno"));
            aluno.setTelefone((String)request.getParameter("telefoneAluno"));
            aluno.setTipoUsuario(oldAluno.getTipoUsuario());
            AlunoService_Service service = new AlunoService_Service();
            AlunoService port = service.getAlunoServicePort();

            if(port.editarAluno(oldAluno,aluno) != null){
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.Servlets.consulta;

import ELearning.services.client.professor.Usuario;
import ELearning.services.client.disciplina.Disciplina;
import ELearning.services.client.disciplina.DisciplinaService;
import ELearning.services.client.disciplina.DisciplinaService_Service;
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
@WebServlet(name = "DisciplinaPesquisaServlet", urlPatterns = {"/DisciplinaPesquisa"})
public class DisciplinaPesquisaServlet extends HttpServlet {

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
            out.println("<title>Servlet DisciplinaPesquisaServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DisciplinaPesquisaServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            Disciplina disciplina = new Disciplina();
            disciplina.setIdDisciplina(Long.parseLong((String)request.getParameter("idDisciplinaEdicao")));
            DisciplinaService_Service service = new DisciplinaService_Service();
            DisciplinaService port = service.getDisciplinaServicePort();

            List<Disciplina> lista = port.procurarDisciplina(disciplina);

            Disciplina discipline = null;
            if(lista.size() > 0)
                discipline = (Disciplina)lista.get(0);

            if(discipline != null){
                request.setAttribute("editDiscipline", discipline);
                RequestDispatcher r = request.getRequestDispatcher("/professor/editDiscipline.jsp");
                r.forward(request, response);
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

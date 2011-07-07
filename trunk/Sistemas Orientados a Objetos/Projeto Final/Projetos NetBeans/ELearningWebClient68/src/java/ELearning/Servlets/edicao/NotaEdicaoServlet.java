/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ELearning.Servlets.edicao;

import ELearning.services.client.nota.Nota;
import ELearning.services.client.nota.NotaService;
import ELearning.services.client.nota.NotaService_Service;
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
@WebServlet(name = "NotaEdicaoServlet", urlPatterns = {"/NotaEdicao"})
public class NotaEdicaoServlet extends HttpServlet {

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
            out.println("<title>Servlet NotaEdicaoServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NotaEdicaoServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            Nota nota = new Nota();
            Nota oldNota = (Nota)request.getSession().getAttribute("editGrade");
            nota.setIdNota(oldNota.getIdNota());
            nota.setNotaCriterio(Float.parseFloat((String)request.getParameter("notaCriterio")));
            nota.setIdCriterion(oldNota.getIdCriterion());
            nota.setIdMatricula(oldNota.getIdMatricula());
            NotaService_Service service = new NotaService_Service();
            NotaService port = service.getNotaServicePort();

            if(port.editarNota(oldNota,nota) != null){
                out.println("Sucesso<br/><br/><a href='/ELearning/professor/professorUI.jsp'>Voltar</a>");
            }else{
                out.println("Erro<br/><br/><a href='/ELearning/professor/professorUI.jsp'>Voltar</a>");
            }
            request.getSession().removeAttribute("editGrade");
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

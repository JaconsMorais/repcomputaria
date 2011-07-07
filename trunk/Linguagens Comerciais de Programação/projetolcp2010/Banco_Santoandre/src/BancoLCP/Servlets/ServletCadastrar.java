/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BancoLCP.Servlets;

import BancoLCP.Conta.Cliente;
import BancoLCP.DAO.OpFuncDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Thales
 */
public class ServletCadastrar extends HttpServlet {
   
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
            out.println("<title>Servlet ServletCadastrar</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletCadastrar at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
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
        
        if(request.getParameter("senha").toString().equals(request.getParameter("confirma_senha").toString())){
        try {
            OpFuncDAO DAOCadastro = new OpFuncDAO();
            Cliente newUser = new Cliente();
            newUser.setCpf((long)Integer.parseInt((String)request.getParameter("cpf")));
            newUser.setEnd((String)request.getParameter("endereco"));
            newUser.setName((String)request.getParameter("nome"));
            newUser.setPassword((String)request.getParameter("senha"));
            DAOCadastro.insert(newUser, "Cliente");
            response.sendRedirect("sucesso.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(ServletCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BancoLCP.Servlets;

import BancoLCP.Conta.Cliente;
import BancoLCP.DAO.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
public class ServletLogin extends HttpServlet {
   
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
            out.println("<title>Servlet ServletLogin</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletLogin at " + request.getContextPath () + "</h1>");
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

        String URL_Redir;

        try {

            URL_Redir = "menu.jsp";

            ClienteDAO DAOLogin = new ClienteDAO();
            ResultSet rsc = (ResultSet) DAOLogin.ValidaLogin((long)Integer.parseInt(request.getParameter("id").toString()),request.getParameter("senha").toString(),"Cliente");
            if(!rsc.wasNull()){
                 request.setAttribute("ID",rsc.getString("id"));
                 request.setAttribute("nome",rsc.getString("nome"));
                 request.setAttribute("endereco",rsc.getString("endereco"));
                 request.setAttribute("cpf",rsc.getString("cpf"));
                 request.setAttribute("saldo",rsc.getString("saldo"));
                 request.setAttribute("tipo","Cliente");
            }else{
                 ResultSet rsf = (ResultSet) DAOLogin.ValidaLogin((long)Integer.parseInt(request.getParameter("id").toString()),request.getParameter("senha").toString(),"Funcionário");
                 if(!rsf.wasNull()){
                     request.setAttribute("ID",rsf.getString("id"));
                     request.setAttribute("nome",rsf.getString("nome"));
                     request.setAttribute("endereco",rsf.getString("endereco"));
                     request.setAttribute("cpf",rsf.getString("cpf"));
                     request.setAttribute("tipo","Funcionário");
                 }else URL_Redir = "erro.jsp";
            }

            response.sendRedirect(URL_Redir);

        } catch (SQLException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
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

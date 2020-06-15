/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import datapack.Allotmentqueue;
import datapack.Professionals;
import dataservices.Allotmentqueueservices;
import dataservices.Professionalservices;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(name = "NewProfApprovalServlet", urlPatterns = {"/NewProfApprovalServlet"})
public class NewProfApprovalServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
            String id = request.getParameter("value");
            String approve=request.getParameter("approve");
            Allotmentqueue aq = new Allotmentqueue();
            Allotmentqueueservices aqserv = new Allotmentqueueservices();
            Professionals prof=new Professionals();
            Professionalservices profserv=new Professionalservices();
            prof=profserv.getProfessinalsById(id);
        try{
            /* TODO output your page here. You may use following sample code. */
            
            
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv","root","Suruchi@2001");
            PreparedStatement ps;
            if(approve.equals("1"))
            {
                String sql="Update professionals set register='true' where id="+id;
                ps = conn.prepareStatement(sql);
                int i = ps.executeUpdate();
                
                aq.setProfessional_id(prof.getid());
                aq.setService_id(prof.getservice_id());
                aqserv.push(aq);
            }
            else if(approve.equals("0"))
            {
                String sql="DELETE FROM professionals WHERE id="+id;
                ps = conn.prepareStatement(sql);
                int i = ps.executeUpdate();
            }
            
                ServletContext context = getServletContext();
                RequestDispatcher dispatcher = context.getRequestDispatcher("/NewProfessionalsApplications");
                dispatcher.forward(request,response);
                
            
        }catch(Exception e)
        {
            out.println("Error "+e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

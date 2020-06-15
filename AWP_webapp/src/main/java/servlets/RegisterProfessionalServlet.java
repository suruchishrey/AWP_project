/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import datapack.Allotmentqueue;
import dataservices.Allotmentqueueservices;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(name = "RegisterProfessionalServlet", urlPatterns = {"/RegisterProfServlet"})
public class RegisterProfessionalServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
                String name = request.getParameter("name");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String mobilenumber = request.getParameter("mobilenumber");
                String profession = request.getParameter("profession");
                String agree = request.getParameter("agree");
                String gender = request.getParameter("gender");
                String service_id=request.getParameter("service_id");
                String registervar="false";
                String status="free";
                String rating="0";
                out.println("professionlid=");
            try {
                Class.forName("com.mysql.jdbc.Driver");
            
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv","root","Suruchi@2001");
                PreparedStatement ps;
                    
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery("select count(*) from professionals");
                    rs.next();
                    //int totalrows=rs.getInt("count(*)");
                    
                    String sql="insert into professionals(username,name,password,profession,email,mob_no,address,gender,register,status,rating,service_id) values(?,?,?,?,?,?,?,?,?,?,?,?)";
                    
                    ps = conn.prepareStatement(sql);
                    ps.setString(1,username);
                    ps.setString(2,name);
                    ps.setString(3,password);
                    ps.setString(4,profession);
                    ps.setString(5, email);
                    ps.setString(6, mobilenumber);
                    ps.setString(7, address);
                    ps.setString(8, gender);
                    ps.setString(9, registervar);
                    ps.setString(10,status);
                    ps.setString(11,rating);
                    ps.setString(12,service_id);
                    int i = ps.executeUpdate();
                    if(i > 0 || i!=0)
                    {
                    request.setAttribute("success_message","Wait for some hours then login again,you will be able to login once you are registered!");
                    request.getRequestDispatcher("/indexuser.jsp").forward(request, response);
                    }
                    else
                    {
                    out.println("There is a problem in your registration.");
                    }
               } catch (ClassNotFoundException ex) {
                   out.println(ex.getMessage());
                Logger.getLogger(RegisterProfessionalServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                
                out.println(ex.getMessage());
                Logger.getLogger(RegisterProfessionalServlet.class.getName()).log(Level.SEVERE, null, ex);
            } 
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

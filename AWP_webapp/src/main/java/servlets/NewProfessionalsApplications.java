/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import datapack.Professionals;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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
@WebServlet(name = "NewProfessionalsApplications", urlPatterns = {"/NewProfessionalsApplications"})
public class NewProfessionalsApplications extends HttpServlet {

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
            ArrayList<Professionals> proflist  = new ArrayList<Professionals>();
            try{
            Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proserv","root","Suruchi@2001");
                String sql = "SELECT * FROM professionals where register='false';";
                Statement pstmt = conn.createStatement();
                ResultSet rs = pstmt.executeQuery(sql);
                while(rs.next())
                {   
                    
                    Professionals prof = new Professionals();
                       prof.setid(Integer.parseInt(rs.getString(1)));
                       prof.setname(rs.getString(2));
                       prof.setusername(rs.getString(3));
                       prof.setprofession(rs.getString(5));
                       prof.setemail(rs.getString(6));
                       prof.setmob_no(rs.getString(7));
                       prof.setaddress(rs.getString(8));
                       prof.setgender(rs.getString(9));
                       prof.setstatus(rs.getString(10));
                       prof.setrating(rs.getString(11));
                       prof.setsalary(rs.getString(12));
                       prof.settotal_services(rs.getString(13));
                       prof.setservice_id(Integer.parseInt(rs.getString(15)));
                    proflist.add(prof);
                   
                }
                request.setAttribute("proflist", proflist);
                ServletContext context = getServletContext();
                RequestDispatcher dispatcher = context.getRequestDispatcher("/newprofdetails.jsp");
                dispatcher.forward(request,response);
                
            }
            catch(Exception e)
            {
                out.println("Exception is "+e.getMessage());
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

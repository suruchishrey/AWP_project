/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import datapack.Professionals;
import dataservices.Professionalservices;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(name = "updateProfDetails", urlPatterns = {"/updateProfDetails"})
public class updateProfDetails extends HttpServlet {

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
            
                String id=request.getParameter("id");
                String name=request.getParameter("name");
                String username=request.getParameter("username");
                String password=request.getParameter("password");
                String profession=request.getParameter("profession");
                String email=request.getParameter("email");
                String mob_no=request.getParameter("mob_no");
                String address=request.getParameter("address");
                String gender=request.getParameter("gender");
                String status=request.getParameter("status");
                Professionals prof=new Professionals();
                prof.setid(Integer.parseInt(id));
                prof.setname(name);
                prof.setusername(username);
                prof.setpassword(password);
                prof.setprofession(profession);
                prof.setemail(email);
                prof.setmob_no(mob_no);
                prof.setaddress(address);
                prof.setgender(gender);
                prof.setstatus(status);
                Professionalservices profserv = new Professionalservices();
                    if( profserv.UpdateDetails(prof))
                    {
                    request.setAttribute("value",id );
                    request.getRequestDispatcher("professionalHomePage.jsp").forward(request, response);
                    }
                    else
                    {
                    out.print("<h1>There is a problem in updating Record.</h1>");
                    }
                //}
                
        }
        catch(Exception e)
        {
            e.printStackTrace();
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

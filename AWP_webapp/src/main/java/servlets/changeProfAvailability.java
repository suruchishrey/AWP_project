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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(name = "changeProfAvailability", urlPatterns = {"/changeProfAvailability"})
public class changeProfAvailability extends HttpServlet {

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
       
            /* TODO output your page here. You may use following sample code. */
            String value = request.getParameter("value");
            String currentstatus;
            Allotmentqueue aq = new Allotmentqueue();
            Allotmentqueueservices aqserv = new Allotmentqueueservices();
            Professionals prof=new Professionals();
            Professionalservices profserv=new Professionalservices();
            prof=profserv.getProfessinalsById(value);
            aq.setProfessional_id(prof.getid());
            aq.setService_id(prof.getservice_id());
            request.setAttribute("value", value);
            try{
                currentstatus=profserv.changeAvailability(Integer.parseInt(value));
                
                
                    if(currentstatus.equals("busy"))
                    {
                        request.setAttribute("message","Availability status changed from FREE TO BUSY");
                        //out.print("aq.serviceid="+Integer.toString(aq.getService_id())+"aq.profid="+Integer.toString(aq.getProfessional_id()));
                        aqserv.pop(aq);
                    }
                    else if(currentstatus.equals("free"))
                    {
                        request.setAttribute("message","Availability status changed from BUSY TO FREE");
                        aqserv.push(aq);
                    }
                
                request.getRequestDispatcher("/professionalHomePage.jsp").forward(request, response);
            }
            catch(Exception e)
            {
                out.println(e.getMessage());
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

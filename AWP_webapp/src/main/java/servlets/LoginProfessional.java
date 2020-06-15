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
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Suruchi
 */
@WebServlet(name = "LoginProfessional", urlPatterns = {"/loginprof_servlet"})
public class LoginProfessional extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        
            /* TODO output your page here. You may use following sample code. */
            String name=request.getParameter("name");
            String password=request.getParameter("pass");
        PrintWriter out = response.getWriter();
        Professionalservices profserv=new Professionalservices();
        Professionals prof;
        prof=profserv.login(name, password);
        ServletContext context = getServletContext();
        
        if(prof!=null)
        {
           
            HttpSession session = request.getSession();
            session.setAttribute("username", name);
            session.setAttribute("current", "professional");
            /*Cookie ck=new Cookie("name",name);
            response.addCookie(ck);*/
            String id;
            id = Integer.toString(prof.getid()) ;
            session.setAttribute("current_id",id);
            request.setAttribute("value",id );
            request.setAttribute("prof_id",Integer.parseInt(id) );
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Profileservlet");
                dispatcher.forward(request, response);
        dispatcher.forward(request, response);
        }
        else{
            request.setAttribute("message","login Unsuccessful try again");
             RequestDispatcher dispatcher = context.getRequestDispatcher("/indexProfessional.jsp");
               dispatcher.forward(request,response);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import dataservices.Userservices;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dataservices.Packageservices;
import java.util.ArrayList;
import datapack.Packages;
import datapack.Services;
import datapack.Users;
import dataservices.Serviceservices;
/**
 *
 * @author kumar
 */
public class userloginservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     * 
     * 
     */
    
    Packageservices pserv = new Packageservices();
    ArrayList<Packages> packlist = new ArrayList<Packages>();
    
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Users u=new Users();
         Userservices ud = new Userservices();
        
        String name = request.getParameter("name");
        String password = request.getParameter("pass");
        
        ServletContext context = getServletContext();
        
        PrintWriter out=response.getWriter();
        
        if(ud.login(name,password))
        {
           
            HttpSession session = request.getSession(true);
            session.setAttribute("username", name);
            session.setMaxInactiveInterval(30*60);
            session.setAttribute("current", "user");
            u=ud.getUsersByName(name);
            request.setAttribute("user_id", u.getid());
            
            String id = request.getParameter("value");
            session.setAttribute("current_id", id);
            if(!id.equals("0"))
            {  
                if(session.getAttribute("previous").toString().equals("bookingPage"))
                {
                    Services s = new Services();

                Serviceservices serv = new Serviceservices(); 


                request.setAttribute("service_id", id);
                s = serv.getServicesByServiceId(id);

                request.setAttribute("serv", s);
                    if(s==null)out.println("serv is null");
                    else{
                    RequestDispatcher dispatcher = context.getRequestDispatcher("/confirmbooking.jsp");
                   dispatcher.forward(request,response);}
                }
            }
            else{
                
 
           RequestDispatcher dispatcher = context.getRequestDispatcher("/userhomepage.jsp");
               dispatcher.forward(request,response);
            }
        
        }
        else
        {
             request.setAttribute("message","login Unsuccesfull try again");
             RequestDispatcher dispatcher = context.getRequestDispatcher("/indexuser.jsp");
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

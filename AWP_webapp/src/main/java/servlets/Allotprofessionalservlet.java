/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import datapack.Allotmentqueue;
import datapack.Orders;
import dataservices.Professionalservices;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dataservices.Allotmentqueueservices;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import datapack.Professionals;
import datapack.Services;
import datapack.Users;
import dataservices.Ordersservices;
import dataservices.Serviceservices;
import dataservices.Userservices;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kumar
 */
public class Allotprofessionalservlet extends HttpServlet {

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
        PrintWriter out=response.getWriter();
        Allotmentqueue aq = new Allotmentqueue();
        Professionals prof = new Professionals();
        Services serv  = new Services();
        Ordersservices oserv=new Ordersservices();
        Orders order=new Orders();
        Users u=new Users();
        Userservices userv=new Userservices();
       
        Allotmentqueueservices aqserv = new Allotmentqueueservices();
        Professionalservices pserv = new Professionalservices();
        Serviceservices sserv = new Serviceservices();
        String service_id = request.getParameter("value");
        
        
         aq = aqserv.getTopProfessinal(service_id);
         int prof_id = aq.getProfessional_id();
         int salary;
         int user_id;
         int num_services;
         serv =sserv.getServicesByServiceId(service_id);
         request.setAttribute("serv",serv);
         
         if(aq!=null && prof_id!=0)
         {    

            
             aqserv.pop(aq);
             
             HttpSession session = request.getSession();
             String user=session.getAttribute("username").toString();
             u=userv.getUsersByName(user);
             user_id=u.getid();
             prof = pserv.getProfessinalsById(Integer.toString(prof_id));
             
             salary = Integer.parseInt(prof.getsalary())+ serv.getPrice() ;
             num_services = Integer.parseInt(prof.gettotal_services()) + 1;
             pserv.updateProfStats(Integer.toString(prof_id),Integer.toString(salary),Integer.toString(num_services));
             
            request.setAttribute("prof",prof );
            order.setProfessional_id(prof_id);
            order.setUser_id(user_id);
            order.setService_id(Integer.parseInt(service_id));
            oserv.push(order);

             ServletContext context = getServletContext();
             RequestDispatcher dispatcher = context.getRequestDispatcher("/bookingreceipt.jsp");
             dispatcher.forward(request,response);

         }
         else
         {   
             
             request.setAttribute("error_message","Sorry!,Currently no professional is free");
             ServletContext context = getServletContext();
             RequestDispatcher dispatcher = context.getRequestDispatcher("/confirmbooking.jsp");
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

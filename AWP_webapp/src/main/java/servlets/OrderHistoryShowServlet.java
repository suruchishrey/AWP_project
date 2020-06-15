/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import datapack.Orders;
import datapack.Professionals;
import datapack.Services;
import datapack.Users;
import dataservices.Ordersservices;
import dataservices.Professionalservices;
import dataservices.Serviceservices;
import dataservices.Userservices;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dell
 */
@WebServlet(name = "OrderHistoryShowServlet", urlPatterns = {"/OrderHistoryShowServlet"})
public class OrderHistoryShowServlet extends HttpServlet {

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
        
            /* TODO output your page here. You may use following sample code. */
            PrintWriter out = response.getWriter();
            
            ArrayList<Orders>OrdersList=new ArrayList<Orders>();
            ArrayList<Professionals>proflist=new ArrayList<Professionals>();
            ArrayList<Services>servlist=new ArrayList<Services>();
            ArrayList<Users>userlist=new ArrayList<Users>();
            HttpSession session = request.getSession(true);
            Users u=new Users();
            Userservices userv=new Userservices();
            Professionals prof=new Professionals();
            Professionalservices profserv=new Professionalservices();
            Orders order=new Orders();
            Ordersservices oserv=new Ordersservices();
            Services serv=new Services();
            Serviceservices sserv= new Serviceservices(); 
            
            String current=session.getAttribute("current").toString();
            int id;
            String name;
            String destpage="/OrdersHistoryInfo.jsp";
            
            if(current.equals("user"))
            {
                name=session.getAttribute("username").toString();
                u=userv.getUsersByName(name);
                id=u.getid();
                OrdersList.clear();
                OrdersList=oserv.getOrdersByUserId(id);
                for(Orders o:OrdersList)
                {
                    prof=profserv.getProfessinalsById(Integer.toString(o.getProfessional_id()));
                    proflist.add(prof);
                    serv=sserv.getServicesByServiceId(Integer.toString(o.getService_id()));
                    servlist.add(serv);
                }
                request.setAttribute("proflistorder", proflist);
                request.setAttribute("servlistorder", servlist);
                destpage="/usersOrders.jsp";
            }
            else if(current.equals("professional"))
            {
                name=session.getAttribute("username").toString();
                prof=profserv.getProfessionalsByName(name);
                id=prof.getid();
                OrdersList.clear();
                OrdersList=oserv.getOrdersByProfId(id);
                for(Orders o:OrdersList)
                {
                    u=userv.getUsersById(Integer.toString(o.getUser_id()));
                    userlist.add(u);
                    serv=sserv.getServicesByServiceId(Integer.toString(o.getService_id()));
                    servlist.add(serv);
                }
                request.setAttribute("servlistorder", servlist);
                request.setAttribute("userlistorder", userlist);
                destpage="/profsOrders.jsp";
            }
            else if(current.equals("admin"))
            {
                OrdersList.clear();
                OrdersList=oserv.getOrdersList();
                for(Orders o:OrdersList)
                {
                    u=userv.getUsersById(Integer.toString(o.getUser_id()));
                    userlist.add(u);
                    prof=profserv.getProfessinalsById(Integer.toString(o.getProfessional_id()));
                    proflist.add(prof);
                    serv=sserv.getServicesByServiceId(Integer.toString(o.getService_id()));
                    servlist.add(serv);
                }
                request.setAttribute("servlistorder", servlist);
                request.setAttribute("proflistorder", proflist);
                request.setAttribute("userlistorder", userlist);
            }
            //request.setAttribute("OrdersList", OrdersList);
            ServletContext context = getServletContext();
             RequestDispatcher dispatcher = context.getRequestDispatcher(destpage);
             dispatcher.forward(request,response);
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

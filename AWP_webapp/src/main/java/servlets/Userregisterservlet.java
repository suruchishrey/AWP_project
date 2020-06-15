/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datapack.Users;
import dataservices.Userservices;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 *
 * @author kumar
 */
public class Userregisterservlet extends HttpServlet {

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
        
       
        Users user = new Users();
        Userservices userv = new Userservices();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String mob_no = request.getParameter("mob_no");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        
        user.setname(username);
        user.setpassword(password);
        user.setemail(email);
        user.setmob_no(mob_no);
        user.setaddress(address);
        user.setgender(gender);
        
        
        
            if(!userv.register_user(user).equals("true"))
            {
                request.setAttribute("error_message",userv.register_user(user));
                request.getRequestDispatcher("/userSignUp.jsp").forward(request, response);
            }
            else
            {
                request.setAttribute("success_message","registered successfully please login");
                request.getRequestDispatcher("/indexuser.jsp").forward(request, response);
            
            }    
        
        
        
        
        
        
        
        
                 
        
                 
        request.setAttribute("success_message","Successfully registered");
        request.getRequestDispatcher("/result.jsp").forward(request, response);
         
               
           
                   
          
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

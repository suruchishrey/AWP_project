/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import datapack.Services;
import dataservices.Serviceservices;
/**
 *
 * @author kumar
 */
public class fileuploadservlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     */
    private final String UPLOAD_DIRECTORY = "C:\\Users\\kumar\\Desktop\\mywork\\AWP_project\\AWP_webapp\\src\\main\\webapp\\images";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
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
    Services serv = new Services();
    Serviceservices s = new Serviceservices();
    ArrayList<String> l = new ArrayList<String>();
    
    String package_id = request.getParameter("package_id");
    String message = " ";
        
        String name="";
        String path=" ";
        if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);
               
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        name = new File(item.getName()).getName();
                        path = new File(item.getName()).getAbsolutePath();
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                    }
                    else{
                        
                        String service_name = item.getFieldName();
                        String service_value = item.getString();           
                        l.add(service_value);
                    }
                }
                
                
                    serv.setName(l.get(0));
                    serv.setPrice(Integer.parseInt(l.get(1)));
                    serv.setDescription(l.get(2));
                    serv.setImage_url("images/"+name);
                    serv.setPackage_id(Integer.parseInt(package_id));
                    
                    if(s.register_service(serv))
                    {
                        message = "added sucessfully new service";
                    }
                    else
                    {
                        message = "failed";
                    }
                    
                
            
               
               //File uploaded successfully
               request.setAttribute("message",message);
                
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }          
          
        }else{
            request.setAttribute("message",
                                 "Sorry this Servlet only handles file upload request");
        }
     
        request.getRequestDispatcher("/addnewservice.jsp").forward(request, response);
      
    }        
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    


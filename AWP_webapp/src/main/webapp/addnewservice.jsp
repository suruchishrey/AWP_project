<%-- 
    Document   : welcome.
    Created on : 13-Apr-2020, 1:00:55 PM
    Author     : kumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:include page="header.jsp"/> 
        
<style>
         #package_head{
    
        border-radius: 5px;
        text-align: center;
    
    }
</style>    

        <br>
        <br>
        <div class="container">
            <%
                String package_id = request.getParameter("package_id");
            %>
            
            
            
            <div class="p-3 bg-secondary text-white" id="package_head">
                <h4>Service Details</h4>
            </div>
    
            <form action="fileuploadservlet?package_id=<%=package_id%>" method="post" enctype="multipart/form-data">
                
                 <div class="form-group">
                    <label for="service_name">Service Name:</label>
                    <input type="text" id="service_name" class="form-control" placeholder="Enter Name" name="service_name">
                 </div>
                 <div class="form-group">
                    <label for="pwd">Price:</label>
                    <input type="text" class="form-control" id="pwd" placeholder="Enter price" name="price">
                 </div>
                 <div class="form-group">
                    <label for="des">Description:</label>
                    <input type="text" class="form-control" id="des" placeholder="Enter Description" name="description">
                 </div>
                
                <div class="form-group"> 
                    <label for="servfile">Service image:</label>
                    <input type="file" id="servfile" name="file" />
                </div>    
                
                 <button type="submit" class="btn btn-primary">Add Service</button>
            </form>   
            
        </div>
        <br>
        
        <%if(request.getAttribute("message")!=null){%>   
         <div class="alert alert-info">${message}</div>
        <%}%>
        
     <jsp:include page="footer.jsp"/> 
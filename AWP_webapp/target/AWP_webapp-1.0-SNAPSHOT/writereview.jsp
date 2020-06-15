<%-- 
    Document   : writereview
    Created on : 25-May-2020, 9:39:57 PM
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
           
            
            <div class="p-3 bg-secondary text-white" id="package_head">
                <h5>Feedback Form</h5>
            </div>
    
            <form action="Reviewservlet" method="post" >
                
                 <div class="form-group">
                    <label for="service_name">Name:</label>
                    <input type="text" id="service_name" class="form-control" placeholder="Enter Name" name="name">
                 </div>
                 <div class="form-group">
                     <label for="pwd">Your comment:</label><br>
                     <textarea name="comment" rows="5" cols="50"></textarea>
                 </div>
                 <div class="form-group">
                    <label for="rate">Rating:</label>
                  
                    <select name="rating" id="rate">
                      <option value="1">poor</option>
                      <option value="2">bad</option>
                      <option value="3">average</option>
                      <option value="4">good</option>
                      <option value="5">excellent</option>
                    </select>
                 </div>
                 <button type="submit" class="btn btn-primary">Submit</button>
            </form>   
            <br>
        
        <%if(request.getAttribute("message")!=null){%>   
         <div class="alert alert-info">${message}</div>
         <a class="btn btn-info" href='/AWP_webapp/Listreviewservlet'>View Reviews</a>
        <%}%>
        
        </div>
        
<jsp:include page="footer.jsp"/>
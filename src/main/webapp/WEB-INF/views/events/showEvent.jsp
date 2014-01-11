<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <div class="span9">
          <div>
            <h1>Hello, world!</h1>
            <p>My Events.</p>
            <p></p>
          </div>
          <div class="row-fluid">
          
            <c:if test="${message == 'fail'}">
                <div class="alert alert-error">
                    <button class="close" title="close" type="button">×</button>
                    Not able to show event.
                    <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                        Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
                    </c:if>
                </div>
            </c:if>           
          
             <form id="create" class="form-horizontal" >
                <legend>Event</legend>       
                
                <div class="control-group">
                    <label class="control-label">Owner Name</label>
                    <div class="controls">
                        <div class="input-prepend">
                        <span class="add-on"><i class="icon-envelope"></i></span>
                        <input type="text" class="input-xlarge" id="oname" value="<c:out value="${event.snaAccount1.firstName} ${event.snaAccount1.lastName}" />" disabled />                           
                        </div>
                                               
                    </div>  
                </div>
                
                <div class="control-group">
                    <label class="control-label">Attendee Name</label>
                    <div class="controls">
                        <div class="input-prepend">
                        <span class="add-on"><i class="icon-envelope"></i></span>
                        <input type="text" class="input-xlarge" id="aname" value="<c:out value="${event.snaAccount2.firstName} ${event.snaAccount2.lastName}" />" disabled />    
                        </div>
                                               
                    </div>  
                </div>
                
                <div class="control-group">
                    <label class="control-label">Event Date (yyyy/MM/dd)</label>
                    <div class="controls">
                        <div class="input-prepend">
                        <span class="add-on"><i class="icon-time"></i></span>
                        <fmt:formatDate value="${event.eventWhen}" type="both" pattern="dd/MM/yyyy" var="when"/>   
                        <input type="text" class="input-xlarge" id="date" value="<c:out value="${when}" />" disabled />                    
                        </div>
                        
                    </div>  
                </div>
                <div class="control-group ">
                    <label class="control-label">Summary</label>
                    <div class="controls">
                        <div class="input-prepend">
                        <span class="add-on"><i class="icon-envelope"></i></span>                                 
                            <input type="text" class="input-xlarge" id="summary" value="<c:out value="${event.summary}" />" disabled />                  
                        </div>
                        
                    </div>
                </div>
                
                <div class="control-group ">
                    <label class="control-label">Description</label>
                    <div class="controls">
                        <div class="input-prepend">
                        <span class="add-on"><i class="icon-envelope"></i></span>
                            <textarea path="description" class="input-xlarge" id="Description" rows="5" cols="25" disabled>${event.description}</textarea>                     
                        </div>
                        
                    </div>
                </div>
                               
                           
              </form>
              
           </div><!--/row-->
        </div><!--/span-->
   
     

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

      <div class="span9">
          <div>
            <h1>Hello, world!</h1>
            <p>Create events for yourself.</p>
            <p></p>
          </div>
          <div class="row-fluid">
          
            <c:if test="${eventAdded == 'fail'}">
		        <div class="alert alert-error">
		            <button class="close" title="close" type="button">×</button>
		            Event creation failed.
		            <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
		                Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
		            </c:if>
		        </div>
		    </c:if>
		    <c:if test="${eventAdded == 'success'}">
		        <div class="alert alert-success">
		            <button class="close"  title="close" type="button">×</button>
		            Event created successfully
		        </div>
		    </c:if>
          	
             <form:form id="create" class="form-horizontal" method="post" action="create" commandName="createEvent">
				<legend>Create Event</legend>		
				
				<div class="control-group">
			        <label class="control-label">Attendee Email</label>
					<div class="controls">
					    <div class="input-prepend">
						<span class="add-on"><i class="icon-envelope"></i></span>
							<form:input type="text" path="attendeeEmail" class="input-xlarge" id="email" placeholder="Email" />
						</div>
						<form:errors path="attendeeEmail" cssClass="alert alert-error" />						
					</div>	
				</div>
				
				<div class="control-group">
			        <label class="control-label">Event Date (yyyy/MM/dd)</label>
					<div class="controls">
					    <div class="input-prepend">
						<span class="add-on"><i class="icon-time"></i></span>
							<form:input type="text" autocomplete="off" path="when" class="input-xlarge" id="when" placeholder="yyyy/MM/dd" />					
						</div>
						<form:errors path="when" cssClass="alert alert-error" />
					</div>	
				</div>
				<div class="control-group ">
			        <label class="control-label">Summary</label>
					<div class="controls">
					    <div class="input-prepend">
						<span class="add-on"><i class="icon-envelope"></i></span>
							<form:input type="text" path="summary" class="input-xlarge" id="Summary" placeholder="Summary" />					
						</div>
						<form:errors path="summary" cssClass="alert alert-error" />
					</div>
				</div>
				
				<div class="control-group ">
			        <label class="control-label">Description</label>
					<div class="controls">
					    <div class="input-prepend">
						<span class="add-on"><i class="icon-envelope"></i></span>
							<form:textarea path="description" class="input-xlarge" id="Description" placeholder="Description" rows="5" cols="25" />					
						</div>
						<form:errors path="description" cssClass="alert alert-error" />
					</div>
				</div>
								
				<div class="control-group">
				<label class="control-label" for="input01"></label>
			      <div class="controls">
			       <button type="submit" class="btn btn-success" rel="tooltip" title="first tooltip">Create Event</button>
			       
			      </div>
			
			</div>
			
			  </form:form>
			  
		   </div><!--/row-->
        </div><!--/span-->
  
     

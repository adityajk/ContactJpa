<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:message code="label.newPassword" var="labelNewPassword" />
<spring:message code="label.confirmPassword" var="labelConfirmPassword" />
<spring:message code="label.currPassword" var="labelCurrentPassword" />
      <div class="span9">
          <div>            
            <p>Personal Profile</p>
            <p></p>
          </div>
          <div class="row-fluid">
          
             <c:if test="${passUpdated == 'fail'}">
		        <div class="alert alert-error">
		            <button class="close" title="close" type="button">×</button>
		            Password updation failed.
		            <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
		                Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
		            </c:if>
		        </div>
		    </c:if>
		    <c:if test="${passUpdated == 'success'}">
		        <div class="alert alert-success">
		            <button class="close"  title="close" type="button">×</button>
		            Password updated successfully
		        </div>
		    </c:if>
          	
             <form:form id="updatePass" class="form-horizontal" method="post" action="changePassword" commandName="updatePassword">
				<legend>Change Password</legend>		
				
				<div class="control-group">
			        <label class="control-label">${labelCurrentPassword}</label>
					<div class="controls">
					    <div class="input-prepend">
						<span class="add-on"><i class="icon-lock"></i></span>
							<form:input type="Password" id="currPasswd" class="input-xlarge" path="currentPassword" placeholder="${labelCurrentPassword}"/>					
						</div>
						<form:errors path="currentPassword" cssClass="alert alert-error" />
					</div>
				</div>
				
				<div class="control-group">
			        <label class="control-label">${labelNewPassword}</label>
					<div class="controls">
					    <div class="input-prepend">
						<span class="add-on"><i class="icon-lock"></i></span>
							<form:input type="Password" id="newPasswd" class="input-xlarge" path="newPassword" placeholder="${labelNewPassword}"/>					
						</div>
						<form:errors path="newPassword" cssClass="alert alert-error" />
					</div>
				</div>
				<div class="control-group">
			        <label class="control-label">${labelConfirmPassword}</label>
					<div class="controls">
					    <div class="input-prepend">
						<span class="add-on"><i class="icon-lock"></i></span>
							<form:input type="Password" id="conpasswd" class="input-xlarge" path="confirmPassword" placeholder="${labelConfirmPassword}"/>
						</div>
					</div>
				</div>
				
								
				<div class="control-group">
					<label class="control-label" for="input01"></label>
				      <div class="controls">
				       <button type="submit" class="btn btn-success" rel="Password" title="Change Password">Change Password</button>
				       
				      </div>
			    </div>
			
			  </form:form>
			   
			  
		   </div><!--/row-->
        </div><!--/span-->
  
     

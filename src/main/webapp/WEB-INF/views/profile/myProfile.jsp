<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:message code="label.firstname" var="labelFirstName" />
<spring:message code="label.signup" var="labelSignup" />
<spring:message code="label.lastname" var="labelLastName" />
<spring:message code="label.email" var="labelEmail" />
<spring:message code="label.gender" var="labelGender" />

      <div class="span9">
          <div>            
            <p>Personal Profile</p>
            <p></p>
          </div>
          <div class="row-fluid">
          
             <c:if test="${profileUpdated == 'fail'}">
		        <div class="alert alert-error">
		            <button class="close" title="close" type="button">×</button>
		            Profile updation failed.
		            <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
		                Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
		            </c:if>
		        </div>
		    </c:if>
		    <c:if test="${profileUpdated == 'success'}">
		        <div class="alert alert-success">
		            <button class="close"  title="close" type="button">×</button>
		            Profile updated successfully
		        </div>
		    </c:if>
          	
             <form:form id="myProfile" class="form-horizontal" method="post" action="myProfile" commandName="updateProfile">
				<legend>Personal Profile</legend>		
				
				<div class="control-group">
			        <label class="control-label">${labelFirstName}</label>
					<div class="controls">
					    <div class="input-prepend">
						<span class="add-on"><i class="icon-user"></i></span>
							<form:input type="text" path="firstName" class="input-xlarge" id="fname" placeholder="${labelFirstName}" />					
						</div>
						<form:errors path="firstName" cssClass="alert alert-error" />
					</div>	
				</div>
				<div class="control-group ">
			        <label class="control-label">${labelLastName}</label>
					<div class="controls">
					    <div class="input-prepend">
						<span class="add-on"><i class="icon-user"></i></span>
							<form:input type="text" path="lastName" class="input-xlarge" id="lname" placeholder="${labelLastName}" />					
						</div>
						<form:errors path="lastName" cssClass="alert alert-error" />
					</div>
				</div>
				<div class="control-group">
			        <label class="control-label">${labelEmail}</label>
					<div class="controls">
					    <div class="input-prepend">
						<span class="add-on"><i class="icon-envelope"></i></span>
							<form:input type="text" path="email" class="input-xlarge" id="email" placeholder="${labelEmail}" />
						</div>
						<form:errors path="email" cssClass="alert alert-error" />
						<c:if test="${not empty emailPresent}"><span class="alert alert-error">${emailPresent}</span></c:if>
					</div>	
				</div>
				
				<c:choose>
					<c:when test="${genderValue == 'm' }">
						<c:set value="active" var="mClass"></c:set>
					</c:when>
					<c:when test="${genderValue == 'f' }">
						<c:set value="active" var="fClass"></c:set>
					</c:when>			
					<c:otherwise>
						<c:set value="" var="mClass"></c:set>
						<c:set value="" var="fClass"></c:set>
					</c:otherwise>
				</c:choose>
				<div class="control-group">
			        <label class="control-label">${labelGender}</label>
					<div class="controls">
					        <form:input type="hidden" path="gender" id="gender" value="" />
							<div id="gender" class="btn-group gender" data-toggle="buttons-radio">  
		                    <button type="button" value="m" class="btn btn-info ${mClass}"><spring:message code="label.male" /></button>  
		                    <button type="button" value="f" class="btn btn-info ${fClass}"><spring:message code="label.female" /></button>                     
		                  </div>
		                   <form:errors path="gender" cssClass="alert alert-error" />
		                  
						  
					</div>
				</div>
								
				<div class="control-group">
				<label class="control-label" for="input01"></label>
			      <div class="controls">
			       <button type="submit" class="btn btn-success" rel="tooltip" title="Update Profile">Update Profile</button>
			       
			      </div>
			
			</div>
			
			  </form:form>
			   
			  
		   </div><!--/row-->
        </div><!--/span-->
  
     

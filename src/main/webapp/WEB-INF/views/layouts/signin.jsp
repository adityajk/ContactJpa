<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="well"> 

	<c:if test="${param.error != null}">
		<div class="alert alert-error">
			<button class="close" title="close" type="button">×</button>
			Failed to login.
			<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
				Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
			</c:if>
		</div>
	</c:if>
	<c:if test="${param.logout != null}">
		<div class="alert alert-success">
			<button class="close"  title="close" type="button">×</button>
			You have been logged out
		</div>
	</c:if>
	
      <form id="signin" class="form-horizontal" method="post" action="signin.do">
		<legend>Please Sign In</legend>			
		<div class="control-group">
	        <label class="control-label">Email</label>
			<div class="controls">
			    <div class="input-prepend">
				<span class="add-on"><i class="icon-envelope"></i></span>
					<input type="text" class="input-xlarge" name="email" id="email" placeholder="Email" />
				</div>
				<!--<form:errors path="email" cssClass="alert alert-error" /> -->
			</div>	
		</div>		
		
		<div class="control-group">
	        <label class="control-label">Password</label>
			<div class="controls">
			    <div class="input-prepend">
				<span class="add-on"><i class="icon-lock"></i></span>
					<input type="Password" id="passwd" name="password" class="input-xlarge" path="password" placeholder="Password"/>					
				</div>
				<!--<form:errors path="password" cssClass="alert alert-error" />-->
			</div>
		</div>
		
		<div class="control-group">
	        <label class="control-label"></label>
			<div class="controls">
			    <div class="input-prepend">				
					<input type="checkbox" />				
				</div>
				<spring:message code="label.rememberMe" />				
			</div>
		</div>	
		
		<div class="control-group">
		<label class="control-label" for="input01"></label>
	      <div class="controls">
	       <button type="submit" class="btn btn-success" rel="tooltip" title="Sign in">Sign in</button>
	       
	      </div>
	
		</div>
		
		<div class="control-group">
	        <label class="control-label"></label>
			<div class="controls">			    
				<a href="#"><spring:message code="label.forgotPassword" /> ?</a>				
			</div>
	  </div>
	
	  </form>
	  
	  

   </div>
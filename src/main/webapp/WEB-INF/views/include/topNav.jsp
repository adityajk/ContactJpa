<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="authenticated" var="authenticated" />

      <!-- Fixed navbar -->
      <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
          <div class="container-fluid">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="brand" href="#">Project Name</a>
            <div class="nav-collapse collapse">
              <ul class="nav">
              	<spring:url value="welcome" htmlEscape="true" var="welcome"/>
                <li id="homenav"><a href="/welcome"><i class="icon-home"></i> Home</a></li>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                <spring:url value="/events/" htmlEscape="true" var="eventsUrl"/>
                <li id="allevents"><a href="${eventsUrl}"><i class="icon-book"></i> All Events</a></li>
                </sec:authorize>
                <spring:url value="/events/my" htmlEscape="true" var="myEventsUrl"/>
                <li id="myevents"><a href="${myEventsUrl}"><i class="icon-user"></i> My Events</a></li>
                <spring:url value="/events/create" htmlEscape="true" var="createEventUrl"/>
                <li id="createevent"><a href="${createEventUrl}"><i class="icon-plus"></i> Create Event</a></li>
                <li class="dropdown">
                  <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-road"></i> States <b class="caret"></b></a>
                  <ul class="dropdown-menu">
                    <li><a href="#">Andhra Pradesh</a></li>
                    <li><a href="#">Jammu &amp; Kashmir</a></li>
                    <li><a href="#">Maharashtra</a></li>
                    <li class="divider"></li>
                    <li class="nav-header">UT</li>
                    <li><a href="#">Chandigarh</a></li>
                    <li><a href="#">Daman &amp; Diu</a></li>
                  </ul>
                </li>
              </ul>
                     
               <ul class="nav pull-right">
                  <c:choose>
                  	<c:when test="${authenticated}">
                  		<li class="dropdown">
	                  		<a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown"><i class="icon-user"></i>  <sec:authentication property="name" /> <b class="caret"></b></a>
	                  		<ul class="dropdown-menu">
	                  		    <spring:url value="/profile/myProfile" htmlEscape="true" var="myProfile"/>
			                    <li><a href="${myProfile}"><i class="icon-user"></i> Personal Profile</a></li>
			                    <spring:url value="/profile/changePassword" htmlEscape="true" var="changePassword"/>
			                    <li><a href="${changePassword}"><i class="icon-lock"></i> Change Password</a></li>
			                    <sec:authorize access="hasRole('ROLE_ADMIN')">
			                    <spring:url value="/profile/banUser" htmlEscape="true" var="banUser"/>
			                    <li><a href="${banUser}"><i class="icon-ban-circle"></i> Ban</a></li>			                    
							    <li class="divider"></li>
							    <spring:url value="/profile/makeAdmin" htmlEscape="true" var="makeAdmin"/>
							    <li><a href="${makeAdmin}"><i class="i"></i> Make admin</a></li>
							    </sec:authorize>
				            </ul>      		
                  		</li>
                  		<li class="divider-vertical"></li>
                  		<spring:url value="/logout" htmlEscape="true" var="logoutUrl" />
                  		<li><a id="navLogoutLink" title="Logout" href="${logoutUrl}"><i class="icon-signout"></i> Logout</a></li>
                  	</c:when>
                  	<c:otherwise> 
			          <li class="dropdown signinnav" id="menuLogin">
			            <a class="dropdown-toggle" href="#" data-toggle="dropdown" id="navLogin"><i class="icon-signin"></i> <spring:message code="label.signin" /><b class="caret"></b></a>
			            <div class="dropdown-menu" style="padding:17px;">
			              <form class="form" id="formLogin" method="post" action="signin.do"> 
			                <div class="input-prepend">
                                <span class="add-on"><i class="icon-envelope"></i></span> 
			                    <input name="email" id="email" placeholder="Email" type="text">
			                </div>
			                <div class="input-prepend">
                                <span class="add-on"><i class="icon-lock"></i></span> 
			                    <input name="password" id="password" placeholder="Password" type="password">
			                </div><br>
			                <input type="checkbox"> <span class="me"><spring:message code="label.rememberMe" /></span><br><br>
			                <button type="submit" id="btnLogin" class="btn btn-warning"><spring:message code="label.signin" /></button>		                
			              </form>
			              <a href="#"><spring:message code="label.forgotPassword" /> ?</a>
			            </div>
			          </li>   
			        <li class="divider-vertical"></li>  
			        <spring:url value="/signup" htmlEscape="true" var="signupUrl"/>   
	                <li id="signupnav"><a href="${signupUrl}" title="Sign Up"><i class="icon-chevron-sign-up"></i> <spring:message code="label.signup" /></a></li>
	                </c:otherwise>
                </c:choose>
               </ul> 
            </div><!--/.nav-collapse -->
          </div>
        </div>
      </div>
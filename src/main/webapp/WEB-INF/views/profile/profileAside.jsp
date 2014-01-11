<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
    <div class="span3">
        <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">Personal Profile</li>
              <spring:url value="/profile/myProfile" htmlEscape="true" var="myProfile"/>
              <li class="uProfile"><a href="${myProfile}"><i class="icon-chevron-right"></i>Update Profile</a></li>
              <spring:url value="/profile/changePassword" htmlEscape="true" var="changePassword"/>
              <li class="uPass"><a href="${changePassword}"><i class="icon-chevron-right"></i>Change Password</a></li>
              <sec:authorize access="hasRole('ROLE_ADMIN')">
              <spring:url value="/profile/banUser" htmlEscape="true" var="banUser"/>
              <li class="bUser"><a href="${banUser}"><i class="icon-chevron-right"></i>Ban User</a></li>
              <spring:url value="/profile/makeAdmin" htmlEscape="true" var="makeAdmin"/>
              <li class="uPriv"><a href="${makeAdmin}"><i class="icon-chevron-right"></i>Make Admin</a></li>
              </sec:authorize>          
            </ul>
        </div><!--/.well -->
    </div><!--/span-->
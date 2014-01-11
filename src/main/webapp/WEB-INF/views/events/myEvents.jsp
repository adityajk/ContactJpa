<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
       <div class="span9">
          <div>
            <h1>Hello, world!</h1>
            <p>List of my events.</p>
            <p></p>
          </div>
          <div class="row-fluid">
            <table  cellpadding="0" cellspacing="0" border="0" class="display" id="table_id">
			    <thead>
			        <tr>
			            <th>Date</th>
			            <th>Owner</th>
			            <th>Attendee</th>
			            <th>Summary</th>
			        </tr>
			    </thead>
			    <tbody>
			         <c:forEach items="${events}" var="event">
                       <fmt:formatDate value="${event.eventWhen}" type="both" pattern="dd/MM/yyyy" var="when"/>
                        <tr>
                            <td><c:out value="${when}" /></td>
                            <td><c:out value="${event.snaAccount1.firstName}" /> <c:out value="${event.snaAccount1.lastName}" /></td>
                            <td><c:out value="${event.snaAccount2.firstName}" /> <c:out value="${event.snaAccount2.lastName}" /></td>
                            <spring:url value="${event.id}" var="eventUrl" />
                            <td><a href="${eventUrl}" title="Click to see the event"><c:out value="${event.summary}" /></a></td>
                        </tr>
                   </c:forEach>
			      
			    </tbody>
			 </table>
		   </div><!--/row-->
        </div><!--/span-->
     

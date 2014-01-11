<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
       
        <div class="span9">
          <div>
            <h1>Hello, world!</h1>
            <p>List of all events.</p>
            <p></p>
          </div>
          <div class="row-fluid">
          	<div class="responseResult">
          		<div class="alert alert-success">
		            <button class="close"  title="close" type="button">×</button>
		            Event deleted successfully
		        </div>
          	</div>
            <table  cellpadding="0" cellspacing="0" border="0" class="display" id="table_id">
			     <thead>
                    <tr>
                        <th>Date</th>
                        <th>Owner</th>
                        <th>Attendee</th>
                        <th>Summary</th>
                        <th>Options</th>
                    </tr>
                </thead>
                <tbody>
                     <c:forEach items="${events}" var="event">
                       <fmt:formatDate value="${event.eventWhen}" type="both" pattern="dd/MM/yyyy" var="when"/>
                       <spring:url value="${event.id}" var="eventUrl" />
                        <tr class="data_${event.id}">
                            <td><c:out value="${when}" /></td>
                            <td><c:out value="${event.snaAccount1.firstName}" /> <c:out value="${event.snaAccount1.lastName}" /></td>
                            <td><c:out value="${event.snaAccount2.firstName}" /> <c:out value="${event.snaAccount2.lastName}" /></td>                            
                            <td><a class="openEvent" href="${eventUrl}" title="Click to see the event"><c:out value="${event.summary}" /></a></td>
                            <td><a class="btn btn-danger btn-small" id="delete_${event.id}" title="Delete" href="javascript:void(0);"><i class="icon-trash"></i> Delete</a>&nbsp;&nbsp;<a class="btn btn-small btn-info" title="Edit" id="edit_${event.id}" href="javascript:void(0);"><i class="icon-edit"></i> Edit</a></td>
                        </tr>
                   </c:forEach>
			    </tbody>
			 </table>
		   </div><!--/row-->
        </div><!--/span-->
 
   
     

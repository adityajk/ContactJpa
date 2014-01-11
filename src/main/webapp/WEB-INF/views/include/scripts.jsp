 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <spring:url value="/webjars/jquery/1.9.0/jquery.js" var="jQuery"/>
    <script src="${jQuery}"></script>

    <spring:url value="/webjars/jquery-ui/1.9.2/js/jquery-ui-1.9.2.custom.js" var="jQueryUi"/>
    <script src="${jQueryUi}"></script>
    
    <spring:url value="/webjars/bootstrap/2.3.0/js/bootstrap.min.js" var="bootstrapJs"/>
    <script src="${bootstrapJs}"></script>    

	<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <spring:url value="/resources/js/html5shiv.js" var="html5shivJs"/>
      <script src="${html5shivJs}"></script>
    <![endif]-->

	<spring:url value="/resources/js/jquery.validate.js" var="validateJs"/>
	<script src="${validateJs}"></script>
	
	<spring:url value="/resources/js/jquery.dataTables.min.js" var="datatableJs"/>
	<script src="${datatableJs}"></script>

	<spring:url value="/resources/js/sna.js" var="snaJs"/>
	<script src="${snaJs}"></script>
	
	
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><tiles:getAsString name="title" /></title>
	<tiles:insertAttribute name="header" />
</head>
<body id="<tiles:getAsString name='bodyId' />">

 <!-- Wrap all page content here -->
    <div id="wrap">
    
	    <tiles:insertAttribute name="topNav" />
	    
	    <div class="container-fluid">
	        <div class="row-fluid">
	        	<tiles:insertAttribute name="aside" />
	    		<tiles:insertAttribute name="content" />
	    	</div><!--/row-->
	    </div>     
     
     </div>
     
    	<tiles:insertAttribute name="footer" />
    
  	
  	
  	<tiles:insertAttribute name="scripts" />
    
</body>
</html>
    
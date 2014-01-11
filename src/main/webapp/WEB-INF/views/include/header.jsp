<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>	
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="State Nodal Agency">
    <meta name="author" content="InDG Team">
    
    <spring:url value="/webjars/bootstrap/2.3.0/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>

    <spring:url value="/webjars/bootstrap/2.3.0/css/bootstrap-responsive.min.css" var="bootstrapResCss"/>
    <link href="${bootstrapResCss}" rel="stylesheet"/>
    
    <spring:url value="/resources/css/demo_table_jui.css" var="demotableCss"/>
    <link href="${demotableCss}" rel="stylesheet"/>

    <spring:url value="/webjars/jquery-ui/1.9.2/css/smoothness/jquery-ui-1.9.2.custom.css" var="jQueryUiCss"/>
    <link href="${jQueryUiCss}" rel="stylesheet"></link>
    
     <spring:url value="/resources/font-awesome/css/font-awesome.min.css" var="fontCss"/>
    <link href="${fontCss}" rel="stylesheet"/>
    
    <!--[if IE 7]>
        <spring:url value="/resources/font-awesome/css/font-awesome-ie7.min.css" var="ieFontCss"/>
        <link href="${ieFontCss}" rel="stylesheet"/>	  
	<![endif]-->
    
    <spring:url value="/resources/css/sna.css" var="snaCss"/>
    <link href="${snaCss}" rel="stylesheet"/>   
   
    
    <!-- Fav and touch icons -->
    <spring:url value="/resources/ico/favicon.ico" var="favicon"/>
    <link rel="shortcut icon" href="${favicon}">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${flag != true}">
	<% getServletContext().getRequestDispatcher("/RecentMessage").forward(request, response); %>
</c:if>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">




</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <br />
    <br />
    <br />
    <br />
    
<div class="container">

	<form class="form-horizontal" action="RecentMessage" id="TewtForm" name="TewtForm" method="post">
		<div class="form-group">
			<label class="col-sm-2 control-label" for="name">Name: </label>
			<div class="col-sm-10">
				<input class="form-control" type="text" name="name" id="name" value="" required />
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2" for="Message" >Message: </label>
			<div class="col-sm-10">
				<textarea  class="form-control col-sm-10" rows="3" name="mes" id="mes" form="TewtForm">Enter text here...</textarea>
			</div>
		</div>
		<input type="submit" name="submit" id="submit" value="Submit" />
	</form>
	
	<div class="col-md-6"><c:out value="${messageList.name}" /></div>
	<div class="col-md-6"><c:out value="${messageList.mdate}" /></div>
	<div><textarea class="form-control" rows="6"><c:out value="${messageList.message}" /></textarea></div>
</div><!-- /.container -->
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>
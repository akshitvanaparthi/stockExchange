<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form class="form-signin"  method=POST action="/performBuyMatch">
	
	<h1 class="h3 mb-3 font-weight-normal">Enter Your Requirements : </h1>

	<input type="text" name="noOfShares" class="form-control" placeholder="Enter no of Shares" required autofocus>

	<input type="text" name="priceLimit" class="form-control" placeholder="Enter Price limit" required>
	<br>

	<button class="btn btn-lg btn-primary btn-block" type="submit">Match</button>

	<br>

	
</form>




</body>
</html>
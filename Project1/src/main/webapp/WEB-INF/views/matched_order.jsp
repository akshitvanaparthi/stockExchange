<%@page import="com.mthree.model.BuyOrder"%>
<%@page import="com.mthree.model.SellOrder"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h3> Buyer matched with Seller . Here are the details :</h3>

<%

BuyOrder b = (BuyOrder)request.getAttribute("matchedBuyOrder");

SellOrder s = (SellOrder)request.getAttribute("matchedSellOrder");



%>
<table>
	<tr>
		<th>BUYER ID</th>
		<th>SELLER ID</th>
		<th>VOLUME</th>
		<th>TRADED PRICE</th>
	</tr>
	<tr>
		<td><%=b.getBuyId() %></td>
		<td><%=s.getSellId() %></td>
		<td><%=b.getBuyShares() %></td>
		<td><%=s.getAsk() %></td>
</table>

<br>




</body>
</html>
<%@page import="com.mthree.model.BuyOrder"%>
<%@page import="com.mthree.model.SellOrder"%>
<%@page import="java.util.*"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3> Seller matched with Buyer . Here are the details :</h3>

<%

SellOrder s = (SellOrder)request.getAttribute("matchedSellOrder");

ArrayList<BuyOrder> b = (ArrayList<BuyOrder>)request.getAttribute("matchedBuyOrder");


%>
<table>
	<tr>
		<th>BUYER ID</th>
		<th>SELLER ID</th>
		<th>VOLUME</th>
		<th>TRADED PRICE</th>
	</tr>
	<tr>
		<td><%=s.getSellId() %></td>
		<% 
		for(BuyOrder list : b){
		
		%>
		
		<td><%=list.getBuyId() %></td>
		<td><%=list.getBuyShares() %></td>
		<td><%=list.getBid() %></td>
		<br>
		<%}%> 
</table>

<br>




</body>
</html>
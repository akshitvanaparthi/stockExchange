<%@page import="com.mthree.model.OrderBook"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Order Book List</title>
</head>
<body>

<%

List<OrderBook> orderBookList = (List<OrderBook>)request.getAttribute("orderBookList");


for(OrderBook o : orderBookList)
{


%>

<%=o.getOrderId() %>,
<%=o.getBuyShares() %>,
<%=o.getBidPrice() %>,
<%=o.getAskPrice() %>,
<%=o.getSellShares() %>,

<br>
<%} %>






</body>
</html>
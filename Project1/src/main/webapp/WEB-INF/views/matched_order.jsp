

<!-- 
	Will be change to Restful request and use jQuery to render the data later
-->
<%@page import="com.mthree.model.BuyOrder"%>
<%@page import="com.mthree.model.SellOrder"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%

BuyOrder b = (BuyOrder)request.getAttribute("matchedBuyOrder");

ArrayList<SellOrder> s = (ArrayList<SellOrder>)request.getAttribute("matchedSellOrder");
double total=0.0;

%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.0.1">
    <title>Matched Order</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/dashboard/">

    <!-- [Lib] Jquery lib -->
    <script src="https://code.jquery.com/jquery-3.5.1.js"
         crossorigin="anonymous"></script>


        <!-- [self-define]Jquery script -->
		<script src="js/matched_order.js"></script>


	
    
    <!-- [Template]  Bootstrap core CSS lib -->
    <link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">

    <!-- [Template]  this template custom style tag -->
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
    <!-- [Template] Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">


</head>



<body >

    <!-- Start  of the html UI code -->


    <!-- Top pannel, including search bar and sign out  -->
    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
        <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">Buyer Id: <%=b.getBuyId() %></a>
        <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse"
            data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
        <ul class="navbar-nav px-3">
            <li class="nav-item text-nowrap">
                <a class="nav-link" href="logout">Sign out</a>
            </li>
        </ul>
    </nav>


    <div class="container-fluid">
        <div class="row">

           

            <!-- Main pannel, show figure and table -->
            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
                <div
                    class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h1 class="h2">Matched Order: Apple Inc.</h1>
                    
                </div>

                <!-- table bid ask cancale order button-->
                
				<h3>State: success %nbsp;<img src="http://www.turanus.com/images/joomlart/banners/html5-icon.png" style="height: 30px;"></h3>
                <!-- order book table -->
                <div class="table-responsive">
                    <table class="table table-striped table-sm">
                        <thead>
                            <tr>
								<th>SELLER ID</th>
								<th>VOLUME</th>
								<th>TRADED PRICE</th>
                            </tr>
                        </thead>

                        <tbody>
							<% 
							for(SellOrder so : s){
								total += so.getSellShares() * so.getAsk();
							%>
								<tr>
									<td><%=so.getSellId() %></td>
									<td><%=so.getSellShares() %></td>
									<td><%=so.getAsk() %></td>
									
								</tr>
								
							<%}%> 
							<tr >
								<td colspan="3">Total: <span id="totalPrice"><%=total%></span></td>
								
							</tr>
                        </tbody>
					</table>
					<button  type="button" class="btn btn-success" onclick="goBack()">Go Back</button>
 
                </div>


            </main>
        </div>
    </div>
    <!-- end of the html UI code -->


    <!-- Will be moved to standlone js file later -->





    <!-- Must put at the bottom of html file -->
    <!-- The website template lib -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"
        crossorigin="anonymous"></script>
    <!-- <script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script> -->
    <script src="../assets/dist/js/bootstrap.bundle.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
    <script src="js/dashboard.js"></script>

	    

</body>

</html>
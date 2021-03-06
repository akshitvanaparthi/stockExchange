<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.0.1">
    <title>Buy Order History</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/dashboard/">

    <!-- [Lib] Jquery lib -->
    <script src="https://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>


    <!-- [Lib] AngularJS lib -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>

    
    
    <!-- [self-define]Jquery script -->
    <script src="js/buyerHistory.js"></script>

    
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



<body ng-app="myApp" ng-controller="Ctrl">

    <!-- Start  of the html UI code -->


    <!-- Top pannel, including search bar and sign out  -->
    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
        <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">Username</a>
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

            <!-- Left pannel -->
            
            <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
                <div class="sidebar-sticky pt-3">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link" href="/">
                                <span data-feather="home"></span>
                                Dashboard 
                            </a>
                        </li>
                    <!-- 
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <span data-feather="file"></span>
                                Orders
                            </a>
                        </li>
                     -->

                    </ul>

                    <h6
                        class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                        <span>MATCHED ORDER</span>
                        <a class="d-flex align-items-center text-muted" href="#" aria-label="Add a new report">
                            <!-- <span data-feather="plus-circle"></span> -->
                        </a>
                    </h6>
                    <ul class="nav flex-column mb-2">
                        <li class="nav-item">
                            <a class="nav-link active" href="/buyerHistory">
                                <span data-feather="file-text"></span>
                                Buy Order Record
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/sellerHistory">
                                <span data-feather="file-text"></span>
                                Sell Order Record
                            </a>
                        </li>
                    <!-- 
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <span data-feather="file-text"></span>
                                Last quarter
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <span data-feather="file-text"></span>
                                Social engagement
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <span data-feather="file-text"></span>
                                Year-end sale
                            </a>
                        </li> 
                    -->
                    </ul>
                </div>
            </nav>
            

            <!-- Main pannel, show figure and table -->
            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
                <div
                    class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h1 class="h2">Apple Inc.</h1>
                    <div class="btn-toolbar mb-2 mb-md-0">
                        <div class="btn-group mr-2">
                            <button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
                            <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
                        </div>
                        <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
                            <span data-feather="calendar"></span>
                            This week
                        </button>
                    </div>
                </div>


                <!-- The price chart, can edit in the dashboard.js file  -->
                <!-- <canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas> -->


                <!-- table bid ask cancale order button-->
                <h2>Matched buy order</h2>

                <!-- order book table -->
                <div class="table-responsive">
                    <table class="table table-striped table-sm">
                        <thead>
                            <tr>
                                <th>Buyer ID</th>
                                <th>Seller ID</th>
                                <th>traded Price</th>
                                <th>Volume</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr ng-repeat="x in buyOrderHistory">
                                <td>{{x.buyerId}}</td>
                                <td>{{x.sellerId}}</td>
                                <td>{{x.tradedPrice}}</td>
                                <td>{{x.volume}}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>


            </main>
        </div>
    </div>
    <!-- end of the html UI code -->


    <!-- Will be moved to standlone js file later -->
    <!-- AngularJs -->
    <script>



    </script>




    <!-- Must put at the bottom of html file -->
    <!-- The website template lib -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"
        crossorigin="anonymous"></script>
    <!-- <script>window.jQuery || document.write('<script src="../assets/js/vendor/jquery.slim.min.js"><\/script>')</script> -->
    <script src="../assets/dist/js/bootstrap.bundle.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>
    <script src="js/dashboard.js"></script>

</body>

</html>
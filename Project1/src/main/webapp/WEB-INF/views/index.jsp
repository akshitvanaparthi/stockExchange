<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Jekyll v4.0.1">
    <title>Dashboard</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/dashboard/">

    <!-- [Lib] Jquery lib -->
    <script src="https://code.jquery.com/jquery-3.5.1.js"
        integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>


    <!-- [Lib] AngularJS lib -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>

    
    
    <!-- [self-define]Jquery script -->
    <script src="js/index.js"></script>

    
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
            <!--
            <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
                <div class="sidebar-sticky pt-3">
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link active" href="#">
                                <span data-feather="home"></span>
                                Dashboard <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <span data-feather="file"></span>
                                Orders
                            </a>
                        </li>

                    </ul>

                    <h6
                        class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                        <span>Saved reports</span>
                        <a class="d-flex align-items-center text-muted" href="#" aria-label="Add a new report">
                            <span data-feather="plus-circle"></span>
                        </a>
                    </h6>
                    <ul class="nav flex-column mb-2">
                        <li class="nav-item">
                            <a class="nav-link" href="#">
                                <span data-feather="file-text"></span>
                                Current month
                            </a>
                        </li>
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
                    </ul>
                </div>
            </nav>
            -->

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
                <canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>


                <!-- table bid ask cancale order button-->
                <table>
                    <tr class="td">
                        <td>
                            <h2>Order Book</h2>
                        </td>
                        <td>
                            <div style="margin-left: 70px;">
                                <button type="button" id="bidButton" class="btn btn-light">Bid</button>
                                <button type="button" id="askButton" class="btn btn-light">Ask</button>
                                <button type="button" id="cancelButton" class="btn btn-light">Cancel</button>


                                <div id="bidContainer" style="margin-bottom: 10px;visibility: visible">
                                    <form id="bidForm">
                                        price: <input name="noOfShares" id="" type="number" class="" step="0.01" style="height: 35px;">
                                        volume: <input name="priceLimit" id="" type="number" class="" style="height: 35px;">
                                        <button type="button" class="btn btn-primary" id="submitBidOrder">Bid</button>
                                    </form>
                                </div>

                                <div id="askContainer" style="margin-bottom: 10px;display: none;">
                                    <form id="askForm">
                                        price: <input name="noOfShares" type="number" class="" step="0.01" style="height: 35px;">
                                        volume:<input name="priceLimit" type="number" class="" style="height: 35px;">
                                        <button type="button" class="btn btn-danger" id="submitAskOrder">Ask</button>
                                    </form>
                                </div>

                                <div id="cancelContainer" style="margin-bottom: 10px;display: none;">
                                    <form id="cancelForm">
                                        price: <input name="noOfShares" type="number" class="" step="0.01" style="height: 35px;">
                                        volume: <input name="priceLimit" type="number" class="" style="height: 35px;">
                                        <button type="button" class="btn btn-secondary" id="submitCancelOrder">cancel</button>
                                    </form>
                                </div>
                            </div>
                        </td>
                    </tr>
                </table>

                <!-- order book table -->
                <div class="table-responsive">
                    <table class="table table-striped table-sm">
                        <thead>
                            <tr>
                                <th>Bid Volume</th>
                                <th>Bid Price</th>
                                <th>Ask Price</th>
                                <th>Ask Volume</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr ng-repeat="x in buyorders">
                                <td>{{x.buyShares}}</td>
                                <td>{{x.bid}}</td>
                                <td>{{sellorders[$index].ask}}</td>
                                <td>{{sellorders[$index].sellShares }}</td>
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

        var app = angular.module('myApp', []);
        app.controller('Ctrl', function ($scope, $http) {
            $http.get("http://localhost:8095/getbuyorders")
                .then(function (response) {
                    $scope.buyorders = response.data;
                });

            $http.get("http://localhost:8095/getsellorders")
                .then(function (response) {
                    $scope.sellorders = response.data;
                });
        });

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
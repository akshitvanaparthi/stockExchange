var app = angular.module('myApp', []);
app.controller('Ctrl', function ($scope,$rootScope, $http) {
    $http.get("/getBuyerHistory")
        .then(function (response) {
            $scope.buyOrderHistory = response.data;
            
            }
            // console.log(bids);
            // console.log(buyShares);


              
        );
        //set global js var
        //https://stackoverflow.com/questions/11938380/global-variables-in-angularjs

 
}); 


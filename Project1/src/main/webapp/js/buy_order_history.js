var app = angular.module('myApp', []);
app.controller('Ctrl', function ($scope,$rootScope, $http) {
    $http.get("/getAllBuyOrderHistory")
        .then(function (response) {
            $scope.buyOrderHistory = response.data;
            bids=[]
            buyShares=[]
            for(i=0;i < $scope.buyOrderHistory.length;i++ ){
                bids.push($scope.buyOrderHistory[i].bid)
                buyShares.push($scope.buyOrderHistory[i].buyShares)
            }
            // console.log(bids);
            // console.log(buyShares);

            feather.replace()
            
            // Graphs
            var ctx = document.getElementById('myChart')
            // eslint-disable-next-line no-unused-vars
            var myChart = new Chart(ctx, {
                type: 'horizontalBar',
                data: {
                labels: bids,
                datasets: [{
                    data: buyShares,
                    lineTension: 0,
                    backgroundColor: 'transparent',
                    borderColor: '#007bff',
                    borderWidth: 4,
                    pointBackgroundColor: '#007bff'
                }]
                },
                options: {
                scales: {
                    yAxes: [{
                    ticks: {
                        beginAtZero: false
                    }
                    }]
                },
                legend: {
                    display: false
                }
                }
            })
              
        });
        //set global js var
        //https://stackoverflow.com/questions/11938380/global-variables-in-angularjs

 
}); 



    var app = angular.module('myApp', []);
    app.controller('Ctrl', function ($scope, $http, $rootScope) {
        $http.get("/getbuyorders")
            .then(function (response) {
                $scope.buyorders = response.data;
            });

        $http.get("/getsellorders")
            .then(function (response) {
                $scope.sellorders = response.data;
                
                if ($scope.sellorders.length >  $scope.buyorders.length ){
                    $scope.mainOrder = $scope.sellorders ;
                }else{
                    $scope.mainOrder = $scope.buyorders ;
                }

                
            });
        
        
        
    }); 
$(document).ready(function () {
    
    // ---- [ Show differnet input option/button] ----------
    // show Bid input
    $("#bidButton").click(function () {
        $('#bidContainer').show();
        $('#askContainer').hide();
        $('#cancelContainer').hide();
    })

    // show Ask input
    $("#askButton").click(function () {
        $('#bidContainer').hide();
        $('#askContainer').show();
        $('#cancelContainer').hide();
    })

    // show Cancel input
    $("#cancelButton").click(function () {
        $('#bidContainer').hide();
        $('#askContainer').hide();
        $('#cancelContainer').show();
    })


    // ---- [ Order button POST event] ----------

    /*   // since want to redirect to oreder_matched page, so disable these fn
        //  also add `action` and `method` in the form tag, and chagne the button type to submit

    // bid order
    $("#submitBidOrder").click(function () {
        // $.post("performBuyMatch",$("#bidForm").serialize());
        $.ajax({
            type: "POST",
            url: "performBuyMatch",
            data: $("#bidForm").serialize(),
        });
        // console.log($("#bidForm").serialize());
    })

    // ask order
    $("#submitAskOrder").click(function () {
        // console.log($("#askForm").serialize());
        $.ajax({
            type: "POST",
            url: "performAskMatch",
            data: $("#askForm").serialize(),
        });
    })


    // Cancel order
    $("#submitCancelOrder").click(function () {
        // console.log($("#askForm").serialize());
        $.ajax({
            type: "POST",
            url: "performCancelMatch",
            data: $("#cancelForm").serialize(),
        });
    })
    */

});

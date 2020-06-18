
var app = angular.module('myApp', []);
app.controller('Ctrl', function ($scope, $http, $rootScope) {

    //render the orderbook in UI
    $http.get("/getbuyorders")
        .then(function (response) {
            $scope.buyorders = response.data;

            $http.get("/getsellorders")
                .then(function (response) {
                    $scope.sellorders = response.data;

                    if ($scope.sellorders.length > $scope.buyorders.length) {
                        $scope.mainOrder = $scope.sellorders;
                    } else {
                        $scope.mainOrder = $scope.buyorders;
                    }


                });
        });

    //redner the latest trade price
    $http.get("/getBuyerHistory")
        .then(function (response) {
            $scope.buyOrderHistory = response.data;
            $http.get("/getSellerHistory")
                .then(function (response) {
                    $scope.sellOrderHistory = response.data;
                    lastSellPrice = $scope.sellOrderHistory[$scope.sellOrderHistory.length-1]
                    lastBuyPrice = $scope.buyOrderHistory[$scope.buyOrderHistory.length-1]
                    latestPrice = (lastBuyPrice.tradedPrice +  lastSellPrice.tradedPrice )/2
                    // console.log(latestPrice)
                    $("#latestPrice").text("[$" + latestPrice + "]" )
                    $("#latestPrice").css("color","green")
                }

                );
        }



        );

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



    $("#cancelOption").on("change", function () {
        // alert(this.value);
        if (this.value == "buyerIdOption") {
            $("#OptionText").text("buyId");
            $("#canclOpion").attr("name", "buyid");
            $("#cancelForm").attr("action", "buycancel");

            // alert(this.value);

        } else if (this.value == "sellerIdOption") {
            $("#OptionText").text("sellId");
            $("#canclOpion").attr("name", "sellid");
            $("#cancelForm").attr("action", "sellcancel");
            // alert(this.value);
        }
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

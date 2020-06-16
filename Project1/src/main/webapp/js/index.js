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

});

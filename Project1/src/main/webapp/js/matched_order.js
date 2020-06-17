
function goBack() {
    window.history.back();
}

$(document).ready(function () {

    //conver total price number to currency format
    // e.g. 10000.0 to $10,000.00
    function numToDollar(){
        options2 = { style: 'currency', currency: 'USD' };
        numberFormat2 = new Intl.NumberFormat('en-US', options2);
        amount=$("#totalPrice").text()
        console.log(numberFormat2.format(amount));
        new_amount = (numberFormat2.format(amount));
        $("#totalPrice").text(new_amount);
    }
    numToDollar();

})
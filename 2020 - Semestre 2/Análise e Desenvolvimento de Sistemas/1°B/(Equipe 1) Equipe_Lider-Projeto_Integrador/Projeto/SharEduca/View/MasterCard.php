<script
src="https://ap-gateway.mastercard.com/checkout/version/49/checkout.js" 
data-error="errorCallback" 
data-cancel="http://127.0.0.1/myfiles/MasterCard_test/"
></script>

<script type="text/javascript">
    function errorCallback(error){
        alert("Error: "+JSON.stringity(error));
        window.location.href = "http://127.0.0.1/myfiles/MasterCard_test/";
    }

    Checkout.configure({
        merchant: '<?php echo $this->mastercard['MerchantID'];?>',
        order: {
            amount: function (){
                return <?php echo $amount;?>;
            },
            currency: '<?php echo $currency;?>',
            description: "Compra do SharEduca",
            id: "<?php echo $mastercard['OrderID'];?>",
        },
        /*
        interaction: {
            name: '<<Nome>>',
            address: {
                line1: 'Rua1',
                line2: 'Rua2'
            }
        },
        */
        session: {
            id: "<?php echo $sessionId;?>"
        }
    });
    Checkout.showPaymentPage();
</script>
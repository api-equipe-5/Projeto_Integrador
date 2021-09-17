$(document).ready(function(){
    $('.chat_icon').click(function(event){
        $('.chat_box').toggleClass('.active');
    });

    $('.conv-form-wrapper').convform({selectInputStyle: 'disable'});
})

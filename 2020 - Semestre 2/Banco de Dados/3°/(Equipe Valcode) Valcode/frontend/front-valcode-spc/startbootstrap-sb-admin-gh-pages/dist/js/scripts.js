/*!
    * Start Bootstrap - SB Admin v6.0.1 (https://startbootstrap.com/templates/sb-admin)
    * Copyright 2013-2020 Start Bootstrap
    * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-sb-admin/blob/master/LICENSE)
    */
    (function($) {
    "use strict";

    // Add active state to sidbar nav links
    var path = window.location.href; // because the 'href' property of the DOM element is the absolute path
        $("#layoutSidenav_nav .sb-sidenav a.nav-link").each(function() {
            if (this.href === path) {
                $(this).addClass("active");
            }
        });

    // Toggle the side navigation
    $("#sidebarToggle").on("click", function(e) {
        e.preventDefault();
        $("body").toggleClass("sb-sidenav-toggled");
    });
})(jQuery);


// select meus dados
   
    $(".multiple_select").mousedown(function(e) {
        if (e.target.tagName == "OPTION") 
        {
          return; //don't close dropdown if i select option
        }
        $(this).toggleClass('multiple_select_active'); //close dropdown if click inside <select> box
    });
    $(".multiple_select").on('blur', function(e) {
        $(this).removeClass('multiple_select_active'); //close dropdown if click outside <select>
    });
    	
    $('.multiple_select option').mousedown(function(e) { //no ctrl to select multiple
        e.preventDefault(); 
        $(this).prop('selected', $(this).prop('selected') ? false : true); //set selected options on click
        $(this).parent().change(); //trigger change event
    });

    	
    	$("#myFilter").on('change', function() {
          var selected = $("#myFilter").val().toString(); //here I get all options and convert to string
          var document_style = document.documentElement.style;
          if(selected !== "")
            document_style.setProperty('--text', "'Empresa(s) Selecionada(s): "+selected+"'");
          else
            document_style.setProperty('--text', "'Select values'");
    	});
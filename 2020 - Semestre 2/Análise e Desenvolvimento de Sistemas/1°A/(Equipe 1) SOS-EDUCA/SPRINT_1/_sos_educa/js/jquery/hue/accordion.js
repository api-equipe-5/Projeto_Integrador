$(document).ready(function() {
	$(".accordion2 h3").eq(2).addClass("active");
	$(".accordion2 p").eq(2).show();
	$(".accordion2 h3").click(function() {
		$(this).next("p").slideToggle("slow")
		.siblings("pivisible").slideUp("slow");
		$(this).toggleClass("active");
		$(this).siblings("h3").removeClass("active")
	
	});
	
});
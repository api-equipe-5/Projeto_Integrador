$(document).ready(function(){
			
    var userName = sessionStorage.getItem("doc_cli");
        
        if(userName == null){
        
            window.location.href = '/index.html';
        
        }
    
});
$('#Logout').click(function() {
    sessionStorage.clear();
    window.location.href = '/index.html';
});

/**ATENÇÃO!!!!!*/

/**ESTE ARQUIVO JAVASCRIPT FOI PROJETADO PARA TRATAR A COLETA DO CSRF_TOKEN DO COOKIE DO VAVEGADOR*/




/*ADQUIRE O CSRF_TOKEN DO CACHE DO NAVEGADOR*/
function getCookie(name) {
    cookieValue = null;
   if (document.cookie && document.cookie !== '') {
       cookies = document.cookie.split(';');
       for ( i = 0; i < cookies.length; i++) {
            cookie = cookies[i].trim();
           // Does this cookie string begin with the name we want?
           if (cookie.substring(0, name.length + 1) === (name + '=')) {
               cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
               break;
           }
       }
   }
   return cookieValue;
}
csrftoken = getCookie('csrftoken');
/////////////////////////////////////////////
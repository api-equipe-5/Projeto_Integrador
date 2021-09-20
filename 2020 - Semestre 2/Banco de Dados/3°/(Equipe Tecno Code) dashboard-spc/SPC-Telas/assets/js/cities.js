$(document).ready(function(){
    carregar_json('Estado');
    function carregar_json(id, cidade_id){
        var html = '';

        $.getJSON('https://gist.githubusercontent.com/letanure/3012978/raw/36fc21d9e2fc45c078e0e0e07cce3c81965db8f9/estados-cidades.json', function(data){
            html += '<option>Selecionar '+ id +'</option>';
            console.log(data);
            if(id == 'Estado' && cidade_id == null){
                for(var i = 0; i < data.estados.length; i++){
                    html += '<option value='+ data.estados[i].sigla +'>'+ data.estados[i].nome+'</option>';
                }
            }else{
                for(var i = 0; i < data.estados.length; i++){
                    if(data.estados[i].sigla == cidade_id){
                        for(var j = 0; j < data.estados[i].cidades.length; j++){
                            html += '<option value='+ data.estados[i].sigla +'>'+data.estados[i].cidades[j]+ '</option>';
                        }
                    }
                }
            }

            $('#'+id).html(html);
        });
        
    }

    $(document).on('change', '#Estado', function(){
        var cidade_id = $(this).val();
        console.log(cidade_id);
        if(cidade_id != null){
            carregar_json('Cidade', cidade_id);
        }
    });

});
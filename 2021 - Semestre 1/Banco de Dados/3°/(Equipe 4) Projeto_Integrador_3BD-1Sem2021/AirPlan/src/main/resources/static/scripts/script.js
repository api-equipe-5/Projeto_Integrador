
function makeFile(key1, key2, tag, file){
    var fso  = new ActiveXObject("Scripting.FileSystemObject");
    var fh = fso.CreateTextFile("c:codeList.txt", true);
    fh.WriteLine(`Primary Key: ${key1} \n
                 Secundary Key: ${key2} \n
                 Tag: ${tag} \n
                 ${file}`); 
}

function filesValues(final){
    let teste = document.getElementsByClassName('file');
    if (teste.length > 0){
        for (i = 0; i < teste.length; i+=4){
            for (j = 0; j < 4; j++){
                let aux = "";
                if(j === 0){
                    aux = [`Section Number: ${teste[i+j].value}`];
                    final.push(aux);
                    console.log(teste[i+j].value);
                    console.log(final);
                }
                else if(j === 1){
                    aux = [`Subsection: ${teste[i+j].value}`];
                    final.push(aux);
                }
                else if(j === 2){
                    aux = [`Block Number: ${teste[i+j].value}`];
                    final.push(aux);
                }
                else if(j === 3){
                    aux = [`Code: ${teste[i+j].value}`];
                    final.push(aux);
                }
            }
        }
    }
    
};

function getFile(){

    let primaryKey = document.getElementById("primaryKey").value;
    let secundaryKey = document.getElementById("secundaryKey").value;
    let tag = document.getElementById("tag").value;
    let final = [];
    filesValues(final);
    makeFile(primaryKey, secundaryKey, tag, final);
}

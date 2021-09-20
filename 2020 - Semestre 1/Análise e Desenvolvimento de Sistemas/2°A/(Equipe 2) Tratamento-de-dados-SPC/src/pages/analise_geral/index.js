const { setFlagsFromString } = require('v8');
const { mainModule } = require('process');

const sectionButtonsCol = document.querySelector('.buttonsMetadados');
const receiveSelectLabels = document.querySelectorAll('.receiveSelect');
const metadadoPlace = document.querySelector('.metadado_place');
const matriz = JSON.parse(localStorage.getItem('matriz'));


metadadoOpts(matriz);

function changeDisabled(index){
  const allDescriptions = document.querySelectorAll('.description');

  cont = 0
  for (let description of allDescriptions){
    if (cont == index)
      description.disabled = false
    cont += 1
    
  }
}

function closeModal(){
  metadadoPlace.innerHTML = "";

  localStorage.removeItem('setMetadado');

  const checks = document.querySelectorAll('.check');
  const allDescriptions = document.querySelectorAll('.description');
  const allSelects = document.querySelectorAll('select');
  
  for (let i = 0; i < checks.length; i++){
    checks[i].checked = false
    allDescriptions[i].value = "";
    allSelects[i].value = "METADADO"
  }
 
}

// Função vem no elemento <a>, quando clicada salva o metadado no localstorage
function setModal(metadado){

  metadadoPlace.appendChild(document.createTextNode(metadado.data))
  localStorage.setItem('setMetadado', metadado.data);
}

function confirmModal(){
  const chekcsElement = document.querySelectorAll('.check');
  const allDescriptions = document.querySelectorAll('.description');
  const allSelects = document.querySelectorAll('select');
  
  for (let i = 0; i < chekcsElement.length; i++){
    if(chekcsElement[i].checked){
      const dataAnalise = JSON.parse(localStorage.getItem('dataAnalise'));

      if(!dataAnalise){
        localStorage.setItem('dataAnalise', 
          JSON.stringify([{
          metaName:localStorage.getItem('setMetadado'),
          name:chekcsElement[i].id,
          checked:chekcsElement[i].checked,
          column:allSelects[i].value,
          whenColHasValue:allDescriptions[i].value
        }]))

      }else{
        const newValues = {
          metaName:localStorage.getItem('setMetadado'),
          name:chekcsElement[i].id,
          checked:chekcsElement[i].checked,
          column:allSelects[i].value,
          whenColHasValue:allDescriptions[i].value}

        let newDataAnalise = [...dataAnalise, newValues];

        localStorage.setItem('dataAnalise', 
          JSON.stringify(newDataAnalise))
      }
    }else{
      const dataAnalise = JSON.parse(localStorage.getItem('dataAnalise'));

    }
  }

}

function metadadoOpts(data){

  array = data;
  const condicionais = ['requerido', 'unico', 'alpha numerico','bla','bla'];
  let metadados = []

  for(let word = 0; word < array[1].length -1; word++){
    const a = document.createElement('a');
    const metadado = document.createTextNode(array[1][word]);
    metadados.push(metadado);

    a.href='#modal'; 
    a.classList.add('modal-open');
    a.appendChild(metadado);
    a.addEventListener('click',()=> setModal(metadado));
    sectionButtonsCol.appendChild(a);

  }  

  for(let i = 0; i < condicionais.length; i++){
    const select = document.createElement('select');

    for(let metadado = 0; metadado < metadados.length; metadado++){
      if (!metadado) {
        const option = document.createElement('option');
        option.appendChild(document.createTextNode('METADADO'));

        select.appendChild(option);
      }
      const option = document.createElement('option');
      option.appendChild(document.createTextNode(metadados[metadado].data));

      select.appendChild(option);
    } 

    receiveSelectLabels[i].appendChild(select);
  }
}

function cleansing(){
  localStorage.removeItem('dataAnalise');
  alert('Suas configurações foram resetadas')
}

function runAnalise(){ 
  const condicionais = JSON.parse(localStorage.getItem('dataAnalise'))
  let Bom = []
  let Malvado = []
  
  for (let condicional of condicionais) {
    for (let row = 0; row < matriz[matriz[1].indexOf(condicional.metaName) + 2].length -1; row++) {
      let lineIsGood = true;
      for (let col = 2; col < matriz.length -1; col++){
        switch (condicional.name) {
          case 'requerido':
            if(condicional.column === 'METADADO'){
              if(col ===  matriz[1].indexOf(condicional.metaName) + 2) {
                if(!matriz[col][row]
                  || matriz[col][row].indexOf("empty:''") >= 0
                  || matriz[col][row].indexOf('NULL') >= 0) {
                    lineIsGood = false
                    //analiseRow(row, true, true);
                  break;
                }
                //analiseRow(row, true, false);
                break; 
              }
            
            }else{
              if(matriz[matriz[1].indexOf(condicional.column) + 2][row] == condicional.whenColHasValue) {
                if(col ===  matriz[1].indexOf(condicional.metaName) + 2) {
                  if(!matriz[col][row]
                    || matriz[col][row].indexOf("empty:''") >= 0
                    || matriz[col][row].indexOf('NULL') >= 0) {
                      lineIsGood = false
                    break;
                    }
                  break; 
                  }
                }
            }
            
          case 'letras':
            if(condicional.column === 'METADADO'){
              if(col ===  matriz[1].indexOf(condicional.metaName) + 2){
                if(!isNaN(matriz[col][row])){
                  lineIsGood = false
                }
                break;
              }             

            }else if(col ===  matriz[1].indexOf(condicional.metaName) + 2) {
              if(!isNaN(matriz[col][row])){
                lineIsGood = false
              }
              break;
            }
            break;
            
          case 'numericos':
            if(condicional.column === 'METADADO'){
              if(isNaN(matriz[col][row])){
                lineIsGood = false
              }
              break;

            }else if(col ===  matriz[1].indexOf(condicional.metaName) + 2) {
              if(isNaN(matriz[col][row])){
                lineIsGood = false
              }
              break;
            }
            break;
          case 'alphanumeric':
            break
          default:
            break;
        }
      }
    if(lineIsGood){
      Bom.push(row);

    }else{
      Malvado.push(row)

    }
      
  }
  // console.log(Bom, Malvado)

  // analiseRow(0,false,false)
  // console.log(Bom, Malvado)
} 
  alert('\n\n\ ...Gerando tabela xlsx\n\n')
  
  generateTable(Bom)
}

function returnMatriz(arrayIndex) {

  //console.log(arrayIndex)

  let newArrayIndex = arrayIndex.filter(function(este, i) {
    return arrayIndex.indexOf(este) === i;
  });

  arrayIndex = newArrayIndex;

  let newMatriz = []

  for(let i = 0; i < matriz[1].length; i++ ){
    newMatriz.push([])
  }

  for(let row of arrayIndex){
    for(let i = 1; i < matriz[1].length +1; i++){
      newMatriz[i -1].push(matriz[i][row])
    }
  }

  newMatriz[0] = matriz[1]
  console.log(newMatriz)
  return newMatriz;
}

function generateTable(LosIndex) {

  let matrizTratada = returnMatriz(LosIndex);

  let concatMatriz = ''
  for(let i = 0; i < matrizTratada.length; i++){
    concatMatriz += '|'
    for (let j = 0; j < matrizTratada[i].length; j++){
      concatMatriz += `${matrizTratada[i][j]},`
    }
  }

  runPython(concatMatriz)
}

function runPython(matriz){
  const { PythonShell } = require('python-shell');
  const path = require('path');

  const ops = {
    scriptPath: path.join(__dirname, '../../engine/'),
    args: [matriz]
  };
  
  const analise = new PythonShell('generateTable.py', ops);

  analise.on('message', function(message){

  })
 
}

let modal = document.getElementById("myHelpModal");

let btn = document.getElementById("myHelpBtn");

let span = document.getElementsByClassName("close")[0];

btn.onclick = function() {
  modal.style.display = "block";
}

span.onclick = function() {
  modal.style.display = "none";
}

window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
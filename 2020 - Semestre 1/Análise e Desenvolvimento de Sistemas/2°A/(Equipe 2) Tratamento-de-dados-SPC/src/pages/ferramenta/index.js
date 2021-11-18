const divTableName = document.querySelector('.table-name');
const divPreSetting = document.querySelector('.pre-settings');

const matriz=[];
localStorage.clear()

function toSettingsPage(){
  const tableName = localStorage.getItem('table');

  if(!tableName){
    alert('Insira uma tabela');
    return;
  }

  returnPython(tableName)
}

function returnPython(table) {

  const { PythonShell } = require('python-shell');
  const path = require('path');

  const ops = {
    scriptPath: path.join(__dirname, '../../engine/'),
    args: [table]
  };

  // Vejo se o arquivo atual tem .xlsx dentro dele, se tiver passo o arquivo
  // python que le xlsx se não csv
  
  const PythonFileExt = table.indexOf('.xlsx') >= 0 ? 'matrizXlsx.py' : 'matrizCsv.py'

  const analise = new PythonShell(PythonFileExt, ops);


  analise.on('message', function(message){
    const data = message.split('|');

    for(let i = 0; i< data.length; i++){
      const newData = data[i].split(',');
      matriz.push(newData);
    }

    localStorage.setItem('matriz',JSON.stringify(matriz))

    window.location.href='../analise_geral/modal.html';
  })

}


// DROPZONE ( CUIDADO! )
document.querySelectorAll(".drop-zone-input").forEach((inputElement) => {
  const dropZoneElement = inputElement.closest(".drop-zone");

  dropZoneElement.addEventListener("click", (e) => {
    inputElement.click();
  });

  inputElement.addEventListener("change", (e) => {
    if (inputElement.files.length) {
      updateThumbnail(dropZoneElement, inputElement.files[0]);
    }

    localStorage.setItem('table',e.target.value.replace('C:\\fakepath\\',''))
  });

  dropZoneElement.addEventListener("dragover", (e) => {
    e.preventDefault();
    dropZoneElement.classList.add("drop-zone--over");
  });

  ["dragleave", "dragend"].forEach((type) => {
    dropZoneElement.addEventListener(type, (e) => {
      dropZoneElement.classList.remove("drop-zone--over");
    });
  });

  dropZoneElement.addEventListener("drop", (e) => {
    e.preventDefault();

    if (e.dataTransfer.files.length) {
      inputElement.files = e.dataTransfer.files;
      updateThumbnail(dropZoneElement, e.dataTransfer.files[0]);
    }

    dropZoneElement.classList.remove("drop-zone--over");

    localStorage.setItem('table',e.target.dataset.label)
  });
});

/**
 * Updates the thumbnail on a drop zone element.
 *
 * @param {HTMLElement} dropZoneElement
 * @param {File} file
 */
function updateThumbnail(dropZoneElement, file) {
  let thumbnailElement = dropZoneElement.querySelector(".drop-zone-thumb");

  // First time - remove the prompt
  if (dropZoneElement.querySelector(".drop-zone-span")) {
    dropZoneElement.querySelector(".drop-zone-span").remove();
  }

  // First time - there is no thumbnail element, so lets create it
  if (!thumbnailElement) {
    thumbnailElement = document.createElement("div");
    thumbnailElement.classList.add("drop-zone-thumb");
    dropZoneElement.appendChild(thumbnailElement);
  }

  thumbnailElement.dataset.label = file.name;

  // Show thumbnail for image files
  if (file.type.startsWith("image/")) {
    const reader = new FileReader();

    reader.readAsDataURL(file);
    reader.onload = () => {
      thumbnailElement.style.backgroundImage = `url('${reader.result}')`;
    };
  } else {
    thumbnailElement.style.backgroundImage = null;
  }
}

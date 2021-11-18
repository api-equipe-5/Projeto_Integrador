import React, { useContext, useState, useEffect } from 'react';
import Dropzone from 'react-dropzone';
import shapeStep1 from '../../assets/img/shape-post-home.png';

import '../Upload-Shape/styles';


import api from '../../services/api';

function  UploadShape() {
  const [file, setFile] = useState();

      const carregar = (()  => {
      const formData = new FormData();
      if (file) formData.append("file", file);
      
          const response = api.post("/upload", formData, {
              headers: {
                  "Content-Type": `multipart/form-data;`,
                  "Access-Control-Allow-Origin": `*`
              }
          })
          .then(response =>  {
            console.log("show files: " + response.data);
            alert("Arquivo carregado com sucesso\nVá para a próxima etapa.");
          }
        )
        .catch(err => {
          console.log('deu ruim bb', err);
        });
      })
    
    return (
      <div>
        <img src={shapeStep1} alt="Shape-Button" width="100%"/>        
          <input type="file" name="file"
          style={{fontSize: 2 + 'rem'}}
          encType="multipart/form-data" multiple onChange={event => setFile(event.target.files[0])} />   
            <button type="button" onClick={carregar} encType="multipart/form-data" style={{fontSize: 2 + 'rem'}}>
            CARREGAR ARQUIVOS .SHP
        </button>
    </div>
    );
  }

export default UploadShape;
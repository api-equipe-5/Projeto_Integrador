import React, { useState } from 'react';

import { Upload, message } from 'antd';
import api from '../../../../services/api';

import ModalConnection from '../ModalConnection';

import { UploadIcon, SearchIcon, Container } from './styles';

const Acess = ({ setFields, setTables, changeScreen, searchTables }) => {
  const isConnected = JSON.parse(sessionStorage.getItem('isConnected'));

  const [fileName, setFileName] = useState('');
  const [openConnection, setOpenConnection] = useState(isConnected);
  
  const { Dragger } = Upload;

  const props = {
    name: 'shapefiles',
    multiple: true,
    action: 'http://localhost:5000/uploads',

    onChange(info) {
      const { status } = info.file;
      if (status !== 'uploading') {
        console.log(info.file, info.fileList);
      }

      localStorage.removeItem('filename');


      if (status === 'done') {

        localStorage.setItem('filename', info.file.name?.split('.')[0]);
        setFileName(info.file.name?.split('.')[0]);
        message.success(`${info.file.name} file uploaded successfully.`);
        
      } else if (status === 'error') {
        message.error(`${info.file.name} file upload failed.`);
      }
    },
  };

  async function handleUpload() {
    try {
      const response = await api.post('/getFieldsAndTables', {
        filename: fileName,
        token: localStorage.getItem('token'),
      });

      setFields(response?.data?.fields);
      setTables(response?.data?.tables);
      changeScreen('upload');
    } catch (error) {
      console.log(error);
    }

    /* CODIGO PARA DEBUG */

    if (localStorage.getItem('MODE') === 'debug') changeScreen('upload');

    /* CODIGO PARA DEBUG */
  }

  return (
    <Container>
      <ModalConnection
        open={openConnection}
        close={setOpenConnection}
        searchTables={searchTables}
      />

      <div className="upload-search-container">

        <div className="upload-container">
          <Dragger className="dragger-props-custom" {...props}>
            <div className="upload-dash">
              <UploadIcon className="upload-icon" />

              <span className="upload-desc">Clique ou arraste seus arquivos aqui</span>
            </div>
          </Dragger>

          <button type="button" onClick={handleUpload} className="handle-button">Upload</button>
        </div>

        <div className="upload-container">
          <button type="button" onClick={() => changeScreen('download')} className="upload-dash search-dash">
            <SearchIcon className="upload-icon" />

            <span className="upload-desc search-desc">Pesquise no banco de dados</span>
          </button>

          <button
            type="button"
            onClick={() => changeScreen('download')}
            className="handle-button"
          >
            Buscar
          </button>
        </div>
      </div>
    </Container>
  );
};

export default Acess;

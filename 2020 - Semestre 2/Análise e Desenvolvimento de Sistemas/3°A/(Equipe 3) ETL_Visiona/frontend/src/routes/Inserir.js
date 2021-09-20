import React, { useState, Fragment, useEffect } from 'react';
import HeaderNoSearch from '../sections/HeaderNoSearch';
import api from '../services/api';
import Uploader from 'rsuite/lib/Uploader';
import 'rsuite/es/Uploader/styles/themes/dark.less';
import { Modal } from 'rsuite';
import 'rsuite/es/Modal/styles/themes/dark.less';
import '../styles/custom-theme.less';
import '../styles/style.css';
import { LinearProgress } from '@material-ui/core';
import { withStyles } from '@material-ui/styles';

export default function Inserir() {

  const [dbtColNames, setDbtColNames] = useState([]);
  const [shpColNames, setShpColNames] = useState([]);
  const selectedColumns = [];

  const user = localStorage.getItem('jumbo/user');
  const password = localStorage.getItem('jumbo/password');
  const host = localStorage.getItem('jumbo/host');
  const port = localStorage.getItem('jumbo/port');
  const database = localStorage.getItem('jumbo/database');
  const table = localStorage.getItem('jumbo/table')
  const shpFileName = localStorage.getItem('jumbo/shpFileName')
  const shpFilePath = localStorage.getItem('jumbo/shpFilePath');

  const dados = {
    user,
    password,
    host,
    port,
    database,
    table,
    shpFileName,
    shpFilePath,
    dbtColNames,
    selectedColumns
  };

  const [open, setOpen] = React.useState(false);
  var [progressStatus, setProgressStatus] = useState('indeterminate');
  var [teste, setTeste] = useState('Carregando...');

  const ColorLinearProgress = withStyles({
    colorPrimary: {
      backgroundColor: '#00FFE0',
    },
    barColorPrimary: {
      backgroundColor: '#373A52',
    },
  })(LinearProgress);

  const handleOpen = () => {
    setOpen(true);
  };

  async function requestInsert() {

    selectedColumns.length = 0;

    dbtColNames.forEach(dbtColName => {
      const shpColNames = document.querySelector(`#${dbtColName}`);
      selectedColumns.push(shpColNames.value)
    });

    try {
      await api.post('/insert_shp_to_dbt', dados).then(response => {
        setTeste(response.data.result)
      });;
      setProgressStatus("buffer")
    } catch (a) {
      setProgressStatus("buffer")
      setTeste("Falha ao inserir os dados");
    }

  };

  useEffect(() => {
    api.post('get_dbt_col_names', dados).then(response => {
      setDbtColNames(response.data.dbtColNames)
    });
  }, []);

  const instanceUploader = {
    name: 'shpFile',
    multiple: true,
    action: "http://localhost:8080/jumbo/upload_shp",
    onSuccess(response) {
      localStorage.setItem('jumbo/shpFileName', response.shpFileName);
      localStorage.setItem('jumbo/shpFilePath', response.shpFilePath);
      api.post('get_shp_col_names', { 'shpFilePath': response.shpFilePath }).then(response => {
        setShpColNames(response.data.shpColNames);
      })
    }
  };

  return (
    <div className='container-insert'>
      <Fragment>
        <HeaderNoSearch />
      </Fragment>
      <Modal backdrop={false} show={open} onHide={() => setOpen(false)}><Modal.Header>
      </Modal.Header>
        <Modal.Body>
          <div><ColorLinearProgress variant={progressStatus} value={0} /></div>
          <div className="text-modal" align='center'>{teste}</div>
        </Modal.Body>
      </Modal>
      <div className="container-insert-content">
        <>
          <header>
            <p>TABELA SELECIONADA: {table}</p>
          </header>
          <section id="sectionBackground">
            <nav>
              <Uploader {...instanceUploader} />
            </nav>
            <article>
              <hr></hr>
              <div className="titleFields">
                <p><span>Campos da Tabela:</span><span>Selecione o Campo:</span></p>
              </div>
              <hr></hr>
              {dbtColNames.map(dbtColName => (
                <section key={dbtColName} className="selectionFields">
                  <span>
                    <span>{dbtColName}</span>
                    <div>
                      <div className="select-wrapper">
                        <select id={dbtColName}>
                          <>
                            <option></option>
                            {shpColNames.map(shpColName => <option key={shpColName} value={shpColName}> {shpColName} </option>)}
                          </>
                        </select>
                      </div>
                    </div>
                  </span>
                  <hr></hr>
                </section>
              ))}
            </article>
          </section>
          <footer>
            <button className="btnInserir" onClick={function (event) { handleOpen(); requestInsert() }}>Inserir</button>
          </footer>
        </>
      </div>
      <div>
      </div>
    </div>

  );

}



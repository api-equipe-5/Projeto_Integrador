import React, { useState, Fragment, useEffect } from 'react';
import HeaderNoSearch from '../sections/HeaderNoSearch';
import api from '../services/api';
import Toggle from 'rsuite/lib/Toggle';
import 'rsuite/es/Toggle/styles/themes/dark.less';
import { Modal } from 'rsuite';
import 'rsuite/es/Modal/styles/themes/dark.less';
import '../styles/custom-theme.less';
import '../styles/style.css';
import { LinearProgress } from '@material-ui/core';
import { withStyles } from '@material-ui/styles';

export default function Extrair() {

  const [dbtColNames, setDbtColNames] = useState([]);
  const choicedColumns = [];

  const user = localStorage.getItem('jumbo/user');
  const password = localStorage.getItem('jumbo/password');
  const host = localStorage.getItem('jumbo/host');
  const port = localStorage.getItem('jumbo/port');
  const database = localStorage.getItem('jumbo/database');
  const table = localStorage.getItem('jumbo/table')

  const dados = {
    user,
    password,
    host,
    port,
    database,
    table,
    choicedColumns
  };

  const [open, setOpen] = React.useState(false);
  var [progressStatus, setProgressStatus] = useState('indeterminate');
  var [teste, setTeste] = useState('Extraindo...');

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

  useEffect(() => {
    api.post('get_dbt_col_names', dados).then(response => {
      setDbtColNames(response.data.dbtColNames)
    });
  }, []);


  async function requestExtract() {

    await api.post('/extract_dbt_to_shp', dados, {
      responseType: "blob"
    })
      .then(response => {
        const filename = response.headers['content-disposition']
          .split(';')
          .find(n => n.includes('filename='))
          .replace('filename=', '')
          .trim()
          ;
        const downloadUrl = window.URL.createObjectURL(new Blob([response.data]));
        const link = document.createElement('a');
        link.href = downloadUrl;
        link.setAttribute('download', filename);
        document.body.appendChild(link);
        link.click();
        link.remove();
      }
      );
    setProgressStatus("buffer")
    setTeste("Extraído com sucesso!")
  }

  async function handleColumnName(dbtColName) {
    if (choicedColumns.includes(dbtColName)) {
      for (var i = 0; i < choicedColumns.length; i++) {
        if (choicedColumns[i] === dbtColName) {
          choicedColumns.splice(i, 1)
        }
      }
    }
    else {
      choicedColumns.push(dbtColName)
    }
  }

  return (
    <div className='container-extract'>
      <Fragment>
        <HeaderNoSearch />
      </Fragment>
      <Modal backdrop={false} show={open} onHide={() => window.location.reload()}><Modal.Header>
      </Modal.Header>
        <Modal.Body>
          <div><ColorLinearProgress variant={progressStatus} value={0} /></div>
          <div className="text-modal" align='center'>{teste}</div>
        </Modal.Body>
      </Modal>
      <div className="container-extract-content">
        <>
          <header>
            <p>TABELA SELECIONADA: {table}</p>
          </header>
          <p id='extractTitle'>Selecione os campos que deseja extrair:</p>
          <section id="extractBackground">
            <article>
              <hr></hr>
              {dbtColNames.map(dbtColName => (
                <section key={dbtColName} className='extractFields'>
                  <span className="extractFields-span">
                    <span className="extractFields-cell1">{dbtColName}</span>
                    <div className="extractFields-cell2">
                      <Toggle onChange={e => handleColumnName(dbtColName)} />
                    </div>
                  </span>
                  <hr className="extractFields-hr"></hr>
                </section>
              ))}
            </article>
            <button className="btnExtrair" onClick={function (event) { handleOpen(); requestExtract() }}>Extrair</button>
            <p>{choicedColumns}</p>
          </section>
        </>
      </div>
    </div >
  )
}

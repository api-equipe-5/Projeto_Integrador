import React, { useEffect, useState} from 'react';
import { useHistory } from 'react-router-dom';


import api from '../../utils/api';
import "../../index.css";

import Fatec from '../../imagem/fatecsjc2.png';
import Visiona from '../../imagem/visiona.png';
import Github from '../../imagem/github.png';
import logo from '../../imagem/logo.png';

var tabget = ["a", "b", "c"]
function Access() {

  const history = useHistory();
  const [tables, setTables] = useState([]);
  const [tableName, setTableName] = useState('');
  const [selectedTable, setSelectedTable] = useState('');
  const [shpName, setShpName] = useState('');
  const [columnsDb, setColumnsDb] = useState([]);
  const [columnsShp, setColumnsShp] = useState([]);

  useEffect(()=> {
    api.get('/getTablesDB').then(response => {
        setTables(response?.data?.tablesDB);
    });
  }, []);

  function handleGetTableColumns(table) { 
    setTableName(table);
    api.post('/getColumnsDB', { tableName: table}).then(response => (
        setColumnsDb(response?.data?.ColumnsDB)
    ));
  }

  function handleUpload(table) {
    setShpName(table)
    api.post('/getColumns', { shapefile: table}).then(response => (
        setColumnsShp(response?.data?.columns)
    ));
  }
  
  async function handleDownload() { 
    try {
      await api.post('/import', {
        table:selectedTable,
      });

      alert('Shapefile gerado ! \nVerique sua pasta "Shapefile tratado"')
    } catch (err) {
      alert('Erro ao fazer download')
    }
    console.log(selectedTable);
  }

  function handleSend() {
    const data = [];

    alert("Enviando dados ao banco, aguarde...")

    columnsDb?.forEach((column) => {
      const field = document.querySelector(`#${column}`);
      if (field.value !== 'Escolha um campo') {
        data.push(field.value);
      }
    });

    try {
        api.post('/upload', {
            tableName,
            shp_adress: shpName,
            list_columnsDB: columnsDb,
            list_columnsSHP: data,
        }).then(response => console.log(response.data));
    } catch (error) {
        console.log(error)     
    }

    console.log(data)
  }

    async function handleRunGeometricImage() {
      try {
        await api.post('/');
      } catch (error) {
        alert('Não foi possível carregar a i')
      }
  }

  return(
    <>
      <header class="menu-principal">
            <main>            
                <div class="header-1">
                    <div class="logo">
                        <ul>
                            <li>
                            <button className='fatec'>
                                <img src={Fatec} />
                            </button>
                            </li>
                            <li>
                            <button className='visiona'>
                                <img src={Visiona}/>
                            </button>
                            </li>
                        </ul>

                    </div>
                    <div class="linkgit">
                    
                    <button className='github'>
                        <img src={Github}/>
                    </button>
                    
                    </div>
                </div>

            </main>

        </header>
        
        <div class="entrar">
            
        </div>
        <div class="entrada">
          <div class="seleçao">    
            <ul>
                <li>
                    <fieldset class="arq">
                        <legend class="central">
                            <button class="botaosb">    Download   </button>
                            <span classname="barra">/</span>
                            <button 
                            class="botaosb"         
                            onClick={() => history.push('/Upload')}
                            >
                                Upload    
                            </button>
                        </legend>
                        <form name="form">
                            <legend class="central">Selecione o tabela para o download</legend>
                            <br></br>
                            <select 
                              className="nomtab"
                              onChange={(e)=> setSelectedTable(e.target.value)}
                            >
                              <option>
                                Selecione uma tabela
                              </option>

                              {tables ? tables.map(table => (
                                <option
                                  key={table}
                                  value={table}
                                >
                                  {table}
                                </option>
                              )) :
                                <option>Nenhuma tabela selecionada</option>
                              }
                            </select>
                            <button
                              type="button"
                              onClick={handleDownload}
                            >
                              Confirmar
                            </button>
                        </form>
                    </fieldset>
                </li>
            </ul>

            <section class="render">

            </section>
        </div>
        </div>
        <div className="logono">
            <ul>
                <img src={logo}/>
            </ul>
            <ul>
                <span className="span">
                    <font className="font1">ShapeView</font> 
                    Seu shapefile rápido e fácil
                </span>
            </ul>

        </div>
    </>
  );
}

export default Access;